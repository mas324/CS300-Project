
@SuppressWarnings(value = { "unchecked" })
public class Dequeue<E> implements DequeInterface<E> {

    private int length, front, back, max;
    private E[] list;

    public Dequeue() {
	list = (E[]) new Object[10];
	front = back = 0;
    }

    public Dequeue(int size) {
	list = (E[]) new Object[max = size];
	front = back = 0;
    }

    @Override
    public void addFront(E item) {
	if (length == max) {
	    System.out.printf("%s. Exiting", new IllegalStateException("Dequeue overflow"));
	    System.exit(1);
	}

	list[front = (front - 1 < 0) ? max - 1 : front - 1] = item;
	length++;
    }

    @Override
    public void addBack(E item) {
	if (length == max) {
	    System.out.printf("%s. Exiting", new IllegalStateException("Dequeue overflow"));
	    System.exit(1);
	}

	list[back] = item;
	back = (back + 1 >= max) ? 0 : back + 1;
	length++;
    }

    @Override
    public E removeFront() {
	if (length == 0)
	    return null;
	length--;
	E e = list[front];
	list[front] = null;
	front = (front + 1 >= max) ? 0 : front + 1;
	return e;
    }

    @Override
    public E removeBack() {
	if (length == 0)
	    return null;
	length--;
	E e = list[back];
	list[back] = null;
	back = (back - 1 < 0) ? max - 1 : back - 1;
	return e;
    }

    @Override
    public E peekFront() {
	return list[front];
    }

    @Override
    public E peekBack() {
	return list[back];
    }

    @Override
    public int size() {
	return length;
    }

    @Override
    public boolean isEmpty() {
	return length == 0;
    }

}
