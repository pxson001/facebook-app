package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: SECONDS */
public class DrawerStateChangedEvent extends Event<DrawerStateChangedEvent> {
    public final int f11435a;

    public DrawerStateChangedEvent(int i, long j, int i2) {
        super(i, j);
        this.f11435a = i2;
    }

    private int m11835j() {
        return this.f11435a;
    }

    public final String m11838b() {
        return "topDrawerStateChanged";
    }

    public final short m11839f() {
        return (short) 0;
    }

    public final void m11837a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, b(), m11836k());
    }

    private WritableMap m11836k() {
        WritableMap b = Arguments.b();
        b.putDouble("drawerState", (double) this.f11435a);
        return b;
    }
}
