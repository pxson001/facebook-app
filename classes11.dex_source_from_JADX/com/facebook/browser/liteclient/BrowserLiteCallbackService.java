package com.facebook.browser.liteclient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivityWithExtraData;
import com.facebook.analytics.timespent.TimeSpentEventReporter;
import com.facebook.base.service.FbService;
import com.facebook.browser.lite.ipc.BrowserLiteCallback.Stub;
import com.facebook.browser.lite.ipc.PrefetchCacheEntry;
import com.facebook.browser.liteclient.logging.BrowserOpenUrlLogger;
import com.facebook.browser.liteclient.logging.BrowserUserInteractionLogger;
import com.facebook.browser.prefetch.BrowserPrefetchCacheManager;
import com.facebook.browser.prefetch.BrowserPrefetchCacheManager.CacheEntry;
import com.facebook.browser.prefetch.qe.ExperimentsForBrowserPrefetchModule;
import com.facebook.bugreporter.BugReportSource;
import com.facebook.bugreporter.BugReporter;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.messaging.business.subscription.common.analytics.BusinessSubscriptionAnalyticsLogger;
import com.facebook.offers.fragment.OfferRenderingUtils;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.titlebar.GraphSearchIntentLauncher;
import com.facebook.ui.browser.BrowserCommandHandler;
import com.facebook.ui.browser.OpenWithAppHelper;
import com.facebook.ui.browser.logging.BrowserLoggingConstants;
import com.facebook.ui.browser.logging.BrowserLongClickLogger;
import com.facebook.ui.browser.prefs.BrowserPrefKey;
import com.facebook.webview.WebViewUriRedirector;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: md5_checksum_of_apk */
public class BrowserLiteCallbackService extends FbService {
    public static final String f5494a = BrowserLiteCallbackService.class.getSimpleName();
    public AbstractFbErrorReporter f5495b;
    public GooglePlayIntentHelper f5496c;
    public BrowserLongClickLogger f5497d;
    public NavigationLogger f5498e;
    public ImmediateActiveSecondReporter f5499f;
    public TimeSpentEventReporter f5500g;
    public BrowserLiteActivity f5501h;
    public AppStateManager f5502i;
    public SecureContextHelper f5503j;
    public WebViewUriRedirector f5504k;
    public BrowserOpenUrlLogger f5505l;
    public BugReporter f5506m;
    public BrowserUserInteractionLogger f5507n;
    public Provider<GraphSearchIntentLauncher> f5508o;
    public ComposerLauncher f5509p;
    public BrowserPrefetchCacheManager f5510q;
    public OfferRenderingUtils f5511r;
    public BrowserLiteMenuItemHandler f5512s;
    public GatekeeperStoreImpl f5513t;
    public InterstitialStartHelper f5514u;
    public BusinessSubscriptionAnalyticsLogger f5515v;
    public FbSharedPreferences f5516w;
    public DefaultAndroidThreadUtil f5517x;
    public AnalyticsLogger f5518y;

    /* compiled from: md5_checksum_of_apk */
    public class BrowserLiteActivity extends Activity implements AnalyticsActivityWithExtraData {
        public String f5490a;

        public final void m6702a(String str) {
            this.f5490a = str;
        }

        public final String am_() {
            return "webview";
        }

        public final Map<String, Object> m6703c() {
            return BrowserLoggingConstants.a(this.f5490a);
        }
    }

    /* compiled from: md5_checksum_of_apk */
    class BrowserLiteCallbackImpl extends Stub {
        final /* synthetic */ BrowserLiteCallbackService f5493a;

        /* compiled from: md5_checksum_of_apk */
        class C07141 implements Runnable {
            final /* synthetic */ BrowserLiteCallbackImpl f5491a;

            C07141(BrowserLiteCallbackImpl browserLiteCallbackImpl) {
                this.f5491a = browserLiteCallbackImpl;
            }

            public void run() {
                this.f5491a.f5493a.f5498e.b(this.f5491a.f5493a.f5501h);
                this.f5491a.f5493a.f5502i.w.c(this.f5491a.f5493a.f5501h);
            }
        }

        /* compiled from: md5_checksum_of_apk */
        class C07152 implements Runnable {
            final /* synthetic */ BrowserLiteCallbackImpl f5492a;

            C07152(BrowserLiteCallbackImpl browserLiteCallbackImpl) {
                this.f5492a = browserLiteCallbackImpl;
            }

            public void run() {
                this.f5492a.f5493a.f5498e.c(this.f5492a.f5493a.f5501h);
                this.f5492a.f5493a.f5502i.w.d(this.f5492a.f5493a.f5501h);
            }
        }

        public final void m6707a() {
            String str = BrowserLiteCallbackService.f5494a;
            this.f5493a.f5517x.a(new C07152(this));
            this.f5493a.f5497d.c();
        }

        public final void m6709a(String str, long j, long j2) {
            String str2 = BrowserLiteCallbackService.f5494a;
            Long.valueOf(j);
            Long.valueOf(j2);
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb4a_iab_video_log");
            honeyClientEvent.b("current_url", str);
            honeyClientEvent.a("started_playing", j);
            honeyClientEvent.a("duration", j2);
            this.f5493a.f5518y.a(honeyClientEvent);
        }

        public BrowserLiteCallbackImpl(BrowserLiteCallbackService browserLiteCallbackService) {
            this.f5493a = browserLiteCallbackService;
        }

        public final int m6706a(String str) {
            Object obj;
            String str2 = BrowserLiteCallbackService.f5494a;
            if (str == null || !str.startsWith(BrowserCommandHandler.a)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                return 2;
            }
            if (this.f5493a.f5513t.a(115, false) || !OpenWithAppHelper.a(this.f5493a, str, this.f5493a.f5495b, this.f5493a.f5496c)) {
                return 0;
            }
            return 1;
        }

        public final boolean m6720b(String str) {
            Intent b = this.f5493a.f5504k.b(this.f5493a, str);
            if (b == null) {
                return false;
            }
            b.setFlags(268435456);
            this.f5493a.f5503j.a(b, this.f5493a);
            return true;
        }

        public final boolean m6715a(String str, String str2, String str3) {
            return this.f5493a.f5511r.a(this.f5493a, str, str2, str3, null);
        }

        public final void m6711a(String str, Bundle bundle) {
            this.f5493a.f5501h.f5490a = str;
            String str2 = BrowserLiteCallbackService.f5494a;
            this.f5493a.f5517x.a(new C07141(this));
            this.f5493a.f5497d.b();
        }

        public final void m6712a(String str, String str2) {
            m6705g(str2);
            if (TextUtils.equals(str, str2)) {
                this.f5493a.f5497d.a();
            }
        }

        public final void m6721c(String str) {
            this.f5493a.f5497d.a(true, str);
            this.f5493a.f5514u.a(this.f5493a, new InterstitialTrigger(Action.BUILT_IN_BROWSER), InterstitialController.class, null);
        }

        public final void m6723d(String str) {
            this.f5493a.f5497d.a(true, str);
        }

        public final void m6710a(String str, long j, long j2, long j3, long j4, long j5, boolean z) {
            this.f5493a.f5505l.a(str, j, j2, j3, j4, j5, z);
        }

        public final void m6714a(long[] jArr) {
            for (int i = 0; i < jArr.length; i++) {
                this.f5493a.f5500g.a(jArr[i]);
                this.f5493a.f5499f.a(jArr[i]);
            }
        }

        public final void m6708a(int i) {
            switch (i) {
                case 1:
                    this.f5493a.f5498e.a("tap_top_left_nav");
                    return;
                case 2:
                    this.f5493a.f5498e.a("tap_back_button");
                    return;
                default:
                    this.f5493a.f5498e.a(null);
                    return;
            }
        }

        private void m6705g(String str) {
            this.f5493a.f5498e.a("system_page_load").a(null, "webview", "webview", null, BrowserLoggingConstants.a(str));
        }

        public final void m6713a(Map map) {
            Uri uri = (Uri) map.get("screenshot_uri");
            List arrayList = new ArrayList();
            arrayList.add(uri);
            Map map2 = (Map) map.get("debug_info_map");
            Builder builder = new Builder();
            for (Object next : map2.keySet()) {
                builder.b((String) next, (String) map2.get(next));
            }
            this.f5493a.f5506m.a(this.f5493a, BugReportSource.DEFAULT, RegularImmutableSet.a, Optional.of(Long.valueOf(210094942460077L)), arrayList, (Uri) map.get("raw_view_description_file_uri"), builder.b());
        }

        public final void m6719b(Map map) {
            this.f5493a.f5507n.a(map);
            this.f5493a.f5512s.m6761a(map);
        }

        public final void m6718b(String str, String str2) {
            this.f5493a.f5515v.a("browser", str, str2);
        }

        public final void m6722c(String str, String str2) {
            m6704d(str, str2);
            Map hashMap = new HashMap();
            hashMap.put("action", "QUOTE_SHARE");
            this.f5493a.f5507n.a(hashMap);
        }

        public final void m6724e(String str) {
            ((GraphSearchIntentLauncher) this.f5493a.f5508o.get()).b(GraphSearchQuery.a("", ScopedEntityType.URL, "", str, null, false));
        }

        private void m6704d(String str, String str2) {
            ComposerSourceType composerSourceType = ComposerSourceType.EXTERNAL;
            ComposerShareParams.Builder a = ComposerShareParams.Builder.a(str2);
            a.f = str;
            this.f5493a.f5509p.a(null, ComposerConfigurationFactory.b(composerSourceType, a.b()).setInitialTargetData(ComposerTargetData.a).setIsFireAndForget(true).a(), this.f5493a);
        }

        public final List m6716b() {
            Set keySet;
            BrowserPrefetchCacheManager browserPrefetchCacheManager = this.f5493a.f5510q;
            if (browserPrefetchCacheManager.g.a(ExperimentsForBrowserPrefetchModule.h, 0) > 0) {
                keySet = browserPrefetchCacheManager.j.keySet();
            } else {
                keySet = new HashSet();
            }
            return new ArrayList(keySet);
        }

        @Nullable
        public final PrefetchCacheEntry m6725f(String str) {
            String c = this.f5493a.f5510q.c(str);
            if (TextUtils.isEmpty(c)) {
                return null;
            }
            CacheEntry d = this.f5493a.f5510q.d(c);
            if (d != null) {
                return new PrefetchCacheEntry(c, d.c, d.d, d.e);
            }
            return null;
        }

        public final void m6717b(int i) {
            if (i == 100) {
                this.f5493a.f5516w.edit().a(BrowserPrefKey.h).commit();
            } else {
                this.f5493a.f5516w.edit().a(BrowserPrefKey.h, i).commit();
            }
        }
    }

    private static <T extends Context> void m6728a(Class<T> cls, T t) {
        m6729a((Object) t, (Context) t);
    }

    public static void m6729a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BrowserLiteCallbackService) obj).m6727a((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), BrowserLongClickLogger.a(injectorLike), NavigationLogger.a(injectorLike), ImmediateActiveSecondReporter.a(injectorLike), TimeSpentEventReporter.a(injectorLike), AppStateManager.a(injectorLike), GooglePlayIntentHelper.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), WebViewUriRedirector.a(injectorLike), BrowserOpenUrlLogger.a(injectorLike), BrowserUserInteractionLogger.a(injectorLike), BugReporter.a(injectorLike), IdBasedProvider.a(injectorLike, 10888), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), BrowserPrefetchCacheManager.a(injectorLike), OfferRenderingUtils.a(injectorLike), BrowserLiteMenuItemHandler.m6759a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), InterstitialStartHelper.a(injectorLike), BusinessSubscriptionAnalyticsLogger.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public final void m6754a() {
        super.a();
        AppInitLockHelper.a(this);
        Class cls = BrowserLiteCallbackService.class;
        m6729a((Object) this, (Context) this);
    }

    @Inject
    private void m6727a(FbErrorReporter fbErrorReporter, BrowserLongClickLogger browserLongClickLogger, NavigationLogger navigationLogger, ImmediateActiveSecondReporter immediateActiveSecondReporter, TimeSpentEventReporter timeSpentEventReporter, AppStateManager appStateManager, GooglePlayIntentHelper googlePlayIntentHelper, SecureContextHelper secureContextHelper, WebViewUriRedirector webViewUriRedirector, BrowserOpenUrlLogger browserOpenUrlLogger, BrowserUserInteractionLogger browserUserInteractionLogger, BugReporter bugReporter, Provider<GraphSearchIntentLauncher> provider, ComposerLauncher composerLauncher, BrowserPrefetchCacheManager browserPrefetchCacheManager, OfferRenderingUtils offerRenderingUtils, BrowserLiteMenuItemHandler browserLiteMenuItemHandler, GatekeeperStore gatekeeperStore, InterstitialStartHelper interstitialStartHelper, BusinessSubscriptionAnalyticsLogger businessSubscriptionAnalyticsLogger, FbSharedPreferences fbSharedPreferences, AndroidThreadUtil androidThreadUtil, AnalyticsLogger analyticsLogger) {
        this.f5495b = fbErrorReporter;
        this.f5497d = browserLongClickLogger;
        this.f5498e = navigationLogger;
        this.f5499f = immediateActiveSecondReporter;
        this.f5500g = timeSpentEventReporter;
        this.f5502i = appStateManager;
        this.f5496c = googlePlayIntentHelper;
        this.f5503j = secureContextHelper;
        this.f5501h = new BrowserLiteActivity();
        this.f5504k = webViewUriRedirector;
        this.f5505l = browserOpenUrlLogger;
        this.f5507n = browserUserInteractionLogger;
        this.f5506m = bugReporter;
        this.f5508o = provider;
        this.f5509p = composerLauncher;
        this.f5510q = browserPrefetchCacheManager;
        this.f5511r = offerRenderingUtils;
        this.f5512s = browserLiteMenuItemHandler;
        this.f5513t = gatekeeperStore;
        this.f5514u = interstitialStartHelper;
        this.f5515v = businessSubscriptionAnalyticsLogger;
        this.f5516w = fbSharedPreferences;
        this.f5517x = androidThreadUtil;
        this.f5518y = analyticsLogger;
    }

    public IBinder onBind(Intent intent) {
        return new BrowserLiteCallbackImpl(this);
    }
}
