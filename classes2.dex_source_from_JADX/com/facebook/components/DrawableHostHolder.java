package com.facebook.components;

import android.graphics.drawable.Drawable;
import android.support.v4.util.SparseArrayCompat;
import android.util.SparseArray;

/* compiled from: getJavaLangAccess */
public class DrawableHostHolder {
    public final SparseArrayCompat<MountItem> f22556a = new SparseArrayCompat();
    public SparseArrayCompat<MountItem> f22557b;
    public final SparseArrayCompat<Touchable> f22558c = new SparseArrayCompat();
    public SparseArrayCompat<Touchable> f22559d;
    public SparseArray<Object> f22560e;
    public CharSequence f22561f;
    public ComponentClickListener f22562g;
    public boolean f22563h;
    public boolean f22564i;
    public boolean f22565j;
    public final ComponentHost f22566k;

    DrawableHostHolder(ComponentHost componentHost) {
        this.f22566k = componentHost;
    }

    final void m30454a(int i, Drawable drawable) {
        if (ComponentHostUtils.m30652a(i, this.f22557b)) {
            this.f22557b.m6353b(i);
        } else {
            this.f22556a.m6353b(i);
        }
        drawable.setCallback(null);
        if (drawable instanceof Touchable) {
            if (ComponentHostUtils.m30652a(i, this.f22559d)) {
                this.f22559d.m6353b(i);
            } else {
                this.f22558c.m6353b(i);
            }
        }
        this.f22566k.invalidate(drawable.getBounds());
        m30453k();
    }

    final void m30455a(MountItem mountItem, int i, int i2) {
        if (this.f22556a.m6350a(i2) != null) {
            if (this.f22557b == null) {
                this.f22557b = ComponentsPools.m30529f();
            }
            ComponentHostUtils.m30649a(i2, this.f22556a, this.f22557b);
        }
        boolean z = mountItem.f22616b instanceof Touchable;
        if (z && this.f22558c.m6350a(i2) != null) {
            if (this.f22559d == null) {
                SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) ComponentsPools.f22604n.mo740a();
                if (sparseArrayCompat == null) {
                    sparseArrayCompat = new SparseArrayCompat(4);
                }
                this.f22559d = sparseArrayCompat;
            }
            ComponentHostUtils.m30649a(i2, this.f22558c, this.f22559d);
        }
        ComponentHostUtils.m30648a(i, i2, this.f22556a, this.f22557b);
        if (z) {
            ComponentHostUtils.m30648a(i, i2, this.f22558c, this.f22559d);
        }
        this.f22566k.invalidate();
        m30453k();
    }

    final boolean m30456g() {
        if (!this.f22565j) {
            return false;
        }
        this.f22563h = true;
        return true;
    }

    private void m30453k() {
        if (this.f22557b != null && this.f22557b.m6348a() == 0) {
            ComponentsPools.m30522a(this.f22557b);
            this.f22557b = null;
        }
        if (this.f22559d != null && this.f22559d.m6348a() == 0) {
            ComponentsPools.f22604n.mo741a(this.f22559d);
            this.f22559d = null;
        }
    }
}
