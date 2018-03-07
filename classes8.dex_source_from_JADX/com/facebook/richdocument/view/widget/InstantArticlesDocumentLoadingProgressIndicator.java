package com.facebook.richdocument.view.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: on_text */
public class InstantArticlesDocumentLoadingProgressIndicator extends CustomFrameLayout implements RichDocumentBlocksFetchProgressListener {
    private final ClipDrawable f7205a;
    private final ValueAnimator f7206b;

    /* compiled from: on_text */
    class C08241 implements AnimatorUpdateListener {
        final /* synthetic */ InstantArticlesDocumentLoadingProgressIndicator f7204a;

        C08241(InstantArticlesDocumentLoadingProgressIndicator instantArticlesDocumentLoadingProgressIndicator) {
            this.f7204a = instantArticlesDocumentLoadingProgressIndicator;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7204a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public InstantArticlesDocumentLoadingProgressIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InstantArticlesDocumentLoadingProgressIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7206b = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f7205a = (ClipDrawable) getBackground();
        this.f7206b.setInterpolator(new LinearInterpolator());
        this.f7206b.setDuration(1000);
        this.f7206b.addUpdateListener(new C08241(this));
    }

    public final void mo454a() {
        setAlpha(1.0f);
        this.f7205a.setLevel(0);
    }

    public final void mo456b() {
        this.f7206b.start();
    }

    public final void mo455a(float f) {
        this.f7205a.setLevel((int) (10000.0f * f));
    }

    public static void m7468b(InstantArticlesDocumentLoadingProgressIndicator instantArticlesDocumentLoadingProgressIndicator, float f) {
        instantArticlesDocumentLoadingProgressIndicator.setAlpha(f);
    }
}
