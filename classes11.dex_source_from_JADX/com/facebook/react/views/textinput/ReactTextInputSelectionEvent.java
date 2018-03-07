package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RECENT_ACTIVITY */
class ReactTextInputSelectionEvent extends Event<ReactTextInputSelectionEvent> {
    private int f11611a;
    private int f11612b;

    public ReactTextInputSelectionEvent(int i, long j, int i2, int i3) {
        super(i, j);
        this.f11611a = i2;
        this.f11612b = i3;
    }

    public final String m12086b() {
        return "topSelectionChange";
    }

    public final void m12085a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, m12086b(), m12084j());
    }

    private WritableMap m12084j() {
        WritableMap b = Arguments.b();
        WritableMap b2 = Arguments.b();
        b2.putInt("start", this.f11611a);
        b2.putInt("end", this.f11612b);
        b.a("selection", b2);
        return b;
    }
}
