package project20280.stacksqueues;

import project20280.interfaces.Deque;

public class ArrayDeque<E> implements Deque<E> {

    private static final int CAPACITY = 1000;
    private final E[] data;
    private int front = 0;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayDeque(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public ArrayDeque() {
        this(CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        return isEmpty() ? null : data[front];
    }

    @Override
    public E last() {
        if (isEmpty()) return null;
        int lastIdx = (front + size - 1) % data.length;
        return data[lastIdx];
    }

    @Override
    public void addFirst(E e) {
        if (size == data.length) {
            throw new IllegalStateException("Deque is full");
        }
        front = (front - 1 + data.length) % data.length;
        data[front] = e;
        size++;
    }

    @Override
    public void addLast(E e) {
        if (size == data.length) {
            throw new IllegalStateException("Deque is full");
        }
        int rear = (front + size) % data.length;
        data[rear] = e;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        E removed = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return removed;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        int lastIdx = (front + size - 1) % data.length;
        E removed = data[lastIdx];
        data[lastIdx] = null;
        size--;
        return removed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i != size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        d.addLast(1);
        d.addLast(2);
        d.addFirst(0);
        d.addFirst(-1);
        System.out.println(d);
        System.out.println(d.first());
        System.out.println(d.last());
        d.removeFirst();
        d.removeLast();
        System.out.println(d);
    }
}