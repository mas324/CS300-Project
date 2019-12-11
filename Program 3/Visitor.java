import java.util.Random;
public class Visitor {

	private int timeOntoQueue;
	private int timeOutOfQueue;
	private int totalTimeInQueue;
	private int timeInGallery;
	private int timeRemainingInGallery;
	private static Random randy = new Random(2);
	private int randomP;
	
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
		randomP = randy.nextInt(100);
		
		if(randomP <= 20) {
			timeInGallery = 5;
		if(randomP <= 40) {
			timeInGallery = 20;
		else {
			timeInGallery = 10;
		}
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

