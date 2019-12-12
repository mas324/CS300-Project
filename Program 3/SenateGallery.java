
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

		for (int z = 0; z < 70; z--) {
			Visitor v = waitingLine.removeFront();
			v.setTimeOutOfQueue(0);
			visitorInGallery.add(v);
		}
	}

	public void runSenateGallerySimulation(int simMinutes) {

	}

	public void ouputStatistics() {

	}
}
