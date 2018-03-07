package com.facebook.ui.browser.lite;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.analytics.CounterLogger;
import com.facebook.auth.credentials.SessionCookie;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.browser.lite.BrowserLiteActivity;
import com.facebook.browser.lite.ipc.BrowserLiteIntent.Builder;
import com.facebook.browser.lite.ipc.PrefetchCacheEntry;
import com.facebook.browser.liteclient.logging.BrowserOpenUrlLogger;
import com.facebook.browser.liteclient.qe.ExperimentsForBrowserLiteQEModule;
import com.facebook.browser.liteclient.util.FbBrowserUtil;
import com.facebook.browser.prefetch.BrowserPrefetchCacheManager;
import com.facebook.browser.prefetch.BrowserPrefetchCacheManager.CacheEntry;
import com.facebook.browser.prefetch.BrowserPrefetcher;
import com.facebook.bugreporter.BugReporterPrefKeys;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.localstats.LocalStatsLogger;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.browser.prefs.BrowserPrefKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: titlebar_search_pressed */
public class BrowserLiteIntentHandler {
    private static final PrefKey f1534a = ((PrefKey) ((PrefKey) SharedPrefKeys.a.a("fb_android/")).a("in_app_browser_profiling"));
    private static final PrefKey f1535b = ((PrefKey) ((PrefKey) SharedPrefKeys.a.a("fb_android/")).a("in_app_browser_debug_overlay"));
    private final LoggedInUserSessionManager f1536c;
    private final ObjectMapper f1537d;
    private final String f1538e;
    public final MessengerAppUtils f1539f;
    private final BrowserPrefetcher f1540g;
    private final BrowserPrefetchCacheManager f1541h;
    private final Provider<TriState> f1542i;
    private final FbSharedPreferences f1543j;
    private final boolean f1544k;
    private final BrowserOpenUrlLogger f1545l;
    private final Provider<TriState> f1546m;
    private final CounterLogger f1547n;
    private final LocalStatsLoggerImpl f1548o;
    public final QeAccessor f1549p;
    private final Product f1550q;
    private final GatekeeperStoreImpl f1551r;

    public static BrowserLiteIntentHandler m1616b(InjectorLike injectorLike) {
        return new BrowserLiteIntentHandler(LoggedInUserSessionManager.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), AppVersionInfoMethodAutoProvider.a(injectorLike), BrowserPrefetcher.a(injectorLike), BrowserPrefetchCacheManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), BrowserOpenUrlLogger.a(injectorLike), CounterLogger.a(injectorLike), LocalStatsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 640), MessengerAppUtils.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 794), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public static BrowserLiteIntentHandler m1610a(InjectorLike injectorLike) {
        return m1616b(injectorLike);
    }

    @Inject
    public BrowserLiteIntentHandler(LoggedInUserAuthDataStore loggedInUserAuthDataStore, ObjectMapper objectMapper, Product product, AppVersionInfo appVersionInfo, BrowserPrefetcher browserPrefetcher, BrowserPrefetchCacheManager browserPrefetchCacheManager, FbSharedPreferences fbSharedPreferences, BrowserOpenUrlLogger browserOpenUrlLogger, CounterLogger counterLogger, LocalStatsLogger localStatsLogger, Provider<TriState> provider, MessengerAppUtils messengerAppUtils, Boolean bool, Provider<TriState> provider2, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore) {
        this.f1536c = loggedInUserAuthDataStore;
        this.f1537d = objectMapper;
        this.f1550q = product;
        this.f1538e = FbBrowserUtil.a(product, appVersionInfo);
        this.f1540g = browserPrefetcher;
        this.f1541h = browserPrefetchCacheManager;
        this.f1543j = fbSharedPreferences;
        this.f1545l = browserOpenUrlLogger;
        this.f1547n = counterLogger;
        this.f1548o = localStatsLogger;
        this.f1542i = provider;
        this.f1539f = messengerAppUtils;
        this.f1544k = bool.booleanValue();
        this.f1546m = provider2;
        this.f1549p = qeAccessor;
        this.f1551r = gatekeeperStore;
    }

    private boolean m1615a() {
        return this.f1550q == Product.PAA;
    }

    private String m1611a(Intent intent) {
        Object stringExtra = intent.getStringExtra("custom_user_agent_suffix");
        if (TextUtils.isEmpty(stringExtra)) {
            return this.f1538e;
        }
        intent.removeExtra("custom_user_agent_suffix");
        return this.f1538e + stringExtra;
    }

    private ArrayList<String> m1617b() {
        ImmutableList a = SessionCookie.a(this.f1537d, this.f1536c.a().mSessionCookiesString);
        ArrayList<String> arrayList = new ArrayList();
        if (a != null) {
            int size = a.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(((SessionCookie) a.get(i)).toString());
            }
        }
        return arrayList;
    }

    private void m1619b(Builder builder, Context context) {
        Object obj = (this.f1539f.a() && this.f1539f.d()) ? 1 : null;
        if (obj != null) {
            builder.a(context.getResources().getString(this.f1544k ? 2131236849 : 2131236848), 2130837864, "SHARE_MESSENGER");
        }
        Builder a = builder.a(context.getResources().getString(2131236846), 2130837858, "COPY_LINK");
        a.a("MENU_OPEN_WITH", -1, null);
        a.a(context.getResources().getString(2131236850), 2130837870, "SAVE_LINK");
    }

    private boolean m1620d() {
        if (BuildConstants.i) {
            return true;
        }
        if (this.f1542i.get() == TriState.YES && this.f1543j.a(BugReporterPrefKeys.c, true)) {
            return true;
        }
        return false;
    }

    private boolean m1621e() {
        return VERSION.SDK_INT >= 19 && this.f1543j.a(f1534a, false);
    }

    private boolean m1622f() {
        return this.f1543j.a(f1535b, false);
    }

    private boolean m1623g() {
        return this.f1549p.a(ExperimentsForBrowserLiteQEModule.a, false);
    }

    private static void m1614a(Builder builder, Context context) {
        String string = context.getResources().getString(2131236852);
        String str = "SHARE_TIMELINE";
        String str2 = "facebook.com";
        Bundle bundle = new Bundle();
        bundle.putString("KEY_LABEL", string);
        if (str2 != null) {
            bundle.putString("KEY_BLACKLIST_DOMAIN", str2);
        }
        bundle.putString("action", str);
        builder.a.putExtra("BrowserLiteIntent.EXTRA_ACTION_BUTTON", bundle);
    }

    private void m1613a(Builder builder) {
        if (this.f1549p.a(ExperimentsForBrowserLiteQEModule.d, false)) {
            builder.a.putExtra("BrowserLiteIntent.EXTRA_IS_BURD_V1_ENABLED", true);
            if (this.f1549p.a(ExperimentsForBrowserLiteQEModule.g, false)) {
                builder.j(true);
            }
        }
        if (this.f1549p.a(ExperimentsForBrowserLiteQEModule.e, false)) {
            builder.a.putExtra("BrowserLiteIntent.EXTRA_IS_BURD_V1_WHITE_CHROME_ENABLED", true);
            builder.j(true);
        }
    }

    public final void m1624a(Intent intent, Context context) {
        Uri data = intent.getData();
        intent.setComponent(new ComponentName(context, BrowserLiteActivity.class));
        Builder builder = new Builder();
        builder.a.putExtra("BrowserLiteIntent.EXTRA_ANIMATION", new int[]{2130968752, 2130968614, 2130968724, 2130968767});
        Builder a = builder.c(m1611a(intent)).a(context.getResources().getConfiguration().locale);
        if (this.f1536c.b()) {
            a.a("https://facebook.com/", m1617b());
            if (m1615a()) {
                m1618b(a);
                intent.putExtras(a.a());
                return;
            }
            if (!intent.getBooleanExtra("should_hide_menu", false)) {
                intent.removeExtra("should_hide_menu");
                m1614a(a, context);
                m1619b(a, context);
            }
            if ("messenger".equals(intent.getStringExtra("iab_origin"))) {
                intent.removeExtra("iab_origin");
                a.b(this.f1544k ? "THEME_WORK_CHAT" : "THEME_MESSENGER");
                a.c(false);
            }
            Object stringExtra = intent.getStringExtra("post_url_data");
            if (!TextUtils.isEmpty(stringExtra)) {
                intent.removeExtra("post_url_data");
                a.d(stringExtra);
            }
            stringExtra = intent.getStringExtra("extra_js_to_execute");
            if (!TextUtils.isEmpty(stringExtra)) {
                intent.removeExtra("extra_js_to_execute");
                a.e(stringExtra);
            }
            if (BuildConstants.e()) {
                a.d(true);
            }
            if (m1620d()) {
                a.a(true);
            }
            if (m1621e()) {
                a.e(true);
            }
            if (m1623g()) {
                a.f(true);
            }
            if (this.f1551r.a(129, false)) {
                a.i(true);
            }
            if (m1622f()) {
                a.h(true);
            }
            int a2 = this.f1549p.a(ExperimentsForBrowserLiteQEModule.f, 0);
            if (a2 != 0) {
                a.a(a2);
            }
            a2 = this.f1549p.a(ExperimentsForBrowserLiteQEModule.c, -1);
            if (a2 >= 0) {
                a.b(a2);
            }
            m1613a(a);
            if (this.f1549p.a(ExperimentsForBrowserLiteQEModule.j, false)) {
                a.n(true);
            }
            if (this.f1549p.a(ExperimentsForBrowserLiteQEModule.h, false)) {
                a.k(true);
                a2 = this.f1543j.a(BrowserPrefKey.h, -1);
                if (this.f1549p.a(ExperimentsForBrowserLiteQEModule.i, false)) {
                    a.l(true);
                } else if (a2 != -1 && a2 < 100) {
                    a2 = -1;
                }
                if (a2 != -1) {
                    a.c(a2);
                }
            }
            Uri b = FacebookUriUtil.b(data);
            this.f1545l.a(b.toString(), m1612a(a, b), intent.getStringExtra("iab_click_source"), intent.getStringExtra("tracking_codes"));
            intent.putExtras(a.a());
            return;
        }
        a.c(false);
        intent.putExtras(a.a());
    }

    @Nullable
    private String m1612a(Builder builder, Uri uri) {
        if (!this.f1540g.a()) {
            return null;
        }
        this.f1540g.i();
        CounterLogger counterLogger = this.f1547n;
        LocalStatsLoggerImpl localStatsLoggerImpl = this.f1548o;
        BrowserPrefetcher browserPrefetcher = this.f1540g;
        BrowserPrefetchCacheManager browserPrefetchCacheManager = this.f1541h;
        if (uri != null && browserPrefetcher.a(uri)) {
            Object obj;
            counterLogger.a("browser_prefetch_load_url");
            localStatsLoggerImpl.a(1835018);
            String uri2 = uri.toString();
            if (browserPrefetcher.u.containsKey(uri2) || uri2.equals(browserPrefetcher.t) || browserPrefetcher.d.a(uri2)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                if (browserPrefetchCacheManager.a(uri2)) {
                    counterLogger.a("browser_prefetch_load_url_cache_hit");
                    localStatsLoggerImpl.a(1835019);
                } else {
                    counterLogger.a("browser_prefetch_load_url_cache_miss");
                    localStatsLoggerImpl.a(1835020);
                    if (uri2.equals(browserPrefetcher.t)) {
                        counterLogger.a("browser_prefetch_load_url_cache_miss_pity");
                        localStatsLoggerImpl.a(1835021);
                    }
                }
            }
        }
        String uri3 = uri.toString();
        String c = this.f1541h.c(uri3);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        CacheEntry d = this.f1541h.d(c);
        if (d != null) {
            builder.a(new PrefetchCacheEntry(c, d.c, d.d, d.e));
            this.f1540g.a(uri3, c, true);
            return "html";
        } else if (c.equals(uri3)) {
            return null;
        } else {
            builder.a(new PrefetchCacheEntry(c, null, null, null));
            this.f1540g.a(uri3, c, false);
            return "redirects";
        }
    }

    private static void m1618b(Builder builder) {
        builder.c(false).a.putExtra("BrowserLiteIntent.EXTRA_KILL_ON_EXIT", false);
    }
}
