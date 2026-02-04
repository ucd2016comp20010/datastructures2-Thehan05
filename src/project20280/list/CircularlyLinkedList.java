package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {

    private class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T e, Node<T> n) {
            data = e;
            next = n;
        }

        public T getData() {
            return data;
        }

        public void setNext(Node<T> n) {
            next = n;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) {
        if(i < 0 || i >= size) {
            return null;
        }

        Node<E> node = tail.next;
        for(int j = 0; j < i; j++) {
            node = node.next;
        }

        return node.data;
    }

    /**
     * Inserts the given element at the specified index of the list, shifting all
     * subsequent elements in the list one position further to make room.
     *
     * @param i the index at which the new element should be stored
     * @param e the new element to be stored
     */
    @Override
    public void add(int i, E e) {
        if (i < 0 || i > size) {
            throw new IllegalArgumentException();
        }

        if (size == 0) {
            tail = new Node<>(e, null);
            tail.next = tail;
            size = 1;
            return;
        }

        if (i == 0) {
            Node<E> newNode = new Node<>(e, tail.next);
            tail.next = newNode;
        }
        else {
            Node<E> prev = tail.next; // head
            for (int j = 0; j < i - 1; j++) {
                prev = prev.next;
            }

            Node<E> newNode = new Node<>(e, prev.next);
            prev.next = newNode;

            if (i == size) { // added at end
                tail = newNode;
            }
        }

        size++;
    }

    @Override
    public E remove(int i) {
        if(i < 0 || i >= size) {
            return null;
        }

        if(i == 0) {
            return removeFirst();
        }

        if(i == size - 1) {
            return removeLast();
        }

        Node<E> prev = tail.next;
        for(int j = 0; j < i - 1; j++) {
            prev = prev.next;
        }

        Node<E> curr = prev.next;
        E removed = curr.data;

        prev.next = curr.next;
        size--;
        return removed;
    }

    public void rotate() {
        if(tail != null) {
            tail = tail.next;
        }
    }

    private class CircularlyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) tail;

        @Override
        public boolean hasNext() {
            return curr != tail;
        }

        @Override
        public E next() {
            E res = curr.data;
            curr = curr.next;
            return res;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new CircularlyLinkedListIterator<E>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E removeFirst() {
        if(size == 0) {
            return null;
        }

        Node<E> head = tail.next;
        E removed = head.data;

        if(size == 1) {
            tail = null;
        } else{
            tail.next  = head.next;
        }
        size--;
        return removed;
    }

    @Override
    public E removeLast() {
        if(size == 0) {
            return null;
        }

        E removed = tail.data;

        if(size == 1) {
            tail = null;
        } else {
            Node<E> prev = tail.next;
            while(prev.next != tail) {
                prev = prev.next;
            }

            prev.next = tail.next;
            tail = prev;
        }

        size--;
        return removed;
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = tail;
        do {
            curr = curr.next;
            sb.append(curr.data);
            if (curr != tail) {
                sb.append(", ");
            }
        } while (curr != tail);
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
        for (int i = 10; i < 20; ++i) {
            ll.addLast(i);
        }

        System.out.println(ll);

        ll.removeFirst();
        System.out.println(ll);

        ll.removeLast();
        System.out.println(ll);

        ll.rotate();
        System.out.println(ll);

        ll.removeFirst();
        ll.rotate();
        System.out.println(ll);

        ll.removeLast();
        ll.rotate();
        System.out.println(ll);

        for (Integer e : ll) {
            System.out.println("value: " + e);
        }

    }
}
