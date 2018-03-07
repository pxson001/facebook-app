package com.facebook.events.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.events.model.Event;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;

@ContextScoped
/* compiled from: canonical_new_presence_push */
public class EventPhaseSelector {
    private static EventPhaseSelector f17884f;
    private static final Object f17885g = new Object();
    private Clock f17886a;
    private long f17887b;
    private long f17888c;
    private long f17889d;
    private long f17890e;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: canonical_new_presence_push */
    public @interface EventPhase {
    }

    private static EventPhaseSelector m18300b(InjectorLike injectorLike) {
        return new EventPhaseSelector((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EventPhaseSelector(Clock clock) {
        this.f17886a = clock;
        this.f17890e = clock.a();
    }

    public final void m18302a(long j, long j2, long j3) {
        this.f17887b = j;
        this.f17888c = j2;
        this.f17889d = j3;
        this.f17890e = this.f17886a.a();
    }

    private int m18301c(Event event) {
        long K = event.K();
        long j = K - this.f17887b;
        if (this.f17890e < j) {
            return 0;
        }
        K = event.a(K + this.f17889d) + this.f17888c;
        if (this.f17890e > K || j == K) {
            return 2;
        }
        return 1;
    }

    public static EventPhaseSelector m18299a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventPhaseSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17885g) {
                EventPhaseSelector eventPhaseSelector;
                if (a2 != null) {
                    eventPhaseSelector = (EventPhaseSelector) a2.a(f17885g);
                } else {
                    eventPhaseSelector = f17884f;
                }
                if (eventPhaseSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18300b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17885g, b3);
                        } else {
                            f17884f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventPhaseSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m18303a(Event event) {
        return m18301c(event) == 2;
    }

    public final boolean m18304b(Event event) {
        return m18301c(event) == 1;
    }
}
