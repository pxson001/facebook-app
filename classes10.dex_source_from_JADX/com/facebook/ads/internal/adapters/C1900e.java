package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.facebook.ads.internal.util.C1898t;
import com.facebook.ads.internal.util.C1983g;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

public class C1900e {
    public int f13992a;
    public int f13993b;
    public final Context f13994c;
    public final View f13995d;
    public final int f13996e;
    public final C1882a f13997f;
    public final Handler f13998g;
    public final Runnable f13999h;
    public final boolean f14000i;
    public volatile boolean f14001j;

    public abstract class C1882a {
        public abstract void mo700a();
    }

    final class C1899b extends C1898t<C1900e> {
        public C1899b(C1900e c1900e) {
            super(c1900e);
        }

        public final void run() {
            C1900e c1900e = (C1900e) m14235a();
            if (c1900e != null) {
                if (c1900e.f14000i || !c1900e.f14001j) {
                    View view = c1900e.f13995d;
                    C1882a c1882a = c1900e.f13997f;
                    if (view != null && c1882a != null) {
                        if (C1983g.m14464a(c1900e.f13994c, view, c1900e.f13996e)) {
                            c1882a.mo700a();
                            c1900e.f14001j = true;
                            return;
                        }
                        HandlerDetour.b(c1900e.f13998g, c1900e.f13999h, (long) c1900e.f13993b, 667359611);
                    }
                }
            }
        }
    }

    public C1900e(Context context, View view, int i, C1882a c1882a) {
        this(context, view, i, false, c1882a);
    }

    private C1900e(Context context, View view, int i, boolean z, C1882a c1882a) {
        this.f13992a = 0;
        this.f13993b = 1000;
        this.f13998g = new Handler();
        this.f13999h = new C1899b(this);
        this.f13994c = context;
        this.f13995d = view;
        this.f13996e = i;
        this.f13997f = c1882a;
        this.f14000i = z;
    }

    public final void m14236a() {
        if (!this.f14000i && !this.f14001j) {
            HandlerDetour.b(this.f13998g, this.f13999h, (long) this.f13992a, -1264288634);
        }
    }

    public final void m14237b() {
        HandlerDetour.a(this.f13998g, this.f13999h);
    }
}
