package com.facebook.fbreactmodules.perf;

import com.facebook.common.perftest.DrawFrameLogger;
import com.facebook.fbreact.perf.FrameLoggingReactScrollViewManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: e44d034af1b91192511a7a30e9ac0fab */
public class FbFrameLoggingReactScrollViewManager extends FrameLoggingReactScrollViewManager {
    private static FbFrameLoggingReactScrollViewManager m8723b(InjectorLike injectorLike) {
        return new FbFrameLoggingReactScrollViewManager(DrawFrameLogger.a(injectorLike));
    }

    @Inject
    public FbFrameLoggingReactScrollViewManager(DrawFrameLogger drawFrameLogger) {
        super(drawFrameLogger);
    }

    public static FbFrameLoggingReactScrollViewManager m8722a(InjectorLike injectorLike) {
        return m8723b(injectorLike);
    }
}
