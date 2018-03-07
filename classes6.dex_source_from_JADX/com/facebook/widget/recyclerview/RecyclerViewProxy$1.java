package com.facebook.widget.recyclerview;

import android.view.View;
import com.facebook.widget.listview.ScrollingViewProxy$OnItemClickListener;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnItemClickListener;

/* compiled from: read_receipts */
class RecyclerViewProxy$1 implements OnItemClickListener {
    final /* synthetic */ ScrollingViewProxy$OnItemClickListener f6133a;
    final /* synthetic */ RecyclerViewProxy f6134b;

    RecyclerViewProxy$1(RecyclerViewProxy recyclerViewProxy, ScrollingViewProxy$OnItemClickListener scrollingViewProxy$OnItemClickListener) {
        this.f6134b = recyclerViewProxy;
        this.f6133a = scrollingViewProxy$OnItemClickListener;
    }

    public final void m8695a(BetterRecyclerView betterRecyclerView, View view, int i, long j) {
        this.f6133a.m8636a(i);
    }
}
