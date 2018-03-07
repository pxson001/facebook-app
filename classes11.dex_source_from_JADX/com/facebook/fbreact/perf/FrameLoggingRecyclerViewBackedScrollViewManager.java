package com.facebook.fbreact.perf;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.facebook.common.perftest.DrawFrameLogger;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.recyclerview.RecyclerViewBackedScrollView;
import com.facebook.react.views.recyclerview.RecyclerViewBackedScrollViewManager;
import javax.annotation.Nullable;

/* compiled from: event_ids */
public class FrameLoggingRecyclerViewBackedScrollViewManager extends RecyclerViewBackedScrollViewManager {
    @Nullable
    public DrawFrameLogger f7408a;

    /* compiled from: event_ids */
    class C09391 extends OnScrollListener {
        final /* synthetic */ FrameLoggingRecyclerViewBackedScrollViewManager f7407a;

        C09391(FrameLoggingRecyclerViewBackedScrollViewManager frameLoggingRecyclerViewBackedScrollViewManager) {
            this.f7407a = frameLoggingRecyclerViewBackedScrollViewManager;
        }

        public final void m8591a(RecyclerView recyclerView, int i) {
            switch (i) {
                case 1:
                case 2:
                    ((DrawFrameLogger) Assertions.b(this.f7407a.f7408a)).a();
                    return;
                default:
                    ((DrawFrameLogger) Assertions.b(this.f7407a.f7408a)).b();
                    return;
            }
        }
    }

    public final /* synthetic */ View mo220a(ThemedReactContext themedReactContext) {
        return mo221b(themedReactContext);
    }

    public FrameLoggingRecyclerViewBackedScrollViewManager(DrawFrameLogger drawFrameLogger) {
        this.f7408a = drawFrameLogger;
    }

    public final RecyclerViewBackedScrollView mo221b(ThemedReactContext themedReactContext) {
        if (this.f7408a == null) {
            this.f7408a = PerfTestConfigHolder.m8639a();
        }
        RecyclerViewBackedScrollView b = super.mo221b(themedReactContext);
        b.setOnScrollListener(new C09391(this));
        return b;
    }
}
