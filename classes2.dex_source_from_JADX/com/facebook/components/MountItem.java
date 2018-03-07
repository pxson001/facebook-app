package com.facebook.components;

import android.content.Context;
import android.util.SparseArray;
import com.facebook.components.displaylist.DisplayList;

/* compiled from: getAllHeaders */
public class MountItem {
    public Component<?> f22615a;
    public Object f22616b;
    public ComponentHost f22617c;
    public CharSequence f22618d;
    public SparseArray<Object> f22619e;
    public EventHandler f22620f;
    public boolean f22621g;
    public int f22622h;
    private DisplayList f22623i;
    public int f22624j;

    final void m30539a(Component<?> component, ComponentHost componentHost, Object obj, CharSequence charSequence, SparseArray<Object> sparseArray, EventHandler eventHandler, DisplayList displayList, int i, int i2) {
        this.f22615a = component;
        this.f22616b = obj;
        this.f22617c = componentHost;
        this.f22620f = eventHandler;
        this.f22624j = i;
        this.f22618d = charSequence;
        this.f22619e = sparseArray;
        this.f22622h = i2;
        this.f22623i = displayList;
    }

    final ComponentHost m30540b() {
        return this.f22617c;
    }

    final Object m30541c() {
        return this.f22616b;
    }

    final boolean m30542i() {
        if (this.f22615a == null || this.f22622h == 2) {
            return false;
        }
        return this.f22615a.f22589c.mo3147g();
    }

    void mo3293a(Context context) {
        if (!(this.f22616b instanceof ComponentHost)) {
            ComponentsPools.m30519a(context, this.f22615a.f22589c.f20396d, this.f22616b);
        }
        this.f22615a = null;
        this.f22623i = null;
        this.f22617c = null;
        this.f22616b = null;
        this.f22624j = 0;
        this.f22618d = null;
        this.f22620f = null;
        this.f22619e = null;
        this.f22621g = false;
        this.f22622h = 0;
    }

    static boolean m30537b(int i) {
        return (i & 1) == 1;
    }

    public final DisplayList m30543k() {
        return this.f22623i;
    }
}
