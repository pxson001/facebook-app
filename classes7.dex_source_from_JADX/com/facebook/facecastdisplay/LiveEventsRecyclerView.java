package com.facebook.facecastdisplay;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/* compiled from: story_admin_page */
public class LiveEventsRecyclerView extends RecyclerView {
    public final LiveEventsLinearLayoutManager f2971h;

    /* compiled from: story_admin_page */
    class LiveEventsLinearLayoutManager extends LinearLayoutManager {
        public LiveEventsLinearLayoutManager(Context context) {
            super(context);
            a(true);
            b(1);
        }
    }

    public LiveEventsRecyclerView(Context context) {
        this(context, null);
    }

    public LiveEventsRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveEventsRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2971h = new LiveEventsLinearLayoutManager(context);
        setLayoutManager(this.f2971h);
    }

    public LiveEventsLinearLayoutManager getLayoutManager() {
        return this.f2971h;
    }

    public int getFirstCompletelyVisiblePosition() {
        return this.f2971h.m();
    }

    public int getLastCompletelyVisiblePosition() {
        return this.f2971h.o();
    }
}
