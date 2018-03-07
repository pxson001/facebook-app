package com.facebook.si;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.datastore.AuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.ExternalIntentHandler;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: media_question */
public class LinkshimExternalIntentHandler implements ExternalIntentHandler {
    private static final String f8994a = LinkshimExternalIntentHandler.class.getSimpleName();
    private final LinkshimUtil f8995b;
    private final LoggedInUserSessionManager f8996c;
    public final Provider<TriState> f8997d;
    private final AnalyticsLogger f8998e;

    public static LinkshimExternalIntentHandler m10711b(InjectorLike injectorLike) {
        return new LinkshimExternalIntentHandler(LinkshimUtil.m10718a(injectorLike), LoggedInUserSessionManager.a(injectorLike), IdBasedProvider.a(injectorLike, 773), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LinkshimExternalIntentHandler(LinkshimUtil linkshimUtil, AuthDataStore authDataStore, Provider<TriState> provider, AnalyticsLogger analyticsLogger) {
        this.f8995b = linkshimUtil;
        this.f8996c = authDataStore;
        this.f8997d = provider;
        this.f8998e = analyticsLogger;
    }

    public final boolean m10715a(Intent intent, Context context) {
        m10712a(intent);
        return false;
    }

    public final boolean m10713a(Intent intent, int i, Activity activity) {
        m10712a(intent);
        return false;
    }

    public final boolean m10714a(Intent intent, int i, Fragment fragment) {
        fragment.getContext();
        m10712a(intent);
        return false;
    }

    public final void m10712a(Intent intent) {
        if (((TriState) this.f8997d.get()).asBoolean(false)) {
            Uri data = intent.getData();
            if (data != null) {
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb_linkshim_single_link_attempt");
                Uri a = LinkshimUtil.m10717a(data);
                if (data.equals(a)) {
                    honeyClientEvent.b("result", "fail_url_not_rewritten");
                    this.f8998e.a(honeyClientEvent);
                } else if (StringUtil.a(this.f8996c.a().mSessionCookiesString)) {
                    honeyClientEvent.b("result", "fail_cookies_not_found");
                    this.f8998e.a(honeyClientEvent);
                } else {
                    data.toString();
                    a.toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("Referer", "http://m.facebook.com");
                    intent.putExtra("com.android.browser.headers", bundle);
                    intent.setData(a);
                    this.f8995b.m10721b(data);
                    honeyClientEvent.b("result", "success");
                    this.f8998e.a(honeyClientEvent);
                }
            }
        }
    }
}
