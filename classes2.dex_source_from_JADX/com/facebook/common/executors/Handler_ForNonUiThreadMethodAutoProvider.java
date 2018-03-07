package com.facebook.common.executors;

import android.os.Handler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: tag_value */
public class Handler_ForNonUiThreadMethodAutoProvider extends AbstractProvider<Handler> {
    public static Handler m5523b(InjectorLike injectorLike) {
        return ExecutorsModule.m1717b(Looper_ForNonUiThreadMethodAutoProvider.m3572b(injectorLike));
    }

    public Object get() {
        return ExecutorsModule.m1717b(Looper_ForNonUiThreadMethodAutoProvider.m3572b(this));
    }

    public static Handler m5522a(InjectorLike injectorLike) {
        return m5523b(injectorLike);
    }
}
