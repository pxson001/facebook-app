package com.facebook.growth.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: prefetch_newsfeed_image_in_fg */
public class FriendFinderAnalyticsLogger {
    private static FriendFinderAnalyticsLogger f6086c;
    private static final Object f6087d = new Object();
    public final AnalyticsLogger f6088a;
    public final FunnelLoggerImpl f6089b;

    /* compiled from: prefetch_newsfeed_image_in_fg */
    public enum ApiType {
        FRIEND_FINDER_API("friend_finder_2.0"),
        FRIENDABLE_CONTACTS_API("friendable_contacts"),
        INVITABLE_CONTACTS_API("invitable_contacts");
        
        private final String mApiType;

        private ApiType(String str) {
            this.mApiType = str;
        }

        public final String getApiName() {
            return this.mApiType;
        }
    }

    /* compiled from: prefetch_newsfeed_image_in_fg */
    public enum EventType {
        FIND_FRIENDS_SHOWN("find_friends_view_shown"),
        FIND_FRIENDS_CLICKED("find_friends_view_clicked"),
        LEGAL_OPENED("friend_finder_legal_opened"),
        LEGAL_GET_STARTED("friend_finder_legal_get_started"),
        LEGAL_MANAGE("friend_finder_legal_manage"),
        LEGAL_LEARN_MORE("friend_finder_legal_learn_more"),
        LEARN_MORE_MANAGE("friend_finder_learn_more_manage"),
        OPENED("friend_finder_opened"),
        CANCELED("friend_finder_canceled"),
        PHONEBOOK_READ("friend_finder_phonebook_read"),
        FIRST_RESULTS_READY("friend_finder_first_results_ready"),
        COMPLETED("friend_finder_completed"),
        HOW_MANY_SEEN("friend_finder_how_many_seen"),
        ADD_FRIENDS_MANAGE("friend_finder_add_friends_manage"),
        TURN_ON_CONTINUOUS_SYNC("friend_finder_turn_on_continuous_contacts_upload"),
        TURN_OFF_CONTINUOUS_SYNC("friend_finder_turn_off_continuous_contacts_upload"),
        FRIENDABLE_CONTACTS_START_FETCHING("friend_finder_friendable_contacts_start_fetching"),
        FRIENDABLE_CONTACTS_PAGE_FETCHED("friend_finder_friendable_contacts_page_fetched"),
        FRIENDABLE_CONTACTS_FETCH_FAILED("friend_finder_friendable_contacts_fetch_failed"),
        PYMK_START_FETCHING("friend_finder_friendable_contacts_pymk_start_fetching"),
        PYMK_FETCHED("friend_finder_friendable_contacts_pymk_fetched"),
        PYMK_FETCH_FAILED("friend_finder_friendable_contacts_pymk_fetch_failed"),
        SEND_INVITE("friend_finder_send_invite"),
        SEND_INVITE_ALL("friend_finder_send_invite_all"),
        UNDO_CLICKED("friend_finder_undo_invite_clicked"),
        INVITES_START_FETCHING("friend_finder_invitable_contacts_start_fetching"),
        INVITES_PAGE_FETCHED("friend_finder_invitable_contacts_page_fetched"),
        INVITES_FETCH_FAILED("friend_finder_invitable_contacts_fetch_failed");
        
        private final String mEventType;

        private EventType(String str) {
            this.mEventType = str;
        }

        public final String getEventName() {
            return this.mEventType;
        }
    }

    private static FriendFinderAnalyticsLogger m7867b(InjectorLike injectorLike) {
        return new FriendFinderAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FunnelLoggerImpl.a(injectorLike));
    }

    public static FriendFinderAnalyticsLogger m7863a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendFinderAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6087d) {
                FriendFinderAnalyticsLogger friendFinderAnalyticsLogger;
                if (a2 != null) {
                    friendFinderAnalyticsLogger = (FriendFinderAnalyticsLogger) a2.a(f6087d);
                } else {
                    friendFinderAnalyticsLogger = f6086c;
                }
                if (friendFinderAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7867b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6087d, b3);
                        } else {
                            f6086c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendFinderAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FriendFinderAnalyticsLogger(AnalyticsLogger analyticsLogger, FunnelLoggerImpl funnelLoggerImpl) {
        this.f6088a = analyticsLogger;
        this.f6089b = funnelLoggerImpl;
    }

    public final void m7885c(String str, String str2) {
        m7865a(EventType.LEGAL_OPENED, ImmutableMap.of("ci_flow", str, "ccu_ref", str2));
        this.f6089b.b(FunnelRegistry.c, EventType.LEGAL_OPENED.getEventName());
    }

    public final void m7887d(String str, String str2) {
        m7865a(EventType.LEGAL_GET_STARTED, ImmutableMap.of("ci_flow", str, "ccu_ref", str2));
    }

    public final void m7868a() {
        m7864a(EventType.LEGAL_MANAGE);
    }

    public final void m7881b() {
        m7864a(EventType.LEGAL_LEARN_MORE);
    }

    public final void m7884c() {
        m7864a(EventType.LEARN_MORE_MANAGE);
    }

    public final void m7874a(String str, long j, int i, int i2, String str2) {
        this.f6088a.c(m7866b(EventType.CANCELED.getEventName()).b("api", ApiType.FRIEND_FINDER_API.getApiName()).b("ci_flow", str).a("time", j).a("batch_size", i).a("pagination_size", i2).b("session_id", str2));
        this.f6089b.b(FunnelRegistry.c, EventType.CANCELED.getEventName());
        this.f6089b.b(FunnelRegistry.c);
    }

    public final void m7873a(String str, long j, int i, int i2, int i3, String str2) {
        this.f6088a.c(m7866b(EventType.PHONEBOOK_READ.getEventName()).b("ci_flow", str).a("time", j).a("phonebook_size", i).a("batch_size", i2).a("pagination_size", i3).b("session_id", str2));
    }

    public final void m7882b(String str, long j, int i, int i2, String str2) {
        this.f6088a.c(m7866b(EventType.FIRST_RESULTS_READY.getEventName()).b("api", ApiType.FRIEND_FINDER_API.getApiName()).b("ci_flow", str).a("time", j).a("batch_size", i).a("pagination_size", i2).b("session_id", str2));
    }

    public final void m7872a(String str, long j, int i, int i2, int i3, int i4, String str2) {
        this.f6088a.c(m7866b(EventType.COMPLETED.getEventName()).b("ci_flow", str).a("time", j).a("phonebook_size", i).a("matches", i2).a("batch_size", i3).a("pagination_size", i4).b("session_id", str2));
        this.f6089b.b(FunnelRegistry.c, EventType.COMPLETED.getEventName());
        this.f6089b.b(FunnelRegistry.c);
    }

    public final void m7869a(String str, int i, int i2, int i3, int i4, String str2) {
        this.f6088a.c(m7866b(EventType.HOW_MANY_SEEN.getEventName()).b("api", ApiType.FRIEND_FINDER_API.getApiName()).b("ci_flow", str).a("how_many_seen", i).a("total_candidates", i2).a("batch_size", i3).a("pagination_size", i4).b("session_id", str2));
    }

    public final void m7886d() {
        m7864a(EventType.ADD_FRIENDS_MANAGE);
    }

    public final void m7888e() {
        m7864a(EventType.TURN_ON_CONTINUOUS_SYNC);
    }

    public final void m7875a(String str, long j, int i, long j2) {
        this.f6088a.c(m7866b(EventType.FIRST_RESULTS_READY.getEventName()).b("api", ApiType.FRIENDABLE_CONTACTS_API.getApiName()).b("ci_flow", str).a("time_since_creation", j).a("result_size", i).a("fetch_time", j2));
    }

    public final void m7871a(String str, long j, int i, int i2) {
        this.f6088a.c(m7866b(EventType.HOW_MANY_SEEN.getEventName()).b("api", ApiType.FRIENDABLE_CONTACTS_API.getApiName()).b("ci_flow", str).a("time_since_creation", j).a("total_candidates", i).a("how_many_seen", i2));
    }

    public final void m7879a(String str, long j, EventType eventType) {
        this.f6088a.a(m7866b(eventType.getEventName()).b("ci_flow", str).a("time_since_creation", j));
    }

    public final void m7876a(String str, long j, int i, long j2, EventType eventType) {
        this.f6088a.a(m7866b(eventType.getEventName()).b("ci_flow", str).a("time_since_creation", j).a("result_size", i).a("fetch_time", j2));
    }

    public final void m7877a(String str, long j, int i, EventType eventType) {
        this.f6088a.a(m7866b(eventType.getEventName()).b("ci_flow", str).a("time_since_creation", j).a("fetched_candidates_size", i));
    }

    public final void m7878a(String str, long j, long j2, int i, int i2) {
        this.f6088a.a(m7866b(EventType.PYMK_FETCHED.getEventName()).b("ci_flow", str).a("time_since_creation", j).a("fetch_time", j2).a("result_size", i).a("fetched_candidates_size", i2));
    }

    public final void m7880a(String str, ApiType apiType) {
        m7865a(EventType.SEND_INVITE, ImmutableMap.of("ci_flow", str, "api", apiType));
    }

    public final void m7883b(String str, ApiType apiType) {
        m7865a(EventType.UNDO_CLICKED, ImmutableMap.of("ci_flow", str, "api", apiType));
    }

    public final void m7870a(String str, int i, ApiType apiType) {
        m7865a(EventType.SEND_INVITE_ALL, ImmutableMap.of("ci_flow", str, "total_candidates", Integer.valueOf(i), "api", apiType));
    }

    private void m7864a(EventType eventType) {
        m7865a(eventType, null);
    }

    private void m7865a(EventType eventType, @Nullable Map<String, ?> map) {
        AnalyticsLogger analyticsLogger = this.f6088a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(eventType.getEventName());
        honeyClientEvent.c = "friend_finder";
        analyticsLogger.c(honeyClientEvent.a(map));
    }

    public static HoneyClientEvent m7866b(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "friend_finder";
        return honeyClientEvent;
    }
}
