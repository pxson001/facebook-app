package com.facebook.messaging.notificationpolicy;

import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.notificationpolicy.NotificationPolicyCheck.CheckResult;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: restored */
public class NotificationPolicyCheckThreadNotificationSettings implements NotificationPolicyCheck {
    private final QeAccessor f3403a;

    @Inject
    public NotificationPolicyCheckThreadNotificationSettings(QeAccessor qeAccessor) {
        this.f3403a = qeAccessor;
    }

    public final boolean mo114a() {
        return this.f3403a.a(Liveness.Live, ExperimentsForNotificationPolicyModule.f3373c, false);
    }

    public final CheckResult mo111a(long j, String str, NotificationSetting notificationSetting) {
        return notificationSetting.b() ? CheckResult.PASS : CheckResult.FAIL;
    }
}
