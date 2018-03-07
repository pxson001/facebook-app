package com.facebook.widget.hscrollrecyclerview;

import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: dashboard */
class HScrollRecyclerView$1 extends OnScrollListener {
    final /* synthetic */ OrientationHelper f16134a;
    final /* synthetic */ HScrollRecyclerView f16135b;

    HScrollRecyclerView$1(HScrollRecyclerView hScrollRecyclerView, OrientationHelper orientationHelper) {
        this.f16135b = hScrollRecyclerView;
        this.f16134a = orientationHelper;
    }

    public final void m20172a(RecyclerView recyclerView, int i, int i2) {
        HScrollRecyclerView.j(this.f16135b, this.f16135b.h.l(), this.f16134a.a(this.f16135b.getChildAt(0)) - this.f16134a.c());
    }
}
