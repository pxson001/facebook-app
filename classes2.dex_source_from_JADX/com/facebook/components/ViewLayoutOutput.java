package com.facebook.components;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.components.reference.Reference;

/* compiled from: geometric_samples_till_change */
class ViewLayoutOutput extends LayoutOutput {
    private final Rect f22638a = new Rect();
    private Reference<Drawable> f22639b;
    private Reference<Drawable> f22640c;
    private int f22641d;

    ViewLayoutOutput() {
    }

    final void m30563a(Reference<Drawable> reference) {
        this.f22639b = reference;
    }

    final Reference<Drawable> m30568m() {
        return this.f22639b;
    }

    final void m30565b(Reference<Drawable> reference) {
        this.f22640c = reference;
    }

    final Reference<Drawable> m30569n() {
        return this.f22640c;
    }

    final Rect m30570o() {
        return this.f22638a;
    }

    final void m30564b(int i, int i2, int i3, int i4) {
        this.f22638a.set(i, i2, i3, i4);
    }

    final void m30566f(int i) {
        this.f22641d = i;
    }

    final int m30571p() {
        return this.f22641d;
    }

    final void mo3294l() {
        super.mo3294l();
        this.f22638a.setEmpty();
        this.f22639b = null;
        this.f22640c = null;
        this.f22641d = 0;
    }
}
