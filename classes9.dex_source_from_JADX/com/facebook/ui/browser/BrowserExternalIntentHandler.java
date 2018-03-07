package com.facebook.ui.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.browser.lite.util.BrowserURLUtil;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.AppInfo;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.ExternalIntentHandler;
import com.facebook.content.SecureContextHelper;
import com.facebook.device.DeviceMemoryInfoReader;
import com.facebook.device.DeviceMemoryInfoReaderMethodAutoProvider;
import com.facebook.device.resourcemonitor.ResourceManager;
import com.facebook.http.onion.TorProxy;
import com.facebook.http.onion.TorProxyMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.ui.browser.config.BrowserConfig;
import com.facebook.ui.browser.lite.BrowserLiteIntentHandler;
import com.facebook.ui.browser.prefs.BrowserPrefKey;
import com.facebook.xconfig.core.XConfigReader;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: topic_feeds_favorites */
public class BrowserExternalIntentHandler implements ExternalIntentHandler {
    private static final String f1497a = BrowserExternalIntentHandler.class.getSimpleName();
    public final FbSharedPreferences f1498b;
    private final AbstractFbErrorReporter f1499c;
    private final SequenceLogger f1500d;
    private final PerformanceLogger f1501e;
    private final XConfigReader f1502f;
    private final SecureContextHelper f1503g;
    private final Clock f1504h;
    private final Provider<TriState> f1505i;
    private final Provider<TriState> f1506j;
    private final DeviceMemoryInfoReader f1507k;
    private final Lazy<ResourceManager> f1508l;
    private final AnalyticsLogger f1509m;
    public final BrowserLiteIntentHandler f1510n;
    private final AppInfo f1511o;
    public final Provider<TriState> f1512p;
    public final Provider<TriState> f1513q;
    public final boolean f1514r;
    private final TorProxy f1515s;

    /* compiled from: topic_feeds_favorites */
    enum BrowserType {
        WEBVIEW,
        EXTERNAL
    }

    public static BrowserExternalIntentHandler m1575b(InjectorLike injectorLike) {
        return new BrowserExternalIntentHandler((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), XConfigReader.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), BrowserLiteIntentHandler.m1610a(injectorLike), IdBasedProvider.a(injectorLike, 793), IdBasedProvider.a(injectorLike, 786), DeviceMemoryInfoReaderMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 1066), AnalyticsLoggerMethodAutoProvider.a(injectorLike), AppInfo.a(injectorLike), IdBasedProvider.a(injectorLike, 800), IdBasedProvider.a(injectorLike, 787), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), TorProxyMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BrowserExternalIntentHandler(FbSharedPreferences fbSharedPreferences, SequenceLogger sequenceLogger, PerformanceLogger performanceLogger, XConfigReader xConfigReader, SecureContextHelper secureContextHelper, FbErrorReporter fbErrorReporter, Clock clock, BrowserLiteIntentHandler browserLiteIntentHandler, Provider<TriState> provider, Provider<TriState> provider2, DeviceMemoryInfoReader deviceMemoryInfoReader, Lazy<ResourceManager> lazy, AnalyticsLogger analyticsLogger, AppInfo appInfo, Provider<TriState> provider3, Provider<TriState> provider4, Boolean bool, TorProxy torProxy) {
        this.f1498b = fbSharedPreferences;
        this.f1500d = sequenceLogger;
        this.f1501e = performanceLogger;
        this.f1502f = xConfigReader;
        this.f1503g = secureContextHelper;
        this.f1499c = fbErrorReporter;
        this.f1504h = clock;
        this.f1510n = browserLiteIntentHandler;
        this.f1505i = provider;
        this.f1506j = provider2;
        this.f1507k = deviceMemoryInfoReader;
        this.f1508l = lazy;
        this.f1509m = analyticsLogger;
        this.f1511o = appInfo;
        this.f1512p = provider3;
        this.f1513q = provider4;
        this.f1514r = bool.booleanValue();
        this.f1515s = torProxy;
    }

    public final boolean m1582a(Intent intent, Context context) {
        return m1576b(intent, context);
    }

    public final boolean m1580a(Intent intent, int i, Activity activity) {
        return m1576b(intent, (Context) activity);
    }

    public final boolean m1581a(Intent intent, int i, Fragment fragment) {
        return m1576b(intent, fragment.getContext());
    }

    private boolean m1576b(Intent intent, Context context) {
        Object obj;
        if (intent != null && intent.getComponent() == null && BrowserURLUtil.a(intent.getData())) {
            obj = 1;
        } else {
            m1578c(intent);
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        Uri data = intent.getData();
        if (FacebookUriUtil.c(data) && "/auth.php".equalsIgnoreCase(data.getPath())) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return m1579c(intent, context);
        }
        switch (m1572a(intent)) {
            case WEBVIEW:
                this.f1510n.m1624a(intent, context);
                return false;
            default:
                m1578c(intent);
                return false;
        }
    }

    private BrowserType m1572a(Intent intent) {
        if (intent.getBooleanExtra("force_in_app_browser", false)) {
            return BrowserType.WEBVIEW;
        }
        if ((intent.getBooleanExtra("force_external_browser", false) && ((TriState) this.f1506j.get()).asBoolean(false)) || intent.getBooleanExtra("com.facebook.intent.extra.SKIP_IN_APP_BROWSER", false) || ((((TriState) this.f1513q.get()).asBoolean(false) && this.f1498b.a(BrowserPrefKey.a, false)) || this.f1515s.a())) {
            return BrowserType.EXTERNAL;
        }
        boolean z;
        if (this.f1514r && ((TriState) this.f1512p.get()).asBoolean(false)) {
            z = true;
        } else {
            z = ((TriState) this.f1513q.get()).asBoolean(false) && !this.f1498b.a(BrowserPrefKey.a, false);
        }
        if (z) {
            return BrowserType.WEBVIEW;
        }
        return BrowserType.EXTERNAL;
    }

    private boolean m1579c(Intent intent, Context context) {
        boolean z;
        Throwable e;
        Builder buildUpon;
        String str;
        Object queryParameter;
        boolean z2 = true;
        boolean z3 = this.f1504h.a() - this.f1498b.a(BrowserPrefKey.d, 0) > 86400000;
        if (VERSION.SDK_INT >= 19 || !z3) {
            z = true;
        } else {
            z = m1574a(this.f1502f.a(BrowserConfig.c, ""), context.getPackageManager().resolveActivity(intent, 65536).activityInfo.packageName);
        }
        if (z && z3) {
            z = true;
        } else {
            try {
                Uri parse = Uri.parse(Uri.parse(intent.getDataString()).getQueryParameter("url"));
                z = StringUtil.a(parse.getQueryParameter("bp"));
                if (z) {
                    try {
                        Object queryParameter2 = parse.getQueryParameter("url2");
                        if (StringUtil.a(queryParameter2)) {
                            throw new NullPointerException("Unwrapped Uri is null/empty");
                        }
                        intent.setData(Uri.parse(queryParameter2));
                        this.f1503g.b(intent, context);
                        return true;
                    } catch (NullPointerException e2) {
                        e = e2;
                        this.f1499c.a(SoftError.a(f1497a + ".maybeUseInAppBrowser", "Launching SSO to vulnerable browser due to exception").a(e).g());
                        if (z) {
                            this.f1498b.edit().a(BrowserPrefKey.d, this.f1504h.a()).commit();
                        }
                        if (BrowserType.WEBVIEW != m1572a(intent)) {
                            z2 = false;
                        }
                        buildUpon = intent.getData().buildUpon();
                        buildUpon.appendQueryParameter("redirect", z2 ? "0" : "1");
                        intent.setData(buildUpon.build());
                        m1578c(intent);
                        str = null;
                        if (intent.getData() != null) {
                            queryParameter = intent.getData().getQueryParameter("url");
                            if (!StringUtil.a(queryParameter)) {
                                str = Uri.parse(queryParameter).getQueryParameter("cb");
                            }
                        }
                        if (StringUtil.a(str)) {
                            return m1573a(intent, context, str);
                        }
                        return false;
                    }
                }
            } catch (NullPointerException e3) {
                e = e3;
                z = true;
                this.f1499c.a(SoftError.a(f1497a + ".maybeUseInAppBrowser", "Launching SSO to vulnerable browser due to exception").a(e).g());
                if (z) {
                    this.f1498b.edit().a(BrowserPrefKey.d, this.f1504h.a()).commit();
                }
                if (BrowserType.WEBVIEW != m1572a(intent)) {
                    z2 = false;
                }
                buildUpon = intent.getData().buildUpon();
                if (z2) {
                }
                buildUpon.appendQueryParameter("redirect", z2 ? "0" : "1");
                intent.setData(buildUpon.build());
                m1578c(intent);
                str = null;
                if (intent.getData() != null) {
                    queryParameter = intent.getData().getQueryParameter("url");
                    if (StringUtil.a(queryParameter)) {
                        str = Uri.parse(queryParameter).getQueryParameter("cb");
                    }
                }
                if (StringUtil.a(str)) {
                    return m1573a(intent, context, str);
                }
                return false;
            }
        }
        if (z) {
            this.f1498b.edit().a(BrowserPrefKey.d, this.f1504h.a()).commit();
        }
        if (BrowserType.WEBVIEW != m1572a(intent)) {
            z2 = false;
        }
        buildUpon = intent.getData().buildUpon();
        if (z2) {
        }
        buildUpon.appendQueryParameter("redirect", z2 ? "0" : "1");
        intent.setData(buildUpon.build());
        m1578c(intent);
        str = null;
        if (intent.getData() != null) {
            queryParameter = intent.getData().getQueryParameter("url");
            if (StringUtil.a(queryParameter)) {
                str = Uri.parse(queryParameter).getQueryParameter("cb");
            }
        }
        if (StringUtil.a(str)) {
            return m1573a(intent, context, str);
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m1573a(android.content.Intent r8, android.content.Context r9, java.lang.String r10) {
        /*
        r7 = this;
        r2 = 0;
        r4 = -1;
        r1 = 1;
        if (r9 == 0) goto L_0x0017;
    L_0x0005:
        r0 = r9 instanceof android.app.Activity;
        if (r0 == 0) goto L_0x0017;
    L_0x0009:
        if (r8 == 0) goto L_0x0017;
    L_0x000b:
        r0 = r8.getData();
        if (r0 == 0) goto L_0x0017;
    L_0x0011:
        r0 = com.facebook.common.util.StringUtil.a(r10);
        if (r0 == 0) goto L_0x0018;
    L_0x0017:
        return r1;
    L_0x0018:
        r0 = "1";
        r0 = r10.equals(r0);
        if (r0 != 0) goto L_0x0028;
    L_0x0020:
        r0 = "2";
        r0 = r10.equals(r0);
        if (r0 == 0) goto L_0x005c;
    L_0x0028:
        r0 = r9;
        r0 = (android.app.Activity) r0;
        r0 = r0.getCallingActivity();
        if (r0 == 0) goto L_0x0017;
    L_0x0031:
        r0 = r0.getPackageName();
        r3 = com.facebook.common.util.StringUtil.a(r0);
        if (r3 != 0) goto L_0x0017;
    L_0x003b:
        r3 = r7.f1502f;
        r5 = com.facebook.ui.browser.config.SSOConfig.c;
        r6 = "";
        r3 = r3.a(r5, r6);
        r3 = r7.m1577b(r3, r0);
        if (r3 == 0) goto L_0x0017;
    L_0x004b:
        r3 = r10.hashCode();
        switch(r3) {
            case 49: goto L_0x0071;
            case 50: goto L_0x007b;
            default: goto L_0x0052;
        };
    L_0x0052:
        r3 = r4;
    L_0x0053:
        switch(r3) {
            case 0: goto L_0x0085;
            default: goto L_0x0056;
        };
    L_0x0056:
        r8.setPackage(r0);
        r0 = r2;
    L_0x005a:
        r1 = r0;
        goto L_0x0017;
    L_0x005c:
        r0 = r10.trim();
        r3 = r7.f1502f;
        r5 = com.facebook.ui.browser.config.SSOConfig.d;
        r6 = "";
        r3 = r3.a(r5, r6);
        r3 = m1574a(r3, r0);
        if (r3 != 0) goto L_0x003b;
    L_0x0070:
        goto L_0x0017;
    L_0x0071:
        r3 = "1";
        r3 = r10.equals(r3);
        if (r3 == 0) goto L_0x0052;
    L_0x0079:
        r3 = r2;
        goto L_0x0053;
    L_0x007b:
        r3 = "2";
        r3 = r10.equals(r3);
        if (r3 == 0) goto L_0x0052;
    L_0x0083:
        r3 = r1;
        goto L_0x0053;
    L_0x0085:
        r0 = new android.content.Intent;
        r0.<init>();
        r2 = r8.getData();
        r0.setData(r2);
        r9 = (android.app.Activity) r9;
        r9.setResult(r4, r0);
        r0 = r1;
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.browser.BrowserExternalIntentHandler.a(android.content.Intent, android.content.Context, java.lang.String):boolean");
    }

    public static void m1578c(@Nullable Intent intent) {
        if (intent != null) {
            intent.removeExtra("og_title");
            intent.removeExtra("parent_story_id");
            intent.removeExtra("conversations_feedback_id");
            intent.removeExtra("tracking_codes");
            intent.removeExtra("com.facebook.intent.extra.SKIP_IN_APP_BROWSER");
            intent.removeExtra("force_external_browser");
            intent.removeExtra("post_url_data");
            intent.removeExtra("iab_click_source");
        }
    }

    private static boolean m1574a(String str, String str2) {
        for (String a : StringUtil.a(str, ',')) {
            if (StringUtil.a(a, str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean m1577b(String str, String str2) {
        if (StringUtil.a(str) || StringUtil.a(str2)) {
            return false;
        }
        for (String a : StringUtil.a(str, ',')) {
            String a2;
            List a3 = StringUtil.a(a2, '=');
            if (StringUtil.a((String) a3.get(0), str2)) {
                a2 = (String) a3.get(1);
                for (Signature toCharsString : this.f1511o.d(str2, 64).signatures) {
                    if (toCharsString.toCharsString().equals(a2)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }
}
