/*This generic interface defines the deque abstract data type
A deque is an ordered list with operations that operate at either end of a list
You can add an item, remove an item, or peek at an item either at
the front of the deque or back of the deque*/

public interface DequeInterface <E>
{
	Deque<integer> deque = new Deque<>(); 
	
	public void addFront(E item); 
	//Inserts at from of the dequeue (item 0)
	deque.addFront();  
	
	public void addBack(E item); 
	
	deque.addBack();
	//Inserts at end of the dequeue
	
	public E removeFront(); 
	deque.removeFront(); 
	
	//Remove from the front (item 0) of the deque and return the reference to the object removed
	//Return null if empty
	
	public E removeBack(); 
	deque.removeBack(); 
	
	//Remove from the back of the deque and return the reference to the object removed
	//Return null if empty
	
	public E peekFront(); 
	deque.peekFront(); 
	//Return reference to item at the front of the deque 
	//Return null if empty
	
	public E peekBack(); 
	deque.peekBack(); 
	//Return reference to item at the back of the deque 
	//Return null if empty
	
	public int size();
	deque.size(); 
	//Returns number of elements in the deque
	
	public boolean isEmpty();
	deque.isEmpty(); 
	//Returns true if the deque has no elements, otherwise false
	
	
	System.out.println(deque.addFront()); 
	System.out.println(deque.addBack()); 
	System.out.println(deque.removeFront()); 
	System.out.println(deque.removeBack()); 
	System.out.println(deque.peekFront()); 
	System.out.println(deque.peekBack()); 
	System.out.println(deque.size()); 
	System.out.println(deque.isEmpty()); 
	
	
	
}
