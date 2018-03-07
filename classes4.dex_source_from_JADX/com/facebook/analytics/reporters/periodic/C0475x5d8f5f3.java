package com.facebook.analytics.reporters.periodic;

import com.facebook.accessibility.DeviceInfoPeriodicReporterAdditionalInfoAccessibility;
import com.facebook.common.android.AccessibilityManagerMethodAutoProvider;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class C0475x5d8f5f3 implements MultiBindIndexedProvider<DeviceInfoPeriodicReporterAdditionalInfo>, Provider<Set<DeviceInfoPeriodicReporterAdditionalInfo>> {
    private final InjectorLike f10490a;

    private C0475x5d8f5f3(InjectorLike injectorLike) {
        this.f10490a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10490a.getScopeAwareInjector(), this);
    }

    public static Set<DeviceInfoPeriodicReporterAdditionalInfo> m11041a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0475x5d8f5f3(injectorLike));
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new DeviceInfoPeriodicReporterAdditionalInfoAccessibility(AccessibilityManagerMethodAutoProvider.b(injector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injector), ContentResolverMethodAutoProvider.b(injector), ResourcesMethodAutoProvider.a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
