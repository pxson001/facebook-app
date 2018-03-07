package com.facebook.debug.fps;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.facebook.debug.fps.FPSController.FPSTimingSource;

@TargetApi(16)
/* compiled from: excessive_delay_scaler_q8 */
public class ChoreographerTimingSource implements FPSTimingSource {
    public final FPSController f12708a;
    public final Choreographer f12709b;
    public final FrameCallback f12710c;
    public long f12711d = -1;
    public long f12712e = -1;
    private boolean f12713f = false;

    /* compiled from: excessive_delay_scaler_q8 */
    class C05991 implements FrameCallback {
        final /* synthetic */ ChoreographerTimingSource f12714a;

        C05991(ChoreographerTimingSource choreographerTimingSource) {
            this.f12714a = choreographerTimingSource;
        }

        public void doFrame(long j) {
            long j2 = j / 1000000;
            if (this.f12714a.f12711d == -1) {
                this.f12714a.f12711d = j2;
                this.f12714a.f12712e = j2;
                this.f12714a.f12709b.postFrameCallback(this.f12714a.f12710c);
                return;
            }
            long j3 = j2 - this.f12714a.f12712e;
            this.f12714a.f12712e = j2;
            this.f12714a.f12708a.a((int) j3);
            this.f12714a.f12709b.postFrameCallback(this.f12714a.f12710c);
        }
    }

    public ChoreographerTimingSource(FPSController fPSController, Choreographer choreographer) {
        this.f12708a = fPSController;
        this.f12709b = choreographer;
        this.f12710c = new C05991(this);
    }

    public final void m13518a() {
        m13517a(true);
        this.f12709b.postFrameCallback(this.f12710c);
    }

    public final void m13519b() {
        m13517a(false);
        this.f12709b.removeFrameCallback(this.f12710c);
    }

    private void m13517a(boolean z) {
        if (z && !this.f12713f) {
            this.f12711d = -1;
        }
        this.f12713f = z;
    }
}
