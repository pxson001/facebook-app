package com.facebook.feed.ui;

import com.facebook.widget.listview.AdapterCompatibleWithListView;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.recyclerview.BetterRecyclerView;

/* compiled from: not a valid Byte value */
public class NewsFeedRecyclerViewProxy extends MultiRowAdapterRecyclerViewProxy {
    private NewsFeedRecyclerViewAdapterWrapper f12215b;

    public NewsFeedRecyclerViewProxy(BetterRecyclerView betterRecyclerView) {
        super(betterRecyclerView);
    }

    public final void m18037a(NewsFeedRecyclerViewAdapterWrapper newsFeedRecyclerViewAdapterWrapper) {
        if (newsFeedRecyclerViewAdapterWrapper instanceof FbListAdapter) {
            mo2339a((FbListAdapter) newsFeedRecyclerViewAdapterWrapper);
        } else if (newsFeedRecyclerViewAdapterWrapper instanceof AdapterCompatibleWithListView) {
            mo2340a((AdapterCompatibleWithListView) newsFeedRecyclerViewAdapterWrapper);
        } else {
            throw new IllegalArgumentException("Unknown adapter type");
        }
        this.f12215b = newsFeedRecyclerViewAdapterWrapper;
    }

    public final int m18035D() {
        if (this.f12215b == null || this.f12215b.mo2512e() == 0) {
            return 0;
        }
        return this.f12215b.s_(Math.max(this.f12215b.m20017b(), Math.min(this.f12215b.m20022d(), m18034F().mo2187o())));
    }

    public final int m18036E() {
        return m18034F().getAccurateFirstVisiblePosition();
    }

    private NewsFeedRecyclerView m18034F() {
        return (NewsFeedRecyclerView) this.f12219c;
    }
}
