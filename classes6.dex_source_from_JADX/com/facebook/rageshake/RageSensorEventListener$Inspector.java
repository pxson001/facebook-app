package com.facebook.rageshake;

import com.facebook.common.collect.RingBuffer;

/* compiled from: showTagExpansionOption */
public class RageSensorEventListener$Inspector {
    final long f4374a = 1000000000;
    public final RingBuffer<RageSensorEventListener$Tuple> f4375b = new RingBuffer(32);
    public long f4376c;
    private final RageSensorEventListener$StateHolder f4377d = new RageSensorEventListener$StateHolder();
    private final RageSensorEventListener$StateHolder f4378e = new RageSensorEventListener$StateHolder();
    private final RageSensorEventListener$StateHolder f4379f = new RageSensorEventListener$StateHolder();

    RageSensorEventListener$Inspector() {
    }

    public final void m6454a() {
        this.f4375b.e();
    }

    final boolean m6455b() {
        this.f4377d.m6456a();
        this.f4378e.m6456a();
        this.f4379f.m6456a();
        for (int i = 0; i < this.f4375b.d(); i++) {
            boolean z;
            boolean z2;
            RageSensorEventListener$Tuple rageSensorEventListener$Tuple = (RageSensorEventListener$Tuple) this.f4375b.a(i);
            RageSensorEventListener$StateHolder rageSensorEventListener$StateHolder = this.f4377d;
            if (rageSensorEventListener$Tuple.f4383a > 13.042845f) {
                z = true;
            } else {
                z = false;
            }
            rageSensorEventListener$StateHolder.m6457a(z, rageSensorEventListener$Tuple.f4383a < -13.042845f);
            rageSensorEventListener$StateHolder = this.f4378e;
            if (rageSensorEventListener$Tuple.f4384b > 13.042845f) {
                z = true;
            } else {
                z = false;
            }
            rageSensorEventListener$StateHolder.m6457a(z, rageSensorEventListener$Tuple.f4384b < -13.042845f);
            RageSensorEventListener$StateHolder rageSensorEventListener$StateHolder2 = this.f4379f;
            if (rageSensorEventListener$Tuple.f4385c > 13.042845f) {
                z = true;
            } else {
                z = false;
            }
            if (rageSensorEventListener$Tuple.f4385c < -13.042845f) {
                z2 = true;
            } else {
                z2 = false;
            }
            rageSensorEventListener$StateHolder2.m6457a(z, z2);
        }
        if (this.f4377d.m6458b() || this.f4378e.m6458b() || this.f4379f.m6458b()) {
            return true;
        }
        return false;
    }
}
