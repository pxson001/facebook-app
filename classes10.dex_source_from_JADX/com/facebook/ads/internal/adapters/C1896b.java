package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.internal.util.C1983g;

public abstract class C1896b {
    protected final C1885c f13984a;
    private final Context f13985b;
    private boolean f13986c;

    public C1896b(Context context, C1885c c1885c) {
        this.f13985b = context;
        this.f13984a = c1885c;
    }

    public final void m14232a() {
        if (!this.f13986c) {
            if (this.f13984a != null) {
                this.f13984a.mo701a();
            }
            mo734b();
            this.f13986c = true;
            C1983g.m14461a(this.f13985b, "Impression logged");
        }
    }

    protected abstract void mo734b();
}
