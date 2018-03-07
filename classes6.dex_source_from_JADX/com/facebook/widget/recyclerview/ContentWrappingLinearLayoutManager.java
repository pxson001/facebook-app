package com.facebook.widget.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/* compiled from: receipt */
public class ContentWrappingLinearLayoutManager extends BetterLinearLayoutManager {
    private static final Rect f6124a = new Rect();

    public ContentWrappingLinearLayoutManager(Context context) {
        super(context);
    }

    public final void m8686a(Recycler recycler, State state, int i, int i2) {
        int i3;
        int i4 = 0;
        if (this.j == 1) {
            i3 = i2;
        } else {
            i3 = i;
        }
        if (MeasureSpec.getMode(i3) == 1073741824) {
            super.a(recycler, state, i, i2);
            return;
        }
        i3 = MeasureSpec.getMode(i3) == Integer.MIN_VALUE ? MeasureSpec.getSize(i3) : Integer.MAX_VALUE;
        int i5 = 0;
        while (i4 < D()) {
            i5 += m8685a(recycler, i4);
            if (i5 > i3) {
                i5 = i3;
                break;
            }
            i4++;
        }
        if (this.j == 1) {
            e(MeasureSpec.getSize(i), Math.min((B() + z()) + i5, i3));
        } else {
            e(Math.min((y() + A()) + i5, i3), MeasureSpec.getSize(i2));
        }
    }

    private int m8685a(Recycler recycler, int i) {
        View c = recycler.c(i);
        if (c == null) {
            return 0;
        }
        int g;
        LayoutParams layoutParams = (LayoutParams) c.getLayoutParams();
        c.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(0, 0), y() + A(), layoutParams.width), ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(0, 0), z() + B(), layoutParams.height));
        a(c, f6124a);
        if (this.j == 1) {
            g = layoutParams.topMargin + (LayoutManager.g(c) + layoutParams.bottomMargin);
        } else {
            g = layoutParams.rightMargin + (LayoutManager.f(c) + layoutParams.leftMargin);
        }
        recycler.a(c);
        return g;
    }
}
