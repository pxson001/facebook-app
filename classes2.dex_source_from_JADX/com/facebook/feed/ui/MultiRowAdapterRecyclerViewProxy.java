package com.facebook.feed.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.ListAdapter;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.RecyclerViewProxy;

/* compiled from: normal */
public class MultiRowAdapterRecyclerViewProxy extends RecyclerViewProxy {
    public HasMultiRow f12216b;

    public MultiRowAdapterRecyclerViewProxy(BetterRecyclerView betterRecyclerView) {
        super(betterRecyclerView);
    }

    public final void mo2339a(ListAdapter listAdapter) {
        super.mo2339a(listAdapter);
        this.f12216b = (HasMultiRow) listAdapter;
    }

    public final void mo2340a(AdapterCompatibleWithListView<? extends ViewHolder> adapterCompatibleWithListView) {
        super.mo2340a((AdapterCompatibleWithListView) adapterCompatibleWithListView);
        this.f12216b = (HasMultiRow) adapterCompatibleWithListView;
    }
}
