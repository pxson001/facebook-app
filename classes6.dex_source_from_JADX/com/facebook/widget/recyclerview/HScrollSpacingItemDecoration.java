package com.facebook.widget.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: reason_code */
public class HScrollSpacingItemDecoration extends ItemDecoration {
    private final int f6131a;
    private final boolean f6132b;

    public HScrollSpacingItemDecoration(int i) {
        this(i, false);
    }

    private HScrollSpacingItemDecoration(int i, boolean z) {
        this.f6131a = i;
        this.f6132b = z;
    }

    public final void m8692a(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.a(rect, view, recyclerView, state);
        int e = RecyclerView.e(view);
        if (this.f6132b || e > 0) {
            rect.left = this.f6131a;
        }
        if (this.f6132b && e == state.e() - 1) {
            rect.right = this.f6131a;
        }
    }
}
