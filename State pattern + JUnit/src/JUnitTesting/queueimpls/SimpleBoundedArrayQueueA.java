package JUnitTesting.queueimpls;

import JUnitTesting.queue.QueueADT;

public class SimpleBoundedArrayQueueA<T> implements QueueADT<T>
{

	private T[] q;
	private int  count;
	private int cap;

	public SimpleBoundedArrayQueueA(int cap) {
		this.cap = cap;
	}
	
	@Override
	public void enqueue(T element) throws IllegalArgumentException, IllegalStateException{
		if(q == null) {
			q = (T[])(new Object[10]);
		}

		if(element == null) {
			throw new IllegalArgumentException("Null is not allowed");
		} else if(count == cap) {
			throw new IllegalStateException("Queue is full");
		}

		q[count] = element;
		count++;
	}

	@Override
	public T dequeue() throws IllegalStateException {
		if(count == 0) {
			throw new IllegalStateException("Queue is empty");
		}
		T tmp = q[0];
		for (int i = 1; i < count; i++) {
			q[i-1] = q[i];
		}

		return tmp;
	}

	@Override
	public T first() {
		if(count == 0) throw new IllegalStateException("Queue is empty");
		return q[0];
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int indexOf(T element) {
		if(element == null) {
			return -1;
		} else {
			for (int i = 0; i < count; i++) {
				if (element.equals(q[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public boolean contains(T element) {
		if(element == null) return false;
		for (T t : q) {
			if(element.equals(t)) return true;
		}
		return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i = 0; i < count; i++) {
			sb.append(q[i]);
			if(i < count -1) {
				sb.append(", ");
			}
		}
		return sb.toString() + "}";
	}
}
