package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: REPORT_FUNDRAISER */
public class ReactTextChangedEvent extends Event<ReactTextChangedEvent> {
    private String f11587a;
    private int f11588b;
    private int f11589c;
    private int f11590d;

    public ReactTextChangedEvent(int i, long j, String str, int i2, int i3, int i4) {
        super(i, j);
        this.f11587a = str;
        this.f11588b = i2;
        this.f11589c = i3;
        this.f11590d = i4;
    }

    public final String m12063b() {
        return "topChange";
    }

    public final void m12062a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, b(), m12061j());
    }

    private WritableMap m12061j() {
        WritableMap b = Arguments.b();
        b.putString("text", this.f11587a);
        WritableMap b2 = Arguments.b();
        b2.putDouble("width", (double) this.f11588b);
        b2.putDouble("height", (double) this.f11589c);
        b.a("contentSize", b2);
        b.putInt("eventCount", this.f11590d);
        b.putInt("target", this.c);
        return b;
    }
}
