package com.facebook.debug.fps;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.debug.fps.FPSController.FPSTimingSource;
import com.google.common.annotations.VisibleForTesting;
import java.lang.reflect.Method;

@TargetApi(16)
/* compiled from: old_android_build_fingerprint */
public class TouchCallbackTimingSource implements FPSTimingSource {
    public final FPSController f11296a;
    private final Choreographer f11297b;
    private final AbstractFbErrorReporter f11298c;
    public final Runnable f11299d;
    private final Method f11300e;
    private final Method f11301f;
    private final Method f11302g;
    public long f11303h = -1;
    public long f11304i = -1;
    private boolean f11305j = false;
    private boolean f11306k;

    /* compiled from: old_android_build_fingerprint */
    public class C04691 implements Runnable {
        final /* synthetic */ TouchCallbackTimingSource f11307a;

        public C04691(TouchCallbackTimingSource touchCallbackTimingSource) {
            this.f11307a = touchCallbackTimingSource;
        }

        public void run() {
            long c = this.f11307a.m16597c();
            if (this.f11307a.f11303h == -1) {
                this.f11307a.f11303h = c;
                this.f11307a.f11304i = c;
                this.f11307a.m16595a(this.f11307a.f11299d);
                return;
            }
            long j = c - this.f11307a.f11304i;
            this.f11307a.f11304i = c;
            this.f11307a.f11296a.m16586a((int) j);
            this.f11307a.m16595a(this.f11307a.f11299d);
        }
    }

    public TouchCallbackTimingSource(FPSController fPSController, Choreographer choreographer, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f11296a = fPSController;
        this.f11297b = choreographer;
        this.f11298c = abstractFbErrorReporter;
        this.f11300e = m16591e();
        this.f11301f = m16592f();
        this.f11302g = m16593g();
        this.f11299d = new C04691(this);
    }

    public final void mo2122a() {
        m16588a(true);
        m16595a(this.f11299d);
    }

    public final void mo2123b() {
        m16588a(false);
        m16590c(this.f11299d);
    }

    private void m16588a(boolean z) {
        if (z && !this.f11305j) {
            this.f11303h = -1;
        }
        this.f11305j = z;
    }

    private Method m16591e() {
        try {
            return Choreographer.class.getDeclaredMethod("postCallback", new Class[]{Integer.TYPE, Runnable.class, Object.class});
        } catch (Exception e) {
            m16587a(e);
            return null;
        }
    }

    private Method m16592f() {
        try {
            return Choreographer.class.getDeclaredMethod("removeCallbacks", new Class[]{Integer.TYPE, Runnable.class, Object.class});
        } catch (Exception e) {
            m16587a(e);
            return null;
        }
    }

    private Method m16593g() {
        try {
            return Choreographer.class.getDeclaredMethod("getFrameTime", new Class[0]);
        } catch (Exception e) {
            m16587a(e);
            return null;
        }
    }

    @VisibleForTesting
    public final void m16595a(Runnable runnable) {
        if (!this.f11306k) {
            try {
                m16589b(runnable);
            } catch (Exception e) {
                m16587a(e);
            }
        }
    }

    @VisibleForTesting
    private void m16589b(Runnable runnable) {
        this.f11300e.invoke(this.f11297b, new Object[]{Integer.valueOf(0), runnable, null});
    }

    @VisibleForTesting
    private void m16590c(Runnable runnable) {
        try {
            this.f11301f.invoke(this.f11297b, new Object[]{Integer.valueOf(0), runnable, null});
        } catch (Exception e) {
            m16587a(e);
        }
    }

    @VisibleForTesting
    public final long m16597c() {
        try {
            return ((Long) this.f11302g.invoke(this.f11297b, new Object[0])).longValue();
        } catch (Exception e) {
            m16587a(e);
            return 0;
        }
    }

    private void m16587a(Exception exception) {
        this.f11298c.m2351b(getClass().getSimpleName(), "Choreographer reflection failed.", exception);
        this.f11306k = true;
    }
}
