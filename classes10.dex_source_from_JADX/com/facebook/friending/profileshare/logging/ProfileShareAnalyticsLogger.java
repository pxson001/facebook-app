package com.facebook.friending.profileshare.logging;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ad_preview_feed_unit */
public class ProfileShareAnalyticsLogger {
    private static ProfileShareAnalyticsLogger f20280c;
    private static final Object f20281d = new Object();
    private final AnalyticsLogger f20282a;
    private final String f20283b = SafeUUIDGenerator.a().toString();

    /* compiled from: ad_preview_feed_unit */
    public enum Event {
        PROFILE_SHARE_OPENED("profile_share_opened"),
        PROFILE_SHARE_CLOSED("profile_share_closed"),
        PROFILE_SHARE_APP_CLICKED("profile_share_app_clicked"),
        PROFILE_SHARE_CONTACT_PICKER_EVENT("profile_share_contact_picker_event");
        
        public final String name;

        private Event(String str) {
            this.name = str;
        }
    }

    /* compiled from: ad_preview_feed_unit */
    public enum Source {
        NEWS_FEED_QP("news_feed_qp");
        
        public final String name;

        private Source(String str) {
            this.name = str;
        }
    }

    private static ProfileShareAnalyticsLogger m20562b(InjectorLike injectorLike) {
        return new ProfileShareAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ProfileShareAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f20282a = analyticsLogger;
    }

    public final void m20564a(Source source, List<String> list) {
        this.f20282a.a(m20560a(Event.PROFILE_SHARE_OPENED).b("source", source.name).b("apps", TextUtils.join(",", list)));
    }

    public static ProfileShareAnalyticsLogger m20561a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProfileShareAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20281d) {
                ProfileShareAnalyticsLogger profileShareAnalyticsLogger;
                if (a2 != null) {
                    profileShareAnalyticsLogger = (ProfileShareAnalyticsLogger) a2.a(f20281d);
                } else {
                    profileShareAnalyticsLogger = f20280c;
                }
                if (profileShareAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20562b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20281d, b3);
                        } else {
                            f20280c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = profileShareAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m20563a() {
        this.f20282a.a(m20560a(Event.PROFILE_SHARE_CLOSED));
    }

    public final void m20565a(String str, long j) {
        this.f20282a.a(m20560a(Event.PROFILE_SHARE_APP_CLICKED).b("app", str).a("timestamp", j));
    }

    public final void m20566a(String str, @Nullable String str2) {
        this.f20282a.a(m20560a(Event.PROFILE_SHARE_CONTACT_PICKER_EVENT).b("result", str).b("address", str2));
    }

    private HoneyClientEvent m20560a(Event event) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event.name);
        honeyClientEvent.c = "profile_share";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = this.f20283b;
        return honeyClientEvent;
    }
}
