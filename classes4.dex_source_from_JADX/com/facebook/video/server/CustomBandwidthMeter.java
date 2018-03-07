package com.facebook.video.server;

import android.os.Handler;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.android.exoplayer.upstream.BandwidthMeter.EventListener;
import com.google.android.exoplayer.util.SlidingPercentile;
import com.google.common.base.Preconditions;

/* compiled from: page_share */
public class CustomBandwidthMeter implements BandwidthMeter {
    private static final String f5420a = CustomBandwidthMeter.class.getSimpleName();
    private final Handler f5421b;
    public final EventListener f5422c;
    private final MonotonicClock f5423d;
    private final SlidingPercentile f5424e;
    private long f5425f;
    private long f5426g;
    private long f5427h;
    private int f5428i;

    public CustomBandwidthMeter(MonotonicClock monotonicClock) {
        this(null, null, monotonicClock);
    }

    private CustomBandwidthMeter(Handler handler, EventListener eventListener, MonotonicClock monotonicClock) {
        this(handler, eventListener, monotonicClock, 2000);
    }

    private CustomBandwidthMeter(Handler handler, EventListener eventListener, MonotonicClock monotonicClock, int i) {
        this.f5425f = 0;
        this.f5421b = handler;
        this.f5422c = eventListener;
        this.f5423d = monotonicClock;
        this.f5424e = new SlidingPercentile(i);
        this.f5427h = -1;
    }

    public final synchronized long m5901a() {
        return this.f5427h;
    }

    public final synchronized void m5903b() {
        if (this.f5428i == 0) {
            this.f5426g = this.f5423d.now();
            Long.valueOf(this.f5426g);
        }
        this.f5428i++;
    }

    public final synchronized void m5902a(int i) {
        this.f5425f += (long) i;
    }

    public final synchronized void m5904c() {
        Preconditions.checkArgument(this.f5428i > 0);
        long now = this.f5423d.now();
        int i = (int) (now - this.f5426g);
        if (i > 0) {
            float f = (float) ((this.f5425f * 8000) / ((long) i));
            Integer.valueOf((int) Math.sqrt((double) this.f5425f));
            Long.valueOf(this.f5425f);
            Float.valueOf(f / 1000.0f);
            this.f5424e.a((int) Math.sqrt((double) this.f5425f), f);
            f = this.f5424e.a(0.5f);
            this.f5427h = Float.isNaN(f) ? -1 : (long) f;
            m5900a(i, this.f5425f, this.f5427h);
        }
        this.f5428i--;
        if (this.f5428i > 0) {
            this.f5426g = now;
            Long.valueOf(this.f5426g);
        }
        this.f5425f = 0;
    }

    private void m5900a(int i, long j, long j2) {
        if (BLog.b(3)) {
            Object[] objArr = new Object[]{Long.valueOf(j2 / 1000), Long.valueOf(j), Integer.valueOf(i), this, Long.valueOf(((long) this.f5424e.a(0.0f)) / 1000), Long.valueOf(((long) this.f5424e.a(1.0f)) / 1000)};
        }
        if (this.f5421b != null && this.f5422c != null) {
            HandlerDetour.a(this.f5421b, new 1(this, i, j, j2), 1390220045);
        }
    }
}
