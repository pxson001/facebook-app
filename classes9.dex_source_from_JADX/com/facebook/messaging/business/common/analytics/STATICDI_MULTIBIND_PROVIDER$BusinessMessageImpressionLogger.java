package com.facebook.messaging.business.common.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.business.promotion.analytics.AdsImpressionLogger;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$BusinessMessageImpressionLogger implements MultiBindIndexedProvider<BusinessMessageImpressionLogger>, Provider<Set<BusinessMessageImpressionLogger>> {
    private final InjectorLike f8703a;

    public STATICDI_MULTIBIND_PROVIDER$BusinessMessageImpressionLogger(InjectorLike injectorLike) {
        this.f8703a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8703a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new DefaultBusinessMessageImpressionLogger(AnalyticsLoggerMethodAutoProvider.a(injector));
            case 1:
                return AdsImpressionLogger.m9349a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
