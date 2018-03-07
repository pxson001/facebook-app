package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.OnProgressCallback;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: erxxzz3456 */
class RequestProgress {
    private final GraphRequest f13862a;
    private final Handler f13863b;
    private final long f13864c = FacebookSdk.m14052h();
    private long f13865d;
    private long f13866e;
    private long f13867f;

    RequestProgress(Handler handler, GraphRequest graphRequest) {
        this.f13862a = graphRequest;
        this.f13863b = handler;
    }

    final void m14151a(long j) {
        this.f13865d += j;
        if (this.f13865d >= this.f13866e + this.f13864c || this.f13865d >= this.f13867f) {
            m14150a();
        }
    }

    final void m14152b(long j) {
        this.f13867f += j;
    }

    final void m14150a() {
        if (this.f13865d > this.f13866e) {
            Callback callback = this.f13862a.f13808l;
            if (this.f13867f > 0 && (callback instanceof OnProgressCallback)) {
                final long j = this.f13865d;
                final long j2 = this.f13867f;
                final OnProgressCallback onProgressCallback = (OnProgressCallback) callback;
                if (this.f13863b != null) {
                    HandlerDetour.a(this.f13863b, new Runnable(this) {
                        final /* synthetic */ RequestProgress f13861d;

                        public void run() {
                        }
                    }, 1024045758);
                }
                this.f13866e = this.f13865d;
            }
        }
    }
}
