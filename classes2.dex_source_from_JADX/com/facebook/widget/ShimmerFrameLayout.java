package com.facebook.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
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
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.facebook.R;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: memory_cache_put */
public class ShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode f14417c = new PorterDuffXfermode(Mode.DST_IN);
    protected ValueAnimator f14418a;
    protected Bitmap f14419b;
    private AbstractFbErrorReporter f14420d;
    private Paint f14421e;
    private Paint f14422f;
    private Mask f14423g;
    public MaskTranslation f14424h;
    private Bitmap f14425i;
    private Bitmap f14426j;
    public boolean f14427k;
    private int f14428l;
    private int f14429m;
    private int f14430n;
    private int f14431o;
    private int f14432p;
    private int f14433q;
    public boolean f14434r;
    private OnGlobalLayoutListener f14435s;

    /* compiled from: memory_cache_put */
    class Mask {
        public MaskAngle f14436a;
        public float f14437b;
        public float f14438c;
        public int f14439d;
        public int f14440e;
        public float f14441f;
        public float f14442g;
        public float f14443h;
        public MaskShape f14444i;

        public final int m20807a(int i) {
            return this.f14439d > 0 ? this.f14439d : (int) (((float) i) * this.f14442g);
        }

        public final int m20809b(int i) {
            return this.f14440e > 0 ? this.f14440e : (int) (((float) i) * this.f14443h);
        }

        public final int[] m20808a() {
            switch (3.a[this.f14444i.ordinal()]) {
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    return new int[]{-16777216, -16777216, 0};
                default:
                    return new int[]{0, -16777216, -16777216, 0};
            }
        }

        public final float[] m20810b() {
            switch (3.a[this.f14444i.ordinal()]) {
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    return new float[]{0.0f, Math.min(this.f14441f, 1.0f), Math.min(this.f14441f + this.f14438c, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.f14441f) - this.f14438c) / 2.0f, 0.0f), Math.max((1.0f - this.f14441f) / 2.0f, 0.0f), Math.min((this.f14441f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f14441f + 1.0f) + this.f14438c) / 2.0f, 1.0f)};
            }
        }
    }

    /* compiled from: memory_cache_put */
    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* compiled from: memory_cache_put */
    public enum MaskShape {
        LINEAR,
        RADIAL
    }

    /* compiled from: memory_cache_put */
    class MaskTranslation {
        public int f14445a;
        public int f14446b;
        public int f14447c;
        public int f14448d;

        public final void m20811a(int i, int i2, int i3, int i4) {
            this.f14445a = i;
            this.f14446b = i2;
            this.f14447c = i3;
            this.f14448d = i4;
        }
    }

    /* compiled from: memory_cache_put */
    class C06091 implements OnGlobalLayoutListener {
        final /* synthetic */ ShimmerFrameLayout f14540a;

        C06091(ShimmerFrameLayout shimmerFrameLayout) {
            this.f14540a = shimmerFrameLayout;
        }

        public void onGlobalLayout() {
            boolean z = this.f14540a.f14434r;
            ShimmerFrameLayout.m20802g(this.f14540a);
            if (this.f14540a.f14427k || z) {
                this.f14540a.m20805b();
            }
        }
    }

    public ShimmerFrameLayout(Context context) {
        this(context, null, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14420d = FbErrorReporterImpl.m2317a(FbInjector.get(context));
        setWillNotDraw(false);
        this.f14423g = new Mask();
        this.f14421e = new Paint();
        this.f14422f = new Paint();
        this.f14422f.setAntiAlias(true);
        this.f14422f.setDither(true);
        this.f14422f.setFilterBitmap(true);
        this.f14422f.setXfermode(f14417c);
        m20789a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
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
                            this.f14423g.f14436a = MaskAngle.CW_90;
                            break;
                        case 180:
                            this.f14423g.f14436a = MaskAngle.CW_180;
                            break;
                        case 270:
                            this.f14423g.f14436a = MaskAngle.CW_270;
                            break;
                        default:
                            this.f14423g.f14436a = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(13)) {
                    switch (obtainStyledAttributes.getInt(13, 0)) {
                        case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                            this.f14423g.f14444i = MaskShape.RADIAL;
                            break;
                        default:
                            this.f14423g.f14444i = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(7)) {
                    this.f14423g.f14438c = obtainStyledAttributes.getFloat(7, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(8)) {
                    this.f14423g.f14439d = obtainStyledAttributes.getDimensionPixelSize(8, 0);
                }
                if (obtainStyledAttributes.hasValue(9)) {
                    this.f14423g.f14440e = obtainStyledAttributes.getDimensionPixelSize(9, 0);
                }
                if (obtainStyledAttributes.hasValue(10)) {
                    this.f14423g.f14441f = obtainStyledAttributes.getFloat(10, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(11)) {
                    this.f14423g.f14442g = obtainStyledAttributes.getFloat(11, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(12)) {
                    this.f14423g.f14443h = obtainStyledAttributes.getFloat(12, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(14)) {
                    this.f14423g.f14437b = obtainStyledAttributes.getFloat(14, 0.0f);
                }
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void m20789a() {
        setAutoStart(false);
        setDuration(1000);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.f14423g.f14436a = MaskAngle.CW_0;
        this.f14423g.f14444i = MaskShape.LINEAR;
        this.f14423g.f14438c = 0.5f;
        this.f14423g.f14439d = 0;
        this.f14423g.f14440e = 0;
        this.f14423g.f14441f = 0.0f;
        this.f14423g.f14442g = 1.0f;
        this.f14423g.f14443h = 1.0f;
        this.f14423g.f14437b = 20.0f;
        this.f14424h = new MaskTranslation();
        setBaseAlpha(0.3f);
        m20802g(this);
    }

    public void setAutoStart(boolean z) {
        this.f14427k = z;
        m20802g(this);
    }

    public float getBaseAlpha() {
        return ((float) this.f14421e.getAlpha()) / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.f14421e.setAlpha((int) (m20787a(0.0f, 1.0f, f) * 255.0f));
        m20802g(this);
    }

    public int getDuration() {
        return this.f14428l;
    }

    public void setDuration(int i) {
        this.f14428l = i;
        m20802g(this);
    }

    public int getRepeatCount() {
        return this.f14429m;
    }

    public void setRepeatCount(int i) {
        this.f14429m = i;
        m20802g(this);
    }

    public int getRepeatDelay() {
        return this.f14430n;
    }

    public void setRepeatDelay(int i) {
        this.f14430n = i;
        m20802g(this);
    }

    public int getRepeatMode() {
        return this.f14431o;
    }

    public void setRepeatMode(int i) {
        this.f14431o = i;
        m20802g(this);
    }

    public MaskShape getMaskShape() {
        return this.f14423g.f14444i;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.f14423g.f14444i = maskShape;
        m20802g(this);
    }

    public MaskAngle getAngle() {
        return this.f14423g.f14436a;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.f14423g.f14436a = maskAngle;
        m20802g(this);
    }

    public float getDropoff() {
        return this.f14423g.f14438c;
    }

    public void setDropoff(float f) {
        this.f14423g.f14438c = f;
        m20802g(this);
    }

    public int getFixedWidth() {
        return this.f14423g.f14439d;
    }

    public void setFixedWidth(int i) {
        this.f14423g.f14439d = i;
        m20802g(this);
    }

    public int getFixedHeight() {
        return this.f14423g.f14440e;
    }

    public void setFixedHeight(int i) {
        this.f14423g.f14440e = i;
        m20802g(this);
    }

    public float getIntensity() {
        return this.f14423g.f14441f;
    }

    public void setIntensity(float f) {
        this.f14423g.f14441f = f;
        m20802g(this);
    }

    public float getRelativeWidth() {
        return this.f14423g.f14442g;
    }

    public void setRelativeWidth(int i) {
        this.f14423g.f14442g = (float) i;
        m20802g(this);
    }

    public float getRelativeHeight() {
        return this.f14423g.f14443h;
    }

    public void setRelativeHeight(int i) {
        this.f14423g.f14443h = (float) i;
        m20802g(this);
    }

    public float getTilt() {
        return this.f14423g.f14437b;
    }

    public void setTilt(float f) {
        this.f14423g.f14437b = f;
        m20802g(this);
    }

    public final void m20805b() {
        if (!this.f14434r) {
            getShimmerAnimation().start();
            this.f14434r = true;
        }
    }

    public final void m20806c() {
        if (this.f14418a != null) {
            this.f14418a.end();
            this.f14418a.removeAllUpdateListeners();
            this.f14418a.cancel();
        }
        this.f14418a = null;
        this.f14434r = false;
    }

    public static void setMaskOffsetX(ShimmerFrameLayout shimmerFrameLayout, int i) {
        if (shimmerFrameLayout.f14432p != i) {
            shimmerFrameLayout.f14432p = i;
            shimmerFrameLayout.invalidate();
        }
    }

    public static void setMaskOffsetY(ShimmerFrameLayout shimmerFrameLayout, int i) {
        if (shimmerFrameLayout.f14433q != i) {
            shimmerFrameLayout.f14433q = i;
            shimmerFrameLayout.invalidate();
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2104533141);
        super.onAttachedToWindow();
        if (this.f14435s == null) {
            this.f14435s = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f14435s);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1894470618, a);
    }

    private OnGlobalLayoutListener getLayoutListener() {
        return new C06091(this);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1079131040);
        m20806c();
        if (this.f14435s != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.f14435s);
            this.f14435s = null;
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 287128637, a);
    }

    protected void dispatchDraw(Canvas canvas) {
        if (!this.f14434r || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            m20791a(canvas);
        }
    }

    private static float m20787a(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean m20791a(Canvas canvas) {
        Bitmap d = m20798d();
        Bitmap e = m20800e();
        if (d == null || e == null) {
            return false;
        }
        m20793b(new Canvas(d));
        canvas.drawBitmap(d, 0.0f, 0.0f, this.f14421e);
        m20796c(new Canvas(e));
        canvas.drawBitmap(e, 0.0f, 0.0f, null);
        return true;
    }

    private Bitmap m20798d() {
        if (this.f14426j == null) {
            this.f14426j = m20801f();
        }
        return this.f14426j;
    }

    private Bitmap m20800e() {
        if (this.f14425i == null) {
            this.f14425i = m20801f();
        }
        return this.f14425i;
    }

    private Bitmap m20801f() {
        int width = getWidth();
        int height = getHeight();
        try {
            return m20788a(width, height);
        } catch (OutOfMemoryError e) {
            String str = "ShimmerFrameLayout failed to create working bitmap";
            this.f14420d.m2340a("ShimmerFrameLayout_frame_layout_oom", str);
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append(" (width = ");
            stringBuilder.append(width);
            stringBuilder.append(", height = ");
            stringBuilder.append(height);
            stringBuilder.append(")\n\n");
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                stringBuilder.append(stackTraceElement.toString());
                stringBuilder.append("\n");
            }
            return null;
        }
    }

    private void m20793b(Canvas canvas) {
        canvas.drawColor(0, Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    private void m20796c(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap != null) {
            canvas.clipRect(this.f14432p, this.f14433q, this.f14432p + maskBitmap.getWidth(), this.f14433q + maskBitmap.getHeight());
            canvas.drawColor(0, Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, (float) this.f14432p, (float) this.f14433q, this.f14422f);
        }
    }

    public static void m20802g(ShimmerFrameLayout shimmerFrameLayout) {
        shimmerFrameLayout.m20806c();
        shimmerFrameLayout.m20803h();
        shimmerFrameLayout.m20804i();
    }

    private void m20803h() {
        if (this.f14419b != null) {
            this.f14419b.recycle();
            this.f14419b = null;
        }
    }

    private void m20804i() {
        if (this.f14426j != null) {
            this.f14426j.recycle();
            this.f14426j = null;
        }
        if (this.f14425i != null) {
            this.f14425i.recycle();
            this.f14425i = null;
        }
    }

    private Bitmap getMaskBitmap() {
        if (this.f14419b != null) {
            return this.f14419b;
        }
        Shader radialGradient;
        int a = this.f14423g.m20807a(getWidth());
        int b = this.f14423g.m20809b(getHeight());
        this.f14419b = m20788a(a, b);
        Canvas canvas = new Canvas(this.f14419b);
        switch (3.a[this.f14423g.f14444i.ordinal()]) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                radialGradient = new RadialGradient((float) (a / 2), (float) (b / 2), (float) (((double) Math.max(a, b)) / Math.sqrt(2.0d)), this.f14423g.m20808a(), this.f14423g.m20810b(), TileMode.REPEAT);
                break;
            default:
                int i;
                int i2;
                int i3;
                int i4;
                switch (3.b[this.f14423g.f14436a.ordinal()]) {
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        i = b;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case 3:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = a;
                        break;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
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
                radialGradient = new LinearGradient((float) i4, (float) i3, (float) i2, (float) i, this.f14423g.m20808a(), this.f14423g.m20810b(), TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.f14423g.f14437b, (float) (a / 2), (float) (b / 2));
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * ((double) Math.max(a, b)))) / 2;
        float f = (float) (sqrt + b);
        canvas.drawRect((float) (-sqrt), (float) (-sqrt), (float) (a + sqrt), f, paint);
        return this.f14419b;
    }

    private Animator getShimmerAnimation() {
        if (this.f14418a != null) {
            return this.f14418a;
        }
        int width = getWidth();
        int height = getHeight();
        int[] iArr = 3.a;
        this.f14423g.f14444i.ordinal();
        switch (3.b[this.f14423g.f14436a.ordinal()]) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f14424h.m20811a(0, -height, 0, height);
                break;
            case 3:
                this.f14424h.m20811a(width, 0, -width, 0);
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                this.f14424h.m20811a(0, height, 0, -height);
                break;
            default:
                this.f14424h.m20811a(-width, 0, width, 0);
                break;
        }
        this.f14418a = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f + (((float) this.f14430n) / ((float) this.f14428l))});
        this.f14418a.setDuration((long) (this.f14428l + this.f14430n));
        this.f14418a.setRepeatCount(this.f14429m);
        this.f14418a.setRepeatMode(this.f14431o);
        this.f14418a.addUpdateListener(new 2(this));
        return this.f14418a;
    }

    private static Bitmap m20788a(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
    }
}
