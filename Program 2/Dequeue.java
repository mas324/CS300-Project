
@SuppressWarnings(value = { "unchecked" })
public class Dequeue<E> implements DequeInterface<E> {

    private int size, front, back, max;
    private E[] list;

    public Dequeue() {
        list = (E[]) new Object[10];
        front = 0;
        back = 9;
    }

    public Dequeue(int size) {
        list = (E[]) new Object[max = size];
        front = 0;
        back = size - 1;
    }

    @Override
    public void addFront(E item) {
        if (size == max)
            return;
        size++;
        list[front++] = item;
    }

    @Override
    public void addBack(E item) {
        if (size == max)
            return;
        size++;
        list[back--] = item;
    }

    @Override
    public E removeFront() {
        if (size == 0)
            return null;
        size--;
        return list[front--];
    }

    @Override
    public E removeBack() {
        if (size == 0)
            return null;
        size--;
        return list[back++];
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
