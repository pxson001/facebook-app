package com.facebook.backgroundlocation.nux;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLModels.BackgroundLocationPrivacyPickerOptionModel;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: download_pending */
public class BackgroundLocationNuxAnalyticsLogger {
    private static BackgroundLocationNuxAnalyticsLogger f14737g;
    private static final Object f14738h = new Object();
    private final AnalyticsLogger f14739a;
    public final RealtimeSinceBootClock f14740b;
    public long f14741c;
    public String f14742d;
    public boolean f14743e;
    public String f14744f;

    /* compiled from: download_pending */
    public enum MoreInfoType {
        LEARN_MORE,
        HELP_CENTER
    }

    private static BackgroundLocationNuxAnalyticsLogger m15110b(InjectorLike injectorLike) {
        return new BackgroundLocationNuxAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), RealtimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BackgroundLocationNuxAnalyticsLogger(AnalyticsLogger analyticsLogger, RealtimeSinceBootClock realtimeSinceBootClock) {
        this.f14739a = analyticsLogger;
        this.f14740b = realtimeSinceBootClock;
    }

    public final void m15111a() {
        this.f14739a.a(m15108a(this.f14743e ? "nearby_friends_informational_impression" : "nearby_friends_now_nux_impression"));
    }

    public static BackgroundLocationNuxAnalyticsLogger m15109a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BackgroundLocationNuxAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14738h) {
                BackgroundLocationNuxAnalyticsLogger backgroundLocationNuxAnalyticsLogger;
                if (a2 != null) {
                    backgroundLocationNuxAnalyticsLogger = (BackgroundLocationNuxAnalyticsLogger) a2.a(f14738h);
                } else {
                    backgroundLocationNuxAnalyticsLogger = f14737g;
                }
                if (backgroundLocationNuxAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15110b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14738h, b3);
                        } else {
                            f14737g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = backgroundLocationNuxAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m15113a(BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel) {
        this.f14739a.a(m15108a(this.f14743e ? "nearby_friends_informational_ok" : "nearby_friends_now_nux_turn_on").b("privacy_type", backgroundLocationPrivacyPickerOptionModel.m15315b().d()));
    }

    public final void m15114b() {
        Preconditions.checkState(!this.f14743e);
        this.f14739a.a(m15108a("nearby_friends_now_nux_not_now"));
    }

    public final void m15116c() {
        this.f14739a.a(m15108a(this.f14743e ? "nearby_friends_informational_back_out" : "nearby_friends_now_nux_back_out"));
    }

    public final void m15115b(BackgroundLocationPrivacyPickerOptionModel backgroundLocationPrivacyPickerOptionModel) {
        this.f14739a.a(m15108a("nearby_friends_now_nux_privacy_changed").b("privacy_type", backgroundLocationPrivacyPickerOptionModel.m15315b().d()));
    }

    public final void m15112a(MoreInfoType moreInfoType) {
        this.f14739a.a(m15108a(this.f14743e ? "nearby_friends_informational_more_info_click" : "nearby_friends_now_nux_more_info_click").b("type", moreInfoType.toString()));
    }

    private HoneyClientEvent m15108a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "background_location";
        return honeyClientEvent.a("session_id", this.f14741c).b("source", this.f14742d).b("surface", this.f14744f);
    }
}
