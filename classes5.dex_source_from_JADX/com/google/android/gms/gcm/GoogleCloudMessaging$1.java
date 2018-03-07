package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class GoogleCloudMessaging$1 extends Handler {
    final /* synthetic */ GoogleCloudMessaging f6801a;

    GoogleCloudMessaging$1(GoogleCloudMessaging googleCloudMessaging, Looper looper) {
        this.f6801a = googleCloudMessaging;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("GCM", "Dropping invalid message");
        }
        Intent intent = (Intent) message.obj;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            this.f6801a.h.add(intent);
            return;
        }
        boolean sendMessage;
        GoogleCloudMessaging googleCloudMessaging = this.f6801a;
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) googleCloudMessaging.f.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                sendMessage = handler.sendMessage(obtain);
                if (!sendMessage) {
                    intent.setPackage(this.f6801a.e.getPackageName());
                    this.f6801a.e.sendBroadcast(intent);
                }
            }
        }
        sendMessage = false;
        if (!sendMessage) {
            intent.setPackage(this.f6801a.e.getPackageName());
            this.f6801a.e.sendBroadcast(intent);
        }
    }
}
