package com.facebook.facecastdisplay;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;

/* compiled from: story_legacy_api_post_id */
public class LiveEventsOnScrollListener extends OnScrollListener {
    private final LinearLayoutManager f2949a;
    private final float f2950b;

    public LiveEventsOnScrollListener(LinearLayoutManager linearLayoutManager, float f) {
        this.f2949a = linearLayoutManager;
        this.f2950b = f;
    }

    public final void m3229a(RecyclerView recyclerView, int i, int i2) {
        int l = this.f2949a.l();
        int n = this.f2949a.n();
        if (l != -1) {
            for (int i3 = l; i3 < n; i3++) {
                View c = this.f2949a.c(i3);
                float top = ((float) c.getTop()) / this.f2950b;
                if (top < 0.0f) {
                    top = 0.0f;
                } else if (top > 1.0f) {
                    top = 1.0f;
                }
                c.setAlpha(top);
            }
            if (i2 != 0) {
                this.f2949a.c(n).setAlpha(1.0f);
            }
        }
    }
}
