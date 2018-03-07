package com.facebook.facecastdisplay.streamingreactions;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import javax.inject.Inject;

/* compiled from: starting */
public class StreamingReactionsFireworkExplosionDrawable extends Drawable {
    private static final Rect f3337a = new Rect();
    private static final Path f3338b = new Path();
    private final Interpolator f3339c;
    private final Resources f3340d;
    private final Paint f3341e = new Paint();
    public final ValueAnimator f3342f;
    private int f3343g;
    private int f3344h;

    /* compiled from: starting */
    class C02901 implements AnimatorUpdateListener {
        final /* synthetic */ StreamingReactionsFireworkExplosionDrawable f3336a;

        C02901(StreamingReactionsFireworkExplosionDrawable streamingReactionsFireworkExplosionDrawable) {
            this.f3336a = streamingReactionsFireworkExplosionDrawable;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3336a.invalidateSelf();
        }
    }

    @Inject
    public StreamingReactionsFireworkExplosionDrawable(Resources resources) {
        this.f3340d = resources;
        this.f3341e.setStrokeWidth((float) this.f3340d.getDimensionPixelSize(2131428047));
        this.f3341e.setStrokeCap(Cap.BUTT);
        this.f3341e.setStyle(Style.STROKE);
        this.f3343g = this.f3340d.getColor(2131362560);
        this.f3344h = this.f3343g;
        this.f3339c = PathInterpolatorCompat.a(0.075f, 0.82f, 0.165f, 1.0f);
        this.f3342f = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f3342f.setDuration(600);
        this.f3342f.setInterpolator(this.f3339c);
        this.f3342f.addUpdateListener(new C02901(this));
    }

    public void draw(Canvas canvas) {
        if (this.f3342f.isRunning()) {
            copyBounds(f3337a);
            float min = ((float) Math.min(f3337a.height(), f3337a.width())) / 2.0f;
            float f = 0.5f * min;
            float f2 = -f;
            f2 += (min - f2) * this.f3342f.getAnimatedFraction();
            f += f2;
            f2 = Math.max(0.0f, f2);
            min = Math.min(min, f);
            f = this.f3341e.getStrokeWidth() / 2.0f;
            f2 += f;
            min -= f;
            if (f2 <= min) {
                f3338b.reset();
                f3338b.moveTo((float) f3337a.centerX(), f2 + ((float) f3337a.centerY()));
                f3338b.lineTo((float) f3337a.centerX(), min + ((float) f3337a.centerY()));
                canvas.save();
                for (int i = 0; i < 10; i++) {
                    this.f3341e.setColor(i % 2 == 0 ? this.f3344h : this.f3343g);
                    canvas.drawPath(f3338b, this.f3341e);
                    canvas.rotate(36.0f, (float) f3337a.centerX(), (float) f3337a.centerY());
                }
                canvas.restore();
            }
        }
    }

    public void setAlpha(int i) {
        this.f3341e.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3341e.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return this.f3341e.getAlpha();
    }

    public final void m4088a(int i) {
        this.f3344h = i;
    }
}
