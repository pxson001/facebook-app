package com.facebook.confirmation.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: fb_ffmpeg */
public class ConfirmationAnalyticsLogger {
    public final AnalyticsLogger f12031a;

    public static ConfirmationAnalyticsLogger m12704b(InjectorLike injectorLike) {
        return new ConfirmationAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ConfirmationAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f12031a = analyticsLogger;
    }

    public final void m12710a(boolean z) {
        HoneyClientEventFast a = this.f12031a.a(ConfirmationLoggingEventType.BACKGROUND_CONFIRMATION_START.getAnalyticsName(), true);
        if (a.a()) {
            a.a("confirmation");
            a.a("sms_perm_granted", z);
            a.b();
        }
    }

    public final void m12706a(int i) {
        HoneyClientEventFast a = this.f12031a.a(ConfirmationLoggingEventType.BACKGROUND_SMS_DETECTED.getAnalyticsName(), true);
        if (a.a()) {
            a.a("confirmation");
            a.a("sms_detected", i);
            a.b();
        }
    }

    public final void m12707a(int i, int i2) {
        HoneyClientEventFast a = this.f12031a.a(ConfirmationLoggingEventType.BACKGROUND_SMS_CONFIRMATION_ATTEMPT.getAnalyticsName(), true);
        if (a.a()) {
            a.a("confirmation");
            a.a("confirmation_code_count", i2);
            a.a("pending_contactpoint_count", i);
            a.b();
        }
    }

    public final void m12711a(boolean z, String str) {
        HoneyClientEventFast a = this.f12031a.a((z ? ConfirmationLoggingEventType.BACKGROUND_SMS_CONFIRMATION_SUCCESS : ConfirmationLoggingEventType.BACKGROUND_SMS_CONFIRMATION_FAILURE).getAnalyticsName(), true);
        if (a.a()) {
            a.a("confirmation");
            a.a("code_type", str);
            a.b();
        }
    }

    public final void m12708a(TriState triState, String str, String str2) {
        ConfirmationLoggingEventType confirmationLoggingEventType;
        switch (1.a[triState.ordinal()]) {
            case 1:
                confirmationLoggingEventType = ConfirmationLoggingEventType.BACKGROUND_SMS_CONFIRMATION_SUCCESS;
                break;
            case 2:
                confirmationLoggingEventType = ConfirmationLoggingEventType.BACKGROUND_SMS_CONFIRMATION_NETWORK;
                break;
            default:
                confirmationLoggingEventType = ConfirmationLoggingEventType.BACKGROUND_SMS_CONFIRMATION_FAILURE;
                break;
        }
        HoneyClientEventFast a = this.f12031a.a(confirmationLoggingEventType.getAnalyticsName(), true);
        if (a.a()) {
            a.a("confirmation");
            a.a("code_type", str);
            if (!StringUtil.c(str2)) {
                a.a("error_message", str2);
            }
            a.b();
        }
    }

    public final void m12705a() {
        HoneyClientEventFast a = this.f12031a.a(ConfirmationLoggingEventType.BACKGROUND_EMAIL_CONFIRMATION_SUCCESS.getAnalyticsName(), true);
        if (a.a()) {
            a.a("confirmation");
            a.b();
        }
    }

    public final void m12709a(String str) {
        HoneyClientEventFast a = this.f12031a.a(ConfirmationLoggingEventType.BACKGROUND_EMAIL_CONFIRMATION_FAILURE.getAnalyticsName(), true);
        if (a.a()) {
            a.a("confirmation");
            a.a("error_message", str);
            a.b();
        }
    }
}
