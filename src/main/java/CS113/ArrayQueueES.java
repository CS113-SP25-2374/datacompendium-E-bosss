package CS113;

import CS113.interfaces.QueueInterface;


public class ArrayQueueES<E> extends ArrayDequeES<E> implements QueueInterface<E> {
    @Override
    public boolean add(E element) {
        return this.addLast(element);
    }

    @Override
    public E element() {
        return this.removeFirst();
    }

    @Override
    public boolean offer(E element) {
        return this.offerFirst(element);
    }

    @Override
    public E peek() {
        return this.peekFirst();
    }

    @Override
    public E poll() {
        return this.pollFirst();
    }

    @Override
    public E remove() {
        return this.removeFirst();
    }
}
