package com.facebook.debug.fps;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: platform_prefetch_ready */
public class TimeSinceTTI {
    private static TimeSinceTTI f9595c;
    private static final Object f9596d = new Object();
    public long f9597a;
    public final MonotonicClock f9598b;

    private static TimeSinceTTI m14651b(InjectorLike injectorLike) {
        return new TimeSinceTTI(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public TimeSinceTTI(MonotonicClock monotonicClock) {
        this.f9598b = monotonicClock;
    }

    public static TimeSinceTTI m14650a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimeSinceTTI b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f9596d) {
                TimeSinceTTI timeSinceTTI;
                if (a2 != null) {
                    timeSinceTTI = (TimeSinceTTI) a2.mo818a(f9596d);
                } else {
                    timeSinceTTI = f9595c;
                }
                if (timeSinceTTI == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m14651b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f9596d, b3);
                        } else {
                            f9595c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = timeSinceTTI;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
