package CS113;

import CS113.interfaces.StackInterface;

public class ArrayStackES<E> extends ArrayDequeES<E> implements StackInterface<E> {

    @Override
    public boolean empty() {
        return this.isEmpty();
    }

    @Override
    public E peek() {
        return this.peekLast();
    }

    @Override
    public E pop() {
        return this.removeLast();
    }

    @Override
    public boolean push(E element) {
        return this.addLast(element);
    }

    @Override
    public int search(Object o) {
        return 0;
    }
}
