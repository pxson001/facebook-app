package com.facebook.messaging.notificationpolicy;

import com.facebook.messaging.model.threads.NotificationSetting;

/* compiled from: retry_count_ */
interface NotificationPolicyCheck {

    /* compiled from: retry_count_ */
    public enum CheckResult {
        PASS,
        PASS_AND_STOP,
        FAIL
    }

    CheckResult mo111a(long j, String str, NotificationSetting notificationSetting);

    boolean mo114a();
}
