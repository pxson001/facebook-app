package com.facebook.friending.center.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: akamai */
public class FriendsCenterAnalyticsLogger {
    private static FriendsCenterAnalyticsLogger f19985c;
    private static final Object f19986d = new Object();
    private final AnalyticsLogger f19987a;
    private final String f19988b = SafeUUIDGenerator.a().toString();

    /* compiled from: akamai */
    public enum Event {
        FRIENDS_CENTER_OPENED("friends_center_opened"),
        FRIENDS_CENTER_TAB_SELECTED("friends_center_tab_selected"),
        FRIENDS_CENTER_FRIENDS_TAB_IMPRESSION("friends_center_friends_tab_impression"),
        FRIENDS_CENTER_SEARCH_IMPRESSION("friends_center_search_impression"),
        FRIENDS_CENTER_TOTAL_SEARCHES("friends_center_total_searches"),
        FRIENDS_CENTER_SUGGESTIONS_TAB_IMPRESSION("friends_center_suggestions_tab_impression"),
        FRIENDS_CENTER_REQUESTS_TAB_IMPRESSION("friends_center_requests_tab_impression"),
        FRIENDS_CENTER_OUTGOING_IMPRESSION("friends_center_outgoing_impression");
        
        public final String analyticsName;

        private Event(String str) {
            this.analyticsName = str;
        }
    }

    private static FriendsCenterAnalyticsLogger m20156b(InjectorLike injectorLike) {
        return new FriendsCenterAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendsCenterAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f19987a = analyticsLogger;
    }

    public final void m20160a(String str, @Nullable String str2) {
        if (StringUtil.a(str2)) {
            str2 = "unknown";
        }
        this.f19987a.a(m20154a(Event.FRIENDS_CENTER_OPENED).b("initial_tab", str).b("source_ref", str2));
    }

    public static FriendsCenterAnalyticsLogger m20155a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsCenterAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19986d) {
                FriendsCenterAnalyticsLogger friendsCenterAnalyticsLogger;
                if (a2 != null) {
                    friendsCenterAnalyticsLogger = (FriendsCenterAnalyticsLogger) a2.a(f19986d);
                } else {
                    friendsCenterAnalyticsLogger = f19985c;
                }
                if (friendsCenterAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20156b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19986d, b3);
                        } else {
                            f19985c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsCenterAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m20159a(String str) {
        this.f19987a.a(m20154a(Event.FRIENDS_CENTER_TAB_SELECTED).b("tab", str));
    }

    public final void m20157a(int i) {
        this.f19987a.a(m20154a(Event.FRIENDS_CENTER_FRIENDS_TAB_IMPRESSION).a("number_of_friends_user_saw", i));
    }

    public final void m20161b(int i) {
        this.f19987a.a(m20154a(Event.FRIENDS_CENTER_TOTAL_SEARCHES).a("number_of_searches", i));
    }

    public final void m20162c(int i) {
        this.f19987a.a(m20154a(Event.FRIENDS_CENTER_SEARCH_IMPRESSION).a("number_of_results_user_saw_per_search", i));
    }

    public final void m20163d(int i) {
        this.f19987a.a(m20154a(Event.FRIENDS_CENTER_SUGGESTIONS_TAB_IMPRESSION).a("number_of_suggestions_user_saw", i));
    }

    public final void m20158a(int i, int i2) {
        this.f19987a.a(m20154a(Event.FRIENDS_CENTER_REQUESTS_TAB_IMPRESSION).a("friend_requests_seen", i).a("pymk_seen", i2));
    }

    private HoneyClientEvent m20154a(Event event) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event.analyticsName);
        honeyClientEvent.c = "friends_center";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = this.f19988b;
        return honeyClientEvent;
    }
}
