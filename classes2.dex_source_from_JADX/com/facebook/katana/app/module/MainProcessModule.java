package com.facebook.katana.app.module;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import com.facebook.analytics.ConnectionStatusLogger;
import com.facebook.analytics.config.IsQualityChangeLoggingEnabled;
import com.facebook.analytics.util.LoggerUtils;
import com.facebook.api.feed.annotation.IsErrorReporterLoggingForFeedUnitCollectionEnabled;
import com.facebook.backgroundlocation.nux.IsBackgroundLocationNuxAvailable;
import com.facebook.bugreporter.BugReporterPrefKeys;
import com.facebook.bugreporter.annotations.InternalSettingsActivity;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.process.ProcessName;
import com.facebook.common.util.TriState;
import com.facebook.config.application.ApiConnectionType;
import com.facebook.config.server.ServerConfig;
import com.facebook.contacts.protocol.annotations.IsNearbyInChatContextEnabled;
import com.facebook.feed.annotations.IsAlwaysPlayVideoUnmutedEnabled;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.inject.ProviderMethod;
import com.facebook.ipc.legacykeyvalue.UserValuesContract;
import com.facebook.katana.InternSettingsActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.activity.FacebookActivityDelegateImpl;
import com.facebook.katana.annotations.IsLoginWithPhoneNumberSupported;
import com.facebook.katana.annotations.UserValuesManagerBackend;
import com.facebook.katana.app.module.common.FbandroidProcessName;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.katana.provider.legacykeyvalue.KeyValueStore;
import com.facebook.katana.provider.legacykeyvalue.LegacyKeyValueStore;
import com.facebook.katana.ringtone.RingtoneUtils;
import com.facebook.katana.service.AppSession;
import com.facebook.languages.switchercommonex.PersistentLocale;
import com.facebook.messaging.annotations.IsGlobalNotificationPreferenceEnabled;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.payments.decorator.PaymentsAppThemeResourceId;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ui.images.base.ImageCacheReportingPrefix;
import com.facebook.video.commercialbreak.IsCommercialBreakDebugToastsEnabled;
import com.facebook.video.commercialbreak.prefs.CommercialBreakPreferencesKeys;
import com.facebook.video.engine.VideoLoggingLevel;
import com.facebook.video.engine.VideoLoggingUtils.VerboseLoggingParam;
import com.facebook.video.player.IsVideoSpecDisplayEnabled;
import com.facebook.video.videohome.annotations.IsVideoHomePlayVideoUnmutedEnabled;
import com.facebook.video.videohome.prefetching.IsVideoHomeForcePrefetchEnabled;
import com.facebook.video.videohome.prefetching.IsVideoHomePrefetchToastEnabled;
import com.facebook.webview.CustomUserAgent;
import java.util.Locale;
import javax.inject.Provider;

@InjectorModule
/* compiled from: time_to_connection_quality_reset */
public class MainProcessModule extends AbstractLibraryModule {

    /* compiled from: time_to_connection_quality_reset */
    public final class C03331 {
        public final boolean f7838a = this.f7839b.mo596a(ExperimentsForHttpQeModule.aA, true);
        final /* synthetic */ QeAccessor f7839b;

        C03331(QeAccessor qeAccessor) {
            this.f7839b = qeAccessor;
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    public static Boolean m4790b(FbSharedPreferences fbSharedPreferences, Provider<TriState> provider, Provider<TriState> provider2) {
        if (BuildConstants.i) {
            return Boolean.valueOf(true);
        }
        if (provider.get() == TriState.YES || provider2.get() == TriState.YES) {
            return Boolean.valueOf(fbSharedPreferences.mo286a(BugReporterPrefKeys.c, true));
        }
        return Boolean.valueOf(false);
    }

    @ProviderMethod
    static Locale m4787a(PersistentLocale persistentLocale) {
        return persistentLocale.mo674a();
    }

    @ProviderMethod
    public static C03331 m4778a(QeAccessor qeAccessor) {
        return new C03331(qeAccessor);
    }

    @ProviderMethod
    @IsGlobalNotificationPreferenceEnabled
    public static Boolean m4783a(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(NotificationsPreferenceConstants.i, true));
    }

    @ProviderMethod
    @ImageCacheReportingPrefix
    public static String m4785a(ProcessName processName) {
        return FbandroidProcessName.convertProcessNameToProcessEnum(processName).toString().toLowerCase(Locale.ENGLISH);
    }

    @ProviderMethod
    @IsBackgroundLocationNuxAvailable
    public static Boolean m4791c() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @IsErrorReporterLoggingForFeedUnitCollectionEnabled
    public static Boolean m4794d() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @IsNearbyInChatContextEnabled
    public static Boolean m4796e() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @IsQualityChangeLoggingEnabled
    public static Boolean m4798f() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @ContextScoped
    static FacebookActivityDelegate m4777a(Activity activity) {
        return new FacebookActivityDelegateImpl(activity);
    }

    @ProviderMethod
    static AppSession m4782a(Context context) {
        return AppSession.m8853b(context, false);
    }

    @ProviderMethod
    public static RingtoneUtils m4781a(@ForAppContext Context context, MoreFileUtils moreFileUtils) {
        return new RingtoneUtils(context, context.getContentResolver(), context.getAssets(), moreFileUtils);
    }

    @ProviderMethod
    @UserValuesManagerBackend
    public static KeyValueStore m4779a(FbSharedPreferences fbSharedPreferences, LegacyKeyValueStore legacyKeyValueStore) {
        return new KeyValueStore(fbSharedPreferences, FbandroidPrefKeys.f19411c, legacyKeyValueStore);
    }

    @ProviderMethod
    @UserValuesManagerBackend
    static LegacyKeyValueStore m4780a(@NeedsApplicationInjector ContentResolver contentResolver, AbstractFbErrorReporter abstractFbErrorReporter) {
        return new LegacyKeyValueStore(contentResolver, UserValuesContract.b, UserValuesContract.c, "name", "value", abstractFbErrorReporter);
    }

    @ProviderMethod
    @PaymentsAppThemeResourceId
    public static Integer m4801g() {
        return Integer.valueOf(2131625233);
    }

    @ProviderMethod
    @IsVideoSpecDisplayEnabled
    static Boolean m4789b(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(FbandroidPrefKeys.f19415g, false));
    }

    @ProviderMethod
    @IsLoginWithPhoneNumberSupported
    public static Boolean m4784a(Boolean bool) {
        return Boolean.valueOf(!bool.booleanValue());
    }

    @ProviderMethod
    @IsAlwaysPlayVideoUnmutedEnabled
    public static Boolean m4792c(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(FbandroidPrefKeys.f19416h, false));
    }

    @ProviderMethod
    @IsVideoHomePlayVideoUnmutedEnabled
    public static Boolean m4795d(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(FbandroidPrefKeys.f19416h, false));
    }

    @ProviderMethod
    @VideoLoggingLevel
    public static String m4797e(FbSharedPreferences fbSharedPreferences) {
        return fbSharedPreferences.mo278a(FbandroidPrefKeys.f19417i, VerboseLoggingParam.NONE.toString());
    }

    @ProviderMethod
    @IsVideoHomeForcePrefetchEnabled
    public static Boolean m4799f(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(FbandroidPrefKeys.f19418j, false));
    }

    @ProviderMethod
    @IsVideoHomePrefetchToastEnabled
    public static Boolean m4800g(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(FbandroidPrefKeys.f19419k, false));
    }

    @ProviderMethod
    @CustomUserAgent
    public static String m4786a(ServerConfig serverConfig) {
        return serverConfig.mo1357d();
    }

    @ProviderMethod
    @InternalSettingsActivity
    static ComponentName m4788b(Context context) {
        return new ComponentName(context, InternSettingsActivity.class);
    }

    @ProviderMethod
    @ApiConnectionType
    public static String m4793c(Context context) {
        ConnectionStatusLogger b = LoggerUtils.m12201b(context);
        if (b != null) {
            return b.m12209b();
        }
        return null;
    }

    @ProviderMethod
    @IsCommercialBreakDebugToastsEnabled
    public static Boolean m4802h(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(CommercialBreakPreferencesKeys.a, false));
    }
}
