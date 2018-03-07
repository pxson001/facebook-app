package com.facebook.react.views.modal;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: Right */
class RequestCloseEvent extends Event<RequestCloseEvent> {
    protected RequestCloseEvent(int i, long j) {
        super(i, j);
    }

    public final String m11899b() {
        return "topRequestClose";
    }

    public final void m11898a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, m11899b(), null);
    }
}
