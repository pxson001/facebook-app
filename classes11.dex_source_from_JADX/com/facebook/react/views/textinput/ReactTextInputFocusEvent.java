package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RECENT_REVIEWS */
class ReactTextInputFocusEvent extends Event<ReactTextInputFocusEvent> {
    public ReactTextInputFocusEvent(int i, long j) {
        super(i, j);
    }

    public final String m12078b() {
        return "topFocus";
    }

    public final boolean m12079e() {
        return false;
    }

    private WritableMap m12076j() {
        WritableMap b = Arguments.b();
        b.putInt("target", this.c);
        return b;
    }

    public final void m12077a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, m12078b(), m12076j());
    }
}
