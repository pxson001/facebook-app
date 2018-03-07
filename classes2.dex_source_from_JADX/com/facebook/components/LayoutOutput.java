package com.facebook.components;

import android.graphics.Rect;
import android.util.SparseArray;
import com.facebook.components.displaylist.DisplayList;

/* compiled from: get */
public class LayoutOutput implements Cloneable {
    public long f22625a;
    public Component<?> f22626b;
    public final Rect f22627c = new Rect();
    private int f22628d;
    private int f22629e;
    private int f22630f;
    public long f22631g = -1;
    public EventHandler f22632h;
    public CharSequence f22633i;
    public SparseArray<Object> f22634j;
    public int f22635k = 0;
    private int f22636l = 0;
    private DisplayList f22637m;

    final Component<?> m30544a() {
        return this.f22626b;
    }

    final void m30549a(Component<?> component) {
        this.f22626b = component;
    }

    final void m30548a(Rect rect) {
        rect.left = this.f22627c.left - this.f22628d;
        rect.top = this.f22627c.top - this.f22629e;
        rect.right = this.f22627c.right - this.f22628d;
        rect.bottom = this.f22627c.bottom - this.f22629e;
    }

    final Rect m30551b() {
        return this.f22627c;
    }

    final void m30546a(int i, int i2, int i3, int i4) {
        this.f22627c.set(i, i2, i3, i4);
    }

    final void m30545a(int i) {
        this.f22628d = i;
    }

    final void m30552b(int i) {
        this.f22629e = i;
    }

    final int m30553c() {
        return this.f22630f;
    }

    final void m30554c(int i) {
        this.f22630f = i;
    }

    final void m30547a(long j) {
        this.f22631g = j;
    }

    final long m30555e() {
        return this.f22625a;
    }

    public final EventHandler m30557f() {
        return this.f22632h;
    }

    public final CharSequence m30558g() {
        return this.f22633i;
    }

    public final SparseArray<Object> m30559h() {
        return this.f22634j;
    }

    public final int m30560j() {
        return this.f22636l;
    }

    public final void m30556e(int i) {
        this.f22636l = i;
    }

    public final DisplayList m30561k() {
        return this.f22637m;
    }

    public final void m30550a(DisplayList displayList) {
        this.f22637m = displayList;
    }

    void mo3294l() {
        if (this.f22626b != null) {
            this.f22626b.m30510d();
            this.f22626b = null;
        }
        this.f22637m = null;
        this.f22627c.setEmpty();
        this.f22628d = 0;
        this.f22629e = 0;
        this.f22630f = 0;
        this.f22631g = -1;
        this.f22632h = null;
        this.f22633i = null;
        this.f22634j = null;
        this.f22635k = 0;
        this.f22636l = 0;
    }
}
