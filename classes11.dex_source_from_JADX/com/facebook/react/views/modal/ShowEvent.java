package com.facebook.react.views.modal;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: ResultList */
class ShowEvent extends Event<ShowEvent> {
    protected ShowEvent(int i, long j) {
        super(i, j);
    }

    public final String m11901b() {
        return "topShow";
    }

    public final void m11900a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, m11901b(), null);
    }
}
