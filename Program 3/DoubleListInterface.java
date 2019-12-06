//Problem 1

public interface DoubleListInterface<E> extends ListInterface<E>{
    boolean hasPrevious();
    E previous();
    void reset();
}
