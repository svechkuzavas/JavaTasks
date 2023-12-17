package task4;

import java.util.Iterator;

public class Task4 {

    private final static MyLinkedList<String> list = new MyLinkedList<>();

    public static void main(String[] args) {
        list.add("1");
        list.add("2");
        list.add("4");
        list.add("3", 2);
        list.printList();
        System.out.println(list.get(2).data);
        list.add("5", 3);
        list.printList();
        list.remove(3);
        list.printList();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() +  ", ");
        }
    }
}
