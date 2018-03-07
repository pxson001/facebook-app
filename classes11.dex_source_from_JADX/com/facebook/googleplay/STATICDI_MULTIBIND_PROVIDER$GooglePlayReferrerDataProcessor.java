package com.facebook.googleplay;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.growth.fb4areferral.Fb4aReferrerDataProcessor;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.registration.common.RegInstanceHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: rsvp_event */
public final class STATICDI_MULTIBIND_PROVIDER$GooglePlayReferrerDataProcessor implements MultiBindIndexedProvider<GooglePlayReferrerDataProcessor>, Provider<Set<GooglePlayReferrerDataProcessor>> {
    private final InjectorLike f10075a;

    public STATICDI_MULTIBIND_PROVIDER$GooglePlayReferrerDataProcessor(InjectorLike injectorLike) {
        this.f10075a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10075a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new GrowthReferrerDataProcessor(AnalyticsLoggerMethodAutoProvider.a(injector));
            case 1:
                return new Fb4aReferrerDataProcessor(AnalyticsLoggerMethodAutoProvider.a(injector), RegInstanceHelper.b(injector), (SecureContextHelper) DefaultSecureContextHelper.a(injector), IdBasedLazy.a(injector, 2209), IdBasedSingletonScopeProvider.b(injector, 609), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injector), AppInitLock.a(injector), (Context) injector.getInstance(Context.class));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
