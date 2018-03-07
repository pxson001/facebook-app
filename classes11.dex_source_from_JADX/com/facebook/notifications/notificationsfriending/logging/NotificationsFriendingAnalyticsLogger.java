package com.facebook.notifications.notificationsfriending.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: tigon */
public class NotificationsFriendingAnalyticsLogger {
    private static NotificationsFriendingAnalyticsLogger f1029b;
    private static final Object f1030c = new Object();
    private final AnalyticsLogger f1031a;

    private static NotificationsFriendingAnalyticsLogger m1387b(InjectorLike injectorLike) {
        return new NotificationsFriendingAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NotificationsFriendingAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f1031a = analyticsLogger;
    }

    public final void m1389a(int i, int i2) {
        m1386a("intermixed_tab_friend_request_impression", ImmutableMap.of("shown_count", String.valueOf(i), "impression_count", String.valueOf(i2)));
    }

    public final void m1391b(int i, int i2) {
        m1386a("intermixed_tab_pymk_impression", ImmutableMap.of("shown_count", String.valueOf(i), "impression_count", String.valueOf(i2)));
    }

    public final void m1388a(int i) {
        m1385a("notifications", i);
    }

    public static NotificationsFriendingAnalyticsLogger m1384a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationsFriendingAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1030c) {
                NotificationsFriendingAnalyticsLogger notificationsFriendingAnalyticsLogger;
                if (a2 != null) {
                    notificationsFriendingAnalyticsLogger = (NotificationsFriendingAnalyticsLogger) a2.a(f1030c);
                } else {
                    notificationsFriendingAnalyticsLogger = f1029b;
                }
                if (notificationsFriendingAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1387b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1030c, b3);
                        } else {
                            f1029b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationsFriendingAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m1390b(int i) {
        m1385a("friend_requests", i);
    }

    public final void m1392c(int i, int i2) {
        m1386a("see_more_notifications_click", ImmutableMap.of("item_count", String.valueOf(i), "expanded_item_count", String.valueOf(i2)));
    }

    private void m1385a(String str, int i) {
        m1386a("see_all_click", ImmutableMap.of("section", str, "item_count", String.valueOf(i)));
    }

    private void m1386a(String str, Map<String, String> map) {
        AnalyticsLogger analyticsLogger = this.f1031a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "notifications_friending";
        analyticsLogger.a(honeyClientEvent.a(map));
    }
}
