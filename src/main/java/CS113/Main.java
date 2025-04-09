package CS113;

public class Main {
    public static void main(String[] args) {

        HeapsES<Integer> myQueue = new HeapsES<>();
        for(int i = 10; i > 0; i--){
            myQueue.add(i);
        }
        System.out.println(myQueue);
        myQueue.poll();
        System.out.println(myQueue);

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