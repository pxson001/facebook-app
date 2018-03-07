package com.facebook.widget.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/* compiled from: reason_with_entities */
public class GridSpacingItemDecoration extends ItemDecoration {
    private final int f6130a;

    public GridSpacingItemDecoration(int i) {
        this.f6130a = i;
    }

    public final void m8691a(Rect rect, View view, RecyclerView recyclerView, State state) {
        int i;
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            i = ((GridLayoutManager) layoutManager).c;
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            i = ((StaggeredGridLayoutManager) layoutManager).g;
        } else {
            i = -1;
        }
        int i2 = i;
        if (i2 > 0) {
            int d = RecyclerView.d(view);
            int i3 = d % i2;
            rect.left = this.f6130a - ((this.f6130a * i3) / i2);
            rect.right = ((i3 + 1) * this.f6130a) / i2;
            if (d < i2) {
                rect.top = this.f6130a;
            }
            rect.bottom = this.f6130a;
        }
    }
}
