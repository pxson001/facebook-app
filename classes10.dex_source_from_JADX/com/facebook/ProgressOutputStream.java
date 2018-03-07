package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.GraphRequestBatch.OnProgressCallback;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Map;

/* compiled from: event/<p$1> */
class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    private final Map<GraphRequest, RequestProgress> f13851a;
    private final GraphRequestBatch f13852b;
    private final long f13853c = FacebookSdk.m14052h();
    private long f13854d;
    private long f13855e;
    private long f13856f;
    private RequestProgress f13857g;

    ProgressOutputStream(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, RequestProgress> map, long j) {
        super(outputStream);
        this.f13852b = graphRequestBatch;
        this.f13851a = map;
        this.f13856f = j;
    }

    private void m14148a(long j) {
        if (this.f13857g != null) {
            this.f13857g.m14151a(j);
        }
        this.f13854d += j;
        if (this.f13854d >= this.f13855e + this.f13853c || this.f13854d >= this.f13856f) {
            m14147a();
        }
    }

    private void m14147a() {
        if (this.f13854d > this.f13855e) {
            for (Callback callback : this.f13852b.f13822f) {
                if (callback instanceof OnProgressCallback) {
                    Handler handler = this.f13852b.f13818b;
                    final OnProgressCallback onProgressCallback = (OnProgressCallback) callback;
                    if (handler != null) {
                        HandlerDetour.a(handler, new Runnable(this) {
                            final /* synthetic */ ProgressOutputStream f13850b;

                            public void run() {
                            }
                        }, 1591942250);
                    }
                }
            }
            this.f13855e = this.f13854d;
        }
    }

    public final void mo699a(GraphRequest graphRequest) {
        this.f13857g = graphRequest != null ? (RequestProgress) this.f13851a.get(graphRequest) : null;
    }

    public void write(byte[] bArr) {
        this.out.write(bArr);
        m14148a((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        m14148a((long) i2);
    }

    public void write(int i) {
        this.out.write(i);
        m14148a(1);
    }

    public void close() {
        super.close();
        for (RequestProgress a : this.f13851a.values()) {
            a.m14150a();
        }
        m14147a();
    }
}
