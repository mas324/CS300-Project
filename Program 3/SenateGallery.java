
public class SenateGallery {
	private Dequeue<Visitor> waitingLine;
	private DLinkedList<Visitor> visitorInGallery, visitorFinished;
	private String date;

	public SenateGallery() {
		date = "";
		waitingLine = new Dequeue<Visitor>(Short.MAX_VALUE);
		visitorFinished = new DLinkedList<Visitor>();
		visitorInGallery = new DLinkedList<Visitor>();
	}

	public SenateGallery(String date) {
		this.date = date;
		waitingLine = new Dequeue<Visitor>(Short.MAX_VALUE);
		visitorFinished = new DLinkedList<Visitor>();
		visitorInGallery = new DLinkedList<Visitor>();
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void initializeSenateGallery() {
		for (int i = 0; i < 96; i++)
			waitingLine.addBack(new RegularVisitor(0));
		for (int i = 0; i < 4; i++)
			waitingLine.addFront(new VIPVisitor(0));

		for (int i = 70; i > 0; i--) {
			Visitor v = waitingLine.removeFront();
			v.setTimeOutOfQueue(0);
			visitorInGallery.add(v);
		}
	}

	public void runSenateGallerySmimulation(int simMinutes) {
		for (int currentMinute = 0; currentMinute < simMinutes; currentMinute++) {

			for (int x = 0; x < 3; x++)
				waitingLine.addBack(new RegularVisitor(currentMinute));

			if (currentMinute % 5 == 0)
				waitingLine.addFront(new VIPVisitor(currentMinute));

			for (int visitor = 0; visitor < visitorInGallery.size(); visitor++) {
				if (visitorInGallery.get(visitor).getTimeRemainingInGallery() == 0)
					visitorFinished.add(visitorInGallery.remove(visitor));
				else
					visitorInGallery.get(visitor).decrementTimeRemainingInGallery();
			}

			if (visitorInGallery.size() <= 55) {
				int available = 90 - visitorInGallery.size();
				for (int i = 0; i < available && i <= 35 && !waitingLine.isEmpty(); i++) {
					Visitor v = waitingLine.removeFront();
					v.setTimeOutOfQueue(currentMinute);
					visitorInGallery.add(v);
				}
			}
		}
	}

	public void outputStatistics() {
		System.out.printf("The date of the visit to the Senate Gallery is %s%n", date);
		System.out.printf("Total who finished viewing is %s%n", visitorFinished.size());
		System.out.printf("Total who are still in gallery is %s%n", visitorInGallery.size());
		System.out.printf("Total who are still waiting is %s%n", waitingLine.size());

		double waitVIP = 0, waitREG = 0;
		int countVIP = 0, countREG = 0;

		for (int i = 0; i < visitorFinished.size(); i++) {
			Visitor v = visitorFinished.get(i);
			if (v.getClass().equals(VIPVisitor.class)) {
				countVIP++;
				waitVIP += v.getTotalTimeInQueue();
			} else {
				countREG++;
				waitREG += v.getTotalTimeInQueue();
			}
		}

		System.out.printf(
				"The average wait time for VIP Visitors who are in the gallery or finished viewing is %.2f seconds%n",
				waitVIP / countVIP);
		System.out.printf(
				"The average wait time for Regular Visitors who are in the gallery or finished viewing is %.2f seconds%n",
				waitREG / countREG);
	}

}
