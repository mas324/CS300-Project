import java.util.Random;
public class Visitor {

	private int timeOntoQueue;
	private int timeOutOfQueue;
	private int totalTimeInQueue;
	private int timeInGallery;
	private int timeRemainingInGallery;
	private static Random randy = new Random(2);
	
	public Visitor(int time) {
		setTimeOntoQueue(time);
		setTimeInGallery();
	}
	public void setTimeOntoQueue(int timeOntoQueue){
		this.timeOntoQueue = timeOntoQueue;
	}
	public void setTimeOutOfQueue(int timeOutOfQueue){
		this.timeOutOfQueue = timeOutOfQueue;
	}
	public void setTotalTimeInQueue() {
		totalTimeInQueue = timeOutOfQueue - timeOntoQueue;
	}
	public void setTimeInGallery() {
		timeInGallery = randy.nextInt();
	}
	public void decrementTimeRemainingInGallery() {
		timeRemainingInGallery--;
	}
	public int getTotalTimeInQueue(){
		return totalTimeInQueue;
	}
	public int getTimeRemainingInGallery(){
		return timeRemainingInGallery;
	}

}

