package CS113;

public class SortingHat <T extends Comparable<T>> {

    void swap(ArrayListES<T> array, int i, int j) {
        T temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }


    //bubble sort, iterates through the array swapping variables one place at a time
    //every run through the largest value should be at the end of the array
     void bubbleSort(ArrayListES<T> unsortedList) {
        for(int i = 0; i < unsortedList.size(); i++) {
            boolean swapped = false;

            for (int j = 0; j < unsortedList.size() - 1; j++) {
                int k = j + 1;
                if (unsortedList.get(j).compareTo(unsortedList.get(j + 1)) > 0) {
                    T temp = unsortedList.get(j);
                    unsortedList.set(j, unsortedList.get(k));
                    unsortedList.set(k, temp);
                    swapped = true;
                }
            }
            if (!swapped) return;
        }
    }

    //insertion list looks at the index value to the right of the one being compared
    //checks if it is smaller and if it is then will swap the positions
    void insertionSort(ArrayListES<T> unsortedArray) {
         for(int i = 1; i < unsortedArray.size(); i++) {
             T temp = unsortedArray.get(i);
             int j = i;

             while (j > 0 && temp.compareTo(unsortedArray.get(j - 1)) < 0) {
                 unsortedArray.set(j, unsortedArray.get(j - 1));
                 j--;
             }
             unsortedArray.set(j, temp);
         }
    }

    //split the array into 2 separate arrays order them, keeps splitting until 1 element
    //then bring them back together and sort them
    ArrayListES<T> mergeSort(ArrayListES<T> arr) {
        if(arr.size() == 1) {
            return arr;
        }

        int mid = arr.size() / 2;
        ArrayListES<T> left = new ArrayListES<>();
        ArrayListES<T> right = new ArrayListES<>();

       for(int i = 0; i < arr.size(); i++) {
           if(i < mid) {
               left.add(arr.get(i));
           } else {
               right.add(arr.get(i));
           }
       }

       return merge(mergeSort(left), mergeSort(right));
    }

    //method combines to arrays together and sorts them in order from least to greater
    ArrayListES<T> merge(ArrayListES<T> left, ArrayListES<T> right) {
        int l = 0, r = 0;
        ArrayListES<T> merged = new ArrayListES<>();

        while(l < left.size() || r < right.size()) {
           if(l == left.size()) {
               merged.add(right.get(r++));
           } else if(r == right.size()) {
               merged.add(left.get(l++));
           } else if(left.get(l).compareTo(right.get(r)) < 0) {
               merged.add(left.get(l++));
           } else {
               merged.add(right.get(r++));
           }
        }

        return merged;
    }

    //TODO make selection sort

    //takes the last element and compares it to the rest of the values in the array
    // if less goes to the left, greater goes to the right
    //call recursively until sorted
    ArrayListES<T> quickSort(ArrayListES<T> arr) {

        if (arr.size() <= 1) {
            return arr;
        }

        T pivot = arr.get(arr.size() - 1);

        ArrayListES<T> left = new ArrayListES<>();
        ArrayListES<T> right = new ArrayListES<>();

        for (int i = 0; i < arr.size() - 1; i++) {
            T current = arr.get(i);
            if (pivot.compareTo(current) > 0) {
                left.add(current);
            } else {
                right.add(current);
            }
        }

        return mergePivot(quickSort(left), pivot, quickSort(right));
    }

    ArrayListES<T> mergePivot(ArrayListES<T> left, T pivot,  ArrayListES<T> right) {
        ArrayListES<T> merged = new ArrayListES<>();

        for(int i = 0; i < left.size(); i++) {
            merged.add(left.get(i));
        }
        merged.add(pivot);
        for(int j = 0; j < right.size(); j++) {
            merged.add(right.get(j));
        }

        return merged;
    }
}
