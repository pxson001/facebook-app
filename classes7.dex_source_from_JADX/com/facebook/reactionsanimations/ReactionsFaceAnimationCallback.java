package com.facebook.reactionsanimations;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.facebook.reactionsanimations.data.ReactionsFace;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.lang.ref.WeakReference;

/* compiled from: fetch_group_data */
public abstract class ReactionsFaceAnimationCallback {
    private final WeakReference<FrameListener> f14365a;
    private final int f14366b;
    private final int f14367c;
    public long f14368d;
    public boolean f14369e;
    public int f14370f;

    @TargetApi(16)
    /* compiled from: fetch_group_data */
    class FrameCallbackFaceAnimationCallback extends ReactionsFaceAnimationCallback implements FrameCallback {
        private final Choreographer f14371a = Choreographer.getInstance();

        public FrameCallbackFaceAnimationCallback(FrameListener frameListener, int i, int i2) {
            super(frameListener, i, i2);
        }

        public void doFrame(long j) {
            m18259a(j / 1000000);
        }

        protected final void mo1140a() {
            this.f14371a.postFrameCallback(this);
        }

        protected final void mo1141b() {
            this.f14371a.removeFrameCallback(this);
        }
    }

    /* compiled from: fetch_group_data */
    public interface FrameListener {
        void mo1142a(float f);
    }

    /* compiled from: fetch_group_data */
    class RunnableFaceAnimationCallback extends ReactionsFaceAnimationCallback implements Runnable {
        private final Handler f14372a = new Handler(Looper.getMainLooper());

        public RunnableFaceAnimationCallback(FrameListener frameListener, int i, int i2) {
            super(frameListener, i, i2);
        }

        public void run() {
            m18259a(SystemClock.uptimeMillis());
        }

        protected final void mo1140a() {
            HandlerDetour.b(this.f14372a, this, 25, -1345763735);
        }

        protected final void mo1141b() {
            HandlerDetour.a(this.f14372a, this);
        }
    }

    public abstract void mo1140a();

    public abstract void mo1141b();

    public static ReactionsFaceAnimationCallback m18257a(FrameListener frameListener, ReactionsFace reactionsFace) {
        return (VERSION.SDK_INT >= 16 ? 1 : null) != null ? new FrameCallbackFaceAnimationCallback(frameListener, reactionsFace.mFrameRate, reactionsFace.mFrameCount) : new RunnableFaceAnimationCallback(frameListener, reactionsFace.mFrameRate, reactionsFace.mFrameCount);
    }

    public ReactionsFaceAnimationCallback(FrameListener frameListener, int i, int i2) {
        this.f14365a = new WeakReference(frameListener);
        this.f14366b = i2;
        this.f14367c = Math.round(1000.0f * (((float) i2) / ((float) i)));
    }

    protected final void m18259a(long j) {
        if (this.f14365a.get() == null) {
            mo1141b();
            this.f14368d = 0;
            this.f14370f = -1;
            return;
        }
        if (this.f14368d == 0) {
            this.f14368d = j;
        }
        int i = ((int) (j - this.f14368d)) / this.f14367c;
        if (!this.f14369e || i <= this.f14370f) {
            ((FrameListener) this.f14365a.get()).mo1142a((((float) ((j - this.f14368d) % ((long) this.f14367c))) / ((float) this.f14367c)) * ((float) this.f14366b));
            this.f14370f = ((int) (j - this.f14368d)) / this.f14367c;
            mo1140a();
            return;
        }
        ((FrameListener) this.f14365a.get()).mo1142a((float) this.f14366b);
        mo1141b();
        this.f14368d = 0;
        this.f14370f = -1;
    }
}
