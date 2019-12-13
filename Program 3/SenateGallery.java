
public class SenateGallery {
	String date;
	Dequeue<Visitor> waitingLine;
	DLList<Visitor> visitorInGallery, visitorFinished;

	public SenateGallery(String date) {
		this.date = date;
		waitingLine = new Dequeue<Visitor>(Short.MAX_VALUE);
		visitorFinished = new DLList<Visitor>();
		visitorInGallery = new DLList<Visitor>();
	}

	public void initializeSenateGallery() {
		for (int reg = 0; reg < 96; reg++)
			waitingLine.addBack(new RegularVisitor(0));

		for (int vip = 0; vip < 4; vip++)
			waitingLine.addFront(new VIPVisitor(0));

		for (int z = 70; z >= 0; z--) {
			Visitor v = waitingLine.removeFront();
			v.setTimeOutOfQueue(0);
			visitorInGallery.add(v);
		}
	}

	public void runSenateGallerySimulation(int simMinutes) {
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

	public void ouputStatistics() {
		float waitTimeVIP = 0, waitTimeReg = 0;
		int numOfVIP = 0, numOfReg = 0;
		Visitor v;

		visitorFinished.reset();
		while (visitorFinished.hasNext()) {
			v = visitorFinished.next();
			if (v.getClass() == VIPVisitor.class) {
				waitTimeVIP += v.getTotalTimeInQueue();
				numOfVIP++;
			} else {
				waitTimeReg += v.getTotalTimeInQueue();
				numOfReg++;
			}
		}

		visitorInGallery.reset();
		while (visitorInGallery.hasNext()) {
			v = visitorInGallery.next();
			if (v.getClass() == VIPVisitor.class) {
				waitTimeVIP += v.getTotalTimeInQueue();
				numOfVIP++;
			} else {
				waitTimeReg += v.getTotalTimeInQueue();
				numOfReg++;
			}
		}

		System.out.printf("The date of the visit to the Senate Gallery is %s%n", date);
		System.out.printf("Total who finished viewing is %s%n", visitorFinished.size());
		System.out.printf("Total who are still in gallery is %s%n", visitorInGallery.size());
		System.out.printf("Total who are still waiting is %s%n", waitingLine.size());
		System.out.printf(
				"The average wait time for VIP Visitors who are in the gallery or finished viewing is %.2f seconds%n",
				waitTimeVIP / numOfVIP);
		System.out.printf(
				"The average wait time for Regular Visitors who are in the gallery or finished viewing is %.2f seconds%n",
				waitTimeReg / numOfReg);

	}
}
