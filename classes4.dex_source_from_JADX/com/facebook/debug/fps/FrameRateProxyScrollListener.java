package com.facebook.debug.fps;

import com.facebook.widget.listview.BaseProxyOnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxy;

/* compiled from: event-rsvp- */
public class FrameRateProxyScrollListener extends BaseProxyOnScrollListener {
    private final FrameRateLogger f12754a;

    public FrameRateProxyScrollListener(FrameRateLogger frameRateLogger) {
        this.f12754a = frameRateLogger;
    }

    public final void mo925a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (i == 0) {
            this.f12754a.b();
        } else {
            this.f12754a.a();
        }
    }
}
