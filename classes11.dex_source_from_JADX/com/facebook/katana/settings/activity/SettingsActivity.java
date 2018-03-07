package com.facebook.katana.settings.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.auth.module.TriState_IsMeUserTrustedTesterGatekeeperAutoProvider;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.base.activity.UsesSimpleStringTitle;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.growth.Boolean_IsPhoneNumberAcquisitionEnabledGatekeeperAutoProvider;
import com.facebook.growth.addcontactpoint.AddContactpointActivity;
import com.facebook.growth.friendfinder.ContinuousContactsUploadPreference;
import com.facebook.http.onion.prefs.OnionUtils;
import com.facebook.http.onion.ui.TorSettingsPreference;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.katana.FacebookOverTorSettingsActivity;
import com.facebook.katana.InternSettingsActivity;
import com.facebook.katana.NotificationSettingsActivity;
import com.facebook.katana.app.module.C1226xb6e0d474;
import com.facebook.katana.settings.SettingsHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.notifications.abtest.NotificationsJewelExperimentController;
import com.facebook.orca.prefs.preferences.MobileOnlineAvailabilityPreference;
import com.facebook.oxygen.preloads.integration.appupdates.fb4a.AppUpdateSettingsActivity;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkPresence;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkPresenceMethodAutoProvider;
import com.facebook.oxygen.preloads.sdk.firstparty.settings.FirstPartySettings;
import com.facebook.photos.prefs.PhotosPrefKeys;
import com.facebook.photos.upload.abtest.ExperimentsForPhotosUploadModule;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.sounds.fb4a.prefs.SoundsPrefKeys;
import com.facebook.transliteration.TransliterateAnalyticsLogger;
import com.facebook.transliteration.TransliterationConfig;
import com.facebook.ui.browser.BrowserDisabledPreference;
import com.facebook.ui.browser.TriState_IsInAppBrowserEnabledMethodAutoProvider;
import com.facebook.ui.browser.prefs.BrowserDataPreference;
import com.facebook.vault.prefs.SyncModePref;
import com.facebook.vault.service.VaultHelpers;
import com.facebook.vault.ui.VaultSettingsActivity;
import com.facebook.video.abtest.TriState_VideoInlineGatekeeperAutoProvider;
import com.facebook.video.settings.VideoAutoPlaySettingsActivity;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.facebook.video.settings.VideoAutoplaySettingsServerMigrationHelper;
import com.facebook.video.settings.VideoPrefs;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import com.facebook.widget.prefs.InstanceStatePreference;
import com.facebook.widget.prefs.OrcaCheckBoxPreference;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UriMatchPatterns
/* compiled from: writes */
public class SettingsActivity extends FbPreferenceActivity implements AnalyticsActivity, UsesSimpleStringTitle {
    @VisibleForTesting
    static boolean f97a = false;
    private NotificationsJewelExperimentController f98A;
    private List<InstanceStatePreference> f99B = Lists.a();
    private PreferenceScreen f100C;
    public FbSharedPreferences f101b;
    private QeAccessor f102c;
    private boolean f103d;
    private boolean f104e;
    private boolean f105f;
    private TriState f106g;
    private TriState f107h;
    private boolean f108i;
    public AnalyticsLogger f109j;
    private SyncModePref f110k;
    private VaultHelpers f111l;
    private ViewerContext f112m;
    private ContinuousContactsUploadPreference f113n;
    private BrowserDataPreference f114o;
    private MobileOnlineAvailabilityPreference f115p;
    public SecureContextHelper f116q;
    public SettingsHelper f117r;
    private VideoAutoplaySettingsServerMigrationHelper f118s;
    private VideoAutoPlaySettingsChecker f119t;
    private PreloadSdkPresence f120u;
    private ListeningExecutorService f121v;
    private ExecutorService f122w;
    private TransliterationConfig f123x;
    public TransliterateAnalyticsLogger f124y;
    private OnionUtils f125z;

    /* compiled from: writes */
    class C00051 implements OnPreferenceChangeListener {
        final /* synthetic */ SettingsActivity f85a;

        C00051(SettingsActivity settingsActivity) {
            this.f85a = settingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("chat_bar_online_status_change");
            honeyClientEvent.c = "chat_bar";
            this.f85a.f109j.c(honeyClientEvent.a("state", (Boolean) obj).b("source", "settings"));
            return true;
        }
    }

    /* compiled from: writes */
    class C00062 implements OnPreferenceChangeListener {
        final /* synthetic */ SettingsActivity f86a;

        C00062(SettingsActivity settingsActivity) {
            this.f86a = settingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            this.f86a.f117r.a(preference, obj);
            return true;
        }
    }

    /* compiled from: writes */
    class C00073 implements OnPreferenceChangeListener {
        final /* synthetic */ SettingsActivity f87a;

        C00073(SettingsActivity settingsActivity) {
            this.f87a = settingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("browser_disabled_setting_change");
            honeyClientEvent.c = "webview";
            this.f87a.f109j.c(honeyClientEvent.a("state", (Boolean) obj).b("source", "settings"));
            return true;
        }
    }

    /* compiled from: writes */
    class C00084 implements OnPreferenceChangeListener {
        final /* synthetic */ SettingsActivity f88a;

        C00084(SettingsActivity settingsActivity) {
            this.f88a = settingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("hi_res_photo_upload_setting_change");
            honeyClientEvent.c = "photo";
            this.f88a.f109j.c(honeyClientEvent.a("state", obj));
            return true;
        }
    }

    /* compiled from: writes */
    class C00106 implements Callable<FirstPartySettings> {
        final /* synthetic */ SettingsActivity f91a;

        C00106(SettingsActivity settingsActivity) {
            this.f91a = settingsActivity;
        }

        public Object call() {
            return FirstPartySettings.m1423a(this.f91a);
        }
    }

    /* compiled from: writes */
    class C00128 implements OnPreferenceClickListener {
        final /* synthetic */ SettingsActivity f95a;

        C00128(SettingsActivity settingsActivity) {
            this.f95a = settingsActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f95a.f101b.edit().putBoolean(VideoPrefs.i, true).commit();
            return false;
        }
    }

    /* compiled from: writes */
    class C00139 implements OnPreferenceClickListener {
        final /* synthetic */ SettingsActivity f96a;

        C00139(SettingsActivity settingsActivity) {
            this.f96a = settingsActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f96a.f116q.a(new Intent(this.f96a, NotificationSettingsActivity.class), this.f96a);
            return true;
        }
    }

    private static <T extends Context> void m85a(Class<T> cls, T t) {
        m86a((Object) t, (Context) t);
    }

    public static void m86a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SettingsActivity) obj).m84a((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), SyncModePref.a(fbInjector), VaultHelpers.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), ViewerContextMethodAutoProvider.a(fbInjector), Boolean_IsPhoneNumberAcquisitionEnabledGatekeeperAutoProvider.a(fbInjector), C1226xb6e0d474.m10796a(fbInjector), TriState_VideoInlineGatekeeperAutoProvider.a(fbInjector), OnionUtils.a(fbInjector), ContinuousContactsUploadPreference.a(fbInjector), BrowserDataPreference.a(fbInjector), MobileOnlineAvailabilityPreference.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), SettingsHelper.a(fbInjector), VideoAutoplaySettingsServerMigrationHelper.a(fbInjector), VideoAutoPlaySettingsChecker.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), PreloadSdkPresenceMethodAutoProvider.a(fbInjector), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), TransliterationConfig.a(fbInjector), TransliterateAnalyticsLogger.a(fbInjector), TriState_IsMeUserTrustedTesterGatekeeperAutoProvider.a(fbInjector), TriState_IsMeUserAnEmployeeMethodAutoProvider.a(fbInjector), TriState_IsInAppBrowserEnabledMethodAutoProvider.a(fbInjector), NotificationsJewelExperimentController.a(fbInjector));
    }

    protected final void m110c(Bundle bundle) {
        super.c(bundle);
        Class cls = SettingsActivity.class;
        m86a((Object) this, (Context) this);
        this.f100C = getPreferenceManager().createPreferenceScreen(this);
        this.f117r.a(this);
        setPreferenceScreen(this.f100C);
        m83a(this.f100C);
        m94d(bundle);
    }

    @Inject
    private void m84a(FbSharedPreferences fbSharedPreferences, SyncModePref syncModePref, VaultHelpers vaultHelpers, AnalyticsLogger analyticsLogger, ViewerContext viewerContext, Boolean bool, TriState triState, TriState triState2, OnionUtils onionUtils, ContinuousContactsUploadPreference continuousContactsUploadPreference, BrowserDataPreference browserDataPreference, MobileOnlineAvailabilityPreference mobileOnlineAvailabilityPreference, SecureContextHelper secureContextHelper, SettingsHelper settingsHelper, VideoAutoplaySettingsServerMigrationHelper videoAutoplaySettingsServerMigrationHelper, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, QeAccessor qeAccessor, PreloadSdkPresence preloadSdkPresence, ListeningExecutorService listeningExecutorService, ExecutorService executorService, TransliterationConfig transliterationConfig, TransliterateAnalyticsLogger transliterateAnalyticsLogger, TriState triState3, TriState triState4, TriState triState5, NotificationsJewelExperimentController notificationsJewelExperimentController) {
        this.f101b = fbSharedPreferences;
        this.f110k = syncModePref;
        this.f111l = vaultHelpers;
        this.f109j = analyticsLogger;
        this.f112m = viewerContext;
        this.f103d = bool.booleanValue();
        this.f104e = triState.asBoolean(false);
        this.f105f = triState2.asBoolean(true);
        this.f125z = onionUtils;
        this.f113n = continuousContactsUploadPreference;
        this.f114o = browserDataPreference;
        this.f115p = mobileOnlineAvailabilityPreference;
        this.f116q = secureContextHelper;
        this.f117r = settingsHelper;
        this.f118s = videoAutoplaySettingsServerMigrationHelper;
        this.f119t = videoAutoPlaySettingsChecker;
        this.f102c = qeAccessor;
        this.f120u = preloadSdkPresence;
        this.f121v = listeningExecutorService;
        this.f122w = executorService;
        this.f123x = transliterationConfig;
        this.f124y = transliterateAnalyticsLogger;
        this.f106g = triState3;
        this.f107h = triState4;
        this.f108i = triState5.asBoolean(false);
        this.f98A = notificationsJewelExperimentController;
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 856884758);
        super.onStart();
        this.f117r.b(this);
        this.f117r.a(2131236506);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1525364515, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 503383756);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.removeAll();
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1760986887, a);
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -919937524);
        super.onResume();
        Preference findPreference = findPreference("video_autoplay");
        if (findPreference != null) {
            VideoAutoplaySettingsServerMigrationHelper videoAutoplaySettingsServerMigrationHelper = this.f118s;
            VideoAutoplaySettingsServerMigrationHelper videoAutoplaySettingsServerMigrationHelper2 = this.f118s;
            findPreference.setSummary(videoAutoplaySettingsServerMigrationHelper.a(videoAutoplaySettingsServerMigrationHelper2.a(videoAutoplaySettingsServerMigrationHelper2.f, this.f101b)));
        }
        m80a(findPreference("vault_sync_mode"));
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -989494587, a);
    }

    private void m83a(PreferenceGroup preferenceGroup) {
        m103g(preferenceGroup);
        m92c(preferenceGroup);
        m96d(preferenceGroup);
        m99e(preferenceGroup);
        m101f(preferenceGroup);
        this.f117r.a(preferenceGroup);
    }

    private void m89b(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setLayoutResource(2130905056);
        preferenceGroup.addPreference(preference);
    }

    private Preference m80a(Preference preference) {
        if (!this.f111l.a() || preference == null) {
            return null;
        }
        Intent intent = new Intent(this, VaultSettingsActivity.class);
        intent.putExtra("tab_to_show", "sync");
        intent.putExtra("nux_ref", "pref");
        preference.setSummary(m79a(this.f110k.a()));
        preference.setIntent(intent);
        return preference;
    }

    private static int m79a(String str) {
        if (str.equals("MOBILE_RADIO")) {
            return 2131234307;
        }
        if (str.equals("WIFI_ONLY")) {
            return 2131234308;
        }
        return 2131234310;
    }

    private void m92c(PreferenceGroup preferenceGroup) {
        PreferenceCategory preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle(2131236513);
        preferenceGroup.addPreference(preferenceCategory);
        m107k(preferenceCategory);
        m88b(preferenceCategory);
        m91c(preferenceCategory);
        m98e(preferenceCategory);
        m100f(preferenceCategory);
        m106j(preferenceCategory);
        m102g(preferenceCategory);
        m105i(preferenceCategory);
        m104h(preferenceCategory);
        m89b(preferenceGroup);
    }

    private void m96d(PreferenceGroup preferenceGroup) {
        if (this.f111l.a() && !"OFF".equals(this.f110k.a())) {
            PreferenceCategory preferenceCategory = new PreferenceCategory(this);
            preferenceCategory.setTitle(2131236514);
            preferenceGroup.addPreference(preferenceCategory);
            m95d(preferenceCategory);
            m89b(preferenceGroup);
        }
    }

    private void m99e(PreferenceGroup preferenceGroup) {
        PreferenceCategory preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle(2131236457);
        preferenceGroup.addPreference(preferenceCategory);
        m82a(preferenceCategory);
    }

    private void m82a(PreferenceCategory preferenceCategory) {
        preferenceCategory.addPreference(this.f115p);
        this.f115p.setOnPreferenceChangeListener(new C00051(this));
    }

    private void m88b(PreferenceCategory preferenceCategory) {
        OrcaCheckBoxPreference a = this.f117r.a(this, SoundsPrefKeys.b, 2131236135, 2131236137, 2131236136, true);
        preferenceCategory.addPreference(a);
        a.setOnPreferenceChangeListener(new C00062(this));
    }

    private void m91c(PreferenceCategory preferenceCategory) {
        if (this.f104e) {
            preferenceCategory.addPreference(this.f113n);
        }
    }

    private void m95d(PreferenceCategory preferenceCategory) {
        Preference a = m80a(getPreferenceManager().createPreferenceScreen(this));
        if (a != null) {
            a.setKey("vault_sync_mode");
            a.setTitle(2131236531);
            preferenceCategory.addPreference(a);
        }
    }

    private void m98e(PreferenceCategory preferenceCategory) {
        if (this.f108i) {
            BrowserDisabledPreference browserDisabledPreference = new BrowserDisabledPreference(this, 2131236528, 2131236860, 2131236859);
            browserDisabledPreference.setOnPreferenceChangeListener(new C00073(this));
            preferenceCategory.addPreference(browserDisabledPreference);
        }
    }

    private void m100f(PreferenceCategory preferenceCategory) {
        if (this.f102c.a(ExperimentsForPhotosUploadModule.p, false)) {
            CheckBoxOrSwitchPreference checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(this);
            checkBoxOrSwitchPreference.setTitle(2131236500);
            checkBoxOrSwitchPreference.setSummaryOff(2131236501);
            checkBoxOrSwitchPreference.setSummaryOn(2131236502);
            checkBoxOrSwitchPreference.setDefaultValue(Boolean.valueOf(false));
            checkBoxOrSwitchPreference.a(PhotosPrefKeys.j);
            checkBoxOrSwitchPreference.setOnPreferenceChangeListener(new C00084(this));
            preferenceCategory.addPreference(checkBoxOrSwitchPreference);
        }
    }

    private void m102g(PreferenceCategory preferenceCategory) {
        if (this.f123x.c.a(759, false)) {
            final CheckBoxOrSwitchPreference checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(this);
            checkBoxOrSwitchPreference.setTitle(2131236503);
            checkBoxOrSwitchPreference.setSummaryOff(2131236505);
            checkBoxOrSwitchPreference.setSummaryOn(2131236504);
            checkBoxOrSwitchPreference.a(TransliterationConfig.b);
            checkBoxOrSwitchPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
                final /* synthetic */ SettingsActivity f90b;

                public boolean onPreferenceChange(Preference preference, Object obj) {
                    this.f90b.f124y.a(Boolean.valueOf(checkBoxOrSwitchPreference.isChecked()), (Boolean) obj);
                    return true;
                }
            });
            preferenceCategory.addPreference(checkBoxOrSwitchPreference);
        }
    }

    private void m104h(PreferenceCategory preferenceCategory) {
        if (this.f108i) {
            this.f114o.setTitle(2131236529);
            this.f114o.d = 2131624657;
            preferenceCategory.addPreference(this.f114o);
        }
    }

    private void m105i(final PreferenceCategory preferenceCategory) {
        if (this.f120u.a(1)) {
            final Preference preference = new Preference(this);
            preference.setTitle(2131236530);
            preference.setEnabled(false);
            preference.setIntent(new Intent(this, AppUpdateSettingsActivity.class));
            preferenceCategory.addPreference(preference);
            Futures.a(this.f121v.a(new C00106(this)), new FutureCallback<FirstPartySettings>(this) {
                final /* synthetic */ SettingsActivity f94c;

                public void onSuccess(@Nullable Object obj) {
                    if (((FirstPartySettings) obj).f1095c) {
                        preference.setEnabled(true);
                    } else {
                        preferenceCategory.removePreference(preference);
                    }
                }

                public void onFailure(Throwable th) {
                    preferenceCategory.removePreference(preference);
                }
            }, this.f122w);
        }
    }

    private void m106j(PreferenceCategory preferenceCategory) {
        if (this.f105f) {
            Preference preference = new Preference(this);
            preference.setKey("video_autoplay");
            preference.setTitle(getString(2131236527));
            preference.setSummary(this.f118s.a(this.f119t.b()));
            preference.setIntent(new Intent(this, VideoAutoPlaySettingsActivity.class));
            preferenceCategory.addPreference(preference);
            preference.setOnPreferenceClickListener(new C00128(this));
        }
    }

    private void m107k(PreferenceCategory preferenceCategory) {
        if (!this.f98A.k() && !this.f98A.a.a(ExperimentsForNotificationsAbtestModule.z, false)) {
            Preference preference = new Preference(this);
            preference.setTitle(2131236461);
            preferenceCategory.addPreference(preference);
            preference.setOnPreferenceClickListener(new C00139(this));
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        for (InstanceStatePreference instanceStatePreference : this.f99B) {
            Bundle a = instanceStatePreference.a();
            if (a != null) {
                bundle.putBundle(instanceStatePreference.getClass().getName(), a);
            }
        }
    }

    private void m94d(@Nullable Bundle bundle) {
        if (bundle != null) {
            for (InstanceStatePreference instanceStatePreference : this.f99B) {
                bundle.getBundle(instanceStatePreference.getClass().getName());
            }
        }
    }

    private void m101f(PreferenceGroup preferenceGroup) {
        m89b(preferenceGroup);
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle(2131236519);
        preferenceGroup.addPreference(preferenceCategory);
        if (this.f103d) {
            Intent intent = new Intent(this, AddContactpointActivity.class);
            intent.putExtra("launch_point", "settings_phone_acquisition");
            Preference preference = new Preference(this);
            preference.setTitle(2131236433);
            preference.setSummary(2131236434);
            preference.setIntent(intent);
            preferenceCategory.addPreference(preference);
        }
        m108l(preferenceCategory);
        if (preferenceCategory.getPreferenceCount() == 0) {
            preferenceGroup.removePreference(preferenceCategory);
        }
    }

    private void m108l(PreferenceCategory preferenceCategory) {
        if (this.f125z.g() && this.f125z.a()) {
            TorSettingsPreference torSettingsPreference = new TorSettingsPreference(this);
            preferenceCategory.addPreference(torSettingsPreference);
            torSettingsPreference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
                final /* synthetic */ SettingsActivity f84a;

                {
                    this.f84a = r1;
                }

                public boolean onPreferenceClick(Preference preference) {
                    this.f84a.f116q.a(new Intent(this.f84a, FacebookOverTorSettingsActivity.class), this.f84a);
                    return true;
                }
            });
        }
    }

    private void m103g(PreferenceGroup preferenceGroup) {
        if (!f97a) {
            String a;
            Object obj;
            FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(FbInjector.get(this));
            if (fbSharedPreferences.a()) {
                a = fbSharedPreferences.a(InternalHttpPrefKeys.r, "facebook.com");
            } else {
                a = "facebook.com";
            }
            if (a.equals("facebook.com") || a.equals("beta.facebook.com") || a.equals("latest.facebook.com")) {
                obj = null;
            } else {
                obj = 1;
            }
            if (!(obj != null || TriState.YES == this.f106g || TriState.YES == this.f107h)) {
                return;
            }
        }
        f97a = true;
        Preference preference = new Preference(this);
        preference.setTitle("Intern settings");
        preference.setSummary("Internal settings for debugging");
        preference.setIntent(new Intent(this, InternSettingsActivity.class));
        preferenceGroup.addPreference(preference);
        m89b(preferenceGroup);
    }

    public final String m109a() {
        return null;
    }

    public final String am_() {
        return "app_settings";
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        if (this.f117r != null) {
            SettingsHelper.a(this);
        }
    }

    public void finish() {
        super.finish();
        if (this.f117r != null) {
            SettingsHelper.b(this);
        }
    }
}
