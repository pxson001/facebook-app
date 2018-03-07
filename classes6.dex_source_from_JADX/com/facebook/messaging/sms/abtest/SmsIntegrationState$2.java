package com.facebook.messaging.sms.abtest;

import android.net.Uri;
import android.provider.Settings.Secure;

/* compiled from: is_edit */
class SmsIntegrationState$2 implements Runnable {
    final /* synthetic */ SmsIntegrationState f12106a;

    SmsIntegrationState$2(SmsIntegrationState smsIntegrationState) {
        this.f12106a = smsIntegrationState;
    }

    public void run() {
        this.f12106a.b.getContentResolver().registerContentObserver(Uri.withAppendedPath(Secure.CONTENT_URI, "sms_default_application"), false, this.f12106a.g);
    }
}
