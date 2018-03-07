package com.facebook.common.executors;

import android.os.Looper;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: update_pinned_threads */
public class Looper_ForNonUiThreadMethodAutoProvider extends AbstractProvider<Looper> {
    public static Looper m3572b(InjectorLike injectorLike) {
        return ExecutorsModule.m1706a(HandlerThreadMethodAutoProvider.m3573a(injectorLike));
    }

    public Object get() {
        return ExecutorsModule.m1706a(HandlerThreadMethodAutoProvider.m3573a(this));
    }

    public static Looper m3571a(InjectorLike injectorLike) {
        return m3572b(injectorLike);
    }
}
