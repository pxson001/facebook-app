package com.facebook.catalyst.views.maps;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: last_eden_gc_length */
public class RegionChangeEvent extends Event<RegionChangeEvent> {
    private static long f5883a = Long.MIN_VALUE;
    private final double f5884b;
    private final double f5885c;
    private final double f5886d;
    private final double f5887e;
    private final long f5888f;

    public final Event m7289a(Event event) {
        RegionChangeEvent regionChangeEvent = (RegionChangeEvent) event;
        if (this.d == regionChangeEvent.d) {
            return this.f5888f > regionChangeEvent.f5888f ? this : regionChangeEvent;
        } else {
            if (this.d <= regionChangeEvent.d) {
                return regionChangeEvent;
            }
            return this;
        }
    }

    public RegionChangeEvent(int i, long j, double d, double d2, double d3, double d4) {
        super(i, j);
        this.f5884b = d;
        this.f5885c = d2;
        this.f5886d = d3;
        this.f5887e = d4;
        long j2 = f5883a;
        f5883a = 1 + j2;
        this.f5888f = j2;
    }

    public final void m7290a(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.c, b(), m7288k());
    }

    private WritableMap m7287j() {
        WritableMap b = Arguments.b();
        b.putDouble("latitude", this.f5884b);
        b.putDouble("longitude", this.f5885c);
        b.putDouble("latitudeDelta", this.f5886d);
        b.putDouble("longitudeDelta", this.f5887e);
        return b;
    }

    private WritableMap m7288k() {
        WritableMap b = Arguments.b();
        b.a("region", m7287j());
        b.putInt("target", this.c);
        return b;
    }

    public final String m7291b() {
        return "topChange";
    }
}
