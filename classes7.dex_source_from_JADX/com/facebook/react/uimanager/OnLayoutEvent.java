package com.facebook.react.uimanager;

import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: friend_finder_friendable_contacts_pymk_start_fetching */
public class OnLayoutEvent extends Event<OnLayoutEvent> {
    private static final SynchronizedPool<OnLayoutEvent> f11754a = new SynchronizedPool(20);
    private int f11755b;
    private int f11756c;
    private int f11757d;
    private int f11758e;

    public static OnLayoutEvent m13918a(int i, int i2, int i3, int i4, int i5) {
        OnLayoutEvent onLayoutEvent = (OnLayoutEvent) f11754a.a();
        if (onLayoutEvent == null) {
            onLayoutEvent = new OnLayoutEvent();
        }
        onLayoutEvent.m13919b(i, i2, i3, i4, i5);
        return onLayoutEvent;
    }

    public final void mo736a() {
        f11754a.a(this);
    }

    private OnLayoutEvent() {
    }

    private void m13919b(int i, int i2, int i3, int i4, int i5) {
        super.m13908a(i, SystemClock.m13613b());
        this.f11755b = i2;
        this.f11756c = i3;
        this.f11757d = i4;
        this.f11758e = i5;
    }

    public final String mo738b() {
        return "topLayout";
    }

    public final void mo737a(RCTEventEmitter rCTEventEmitter) {
        WritableMap b = Arguments.m13388b();
        b.putDouble("x", (double) PixelUtil.m13926c((float) this.f11755b));
        b.putDouble("y", (double) PixelUtil.m13926c((float) this.f11756c));
        b.putDouble("width", (double) PixelUtil.m13926c((float) this.f11757d));
        b.putDouble("height", (double) PixelUtil.m13926c((float) this.f11758e));
        WritableMap b2 = Arguments.m13388b();
        b2.mo696a("layout", b);
        b2.putInt("target", this.f11751c);
        rCTEventEmitter.receiveEvent(this.f11751c, mo738b(), b2);
    }
}
