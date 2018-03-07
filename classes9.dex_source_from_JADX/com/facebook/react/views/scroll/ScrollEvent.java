package com.facebook.react.views.scroll;

import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import javax.annotation.Nullable;

/* compiled from: ba0bb3e08d2f858f76d6ba7542c98e2d */
public class ScrollEvent extends Event<ScrollEvent> {
    private static final SynchronizedPool<ScrollEvent> f19095a = new SynchronizedPool(3);
    private int f19096b;
    private int f19097c;
    private int f19098d;
    private int f19099e;
    private int f19100f;
    private int f19101g;
    @Nullable
    private ScrollEventType f19102h;

    public final void m19079a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, b(), m19077j());
    }

    public static ScrollEvent m19075a(int i, long j, ScrollEventType scrollEventType, int i2, int i3, int i4, int i5, int i6, int i7) {
        ScrollEvent scrollEvent = (ScrollEvent) f19095a.a();
        if (scrollEvent == null) {
            scrollEvent = new ScrollEvent();
        }
        scrollEvent.m19076b(i, j, scrollEventType, i2, i3, i4, i5, i6, i7);
        return scrollEvent;
    }

    public final void m19078a() {
        f19095a.a(this);
    }

    private ScrollEvent() {
    }

    private void m19076b(int i, long j, ScrollEventType scrollEventType, int i2, int i3, int i4, int i5, int i6, int i7) {
        super.a(i, j);
        this.f19102h = scrollEventType;
        this.f19096b = i2;
        this.f19097c = i3;
        this.f19098d = i4;
        this.f19099e = i5;
        this.f19100f = i6;
        this.f19101g = i7;
    }

    public final String m19080b() {
        return ((ScrollEventType) Assertions.b(this.f19102h)).getJSEventName();
    }

    public final short m19082f() {
        return (short) 0;
    }

    public final boolean m19081e() {
        if (this.f19102h == ScrollEventType.SCROLL) {
            return true;
        }
        return false;
    }

    private WritableMap m19077j() {
        WritableMap b = Arguments.b();
        b.putDouble("top", 0.0d);
        b.putDouble("bottom", 0.0d);
        b.putDouble("left", 0.0d);
        b.putDouble("right", 0.0d);
        WritableMap b2 = Arguments.b();
        b2.putDouble("x", (double) PixelUtil.c((float) this.f19096b));
        b2.putDouble("y", (double) PixelUtil.c((float) this.f19097c));
        WritableMap b3 = Arguments.b();
        b3.putDouble("width", (double) PixelUtil.c((float) this.f19098d));
        b3.putDouble("height", (double) PixelUtil.c((float) this.f19099e));
        WritableMap b4 = Arguments.b();
        b4.putDouble("width", (double) PixelUtil.c((float) this.f19100f));
        b4.putDouble("height", (double) PixelUtil.c((float) this.f19101g));
        WritableMap b5 = Arguments.b();
        b5.a("contentInset", b);
        b5.a("contentOffset", b2);
        b5.a("contentSize", b3);
        b5.a("layoutMeasurement", b4);
        b5.putInt("target", this.c);
        b5.putBoolean("responderIgnoreScroll", true);
        return b5;
    }
}
