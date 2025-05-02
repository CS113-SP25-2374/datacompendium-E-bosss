package CS113;

import CS113.interfaces.HeapInterface;

public class HeapsES <T extends Comparable<T>> implements HeapInterface<T> {

    ArrayListES<T> array = new ArrayListES<>();

    public HeapsES() {}

    void heapifyUp(T element, int index) {
        //while index is not 0 check parent and keep swapping if it less than
        while(index > 0) {
            int parent = (index - 1) / 2;
            if(element.compareTo(array.get(parent)) < 0) {
                T temp = array.get(parent);
                array.set(parent, array.get(index));
                array.set(index, temp);
                index = parent;
            }

            //code for how to recursively do it
            /*
            if(index <=0) return;

            int parentIndex = (index - 1) / 2;
            T parent = array.get(parentIndex);

            if(element.compareTo(array.get(parent) < 0) {
                array.set(parentIndex, element);
                array.set(index, parent);
                heapifyUp(element, parentIndex);
            }


             */
        }
    }

    void heapifyDown(T element, int index) {

        int child1Index = (index * 2) + 1;
        int child2Index = (index * 2) + 2;
        int smallest = index;

        if (child1Index <  array.size()) {
            smallest = child1Index;
        }
        else if(child2Index <  array.size()) {
            smallest = child2Index;
        }

        T smallestValue = array.get(smallest);
        if(element.compareTo(smallestValue) > 0) {
            array.set(index, smallestValue);
            array.set(smallest, element);
            heapifyDown(element, smallest);
        }

    }


    @Override
    public boolean add(T element) {
       array.add(element);
       heapifyUp(element, array.size() - 1);
       return true;
    }

    @Override
    public T peek() {
        return array.get(0);
    }

    @Override
    public T poll() {
        T first = array.get(0);
        T last = array.get(array.size() - 1);
        array.set(0, last);
        array.remove(array.size() - 1);
        heapifyDown(last, 0);
        return first;
    }

    public String toString() {
        return array.toString();
    }
}
