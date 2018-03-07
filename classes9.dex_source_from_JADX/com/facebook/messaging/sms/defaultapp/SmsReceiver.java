package com.facebook.messaging.sms.defaultapp;

import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: com.facebook.orca.media.upload.PROCESS_MEDIA_COMPLETE */
public class SmsReceiver extends DynamicSecureBroadcastReceiver {
    public static final String[] f17620a = new String[]{"com.facebook.messaging.sms.COMPOSE_SMS", "com.facebook.messaging.sms.HEADLESS_SEND", "com.facebook.messaging.sms.REQUEST_SEND_MESSAGE", "com.facebook.messaging.sms.MESSAGE_SENT", "com.facebook.messaging.sms.DOWNLOAD_MMS", "com.facebook.messaging.sms.MMS_DOWNLOADED", "com.facebook.messaging.sms.MARK_PENDING_MMS", "com.facebook.messaging.sms.E2E_TEST_RECEIVING_SMS"};

    public SmsReceiver() {
        SmsActionReceiver smsActionReceiver = new SmsActionReceiver();
        Builder builder = ImmutableMap.builder();
        for (Object b : f17620a) {
            builder.b(b, smsActionReceiver);
        }
        super(builder.b());
    }
}
