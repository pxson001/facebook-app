package com.facebook.push.adm;

import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerBase;
import com.amazon.device.messaging.ADMMessageReceiver;

/* compiled from: iTunSMPB */
public class ADMBroadcastReceiver extends ADMMessageHandlerBase {
    private static final Class<?> f11220a = ADMBroadcastReceiver.class;

    /* compiled from: iTunSMPB */
    public class MessageAlertReceiver extends ADMMessageReceiver {
        public MessageAlertReceiver() {
            super(ADMBroadcastReceiver.class);
        }
    }

    public ADMBroadcastReceiver() {
        super(ADMBroadcastReceiver.class.getName());
    }

    public ADMBroadcastReceiver(String str) {
        super(str);
    }

    protected void onMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        Intent intent2 = new Intent(this, ADMService.class);
        intent2.setAction("message_received");
        intent2.putExtra("bundle", extras);
        startService(intent2);
    }

    protected void onRegistrationError(String str) {
        new StringBuilder("OnRegistrationError Id: ").append(str);
        Intent intent = new Intent(this, ADMService.class);
        intent.setAction("registration_error");
        intent.putExtra("registration_error_id", str);
        startService(intent);
    }

    protected void onRegistered(String str) {
        new StringBuilder("RegistrationId: ").append(str);
        Intent intent = new Intent(this, ADMService.class);
        intent.setAction("registration");
        intent.putExtra("registration_id", str);
        startService(intent);
    }

    protected void onUnregistered(String str) {
    }
}
