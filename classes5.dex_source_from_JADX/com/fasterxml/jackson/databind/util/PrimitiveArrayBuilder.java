package com.fasterxml.jackson.databind.util;

/* compiled from: can_viewer_join */
public abstract class PrimitiveArrayBuilder<T> {
    protected T f6229a;
    protected Node<T> f6230b;
    protected Node<T> f6231c;
    protected int f6232d;

    /* compiled from: can_viewer_join */
    public final class Node<T> {
        public final T f6250a;
        final int f6251b;
        public Node<T> f6252c;

        public Node(T t, int i) {
            this.f6250a = t;
            this.f6251b = i;
        }

        public final T m11806a() {
            return this.f6250a;
        }

        public final int m11805a(T t, int i) {
            System.arraycopy(this.f6250a, 0, t, i, this.f6251b);
            return this.f6251b + i;
        }

        public final Node<T> m11808b() {
            return this.f6252c;
        }

        public final void m11807a(Node<T> node) {
            if (this.f6252c != null) {
                throw new IllegalStateException();
            }
            this.f6252c = node;
        }
    }

    protected abstract T mo727a(int i);

    protected PrimitiveArrayBuilder() {
    }

    public final T m11760a() {
        m11759b();
        return this.f6229a == null ? mo727a(12) : this.f6229a;
    }

    public final T m11762a(T t, int i) {
        int i2;
        Node node = new Node(t, i);
        if (this.f6230b == null) {
            this.f6231c = node;
            this.f6230b = node;
        } else {
            this.f6231c.m11807a(node);
            this.f6231c = node;
        }
        this.f6232d += i;
        if (i < 16384) {
            i2 = i + i;
        } else {
            i2 = (i >> 2) + i;
        }
        return mo727a(i2);
    }

    public final T m11763b(T t, int i) {
        int i2 = i + this.f6232d;
        T a = mo727a(i2);
        int i3 = 0;
        for (Node node = this.f6230b; node != null; node = node.f6252c) {
            i3 = node.m11805a(a, i3);
        }
        System.arraycopy(t, 0, a, i3, i);
        int i4 = i3 + i;
        if (i4 == i2) {
            return a;
        }
        throw new IllegalStateException("Should have gotten " + i2 + " entries, got " + i4);
    }

    private void m11759b() {
        if (this.f6231c != null) {
            this.f6229a = this.f6231c.f6250a;
        }
        this.f6231c = null;
        this.f6230b = null;
        this.f6232d = 0;
    }
}
