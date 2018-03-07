package com.facebook.widget.recyclerview;

import android.view.View;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnItemLongClickListener;

/* compiled from: read_receipts */
class RecyclerViewProxy$2 implements OnItemLongClickListener {
    final /* synthetic */ ScrollingViewProxy.OnItemLongClickListener f6135a;
    final /* synthetic */ RecyclerViewProxy f6136b;

    RecyclerViewProxy$2(RecyclerViewProxy recyclerViewProxy, ScrollingViewProxy.OnItemLongClickListener onItemLongClickListener) {
        this.f6136b = recyclerViewProxy;
        this.f6135a = onItemLongClickListener;
    }

    public final boolean m8696a(BetterRecyclerView betterRecyclerView, View view, int i, long j) {
        return this.f6135a.a(view, i);
    }
}
