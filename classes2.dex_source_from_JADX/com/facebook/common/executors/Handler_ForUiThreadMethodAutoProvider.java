package com.facebook.common.executors;

import android.os.Handler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: web_view_time */
public class Handler_ForUiThreadMethodAutoProvider extends AbstractProvider<Handler> {
    public static Handler m1701b(InjectorLike injectorLike) {
        return ExecutorsModule.m1703a(Looper_ForUiThreadMethodAutoProvider.m1702a(injectorLike));
    }

    public Object get() {
        return ExecutorsModule.m1703a(Looper_ForUiThreadMethodAutoProvider.m1702a(this));
    }

    public static Handler m1700a(InjectorLike injectorLike) {
        return m1701b(injectorLike);
    }
}
