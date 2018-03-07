package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RECORD */
class ReactTextInputEndEditingEvent extends Event<ReactTextInputEndEditingEvent> {
    private String f11591a;

    public ReactTextInputEndEditingEvent(int i, long j, String str) {
        super(i, j);
        this.f11591a = str;
    }

    public final String m12070b() {
        return "topEndEditing";
    }

    public final boolean m12071e() {
        return false;
    }

    public final void m12069a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, m12070b(), m12068j());
    }

    private WritableMap m12068j() {
        WritableMap b = Arguments.b();
        b.putInt("target", this.c);
        b.putString("text", this.f11591a);
        return b;
    }
}
