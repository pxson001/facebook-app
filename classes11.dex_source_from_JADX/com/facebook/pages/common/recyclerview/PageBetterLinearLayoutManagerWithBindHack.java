package com.facebook.pages.common.recyclerview;

import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;

/* compiled from: searchPlacesAndLayoutsRequest */
public class PageBetterLinearLayoutManagerWithBindHack extends LayoutManagerWithKeepAttachedHack {
    private final BetterRecyclerView f2238a;

    public PageBetterLinearLayoutManagerWithBindHack(BetterRecyclerView betterRecyclerView) {
        super(betterRecyclerView, null);
        this.f2238a = betterRecyclerView;
    }

    public final void m3188a(View view, Recycler recycler) {
        ViewHolder a = this.f2238a.a(view);
        if (this.f2238a.F != null) {
            this.f2238a.F.a(a);
        }
        d(view);
    }
}
