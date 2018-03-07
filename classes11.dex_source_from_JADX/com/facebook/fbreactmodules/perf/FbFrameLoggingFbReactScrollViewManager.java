package com.facebook.fbreactmodules.perf;

import com.facebook.common.perftest.DrawFrameLogger;
import com.facebook.fbreact.perf.FrameLoggingFbReactScrollViewManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: earlier_total_rss_kb */
public class FbFrameLoggingFbReactScrollViewManager extends FrameLoggingFbReactScrollViewManager {
    private static FbFrameLoggingFbReactScrollViewManager m8719b(InjectorLike injectorLike) {
        return new FbFrameLoggingFbReactScrollViewManager(DrawFrameLogger.a(injectorLike));
    }

    @Inject
    public FbFrameLoggingFbReactScrollViewManager(DrawFrameLogger drawFrameLogger) {
        super(drawFrameLogger);
    }

    public static FbFrameLoggingFbReactScrollViewManager m8718a(InjectorLike injectorLike) {
        return m8719b(injectorLike);
    }
}
