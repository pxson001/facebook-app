package com.facebook.components.fb.fresco;

import com.facebook.components.EventHandler;

/* compiled from: transliterator_preference_changed */
class FbFrescoComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f1203a;
    final /* synthetic */ Object f1204b;
    final /* synthetic */ FbFrescoComponent f1205c;

    FbFrescoComponent$1(FbFrescoComponent fbFrescoComponent, EventHandler eventHandler, Object obj) {
        this.f1205c = fbFrescoComponent;
        this.f1203a = eventHandler;
        this.f1204b = obj;
    }

    public void run() {
        this.f1205c.a(this.f1203a, this.f1204b);
    }
}
