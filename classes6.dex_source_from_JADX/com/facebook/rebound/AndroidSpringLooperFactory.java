package com.facebook.rebound;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: facebook.com/ */
abstract class AndroidSpringLooperFactory {

    @TargetApi(16)
    /* compiled from: facebook.com/ */
    public class ChoreographerAndroidSpringLooper extends SpringLooper {
        public final Choreographer f15410b;
        public final FrameCallback f15411c = new C10941(this);
        public boolean f15412d;
        public long f15413e;

        /* compiled from: facebook.com/ */
        class C10941 implements FrameCallback {
            final /* synthetic */ ChoreographerAndroidSpringLooper f15408a;

            C10941(ChoreographerAndroidSpringLooper choreographerAndroidSpringLooper) {
                this.f15408a = choreographerAndroidSpringLooper;
            }

            public void doFrame(long j) {
                if (this.f15408a.f15412d && this.f15408a.f15409a != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f15408a.f15409a.m23036a((double) (uptimeMillis - this.f15408a.f15413e));
                    this.f15408a.f15413e = uptimeMillis;
                    this.f15408a.f15410b.postFrameCallback(this.f15408a.f15411c);
                }
            }
        }

        public ChoreographerAndroidSpringLooper(Choreographer choreographer) {
            this.f15410b = choreographer;
        }

        public final void mo1217b() {
            if (!this.f15412d) {
                this.f15412d = true;
                this.f15413e = SystemClock.uptimeMillis();
                this.f15410b.removeFrameCallback(this.f15411c);
                this.f15410b.postFrameCallback(this.f15411c);
            }
        }

        public final void mo1218c() {
            this.f15412d = false;
            this.f15410b.removeFrameCallback(this.f15411c);
        }
    }

    /* compiled from: facebook.com/ */
    public class LegacyAndroidSpringLooper extends SpringLooper {
        public final Handler f15415b;
        public final Runnable f15416c = new C10951(this);
        public boolean f15417d;
        public long f15418e;

        /* compiled from: facebook.com/ */
        class C10951 implements Runnable {
            final /* synthetic */ LegacyAndroidSpringLooper f15414a;

            C10951(LegacyAndroidSpringLooper legacyAndroidSpringLooper) {
                this.f15414a = legacyAndroidSpringLooper;
            }

            public void run() {
                if (this.f15414a.f15417d && this.f15414a.f15409a != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f15414a.f15409a.m23036a((double) (uptimeMillis - this.f15414a.f15418e));
                    this.f15414a.f15418e = uptimeMillis;
                    HandlerDetour.a(this.f15414a.f15415b, this.f15414a.f15416c, -257725303);
                }
            }
        }

        public LegacyAndroidSpringLooper(Handler handler) {
            this.f15415b = handler;
        }

        public final void mo1217b() {
            if (!this.f15417d) {
                this.f15417d = true;
                this.f15418e = SystemClock.uptimeMillis();
                HandlerDetour.a(this.f15415b, this.f15416c);
                HandlerDetour.a(this.f15415b, this.f15416c, -1959768981);
            }
        }

        public final void mo1218c() {
            this.f15417d = false;
            HandlerDetour.a(this.f15415b, this.f15416c);
        }
    }

    AndroidSpringLooperFactory() {
    }
}
