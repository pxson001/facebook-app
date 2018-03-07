package com.facebook.analytics.eventlisteners;

import com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter;
import com.facebook.analytics.timespent.TimeSpentEventReporter;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$AnalyticsEventListener implements MultiBindIndexedProvider<AnalyticsEventListener>, Provider<Set<AnalyticsEventListener>> {
    private final InjectorLike f7464a;

    public STATICDI_MULTIBIND_PROVIDER$AnalyticsEventListener(InjectorLike injectorLike) {
        this.f7464a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f7464a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return ImmediateActiveSecondReporter.m21688a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return TimeSpentEventReporter.m20164a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
