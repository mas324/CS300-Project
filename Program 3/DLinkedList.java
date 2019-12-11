//Problem 1

@SuppressWarnings(value = { "unchecked", "rawtypes" })
public class DLinkedList<E> implements DoubleListInterface<E> {

	private DLNode first, current, last;
	private int size;

	private void isInBounds(int index) {
		if (index >= size || index < 0) {
			System.out.printf("Error: %s", new IndexOutOfBoundsException("Index not in list"));
			System.exit(0);
		}
	}

	private DLNode nodeLookup(int index) {
		isInBounds(index);
		DLNode x;

		if (index < size / 2) {
			x = first;
			for (int i = 0; i < index; i++)
				x = x.getNext();
		} else {
			x = last;
			for (int i = size - 1; i > index; i--)
				x = x.getPrevious();
		}

		return x;
	}

	public DLinkedList() {
		clear();
	}

	@Override
	public void add(int index, E x) {
		DLNode newNode = new DLNode(x);

		if (index == 0) {
			newNode.setNext(first);
			first = newNode;
		} else {
			DLNode node = nodeLookup(index);
			newNode.setNext(node);
			newNode.setPrevious(node.getPrevious());
			node.setPrevious(newNode);
		}
		++size;
	}

	@Override
	public void add(E x) {
		DLNode node = new DLNode(x);
		if (first == null)
			first = node;
		else if (first.getNext() == null) {
			first.setNext(node);
			node.setPrevious(first);
		} else {
			last.setNext(node);
			node.setPrevious(last);
		}
		last = current = node;
		++size;
	}

	@Override
	public void clear() {
		first = current = last = null;
		size = 0;
	}

	@Override
	public boolean contains(E x) {
		DLNode front = first, back = last;
		for (int i = 0; i <= size / 2; i++) {
			if (x.equals(front.getData()) || x.equals(back.getData()))
				return true;
			front = front.getNext();
			back = back.getPrevious();
		}
		return false;
	}

	@Override
	public E get(int index) {
		isInBounds(index);
		if (index == 0)
			return (E) first.getData();
		if (index == size - 1)
			return (E) last.getData();

		return (E) nodeLookup(index).getData();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean remove(E x) {
		if (x.equals(first.getData())) {
			first = first.getNext();
			--size;
			return true;
		}

		DLNode node = first;
		while (node.getNext() != null) {
			if (x.equals(node.getData())) {
				node.getPrevious().setNext(node.getNext());
				node.getNext().setPrevious(node.getPrevious());
				node.setNext(null);
				node.setPrevious(null);
				--size;
				return true;
			}
			node = node.getNext();
		}

		return false;
	}

	@Override
	public E remove(int index) {
		isInBounds(index);

		E x = null;

		if (index == 0) {
			x = (E) first.getData();
			first = first.getNext();
			--size;
			return x;
		} else if (index == size - 1) {
			x = (E) last.getData();
			last = last.getPrevious();
			--size;
			return x;
		}

		DLNode node = nodeLookup(index);

		x = (E) node.getData();
		node.getPrevious().setNext(node.getNext());
		node.getNext().setPrevious(node.getPrevious());
		node.setNext(null);
		node.setPrevious(null);
		--size;
		return x;
	}

	@Override
	public E set(int index, E x) {
		DLNode node = nodeLookup(index);
		E data = (E) node.getData();
		node.setData(x);
		return data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public E next() {
		if (!hasNext())
			return null;
		E data = (E) current.getData();
		current = current.getNext();
		return data;
	}

	@Override
	public boolean hasPrevious() {
		return current != null;
	}

	@Override
	public E previous() {
		if (!hasPrevious())
			return null;
		E data = (E) current.getData();
		current = current.getPrevious();
		return data;
	}

	@Override
	public void reset() {
		current = first;
	}

}
