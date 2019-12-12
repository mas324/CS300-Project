
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
		Dequeue<Visitor> waitingLine;
		
		for( int i=0; i < 96; i++){ 
		waitingLine.addBack(); 
			
		} 
		
		for( int j= 0; i< 4; j++){ 
		waitingLine.addFront(); 
			
		} 
		
		for( int z = 0; z<70 ; z--) { 
		Dequeue<Visitor> waitingLine.removeFront(); 
			visitorGallery.add(line.removeFront); 
			
		}
		
		
		} 
		
		
	}

	public void runSenateGallerySimulation(int simMinutes) {

	}

	public void ouputStatistics() {

	}

}
