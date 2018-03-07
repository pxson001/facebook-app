package com.facebook.messaging.chatheads.intents;

import android.content.Intent;

/* compiled from: messenger_quickcam_save_dialog_shown */
public class ChatHeadsIntentDispatcher$1 implements Runnable {
    final /* synthetic */ Intent f9737a;
    final /* synthetic */ ChatHeadsIntentDispatcher f9738b;

    public ChatHeadsIntentDispatcher$1(ChatHeadsIntentDispatcher chatHeadsIntentDispatcher, Intent intent) {
        this.f9738b = chatHeadsIntentDispatcher;
        this.f9737a = intent;
    }

    public void run() {
        ChatHeadsIntentDispatcher.c(this.f9738b, this.f9737a);
        this.f9738b.g = true;
    }
}
