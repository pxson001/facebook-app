package com.facebook.debug.fps;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* compiled from: __typename */
public class FrameRateListViewScrollListener implements OnScrollListener {
    private final FrameRateLogger f11786a;

    public FrameRateListViewScrollListener(FrameRateLogger frameRateLogger) {
        this.f11786a = frameRateLogger;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.f11786a.b();
        } else {
            this.f11786a.a();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
