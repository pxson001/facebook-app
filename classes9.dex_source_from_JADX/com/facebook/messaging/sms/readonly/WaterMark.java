package com.facebook.messaging.sms.readonly;

/* compiled from: com.facebook.orca.CONNECTIVITY_CHANGED */
public class WaterMark {
    private long f17778a;
    private int f17779b;

    public WaterMark(long j, int i) {
        m17704a(j, i);
    }

    public final void m17704a(long j, int i) {
        this.f17778a = j;
        this.f17779b = i;
    }

    public final long m17703a() {
        return this.f17778a;
    }

    public final int m17705b(long j, int i) {
        if (j == this.f17778a && i == this.f17779b) {
            return 0;
        }
        return j >= this.f17778a ? 1 : -1;
    }
}
