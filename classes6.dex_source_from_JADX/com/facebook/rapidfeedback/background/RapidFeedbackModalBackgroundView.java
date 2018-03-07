package com.facebook.rapidfeedback.background;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.rapidfeedback.background.ClippedImageViewTransitions.Type;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: failed to create NativeDetector  */
public class RapidFeedbackModalBackgroundView extends CustomFrameLayout {
    private int f15383a;
    private int f15384b;
    private int f15385c;
    private int f15386d;
    private ClippedImageView f15387e;
    private ClippedImageView f15388f;
    private ClippedImageViewTransitions f15389g;
    private Rect f15390h;
    private Rect f15391i;
    private Rect f15392j;
    private boolean f15393k;
    private int f15394l;
    private boolean f15395m;

    public RapidFeedbackModalBackgroundView(Context context) {
        super(context);
        m22997a(context);
    }

    public RapidFeedbackModalBackgroundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22997a(context);
    }

    private void m22997a(Context context) {
        this.f15387e = new ClippedImageView(context);
        this.f15388f = new ClippedImageView(context);
    }

    public final void m22999a(int i) {
        this.f15387e.f15370a = (NinePatchDrawable) getResources().getDrawable(i);
        this.f15388f.f15370a = (NinePatchDrawable) getResources().getDrawable(i);
    }

    public final void m23001a(int i, int i2, int i3, int i4, boolean z) {
        int i5;
        this.f15385c = i;
        this.f15386d = i2;
        this.f15383a = i3;
        this.f15384b = i4;
        int i6 = this.f15386d;
        if (z) {
            i5 = this.f15383a - (this.f15384b / 2);
            i6 = this.f15383a + (this.f15384b / 2);
        } else {
            i5 = 0;
        }
        Rect rect = new Rect(0, i5, this.f15385c, this.f15386d + i5);
        Rect rect2 = new Rect(0, 0, this.f15385c, this.f15383a);
        this.f15387e.setDrawableBounds(rect);
        this.f15387e.f15371b = rect2;
        removeView(this.f15387e);
        addView(this.f15387e, 0, new LayoutParams(-1, -1));
        rect2 = new Rect(0, i6 - this.f15386d, this.f15385c, i6);
        Rect rect3 = new Rect(0, this.f15383a, this.f15385c, this.f15386d);
        this.f15388f.setDrawableBounds(rect2);
        this.f15388f.f15371b = rect3;
        removeView(this.f15388f);
        addView(this.f15388f, 0, new LayoutParams(-1, -1));
        this.f15395m = true;
    }

    public final void m23002a(final Runnable runnable) {
        this.f15389g = new ClippedImageViewTransitions(this.f15387e, this.f15388f, this.f15383a, this.f15384b, this.f15386d, Type.EXPAND);
        this.f15389g.setDuration(300);
        this.f15389g.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ RapidFeedbackModalBackgroundView f15382b;

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                runnable.run();
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        startAnimation(this.f15389g);
    }

    public final void m22998a() {
        this.f15389g = new ClippedImageViewTransitions(this.f15387e, this.f15388f, this.f15383a, this.f15384b, this.f15386d, Type.COLLAPSE);
        this.f15389g.setDuration(300);
        startAnimation(this.f15389g);
    }

    public final void m23004b(int i) {
        if (this.f15395m && i != this.f15394l) {
            if (!this.f15393k) {
                this.f15392j = this.f15388f.f15372c;
                this.f15390h = this.f15387e.f15371b;
                this.f15391i = this.f15388f.f15371b;
                this.f15393k = true;
            }
            this.f15394l = i;
            this.f15387e.f15371b = new Rect(this.f15390h.left, this.f15390h.top, this.f15390h.right, this.f15390h.bottom - i);
            this.f15388f.f15371b = new Rect(this.f15391i.left, this.f15391i.top - i, this.f15391i.right, this.f15391i.bottom);
            this.f15388f.setDrawableBounds(new Rect(this.f15392j.left, this.f15392j.top - i, this.f15392j.right, this.f15392j.bottom - i));
            this.f15387e.invalidate();
            this.f15388f.invalidate();
        }
    }

    public final void m23003b() {
        if (this.f15395m) {
            this.f15394l = 0;
            this.f15387e.f15371b = this.f15390h;
            this.f15388f.f15371b = this.f15391i;
            this.f15388f.setDrawableBounds(this.f15392j);
            this.f15392j = null;
            this.f15391i = null;
            this.f15390h = null;
            this.f15393k = false;
        }
    }

    public int getUpperBound() {
        return this.f15387e.f15372c.top;
    }

    public final void m23000a(int i, int i2) {
        this.f15384b = i;
        this.f15383a = i2;
    }
}
