package com.facebook.growth.campaign;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.init.ErrorReporterSecondaryInit;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.growth.prefs.CampaignPrefKeys;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: trace_info */
public class AdvertisingIdLogger {
    private final Context f805a;
    public final FbSharedPreferences f806b;
    private final AppVersionInfo f807c;
    public final Lazy<ExecutorService> f808d;
    private final Lazy<AnalyticsLogger> f809e;

    /* compiled from: trace_info */
    public class C00551 implements Runnable {
        final /* synthetic */ AdvertisingIdLogger f908a;

        public C00551(AdvertisingIdLogger advertisingIdLogger) {
            this.f908a = advertisingIdLogger;
        }

        public void run() {
            AdvertisingIdLogger.m1134b(this.f908a);
        }
    }

    public static AdvertisingIdLogger m1133b(InjectorLike injectorLike) {
        return new AdvertisingIdLogger((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), AppVersionInfoMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3832), IdBasedSingletonScopeProvider.b(injectorLike, 175));
    }

    @Inject
    public AdvertisingIdLogger(Context context, FbSharedPreferences fbSharedPreferences, AppVersionInfo appVersionInfo, Lazy<ExecutorService> lazy, Lazy<AnalyticsLogger> lazy2) {
        this.f805a = context;
        this.f806b = fbSharedPreferences;
        this.f807c = appVersionInfo;
        this.f808d = lazy;
        this.f809e = lazy2;
    }

    public static void m1134b(AdvertisingIdLogger advertisingIdLogger) {
        Object a = advertisingIdLogger.f807c.a();
        if (!TextUtils.isEmpty(a)) {
            String a2 = advertisingIdLogger.f806b.a(ErrorReporterSecondaryInit.b, "unknown");
            if (a.equals(a2) || "unknown".equals(a2)) {
                advertisingIdLogger.m1135c();
                advertisingIdLogger.f806b.edit().putBoolean(CampaignPrefKeys.f901b, true).commit();
            }
        }
    }

    private void m1135c() {
        String str;
        boolean z;
        HoneyClientEventFast a;
        String str2 = null;
        try {
            Info a2 = AdvertisingIdClient.m12400a(this.f805a);
            String a3 = a2.a();
            try {
                boolean z2 = !a2.b();
                str = a3;
                z = z2;
            } catch (Exception e) {
                str2 = a3;
                z = true;
                str = str2;
                a = ((AnalyticsLogger) this.f809e.get()).a("app_new_install", true);
                if (!a.a()) {
                    a.a("advertising_id", str);
                    a.a("tracking_enabled", z);
                    a.b();
                }
            }
        } catch (Exception e2) {
            z = true;
            str = str2;
            a = ((AnalyticsLogger) this.f809e.get()).a("app_new_install", true);
            if (!a.a()) {
                a.a("advertising_id", str);
                a.a("tracking_enabled", z);
                a.b();
            }
        }
        a = ((AnalyticsLogger) this.f809e.get()).a("app_new_install", true);
        if (!a.a()) {
            a.a("advertising_id", str);
            a.a("tracking_enabled", z);
            a.b();
        }
    }
}
