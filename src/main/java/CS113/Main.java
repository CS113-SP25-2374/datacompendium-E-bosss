package CS113;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayListES<Integer> list = new ArrayListES<>();

        for(int i = 0; i < 10; i++){
            list.add(i);
        }

        System.out.println(list);
    }
}