package com.facebook.components;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.facebook.components.reference.Reference;

/* compiled from: getCertificate */
public class ViewMountItem extends MountItem {
    public final Rect f22611a = new Rect();
    public Reference<Drawable> f22612b;
    public Reference<Drawable> f22613c;
    public int f22614d;

    ViewMountItem() {
    }

    final void m30535a(Component<?> component, ComponentHost componentHost, Object obj, CharSequence charSequence, SparseArray<Object> sparseArray, EventHandler eventHandler, int i, int i2, int i3, Rect rect, Reference<Drawable> reference, Reference<Drawable> reference2) {
        super.m30539a(component, componentHost, obj, charSequence, sparseArray, eventHandler, null, i, i2);
        this.f22611a.set(rect);
        this.f22612b = reference;
        this.f22613c = reference2;
        this.f22614d = i3;
    }

    public final boolean m30536r() {
        return (this.f22611a.left == 0 && this.f22611a.top == 0 && this.f22611a.right == 0 && this.f22611a.bottom == 0) ? false : true;
    }

    final void mo3293a(Context context) {
        super.mo3293a(context);
        this.f22611a.setEmpty();
        this.f22612b = null;
        this.f22613c = null;
        this.f22614d = 0;
    }
}
