package com.facebook.backgroundlocation.reporting;

import android.content.Context;
import android.content.Intent;
import com.facebook.backgroundlocation.reporting.abtest.ExperimentsForBackgroundLocationReportingModule;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.content.FacebookOnlySecureBroadcastReceiver;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.location.FbLocationContinuousListener;
import com.facebook.location.FbLocationContinuousListenerMethodAutoProvider;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationSignalDataPackage;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.common.collect.ImmutableSet;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: icon_image */
public class BackgroundLocationReportingBroadcastReceiver extends FacebookOnlySecureBroadcastReceiver {
    private static Boolean f10537m;
    @Inject
    AppStateManager f10538a;
    @Inject
    BackgroundLocationReportingNewImplAnalyticsLogger f10539b;
    @Inject
    BackgroundLocationReportingSettingsManager f10540c;
    @Inject
    BackgroundLocationReportingNewImplManager f10541d;
    @Inject
    BackgroundLocationReportingDataSaver f10542e;
    @Inject
    BackgroundLocationReportingUtils f10543f;
    @Inject
    FbLocationContinuousListener f10544g;
    @DefaultExecutorService
    @Inject
    ExecutorService f10545h;
    @Inject
    Lazy<GeofenceLocationTracker> f10546i;
    @Inject
    SecureContextHelper f10547j;
    @Inject
    FacebookOnlyIntentActionFactory f10548k;
    @Inject
    QeAccessor f10549l;

    private static <T extends InjectableComponentWithoutContext> void m11080a(Class<T> cls, T t, Context context) {
        m11081a(t, context);
    }

    public static void m11081a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BackgroundLocationReportingBroadcastReceiver) obj).m11079a(AppStateManager.a(injectorLike), BackgroundLocationReportingNewImplAnalyticsLogger.m10133a(injectorLike), BackgroundLocationReportingSettingsManager.m10123a(injectorLike), BackgroundLocationReportingNewImplManager.m10114a(injectorLike), BackgroundLocationReportingDataSaver.m11097a(injectorLike), BackgroundLocationReportingUtils.m11115b(injectorLike), FbLocationContinuousListenerMethodAutoProvider.m10147b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 4923), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), FacebookOnlyIntentActionFactory.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public BackgroundLocationReportingBroadcastReceiver() {
        super(ImmutableSet.of("BACKGROUND_LOCATION_REPORTING_SETTINGS_REQUEST_REFRESH_ACTION", "BACKGROUND_LOCATION_REPORTING_ACTION_FETCH_IS_ENABLED_FINISHED", "BACKGROUND_LOCATION_REPORTING_SETTINGS_CHANGED_ACTION", "BACKGROUND_LOCATION_REPORTING_ACTION_LOCATION_UPDATE", "BACKGROUND_LOCATION_REPORTING_ACTION_WRITE_FINISHED", "BACKGROUND_LOCATION_REPORTING_ACTION_OBTAIN_SINGLE_LOCATION_FINISHED", new String[0]));
    }

    protected final void m11087a(Context context, Intent intent, String str) {
        Class cls = BackgroundLocationReportingBroadcastReceiver.class;
        m11081a(this, context);
        if ("BACKGROUND_LOCATION_REPORTING_SETTINGS_REQUEST_REFRESH_ACTION".equals(str)) {
            m11078a(intent);
        } else if ("BACKGROUND_LOCATION_REPORTING_ACTION_FETCH_IS_ENABLED_FINISHED".equals(str)) {
            m11083b(intent);
        } else if ("BACKGROUND_LOCATION_REPORTING_SETTINGS_CHANGED_ACTION".equals(str)) {
            m11084c(intent);
        } else if ("BACKGROUND_LOCATION_REPORTING_ACTION_LOCATION_UPDATE".equals(str)) {
            m11082b(context, intent);
        } else if ("BACKGROUND_LOCATION_REPORTING_ACTION_WRITE_FINISHED".equals(str)) {
            m11085d(intent);
        } else if ("BACKGROUND_LOCATION_REPORTING_ACTION_OBTAIN_SINGLE_LOCATION_FINISHED".equals(str)) {
            m11086e(intent);
        } else {
            throw new IllegalArgumentException("Unknown action: " + str);
        }
    }

    private void m11078a(Intent intent) {
        if (intent.hasExtra("expected_location_history_setting")) {
            this.f10540c.m10129a(intent.getBooleanExtra("expected_location_history_setting", false));
            return;
        }
        throw new IllegalStateException("request refresh action did not have parameter");
    }

    private void m11083b(Intent intent) {
        this.f10540c.m10128a(BackgroundLocationReportingNewImplService.m10173b(intent));
    }

    private void m11084c(Intent intent) {
        if (intent.hasExtra("is_location_history_enabled")) {
            this.f10541d.m10121a(intent.getBooleanExtra("is_location_history_enabled", false));
            return;
        }
        throw new IllegalStateException("settings changed broadcast did not have parameter");
    }

    private void m11079a(AppStateManager appStateManager, BackgroundLocationReportingNewImplAnalyticsLogger backgroundLocationReportingNewImplAnalyticsLogger, BackgroundLocationReportingSettingsManager backgroundLocationReportingSettingsManager, BackgroundLocationReportingNewImplManager backgroundLocationReportingNewImplManager, BackgroundLocationReportingDataSaver backgroundLocationReportingDataSaver, BackgroundLocationReportingUtils backgroundLocationReportingUtils, FbLocationContinuousListener fbLocationContinuousListener, ExecutorService executorService, Lazy<GeofenceLocationTracker> lazy, SecureContextHelper secureContextHelper, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, QeAccessor qeAccessor) {
        this.f10538a = appStateManager;
        this.f10539b = backgroundLocationReportingNewImplAnalyticsLogger;
        this.f10540c = backgroundLocationReportingSettingsManager;
        this.f10541d = backgroundLocationReportingNewImplManager;
        this.f10542e = backgroundLocationReportingDataSaver;
        this.f10543f = backgroundLocationReportingUtils;
        this.f10544g = fbLocationContinuousListener;
        this.f10545h = executorService;
        this.f10546i = lazy;
        this.f10547j = secureContextHelper;
        this.f10548k = facebookOnlyIntentActionFactory;
        this.f10549l = qeAccessor;
    }

    private void m11082b(Context context, Intent intent) {
        boolean z = false;
        ImmutableLocation a = this.f10544g.mo784a(intent);
        if (a != null) {
            this.f10539b.m10140a(a);
            if (f10537m == null) {
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.b;
                if (GoogleApiAvailability.a(context) == 0 && this.f10549l.a(ExperimentsForBackgroundLocationReportingModule.f9740j, false)) {
                    z = true;
                }
                f10537m = Boolean.valueOf(z);
            }
            if (f10537m.booleanValue()) {
                this.f10547j.c(BackgroundLocationReportingGcmUploadSchedulerService.a(context, this.f10548k, a), context);
            } else {
                ExecutorDetour.a(this.f10545h, new 1(this, context, a), -927874471);
            }
        }
    }

    private void m11085d(Intent intent) {
        this.f10542e.m11100a(BackgroundLocationReportingNewImplService.m10175d(intent), BackgroundLocationReportingNewImplService.m10174c(intent));
    }

    private void m11086e(Intent intent) {
        this.f10542e.m11102a(new LocationSignalDataPackage(BackgroundLocationReportingNewImplService.m10177f(intent), Boolean.valueOf(this.f10538a.l())), BackgroundLocationReportingNewImplService.m10176e(intent));
    }
}
