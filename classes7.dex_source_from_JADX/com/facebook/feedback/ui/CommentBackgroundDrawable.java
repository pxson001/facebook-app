package com.facebook.feedback.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.facebook.fbui.glyph.GlyphColorizer;

/* compiled from: selected */
public class CommentBackgroundDrawable extends Drawable implements AnimatorListener, AnimatorUpdateListener, Callback {
    private final Drawable f4182a;
    private final Drawable f4183b = this.f4182a.getConstantState().newDrawable();
    private final Drawable f4184c;
    private Drawable f4185d;
    private ValueAnimator f4186e;

    public CommentBackgroundDrawable(Context context, GlyphColorizer glyphColorizer) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130773279, typedValue, true);
        this.f4182a = context.getResources().getDrawable(typedValue.resourceId);
        this.f4183b.setColorFilter(glyphColorizer.a(-1447187));
        this.f4184c = context.getResources().getDrawable(2130838152);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        this.f4182a.setBounds(getBounds());
        this.f4182a.draw(canvas);
        if (this.f4185d != null) {
            this.f4185d.setBounds(getBounds());
            this.f4185d.draw(canvas);
        }
    }

    public void setAlpha(int i) {
        this.f4182a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f4182a.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return this.f4182a.getOpacity();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public final void m4804a() {
        m4806c();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 255});
        ofInt.setDuration((long) ViewConfiguration.getLongPressTimeout());
        m4802a(this.f4183b, ofInt);
    }

    public final void m4805a(ValueAnimator valueAnimator) {
        m4806c();
        m4802a(this.f4184c, valueAnimator);
    }

    private void m4802a(Drawable drawable, ValueAnimator valueAnimator) {
        this.f4185d = drawable;
        this.f4186e = valueAnimator;
        valueAnimator.addListener(this);
        valueAnimator.addUpdateListener(this);
        if (!valueAnimator.isStarted()) {
            valueAnimator.start();
        }
    }

    public final void m4806c() {
        this.f4185d = null;
        if (this.f4186e != null) {
            this.f4186e.removeUpdateListener(this);
            this.f4186e = null;
        }
        invalidateSelf();
    }

    public void onAnimationStart(Animator animator) {
        invalidateSelf();
    }

    public void onAnimationEnd(Animator animator) {
        this.f4185d = null;
        this.f4186e = null;
        invalidateSelf();
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.f4185d != null) {
            this.f4185d.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            invalidateSelf();
        }
    }

    public static ValueAnimator m4803d() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, 0});
        ofInt.setDuration(4000);
        return ofInt;
    }
}
