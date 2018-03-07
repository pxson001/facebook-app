package com.facebook.quicklog;

import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.common.util.TriState;
import java.util.ArrayList;

/* compiled from: zero_rating2/clearable/current_zero_rating_status */
public class QuickEvent implements Poolable<QuickEvent> {
    public static final ObjectPool<QuickEvent> f459a = new C01521(500);
    public int f460b;
    int f461c;
    long f462d;
    long f463e;
    long f464f;
    public int f465g;
    int f466h;
    boolean f467i;
    boolean f468j;
    String f469k;
    boolean f470l;
    boolean f471m;
    public boolean f472n;
    PerfStats f473o;
    public TriState f474p;
    int f475q;
    public ArrayList<String> f476r;
    public ArrayList<String> f477s;
    public short f478t;
    long f479u;
    public boolean f480v;
    boolean f481w;
    private QuickEvent f482x;

    /* compiled from: zero_rating2/clearable/current_zero_rating_status */
    final class C01521 extends ObjectPool<QuickEvent> {
        C01521(int i) {
            super(i);
        }

        final Poolable mo642a() {
            return new QuickEvent();
        }
    }

    public final void mo80a(Object obj) {
        this.f482x = (QuickEvent) obj;
    }

    public final Object mo79a() {
        return this.f482x;
    }

    public final void mo81b() {
    }

    QuickEvent() {
    }

    public final void m1004a(String str, String str2) {
        if (this.f476r == null) {
            this.f476r = new ArrayList();
        }
        this.f476r.add(str);
        this.f476r.add(str2);
        if (str.equals("tag_name")) {
            this.f470l = true;
        }
    }

    public final void m1003a(String str) {
        if (this.f477s == null) {
            this.f477s = new ArrayList();
        }
        this.f477s.add(str);
    }

    public final void m1008f() {
        if (this.f473o != null) {
            this.f473o.n();
        }
    }

    public final long m1009g() {
        return (((long) this.f461c) << 32) | ((long) this.f465g);
    }

    public final void m1006a(boolean z, boolean z2) {
        m1001a(TriState.valueOf(z), z2);
    }

    public final int m1010i() {
        return this.f465g;
    }

    public final void m1001a(TriState triState, boolean z) {
        if (z || this.f474p != TriState.YES) {
            if (triState == null) {
                triState = TriState.UNSET;
            }
            this.f474p = triState;
        }
    }

    public final void m1005a(boolean z) {
        if (!this.f472n) {
            z = false;
        }
        this.f472n = z;
    }

    public static QuickEvent m998a(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, long j, boolean z4, long j2, long j3, boolean z5) {
        QuickEvent quickEvent = (QuickEvent) f459a.m4469b();
        quickEvent.f465g = i;
        quickEvent.f466h = i4;
        quickEvent.f467i = z;
        quickEvent.f468j = z2;
        quickEvent.f471m = z3;
        quickEvent.f462d = j;
        quickEvent.f472n = z4;
        quickEvent.f479u = j;
        quickEvent.f464f = j2;
        quickEvent.f463e = j3;
        quickEvent.f461c = i2;
        quickEvent.f460b = i3;
        quickEvent.f478t = (short) 1;
        quickEvent.f476r = null;
        quickEvent.f477s = null;
        quickEvent.f482x = null;
        quickEvent.f469k = null;
        quickEvent.f470l = false;
        quickEvent.f480v = z5;
        quickEvent.f473o = null;
        quickEvent.f475q = 0;
        quickEvent.f481w = true;
        quickEvent.f474p = TriState.UNSET;
        return quickEvent;
    }

    public static QuickEvent m999a(int i, int i2, long j, boolean z, boolean z2) {
        QuickEvent quickEvent = (QuickEvent) f459a.m4469b();
        quickEvent.f465g = i;
        quickEvent.f461c = i2;
        quickEvent.f462d = j;
        quickEvent.f472n = z;
        quickEvent.f481w = false;
        quickEvent.f471m = z2;
        quickEvent.f469k = null;
        return quickEvent;
    }
}
