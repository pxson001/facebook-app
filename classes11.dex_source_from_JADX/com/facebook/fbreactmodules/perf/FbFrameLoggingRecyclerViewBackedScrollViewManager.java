package com.facebook.fbreactmodules.perf;

import com.facebook.common.perftest.DrawFrameLogger;
import com.facebook.fbreact.perf.FrameLoggingRecyclerViewBackedScrollViewManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: e3927e5014a82b29f4829b5e618cab61 */
public class FbFrameLoggingRecyclerViewBackedScrollViewManager extends FrameLoggingRecyclerViewBackedScrollViewManager {
    private static FbFrameLoggingRecyclerViewBackedScrollViewManager m8727b(InjectorLike injectorLike) {
        return new FbFrameLoggingRecyclerViewBackedScrollViewManager(DrawFrameLogger.a(injectorLike));
    }

    @Inject
    public FbFrameLoggingRecyclerViewBackedScrollViewManager(DrawFrameLogger drawFrameLogger) {
        super(drawFrameLogger);
    }

    public static FbFrameLoggingRecyclerViewBackedScrollViewManager m8726a(InjectorLike injectorLike) {
        return m8727b(injectorLike);
    }
}
