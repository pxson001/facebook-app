package com.facebook.react.views.swiperefresh;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: RedSpaceGridViewportMonitor.onScroll */
public class RefreshEvent extends Event<RefreshEvent> {
    protected RefreshEvent(int i, long j) {
        super(i, j);
    }

    public final String m11957b() {
        return "topRefresh";
    }

    public final void m11956a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, b(), null);
    }
}
