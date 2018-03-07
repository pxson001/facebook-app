package com.facebook.messaging.notificationpolicy;

import com.facebook.common.appstate.AppStateManager;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.notificationpolicy.NotificationPolicyCheck.CheckResult;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: result_optimistic_product */
public class NotificationPolicyCheckLastActiveDevice implements NotificationPolicyCheck, NotificationPolicyMessageCheck {
    private final AppStateManager f3392a;
    private final QeAccessor f3393b;
    private final Provider<String> f3394c;
    private boolean f3395d = true;
    public long f3396e = 0;

    @Inject
    public NotificationPolicyCheckLastActiveDevice(AppStateManager appStateManager, QeAccessor qeAccessor, Provider<String> provider) {
        this.f3392a = appStateManager;
        this.f3393b = qeAccessor;
        this.f3394c = provider;
    }

    public final boolean mo114a() {
        return this.f3393b.a(Liveness.Live, ExperimentsForNotificationPolicyModule.f3371a, false);
    }

    public final CheckResult mo111a(long j, String str, NotificationSetting notificationSetting) {
        if (this.f3395d) {
            return CheckResult.PASS;
        }
        Object obj;
        if (j - this.f3396e < 180000) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return CheckResult.FAIL;
        }
        if (!this.f3392a.l()) {
            return CheckResult.FAIL;
        }
        this.f3395d = true;
        return CheckResult.PASS;
    }

    public final void mo113a(@Nullable String str, long j) {
        if (str != null && str.equals(this.f3394c.get())) {
            m3290c(j);
        }
    }

    public final void mo115b() {
        this.f3395d = true;
    }

    public final void mo112a(long j) {
        m3290c(j);
    }

    public final void mo116c() {
        this.f3395d = true;
    }

    private void m3290c(long j) {
        this.f3395d = false;
        this.f3396e = j;
    }
}
