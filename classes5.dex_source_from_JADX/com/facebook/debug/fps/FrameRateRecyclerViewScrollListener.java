package com.facebook.debug.fps;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: __type__ */
public class FrameRateRecyclerViewScrollListener extends OnScrollListener {
    private final FrameRateLogger f11787a;

    public FrameRateRecyclerViewScrollListener(FrameRateLogger frameRateLogger) {
        this.f11787a = frameRateLogger;
    }

    public final void m19809a(RecyclerView recyclerView, int i) {
        if (i == 0) {
            this.f11787a.b();
        } else {
            this.f11787a.a();
        }
        m19811b(recyclerView, i);
    }

    public void m19810a(RecyclerView recyclerView, int i, int i2) {
    }

    protected void m19811b(RecyclerView recyclerView, int i) {
    }
}
