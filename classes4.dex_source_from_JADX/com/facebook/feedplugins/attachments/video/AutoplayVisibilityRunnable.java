package com.facebook.feedplugins.attachments.video;

import android.view.View;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.ui.inlinevideoplayer.ScrollSpeedEstimator;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Provider;

/* compiled from: phat_rank */
public abstract class AutoplayVisibilityRunnable<V extends View> implements Runnable {
    private final VideoAutoplayVisibilityDecider f5019a;
    private final int f5020b;
    public final ScrollSpeedEstimator f5021c;
    public V f5022d;
    public boolean f5023e = false;
    private final Runnable f5024f = new C02131(this);

    /* compiled from: phat_rank */
    class C02131 implements Runnable {
        final /* synthetic */ AutoplayVisibilityRunnable f5025a;

        C02131(AutoplayVisibilityRunnable autoplayVisibilityRunnable) {
            this.f5025a = autoplayVisibilityRunnable;
        }

        public void run() {
            this.f5025a.f5021c.m5412a(this.f5025a.f5022d);
        }
    }

    public abstract void mo439a(V v);

    public abstract void mo440b(V v);

    public abstract boolean mo441c(V v);

    public AutoplayVisibilityRunnable(AutoplayVisibilityRunnableActivityListener autoplayVisibilityRunnableActivityListener, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider, Provider<ScrollSpeedEstimator> provider, int i) {
        autoplayVisibilityRunnableActivityListener.a(this);
        this.f5019a = videoAutoplayVisibilityDecider;
        this.f5021c = (ScrollSpeedEstimator) provider.get();
        this.f5020b = i;
    }

    public final void m5409d(V v) {
        this.f5022d = v;
        if (!this.f5023e) {
            this.f5023e = true;
            this.f5022d.post(this.f5024f);
            m5403e();
        }
    }

    public final void m5404a() {
        if (this.f5022d != null) {
            this.f5022d.removeCallbacks(this.f5024f);
            this.f5022d.removeCallbacks(this);
        }
        this.f5023e = false;
        this.f5022d = null;
    }

    public final void m5406b() {
        if (this.f5022d != null) {
            this.f5023e = true;
            this.f5021c.m5412a(this.f5022d);
            m5403e();
        }
    }

    public void run() {
        TracerDetour.a("AutoplayVisibilityRunnable.run", -1279173138);
        try {
            if (this.f5023e) {
                this.f5021c.m5414b(this.f5022d);
                boolean c = mo441c(this.f5022d);
                switch (this.f5019a.a(this.f5022d)) {
                    case VISIBLE_FOR_AUTOPLAY:
                        if (!(c || this.f5021c.m5413a())) {
                            TracerDetour.a("AutoplayVisibilityRunnable.onVisibleForAutoplay", -1938319154);
                            try {
                                int i = this.f5022d;
                                mo439a(i);
                                TracerDetour.a(i);
                                break;
                            } finally {
                                TracerDetour.a(-1914784291);
                            }
                        }
                    case OFFSCREEN:
                    case NOT_VISIBLE:
                        TracerDetour.a("AutoplayVisibilityRunnable.onNotVisible", 1603205595);
                        try {
                            mo440b(this.f5022d);
                            TracerDetour.a(2074876989);
                            break;
                        } catch (Throwable th) {
                            TracerDetour.a(2139862521);
                        }
                }
                m5403e();
            }
            TracerDetour.a(-1374639943);
        } catch (Throwable th2) {
            TracerDetour.a(-316179073);
        }
    }

    private void m5403e() {
        this.f5022d.removeCallbacks(this);
        this.f5022d.postDelayed(this, (long) this.f5020b);
    }
}
