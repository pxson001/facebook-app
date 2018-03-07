package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RECENT_SHARES */
public class ReactTextInputEvent extends Event<ReactTextInputEvent> {
    private String f11592a;
    private String f11593b;
    private int f11594c;
    private int f11595d;

    public ReactTextInputEvent(int i, long j, String str, String str2, int i2, int i3) {
        super(i, j);
        this.f11592a = str;
        this.f11593b = str2;
        this.f11594c = i2;
        this.f11595d = i3;
    }

    public final String m12074b() {
        return "topTextInput";
    }

    public final void m12073a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, b(), m12072j());
    }

    public final boolean m12075e() {
        return false;
    }

    private WritableMap m12072j() {
        WritableMap b = Arguments.b();
        WritableMap b2 = Arguments.b();
        b2.putDouble("start", (double) this.f11594c);
        b2.putDouble("end", (double) this.f11595d);
        b.putString("text", this.f11592a);
        b.putString("previousText", this.f11593b);
        b.a("range", b2);
        b.putInt("target", this.c);
        return b;
    }
}
