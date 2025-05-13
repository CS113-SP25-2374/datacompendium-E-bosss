package CS113;

import CS113.interfaces.IteratorInterface;

import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayQueueES<String> queue = new ArrayQueueES<>();

        //adding element to queue
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");

        System.out.println(queue);

//        retrieving the element from the queue
        System.out.println("First Element: " + queue.peek());

        //removing an element from queue, always from the front
        queue.remove();
        System.out.println("Queue (Removed First Element): " + queue);

        //iterate through the queue
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.poll());
        }





//        GraphES graph = new GraphES();
//
//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("C");
//        graph.addNode("D");
//        graph.addEdge("A", "B", false);
//        graph.addEdge("B", "C", false);
//        graph.printGraph();

//        ArrayListES<Integer> arrayToSort = new ArrayListES<>();
//        Random random = new Random();
//        for(int i = 0; i < 20; i++) {
//            arrayToSort.add(random.nextInt(100));
//        }
//        System.out.println(arrayToSort);
//
//        SortingHat<Integer> sort = new SortingHat<>();
//         arrayToSort = sort.quickSort(arrayToSort);
//        System.out.println(arrayToSort);

//        HeapsES<Integer> myQueue = new HeapsES<>();
//        for(int i = 10; i > 0; i--){
//            myQueue.add(i);
//        }
//        System.out.println(myQueue);
//        myQueue.poll();
//        System.out.println(myQueue);

//        LinkedListES<Integer> list = new LinkedListES<>();
//
//        for(int i = 0; i < 10; i++){
//            list.add(i);
//        }

//        System.out.println("Iterator Test");
//        IteratorInterface<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            System.out.print(" " + iterator.next());
//        }

//        System.out.println(list);

//        System.out.println();
//        System.out.println(list.contains(1));

//        Integer temp = 6;
//        list.remove(temp);
//        System.out.println(list);




    }
}