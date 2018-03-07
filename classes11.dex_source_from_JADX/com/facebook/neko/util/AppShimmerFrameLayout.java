package com.facebook.neko.util;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: topBlur */
public class AppShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode f855c = new PorterDuffXfermode(Mode.DST_IN);
    protected ValueAnimator f856a;
    protected Bitmap f857b;
    private Paint f858d;
    private Paint f859e;
    private Mask f860f;
    public MaskTranslation f861g;
    private Bitmap f862h;
    private Bitmap f863i;
    public boolean f864j;
    private int f865k;
    private int f866l;
    private int f867m;
    private int f868n;
    private int f869o;
    private int f870p;
    public boolean f871q;
    private OnGlobalLayoutListener f872r;
    private boolean f873s;

    /* compiled from: topBlur */
    class C01111 implements OnGlobalLayoutListener {
        final /* synthetic */ AppShimmerFrameLayout f838a;

        C01111(AppShimmerFrameLayout appShimmerFrameLayout) {
            this.f838a = appShimmerFrameLayout;
        }

        public void onGlobalLayout() {
            boolean z = this.f838a.f871q;
            AppShimmerFrameLayout.m1152g(this.f838a);
            if (this.f838a.f864j || z) {
                this.f838a.m1155a();
            }
        }
    }

    /* compiled from: topBlur */
    class C01122 implements AnimatorUpdateListener {
        final /* synthetic */ AppShimmerFrameLayout f839a;

        C01122(AppShimmerFrameLayout appShimmerFrameLayout) {
            this.f839a = appShimmerFrameLayout;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            AppShimmerFrameLayout.setMaskOffsetX(this.f839a, (int) ((((float) this.f839a.f861g.f851a) * (1.0f - max)) + (((float) this.f839a.f861g.f853c) * max)));
            AppShimmerFrameLayout.setMaskOffsetY(this.f839a, (int) ((max * ((float) this.f839a.f861g.f854d)) + (((float) this.f839a.f861g.f852b) * (1.0f - max))));
        }
    }

    /* compiled from: topBlur */
    class Mask {
        public MaskAngle f842a;
        public float f843b;
        public float f844c;
        public int f845d;
        public int f846e;
        public float f847f;
        public float f848g;
        public float f849h;
        public MaskShape f850i;

        public final int m1131a(int i) {
            return this.f845d > 0 ? this.f845d : (int) (((float) i) * this.f848g);
        }

        public final int m1133b(int i) {
            return this.f846e > 0 ? this.f846e : (int) (((float) i) * this.f849h);
        }

        public final int[] m1132a() {
            switch (this.f850i) {
                case RADIAL:
                    return new int[]{-16777216, -16777216, 0};
                default:
                    return new int[]{0, -16777216, -16777216, 0};
            }
        }

        public final float[] m1134b() {
            switch (this.f850i) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.f847f, 1.0f), Math.min(this.f847f + this.f844c, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.f847f) - this.f844c) / 2.0f, 0.0f), Math.max((1.0f - this.f847f) / 2.0f, 0.0f), Math.min((this.f847f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f847f + 1.0f) + this.f844c) / 2.0f, 1.0f)};
            }
        }
    }

    /* compiled from: topBlur */
    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* compiled from: topBlur */
    public enum MaskShape {
        LINEAR,
        RADIAL
    }

    /* compiled from: topBlur */
    class MaskTranslation {
        public int f851a;
        public int f852b;
        public int f853c;
        public int f854d;

        public final void m1135a(int i, int i2, int i3, int i4) {
            this.f851a = i;
            this.f852b = i2;
            this.f853c = i3;
            this.f854d = i4;
        }
    }

    public AppShimmerFrameLayout(Context context) {
        this(context, null, 0);
    }

    public AppShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.f860f = new Mask();
        this.f858d = new Paint();
        this.f859e = new Paint();
        this.f859e.setAntiAlias(true);
        this.f859e.setDither(true);
        this.f859e.setFilterBitmap(true);
        this.f859e.setXfermode(f855c);
        m1145c();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NekoShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(0)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(0, false));
                }
                if (obtainStyledAttributes.hasValue(1)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(1, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(2)) {
                    setDuration(obtainStyledAttributes.getInt(2, 0));
                }
                if (obtainStyledAttributes.hasValue(3)) {
                    setRepeatCount(obtainStyledAttributes.getInt(3, 0));
                }
                if (obtainStyledAttributes.hasValue(4)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(4, 0));
                }
                if (obtainStyledAttributes.hasValue(5)) {
                    setRepeatMode(obtainStyledAttributes.getInt(5, 0));
                }
                if (obtainStyledAttributes.hasValue(6)) {
                    switch (obtainStyledAttributes.getInt(6, 0)) {
                        case 90:
                            this.f860f.f842a = MaskAngle.CW_90;
                            break;
                        case 180:
                            this.f860f.f842a = MaskAngle.CW_180;
                            break;
                        case 270:
                            this.f860f.f842a = MaskAngle.CW_270;
                            break;
                        default:
                            this.f860f.f842a = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(13)) {
                    switch (obtainStyledAttributes.getInt(13, 0)) {
                        case 1:
                            this.f860f.f850i = MaskShape.RADIAL;
                            break;
                        default:
                            this.f860f.f850i = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(7)) {
                    this.f860f.f844c = obtainStyledAttributes.getFloat(7, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(8)) {
                    this.f860f.f845d = obtainStyledAttributes.getDimensionPixelSize(8, 0);
                }
                if (obtainStyledAttributes.hasValue(9)) {
                    this.f860f.f846e = obtainStyledAttributes.getDimensionPixelSize(9, 0);
                }
                if (obtainStyledAttributes.hasValue(10)) {
                    this.f860f.f847f = obtainStyledAttributes.getFloat(10, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(11)) {
                    this.f860f.f848g = obtainStyledAttributes.getFloat(11, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(12)) {
                    this.f860f.f849h = obtainStyledAttributes.getFloat(12, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(14)) {
                    this.f860f.f843b = obtainStyledAttributes.getFloat(14, 0.0f);
                }
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void m1145c() {
        setAutoStart(false);
        setDuration(1000);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.f860f.f842a = MaskAngle.CW_0;
        this.f860f.f850i = MaskShape.LINEAR;
        this.f860f.f844c = 0.5f;
        this.f860f.f845d = 0;
        this.f860f.f846e = 0;
        this.f860f.f847f = 0.0f;
        this.f860f.f848g = 1.0f;
        this.f860f.f849h = 1.0f;
        this.f860f.f843b = 20.0f;
        this.f861g = new MaskTranslation();
        setBaseAlpha(0.3f);
        m1152g(this);
    }

    public void setAutoStart(boolean z) {
        this.f864j = z;
        m1152g(this);
    }

    public float getBaseAlpha() {
        return ((float) this.f858d.getAlpha()) / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.f858d.setAlpha((int) (m1136a(0.0f, 1.0f, f) * 255.0f));
        m1152g(this);
    }

    public int getDuration() {
        return this.f865k;
    }

    public void setDuration(int i) {
        this.f865k = i;
        m1152g(this);
    }

    public int getRepeatCount() {
        return this.f866l;
    }

    public void setRepeatCount(int i) {
        this.f866l = i;
        m1152g(this);
    }

    public int getRepeatDelay() {
        return this.f867m;
    }

    public void setRepeatDelay(int i) {
        this.f867m = i;
        m1152g(this);
    }

    public int getRepeatMode() {
        return this.f868n;
    }

    public void setRepeatMode(int i) {
        this.f868n = i;
        m1152g(this);
    }

    public MaskShape getMaskShape() {
        return this.f860f.f850i;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.f860f.f850i = maskShape;
        m1152g(this);
    }

    public MaskAngle getAngle() {
        return this.f860f.f842a;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.f860f.f842a = maskAngle;
        m1152g(this);
    }

    public float getDropoff() {
        return this.f860f.f844c;
    }

    public void setDropoff(float f) {
        this.f860f.f844c = f;
        m1152g(this);
    }

    public int getFixedWidth() {
        return this.f860f.f845d;
    }

    public void setFixedWidth(int i) {
        this.f860f.f845d = i;
        m1152g(this);
    }

    public int getFixedHeight() {
        return this.f860f.f846e;
    }

    public void setFixedHeight(int i) {
        this.f860f.f846e = i;
        m1152g(this);
    }

    public float getIntensity() {
        return this.f860f.f847f;
    }

    public void setIntensity(float f) {
        this.f860f.f847f = f;
        m1152g(this);
    }

    public float getRelativeWidth() {
        return this.f860f.f848g;
    }

    public void setRelativeWidth(int i) {
        this.f860f.f848g = (float) i;
        m1152g(this);
    }

    public float getRelativeHeight() {
        return this.f860f.f849h;
    }

    public void setRelativeHeight(int i) {
        this.f860f.f849h = (float) i;
        m1152g(this);
    }

    public float getTilt() {
        return this.f860f.f843b;
    }

    public void setTilt(float f) {
        this.f860f.f843b = f;
        m1152g(this);
    }

    public final void m1155a() {
        if (!this.f871q && !this.f873s) {
            getShimmerAnimation().start();
            this.f871q = true;
        }
    }

    public final void m1156b() {
        if (this.f856a != null) {
            this.f856a.end();
            this.f856a.removeAllUpdateListeners();
            this.f856a.cancel();
        }
        this.f856a = null;
        this.f871q = false;
    }

    public static void setMaskOffsetX(AppShimmerFrameLayout appShimmerFrameLayout, int i) {
        if (appShimmerFrameLayout.f869o != i) {
            appShimmerFrameLayout.f869o = i;
            appShimmerFrameLayout.invalidate();
        }
    }

    public static void setMaskOffsetY(AppShimmerFrameLayout appShimmerFrameLayout, int i) {
        if (appShimmerFrameLayout.f870p != i) {
            appShimmerFrameLayout.f870p = i;
            appShimmerFrameLayout.invalidate();
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1887904742);
        super.onAttachedToWindow();
        if (this.f872r == null) {
            this.f872r = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f872r);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 679402617, a);
    }

    private OnGlobalLayoutListener getLayoutListener() {
        return new C01111(this);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1106627866);
        m1156b();
        if (this.f872r != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.f872r);
            this.f872r = null;
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 208050320, a);
    }

    protected void dispatchDraw(Canvas canvas) {
        if (!this.f871q || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            m1139a(canvas);
        }
    }

    private static float m1136a(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean m1139a(Canvas canvas) {
        Bitmap d = m1148d();
        Bitmap e = m1150e();
        if (d == null || e == null) {
            return false;
        }
        m1142b(new Canvas(d));
        canvas.drawBitmap(d, 0.0f, 0.0f, this.f858d);
        m1146c(new Canvas(e));
        canvas.drawBitmap(e, 0.0f, 0.0f, null);
        return true;
    }

    private Bitmap m1148d() {
        if (this.f863i == null) {
            this.f863i = m1151f();
        }
        return this.f863i;
    }

    private Bitmap m1150e() {
        if (this.f862h == null) {
            this.f862h = m1151f();
        }
        return this.f862h;
    }

    private Bitmap m1151f() {
        return m1137a(getWidth(), getHeight());
    }

    private static Bitmap m1137a(int i, int i2) {
        try {
            return m1141b(i, i2);
        } catch (OutOfMemoryError e) {
            StringBuilder stringBuilder = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
            stringBuilder.append(" (width = ");
            stringBuilder.append(i);
            stringBuilder.append(", height = ");
            stringBuilder.append(i2);
            stringBuilder.append(")\n\n");
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                stringBuilder.append(stackTraceElement.toString());
                stringBuilder.append("\n");
            }
            Log.d("AppShimmerFrameLayout", stringBuilder.toString());
            return null;
        }
    }

    private void m1142b(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    private void m1146c(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap != null) {
            canvas.clipRect(this.f869o, this.f870p, this.f869o + maskBitmap.getWidth(), this.f870p + maskBitmap.getHeight());
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, (float) this.f869o, (float) this.f870p, this.f859e);
        }
    }

    public static void m1152g(AppShimmerFrameLayout appShimmerFrameLayout) {
        appShimmerFrameLayout.m1156b();
        appShimmerFrameLayout.m1153h();
        appShimmerFrameLayout.m1154i();
    }

    private void m1153h() {
        if (this.f857b != null) {
            this.f857b.recycle();
            this.f857b = null;
        }
    }

    private void m1154i() {
        if (this.f863i != null) {
            this.f863i.recycle();
            this.f863i = null;
        }
        if (this.f862h != null) {
            this.f862h.recycle();
            this.f862h = null;
        }
    }

    private Bitmap getMaskBitmap() {
        if (this.f857b != null) {
            return this.f857b;
        }
        if (this.f873s) {
            return this.f857b;
        }
        int a = this.f860f.m1131a(getWidth());
        int b = this.f860f.m1133b(getHeight());
        this.f857b = m1137a(a, b);
        if (this.f857b == null) {
            this.f873s = true;
            return null;
        }
        Shader radialGradient;
        Canvas canvas = new Canvas(this.f857b);
        switch (this.f860f.f850i) {
            case RADIAL:
                radialGradient = new RadialGradient((float) (a / 2), (float) (b / 2), (float) (((double) Math.max(a, b)) / Math.sqrt(2.0d)), this.f860f.m1132a(), this.f860f.m1134b(), TileMode.REPEAT);
                break;
            default:
                int i;
                int i2;
                int i3;
                int i4;
                switch (this.f860f.f842a) {
                    case CW_90:
                        i = b;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = a;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = b;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = a;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient((float) i4, (float) i3, (float) i2, (float) i, this.f860f.m1132a(), this.f860f.m1134b(), TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.f860f.f843b, (float) (a / 2), (float) (b / 2));
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * ((double) Math.max(a, b)))) / 2;
        float f = (float) (sqrt + b);
        canvas.drawRect((float) (-sqrt), (float) (-sqrt), (float) (a + sqrt), f, paint);
        return this.f857b;
    }

    private Animator getShimmerAnimation() {
        if (this.f856a != null) {
            return this.f856a;
        }
        int width = getWidth();
        int height = getHeight();
        int[] iArr = C01133.f840a;
        this.f860f.f850i.ordinal();
        switch (this.f860f.f842a) {
            case CW_90:
                this.f861g.m1135a(0, -height, 0, height);
                break;
            case CW_180:
                this.f861g.m1135a(width, 0, -width, 0);
                break;
            case CW_270:
                this.f861g.m1135a(0, height, 0, -height);
                break;
            default:
                this.f861g.m1135a(-width, 0, width, 0);
                break;
        }
        this.f856a = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f + (((float) this.f867m) / ((float) this.f865k))});
        this.f856a.setDuration((long) (this.f865k + this.f867m));
        this.f856a.setRepeatCount(this.f866l);
        this.f856a.setRepeatMode(this.f868n);
        this.f856a.addUpdateListener(new C01122(this));
        return this.f856a;
    }

    private static Bitmap m1141b(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
    }
}
