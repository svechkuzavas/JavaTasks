package task4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;

    public void add(E t) {
        final Node<E> tailEmp = tail;
        final Node<E> newNode = new Node<>(t);
        tail = newNode;
        if (tailEmp == null)
            head = newNode;
        else
            tailEmp.next = newNode;
    }

    public void add(E t, int index) {
        final Node<E> beforeIndex = nodeAt(index-1);
        final Node<E> newNode = new Node<>(t);
        final Node<E> atIndex = nodeAt(index);
        beforeIndex.next = newNode;
        newNode.next = atIndex;
    }

    public Node<E> get(int index) {
        return nodeAt(index);
    }

    public void remove(int index) {
        final Node<E> beforeIndex = nodeAt(index-1);
        beforeIndex.next = nodeAt(index+1);
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> pointer = head;

            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public E next() {
                E result = pointer.data;
                pointer = pointer.next;
                return result;
            }
        };
    }

    boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    boolean copy(Collection<? extends E> c) {
        head = null;
        for (E e: c) {
            add(e);
        }
        return true;
    }

    public void printList() {
        Node<E> ptr = head;
        List<String> results = new ArrayList<>();
        while (ptr != null) {
            results.add(ptr.data.toString());
            ptr = ptr.next;
        }
        System.out.println(String.join("->", results));
    }

    private Node<E> nodeAt(int index) {
        Node<E> ptr = head;
        for (int i = 0; i < index; i++)
            ptr = ptr.next;
        return ptr;
    }

    /* Linked list Node*/
    static class Node<N> {
        N data;
        Node<N> next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(N d) { data = d; }
    }
}
