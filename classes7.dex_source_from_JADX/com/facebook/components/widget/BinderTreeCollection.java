package com.facebook.components.widget;

import android.support.v4.util.SparseArrayCompat;
import com.facebook.components.ComponentTree;

/* compiled from: transliterator_dictionary_mod_failed */
class BinderTreeCollection {
    private final SparseArrayCompat<ComponentTree> f1239a = new SparseArrayCompat();

    BinderTreeCollection() {
    }

    final int m1319a() {
        return this.f1239a.a() == 0 ? -1 : this.f1239a.e(0);
    }

    final void m1322a(int i, ComponentTree componentTree) {
        this.f1239a.a(i, componentTree);
    }

    final void m1321a(int i) {
        this.f1239a.b(i);
    }

    final ComponentTree m1324b(int i) {
        return (ComponentTree) this.f1239a.a(i);
    }

    final int m1320a(ComponentTree componentTree) {
        return this.f1239a.a(componentTree);
    }

    final int m1323b() {
        return this.f1239a.a();
    }
}
