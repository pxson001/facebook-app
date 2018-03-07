package com.facebook.react.views.recyclerview;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: Request Timeout */
public class ContentSizeChangeEvent extends Event<ContentSizeChangeEvent> {
    private final int f11493a;
    private final int f11494b;

    public ContentSizeChangeEvent(int i, long j, int i2, int i3) {
        super(i, j);
        this.f11493a = i2;
        this.f11494b = i3;
    }

    public final String m11924b() {
        return "topContentSizeChange";
    }

    public final void m11923a(RCTEventEmitter rCTEventEmitter) {
        WritableMap b = Arguments.b();
        b.putDouble("width", (double) PixelUtil.c((float) this.f11493a));
        b.putDouble("height", (double) PixelUtil.c((float) this.f11494b));
        rCTEventEmitter.receiveEvent(this.c, "topContentSizeChange", b);
    }
}
