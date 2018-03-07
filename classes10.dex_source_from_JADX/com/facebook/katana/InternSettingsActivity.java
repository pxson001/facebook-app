package com.facebook.katana;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.abtest.gkprefs.GkSettingsListActivity;
import com.facebook.abtest.qe.IProvidePreferences_ForQuickExperimentMethodAutoProvider;
import com.facebook.abtest.qe.annotations.ForQuickExperiment;
import com.facebook.acra.ACRA;
import com.facebook.aldrin.prefs.LaunchAldrinInternSettingsPreference;
import com.facebook.aldrin.status.annotations.IsAldrinEnabled;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.ClientPeriodicEventReporterManager;
import com.facebook.analytics.NavigationToastProvider;
import com.facebook.analytics.internal.AnalyticsBatchIntervalPreference;
import com.facebook.analytics.interncontactsupload.AnalyticsContactsUploadIntervalPreference;
import com.facebook.analytics.interndeviceinfo.AnalyticsDeviceInfoIntervalPreference;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.client.BookmarkClient;
import com.facebook.breakpad.BreakpadManager;
import com.facebook.bugreporter.BugReporterPrefKeys;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.diagnostics.NetAccessLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.internalprefhelpers.ConfigurationRefreshUpdaterDialogFragment;
import com.facebook.common.internalprefhelpers.GkRefresherTask;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.composer.tip.ComposerTipPreference;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.contactlogs.ContactLogsUploadRunner;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.contacts.ccu.internsetting.ContactsUploadInternSettingHelper;
import com.facebook.contacts.upload.ContactsUploadRunner;
import com.facebook.contacts.upload.ContactsUploadVisibility;
import com.facebook.contacts.upload.ContinuousContactUploadClient;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.connection.DataConnectionOverlayPreference;
import com.facebook.debug.droidinspector.DroidInspectorPreference;
import com.facebook.debug.feed.ClientSideRankingIndicatorPreference;
import com.facebook.debug.feed.CommentCacheStatePreference;
import com.facebook.debug.feed.FreshFeedOverlayPreference;
import com.facebook.debug.feed.HomeStoriesOverlayPreference;
import com.facebook.debug.monkey.MonkeyMode;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.debug.pref.DebugPreferencesFactory;
import com.facebook.debug.pref.DebugPreferencesFactory.2;
import com.facebook.debug.pref.DebugPreferencesFactory.3;
import com.facebook.debug.pref.DebugPreferencesFactory.4;
import com.facebook.debug.pref.NonEmployeeModePreference;
import com.facebook.debug.uitools.FBUiAdoptionPreference;
import com.facebook.debug.uitools.FigAdoptionPreference;
import com.facebook.debug.uitools.NodeScannerPreference;
import com.facebook.debug.uitools.UIMonitorPreference;
import com.facebook.debug.viewserver.ViewServerPreference;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.devicebasedlogin.nux.DeviceBasedLoginSettings;
import com.facebook.dialtone.prefs.CreateDialtoneShortcutPreference;
import com.facebook.dialtone.prefs.IsUserInDialtonePreference;
import com.facebook.dialtone.prefs.SwitchToDialtonePreference;
import com.facebook.dialtone.prefs.SwitchToFullFBPreference;
import com.facebook.fbui.runtimelinter.RuntimeLinterPrefKeys;
import com.facebook.fbui.runtimelinter.UIRuntimeLinter;
import com.facebook.feed.annotations.ForNewsfeed;
import com.facebook.feed.module.IProvidePreferences_ForNewsfeedMethodAutoProvider;
import com.facebook.gametime.constants.GametimeRef;
import com.facebook.gametime.util.GametimeUtil;
import com.facebook.graphql.preference.GraphQLCachePreference;
import com.facebook.greetingcards.create.ForGreetingCards;
import com.facebook.greetingcards.create.GreetingCardsPreferencesProvider;
import com.facebook.growth.nux.preferences.LaunchNUXPreference;
import com.facebook.growth.nux.preferences.ResetNUXStatusPreference;
import com.facebook.growth.nux.preferences.ResetNUXStatusPreference.1;
import com.facebook.growth.nux.preferences.ShowNUXStepPreference;
import com.facebook.http.prefs.HttpPreferencesFactory;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.http.strictsocket.StrictSocketManager;
import com.facebook.http.strictsocket.StrictSocketPreference;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.prefs.DiodePreferences;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.katana.prefs.URIWidgetPreference;
import com.facebook.katana.settings.SettingsHelper;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.katana.webview.FacewebComponentsStoreCache;
import com.facebook.location.FbLocationImplementationPref;
import com.facebook.location.FbLocationImplementationPrefUtil;
import com.facebook.location.LocationPrefKeys;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.loom.module.LoomPreferences;
import com.facebook.mqttlite.MqttConnectionConfigManager;
import com.facebook.notifications.lockscreen.util.LockScreenUtil;
import com.facebook.notifications.preferences.InlineNotificationNuxResetServerPreference;
import com.facebook.notifications.preferences.InlineNotificationNuxWebpagePreference;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.creativeediting.swipeable.composer.nux.SwipeableFrameNuxPreference;
import com.facebook.platform.webdialogs.PlatformWebDialogsPrefKeys;
import com.facebook.prefs.provider.IProvidePreferences;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.privacy.audience.PrivacyEducationPreference;
import com.facebook.productionprompts.common.PromptsInternalSettingsActivity;
import com.facebook.push.PushInitializer;
import com.facebook.push.PushManager;
import com.facebook.push.externalcloud.PushPreferenceSelector;
import com.facebook.push.externalcloud.PushServiceSelector;
import com.facebook.push.fbpushtoken.PushTokenHolder;
import com.facebook.push.registration.ServiceType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quickpromotion.annotations.ForQuickPromotion;
import com.facebook.quickpromotion.debug.QuickPromotionPreferencesProvider;
import com.facebook.rapidfeedback.debug.RapidFeedbackPreferencesLauncher;
import com.facebook.rti.common.sharedprefs.SharedPreferencesCompatHelper;
import com.facebook.saved.SavedInternalPreferences;
import com.facebook.search.debug.SearchDebugActivity;
import com.facebook.search.module.IProvidePreferences_ForGraphSearchMethodAutoProvider;
import com.facebook.search.prefs.ForGraphSearch;
import com.facebook.securitycheckup.SecurityCheckupMainActivity;
import com.facebook.selfupdate.SelfUpdatePreferencesProvider;
import com.facebook.selfupdate.annotations.ForSelfUpdate;
import com.facebook.sounds.configurator.prefs.AudioConfiguratorPrefKeys;
import com.facebook.ssl.trustmanager.FbTrustManagerFactory;
import com.facebook.timeline.prefs.TimelinePreferences;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.trace.DebugTraceData;
import com.facebook.trace.DebugTracePreference;
import com.facebook.trace.PerfDebugTracer;
import com.facebook.ui.browser.BrowserUriIntentBuilder;
import com.facebook.ui.browser.prefs.BrowserPrefetchPreference;
import com.facebook.video.channelfeed.ChannelFeedPreferences;
import com.facebook.video.commercialbreak.prefs.CommercialBreakPreferences;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoLoggingUtils.VerboseLoggingParam;
import com.facebook.video.server.VideoServerPreferences;
import com.facebook.video.videohome.prefetching.VideoHomePrefetchingIntervalPreference;
import com.facebook.widget.images.ClearImageCachePreference;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import com.facebook.widget.prefs.EditTextPreferenceWithSummaryValue;
import com.facebook.widget.prefs.OrcaCheckBoxPreference;
import com.facebook.widget.prefs.OrcaEditTextPreference;
import com.facebook.widget.prefs.OrcaEditTextWithHistoryPreference;
import com.facebook.widget.prefs.OrcaGatedPreference;
import com.facebook.widget.prefs.OrcaListPreference;
import com.facebook.widget.prefs.OrcaListPreferenceWithSummaryValue;
import com.facebook.zero.iptest.prefs.ZeroIPTestPreference;
import com.facebook.zero.prefs.LaunchZeroRatingInternSettingsPreference;
import com.google.common.collect.ImmutableList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: via_chat_bar_favorite_friends_section */
public class InternSettingsActivity extends FbPreferenceActivity {
    private static final PrefKey f589X = ((PrefKey) SharedPrefKeys.c.a("reset"));
    private static final PrefKey f590Y = ((PrefKey) SharedPrefKeys.c.a("rolodex"));
    private static final PrefKey f591Z = ((PrefKey) SharedPrefKeys.c.a("device_stat_interval"));
    private static final PrefKey aa = ((PrefKey) SharedPrefKeys.c.a("process_stat_interval"));
    @Inject
    NetAccessLogger f592A;
    @Inject
    AddressBookPeriodicRunner f593B;
    @Inject
    PerfDebugTracer f594C;
    @Inject
    BrowserUriIntentBuilder f595D;
    @Inject
    RapidFeedbackPreferencesLauncher f596E;
    @Inject
    VideoLoggingUtils f597F;
    @Inject
    StrictSocketManager f598G;
    @Inject
    QeAccessor f599H;
    @Inject
    AnalyticsLogger f600I;
    @Inject
    Fb4aUriIntentMapper f601J;
    @Inject
    @IsAldrinEnabled
    Provider<Boolean> f602K;
    @Inject
    Lazy<ClientPeriodicEventReporterManager> f603L;
    @Inject
    GametimeUtil f604M;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager f605N;
    @Inject
    @IsWorkBuild
    Boolean f606O;
    @Inject
    SettingsHelper f607P;
    @Inject
    @ForQuickExperiment
    IProvidePreferences f608Q;
    @Inject
    @ForQuickPromotion
    IProvidePreferences f609R;
    @Inject
    @ForSelfUpdate
    IProvidePreferences f610S;
    @Inject
    @ForGraphSearch
    IProvidePreferences f611T;
    @Inject
    @ForNewsfeed
    IProvidePreferences f612U;
    @ForGreetingCards
    @Inject
    IProvidePreferences f613V;
    @Inject
    BookmarkManager f614W;
    @Inject
    FbSharedPreferences f615a;
    public OrcaEditTextWithHistoryPreference ab;
    private PreferenceScreen ac;
    private final List<Preference> ad = new LinkedList();
    @Inject
    MonkeyMode f616b;
    @Inject
    UIRuntimeLinter f617c;
    @Inject
    FbUriIntentHandler f618d;
    @Inject
    SecureContextHelper f619e;
    @Inject
    UniqueIdForDeviceHolderImpl f620f;
    @Inject
    PushServiceSelector f621g;
    @Inject
    PushPreferenceSelector f622h;
    @Inject
    PushInitializer f623i;
    @DefaultExecutorService
    @Inject
    ExecutorService f624j;
    @Inject
    LockScreenUtil f625k;
    @Inject
    FbTrustManagerFactory f626l;
    @Inject
    FbLocationImplementationPrefUtil f627m;
    @Inject
    Provider<GkRefresherTask> f628n;
    @Inject
    ContactsUploadRunner f629o;
    @Inject
    ContactLogsUploadRunner f630p;
    @Inject
    ContactsUploadInternSettingHelper f631q;
    @Inject
    ContinuousContactUploadClient f632r;
    @Inject
    AbstractFbErrorReporter f633s;
    @Inject
    Context f634t;
    @Inject
    DebugTracePreference f635u;
    @Inject
    DebugTraceData f636v;
    @Inject
    ClearImageCachePreference f637w;
    @Inject
    NonEmployeeModePreference f638x;
    @Inject
    ZeroIPTestPreference f639y;
    @Inject
    PerformanceLogger f640z;

    /* compiled from: via_chat_bar_favorite_friends_section */
    class C00842 implements OnEditorActionListener {
        final /* synthetic */ InternSettingsActivity f566a;

        C00842(InternSettingsActivity internSettingsActivity) {
            this.f566a = internSettingsActivity;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6 && (i != 0 || keyEvent.getAction() != 0)) {
                return false;
            }
            String charSequence = textView.getText().toString();
            this.f566a.m651a(charSequence);
            this.f566a.ab.getDialog().dismiss();
            this.f566a.m657b(charSequence);
            return true;
        }
    }

    /* compiled from: via_chat_bar_favorite_friends_section */
    class C00853 implements OnPreferenceChangeListener {
        final /* synthetic */ InternSettingsActivity f577a;

        C00853(InternSettingsActivity internSettingsActivity) {
            this.f577a = internSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (obj instanceof String) {
                this.f577a.m651a(String.valueOf(obj));
                this.f577a.m657b((String) obj);
            }
            return false;
        }
    }

    /* compiled from: via_chat_bar_favorite_friends_section */
    class C00864 implements OnPreferenceChangeListener {
        final /* synthetic */ InternSettingsActivity f581a;

        C00864(InternSettingsActivity internSettingsActivity) {
            this.f581a = internSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            boolean z;
            if (((Boolean) obj).booleanValue()) {
                z = false;
            } else {
                z = true;
            }
            ACRA.mReportSender.mSkipSslCertChecks = z;
            ACRA.writeSkipCertChecksFile(z);
            return true;
        }
    }

    /* compiled from: via_chat_bar_favorite_friends_section */
    class C00886 implements OnPreferenceChangeListener {
        final /* synthetic */ InternSettingsActivity f585a;

        C00886(InternSettingsActivity internSettingsActivity) {
            this.f585a = internSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            Toast.makeText(this.f585a, "Reload the application to take effect", 0).show();
            return true;
        }
    }

    /* compiled from: via_chat_bar_favorite_friends_section */
    class C00897 implements OnPreferenceChangeListener {
        final /* synthetic */ InternSettingsActivity f586a;

        C00897(InternSettingsActivity internSettingsActivity) {
            this.f586a = internSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (obj.equals("bookmarks")) {
                this.f586a.f614W.a();
            }
            return false;
        }
    }

    /* compiled from: via_chat_bar_favorite_friends_section */
    class C00908 implements OnPreferenceChangeListener {
        final /* synthetic */ InternSettingsActivity f587a;

        C00908(InternSettingsActivity internSettingsActivity) {
            this.f587a = internSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            this.f587a.f597F.a((Boolean) obj);
            return true;
        }
    }

    /* compiled from: via_chat_bar_favorite_friends_section */
    class C00919 implements OnPreferenceChangeListener {
        final /* synthetic */ InternSettingsActivity f588a;

        C00919(InternSettingsActivity internSettingsActivity) {
            this.f588a = internSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            this.f588a.f597F.a((String) obj);
            return true;
        }
    }

    private static <T extends Context> void m649a(Class<T> cls, T t) {
        m650a((Object) t, (Context) t);
    }

    public static void m650a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((InternSettingsActivity) obj).m648a((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), MonkeyMode.a(injectorLike), UIRuntimeLinter.a(injectorLike), FbUriIntentHandler.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.a(injectorLike), PushServiceSelector.a(injectorLike), PushPreferenceSelector.a(injectorLike), PushInitializer.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), LockScreenUtil.a(injectorLike), FbTrustManagerFactory.a(injectorLike), FbLocationImplementationPrefUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 5137), ContactsUploadRunner.a(injectorLike), ContactLogsUploadRunner.a(injectorLike), ContactsUploadInternSettingHelper.a(injectorLike), ContinuousContactUploadClient.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class), DebugTracePreference.a(injectorLike), DebugTraceData.a(injectorLike), ClearImageCachePreference.a(injectorLike), NonEmployeeModePreference.a(injectorLike), ZeroIPTestPreference.m13202a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), NetAccessLogger.a(injectorLike), AddressBookPeriodicRunner.a(injectorLike), PerfDebugTracer.a(injectorLike), BrowserUriIntentBuilder.a(injectorLike), RapidFeedbackPreferencesLauncher.a(injectorLike), VideoLoggingUtils.a(injectorLike), StrictSocketManager.m517a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), Fb4aUriIntentMapper.a(injectorLike), IdBasedProvider.a(injectorLike, 3873), IdBasedSingletonScopeProvider.b(injectorLike, 125), GametimeUtil.m21a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), SettingsHelper.a(injectorLike), IProvidePreferences_ForQuickExperimentMethodAutoProvider.a(injectorLike), (IProvidePreferences) QuickPromotionPreferencesProvider.a(injectorLike), (IProvidePreferences) SelfUpdatePreferencesProvider.m10106a(injectorLike), IProvidePreferences_ForGraphSearchMethodAutoProvider.a(injectorLike), IProvidePreferences_ForNewsfeedMethodAutoProvider.a(injectorLike), (IProvidePreferences) GreetingCardsPreferencesProvider.m128a(injectorLike), (BookmarkManager) BookmarkClient.a(injectorLike));
    }

    private void m648a(FbSharedPreferences fbSharedPreferences, MonkeyMode monkeyMode, UIRuntimeLinter uIRuntimeLinter, FbUriIntentHandler fbUriIntentHandler, SecureContextHelper secureContextHelper, UniqueIdForDeviceHolder uniqueIdForDeviceHolder, PushServiceSelector pushServiceSelector, PushPreferenceSelector pushPreferenceSelector, PushInitializer pushInitializer, ExecutorService executorService, LockScreenUtil lockScreenUtil, FbTrustManagerFactory fbTrustManagerFactory, FbLocationImplementationPrefUtil fbLocationImplementationPrefUtil, Provider<GkRefresherTask> provider, ContactsUploadRunner contactsUploadRunner, ContactLogsUploadRunner contactLogsUploadRunner, ContactsUploadInternSettingHelper contactsUploadInternSettingHelper, ContinuousContactUploadClient continuousContactUploadClient, FbErrorReporter fbErrorReporter, Context context, DebugTracePreference debugTracePreference, DebugTraceData debugTraceData, ClearImageCachePreference clearImageCachePreference, NonEmployeeModePreference nonEmployeeModePreference, ZeroIPTestPreference zeroIPTestPreference, PerformanceLogger performanceLogger, NetAccessLogger netAccessLogger, AddressBookPeriodicRunner addressBookPeriodicRunner, PerfDebugTracer perfDebugTracer, BrowserUriIntentBuilder browserUriIntentBuilder, RapidFeedbackPreferencesLauncher rapidFeedbackPreferencesLauncher, VideoLoggingUtils videoLoggingUtils, StrictSocketManager strictSocketManager, QeAccessor qeAccessor, AnalyticsLogger analyticsLogger, Fb4aUriIntentMapper fb4aUriIntentMapper, Provider<Boolean> provider2, Lazy<ClientPeriodicEventReporterManager> lazy, GametimeUtil gametimeUtil, FbBroadcastManager fbBroadcastManager, Boolean bool, SettingsHelper settingsHelper, IProvidePreferences iProvidePreferences, IProvidePreferences iProvidePreferences2, IProvidePreferences iProvidePreferences3, IProvidePreferences iProvidePreferences4, IProvidePreferences iProvidePreferences5, IProvidePreferences iProvidePreferences6, BookmarkManager bookmarkManager) {
        this.f615a = fbSharedPreferences;
        this.f616b = monkeyMode;
        this.f617c = uIRuntimeLinter;
        this.f618d = fbUriIntentHandler;
        this.f619e = secureContextHelper;
        this.f620f = uniqueIdForDeviceHolder;
        this.f621g = pushServiceSelector;
        this.f622h = pushPreferenceSelector;
        this.f623i = pushInitializer;
        this.f624j = executorService;
        this.f625k = lockScreenUtil;
        this.f626l = fbTrustManagerFactory;
        this.f627m = fbLocationImplementationPrefUtil;
        this.f628n = provider;
        this.f629o = contactsUploadRunner;
        this.f630p = contactLogsUploadRunner;
        this.f631q = contactsUploadInternSettingHelper;
        this.f632r = continuousContactUploadClient;
        this.f633s = fbErrorReporter;
        this.f634t = context;
        this.f635u = debugTracePreference;
        this.f636v = debugTraceData;
        this.f637w = clearImageCachePreference;
        this.f638x = nonEmployeeModePreference;
        this.f639y = zeroIPTestPreference;
        this.f640z = performanceLogger;
        this.f592A = netAccessLogger;
        this.f593B = addressBookPeriodicRunner;
        this.f594C = perfDebugTracer;
        this.f595D = browserUriIntentBuilder;
        this.f596E = rapidFeedbackPreferencesLauncher;
        this.f597F = videoLoggingUtils;
        this.f598G = strictSocketManager;
        this.f599H = qeAccessor;
        this.f600I = analyticsLogger;
        this.f601J = fb4aUriIntentMapper;
        this.f602K = provider2;
        this.f603L = lazy;
        this.f604M = gametimeUtil;
        this.f605N = fbBroadcastManager;
        this.f606O = bool;
        this.f607P = settingsHelper;
        this.f608Q = iProvidePreferences;
        this.f609R = iProvidePreferences2;
        this.f610S = iProvidePreferences3;
        this.f611T = iProvidePreferences4;
        this.f612U = iProvidePreferences5;
        this.f613V = iProvidePreferences6;
        this.f614W = bookmarkManager;
    }

    public static Intent m638a(Context context) {
        return new Intent(context, InternSettingsActivity.class);
    }

    public final void m671c(Bundle bundle) {
        super.c(bundle);
        Class cls = InternSettingsActivity.class;
        m650a((Object) this, (Context) this);
        this.f607P.a(this);
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(createPreferenceScreen);
        this.ac = createPreferenceScreen;
        m646a(this.ac);
        this.f600I.a("internal_settings_opened");
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -97633283);
        super.onStart();
        this.f607P.b(this);
        this.f607P.a(2131233148);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1140140734, a);
    }

    private void m646a(PreferenceScreen preferenceScreen) {
        this.ab = new OrcaEditTextWithHistoryPreference(this, this) {
            final /* synthetic */ InternSettingsActivity f548a;

            protected boolean persistString(String str) {
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                return super.persistString(str);
            }

            protected String getPersistedString(String str) {
                return "";
            }

            protected final void m637a(ViewGroup viewGroup, String str) {
                if (!TextUtils.isEmpty(str)) {
                    super.a(viewGroup, str);
                }
            }
        };
        this.ab.a(FbandroidPrefKeys.q);
        this.ab.setDefaultValue("");
        this.ab.setDialogTitle("Filter settings");
        this.ab.setTitle("Filter Internal Settings");
        this.ab.setSummary("Quickly find required internal setting");
        this.ab.setText("");
        this.ab.getEditText().setHint("Leave empty to show all");
        this.ab.getEditText().setSingleLine(true);
        this.ab.getEditText().setImeOptions(6);
        this.ab.getEditText().setInputType(1);
        this.ab.getEditText().setOnEditorActionListener(new C00842(this));
        this.ab.setOnPreferenceChangeListener(new C00853(this));
        preferenceScreen.addPreference(this.ab);
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference.a(InternalHttpPrefKeys.j);
        checkBoxOrSwitchPreference.setDefaultValue(Boolean.valueOf(true));
        checkBoxOrSwitchPreference.setTitle(2131241479);
        checkBoxOrSwitchPreference.setSummary(2131241480);
        final OrcaCheckBoxPreference orcaCheckBoxPreference = checkBoxOrSwitchPreference;
        orcaCheckBoxPreference.setOnPreferenceChangeListener(new C00864(this));
        OrcaListPreference orcaListPreference = new OrcaListPreference(this);
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference2 = new CheckBoxOrSwitchPreference(this);
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference3 = new CheckBoxOrSwitchPreference(this);
        final OrcaListPreference orcaListPreference2 = new OrcaListPreference(this);
        final OrcaEditTextWithHistoryPreference orcaEditTextWithHistoryPreference = new OrcaEditTextWithHistoryPreference(this);
        orcaEditTextWithHistoryPreference.a(InternalHttpPrefKeys.r);
        orcaEditTextWithHistoryPreference.setDefaultValue("facebook.com");
        orcaEditTextWithHistoryPreference.setTitle("Sandbox");
        orcaEditTextWithHistoryPreference.setSummary("e.g., beta, prod, your-unix-name.sb, blank=facebook.com");
        orcaEditTextWithHistoryPreference.setDialogTitle("Sandbox");
        EditText editText = orcaEditTextWithHistoryPreference.getEditText();
        editText.setHint("e.g., beta, latest, intern, prod, dev, facebook.com");
        editText.setSingleLine(true);
        editText.setInputType(1);
        orcaEditTextWithHistoryPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f584c;

            public boolean onPreferenceChange(Preference preference, Object obj) {
                CharSequence charSequence;
                if ((obj instanceof String) && (preference instanceof EditTextPreference)) {
                    String str = (String) obj;
                    String toLowerCase = str.trim().toLowerCase();
                    if (toLowerCase.endsWith(".")) {
                        toLowerCase = toLowerCase.substring(0, toLowerCase.length() - 1);
                    }
                    if (toLowerCase.length() == 0) {
                        toLowerCase = "facebook.com";
                    } else if (!toLowerCase.endsWith("facebook.com")) {
                        toLowerCase = toLowerCase + ".facebook.com";
                    }
                    String str2 = toLowerCase;
                    EditTextPreference editTextPreference = (EditTextPreference) preference;
                    if (!str2.equals(str)) {
                        editTextPreference.setText(str2);
                        return false;
                    }
                }
                boolean z = !"facebook.com".equals(obj);
                if (this.f584c.f626l.c()) {
                    orcaCheckBoxPreference.setChecked(true);
                    charSequence = "Cache cleared";
                } else {
                    boolean z2;
                    OrcaCheckBoxPreference orcaCheckBoxPreference = orcaCheckBoxPreference;
                    if (z) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    orcaCheckBoxPreference.setChecked(z2);
                    charSequence = "Cache cleared. Please install the Facebook root certificate.";
                }
                if (orcaListPreference2.getOnPreferenceChangeListener().onPreferenceChange(orcaListPreference2, "cache")) {
                    orcaListPreference2.setValue("cache");
                }
                if (z) {
                    obj = (String) obj;
                    if (!(obj == null || obj.isEmpty())) {
                        if (!(obj.startsWith("www.") || obj.startsWith("b-www."))) {
                            obj = "b-www." + obj;
                        }
                        ACRA.setReportHost(obj);
                    }
                } else {
                    ACRA.setReportHost("b-www.facebook.com");
                }
                Toast.makeText(this.f584c, charSequence, 0).show();
                return true;
            }
        });
        preferenceScreen.addPreference(orcaEditTextWithHistoryPreference);
        preferenceScreen.addPreference(orcaCheckBoxPreference);
        if (BuildConstants.i) {
            checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(this);
            checkBoxOrSwitchPreference.a(InternalHttpPrefKeys.k);
            checkBoxOrSwitchPreference.setDefaultValue(Boolean.valueOf(false));
            checkBoxOrSwitchPreference.setTitle(2131241481);
            checkBoxOrSwitchPreference.setSummary(2131241482);
            OrcaCheckBoxPreference orcaCheckBoxPreference2 = checkBoxOrSwitchPreference;
            orcaCheckBoxPreference2.setOnPreferenceChangeListener(new C00886(this));
            preferenceScreen.addPreference(orcaCheckBoxPreference2);
        }
        m669k(preferenceScreen);
        m645a((PreferenceGroup) preferenceScreen, this.f608Q);
        m644a((PreferenceGroup) preferenceScreen);
        m654b((PreferenceGroup) preferenceScreen);
        m662e((PreferenceGroup) preferenceScreen);
        orcaListPreference.setEntries(new CharSequence[]{"Reload Bookmarks"});
        orcaListPreference.setEntryValues(new CharSequence[]{"bookmarks"});
        orcaListPreference.setDialogTitle("Bookmarks menu");
        orcaListPreference.setTitle("Bookmarks menu control");
        orcaListPreference.setSummary("Reloads Bookmarks navigation data");
        orcaListPreference.setPositiveButtonText("Reload");
        orcaListPreference.setNegativeButtonText("Cancel");
        orcaListPreference.setKey("navbar");
        orcaListPreference.setOnPreferenceChangeListener(new C00897(this));
        preferenceScreen.addPreference(orcaListPreference);
        m669k(preferenceScreen);
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle(2131232969);
        preferenceScreen.addPreference(preferenceCategory);
        preferenceCategory.addPreference(new LaunchZeroRatingInternSettingsPreference(this));
        preferenceCategory.addPreference(this.f639y);
        m669k(preferenceScreen);
        Preference preferenceCategory2 = new PreferenceCategory(this);
        preferenceCategory2.setTitle("Video");
        preferenceScreen.addPreference(preferenceCategory2);
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference4 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference4.a(FbandroidPrefKeys.g);
        checkBoxOrSwitchPreference4.setTitle("Display Inline Video Specs");
        checkBoxOrSwitchPreference4.setSummary("Display metadata of the playing video");
        checkBoxOrSwitchPreference4.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory2.addPreference(checkBoxOrSwitchPreference4);
        checkBoxOrSwitchPreference4 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference4.a(FbandroidPrefKeys.w);
        checkBoxOrSwitchPreference4.setTitle("Enable Video Player Debugging Logs");
        checkBoxOrSwitchPreference4.setSummary("Enable debugging logs for video player");
        checkBoxOrSwitchPreference4.setDefaultValue(Boolean.valueOf(false));
        checkBoxOrSwitchPreference4.setOnPreferenceChangeListener(new C00908(this));
        preferenceCategory2.addPreference(checkBoxOrSwitchPreference4);
        checkBoxOrSwitchPreference4 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference4.a(FbandroidPrefKeys.h);
        checkBoxOrSwitchPreference4.setTitle("Play inline videos unmuted");
        checkBoxOrSwitchPreference4.setSummary("Set all inline FB videos to unmuted state");
        checkBoxOrSwitchPreference4.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory2.addPreference(checkBoxOrSwitchPreference4);
        VerboseLoggingParam[] values = VerboseLoggingParam.values();
        CharSequence[] charSequenceArr = new CharSequence[values.length];
        for (int i = 0; i < values.length; i++) {
            charSequenceArr[i] = values[i].toString();
        }
        OrcaListPreferenceWithSummaryValue orcaListPreferenceWithSummaryValue = new OrcaListPreferenceWithSummaryValue(this);
        orcaListPreferenceWithSummaryValue.a(FbandroidPrefKeys.i);
        orcaListPreferenceWithSummaryValue.setTitle("Logging level");
        orcaListPreferenceWithSummaryValue.setSummary("Adjust video logging verbosity level");
        orcaListPreferenceWithSummaryValue.setDefaultValue(VerboseLoggingParam.NONE.toString());
        orcaListPreferenceWithSummaryValue.setOnPreferenceChangeListener(new C00919(this));
        orcaListPreferenceWithSummaryValue.setEntries(charSequenceArr);
        orcaListPreferenceWithSummaryValue.setEntryValues(charSequenceArr);
        preferenceCategory2.addPreference(orcaListPreferenceWithSummaryValue);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Video Home");
        preferenceScreen.addPreference(preferenceCategory);
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference5 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference5.a(FbandroidPrefKeys.j);
        checkBoxOrSwitchPreference5.setTitle("Videohome force prefetching");
        checkBoxOrSwitchPreference5.setSummary("Forces data prefetching");
        checkBoxOrSwitchPreference5.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference5);
        preferenceCategory.addPreference(new VideoHomePrefetchingIntervalPreference(this));
        checkBoxOrSwitchPreference5 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference5.a(FbandroidPrefKeys.k);
        checkBoxOrSwitchPreference5.setTitle("Videohome prefetching toast");
        checkBoxOrSwitchPreference5.setSummary("shows a toast when prefetching starts/finishes");
        checkBoxOrSwitchPreference5.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference5);
        m669k(preferenceScreen);
        preferenceScreen.addPreference(new ChannelFeedPreferences(this));
        m669k(preferenceScreen);
        preferenceScreen.addPreference(new CommercialBreakPreferences(this));
        m669k(preferenceScreen);
        preferenceScreen.addPreference(new VideoServerPreferences(this));
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Groups");
        preferenceScreen.addPreference(preferenceCategory);
        preferenceCategory2 = new Preference(this);
        preferenceCategory2.setTitle("Discover Landings");
        preferenceCategory2.setSummary("Open Discover Landings Page");
        preferenceCategory2.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f534a;

            {
                this.f534a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                this.f534a.f619e.b(this.f534a.f601J.a(this.f534a.f634t, Uri.parse(FBLinks.x).toString()), this.f534a.f634t);
                return true;
            }
        });
        preferenceCategory.addPreference(preferenceCategory2);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("In-App Browser");
        preferenceScreen.addPreference(preferenceCategory);
        checkBoxOrSwitchPreference2.a(FbandroidPrefKeys.u);
        checkBoxOrSwitchPreference2.setTitle("Enable Web Contents Debugging");
        checkBoxOrSwitchPreference2.setSummary("Enable remote debugging with Chrome");
        checkBoxOrSwitchPreference2.setDefaultValue(Boolean.valueOf(false));
        checkBoxOrSwitchPreference2.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f535a;

            {
                this.f535a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                if (VERSION.SDK_INT < 19) {
                    return false;
                }
                WebView.setWebContentsDebuggingEnabled(obj.equals(Boolean.valueOf(true)));
                return true;
            }
        });
        preferenceCategory.addPreference(checkBoxOrSwitchPreference2);
        checkBoxOrSwitchPreference3.a(FbandroidPrefKeys.v);
        checkBoxOrSwitchPreference3.setTitle("Enable Debug Overlay");
        checkBoxOrSwitchPreference3.setSummary("Enable in-app browser debug overlay");
        checkBoxOrSwitchPreference3.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference3);
        preferenceCategory.addPreference(new BrowserPrefetchPreference(this));
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Contacts");
        preferenceScreen.addPreference(preferenceCategory);
        Preference preference = new Preference(this);
        preference.setTitle("Force upload call logs");
        preference.setSummary("Call, MMS and SMS Log Upload");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f536a;

            {
                this.f536a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                this.f536a.f630p.b();
                return true;
            }
        });
        Preference preference2 = new Preference(this);
        preference2.setTitle("Force upload contacts");
        preference2.setSummary("Phonebook Contacts Upload");
        preference2.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f537a;

            {
                this.f537a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                if (this.f537a.f631q.a()) {
                    this.f537a.f631q.b();
                } else {
                    this.f537a.f629o.a(ContactsUploadVisibility.SHOW);
                }
                return true;
            }
        });
        preferenceCategory2 = new Preference(this);
        preferenceCategory2.setTitle("Force DELTA upload contacts");
        preferenceCategory2.setSummary("Phonebook Contacts DELTA Upload");
        preferenceCategory2.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f538a;

            {
                this.f538a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                if (this.f538a.f631q.a()) {
                    this.f538a.f631q.c();
                } else {
                    this.f538a.f632r.a("contacts_upload_friend_finder", true);
                }
                return true;
            }
        });
        AnalyticsContactsUploadIntervalPreference analyticsContactsUploadIntervalPreference = new AnalyticsContactsUploadIntervalPreference(this);
        preferenceCategory.addPreference(preference);
        preferenceCategory.addPreference(preference2);
        preferenceCategory.addPreference(preferenceCategory2);
        preferenceCategory.addPreference(analyticsContactsUploadIntervalPreference);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Growth NUX");
        preferenceScreen.addPreference(preferenceCategory);
        ShowNUXStepPreference showNUXStepPreference = new ShowNUXStepPreference(this);
        showNUXStepPreference.a();
        preferenceCategory.addPreference(showNUXStepPreference);
        ResetNUXStatusPreference resetNUXStatusPreference = new ResetNUXStatusPreference(this);
        resetNUXStatusPreference.setTitle("Reset NUX status");
        resetNUXStatusPreference.setSummary("Force current user into NUX eligibility for non-production sandbox");
        resetNUXStatusPreference.setKey(ResetNUXStatusPreference.class.getName());
        resetNUXStatusPreference.setOnPreferenceClickListener(new 1(resetNUXStatusPreference));
        preferenceCategory.addPreference(resetNUXStatusPreference);
        LaunchNUXPreference launchNUXPreference = new LaunchNUXPreference(this);
        Context context = launchNUXPreference.getContext();
        launchNUXPreference.setTitle("Launch NUX");
        launchNUXPreference.setSummary("Launch this user's currently eligible NUX steps");
        launchNUXPreference.setKey(LaunchNUXPreference.class.getName());
        launchNUXPreference.setOnPreferenceClickListener(new LaunchNUXPreference.1(launchNUXPreference, context));
        preferenceCategory.addPreference(launchNUXPreference);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("MQTT");
        preferenceScreen.addPreference(preferenceCategory);
        OrcaListPreferenceWithSummaryValue orcaListPreferenceWithSummaryValue2 = new OrcaListPreferenceWithSummaryValue(this);
        orcaListPreferenceWithSummaryValue2.setKey(MqttConnectionConfigManager.b.a());
        orcaListPreferenceWithSummaryValue2.setTitle("MQTT Server tier");
        orcaListPreferenceWithSummaryValue2.setDefaultValue("default");
        orcaListPreferenceWithSummaryValue2.setEntries(new CharSequence[]{"default", "sandbox"});
        orcaListPreferenceWithSummaryValue2.setEntryValues(new CharSequence[]{"default", "sandbox"});
        preferenceCategory.addPreference(orcaListPreferenceWithSummaryValue2);
        EditTextPreferenceWithSummaryValue editTextPreferenceWithSummaryValue = new EditTextPreferenceWithSummaryValue(this);
        editTextPreferenceWithSummaryValue.a(MqttConnectionConfigManager.c);
        editTextPreferenceWithSummaryValue.setTitle("MQTT Sandbox");
        editTextPreferenceWithSummaryValue.setDialogTitle("MQTT Sandbox");
        editTextPreferenceWithSummaryValue.getEditText().setHint("user.devNN.prn2.facebook.com:8883");
        editTextPreferenceWithSummaryValue.getEditText().setSingleLine(true);
        editTextPreferenceWithSummaryValue.getEditText().setInputType(1);
        editTextPreferenceWithSummaryValue.a();
        preferenceCategory.addPreference(editTextPreferenceWithSummaryValue);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Push Notification");
        preferenceScreen.addPreference(preferenceCategory);
        preferenceCategory.addPreference(m639a());
        if (this.f625k.a(false)) {
            preferenceCategory = new PreferenceCategory(this);
            preferenceCategory.setTitle("Popup Notifications");
            OrcaListPreference orcaListPreference3 = new OrcaListPreference(this);
            orcaListPreference3.setEntries(new CharSequence[]{"Reset Nux"});
            orcaListPreference3.setEntryValues(new CharSequence[]{"reset_nux"});
            orcaListPreference3.setDialogTitle("Popup Notifications");
            orcaListPreference3.setTitle("Reset Popup Notifications Nux");
            orcaListPreference3.setPositiveButtonText("Reset");
            orcaListPreference3.setNegativeButtonText("Cancel");
            orcaListPreference3.setKey("popup_nux");
            orcaListPreference3.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
                final /* synthetic */ InternSettingsActivity f539a;

                {
                    this.f539a = r1;
                }

                public boolean onPreferenceChange(Preference preference, Object obj) {
                    if (obj.equals("reset_nux")) {
                        this.f539a.f625k.d.edit().putBoolean(NotificationsPreferenceConstants.j, true).commit();
                        this.f539a.f625k.d.edit().a(NotificationsPreferenceConstants.B).a(NotificationsPreferenceConstants.C).a(NotificationsPreferenceConstants.D).commit();
                    }
                    return false;
                }
            });
            preferenceScreen.addPreference(preferenceCategory);
            preferenceCategory.addPreference(orcaListPreference3);
        }
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("FACEWEB");
        preferenceScreen.addPreference(preferenceCategory);
        orcaListPreference2.setEntries(new CharSequence[]{"Clear cookies", "Clear cache"});
        orcaListPreference2.setEntryValues(new CharSequence[]{"cookies", "cache"});
        orcaListPreference2.setDialogTitle("Reset webviews");
        orcaListPreference2.setTitle("Webview control");
        orcaListPreference2.setSummary("Clears webview cookies or caches");
        orcaListPreference2.setPositiveButtonText("Clear");
        orcaListPreference2.setNegativeButtonText("Cancel");
        orcaListPreference2.a(f589X);
        orcaListPreference2.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f540a;

            {
                this.f540a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                if (obj.equals("cookies")) {
                    CookieSyncManager.createInstance(this.f540a);
                    CookieManager.getInstance().removeAllCookie();
                } else if (obj.equals("cache")) {
                    new WebView(this.f540a).clearCache(true);
                    FacewebComponentsStoreCache.m1296a(this.f540a);
                }
                return false;
            }
        });
        preferenceCategory.addPreference(orcaListPreference2);
        OrcaEditTextPreference orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.a(InternalHttpPrefKeys.s);
        orcaEditTextPreference.setDefaultValue("");
        orcaEditTextPreference.setTitle("Weinre Server");
        orcaEditTextPreference.setSummary("Set weinre server hostname and port number ");
        orcaEditTextPreference.setDialogTitle("Weinre Server");
        EditText editText2 = orcaEditTextPreference.getEditText();
        editText2.setHint("(e.g., 172.16.108.12:8081)");
        editText2.setSingleLine(true);
        preferenceCategory.addPreference(orcaEditTextPreference);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("UI Performance");
        preferenceScreen.addPreference(preferenceCategory);
        preferenceCategory.addPreference(new ViewServerPreference(this));
        preferenceCategory.addPreference(new DroidInspectorPreference(this));
        preferenceCategory.addPreference(new UIMonitorPreference(this));
        preferenceCategory.addPreference(new FBUiAdoptionPreference(this));
        preferenceCategory.addPreference(new FigAdoptionPreference(this));
        preferenceCategory.addPreference(new NodeScannerPreference(this));
        checkBoxOrSwitchPreference2 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference2.a(RuntimeLinterPrefKeys.b);
        checkBoxOrSwitchPreference2.setTitle("Enable Runtime UI Linter");
        checkBoxOrSwitchPreference2.setSummary("If enabled, the runtime UI linter will periodically check the UI for errors.");
        checkBoxOrSwitchPreference2.setDefaultValue(RuntimeLinterPrefKeys.c);
        checkBoxOrSwitchPreference2.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f541a;

            {
                this.f541a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                UIRuntimeLinter uIRuntimeLinter = this.f541a.f617c;
                if (uIRuntimeLinter.m && uIRuntimeLinter.p != null) {
                    uIRuntimeLinter.j.b(uIRuntimeLinter.p);
                    uIRuntimeLinter.p = null;
                }
                uIRuntimeLinter.m = false;
                return true;
            }
        });
        preferenceCategory.addPreference(checkBoxOrSwitchPreference2);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("HTTP Prefs");
        preferenceScreen.addPreference(preferenceCategory);
        preferenceCategory.addPreference(HttpPreferencesFactory.m512c(this));
        Object strictSocketPreference = new StrictSocketPreference(this, this.f598G);
        strictSocketPreference.a();
        preferenceCategory.addPreference(strictSocketPreference);
        checkBoxOrSwitchPreference2 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference2.a(InternalHttpPrefKeys.b);
        checkBoxOrSwitchPreference2.setTitle("PHP Request profiling");
        checkBoxOrSwitchPreference2.setSummary("Enable PHP Profiling on all requests");
        checkBoxOrSwitchPreference2.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference2);
        checkBoxOrSwitchPreference2 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference2.a(InternalHttpPrefKeys.c);
        checkBoxOrSwitchPreference2.setTitle("Wirehog Request Profiling");
        checkBoxOrSwitchPreference2.setSummary("Enable Wirehog Profiling on all requests");
        checkBoxOrSwitchPreference2.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference2);
        checkBoxOrSwitchPreference2 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference2.a(InternalHttpPrefKeys.d);
        checkBoxOrSwitchPreference2.setTitle("Teak Request Profiling");
        checkBoxOrSwitchPreference2.setSummary("Enable Teak Profiling on all requests");
        checkBoxOrSwitchPreference2.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference2);
        checkBoxOrSwitchPreference2 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference2.a(InternalHttpPrefKeys.e);
        checkBoxOrSwitchPreference2.setTitle("FB Request Tracing");
        checkBoxOrSwitchPreference2.setSummary("Enable FB Tracing on all requests");
        checkBoxOrSwitchPreference2.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference2);
        checkBoxOrSwitchPreference2 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference2.a(InternalHttpPrefKeys.f);
        checkBoxOrSwitchPreference2.setTitle("Artillery Tracing");
        checkBoxOrSwitchPreference2.setSummary("Enable Artillery tracing on all requests");
        checkBoxOrSwitchPreference2.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference2);
        checkBoxOrSwitchPreference2 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference2.a(InternalHttpPrefKeys.g);
        checkBoxOrSwitchPreference2.setTitle("Show requests queue");
        checkBoxOrSwitchPreference2.setSummary("Restart may be required");
        checkBoxOrSwitchPreference2.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference2);
        if (this.f599H.a(ExperimentsForHttpQeModule.al, false)) {
            checkBoxOrSwitchPreference2 = new CheckBoxOrSwitchPreference(this);
            checkBoxOrSwitchPreference2.a(InternalHttpPrefKeys.m);
            checkBoxOrSwitchPreference2.setTitle("Enable 2G Empathy");
            checkBoxOrSwitchPreference2.setSummary("Applies to those in the edge_empathy_simulation GK. Restart may be required.");
            checkBoxOrSwitchPreference2.setDefaultValue(Boolean.valueOf(false));
            preferenceCategory.addPreference(checkBoxOrSwitchPreference2);
        }
        checkBoxOrSwitchPreference2 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference2.a(InternalHttpPrefKeys.n);
        checkBoxOrSwitchPreference2.setTitle("Print liger trace events in logcat");
        checkBoxOrSwitchPreference2.setSummary("Turn on to print all Liger trace events in logcat.");
        checkBoxOrSwitchPreference2.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference2);
        checkBoxOrSwitchPreference4 = new CheckBoxOrSwitchPreference(this);
        final Runnable anonymousClass18 = new Runnable(this) {
            final /* synthetic */ InternSettingsActivity f545d;

            public void run() {
                this.f545d.f616b.b = true;
                if (checkBoxOrSwitchPreference4 != null) {
                    checkBoxOrSwitchPreference4.setEnabled(false);
                    checkBoxOrSwitchPreference4.setDefaultValue(Boolean.valueOf(false));
                    checkBoxOrSwitchPreference4.setSummary("Monkey mode irrevocably on. Reinstall the app or clear application data to turn it off.");
                }
                if (orcaCheckBoxPreference != null) {
                    orcaCheckBoxPreference.setEnabled(false);
                }
                if (orcaEditTextWithHistoryPreference != null) {
                    orcaEditTextWithHistoryPreference.setEnabled(false);
                }
            }
        };
        checkBoxOrSwitchPreference4.a(MonkeyMode.a);
        checkBoxOrSwitchPreference4.setTitle("Monkey mode");
        checkBoxOrSwitchPreference4.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f547b;

            public boolean onPreferenceChange(Preference preference, Object obj) {
                anonymousClass18.run();
                return true;
            }
        });
        checkBoxOrSwitchPreference4.setDefaultValue(Boolean.valueOf(false));
        checkBoxOrSwitchPreference4.setSummary("Disables Logout, Crash, Report Bug, and this preference.");
        preferenceScreen.addPreference(checkBoxOrSwitchPreference4);
        checkBoxOrSwitchPreference4 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference4.a(PerformanceLogger.a);
        checkBoxOrSwitchPreference4.setTitle("Show PerfMarker in LogCat");
        checkBoxOrSwitchPreference4.setDefaultValue(Boolean.valueOf(this.f640z.a()));
        checkBoxOrSwitchPreference4.setSummary("Collect all PerfMarkers and report timestamp and elapsed time to LogCat");
        preferenceScreen.addPreference(checkBoxOrSwitchPreference4);
        checkBoxOrSwitchPreference4 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference4.a(InteractionTTILogger.a);
        checkBoxOrSwitchPreference4.setTitle("Display Perf Numbers On Screen");
        checkBoxOrSwitchPreference4.setDefaultValue(Boolean.valueOf(false));
        checkBoxOrSwitchPreference4.setSummary("Display real time perf numbers on screen. Restart app to make it takes effect.");
        preferenceScreen.addPreference(checkBoxOrSwitchPreference4);
        checkBoxOrSwitchPreference4 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference4.a(NetAccessLogger.a);
        checkBoxOrSwitchPreference4.setTitle(2131233113);
        checkBoxOrSwitchPreference4.setSummaryOff(2131233828);
        checkBoxOrSwitchPreference4.setSummaryOn(2131233829);
        checkBoxOrSwitchPreference4.setDefaultValue(Boolean.valueOf(false));
        checkBoxOrSwitchPreference4.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f549a;

            {
                this.f549a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                this.f549a.f592A.b.edit().putBoolean(NetAccessLogger.a, ((Boolean) obj).booleanValue()).commit();
                return true;
            }
        });
        preferenceScreen.addPreference(checkBoxOrSwitchPreference4);
        checkBoxOrSwitchPreference4 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference4.a(NavigationToastProvider.a);
        checkBoxOrSwitchPreference4.setTitle(2131233114);
        checkBoxOrSwitchPreference4.setSummary("Show navigation events when there is a page transition");
        preferenceScreen.addPreference(checkBoxOrSwitchPreference4);
        orcaListPreference = new OrcaListPreference(this);
        String l = Long.toString(this.f615a.a(AnalyticsPrefKeys.f, -1));
        CharSequence[] charSequenceArr2 = new CharSequence[]{"1", "5", "30", "60", "120", "-1"};
        orcaListPreference.setEntries(new CharSequence[]{"1 second", "5 seconds", "30 seconds", "1 minute", "2 minutes", "Unset"});
        orcaListPreference.setEntryValues(charSequenceArr2);
        orcaListPreference.setDefaultValue(l);
        orcaListPreference.a(f591Z);
        orcaListPreference.setTitle("Device Status Event Interval");
        orcaListPreference.setSummary("Time between Device Status analytics events");
        orcaListPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f550a;

            {
                this.f550a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                Long valueOf = Long.valueOf(Long.parseLong((String) obj));
                if (valueOf.longValue() == -1) {
                    this.f550a.f615a.edit().a(AnalyticsPrefKeys.f).commit();
                } else {
                    this.f550a.f615a.edit().a(AnalyticsPrefKeys.f, valueOf.longValue() * 1000).commit();
                    ((ClientPeriodicEventReporterManager) this.f550a.f603L.get()).a();
                }
                return true;
            }
        });
        preferenceScreen.addPreference(orcaListPreference);
        orcaListPreference = new OrcaListPreference(this);
        l = Long.toString(this.f615a.a(AnalyticsPrefKeys.b, -1));
        charSequenceArr2 = new CharSequence[]{"1", "5", "30", "60", "120", "-1"};
        orcaListPreference.setEntries(new CharSequence[]{"1 second", "5 seconds", "30 seconds", "1 minute", "2 minutes", "Unset"});
        orcaListPreference.setEntryValues(charSequenceArr2);
        orcaListPreference.setDefaultValue(l);
        orcaListPreference.a(aa);
        orcaListPreference.setTitle("Process Status Event Interval");
        orcaListPreference.setSummary("Time between Process Status analytics events");
        orcaListPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f551a;

            {
                this.f551a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                Long valueOf = Long.valueOf(Long.parseLong((String) obj));
                if (valueOf.longValue() == -1) {
                    this.f551a.f615a.edit().a(AnalyticsPrefKeys.b).commit();
                } else {
                    this.f551a.f615a.edit().a(AnalyticsPrefKeys.b, valueOf.longValue() * 1000).commit();
                    ((ClientPeriodicEventReporterManager) this.f551a.f603L.get()).a();
                }
                return true;
            }
        });
        preferenceScreen.addPreference(orcaListPreference);
        preferenceScreen.addPreference(new AnalyticsDeviceInfoIntervalPreference(this));
        OrcaListPreferenceWithSummaryValue orcaListPreferenceWithSummaryValue3 = new OrcaListPreferenceWithSummaryValue(this);
        orcaListPreferenceWithSummaryValue3.setKey(DebugLoggingPrefKeys.c.a());
        orcaListPreferenceWithSummaryValue3.setTitle(2131239995);
        orcaListPreferenceWithSummaryValue3.setDefaultValue("-1");
        orcaListPreferenceWithSummaryValue3.setEntries(2131755084);
        orcaListPreferenceWithSummaryValue3.setEntryValues(2131755085);
        preferenceScreen.addPreference(orcaListPreferenceWithSummaryValue3);
        checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference.setKey(DebugLoggingPrefKeys.e.a());
        checkBoxOrSwitchPreference.setTitle(2131239999);
        preferenceScreen.addPreference(checkBoxOrSwitchPreference);
        preferenceScreen.addPreference(new AnalyticsBatchIntervalPreference(this));
        preferenceScreen.addPreference(new DataConnectionOverlayPreference(this));
        preferenceScreen.addPreference(new HomeStoriesOverlayPreference(this));
        preferenceScreen.addPreference(new FreshFeedOverlayPreference(this));
        preferenceScreen.addPreference(new ClientSideRankingIndicatorPreference(this));
        preferenceScreen.addPreference(new CommentCacheStatePreference(this));
        orcaListPreference = new OrcaListPreference(this);
        orcaListPreference.setEntries(new CharSequence[]{"Upload", "Download"});
        orcaListPreference.setEntryValues(new CharSequence[]{"upload", "download"});
        orcaListPreference.setDialogTitle("Contacts menu");
        orcaListPreference.setTitle("Contacts (Rolodex) control");
        orcaListPreference.setSummary("Trigger contacts uploads/downloads");
        orcaListPreference.setPositiveButtonText("Start");
        orcaListPreference.setNegativeButtonText("Cancel");
        orcaListPreference.a(f590Y);
        orcaListPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f552a;

            {
                this.f552a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                if (obj.equals("upload")) {
                    this.f552a.f629o.a(ContactsUploadVisibility.HIDE);
                } else if (obj.equals("download")) {
                    this.f552a.f593B.a();
                }
                return false;
            }
        });
        preferenceScreen.addPreference(orcaListPreference);
        preferenceScreen.addPreference(this.f637w);
        if (this.f616b.a()) {
            anonymousClass18.run();
        }
        checkBoxOrSwitchPreference4 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference4.a(BugReporterPrefKeys.c);
        checkBoxOrSwitchPreference4.setTitle(2131235809);
        checkBoxOrSwitchPreference4.setSummary(2131235810);
        checkBoxOrSwitchPreference4.setDefaultValue(Boolean.valueOf(true));
        preferenceScreen.addPreference(checkBoxOrSwitchPreference4);
        m669k(preferenceScreen);
        preferenceScreen.addPreference(new TimelinePreferences(this));
        m669k(preferenceScreen);
        preferenceScreen.addPreference(new DiodePreferences(this));
        m669k(preferenceScreen);
        preferenceScreen.addPreference(new DeviceBasedLoginSettings(this));
        preferenceScreen.addPreference(new IsUserInDialtonePreference(this));
        preferenceScreen.addPreference(new CreateDialtoneShortcutPreference(this));
        preferenceScreen.addPreference(new SwitchToDialtonePreference(this));
        preferenceScreen.addPreference(new SwitchToFullFBPreference(this));
        m669k(preferenceScreen);
        preferenceScreen.addPreference(new DataUsagePreferences(this));
        m669k(preferenceScreen);
        m645a((PreferenceGroup) preferenceScreen, this.f609R);
        m669k(preferenceScreen);
        m645a((PreferenceGroup) preferenceScreen, this.f610S);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Memory");
        preferenceScreen.addPreference(preferenceCategory);
        preferenceCategory.addPreference(DebugPreferencesFactory.b(this));
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Composer Nux");
        preferenceScreen.addPreference(preferenceCategory);
        preferenceCategory.addPreference(new ComposerTipPreference(this));
        m669k(preferenceScreen);
        m645a((PreferenceGroup) preferenceScreen, this.f611T);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Composer Frames Nux");
        preferenceScreen.addPreference(preferenceCategory);
        preferenceCategory.addPreference(new SwipeableFrameNuxPreference(this));
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("GraphQL");
        preferenceScreen.addPreference(preferenceCategory);
        preferenceCategory.addPreference(new GraphQLCachePreference(this));
        m669k(preferenceScreen);
        preferenceScreen.addPreference(new LoomPreferences(this));
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("URI Widget");
        preferenceScreen.addPreference(preferenceCategory);
        preferenceCategory.addPreference(new URIWidgetPreference(this, this.f618d, this.f619e));
        m669k(preferenceScreen);
        m645a((PreferenceGroup) preferenceScreen, this.f612U);
        m669k(preferenceScreen);
        m645a((PreferenceGroup) preferenceScreen, this.f613V);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Rapid Feedback - Internal");
        preferenceScreen.addPreference(preferenceCategory);
        this.f596E.setSummary("Test/Debug Surveys with their IDs");
        preferenceCategory.addPreference(this.f596E);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Security Checkup - Internal");
        preferenceScreen.addPreference(preferenceCategory);
        Preference preference3 = new Preference(this);
        preference3.setTitle("Security Checkup");
        preference3.setSummary("Launch Security Checkup for test/debug");
        preference3.setIntent(new Intent(this, SecurityCheckupMainActivity.class));
        preferenceCategory.addPreference(preference3);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Platform");
        preferenceScreen.addPreference(preferenceCategory);
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference6 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference6.a(PlatformWebDialogsPrefKeys.c);
        checkBoxOrSwitchPreference6.setTitle("Reset Manifest refresh per Action");
        checkBoxOrSwitchPreference6.setSummary("Discards the cached manifest for each dialog invocation");
        checkBoxOrSwitchPreference6.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference6);
        checkBoxOrSwitchPreference6 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference6.a(PlatformWebDialogsPrefKeys.d);
        checkBoxOrSwitchPreference6.setTitle("Disable Manifest Refresh");
        checkBoxOrSwitchPreference6.setSummary("Stops the manifest from refreshing without a dialog invocation (happens on cold start)");
        checkBoxOrSwitchPreference6.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference6);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Privacy");
        preferenceScreen.addPreference(preferenceCategory);
        preferenceCategory.addPreference(new PrivacyEducationPreference(this));
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Sounds");
        preferenceScreen.addPreference(preferenceCategory);
        checkBoxOrSwitchPreference6 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference6.a(AudioConfiguratorPrefKeys.b);
        checkBoxOrSwitchPreference6.setTitle(2131236761);
        checkBoxOrSwitchPreference6.setSummaryOn(2131236762);
        checkBoxOrSwitchPreference6.setSummaryOff(2131236763);
        checkBoxOrSwitchPreference6.setDefaultValue(Boolean.valueOf(false));
        preferenceCategory.addPreference(checkBoxOrSwitchPreference6);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Search");
        preferenceScreen.addPreference(preferenceCategory);
        preference3 = new Preference(this);
        preference3.setTitle("Debug Settings");
        preference3.setSummary("Control search settings");
        preference3.setIntent(new Intent(this, SearchDebugActivity.class));
        preferenceCategory.addPreference(preference3);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Pages");
        preferenceScreen.addPreference(preferenceCategory);
        m669k(preferenceScreen);
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Location");
        preferenceScreen.addPreference(preferenceCategory);
        OrcaListPreference orcaListPreference4 = new OrcaListPreference(this);
        ImmutableList<FbLocationImplementationPref> a = this.f627m.a();
        int a2 = this.f615a.a(LocationPrefKeys.b, FbLocationImplementationPref.DEFAULT.key);
        CharSequence[] charSequenceArr3 = new String[a.size()];
        CharSequence[] charSequenceArr4 = new String[a.size()];
        int i2 = 0;
        for (FbLocationImplementationPref fbLocationImplementationPref : a) {
            charSequenceArr3[i2] = fbLocationImplementationPref.name;
            int i3 = i2 + 1;
            charSequenceArr4[i2] = fbLocationImplementationPref.key;
            i2 = i3;
        }
        orcaListPreference4.setEntries(charSequenceArr3);
        orcaListPreference4.setEntryValues(charSequenceArr4);
        orcaListPreference4.setDefaultValue(Integer.toString(a2));
        orcaListPreference4.setTitle("Location Implementation");
        orcaListPreference4.setSummary("Choice of Standard or Mock Location Implementations for testing purposes (Restart is recommended)");
        orcaListPreference4.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f553a;

            {
                this.f553a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                this.f553a.f615a.edit().a(LocationPrefKeys.b, Integer.parseInt((String) obj)).commit();
                return true;
            }
        });
        preferenceScreen.addPreference(orcaListPreference4);
        preferenceScreen.addPreference(this.f638x);
        m669k(preferenceScreen);
        preferenceScreen.addPreference(new SavedInternalPreferences(this));
        m669k(preferenceScreen);
        m665g(preferenceScreen);
        m666h(preferenceScreen);
        m667i(preferenceScreen);
        m668j(preferenceScreen);
        m669k(preferenceScreen);
        PreferenceGroup preferenceCategory3 = new PreferenceCategory(this);
        preferenceCategory3.setTitle("Method Tracing");
        preferenceScreen.addPreference(preferenceCategory3);
        m669k(preferenceScreen);
        preferenceCategory3.addPreference(this.f635u);
        m658c(preferenceCategory3);
        m660d(preferenceCategory3);
        m669k(preferenceScreen);
        m664f(preferenceScreen);
        m669k(preferenceScreen);
        m655b(preferenceScreen);
        if (((Boolean) this.f602K.get()).booleanValue()) {
            m669k(preferenceScreen);
            m659c(preferenceScreen);
        }
        preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Inline Notification NUX Preference");
        preferenceScreen.addPreference(preferenceCategory);
        InlineNotificationNuxResetServerPreference inlineNotificationNuxResetServerPreference = new InlineNotificationNuxResetServerPreference(this);
        inlineNotificationNuxResetServerPreference.setTitle("Reset Inline Notification NUX status");
        inlineNotificationNuxResetServerPreference.setSummary("Clears client preferences and fetches status from server");
        inlineNotificationNuxResetServerPreference.setKey(InlineNotificationNuxResetServerPreference.class.getName());
        inlineNotificationNuxResetServerPreference.setOnPreferenceClickListener(new InlineNotificationNuxResetServerPreference.1(inlineNotificationNuxResetServerPreference));
        preferenceCategory.addPreference(inlineNotificationNuxResetServerPreference);
        InlineNotificationNuxWebpagePreference inlineNotificationNuxWebpagePreference = new InlineNotificationNuxWebpagePreference(this);
        inlineNotificationNuxWebpagePreference.setTitle("Open Inline Notification NUX server config");
        inlineNotificationNuxWebpagePreference.setSummary("Click 'Reset View State For User' to enable NUX eligibility");
        inlineNotificationNuxWebpagePreference.setKey(InlineNotificationNuxWebpagePreference.class.getName());
        inlineNotificationNuxWebpagePreference.setOnPreferenceClickListener(new InlineNotificationNuxWebpagePreference.1(inlineNotificationNuxWebpagePreference));
        preferenceCategory.addPreference(inlineNotificationNuxWebpagePreference);
        m669k(preferenceScreen);
        m661d(preferenceScreen);
        m669k(preferenceScreen);
        m663e(preferenceScreen);
        m670l(preferenceScreen);
        m653b();
    }

    private void m651a(String str) {
        this.ab.setText(str);
        this.ab.getEditText().setText("");
    }

    private Preference m639a() {
        Preference createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        createPreferenceScreen.setTitle("Push Registration");
        Preference preference = new Preference(this);
        preference.setTitle("Device ID");
        preference.setSummary(this.f620f.a());
        createPreferenceScreen.addPreference(preference);
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference.a((PrefKey) SharedPrefKeys.c.a("mqttlite_notif"));
        checkBoxOrSwitchPreference.setTitle(2131233108);
        checkBoxOrSwitchPreference.setSummary(2131233109);
        checkBoxOrSwitchPreference.setDefaultValue(Boolean.valueOf(false));
        final SharedPreferences sharedPreferences = getSharedPreferences("mqtt_debug", 4);
        checkBoxOrSwitchPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f555b;

            public boolean onPreferenceChange(Preference preference, Object obj) {
                sharedPreferences.edit().putBoolean("is_on", ((Boolean) obj).booleanValue()).commit();
                return true;
            }
        });
        createPreferenceScreen.addPreference(checkBoxOrSwitchPreference);
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference2 = new CheckBoxOrSwitchPreference(this);
        checkBoxOrSwitchPreference2.setTitle(2131233105);
        checkBoxOrSwitchPreference2.setSummary(2131233106);
        checkBoxOrSwitchPreference2.setDefaultValue(Boolean.valueOf(false));
        checkBoxOrSwitchPreference2.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f556a;

            {
                this.f556a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                this.f556a.f615a.edit().putBoolean((PrefKey) SharedPrefKeys.a.a("mqtt/push_channel"), ((Boolean) obj).booleanValue()).commit();
                return true;
            }
        });
        createPreferenceScreen.addPreference(checkBoxOrSwitchPreference2);
        PreferenceCategory preferenceCategory = new PreferenceCategory(this);
        createPreferenceScreen.addPreference(preferenceCategory);
        m643a(preferenceCategory);
        for (ServiceType serviceType : this.f621g.a()) {
            PreferenceCategory preferenceCategory2 = new PreferenceCategory(this);
            createPreferenceScreen.addPreference(preferenceCategory2);
            m640a(preferenceCategory2, serviceType, this.f622h.a(serviceType), this.f623i);
        }
        return createPreferenceScreen;
    }

    private void m643a(PreferenceCategory preferenceCategory) {
        SharedPreferences a = SharedPreferencesCompatHelper.a.a(this.f634t, "rti.mqtt.flags", true);
        Set keySet = SharedPreferencesCompatHelper.a.a(this.f634t, "rti.mqtt.registrations", true).getAll().keySet();
        CharSequence string = a.getString("shared_status", "DISABLED");
        CharSequence string2 = a.getString("leader_package", "unset");
        preferenceCategory.setTitle("Shared Experiment");
        Preference preference = new Preference(this);
        preference.setTitle("Experiment Status");
        preference.setSummary(string);
        preferenceCategory.addPreference(preference);
        Preference preference2 = new Preference(this);
        preference2.setTitle("Leader Package");
        preference2.setSummary(string2);
        preferenceCategory.addPreference(preference2);
        if (keySet != null && !keySet.isEmpty()) {
            Preference preference3 = new Preference(this);
            preference3.setTitle("Registered Packages");
            preference3.setSummary(keySet.toString());
            preferenceCategory.addPreference(preference3);
        }
    }

    private Preference m640a(PreferenceCategory preferenceCategory, final ServiceType serviceType, final PushTokenHolder pushTokenHolder, final PushInitializer pushInitializer) {
        preferenceCategory.setTitle(serviceType.name());
        Preference preference = new Preference(this);
        preference.setTitle("Token");
        preference.setSummary(pushTokenHolder.a());
        preferenceCategory.addPreference(preference);
        preference = new Preference(this);
        preference.setTitle("Last Token Request Time");
        preference.setSummary(m642a(pushTokenHolder.l()));
        preferenceCategory.addPreference(preference);
        preference = new Preference(this);
        preference.setTitle("Last FBServer Register Time");
        preference.setSummary(m642a(pushTokenHolder.o()));
        preferenceCategory.addPreference(preference);
        OrcaListPreference orcaListPreference = new OrcaListPreference(this);
        orcaListPreference.setTitle("Register/Unregister");
        orcaListPreference.setSummary("Manually register/unregister " + serviceType.name() + ".");
        orcaListPreference.setDialogTitle(serviceType.name());
        orcaListPreference.setEntries(new CharSequence[]{"Clear Preference", "Register", "Ensure Registration", "Unregister"});
        orcaListPreference.setEntryValues(new CharSequence[]{"clear", "register", "ensure", "unregister"});
        orcaListPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f563d;

            public boolean onPreferenceChange(Preference preference, Object obj) {
                final String str = (String) obj;
                final PushManager a = pushInitializer.a(serviceType);
                ExecutorDetour.a(this.f563d.f624j, new Runnable(this) {
                    final /* synthetic */ AnonymousClass27 f559c;

                    public void run() {
                        if ("clear".equals(str)) {
                            pushTokenHolder.h();
                        } else if ("register".equals(str)) {
                            a.c();
                        } else if ("ensure".equals(str)) {
                            a.d();
                        } else if ("unregister".equals(str)) {
                            a.e();
                        }
                    }
                }, 1048335740);
                return false;
            }
        });
        preferenceCategory.addPreference(orcaListPreference);
        return preferenceCategory;
    }

    private static String m642a(long j) {
        if (j == 0) {
            return "";
        }
        return new SimpleDateFormat("MMM d, hh:mm:ss a z").format(new Date(j));
    }

    private void m645a(PreferenceGroup preferenceGroup, IProvidePreferences iProvidePreferences) {
        for (Preference preference : iProvidePreferences.a(this)) {
            if (!(preference instanceof OrcaGatedPreference) || ((OrcaGatedPreference) preference).a()) {
                preferenceGroup.addPreference(preference);
            }
        }
    }

    private void m644a(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setTitle("Override A Gk");
        preference.setIntent(new Intent(this, GkSettingsListActivity.class));
        preferenceGroup.addPreference(preference);
    }

    private void m654b(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setTitle("Refresh All Gks");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f564a;

            {
                this.f564a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                ((GkRefresherTask) this.f564a.f628n.get()).a(this.f564a.getApplicationContext(), new Void[0]);
                return true;
            }
        });
        preferenceGroup.addPreference(preference);
    }

    private void m658c(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setTitle("Refresh trace upload rate limit");
        preference.setSummary("Sets the last upload timestamp to 0 so we can upload trace files for debugging");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f565a;

            {
                this.f565a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                this.f565a.f636v.a.edit().putLong("LastRunTime", 0).commit();
                return true;
            }
        });
        preferenceGroup.addPreference(preference);
    }

    private void m660d(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setTitle("Resets PerfDebugTracer state");
        preference.setSummary("If the current request is stuck, resets the tracing state so that another trace can be requested");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f567a;

            {
                this.f567a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                this.f567a.f594C.b();
                return true;
            }
        });
        preferenceGroup.addPreference(preference);
    }

    private void m662e(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setTitle("Force Configuration Fetch");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f568a;

            {
                this.f568a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                new ConfigurationRefreshUpdaterDialogFragment().a(this.f568a.c(), "config_refresh");
                return true;
            }
        });
        preferenceGroup.addPreference(preference);
    }

    private void m664f(PreferenceGroup preferenceGroup) {
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Crash the app");
        preferenceGroup.addPreference(preferenceCategory);
        preferenceCategory = new Preference(this);
        preferenceCategory.setTitle("Soft Error");
        preferenceCategory.setSummary("Report a soft error");
        preferenceCategory.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f569a;

            {
                this.f569a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                this.f569a.f633s.a("UserTriggeredReport", "User triggered soft error from Intern settings");
                return true;
            }
        });
        preferenceGroup.addPreference(preferenceCategory);
        preferenceCategory = new Preference(this);
        preferenceCategory.setTitle("Native crash");
        preferenceCategory.setSummary("Cause a native crash");
        preferenceCategory.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f570a;

            {
                this.f570a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                BreakpadManager.crashThisProcess();
                return true;
            }
        });
        preferenceGroup.addPreference(preferenceCategory);
        Preference preference = new Preference(this);
        preference.setTitle("Java Crash");
        preference.setSummary("Cause a Java crash");
        preference.setOnPreferenceClickListener(new DebugPreferencesFactory.1());
        preferenceGroup.addPreference(preference);
        preference = new Preference(this);
        preference.setTitle("Out Of Memory Crash");
        preference.setSummary("Cause an out of memory crash");
        preference.setOnPreferenceClickListener(new 2());
        preferenceGroup.addPreference(preference);
        preference = new Preference(this);
        preference.setTitle("App Not Responding Error");
        preference.setSummary("Simulate a stalled main thread");
        preference.setOnPreferenceClickListener(new 3());
        preferenceGroup.addPreference(preference);
        preference = new Preference(this);
        preference.setTitle("App Not Responding (recover)");
        preference.setSummary("Simulate a stalled main thread and come back after 10 seconds");
        preference.setOnPreferenceClickListener(new 4());
        preferenceGroup.addPreference(preference);
    }

    private void m665g(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setTitle("Fundraiser Donation Flow");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f571a;

            {
                this.f571a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                this.f571a.f618d.a(this.f571a.f634t, StringFormatUtil.formatStrLocaleSafe(FBLinks.eV, "10206909626159579", "fb4a_intern_settings"));
                return true;
            }
        });
        preferenceGroup.addPreference(preference);
    }

    private void m666h(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setTitle("Fundraiser Page");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f572a;

            {
                this.f572a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                this.f572a.f618d.a(this.f572a.f634t, StringFormatUtil.formatStrLocaleSafe(FBLinks.eW, "1491884814456113", "0"));
                return true;
            }
        });
        preferenceGroup.addPreference(preference);
    }

    private void m667i(PreferenceGroup preferenceGroup) {
        OrcaEditTextPreference orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.setTitle("Launch Goodwill Anniversary Video Editor");
        orcaEditTextPreference.setDialogTitle("Campaign ID");
        orcaEditTextPreference.setText("10101979261720443");
        orcaEditTextPreference.getEditText().setSingleLine(true);
        orcaEditTextPreference.getEditText().setImeOptions(6);
        orcaEditTextPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f573a;

            {
                this.f573a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                if (!(obj instanceof String)) {
                    return false;
                }
                this.f573a.f618d.a(this.f573a.f634t, StringFormatUtil.formatStrLocaleSafe(FBLinks.em, obj));
                return true;
            }
        });
        preferenceGroup.addPreference(orcaEditTextPreference);
        orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.setTitle("Launch Goodwill Friends Day Video Editor");
        orcaEditTextPreference.setDialogTitle("Promotion ID");
        orcaEditTextPreference.setText("10101969534793283");
        orcaEditTextPreference.getEditText().setSingleLine(true);
        orcaEditTextPreference.getEditText().setImeOptions(6);
        orcaEditTextPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f574a;

            {
                this.f574a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                if (!(obj instanceof String)) {
                    return false;
                }
                this.f574a.f618d.a(this.f574a.f634t, StringFormatUtil.formatStrLocaleSafe(FBLinks.eo, obj, "debug_menu"));
                return true;
            }
        });
        preferenceGroup.addPreference(orcaEditTextPreference);
    }

    private void m668j(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setTitle("Open website with fb://webview");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ InternSettingsActivity f575a;

            {
                this.f575a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                Uri parse = Uri.parse(FBLinks.a("webview/?url=https%3A%2F%2Fwww.facebook.com"));
                Intent a = this.f575a.f595D.a(this.f575a.f634t, parse.toString());
                if (a == null) {
                    a = new Intent("android.intent.action.VIEW", parse);
                    a.addFlags(268435456);
                }
                try {
                    if (!FacebookUriUtil.g(parse) || a.getBooleanExtra("force_external_browser", false)) {
                        this.f575a.f619e.b(a, this.f575a.f634t);
                        return true;
                    }
                    this.f575a.f619e.a(a, this.f575a.f634t);
                    return true;
                } catch (Exception e) {
                    Toast.makeText(this.f575a.getApplicationContext(), "Couldn't start activity", 0).show();
                }
            }
        });
        preferenceGroup.addPreference(preference);
    }

    private void m655b(PreferenceScreen preferenceScreen) {
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Instant Articles");
        preferenceScreen.addPreference(preferenceCategory);
        OrcaEditTextPreference orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.setTitle("Launch article by ID");
        orcaEditTextPreference.setDialogTitle("Article ID");
        orcaEditTextPreference.getEditText().setSingleLine(true);
        orcaEditTextPreference.getEditText().setInputType(2);
        orcaEditTextPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f576a;

            {
                this.f576a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                if (!(obj instanceof String)) {
                    return false;
                }
                Intent intent = new Intent();
                intent.putExtra("extra_instant_articles_id", (String) obj);
                intent.putExtra("extra_instant_articles_referrer", "settings");
                this.f576a.f619e.b(intent, this.f576a.f634t);
                return true;
            }
        });
        preferenceCategory.addPreference(orcaEditTextPreference);
    }

    private void m659c(PreferenceScreen preferenceScreen) {
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Aldrin");
        preferenceScreen.addPreference(preferenceCategory);
        preferenceCategory.addPreference(new LaunchAldrinInternSettingsPreference(this));
    }

    private void m661d(PreferenceScreen preferenceScreen) {
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Gametime");
        preferenceScreen.addPreference(preferenceCategory);
        OrcaEditTextWithHistoryPreference orcaEditTextWithHistoryPreference = new OrcaEditTextWithHistoryPreference(this);
        orcaEditTextWithHistoryPreference.a(new PrefKey(SharedPrefKeys.c, "gametime_internal_preferences"));
        orcaEditTextWithHistoryPreference.setTitle("Launch match by page ID");
        orcaEditTextWithHistoryPreference.setDialogTitle("Page ID");
        orcaEditTextWithHistoryPreference.getEditText().setSingleLine(true);
        orcaEditTextWithHistoryPreference.getEditText().setInputType(2);
        orcaEditTextWithHistoryPreference.getEditText().setHint("This hint is purposefully long to make this line long enough to fit the whole screen");
        orcaEditTextWithHistoryPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ InternSettingsActivity f578a;

            {
                this.f578a = r1;
            }

            public boolean onPreferenceChange(Preference preference, Object obj) {
                if (!(obj instanceof String)) {
                    return false;
                }
                this.f578a.f604M.m23a((String) obj, GametimeRef.INTERN_SETTINGS, this.f578a.f634t);
                return true;
            }
        });
        preferenceCategory.addPreference(orcaEditTextWithHistoryPreference);
    }

    private void m663e(PreferenceScreen preferenceScreen) {
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle("Inline Composer Prompts");
        preferenceScreen.addPreference(preferenceCategory);
        Preference preference = new Preference(this);
        preference.setTitle("Discarded Prompt");
        preference.setSummary("Show reasons why prompts are not seen");
        preference.setIntent(new Intent(this, PromptsInternalSettingsActivity.class));
        preferenceCategory.addPreference(preference);
    }

    private void m653b() {
        this.ad.clear();
        for (int i = 0; i < this.ac.getPreferenceCount(); i++) {
            this.ad.add(this.ac.getPreference(i));
        }
    }

    private void m657b(String str) {
        String toLowerCase = str.toLowerCase(Locale.US);
        this.ac.removeAll();
        if (TextUtils.isEmpty(toLowerCase)) {
            m646a(this.ac);
        } else {
            this.ac.addPreference(this.ab);
            for (Preference preference : this.ad) {
                m652a(toLowerCase, preference, preference, this.ac);
            }
        }
        onContentChanged();
    }

    private void m652a(String str, Preference preference, Preference preference2, PreferenceScreen preferenceScreen) {
        if (preference.getTitle() != null && preference.getTitle().toString().toLowerCase(Locale.US).contains(str)) {
            preferenceScreen.addPreference(preference2);
        } else if (preference instanceof PreferenceCategory) {
            PreferenceCategory preferenceCategory = (PreferenceCategory) preference;
            for (int i = 0; i < preferenceCategory.getPreferenceCount(); i++) {
                m652a(str, preferenceCategory.getPreference(i), preference2, preferenceScreen);
            }
        }
    }

    private void m669k(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setLayoutResource(2130905056);
        preferenceGroup.addPreference(preference);
    }

    private void m670l(PreferenceGroup preferenceGroup) {
        if (this.f606O.booleanValue()) {
            m669k(preferenceGroup);
            Preference preferenceCategory = new PreferenceCategory(this);
            preferenceGroup.addPreference(preferenceCategory);
            preferenceCategory.setTitle("Facebook at Work");
            Preference preference = new Preference(this);
            preferenceCategory.addPreference(preference);
            preference.setTitle("Pop SSO reauth notification");
            preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
                final /* synthetic */ InternSettingsActivity f579a;

                {
                    this.f579a = r1;
                }

                public boolean onPreferenceClick(Preference preference) {
                    this.f579a.f605N.a(new Intent().setAction("com.facebook.work.reauth.POP_REAUTH_NOTIF"));
                    return true;
                }
            });
            preference = new Preference(this);
            preferenceCategory.addPreference(preference);
            preference.setTitle("Open blocking SSO dialog now");
            preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
                final /* synthetic */ InternSettingsActivity f580a;

                {
                    this.f580a = r1;
                }

                public boolean onPreferenceClick(Preference preference) {
                    this.f580a.f605N.a(new Intent().setAction("com.facebook.work.reauth.NEED_REAUTH_NOW"));
                    return true;
                }
            });
        }
    }
}
