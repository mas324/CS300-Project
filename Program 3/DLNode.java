//Problem 1

@SuppressWarnings(value = { "rawtypes" })
public class DLNode<E> {
    private E data;
    private DLNode next, previous;

    public DLNode() {

    }

    public DLNode(E x) {
        data = x;
        previous = next = null;
    }

    public void setNext(DLNode next) {
        this.next = next;
    }

    public DLNode getNext() {
        return next;
    }

    public void setPrevious(DLNode previous) {
        this.previous = previous;
    }

    public DLNode getPrevious() {
        return previous;
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }
}