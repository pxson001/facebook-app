package com.facebook.zero.activity;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.zero.activity.ZeroIntentInterstitialActivity.Observer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: ्औ */
public final class C0000x67d39c18 implements MultiBindIndexedProvider<Observer>, Provider<Set<Observer>> {
    private final InjectorLike f2a;

    public C0000x67d39c18(InjectorLike injectorLike) {
        this.f2a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new NekoIntentInterstitialObserver(AnalyticsLoggerMethodAutoProvider.a(injector), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
