package com.facebook.common.time;

/* compiled from: wifi_scan_min_rssi */
public class SystemClock implements Clock {
    public static final SystemClock f762a = new SystemClock();

    private SystemClock() {
    }

    public static SystemClock m1506b() {
        return f762a;
    }

    public final long mo211a() {
        return System.currentTimeMillis();
    }
}
