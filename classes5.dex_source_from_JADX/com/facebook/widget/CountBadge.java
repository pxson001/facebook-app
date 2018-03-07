package com.facebook.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.ui.animations.BounceAnimationCreator;

/* compiled from: com.google.android.gms.signin.internal.waitForAccessTokenRefresh */
public class CountBadge extends CustomFrameLayout {
    private ViewPropertyAnimator f5583a;
    private ObjectAnimator f5584b;
    private TextView f5585c;
    private AnimatorListenerAdapter f5586d;
    private int f5587e;
    private ViewTransform f5588f;
    private int f5589g = 0;
    private int f5590h = 0;

    /* compiled from: com.google.android.gms.signin.internal.waitForAccessTokenRefresh */
    class C05191 extends AnimatorListenerAdapter {
        final /* synthetic */ CountBadge f5582a;

        C05191(CountBadge countBadge) {
            this.f5582a = countBadge;
        }

        public void onAnimationEnd(Animator animator) {
            CountBadge.m10397i(this.f5582a);
        }
    }

    public CountBadge(Context context) {
        super(context);
        m10389a(null);
    }

    public CountBadge(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10389a(attributeSet);
    }

    private final void m10389a(AttributeSet attributeSet) {
        int i = -16777216;
        setContentView(2130903807);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CountBadge);
            this.f5589g = obtainStyledAttributes.getResourceId(0, this.f5589g);
            this.f5590h = obtainStyledAttributes.getResourceId(1, this.f5590h);
            i = obtainStyledAttributes.getColor(2, -16777216);
            obtainStyledAttributes.recycle();
        }
        int i2 = i;
        setBackgroundResource(this.f5589g);
        this.f5585c = (TextView) c(2131560808);
        this.f5585c.setTextColor(i2);
        this.f5588f = new ViewTransform(this);
        setCount(0);
        this.f5583a = animate();
        this.f5583a.setDuration(150);
        this.f5586d = new C05191(this);
        this.f5584b = BounceAnimationCreator.m10254a(this);
    }

    public void setChecked(boolean z) {
        if (z) {
            setBackgroundResource(this.f5590h);
        } else {
            setBackgroundResource(this.f5589g);
        }
    }

    public void setCount(int i) {
        if (i <= 0) {
            this.f5587e = 0;
            this.f5585c.setText("1");
            m10395g();
            return;
        }
        this.f5587e = i;
        this.f5585c.setText(Integer.toString(this.f5587e));
        m10393e();
    }

    public void setTextSize(float f) {
        this.f5585c.setTextSize(f);
    }

    public int getCount() {
        return this.f5587e;
    }

    private void m10391a(boolean z) {
        if (this.f5587e == 0) {
            this.f5587e = 1;
            m10394f();
        } else if (this.f5587e > 0) {
            setCount(this.f5587e + 1);
            if (z) {
                this.f5584b.start();
            }
        }
    }

    public final void m10398a() {
        m10391a(true);
    }

    private void m10392b(boolean z) {
        if (this.f5587e == 1) {
            this.f5587e = 0;
            m10396h();
        } else if (this.f5587e > 1) {
            setCount(this.f5587e - 1);
            if (z) {
                this.f5584b.start();
            }
        }
    }

    public final void m10399b() {
        m10392b(true);
    }

    private void m10393e() {
        this.f5588f.setScaleX(1.0f);
        this.f5588f.setScaleY(1.0f);
    }

    private void m10394f() {
        this.f5583a.setListener(this.f5586d);
        this.f5583a.scaleX(1.0f);
        this.f5583a.scaleY(1.0f);
    }

    private void m10395g() {
        this.f5588f.setScaleX(0.0f);
        this.f5588f.setScaleY(0.0f);
    }

    private void m10396h() {
        this.f5583a.setListener(this.f5586d);
        this.f5583a.scaleX(0.0f);
        this.f5583a.scaleY(0.0f);
    }

    public static void m10397i(CountBadge countBadge) {
        if (countBadge.f5588f.f5820a.getScaleX() == 1.0f) {
            countBadge.f5584b.start();
        }
    }
}
