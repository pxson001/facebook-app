package com.facebook.device_id;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.init.ErrorReporterDeviceIdChangedCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.device_id.reporter.DeviceIdUpdatedLogger;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.push.fbpushtoken.DeviceIdChangedTokenRefresher;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$DeviceIdChangedCallback implements MultiBindIndexedProvider<DeviceIdChangedCallback>, Provider<Set<DeviceIdChangedCallback>> {
    private final InjectorLike f860a;

    private STATICDI_MULTIBIND_PROVIDER$DeviceIdChangedCallback(InjectorLike injectorLike) {
        this.f860a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f860a.getScopeAwareInjector(), this);
    }

    public static Set<DeviceIdChangedCallback> m1201a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$DeviceIdChangedCallback(injectorLike));
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new ErrorReporterDeviceIdChangedCallback((AbstractFbErrorReporter) FbErrorReporterImpl.a(injector));
            case 1:
                return new DeviceIdUpdatedLogger(AnalyticsLoggerMethodAutoProvider.a(injector), (Clock) SystemClockMethodAutoProvider.a(injector));
            case 2:
                return DeviceIdChangedTokenRefresher.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
