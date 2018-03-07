package com.facebook.fbreact.views.fbvpvlogger;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: email-address */
public class ReactVpvEvent extends Event<ReactVpvEvent> {
    private final String f7483a;
    private final boolean f7484b;
    private final boolean f7485c;

    public ReactVpvEvent(int i, long j, String str, boolean z, boolean z2) {
        super(i, j);
        this.f7483a = str;
        this.f7484b = z;
        this.f7485c = z2;
    }

    public final String m8662b() {
        return "reactVpvEvent";
    }

    private WritableMap m8660j() {
        WritableMap b = Arguments.b();
        b.putBoolean("isAttached", this.f7484b);
        b.putBoolean("isTop", this.f7485c);
        b.putString("feedUnitId", this.f7483a);
        return b;
    }

    public final void m8661a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, b(), m8660j());
    }
}
