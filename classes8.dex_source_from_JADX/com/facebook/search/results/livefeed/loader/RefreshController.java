package com.facebook.search.results.livefeed.loader;

import android.os.Handler;
import com.facebook.common.time.Clock;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: SEARCH_RESULTS_CONTEXT */
public abstract class RefreshController {
    public final Handler f23208a;
    public final int f23209b;
    public final Clock f23210c;
    public long f23211d = 0;
    public long f23212e = 0;
    public long f23213f = 0;
    public boolean f23214g;
    public final Runnable f23215h = new C25011(this);

    /* compiled from: SEARCH_RESULTS_CONTEXT */
    class C25011 implements Runnable {
        final /* synthetic */ RefreshController f23230a;

        C25011(RefreshController refreshController) {
            this.f23230a = refreshController;
        }

        public void run() {
            long a = (this.f23230a.f23210c.a() - this.f23230a.f23211d) - this.f23230a.f23213f;
            if (a < ((long) this.f23230a.f23209b)) {
                HandlerDetour.b(this.f23230a.f23208a, this.f23230a.f23215h, ((long) this.f23230a.f23209b) - a, -726132168);
                return;
            }
            this.f23230a.f23211d = this.f23230a.f23210c.a();
            this.f23230a.f23213f = 0;
            this.f23230a.f23212e = 0;
            this.f23230a.mo1311a();
            HandlerDetour.b(this.f23230a.f23208a, this.f23230a.f23215h, (long) this.f23230a.f23209b, 847861005);
        }
    }

    public abstract void mo1311a();

    public RefreshController(Clock clock, Handler handler, int i, boolean z) {
        this.f23210c = clock;
        this.f23208a = handler;
        this.f23209b = i;
        this.f23214g = z;
    }

    public final void m26913b() {
        this.f23208a.removeCallbacksAndMessages(null);
        if (this.f23212e > 0) {
            this.f23213f = this.f23210c.a() - this.f23212e;
        }
        if (this.f23214g) {
            HandlerDetour.a(this.f23208a, this.f23215h, -375247630);
        } else {
            HandlerDetour.b(this.f23208a, this.f23215h, (long) this.f23209b, -1784896386);
        }
    }

    public final void m26914c() {
        this.f23212e = this.f23210c.a();
        this.f23208a.removeCallbacksAndMessages(null);
    }
}
