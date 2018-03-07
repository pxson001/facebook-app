package com.facebook.messaging.sms.defaultapp;

import com.facebook.content.DynamicSecureBroadcastReceiver;

/* compiled from: com.facebook.rtc.fbwebrtc.intent.action.INCOMING_CALL */
public class PrivilegedSmsReceiver extends DynamicSecureBroadcastReceiver {
    public PrivilegedSmsReceiver() {
        super("android.provider.Telephony.SMS_DELIVER", new SmsActionReceiver());
    }
}
