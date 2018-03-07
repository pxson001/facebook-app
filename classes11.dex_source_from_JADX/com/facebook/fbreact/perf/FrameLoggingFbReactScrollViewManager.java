package com.facebook.fbreact.perf;

import android.view.View;
import com.facebook.common.perftest.DrawFrameLogger;
import com.facebook.fbreact.views.fbscroll.FbReactScrollView;
import com.facebook.fbreact.views.fbscroll.FbReactScrollViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import javax.annotation.Nullable;

/* compiled from: exclude_work_communities */
public class FrameLoggingFbReactScrollViewManager extends FbReactScrollViewManager {
    @Nullable
    public DrawFrameLogger f7404a;

    /* compiled from: exclude_work_communities */
    public class C09371 {
        public final /* synthetic */ FrameLoggingFbReactScrollViewManager f7402a;

        C09371(FrameLoggingFbReactScrollViewManager frameLoggingFbReactScrollViewManager) {
            this.f7402a = frameLoggingFbReactScrollViewManager;
        }
    }

    public final /* synthetic */ View mo218a(ThemedReactContext themedReactContext) {
        return m8581c(themedReactContext);
    }

    public final /* synthetic */ FbReactScrollView mo219b(ThemedReactContext themedReactContext) {
        return m8581c(themedReactContext);
    }

    public FrameLoggingFbReactScrollViewManager(DrawFrameLogger drawFrameLogger) {
        this.f7404a = drawFrameLogger;
    }

    private ObservableFbReactScrollView m8581c(ThemedReactContext themedReactContext) {
        if (this.f7404a == null) {
            this.f7404a = PerfTestConfigHolder.m8639a();
        }
        ObservableFbReactScrollView observableFbReactScrollView = new ObservableFbReactScrollView(themedReactContext);
        observableFbReactScrollView.f7450a = new C09371(this);
        return observableFbReactScrollView;
    }
}
