package com.facebook.video.player.plugins;

import com.facebook.common.executors.FbAsyncTask;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;

/* compiled from: communication_rank */
class Video360Plugin$LoggingTask extends FbAsyncTask<Object, String, Void> {
    final /* synthetic */ Video360Plugin f19409a;

    public Video360Plugin$LoggingTask(Video360Plugin video360Plugin) {
        this.f19409a = video360Plugin;
    }

    protected final Object m28184a(Object[] objArr) {
        Preconditions.checkNotNull(this.f19409a.h);
        Object obj = null;
        if (this.f19409a.h.l() && this.f19409a.a(this.f19409a.A, 30)) {
            Float.valueOf(this.f19409a.A.d);
            Float.valueOf(this.f19409a.A.e);
            Float.valueOf(this.f19409a.A.f);
            this.f19409a.b.c(this.f19409a.C.a.b);
            this.f19409a.b.a(this.f19409a.C.a.b, this.f19409a.A.g, (int) this.f19409a.A.d, (int) this.f19409a.A.e, (int) this.f19409a.A.f, this.f19409a.h.f() / 1000, this.f19409a.A.c, (int) this.f19409a.A.b);
            obj = 1;
        }
        if (this.f19409a.v) {
            HandlerDetour.b(this.f19409a.t, this.f19409a.y, 1000, 1587258040);
        }
        if (this.f19409a.w && r0 == null) {
            this.f19409a.b.c(this.f19409a.C.a.b);
        }
        if (this.f19409a.x) {
            this.f19409a.b.d(this.f19409a.C.a.b);
        }
        return null;
    }
}
