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
	}

	public void setTotalTimeInQueue() {
		totalTimeInQueue = timeOutOfQueue - timeOntoQueue;
	}

	public void setTimeInGallery() {
		int randomP = randy.nextInt(100) + 1;

		if (randomP <= 20)
			timeInGallery = 5;
		else if (randomP <= 40)
			timeInGallery = 20;
		else
			timeInGallery = 10;

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
