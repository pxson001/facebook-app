package com.facebook.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: realtimeViewerFbid */
public class JustifiedLinearLayoutManager extends BetterLinearLayoutManager {
    public JustifiedLinearLayoutManager(Context context) {
        super(context, 0, false);
    }

    public final void m8694c(Recycler recycler, State state) {
        if (state.k || state.e() == 0 || !m8693d(recycler, state)) {
            super.c(recycler, state);
            return;
        }
        int w = w() / state.e();
        a(recycler);
        for (int i = 0; i < state.e(); i++) {
            View c = recycler.c(i);
            b(c);
            a(c, 0, 0);
            int i2 = (int) (((double) w) * (((double) i) + 0.5d));
            int measuredWidth = c.getMeasuredWidth() / 2;
            a(c, i2 - measuredWidth, 0, measuredWidth + i2, c.getMeasuredHeight());
        }
        f(state);
    }

    private boolean m8693d(Recycler recycler, State state) {
        int i = 0;
        for (int i2 = 0; i2 < state.e(); i2++) {
            View c = recycler.c(i2);
            a(c, 0, 0);
            i += c.getMeasuredWidth();
        }
        if (i <= w()) {
            return true;
        }
        return false;
    }
}
