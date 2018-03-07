package com.facebook.katana;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ParseException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.tagging.AnalyticsActivityWithExtraData;
import com.facebook.appindexing.AppIndexingLogger;
import com.facebook.appindexing.AppIndexingLogger.EventType;
import com.facebook.base.activity.DeliverOnNewIntentWhenFinishing;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.deeplinking.activity.ActivityWithDeepLinking;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.IntentHandlerUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.android.gms.appindexing.AndroidAppUri;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DeliverOnNewIntentWhenFinishing
/* compiled from: via_chat_bar_nearby_friends_section */
public class IntentUriHandler extends FbFragmentActivity implements AnalyticsActivityWithExtraData, ActivityWithDeepLinking {
    @Inject
    AppIndexingLogger f532p;
    @Inject
    IntentHandlerUtil f533q;

    private static <T extends Context> void m629a(Class<T> cls, T t) {
        m630a((Object) t, (Context) t);
    }

    public static void m630a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((IntentUriHandler) obj).m628a(new AppIndexingLogger(AnalyticsLoggerMethodAutoProvider.a(fbInjector)), IntentHandlerUtil.m1246a(fbInjector));
    }

    private void m628a(AppIndexingLogger appIndexingLogger, IntentHandlerUtil intentHandlerUtil) {
        this.f532p = appIndexingLogger;
        this.f533q = intentHandlerUtil;
    }

    public final void m635b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = IntentUriHandler.class;
        m630a((Object) this, (Context) this);
        m632j();
        this.f533q.m1253a((Context) this, getIntent());
    }

    public Uri getReferrer() {
        if (VERSION.SDK_INT >= 22) {
            return super.getReferrer();
        }
        return m631i();
    }

    protected final void m634a(Intent intent) {
        super.a(intent);
        startActivity(intent.setComponent(new ComponentName(this, IntentUriHandler.class)).addFlags(402653184));
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1698866101);
        super.onResume();
        finish();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1427838727, a);
    }

    public final Map<String, Object> m636c() {
        Map<String, Object> hashMap = new HashMap();
        Uri referrer = getReferrer();
        if (referrer != null) {
            hashMap.put("referrer", referrer.toString());
        }
        return hashMap;
    }

    public final String am_() {
        return "infrastructure";
    }

    private Uri m631i() {
        Intent intent = getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra == null) {
            return null;
        }
        try {
            return Uri.parse(stringExtra);
        } catch (ParseException e) {
            return null;
        }
    }

    private void m632j() {
        String k = m633k();
        Uri referrer = getReferrer();
        AppIndexingLogger appIndexingLogger = this.f532p;
        String str = null;
        if (referrer != null && k != null) {
            String host;
            String a;
            if (referrer.getScheme().equals("http") || referrer.getScheme().equals("https")) {
                str = "browser";
                host = referrer.getHost();
            } else if (referrer.getScheme().equals("android-app")) {
                AndroidAppUri a2 = AndroidAppUri.a(referrer);
                a = a2.a();
                Uri b = a2.b();
                if (b != null) {
                    host = b.getHost();
                    if ("com.google.android.googlequicksearchbox".equals(a)) {
                        str = "google_launcher";
                    } else if ("com.gau.go.launcherex".equals(a)) {
                        str = "go_launcher";
                    }
                } else {
                    return;
                }
            } else {
                host = null;
            }
            if (str != null) {
                a = referrer.toString();
                HoneyClientEventFast a3 = appIndexingLogger.a.a(EventType.APP_INDEXING_EVENT_TYPE.getEventName(), false);
                if (a3.a()) {
                    a3.a("app_indexing").a("launcher_type", str).a("launch_host", host).a("link_tag", k).a("referrer_uri", a).b();
                }
            }
        }
    }

    private String m633k() {
        return getIntent().getDataString();
    }
}
