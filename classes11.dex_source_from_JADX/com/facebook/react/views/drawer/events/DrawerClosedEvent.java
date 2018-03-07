package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: SECTION_FOOTER */
public class DrawerClosedEvent extends Event<DrawerClosedEvent> {
    public DrawerClosedEvent(int i, long j) {
        super(i, j);
    }

    public final String m11825b() {
        return "topDrawerClosed";
    }

    public final short m11826f() {
        return (short) 0;
    }

    public final void m11824a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, b(), Arguments.b());
    }
}
