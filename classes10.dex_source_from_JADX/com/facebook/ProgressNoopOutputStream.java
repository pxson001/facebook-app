package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: event/{%s} */
class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {
    private final Map<GraphRequest, RequestProgress> f13844a = new HashMap();
    private final Handler f13845b;
    private GraphRequest f13846c;
    private RequestProgress f13847d;
    private int f13848e;

    ProgressNoopOutputStream(Handler handler) {
        this.f13845b = handler;
    }

    public final void mo699a(GraphRequest graphRequest) {
        this.f13846c = graphRequest;
        this.f13847d = graphRequest != null ? (RequestProgress) this.f13844a.get(graphRequest) : null;
    }

    final int m14143a() {
        return this.f13848e;
    }

    final Map<GraphRequest, RequestProgress> m14146b() {
        return this.f13844a;
    }

    final void m14144a(long j) {
        if (this.f13847d == null) {
            this.f13847d = new RequestProgress(this.f13845b, this.f13846c);
            this.f13844a.put(this.f13846c, this.f13847d);
        }
        this.f13847d.m14152b(j);
        this.f13848e = (int) (((long) this.f13848e) + j);
    }

    public void write(byte[] bArr) {
        m14144a((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        m14144a((long) i2);
    }

    public void write(int i) {
        m14144a(1);
    }
}
