package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.controller.AbstractDraweeController;
import java.util.HashSet;
import java.util.Set;

/* compiled from: message */
public class DeferredReleaser {
    private static DeferredReleaser f14379a = null;
    public final Set<Releasable> f14380b = new HashSet();
    public final Handler f14381c = new Handler(Looper.getMainLooper());
    public final Runnable f14382d = new C05991(this);

    /* compiled from: message */
    class C05991 implements Runnable {
        final /* synthetic */ DeferredReleaser f14383a;

        C05991(DeferredReleaser deferredReleaser) {
            this.f14383a = deferredReleaser;
        }

        public void run() {
            DeferredReleaser.m20761c();
            for (AbstractDraweeController b : this.f14383a.f14380b) {
                b.m20746b();
            }
            this.f14383a.f14380b.clear();
        }
    }

    public static synchronized DeferredReleaser m20760a() {
        DeferredReleaser deferredReleaser;
        synchronized (DeferredReleaser.class) {
            if (f14379a == null) {
                f14379a = new DeferredReleaser();
            }
            deferredReleaser = f14379a;
        }
        return deferredReleaser;
    }

    public final void m20762b(AbstractDraweeController abstractDraweeController) {
        m20761c();
        this.f14380b.remove(abstractDraweeController);
    }

    public static void m20761c() {
        Preconditions.b(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
