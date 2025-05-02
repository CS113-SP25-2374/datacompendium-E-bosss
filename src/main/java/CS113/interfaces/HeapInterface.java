package CS113.interfaces;

public interface HeapInterface <T extends Comparable<T>> {
    /**
     * Adds an element to the queue
     * @param element
     * @return true if it adds
     */
    boolean add(T element);

    /**
     * Retrieves but does not remove th
     * e head
     * @return an element
     */
    T peek();

    /**
     * Retrieves and returns the head of the queue
     * @return an element
     */
    T poll();
}