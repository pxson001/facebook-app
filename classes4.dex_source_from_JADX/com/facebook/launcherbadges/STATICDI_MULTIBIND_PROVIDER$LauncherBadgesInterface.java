package com.facebook.launcherbadges;

import android.content.Context;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.intent.HomeIntentHandlerHelper;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.app.module.String_AppLaunchClassMethodAutoProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$LauncherBadgesInterface implements MultiBindIndexedProvider<LauncherBadgesInterface>, Provider<Set<LauncherBadgesInterface>> {
    private final InjectorLike f8418a;

    public STATICDI_MULTIBIND_PROVIDER$LauncherBadgesInterface(InjectorLike injectorLike) {
        this.f8418a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8418a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new HtcLauncherBadgesInterface((Context) injector.getInstance(Context.class), PackageManagerMethodAutoProvider.a(injector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injector), HomeIntentHandlerHelper.m8685b(injector), String_AppLaunchClassMethodAutoProvider.m8695a(injector));
            case 1:
                return new LgLauncherBadgesInterface((Context) injector.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injector), String_AppLaunchClassMethodAutoProvider.m8695a(injector));
            case 2:
                return new SamsungLauncherBadgesInterface((Context) injector.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injector), HomeIntentHandlerHelper.m8685b(injector), String_AppLaunchClassMethodAutoProvider.m8695a(injector));
            case 3:
                return new SonyLauncherBadgesInterface((Context) injector.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injector), String_AppLaunchClassMethodAutoProvider.m8695a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
