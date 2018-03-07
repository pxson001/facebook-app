package com.facebook.react.views.recyclerview;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;

/* compiled from: RelayAPIConfig */
class NotAnimatedItemAnimator extends ItemAnimator {
    NotAnimatedItemAnimator() {
    }

    public final void m11925a() {
    }

    public final boolean m11926a(ViewHolder viewHolder) {
        d(viewHolder);
        return true;
    }

    public final boolean m11930b(ViewHolder viewHolder) {
        f(viewHolder);
        return true;
    }

    public final boolean m11927a(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        e(viewHolder);
        return true;
    }

    public final boolean m11928a(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        a(viewHolder, true);
        a(viewHolder2, false);
        return true;
    }

    public final void m11932c(ViewHolder viewHolder) {
    }

    public final void m11931c() {
    }

    public final boolean m11929b() {
        return false;
    }
}
