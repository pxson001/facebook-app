package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RCTTextInlineImage doesn't map into a native view */
class PageScrollStateChangedEvent extends Event<PageScrollStateChangedEvent> {
    private final String f11619a;

    protected PageScrollStateChangedEvent(int i, long j, String str) {
        super(i, j);
        this.f11619a = str;
    }

    public final String m12105b() {
        return "topPageScrollStateChanged";
    }

    private WritableMap m12103j() {
        WritableMap b = Arguments.b();
        b.putString("pageScrollState", this.f11619a);
        return b;
    }

    public final void m12104a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, m12105b(), m12103j());
    }
}
