package com.facebook.analytics.feature;

import com.facebook.backgroundlocation.reporting.BackgroundLocationReportingAnalyticsPeriodicFeatureStatus;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.location.LocationAnalyticsPeriodicFeatureStatus;
import com.facebook.messaging.lowdatamode.LowDataModeAnalyticsPeriodicFeatureStatus;
import com.facebook.oxygen.preloads.integration.fppreporting.FppFeatureStatus;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkPresenceMethodAutoProvider;
import com.facebook.push.mqtt.persistence.MqttPersistentServicePeriodicFeatureStatus;
import com.facebook.ui.browser.logging.BrowserEnabledPeriodicFeature;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$PeriodicFeatureStatus implements MultiBindIndexedProvider<PeriodicFeatureStatus>, Provider<Set<PeriodicFeatureStatus>> {
    private final InjectorLike f10915a;

    public STATICDI_MULTIBIND_PROVIDER$PeriodicFeatureStatus(InjectorLike injectorLike) {
        this.f10915a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10915a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 6;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return BackgroundLocationReportingAnalyticsPeriodicFeatureStatus.m11351a(injector);
            case 1:
                return LocationAnalyticsPeriodicFeatureStatus.m11359a((InjectorLike) injector);
            case 2:
                return LowDataModeAnalyticsPeriodicFeatureStatus.m11379a(injector);
            case 3:
                return new FppFeatureStatus(PreloadSdkPresenceMethodAutoProvider.b(injector));
            case 4:
                return MqttPersistentServicePeriodicFeatureStatus.m11397a(injector);
            case 5:
                return BrowserEnabledPeriodicFeature.m11402a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
