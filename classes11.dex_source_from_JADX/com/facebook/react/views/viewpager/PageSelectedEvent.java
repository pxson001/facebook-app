package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RCTTextInlineImage */
class PageSelectedEvent extends Event<PageSelectedEvent> {
    private final int f11620a;

    protected PageSelectedEvent(int i, long j, int i2) {
        super(i, j);
        this.f11620a = i2;
    }

    public final String m12108b() {
        return "topPageSelected";
    }

    private WritableMap m12106j() {
        WritableMap b = Arguments.b();
        b.putInt("position", this.f11620a);
        return b;
    }

    public final void m12107a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, m12108b(), m12106j());
    }
}
