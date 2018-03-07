package com.facebook.messaging.notificationpolicy;

import com.facebook.common.time.Clock;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.notificationpolicy.NotificationPolicyCheck.CheckResult;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: response_updatecheckms */
public class NotificationPolicyCheckUnreadMessageFrequency implements NotificationPolicyCheck, NotificationPolicyMessageCheck {
    private final Clock f3404a;
    private final QeAccessor f3405b;
    private final Provider<String> f3406c;
    private final List<Long> f3407d = new ArrayList();

    @Inject
    public NotificationPolicyCheckUnreadMessageFrequency(Clock clock, QeAccessor qeAccessor, Provider<String> provider) {
        this.f3404a = clock;
        this.f3405b = qeAccessor;
        this.f3406c = provider;
    }

    public final boolean mo114a() {
        return this.f3405b.a(Liveness.Live, ExperimentsForNotificationPolicyModule.f3374d, false);
    }

    public final CheckResult mo111a(long j, String str, NotificationSetting notificationSetting) {
        m3304d();
        return this.f3407d.size() < 3 ? CheckResult.PASS : CheckResult.FAIL;
    }

    public final void mo113a(@Nullable String str, long j) {
        if (str == null || !str.equals(this.f3406c.get())) {
            this.f3407d.add(Long.valueOf(j));
            m3304d();
            return;
        }
        this.f3407d.clear();
    }

    public final void mo115b() {
        this.f3407d.clear();
    }

    public final void mo112a(long j) {
        this.f3407d.clear();
    }

    public final void mo116c() {
    }

    private void m3304d() {
        int size = this.f3407d.size();
        if (size > 3) {
            this.f3407d.subList(0, size - 3).clear();
        }
        long a = this.f3404a.a() - 300000;
        while (!this.f3407d.isEmpty() && ((Long) this.f3407d.get(0)).longValue() < a) {
            this.f3407d.remove(0);
        }
    }
}
