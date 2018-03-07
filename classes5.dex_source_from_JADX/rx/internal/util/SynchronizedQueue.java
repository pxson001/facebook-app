package rx.internal.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: booking_number_label */
public class SynchronizedQueue<T> implements Queue<T> {
    private final LinkedList<T> f7867a;
    private final int f7868b;

    public SynchronizedQueue() {
        this.f7867a = new LinkedList();
        this.f7868b = -1;
    }

    public SynchronizedQueue(int i) {
        this.f7867a = new LinkedList();
        this.f7868b = i;
    }

    public synchronized boolean isEmpty() {
        return this.f7867a.isEmpty();
    }

    public synchronized boolean contains(Object obj) {
        return this.f7867a.contains(obj);
    }

    public synchronized Iterator<T> iterator() {
        return this.f7867a.iterator();
    }

    public synchronized int size() {
        return this.f7867a.size();
    }

    public synchronized boolean add(T t) {
        return this.f7867a.add(t);
    }

    public synchronized boolean remove(Object obj) {
        return this.f7867a.remove(obj);
    }

    public synchronized boolean containsAll(Collection<?> collection) {
        return this.f7867a.containsAll(collection);
    }

    public synchronized boolean addAll(Collection<? extends T> collection) {
        return this.f7867a.addAll(collection);
    }

    public synchronized boolean removeAll(Collection<?> collection) {
        return this.f7867a.removeAll(collection);
    }

    public synchronized boolean retainAll(Collection<?> collection) {
        return this.f7867a.retainAll(collection);
    }

    public synchronized void clear() {
        this.f7867a.clear();
    }

    public synchronized String toString() {
        return this.f7867a.toString();
    }

    public synchronized boolean equals(Object obj) {
        return this.f7867a.equals(obj);
    }

    public synchronized int hashCode() {
        return this.f7867a.hashCode();
    }

    public synchronized T peek() {
        return this.f7867a.peek();
    }

    public synchronized T element() {
        return this.f7867a.element();
    }

    public synchronized T poll() {
        return this.f7867a.poll();
    }

    public synchronized T remove() {
        return this.f7867a.remove();
    }

    public synchronized boolean offer(T t) {
        boolean offer;
        if (this.f7868b < 0 || this.f7867a.size() + 1 <= this.f7868b) {
            offer = this.f7867a.offer(t);
        } else {
            offer = false;
        }
        return offer;
    }

    public synchronized Object clone() {
        return this.f7867a.clone();
    }

    public synchronized Object[] toArray() {
        return this.f7867a.toArray();
    }

    public synchronized <R> R[] toArray(R[] rArr) {
        return this.f7867a.toArray(rArr);
    }
}
