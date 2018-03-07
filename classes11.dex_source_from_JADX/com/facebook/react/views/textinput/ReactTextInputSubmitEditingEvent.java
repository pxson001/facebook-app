package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RECENTLY_JOINED_SECTION */
class ReactTextInputSubmitEditingEvent extends Event<ReactTextInputSubmitEditingEvent> {
    private String f11616a;

    public ReactTextInputSubmitEditingEvent(int i, long j, String str) {
        super(i, j);
        this.f11616a = str;
    }

    public final String m12098b() {
        return "topSubmitEditing";
    }

    public final boolean m12099e() {
        return false;
    }

    public final void m12097a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, m12098b(), m12096j());
    }

    private WritableMap m12096j() {
        WritableMap b = Arguments.b();
        b.putInt("target", this.c);
        b.putString("text", this.f11616a);
        return b;
    }
}
