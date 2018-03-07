package com.facebook.widget.listview;

import android.view.View;
import android.widget.AbsListView.RecyclerListener;

/* compiled from: referrer_id */
class ListViewProxy$4 implements RecyclerListener {
    final /* synthetic */ ScrollingViewProxy.RecyclerListener f6049a;
    final /* synthetic */ ListViewProxy f6050b;

    ListViewProxy$4(ListViewProxy listViewProxy, ScrollingViewProxy.RecyclerListener recyclerListener) {
        this.f6050b = listViewProxy;
        this.f6049a = recyclerListener;
    }

    public void onMovedToScrapHeap(View view) {
        this.f6049a.a(view);
    }
}
