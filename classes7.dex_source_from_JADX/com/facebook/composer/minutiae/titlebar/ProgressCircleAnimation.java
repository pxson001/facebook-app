package com.facebook.composer.minutiae.titlebar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.composer.minutiae.util.BetterArcDrawer;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: thread_presence_ack_post */
public class ProgressCircleAnimation extends View implements AnimatorUpdateListener {
    private Paint f1774a;
    private BetterArcDrawer f1775b;
    public int f1776c;
    private PointF f1777d;
    private float f1778e;

    public ProgressCircleAnimation(Context context) {
        super(context);
        m1742a(null);
    }

    public ProgressCircleAnimation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1742a(attributeSet);
    }

    public ProgressCircleAnimation(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1742a(attributeSet);
    }

    private void m1742a(AttributeSet attributeSet) {
        float dimensionPixelSize;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ProgressCircleAnimation);
            dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(0, 4);
            obtainStyledAttributes.recycle();
        } else {
            dimensionPixelSize = 4.0f;
        }
        this.f1774a = new Paint(this) {
            final /* synthetic */ ProgressCircleAnimation f1773b;
        };
        this.f1775b = new BetterArcDrawer(this.f1774a, 16);
    }

    private void m1741a() {
        float strokeWidth = this.f1774a.getStrokeWidth() / 2.0f;
        this.f1777d = new PointF(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
        this.f1778e = (((float) getWidth()) / 2.0f) - strokeWidth;
    }

    public void onDraw(Canvas canvas) {
        if (this.f1777d == null) {
            m1741a();
        }
        this.f1775b.m1807a(canvas, this.f1777d, this.f1778e, 270.0f, (float) this.f1776c);
    }

    public void setArcAngle(int i) {
        this.f1776c = i;
    }

    @VisibleForTesting
    public int getArcAngle() {
        return this.f1776c;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        invalidate();
    }
}
