package com.facebook.groups.groupsgrid;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView.Adapter;
import com.facebook.groups.groupsgrid.adapter.Enums.ViewTypes;

/* compiled from: XML Error */
public class GroupsSectionedGridLayoutManagerSpanSizeLookup extends SpanSizeLookup {
    private final int f10314b;
    private final Adapter f10315c;

    public GroupsSectionedGridLayoutManagerSpanSizeLookup(int i, Adapter adapter) {
        this.f10314b = i;
        this.f10315c = adapter;
    }

    public final int m10741a(int i) {
        if (this.f10315c.getItemViewType(i) == ViewTypes.POG.ordinal()) {
            return 1;
        }
        return this.f10314b;
    }
}
