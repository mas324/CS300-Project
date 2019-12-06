
public class SenateGallery {
    private Dequeue<Visitor> waitingLine;
    private DLinkedList<Visitor> visitorInGallery, visitorFinished;
    private String date;
    
    public SenateGallery() {
	date = "";
    }
    
    public SenateGallery(String date) {
	this.date = date;
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
    
    private void runSenateGallerySmimulation(int simMinutes) {
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
	    
	    
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	outputStatistics();
    }
    
    private void outputStatistics() {
	StringBuilder build = new StringBuilder(date);
	build.append(String.format("\n%s\n", visitorFinished.size()));
	build.append(String.format("%s\n", visitorInGallery.size()));
	build.append(String.format("%s", waitingLine.size()));
    }

}
