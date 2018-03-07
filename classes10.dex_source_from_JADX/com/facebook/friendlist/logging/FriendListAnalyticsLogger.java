package com.facebook.friendlist.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accountType */
public class FriendListAnalyticsLogger {
    private static FriendListAnalyticsLogger f20409c;
    private static final Object f20410d = new Object();
    private final AnalyticsLogger f20411a;
    private final String f20412b = SafeUUIDGenerator.a().toString();

    /* compiled from: accountType */
    /* synthetic */ class C29211 {
        static final /* synthetic */ int[] f20408a = new int[FriendListType.values().length];

        static {
            try {
                f20408a[FriendListType.ALL_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20408a[FriendListType.MUTUAL_FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20408a[FriendListType.RECENTLY_ADDED_FRIENDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f20408a[FriendListType.SUGGESTIONS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f20408a[FriendListType.FRIENDS_WITH_NEW_POSTS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: accountType */
    enum AnalyticsEvent {
        FRIEND_LIST_OPENED("friend_list_opened"),
        FRIEND_LIST_SEARCH_BAR_CLICK("friend_list_search_bar_click"),
        FRIEND_LIST_TAB_SELECTED("friend_list_tab_selected"),
        FRIEND_LIST_ALL_FRIENDS_SEEN("friend_list_all_friends_seen"),
        FRIEND_LIST_MUTUAL_FRIENDS_SEEN("friend_list_mutual_friends_seen"),
        FRIEND_LIST_RECENTLY_ADDED_FRIENDS_SEEN("friend_list_recently_added_friends_seen"),
        FRIEND_LIST_SUGGESTIONS_SEEN("friend_list_suggestions_seen"),
        FRIEND_LIST_WITH_NEW_POSTS_SEEN("friend_list_with_new_posts_seen");
        
        public final String analyticsName;

        private AnalyticsEvent(String str) {
            this.analyticsName = str;
        }
    }

    private static FriendListAnalyticsLogger m20674b(InjectorLike injectorLike) {
        return new FriendListAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendListAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f20411a = analyticsLogger;
    }

    public final void m20678a(String str, String str2, String str3) {
        this.f20411a.a(m20671a(AnalyticsEvent.FRIEND_LIST_OPENED, str3).b("initial_tab", str).b("source_ref", str2));
    }

    public final void m20677a(String str, String str2) {
        this.f20411a.a(m20671a(AnalyticsEvent.FRIEND_LIST_TAB_SELECTED, str2).b("tab", str));
    }

    public static FriendListAnalyticsLogger m20673a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendListAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20410d) {
                FriendListAnalyticsLogger friendListAnalyticsLogger;
                if (a2 != null) {
                    friendListAnalyticsLogger = (FriendListAnalyticsLogger) a2.a(f20410d);
                } else {
                    friendListAnalyticsLogger = f20409c;
                }
                if (friendListAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20674b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20410d, b3);
                        } else {
                            f20409c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendListAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m20675a(FriendListType friendListType, int i, String str) {
        this.f20411a.a(m20671a(m20672a(friendListType), str).a("number_of_friends_seen", i));
    }

    public final void m20676a(String str) {
        this.f20411a.a(m20671a(AnalyticsEvent.FRIEND_LIST_SEARCH_BAR_CLICK, str));
    }

    private HoneyClientEvent m20671a(AnalyticsEvent analyticsEvent, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(analyticsEvent.analyticsName);
        honeyClientEvent.c = "profile_friends_page";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = this.f20412b;
        return honeyClientEvent.b("target_id", str);
    }

    private static AnalyticsEvent m20672a(FriendListType friendListType) {
        switch (C29211.f20408a[friendListType.ordinal()]) {
            case 1:
                return AnalyticsEvent.FRIEND_LIST_ALL_FRIENDS_SEEN;
            case 2:
                return AnalyticsEvent.FRIEND_LIST_MUTUAL_FRIENDS_SEEN;
            case 3:
                return AnalyticsEvent.FRIEND_LIST_RECENTLY_ADDED_FRIENDS_SEEN;
            case 4:
                return AnalyticsEvent.FRIEND_LIST_SUGGESTIONS_SEEN;
            case 5:
                return AnalyticsEvent.FRIEND_LIST_WITH_NEW_POSTS_SEEN;
            default:
                throw new IllegalArgumentException("Unexpected value for FriendListType");
        }
    }
}
