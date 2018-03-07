package com.facebook.analytics.service;

import com.facebook.analytics.service.AnalyticsEventsDataStore.AnalyticsEventsDataStoreListener;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class C0072x552d0095 implements MultiBindIndexedProvider<AnalyticsEventsDataStoreListener>, Provider<Set<AnalyticsEventsDataStoreListener>> {
    private final InjectorLike f1187a;

    public C0072x552d0095(InjectorLike injectorLike) {
        this.f1187a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1187a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return AnalyticsEventUploader.m1267a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
