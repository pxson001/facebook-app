package com.facebook.ui.waveanimator;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.facebook.feedback.reactions.ui.ReactionsVectorDrawable;
import com.facebook.feedback.reactions.ui.ReactionsVectorDrawable.C03371;
import com.facebook.feedback.reactions.ui.VectorGraphicConfig.AnimationWave;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.lang.ref.WeakReference;

/* compiled from: empty feedback for type  */
public abstract class MultiWaveAnimator {
    private final WeakReference<WaveAnimatorListener> f15317a;
    private final WaveInfo f15318b = new WaveInfo();
    private final WaveInfo f15319c = new WaveInfo();
    private final WaveInfo f15320d = new WaveInfo();
    public long f15321e;

    @TargetApi(16)
    /* compiled from: empty feedback for type  */
    class FrameCallbackMultiWaveAnimator extends MultiWaveAnimator implements FrameCallback {
        private final Choreographer f15322a = Choreographer.getInstance();

        public FrameCallbackMultiWaveAnimator(C03371 c03371) {
            super(c03371);
        }

        public void doFrame(long j) {
            m19332a(j / 1000000);
        }

        protected final void mo1186a() {
            this.f15322a.postFrameCallback(this);
        }

        protected final void mo1187b() {
            this.f15322a.removeFrameCallback(this);
        }
    }

    /* compiled from: empty feedback for type  */
    class RunnableMultiWaveAnimator extends MultiWaveAnimator implements Runnable {
        private final Handler f15323a = new Handler(Looper.getMainLooper());

        public RunnableMultiWaveAnimator(C03371 c03371) {
            super(c03371);
        }

        public void run() {
            m19332a(SystemClock.uptimeMillis());
        }

        protected final void mo1186a() {
            HandlerDetour.b(this.f15323a, this, 25, -1515438366);
        }

        protected final void mo1187b() {
            HandlerDetour.a(this.f15323a, this);
        }
    }

    /* compiled from: empty feedback for type  */
    public class WaveInfo {
        public int f15324a = 1000;
        public WaveType f15325b = WaveType.SIN;
        public double f15326c;

        public final float m19341c() {
            return (float) this.f15326c;
        }
    }

    /* compiled from: empty feedback for type  */
    public enum WaveType {
        SIN,
        COS
    }

    public abstract void mo1186a();

    public abstract void mo1187b();

    public static MultiWaveAnimator m19328a(C03371 c03371) {
        Object obj;
        if (VERSION.SDK_INT >= 16) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return new FrameCallbackMultiWaveAnimator(c03371);
        }
        return new RunnableMultiWaveAnimator(c03371);
    }

    public MultiWaveAnimator(C03371 c03371) {
        this.f15317a = new WeakReference(c03371);
    }

    protected final void m19332a(long j) {
        if (this.f15317a.get() == null) {
            mo1187b();
            this.f15321e = 0;
            return;
        }
        if (this.f15321e == 0) {
            this.f15321e = j;
        }
        m19330b(j);
        C03371 c03371 = (C03371) this.f15317a.get();
        float c = this.f15318b.m19341c();
        float c2 = this.f15319c.m19341c();
        float c3 = this.f15320d.m19341c();
        if (c03371.f3890a.f3897d.k()) {
            AnimationWave animationWave = ReactionsVectorDrawable.m4537c(c03371.f3890a).mXAnimationWave;
            c03371.f3890a.f3907n = ((animationWave.mRange1 - animationWave.mRange0) * c) + animationWave.mRange0;
            animationWave = ReactionsVectorDrawable.m4537c(c03371.f3890a).mYAnimationWave;
            c03371.f3890a.f3908o = ((animationWave.mRange1 - animationWave.mRange0) * c2) + animationWave.mRange0;
            animationWave = ReactionsVectorDrawable.m4537c(c03371.f3890a).mRotationAnimationWave;
            c03371.f3890a.f3909p = ((animationWave.mRange1 - animationWave.mRange0) * c3) + animationWave.mRange0;
            ReactionsVectorDrawable.m4540f(c03371.f3890a);
            c03371.f3890a.invalidateSelf();
        }
        mo1186a();
    }

    private void m19330b(long j) {
        m19329a(this.f15318b, j);
        m19329a(this.f15319c, j);
        m19329a(this.f15320d, j);
    }

    private void m19329a(WaveInfo waveInfo, long j) {
        double d = 0.0d;
        if (waveInfo.f15324a == 0) {
            waveInfo.f15326c = 0.0d;
            return;
        }
        double d2 = (double) (((float) ((j - this.f15321e) % ((long) waveInfo.f15324a))) / ((float) waveInfo.f15324a));
        if (waveInfo.f15325b == WaveType.COS) {
            d = 1.5707963267948966d;
        }
        waveInfo.f15326c = (Math.sin(d + (d2 * 6.283185307179586d)) * 0.5d) + 0.5d;
    }

    public final float m19334c() {
        return this.f15318b.m19341c();
    }

    public final float m19335d() {
        return this.f15319c.m19341c();
    }

    public final float m19336e() {
        return this.f15320d.m19341c();
    }
}
