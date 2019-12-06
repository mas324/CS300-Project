import java.util.Random;

public class Visitor {
    @SuppressWarnings("unused")
    private int timeOntoQueue, timeOutOfQueue, totalTimeInQueue, timeInGallery, timeRemainingInGallery;
    private Random rand = new Random(2);

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
	int x = rand.nextInt(101);
	if (x <= 20)
	    timeInGallery = 5;
	else if (x <= 80)
	    timeInGallery = 10;
	else
	    timeInGallery = 20;
	
	timeInGallery = timeRemainingInGallery;
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
