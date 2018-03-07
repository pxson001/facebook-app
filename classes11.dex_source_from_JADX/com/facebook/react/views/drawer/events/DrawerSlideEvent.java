package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: SECTION */
public class DrawerSlideEvent extends Event<DrawerSlideEvent> {
    public final float f11434a;

    public DrawerSlideEvent(int i, long j, float f) {
        super(i, j);
        this.f11434a = f;
    }

    private float m11830j() {
        return this.f11434a;
    }

    public final String m11833b() {
        return "topDrawerSlide";
    }

    public final short m11834f() {
        return (short) 0;
    }

    public final void m11832a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, b(), m11831k());
    }

    private WritableMap m11831k() {
        WritableMap b = Arguments.b();
        b.putDouble("offset", (double) this.f11434a);
        return b;
    }
}
