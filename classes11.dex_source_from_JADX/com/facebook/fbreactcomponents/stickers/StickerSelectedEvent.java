package com.facebook.fbreactcomponents.stickers;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: edspace */
public class StickerSelectedEvent extends Event<StickerSelectedEvent> {
    public final String f7489a;

    public StickerSelectedEvent(int i, long j, String str) {
        super(i, j);
        this.f7489a = str;
    }

    public final boolean m8671e() {
        return false;
    }

    public final String m8670b() {
        return "topStickerSelect";
    }

    private WritableMap m8667j() {
        WritableMap b = Arguments.b();
        b.putString("stickerFBID", this.f7489a);
        return b;
    }

    private String m8668k() {
        return this.f7489a;
    }

    public final void m8669a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, b(), m8667j());
    }
}
