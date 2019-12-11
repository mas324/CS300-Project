import java.util.Random;
public class Visitor {

	private int timeOntoQueue;
	private int timeOutOfQueue;
	private int totalTimeInQueue;
	private int timeInGallery;
	private int timeRemainingInGallery;
	private static Random randy = new Random(2);
	
	public Visitor() {
		this.setTimeOntoQueue = timeOntoQueue;
		this.setTimeInGallery = timeInGallery;
	}

	public void setTimeOntoQueue(int timeOntoQueue){
		this.setTimeOntoQueue = timeOntoQueue;
	}
	public void setTimeOutOfQueue(int timeOutOfQueue){
		this.setTimeOutOfQueue = timeOutOfQueue;
	}
	public void setTimeInGallery() {
		this.setTimeInGallery = timeInGallery;
	}
	public int decrementTimeRemainingInGallery() {
		timeRemaining--
	}
	public int getTotalTimeInQueue(){
		return totalTimeInQueue;
	}
	public int getTimeRemainingInGallery(){
		return timeRemainingInGallery;
	}

}

