package com.facebook.analytics;

/* compiled from: messenger_bannertriggers */
public class CpuUsageData {
    public final double f8061a;
    public final double f8062b;
    private final double f8063c;
    private final double f8064d;

    public CpuUsageData(double d, double d2, double d3, double d4) {
        this.f8061a = d;
        this.f8062b = d2;
        this.f8063c = d3;
        this.f8064d = d4;
    }

    public final double m8348a() {
        return this.f8061a;
    }

    public final double m8349b() {
        return this.f8062b;
    }

    public final double m8350c() {
        return this.f8061a + this.f8062b;
    }

    public final double m8351d() {
        return this.f8063c;
    }

    public final double m8352e() {
        return this.f8064d;
    }
}
