package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;
import java.util.List;

/* compiled from: can_viewer_edit_tag */
public final class ObjectBuffer {
    private Node f6246a;
    private Node f6247b;
    private int f6248c;
    private Object[] f6249d;

    /* compiled from: can_viewer_edit_tag */
    public final class Node {
        public final Object[] f6244a;
        public Node f6245b;

        public Node(Object[] objArr) {
            this.f6244a = objArr;
        }

        public final Object[] m11795a() {
            return this.f6244a;
        }

        public final Node m11796b() {
            return this.f6245b;
        }

        public final void m11794a(Node node) {
            if (this.f6245b != null) {
                throw new IllegalStateException();
            }
            this.f6245b = node;
        }
    }

    public final Object[] m11800a() {
        m11798c();
        if (this.f6249d == null) {
            return new Object[12];
        }
        return this.f6249d;
    }

    public final Object[] m11801a(Object[] objArr) {
        Node node = new Node(objArr);
        if (this.f6246a == null) {
            this.f6247b = node;
            this.f6246a = node;
        } else {
            this.f6247b.m11794a(node);
            this.f6247b = node;
        }
        int length = objArr.length;
        this.f6248c += length;
        if (length < 16384) {
            length += length;
        } else {
            length += length >> 2;
        }
        return new Object[length];
    }

    public final Object[] m11802a(Object[] objArr, int i) {
        int i2 = this.f6248c + i;
        Object obj = new Object[i2];
        m11797a(obj, i2, objArr, i);
        return obj;
    }

    public final <T> T[] m11803a(Object[] objArr, int i, Class<T> cls) {
        int i2 = i + this.f6248c;
        Object[] objArr2 = (Object[]) Array.newInstance(cls, i2);
        m11797a(objArr2, i2, objArr, i);
        m11798c();
        return objArr2;
    }

    public final void m11799a(Object[] objArr, int i, List<Object> list) {
        int i2 = 0;
        for (Node node = this.f6246a; node != null; node = node.f6245b) {
            for (Object add : node.f6244a) {
                list.add(add);
            }
        }
        while (i2 < i) {
            list.add(objArr[i2]);
            i2++;
        }
    }

    public final int m11804b() {
        return this.f6249d == null ? 0 : this.f6249d.length;
    }

    private void m11798c() {
        if (this.f6247b != null) {
            this.f6249d = this.f6247b.f6244a;
        }
        this.f6247b = null;
        this.f6246a = null;
        this.f6248c = 0;
    }

    private void m11797a(Object obj, int i, Object[] objArr, int i2) {
        int i3 = 0;
        for (Node node = this.f6246a; node != null; node = node.f6245b) {
            Object obj2 = node.f6244a;
            int length = obj2.length;
            System.arraycopy(obj2, 0, obj, i3, length);
            i3 += length;
        }
        System.arraycopy(objArr, 0, obj, i3, i2);
        int i4 = i3 + i2;
        if (i4 != i) {
            throw new IllegalStateException("Should have gotten " + i + " entries, got " + i4);
        }
    }
}
