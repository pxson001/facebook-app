package com.facebook.growth.fb4areferral;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.googleplay.GooglePlayReferrerDataProcessor;
import com.facebook.growth.sem.SemTrackingLogger;
import com.facebook.inject.Lazy;
import com.facebook.registration.common.RegInstanceHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

/* compiled from: WEEKLY_LIKE */
public class Fb4aReferrerDataProcessor implements GooglePlayReferrerDataProcessor {
    public final AnalyticsLogger f10377a;
    public final RegInstanceHelper f10378b;
    public final SecureContextHelper f10379c;
    private final Lazy<SemTrackingLogger> f10380d;
    private final Lazy<Clock> f10381e;
    private final ObjectMapper f10382f;
    public final AppInitLock f10383g;
    public final Context f10384h;

    @Inject
    public Fb4aReferrerDataProcessor(AnalyticsLogger analyticsLogger, RegInstanceHelper regInstanceHelper, SecureContextHelper secureContextHelper, Lazy<SemTrackingLogger> lazy, Lazy<Clock> lazy2, ObjectMapper objectMapper, AppInitLock appInitLock, Context context) {
        this.f10377a = analyticsLogger;
        this.f10378b = regInstanceHelper;
        this.f10379c = secureContextHelper;
        this.f10380d = lazy;
        this.f10381e = lazy2;
        this.f10382f = objectMapper;
        this.f10383g = appInitLock;
        this.f10384h = context;
    }

    public final void mo256a(ImmutableMap<String, String> immutableMap) {
        String str;
        String str2;
        if (!StringUtil.a((CharSequence) immutableMap.get("utm_reg"))) {
            str = (String) immutableMap.get("utm_reg");
            str2 = (String) immutableMap.get("utm_source");
            if (StringUtil.a(str2)) {
                str2 = "unknown";
            }
            this.f10383g.b();
            this.f10378b.a(str);
            HoneyClientEventFast a = this.f10377a.a("reg_native_app_open", true);
            if (a.a()) {
                a.a("growth");
                a.a("source", str2);
                a.a("reg_instance", str);
                a.b();
            }
        }
        m10775d(immutableMap);
        if (!StringUtil.a(new CharSequence[]{(CharSequence) immutableMap.get("utm_uid"), (CharSequence) immutableMap.get("utm_nonce")})) {
            str = (String) immutableMap.get("utm_uid");
            str2 = (String) immutableMap.get("utm_nonce");
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("google_play_referrer_login_attempt");
            honeyClientEvent.c = "growth";
            honeyClientEvent.b("contactpoint", str);
            Builder buildUpon = Uri.parse("fblogin://login/fbauth/").buildUpon();
            buildUpon.appendQueryParameter("contactpoint", str);
            buildUpon.appendQueryParameter("nonce", str2);
            str = (String) immutableMap.get("landing_page");
            if (!StringUtil.a(str)) {
                buildUpon.appendQueryParameter("landing_page", str);
                honeyClientEvent.b("landing_page", str);
            }
            this.f10377a.c(honeyClientEvent);
            Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
            intent.setFlags(268435456);
            this.f10379c.a(intent, this.f10384h.getApplicationContext());
        }
    }

    private void m10775d(ImmutableMap<String, String> immutableMap) {
        String str = (String) immutableMap.get("campaign_id");
        String str2 = (String) immutableMap.get("utm_campaign");
        String valueOf = String.valueOf(((Clock) this.f10381e.get()).a() / 1000);
        if (!StringUtil.a(str) || !StringUtil.a(str2)) {
            try {
                ((SemTrackingLogger) this.f10380d.get()).a(this.f10382f.a(immutableMap), valueOf);
            } catch (JsonProcessingException e) {
                throw Throwables.propagate(e);
            }
        }
    }
}
