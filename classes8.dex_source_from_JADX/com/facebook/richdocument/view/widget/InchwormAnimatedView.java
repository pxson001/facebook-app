package com.facebook.richdocument.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.R;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: open_page_commerce_tap */
public abstract class InchwormAnimatedView extends View {
    private final Paint f7104A;
    public Bitmap f7105B;
    private final RectF f7106C;
    public PlatformBitmapFactory f7107D;
    public final Handler f7108E;
    private boolean f7109F;
    protected int f7110a;
    protected float f7111b;
    protected float f7112c;
    protected float f7113d;
    public Path f7114e;
    private int f7115f;
    private final Path f7116g;
    private final Path f7117h;
    private final PathMeasure f7118i;
    public final ValueAnimator f7119j;
    public final ValueAnimator f7120k;
    public final ValueAnimator f7121l;
    public final ValueAnimator f7122m;
    public final ValueAnimator f7123n;
    public final Runnable f7124o;
    public final Runnable f7125p;
    public float f7126q;
    public float f7127r;
    public float f7128s;
    public float f7129t;
    public float f7130u;
    public boolean f7131v;
    private final Paint f7132w;
    public final Paint f7133x;
    public final Paint f7134y;
    public final Paint f7135z;

    /* compiled from: open_page_commerce_tap */
    class C08151 implements Runnable {
        final /* synthetic */ InchwormAnimatedView f7192a;

        C08151(InchwormAnimatedView inchwormAnimatedView) {
            this.f7192a = inchwormAnimatedView;
        }

        public void run() {
            this.f7192a.f7119j.start();
        }
    }

    /* compiled from: open_page_commerce_tap */
    class C08162 implements Runnable {
        final /* synthetic */ InchwormAnimatedView f7193a;

        C08162(InchwormAnimatedView inchwormAnimatedView) {
            this.f7193a = inchwormAnimatedView;
        }

        public void run() {
            this.f7193a.f7120k.start();
        }
    }

    /* compiled from: open_page_commerce_tap */
    class C08173 implements AnimatorUpdateListener {
        final /* synthetic */ InchwormAnimatedView f7194a;

        C08173(InchwormAnimatedView inchwormAnimatedView) {
            this.f7194a = inchwormAnimatedView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f7194a.f7131v && this.f7194a.f7119j.getCurrentPlayTime() >= 800) {
                this.f7194a.f7120k.start();
                this.f7194a.f7131v = true;
            }
            this.f7194a.f7126q = Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f7194a.invalidate();
        }
    }

    /* compiled from: open_page_commerce_tap */
    class C08184 extends AnimatorListenerAdapter {
        final /* synthetic */ InchwormAnimatedView f7195a;

        C08184(InchwormAnimatedView inchwormAnimatedView) {
            this.f7195a = inchwormAnimatedView;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            HandlerDetour.b(this.f7195a.f7108E, this.f7195a.f7124o, 400, -2133652222);
        }
    }

    /* compiled from: open_page_commerce_tap */
    class C08195 implements AnimatorUpdateListener {
        final /* synthetic */ InchwormAnimatedView f7196a;

        C08195(InchwormAnimatedView inchwormAnimatedView) {
            this.f7196a = inchwormAnimatedView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7196a.f7127r = Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f7196a.invalidate();
        }
    }

    /* compiled from: open_page_commerce_tap */
    class C08206 extends AnimatorListenerAdapter {
        final /* synthetic */ InchwormAnimatedView f7197a;

        C08206(InchwormAnimatedView inchwormAnimatedView) {
            this.f7197a = inchwormAnimatedView;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            HandlerDetour.b(this.f7197a.f7108E, this.f7197a.f7125p, 400, -1074480092);
        }
    }

    /* compiled from: open_page_commerce_tap */
    class C08217 implements AnimatorUpdateListener {
        final /* synthetic */ InchwormAnimatedView f7198a;

        C08217(InchwormAnimatedView inchwormAnimatedView) {
            this.f7198a = inchwormAnimatedView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7198a.f7128s = Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f7198a.invalidate();
        }
    }

    /* compiled from: open_page_commerce_tap */
    class C08228 implements AnimatorUpdateListener {
        final /* synthetic */ InchwormAnimatedView f7199a;

        C08228(InchwormAnimatedView inchwormAnimatedView) {
            this.f7199a = inchwormAnimatedView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7199a.f7129t = Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f7199a.invalidate();
        }
    }

    /* compiled from: open_page_commerce_tap */
    class C08239 implements AnimatorUpdateListener {
        final /* synthetic */ InchwormAnimatedView f7200a;

        C08239(InchwormAnimatedView inchwormAnimatedView) {
            this.f7200a = inchwormAnimatedView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7200a.f7130u = Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static void m7424a(Object obj, Context context) {
        ((InchwormAnimatedView) obj).f7107D = PlatformBitmapFactoryMethodAutoProvider.a(FbInjector.get(context));
    }

    protected abstract Path mo446a(RectF rectF);

    public InchwormAnimatedView(Context context) {
        this(context, null);
    }

    public InchwormAnimatedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InchwormAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7116g = new Path();
        this.f7117h = new Path();
        this.f7118i = new PathMeasure();
        this.f7119j = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f7120k = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f7121l = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f7122m = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f7123n = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f7124o = new C08151(this);
        this.f7125p = new C08162(this);
        this.f7104A = new Paint();
        this.f7106C = new RectF();
        this.f7108E = new Handler();
        Class cls = InchwormAnimatedView.class;
        m7424a((Object) this, getContext());
        float dimensionPixelSize = (float) context.getResources().getDimensionPixelSize(2131431862);
        float f = dimensionPixelSize / 1.2f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.InchwormAnimatedView, i, 0);
        this.f7112c = (float) obtainStyledAttributes.getDimensionPixelSize(0, (int) dimensionPixelSize);
        int color = obtainStyledAttributes.getColor(1, -1);
        int color2 = obtainStyledAttributes.getColor(2, -1);
        int color3 = obtainStyledAttributes.getColor(3, -16777216);
        this.f7110a = obtainStyledAttributes.getDimensionPixelSize(4, (int) f);
        this.f7113d = this.f7112c;
        this.f7132w = m7422a(color, this.f7112c, 255);
        this.f7133x = m7422a(color2, this.f7112c, 153);
        this.f7134y = m7422a(color3, this.f7112c + ((float) (this.f7110a * 2)), 51);
        this.f7135z = m7422a(-16777216, (this.f7112c + ((float) (this.f7110a * 2))) + (2.0f * this.f7113d), 12);
        obtainStyledAttributes.recycle();
        this.f7111b = this.f7112c + ((float) (this.f7110a * 2));
        mo438b();
        this.f7109F = false;
    }

    private static Paint m7422a(int i, float f, int i2) {
        Paint paint = new Paint(1);
        paint.setColor(i);
        paint.setStrokeWidth(f);
        paint.setAlpha(i2);
        paint.setStyle(Style.STROKE);
        return paint;
    }

    private void mo438b() {
        this.f7119j.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f7119j.setDuration(1500);
        this.f7119j.addUpdateListener(new C08173(this));
        this.f7119j.addListener(new C08184(this));
        this.f7120k.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f7120k.setDuration(1500);
        this.f7120k.addUpdateListener(new C08195(this));
        this.f7120k.addListener(new C08206(this));
        this.f7121l.setInterpolator(new LinearInterpolator());
        this.f7121l.setDuration(3000).addUpdateListener(new C08217(this));
        this.f7121l.setRepeatCount(-1);
        this.f7122m.setInterpolator(new LinearInterpolator());
        this.f7122m.setDuration(3000).addUpdateListener(new C08228(this));
        this.f7122m.setRepeatCount(-1);
        this.f7123n.setInterpolator(new DecelerateInterpolator());
        this.f7123n.setDuration(1000);
        this.f7123n.addUpdateListener(new C08239(this));
        setLayerType(2, null);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            RectF rectF = new RectF((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
            if (this.f7106C == null || !this.f7106C.equals(rectF)) {
                this.f7106C.set(rectF);
                this.f7114e = mo446a(rectF);
                this.f7118i.setPath(this.f7114e, false);
                this.f7115f = (int) this.f7118i.getLength();
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.f7114e != null && !this.f7114e.isEmpty()) {
            if (this.f7105B == null || this.f7105B.isRecycled()) {
                this.f7105B = (Bitmap) this.f7107D.a(getWidth(), getHeight(), Config.ARGB_8888).a();
                Canvas canvas2 = new Canvas(this.f7105B);
                canvas2.drawPath(this.f7114e, this.f7135z);
                canvas2.drawPath(this.f7114e, this.f7134y);
                canvas2.drawPath(this.f7114e, this.f7133x);
            }
            canvas.drawBitmap(this.f7105B, 0.0f, 0.0f, this.f7104A);
            if (this.f7109F) {
                m7426g();
                if (!this.f7116g.isEmpty()) {
                    canvas.drawPath(this.f7116g, this.f7132w);
                    this.f7116g.reset();
                }
                if (!this.f7117h.isEmpty()) {
                    canvas.drawPath(this.f7117h, this.f7132w);
                    this.f7117h.reset();
                    return;
                }
                return;
            }
            canvas.drawPath(this.f7114e, this.f7132w);
        }
    }

    private void m7426g() {
        float f = (this.f7127r + this.f7129t) + this.f7130u;
        float f2 = (this.f7126q + this.f7128s) + this.f7130u;
        f -= (float) Math.floor((double) f);
        f2 -= (float) Math.floor((double) f2);
        if (f < f2) {
            this.f7118i.getSegment(f * ((float) this.f7115f), f2 * ((float) this.f7115f), this.f7116g, true);
            this.f7116g.rLineTo(0.0f, 0.0f);
            return;
        }
        this.f7118i.getSegment(f * ((float) this.f7115f), 1.0f * ((float) this.f7115f), this.f7117h, true);
        this.f7116g.rLineTo(0.0f, 0.0f);
        this.f7118i.getSegment(0.0f, f2 * ((float) this.f7115f), this.f7116g, true);
        this.f7117h.rLineTo(0.0f, 0.0f);
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view != this) {
            return;
        }
        if (i == 4 || i == 8) {
            m7430e();
        }
    }

    public final boolean m7428a() {
        if (this.f7109F) {
            return false;
        }
        this.f7109F = true;
        this.f7121l.start();
        this.f7122m.start();
        this.f7119j.start();
        this.f7131v = false;
        return true;
    }

    public final void m7429d() {
        if (this.f7109F && !this.f7123n.isRunning()) {
            this.f7123n.start();
        }
    }

    public final void m7430e() {
        if (this.f7109F) {
            this.f7109F = false;
            if (this.f7119j != null) {
                this.f7119j.cancel();
            }
            if (this.f7120k != null) {
                this.f7120k.cancel();
            }
            if (this.f7121l != null) {
                this.f7121l.cancel();
            }
            if (this.f7122m != null) {
                this.f7122m.cancel();
            }
            if (this.f7123n != null) {
                this.f7123n.cancel();
            }
            HandlerDetour.a(this.f7108E, this.f7124o);
            HandlerDetour.a(this.f7108E, this.f7125p);
            invalidate();
        }
    }

    protected static RectF m7423a(RectF rectF, float f) {
        float width = rectF.width();
        float height = rectF.height();
        RectF rectF2 = new RectF(rectF);
        if (f > width / height) {
            width /= f;
            rectF2.top = ((height - width) / 2.0f) + rectF2.top;
            rectF2.bottom = width + rectF2.top;
        } else {
            height = rectF.height() * f;
            rectF2.left = ((width - height) / 2.0f) + rectF2.left;
            rectF2.right = rectF2.left + height;
        }
        return rectF2;
    }
}
