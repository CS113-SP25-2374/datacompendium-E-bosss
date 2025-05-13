package CS113;

import CS113.interfaces.DequeInterface;

public class ArrayDequeES<E> implements DequeInterface<E> {

    E[] array;
    int first;
    int last;
    int count;

    public ArrayDequeES() {
        resize(10);
        first = -1;
        last = -1;
        count = 0;
    }

    private void resize(int newSize) {
        //if empty creates new array size of 10
        if (array == null) {
            array = (E[]) new Object[newSize];
            return;
        }

        //creates and new array and copies the elements
        E[] newArray = (E[]) new Object[newSize];
        for(int i = 0; i <= last; i++) {
            newArray[i] = array[i];
        }
        //take the difference
        int diff = newArray.length - array.length;

        //this ensures that the elements are in the correct spot after creating the new array
        //starts at the back and moves them forward until they are in the correct spots
        for (int i = newArray.length - 1; i >= first + diff; i--) {
            newArray[i] = array[i - diff];
        }
        //set new array to array
        array = newArray;
    }

    @Override
    public boolean offerFirst(E element) {
       if (count == array.length - 1) {
           return false;
       }
       addFirst(element);
       return true;
    }

    @Override
    public boolean offerLast(E element) {
        if (count == array.length - 1) {
            return false;
        }
        addLast(element);
        return true;
    }

    @Override
    public boolean addFirst(E element) {
        //if count is size of array, resize
        if (count == array.length) {
            resize(array.length * 2);
        }

        //if there is no elements in queue then sets position to 0
        //first is also the last
        //adds element to first and count is increased
        if (first == -1) {
            first = 0;
            last = first;
            array[first] = element;
            count++;
        }
        //if there is already an element in array
        //decrements first position by 1 to move it to the next spot
        else {
            first--;
            //because it is a circular array
            //checks if it is at the first spot and wraps around
            if (first < 0) {
                first = array.length - 1;
            }
            //adds the element and increases the count
            array[first] = element;
            count++;
        }
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (count == array.length - 1) {
            resize(array.length * 2);
        }

        if (last == -1) {
            first = last = 0;
            array[last] = element;
            count++;
        } else {
            last++;
            if (last > array.length - 1) {
                last = 0;
            }
            array[last] = element;
            count++;
        }
        return true;
    }

    @Override
    public E removeFirst() {
        E temp = array[first];
        array[first] = null;
        first++;
        return temp;
    }

    @Override
    public E removeLast() {
        E temp = array[last];
        array[last] = null;
        last--;
        return temp;
    }

    @Override
    public E peekFirst() {
       return array[first];
    }

    @Override
    public E peekLast() {
        return array[last];
    }

    @Override
    public E pollFirst() {
        return removeFirst();
    }

    @Override
    public E pollLast() {
        return removeLast();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        int size = size();
        for(int i = 0; i < size; i++) {

            sb.append(array[i]);
            if(i < size - 1) {

                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
