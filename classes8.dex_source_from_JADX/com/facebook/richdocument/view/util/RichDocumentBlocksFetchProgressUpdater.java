package com.facebook.richdocument.view.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.facebook.instantarticles.BaseInstantArticlesDelegateImpl;

/* compiled from: opened_link */
public class RichDocumentBlocksFetchProgressUpdater {
    public final BaseInstantArticlesDelegateImpl f7059a;
    public final ValueAnimator f7060b = ValueAnimator.ofFloat(new float[]{0.0f, 0.7f});
    private ValueAnimator f7061c;
    public float f7062d;
    public float f7063e;
    public boolean f7064f;
    public boolean f7065g;

    /* compiled from: opened_link */
    class C08021 implements AnimatorUpdateListener {
        final /* synthetic */ RichDocumentBlocksFetchProgressUpdater f7055a;

        C08021(RichDocumentBlocksFetchProgressUpdater richDocumentBlocksFetchProgressUpdater) {
            this.f7055a = richDocumentBlocksFetchProgressUpdater;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7055a.f7062d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RichDocumentBlocksFetchProgressUpdater.m7364c(this.f7055a);
        }
    }

    /* compiled from: opened_link */
    class C08032 extends AnimatorListenerAdapter {
        final /* synthetic */ RichDocumentBlocksFetchProgressUpdater f7056a;

        C08032(RichDocumentBlocksFetchProgressUpdater richDocumentBlocksFetchProgressUpdater) {
            this.f7056a = richDocumentBlocksFetchProgressUpdater;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.f7056a.f7065g) {
                this.f7056a.f7059a.O.setVisibility(0);
            }
        }
    }

    /* compiled from: opened_link */
    class C08043 implements AnimatorUpdateListener {
        final /* synthetic */ RichDocumentBlocksFetchProgressUpdater f7057a;

        C08043(RichDocumentBlocksFetchProgressUpdater richDocumentBlocksFetchProgressUpdater) {
            this.f7057a = richDocumentBlocksFetchProgressUpdater;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7057a.f7063e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RichDocumentBlocksFetchProgressUpdater.m7364c(this.f7057a);
        }
    }

    /* compiled from: opened_link */
    class C08054 extends AnimatorListenerAdapter {
        final /* synthetic */ RichDocumentBlocksFetchProgressUpdater f7058a;

        C08054(RichDocumentBlocksFetchProgressUpdater richDocumentBlocksFetchProgressUpdater) {
            this.f7058a = richDocumentBlocksFetchProgressUpdater;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f7058a.f7063e = 0.0f;
        }
    }

    public RichDocumentBlocksFetchProgressUpdater(BaseInstantArticlesDelegateImpl baseInstantArticlesDelegateImpl, long j) {
        this.f7059a = baseInstantArticlesDelegateImpl;
        this.f7060b.setDuration(j);
        this.f7060b.setInterpolator(new DecelerateInterpolator());
        this.f7060b.addUpdateListener(new C08021(this));
        this.f7060b.addListener(new C08032(this));
    }

    public static void m7364c(RichDocumentBlocksFetchProgressUpdater richDocumentBlocksFetchProgressUpdater) {
        BaseInstantArticlesDelegateImpl baseInstantArticlesDelegateImpl = richDocumentBlocksFetchProgressUpdater.f7059a;
        float f = richDocumentBlocksFetchProgressUpdater.f7062d + richDocumentBlocksFetchProgressUpdater.f7063e;
        if (baseInstantArticlesDelegateImpl.P != null) {
            baseInstantArticlesDelegateImpl.P.mo455a(f);
            if (f == 0.0f) {
                baseInstantArticlesDelegateImpl.P.mo454a();
            } else if (f == 1.0f) {
                baseInstantArticlesDelegateImpl.P.mo456b();
            }
        }
    }

    public final void m7365b() {
        if (this.f7064f) {
            this.f7065g = true;
            this.f7060b.cancel();
            this.f7061c = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f - this.f7062d});
            this.f7061c.setDuration(1000);
            this.f7061c.setInterpolator(new AccelerateInterpolator());
            this.f7061c.addUpdateListener(new C08043(this));
            this.f7061c.addListener(new C08054(this));
            this.f7061c.start();
            this.f7064f = false;
        }
    }
}
