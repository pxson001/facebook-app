package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RECORDING */
class ReactTextInputBlurEvent extends Event<ReactTextInputBlurEvent> {
    public ReactTextInputBlurEvent(int i, long j) {
        super(i, j);
    }

    public final String m12066b() {
        return "topBlur";
    }

    public final boolean m12067e() {
        return false;
    }

    private WritableMap m12064j() {
        WritableMap b = Arguments.b();
        b.putInt("target", this.c);
        return b;
    }

    public final void m12065a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, m12066b(), m12064j());
    }
}
