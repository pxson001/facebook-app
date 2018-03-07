package com.facebook.catalyst.shadow.flat;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* compiled from: mByline */
public final class ElementsList<E> {
    public final ArrayList<Scope> f5659a = new ArrayList();
    public final ArrayDeque<E> f5660b = new ArrayDeque();
    public final E[] f5661c;
    public Scope f5662d = null;
    public int f5663e = 0;

    /* compiled from: mByline */
    public final class Scope {
        Object[] f5656a;
        int f5657b;
        int f5658c;
    }

    public ElementsList(E[] eArr) {
        this.f5661c = eArr;
        this.f5659a.add(this.f5662d);
    }

    public final E[] m6971a() {
        E[] eArr;
        Scope scope = this.f5662d;
        this.f5663e--;
        this.f5662d = (Scope) this.f5659a.get(this.f5663e);
        int size = this.f5660b.size() - scope.f5658c;
        if (scope.f5657b != scope.f5656a.length) {
            E[] eArr2;
            if (size == 0) {
                eArr2 = this.f5661c;
            } else {
                Object[] objArr = (Object[]) Array.newInstance(this.f5661c.getClass().getComponentType(), size);
                for (int i = size - 1; i >= 0; i--) {
                    objArr[i] = this.f5660b.pollLast();
                }
            }
            eArr = eArr2;
        } else {
            for (int i2 = 0; i2 < size; i2++) {
                this.f5660b.pollLast();
            }
            eArr = null;
        }
        scope.f5656a = null;
        return eArr;
    }

    public final void m6970a(Object[] objArr) {
        this.f5663e++;
        if (this.f5663e == this.f5659a.size()) {
            this.f5662d = new Scope();
            this.f5659a.add(this.f5662d);
        } else {
            this.f5662d = (Scope) this.f5659a.get(this.f5663e);
        }
        Scope scope = this.f5662d;
        scope.f5656a = objArr;
        scope.f5657b = 0;
        scope.f5658c = this.f5660b.size();
    }

    public final void m6969a(E e) {
        Scope scope = this.f5662d;
        if (scope.f5657b >= scope.f5656a.length || scope.f5656a[scope.f5657b] != e) {
            scope.f5657b = Integer.MAX_VALUE;
        } else {
            scope.f5657b++;
        }
        this.f5660b.add(e);
    }
}
