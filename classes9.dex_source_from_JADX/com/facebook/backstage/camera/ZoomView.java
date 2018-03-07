package com.facebook.backstage.camera;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;

/* compiled from: search/awareness/tutorial_nux */
public class ZoomView extends FrameLayout {
    private final TextView f4480a;
    private final ZoomIndicator f4481b;
    private ViewPropertyAnimator f4482c;

    /* compiled from: search/awareness/tutorial_nux */
    class C04271 implements AnimatorListener {
        final /* synthetic */ ZoomView f4470a;

        C04271(ZoomView zoomView) {
            this.f4470a = zoomView;
        }

        public void onAnimationStart(Animator animator) {
            this.f4470a.setVisibility(0);
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: search/awareness/tutorial_nux */
    class C04282 implements AnimatorListener {
        final /* synthetic */ ZoomView f4471a;

        C04282(ZoomView zoomView) {
            this.f4471a = zoomView;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f4471a.setVisibility(4);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: search/awareness/tutorial_nux */
    class ZoomIndicator extends View {
        final /* synthetic */ ZoomView f4472a;
        private final Paint f4473b;
        private final int f4474c;
        private float f4475d;
        private float f4476e;
        private float f4477f;
        private float f4478g;
        private float f4479h;

        public ZoomIndicator(ZoomView zoomView, Context context) {
            this.f4472a = zoomView;
            super(context);
            setWillNotDraw(false);
            this.f4473b = new Paint(1);
            this.f4473b.setColor(-1);
            this.f4473b.setStyle(Style.STROKE);
            this.f4473b.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
            this.f4473b.setAlpha(128);
            this.f4474c = (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics());
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.f4475d = (float) ((Math.min(getWidth(), getHeight()) - this.f4474c) / 2);
            this.f4476e = TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics());
            this.f4478g = (float) (getWidth() / 2);
            this.f4479h = (float) (getHeight() / 2);
        }

        public final void m4449a(float f, float f2) {
            this.f4477f = this.f4476e + ((this.f4475d - this.f4476e) * ((f - 1.0f) / (f2 - 1.0f)));
            invalidate();
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawCircle(this.f4478g, this.f4479h, this.f4477f, this.f4473b);
            canvas.drawCircle(this.f4478g, this.f4479h, this.f4475d, this.f4473b);
            canvas.drawCircle(this.f4478g, this.f4479h, this.f4476e, this.f4473b);
            canvas.drawLine(this.f4478g, this.f4479h - this.f4476e, this.f4478g, this.f4479h - this.f4475d, this.f4473b);
            Canvas canvas2 = canvas;
            canvas2.drawLine(this.f4478g, this.f4476e + this.f4479h, this.f4478g, this.f4475d + this.f4479h, this.f4473b);
            canvas.drawLine(this.f4478g - this.f4476e, this.f4479h, this.f4478g - this.f4475d, this.f4479h, this.f4473b);
            canvas2 = canvas;
            canvas2.drawLine(this.f4476e + this.f4478g, this.f4479h, this.f4475d + this.f4478g, this.f4479h, this.f4473b);
        }
    }

    public ZoomView(Context context) {
        this(context, null);
    }

    public ZoomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4480a = new TextView(context);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f4480a.setLayoutParams(layoutParams);
        this.f4480a.setTextSize(2, 32.0f);
        this.f4480a.setTextColor(Color.argb(128, 255, 255, 255));
        addView(this.f4480a);
        this.f4481b = new ZoomIndicator(this, context);
        this.f4481b.setLayoutParams(new MarginLayoutParams(-1, -1));
        addView(this.f4481b);
    }

    public final void m4451a(int i, int i2) {
        float f = ((float) i) / 100.0f;
        float f2 = ((float) i2) / 100.0f;
        this.f4480a.setText(String.format("%.2f", new Object[]{Float.valueOf(f)}));
        this.f4481b.m4449a(f, f2);
    }

    public final void m4450a() {
        if (this.f4482c != null) {
            this.f4482c.cancel();
        }
        this.f4482c = animate();
        this.f4482c.setDuration(250);
        this.f4482c.alpha(1.0f);
        this.f4482c.setListener(new C04271(this));
        this.f4482c.start();
    }

    public final void m4452b() {
        if (this.f4482c != null) {
            this.f4482c.cancel();
        }
        this.f4482c = animate();
        this.f4482c.setDuration(450);
        this.f4482c.alpha(0.0f);
        this.f4482c.setListener(new C04282(this));
        this.f4482c.start();
    }
}
