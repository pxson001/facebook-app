package com.facebook.attachments.angora.actionbutton;

import com.facebook.components.EventHandler;

/* compiled from: video/mpeg2 */
class ActionButtonComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f640a;
    final /* synthetic */ Object f641b;
    final /* synthetic */ ActionButtonComponent f642c;

    ActionButtonComponent$1(ActionButtonComponent actionButtonComponent, EventHandler eventHandler, Object obj) {
        this.f642c = actionButtonComponent;
        this.f640a = eventHandler;
        this.f641b = obj;
    }

    public void run() {
        this.f642c.a(this.f640a, this.f641b);
    }
}
