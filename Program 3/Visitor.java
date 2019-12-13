import java.util.Random;

public class Visitor {

	private int timeOntoQueue, timeOutOfQueue, totalTimeInQueue, timeInGallery, timeRemainingInGallery;
	private static Random randy = new Random(2);

	public Visitor(int time) {
		setTimeOntoQueue(time);
		setTimeInGallery();
	}

	public void setTimeOntoQueue(int timeOntoQueue) {
		this.timeOntoQueue = timeOntoQueue;
	}

	public void setTimeOutOfQueue(int timeOutOfQueue) {
		this.timeOutOfQueue = timeOutOfQueue;
		totalTimeInQueue = this.timeOutOfQueue - timeOntoQueue;
	}

	public void setTimeInGallery() {
		int visitTime = randy.nextInt(101);

		if (visitTime <= 20)
			timeInGallery = 5;
		else if (visitTime <= 80)
			timeInGallery = 10;
		else
			timeInGallery = 20;

		timeRemainingInGallery = timeInGallery;
	}

	public void decrementTimeRemainingInGallery() {
		timeRemainingInGallery--;
	}

	public int getTotalTimeInQueue() {
		return totalTimeInQueue;
	}

	public int getTimeRemainingInGallery() {
		return timeRemainingInGallery;
	}

}
