package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RCTVirtualText */
class PageScrollEvent extends Event<PageScrollEvent> {
    private final int f11617a;
    private final float f11618b;

    protected PageScrollEvent(int i, long j, int i2, float f) {
        super(i, j);
        this.f11617a = i2;
        this.f11618b = f;
    }

    public final String m12102b() {
        return "topPageScroll";
    }

    public final void m12101a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, m12102b(), m12100j());
    }

    private WritableMap m12100j() {
        WritableMap b = Arguments.b();
        b.putInt("position", this.f11617a);
        b.putDouble("offset", (double) this.f11618b);
        return b;
    }
}
