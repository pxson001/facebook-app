package com.facebook.debug.fps;

import android.os.Build.VERSION;
import android.view.Choreographer;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: old_api */
public class FPSController {
    public static final boolean f11290a = (VERSION.SDK_INT >= 16);
    public final DefaultAndroidThreadUtil f11291b;
    private final AbstractFbErrorReporter f11292c;
    private final boolean f11293d;
    public FPSTimingSource f11294e;
    public FpsListener f11295f = null;

    /* compiled from: old_api */
    public interface FPSTimingSource {
        void mo2122a();

        void mo2123b();
    }

    @Inject
    public FPSController(@Assisted Boolean bool, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f11293d = bool.booleanValue();
        this.f11291b = defaultAndroidThreadUtil;
        this.f11292c = abstractFbErrorReporter;
        m16585c();
    }

    private void m16584a(FPSTimingSource fPSTimingSource) {
        if (this.f11294e != null) {
            this.f11294e.mo2123b();
        }
        Preconditions.checkNotNull(fPSTimingSource);
        this.f11294e = fPSTimingSource;
    }

    protected final void m16586a(int i) {
        this.f11295f.mo2121a(i);
    }

    private void m16585c() {
        if (!f11290a) {
            return;
        }
        if (this.f11293d) {
            m16584a(new TouchCallbackTimingSource(this, Choreographer.getInstance(), this.f11292c));
        } else {
            m16584a(new ChoreographerTimingSource(this, Choreographer.getInstance()));
        }
    }
}
