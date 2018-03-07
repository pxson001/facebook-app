package com.facebook.photos.dialog.clipping;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: listening_to */
public class ClippingAnimationController {
    public final ClippingImageView f10122a;
    @Nullable
    public DrawingRule f10123b;
    @Nullable
    public DrawingRule f10124c;
    @Nullable
    public ValueAnimator f10125d;
    private AnimatorUpdateListener f10126e = new C08511(this);
    private AnimatorListener f10127f = new C08522(this);

    /* compiled from: listening_to */
    class C08511 implements AnimatorUpdateListener {
        final /* synthetic */ ClippingAnimationController f10119a;
        private DrawingRule f10120b;

        C08511(ClippingAnimationController clippingAnimationController) {
            this.f10119a = clippingAnimationController;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (this.f10120b == null) {
                this.f10120b = new DrawingRule();
            }
            ClippingAnimationController.m11997a(this.f10119a, this.f10119a.f10123b, this.f10119a.f10124c, floatValue, this.f10120b);
            this.f10120b = this.f10119a.f10122a.m12001a(this.f10120b);
        }
    }

    /* compiled from: listening_to */
    class C08522 implements AnimatorListener {
        final /* synthetic */ ClippingAnimationController f10121a;

        C08522(ClippingAnimationController clippingAnimationController) {
            this.f10121a = clippingAnimationController;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (animator == this.f10121a.f10125d) {
                this.f10121a.f10125d = null;
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public ClippingAnimationController(ClippingImageView clippingImageView) {
        this.f10122a = clippingImageView;
    }

    public final void m11999a(Drawable drawable, DrawingRule drawingRule, DrawingRule drawingRule2, @Nullable ClipAnimationListener clipAnimationListener) {
        if (this.f10125d != null) {
            this.f10125d.cancel();
        }
        this.f10123b = m11995a(drawingRule);
        this.f10124c = m11995a(drawingRule2);
        this.f10122a.setDrawable(drawable);
        this.f10122a.mo557a(this.f10123b, this.f10124c);
        this.f10125d = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f10125d.setDuration(300);
        this.f10125d.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f10125d.addUpdateListener(this.f10126e);
        this.f10125d.addListener(this.f10127f);
        if (clipAnimationListener != null) {
            this.f10125d.addListener(clipAnimationListener);
            this.f10125d.addUpdateListener(clipAnimationListener);
        }
        this.f10125d.start();
    }

    public final void m11998a() {
        if (this.f10125d != null) {
            this.f10125d.removeAllListeners();
            this.f10125d.removeAllUpdateListeners();
            this.f10125d.cancel();
            this.f10125d = null;
        }
    }

    public final DrawingRule m12000c() {
        Preconditions.checkNotNull(this.f10125d);
        Preconditions.checkNotNull(this.f10124c);
        Preconditions.checkNotNull(this.f10123b);
        DrawingRule drawingRule = new DrawingRule();
        m11997a(this, this.f10123b, this.f10124c, this.f10125d != null ? ((Float) this.f10125d.getAnimatedValue()).floatValue() : 1.0f, drawingRule);
        int[] iArr = new int[2];
        this.f10122a.getLocationOnScreen(iArr);
        DrawingRule drawingRule2 = new DrawingRule();
        drawingRule2.f10719a.set(drawingRule.f10719a);
        drawingRule2.f10720b.set(drawingRule.f10720b);
        drawingRule2.f10719a.offset(iArr[0], iArr[1]);
        drawingRule2.f10720b.offset(iArr[0], iArr[1]);
        return drawingRule2;
    }

    private DrawingRule m11995a(DrawingRule drawingRule) {
        int[] iArr = new int[2];
        this.f10122a.getLocationOnScreen(iArr);
        DrawingRule drawingRule2 = new DrawingRule();
        drawingRule2.f10719a.set(drawingRule.f10719a);
        drawingRule2.f10720b.set(drawingRule.f10720b);
        drawingRule2.f10719a.offset(-iArr[0], -iArr[1]);
        drawingRule2.f10720b.offset(-iArr[0], -iArr[1]);
        return drawingRule2;
    }

    public static void m11997a(ClippingAnimationController clippingAnimationController, DrawingRule drawingRule, DrawingRule drawingRule2, float f, DrawingRule drawingRule3) {
        m11996a(drawingRule.f10720b, drawingRule2.f10720b, f, drawingRule3.f10720b);
        m11996a(drawingRule.f10719a, drawingRule2.f10719a, f, drawingRule3.f10719a);
    }

    private static void m11996a(Rect rect, Rect rect2, float f, Rect rect3) {
        float f2 = ((float) rect.top) + (((float) (rect2.top - rect.top)) * f);
        rect3.set((int) (((float) rect.left) + (((float) (rect2.left - rect.left)) * f)), (int) f2, (int) (((float) rect.right) + (((float) (rect2.right - rect.right)) * f)), (int) (((float) rect.bottom) + (((float) (rect2.bottom - rect.bottom)) * f)));
    }
}
