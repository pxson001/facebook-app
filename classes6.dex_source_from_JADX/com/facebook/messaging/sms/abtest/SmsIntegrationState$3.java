package com.facebook.messaging.sms.abtest;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* compiled from: is_edit */
class SmsIntegrationState$3 extends ContentObserver {
    final /* synthetic */ SmsIntegrationState f12107a;

    SmsIntegrationState$3(SmsIntegrationState smsIntegrationState, Handler handler) {
        this.f12107a = smsIntegrationState;
        super(handler);
    }

    public void onChange(boolean z, Uri uri) {
        super.onChange(z);
        this.f12107a.e();
    }
}
