package com.facebook.springs;

import com.facebook.common.time.Clock;
import com.facebook.inject.InjectorLike;

/* compiled from: connection_style */
public class SpringClock implements Clock {
    public static SpringClock m10184a(InjectorLike injectorLike) {
        return new SpringClock();
    }

    public final long m10185a() {
        return System.currentTimeMillis();
    }
}
