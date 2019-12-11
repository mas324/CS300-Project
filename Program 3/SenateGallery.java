
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

	}

	public void runSenateGallerySimulation(int simMinutes) {

	}

	public void ouputStatistics() {

	}

}
