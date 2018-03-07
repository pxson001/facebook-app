package com.facebook.bugreporter.scheduler;

import com.facebook.content.DynamicSecureBroadcastReceiver;

/* compiled from: ispx_48khz */
public class AlarmsBroadcastReceiver extends DynamicSecureBroadcastReceiver {
    public AlarmsBroadcastReceiver() {
        super("com.facebook.bugreporter.scheduler.AlarmsBroadcastReceiver.RETRY_UPLOAD", new Receiver());
    }
}
