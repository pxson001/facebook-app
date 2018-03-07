package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: SECTION_COLLECTION_HEADER */
public class DrawerOpenedEvent extends Event<DrawerOpenedEvent> {
    public DrawerOpenedEvent(int i, long j) {
        super(i, j);
    }

    public final String m11828b() {
        return "topDrawerOpened";
    }

    public final short m11829f() {
        return (short) 0;
    }

    public final void m11827a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, b(), Arguments.b());
    }
}
