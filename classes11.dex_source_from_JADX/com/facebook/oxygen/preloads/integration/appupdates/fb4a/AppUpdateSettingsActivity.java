package com.facebook.oxygen.preloads.integration.appupdates.fb4a;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.base.activity.UsesSimpleStringTitle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.katana.settings.SettingsHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.oxygen.preloads.integration.appupdates.AppUpdateSettings;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkPresence;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkPresenceMethodAutoProvider;
import com.facebook.oxygen.preloads.sdk.firstparty.settings.FirstPartySettings;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: textShadowOffset */
public class AppUpdateSettingsActivity extends FbPreferenceActivity implements UsesSimpleStringTitle {
    public static final PrefKey f1080a;
    public static final PrefKey f1081i;
    public static final PrefKey f1082j = ((PrefKey) f1080a.a("fb4a_auto_update_notification_enabled"));
    public static final PrefKey f1083k = ((PrefKey) f1080a.a("fb4a_auto_update_complete_notification_enabled"));
    @Inject
    SettingsHelper f1084b;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f1085c;
    @Inject
    @ForUiThread
    ExecutorService f1086d;
    @Inject
    AppUpdateSettings f1087e;
    @Inject
    AbstractFbErrorReporter f1088f;
    @Inject
    AnalyticsLogger f1089g;
    @Inject
    PreloadSdkPresence f1090h;
    public FirstPartySettings f1091l;
    public PreferenceScreen f1092m;

    /* compiled from: textShadowOffset */
    class C01571 implements Callable<FirstPartySettings> {
        final /* synthetic */ AppUpdateSettingsActivity f1078a;

        C01571(AppUpdateSettingsActivity appUpdateSettingsActivity) {
            this.f1078a = appUpdateSettingsActivity;
        }

        public Object call() {
            return FirstPartySettings.m1423a(this.f1078a);
        }
    }

    /* compiled from: textShadowOffset */
    class C01582 implements FutureCallback<FirstPartySettings> {
        final /* synthetic */ AppUpdateSettingsActivity f1079a;

        C01582(AppUpdateSettingsActivity appUpdateSettingsActivity) {
            this.f1079a = appUpdateSettingsActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f1079a.f1091l = (FirstPartySettings) obj;
            this.f1079a.f1087e.m1407a(this.f1079a.f1091l, this.f1079a.f1092m, AppUpdateSettingsActivity.f1081i, AppUpdateSettingsActivity.f1082j, AppUpdateSettingsActivity.f1083k);
        }

        public void onFailure(Throwable th) {
            this.f1079a.f1088f.a("omvp_app_updates", th);
            this.f1079a.f1087e.m1407a(null, this.f1079a.f1092m, AppUpdateSettingsActivity.f1081i, AppUpdateSettingsActivity.f1082j, AppUpdateSettingsActivity.f1083k);
            AppUpdateSettings appUpdateSettings = this.f1079a.f1087e;
            PreferenceScreen preferenceScreen = this.f1079a.f1092m;
            appUpdateSettings.f1068l = new Preference(appUpdateSettings.f1058b);
            appUpdateSettings.f1068l.setLayoutResource(2130906355);
            appUpdateSettings.f1068l.setSelectable(false);
            appUpdateSettings.f1068l.setShouldDisableView(true);
            appUpdateSettings.f1068l.setOrder(1);
            if (2130837658 > null) {
                appUpdateSettings.f1068l.setIcon(2130837658);
            }
            preferenceScreen.addPreference(appUpdateSettings.f1068l);
            appUpdateSettings.f1066j.setEnabled(false);
            appUpdateSettings.f1069m.setEnabled(false);
            appUpdateSettings.f1070n.setEnabled(false);
        }
    }

    private static <T extends Context> void m1411a(Class<T> cls, T t) {
        m1412a((Object) t, (Context) t);
    }

    public static void m1412a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AppUpdateSettingsActivity) obj).m1410a(SettingsHelper.b(fbInjector), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), new AppUpdateSettings((Context) fbInjector.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector)), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), PreloadSdkPresenceMethodAutoProvider.b(fbInjector));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("appUpdates/");
        f1080a = prefKey;
        f1081i = (PrefKey) prefKey.a("fb4a_auto_updates_enabled");
    }

    protected final void m1419a(Bundle bundle) {
        super.a(bundle);
        requestWindowFeature(1);
    }

    public final void m1420c(Bundle bundle) {
        super.c(bundle);
        Class cls = AppUpdateSettingsActivity.class;
        m1412a((Object) this, (Context) this);
        this.f1092m = getPreferenceManager().createPreferenceScreen(this);
        this.f1084b.a(this);
        setPreferenceScreen(this.f1092m);
        Futures.a(this.f1085c.a(new C01571(this)), new C01582(this), this.f1086d);
    }

    private void m1410a(SettingsHelper settingsHelper, ListeningExecutorService listeningExecutorService, ExecutorService executorService, AppUpdateSettings appUpdateSettings, AbstractFbErrorReporter abstractFbErrorReporter, AnalyticsLogger analyticsLogger, PreloadSdkPresence preloadSdkPresence) {
        this.f1084b = settingsHelper;
        this.f1085c = listeningExecutorService;
        this.f1086d = executorService;
        this.f1087e = appUpdateSettings;
        this.f1088f = abstractFbErrorReporter;
        this.f1089g = analyticsLogger;
        this.f1090h = preloadSdkPresence;
    }

    public final String m1418a() {
        return null;
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1190451256);
        super.onStart();
        this.f1084b.b(this);
        this.f1084b.a(2131241721);
        m1413a("app_update_settings_active");
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 951922892, a);
    }

    private void m1413a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.b("application_name", getPackageName());
        honeyClientEvent.a("appmanager_version", this.f1090h.a());
        this.f1089g.a(honeyClientEvent);
    }
}
