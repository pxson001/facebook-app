package com.facebook.messaging.notificationpolicy;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CounterLogger;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: response_release */
public class NotificationPolicyEngine {
    private static final Object f3409e = new Object();
    private final QeAccessor f3410a;
    private final NotificationPolicyCheck[] f3411b;
    public final NotificationPolicyMessageCheck[] f3412c;
    private final NotificationPolicyPushCheck[] f3413d;

    private static NotificationPolicyEngine m3312b(InjectorLike injectorLike) {
        return new NotificationPolicyEngine((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), new NotificationPolicyCheckLastActiveDevice(AppStateManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4443)), new NotificationPolicyCheckOnlyAfterPush(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), CounterLogger.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike)), new NotificationPolicyCheckUnreadMessageFrequency((Clock) SystemClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4443)), new NotificationPolicyCheckThreadNotificationSettings((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public NotificationPolicyEngine(QeAccessor qeAccessor, NotificationPolicyCheckLastActiveDevice notificationPolicyCheckLastActiveDevice, NotificationPolicyCheckOnlyAfterPush notificationPolicyCheckOnlyAfterPush, NotificationPolicyCheckUnreadMessageFrequency notificationPolicyCheckUnreadMessageFrequency, NotificationPolicyCheckThreadNotificationSettings notificationPolicyCheckThreadNotificationSettings) {
        this.f3410a = qeAccessor;
        this.f3411b = new NotificationPolicyCheck[]{notificationPolicyCheckOnlyAfterPush, notificationPolicyCheckLastActiveDevice, notificationPolicyCheckUnreadMessageFrequency, notificationPolicyCheckThreadNotificationSettings};
        this.f3412c = new NotificationPolicyMessageCheck[]{notificationPolicyCheckLastActiveDevice, notificationPolicyCheckUnreadMessageFrequency};
        this.f3413d = new NotificationPolicyPushCheck[]{notificationPolicyCheckOnlyAfterPush};
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.notificationpolicy.NotificationPolicyEngine m3311a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f3409e;	 Catch:{ all -> 0x006c }
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
        r1 = m3312b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3409e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.notificationpolicy.NotificationPolicyEngine) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.notificationpolicy.NotificationPolicyEngine) r0;	 Catch:{  }
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
        r0 = f3409e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.notificationpolicy.NotificationPolicyEngine) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.notificationpolicy.NotificationPolicyEngine.a(com.facebook.inject.InjectorLike):com.facebook.messaging.notificationpolicy.NotificationPolicyEngine");
    }

    public final boolean m3316a() {
        return this.f3410a.a(Liveness.Live, ExperimentsForNotificationPolicyModule.f3375e, false);
    }

    public final synchronized boolean m3317a(long j, String str, NotificationSetting notificationSetting) {
        boolean z = true;
        synchronized (this) {
            if (m3316a()) {
                boolean z2 = false;
                for (NotificationPolicyCheck notificationPolicyCheck : this.f3411b) {
                    if (notificationPolicyCheck.mo114a()) {
                        switch (notificationPolicyCheck.mo111a(j, str, notificationSetting)) {
                            case PASS:
                                z2 = true;
                                break;
                            case PASS_AND_STOP:
                                break;
                            case FAIL:
                                z = false;
                                break;
                            default:
                                break;
                        }
                    }
                }
                z = z2;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final void m3314a(@Nullable String str, long j) {
        for (NotificationPolicyMessageCheck a : this.f3412c) {
            a.mo113a(str, j);
        }
    }

    public final void m3318b() {
        for (NotificationPolicyMessageCheck b : this.f3412c) {
            b.mo115b();
        }
    }

    public final void m3313a(long j) {
        for (NotificationPolicyMessageCheck a : this.f3412c) {
            a.mo112a(j);
        }
    }

    public final synchronized void m3315a(String str, boolean z) {
        for (NotificationPolicyPushCheck a : this.f3413d) {
            a.mo117a(str, z);
        }
    }
}
