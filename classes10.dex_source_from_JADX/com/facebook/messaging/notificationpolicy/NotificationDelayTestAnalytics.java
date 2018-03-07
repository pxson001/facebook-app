package com.facebook.messaging.notificationpolicy;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.SystemClock;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

@UserScoped
/* compiled from: retry_send */
public class NotificationDelayTestAnalytics {
    private static final Object f3380b = new Object();
    private final AnalyticsLogger f3381a;

    private static NotificationDelayTestAnalytics m3271b(InjectorLike injectorLike) {
        return new NotificationDelayTestAnalytics(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NotificationDelayTestAnalytics(AnalyticsLogger analyticsLogger) {
        this.f3381a = analyticsLogger;
    }

    final void m3272a(String str) {
        m3270a("ndt_delta_received", str);
    }

    final void m3273b(String str) {
        m3270a("ndt_push_received", str);
    }

    final void m3274c(String str) {
        m3270a("ndt_push_process_immediate", str);
    }

    final void m3275d(String str) {
        m3270a("ndt_push_process_delayed", str);
    }

    final void m3276e(String str) {
        m3270a("ndt_no_thread_key", str);
    }

    final void m3277f(String str) {
        m3270a("ndt_no_thread_exists_locally", str);
    }

    private void m3270a(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.b("message_id", str2);
        honeyClientEvent.a("client_time_ms", SystemClock.a.a());
        this.f3381a.a(honeyClientEvent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.notificationpolicy.NotificationDelayTestAnalytics m3269a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f3380b;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m3271b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3380b;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.notificationpolicy.NotificationDelayTestAnalytics) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.notificationpolicy.NotificationDelayTestAnalytics) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f3380b;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.notificationpolicy.NotificationDelayTestAnalytics) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.notificationpolicy.NotificationDelayTestAnalytics.a(com.facebook.inject.InjectorLike):com.facebook.messaging.notificationpolicy.NotificationDelayTestAnalytics");
    }
}
