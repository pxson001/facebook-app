package com.facebook.fbreact.perf;

import android.view.View;
import com.facebook.common.perftest.DrawFrameLogger;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import javax.annotation.Nullable;

/* compiled from: events_max_num */
public class FrameLoggingReactScrollViewManager extends ReactScrollViewManager {
    @Nullable
    public DrawFrameLogger f7406a;

    /* compiled from: events_max_num */
    public class C09381 {
        public final /* synthetic */ FrameLoggingReactScrollViewManager f7405a;

        C09381(FrameLoggingReactScrollViewManager frameLoggingReactScrollViewManager) {
            this.f7405a = frameLoggingReactScrollViewManager;
        }
    }

    public final /* synthetic */ View m8587a(ThemedReactContext themedReactContext) {
        return b(themedReactContext);
    }

    public FrameLoggingReactScrollViewManager(DrawFrameLogger drawFrameLogger) {
        this.f7406a = drawFrameLogger;
    }

    public final ReactScrollView m8588b(ThemedReactContext themedReactContext) {
        if (this.f7406a == null) {
            this.f7406a = PerfTestConfigHolder.m8639a();
        }
        ObservableReactScrollView observableReactScrollView = new ObservableReactScrollView(themedReactContext);
        observableReactScrollView.f7456a = new C09381(this);
        return observableReactScrollView;
    }
}
