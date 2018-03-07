package com.facebook.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.debug.log.BLog;
import com.facebook.widget.RoundedDrawSizeParams.ScaleType;
import com.facebook.widget.RoundedFrameLayout.C05261;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

@Deprecated
/* compiled from: com.google.android.gms.common.internal.ClientSettings.sessionId */
public class RoundedDrawHelper {
    private static final Class<?> f5716a = RoundedDrawHelper.class;
    public final RoundedDrawParams f5717b;
    public final RoundedDrawSizeParams f5718c;
    public final RectF f5719d;
    private final Paint f5720e;
    public Paint f5721f;
    private ColorFilter f5722g;
    private Paint f5723h;
    private int f5724i = 255;
    public Matrix f5725j = new Matrix();
    public Bitmap f5726k;
    private Path f5727l;
    private RectF f5728m;
    public Canvas f5729n;
    public WeakReference<Bitmap> f5730o;
    public BitmapShader f5731p;
    public Matrix f5732q;
    private Paint f5733r;

    /* compiled from: com.google.android.gms.common.internal.ClientSettings.sessionId */
    public /* synthetic */ class C05251 {
        public static final /* synthetic */ int[] f5715a = new int[ScaleType.values().length];

        static {
            try {
                f5715a[ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5715a[ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public RoundedDrawHelper(RoundedDrawParams roundedDrawParams, RoundedDrawSizeParams roundedDrawSizeParams) {
        this.f5717b = roundedDrawParams;
        this.f5718c = roundedDrawSizeParams;
        this.f5719d = new RectF((float) roundedDrawSizeParams.f5754c, (float) roundedDrawSizeParams.f5755d, (float) (roundedDrawSizeParams.f5752a - roundedDrawSizeParams.f5756e), (float) (roundedDrawSizeParams.f5753b - roundedDrawSizeParams.f5757f));
        this.f5720e = m10517h();
        this.f5721f = m10518i();
    }

    public final void m10523a(ColorFilter colorFilter) {
        this.f5722g = colorFilter;
        this.f5733r = null;
    }

    public final void m10520a(int i) {
        this.f5723h = new Paint(1);
        this.f5723h.setColor(i);
        this.f5723h.setAlpha(this.f5724i);
    }

    public final void m10524b(int i) {
        this.f5724i = i;
        if (this.f5723h != null) {
            this.f5723h.setAlpha(i);
        }
    }

    public final void m10525c(int i) {
        this.f5717b.f5751i = i;
        this.f5721f = m10518i();
    }

    public final void m10522a(Canvas canvas, C05261 c05261) {
        if (!m10511d()) {
            c05261.m10529a(canvas);
        } else if (m10513e()) {
            m10509b(canvas, c05261);
        } else {
            Bitmap b = m10507b();
            if (b == null) {
                m10509b(canvas, c05261);
                return;
            }
            Canvas canvas2;
            if (b != this.f5726k || this.f5729n == null) {
                this.f5729n = new Canvas(b);
                canvas2 = this.f5729n;
            } else {
                canvas2 = this.f5729n;
            }
            Canvas canvas3 = canvas2;
            canvas3.drawColor(0, Mode.CLEAR);
            c05261.m10529a(canvas3);
            m10521a(canvas, b);
        }
    }

    public final void m10521a(Canvas canvas, Bitmap bitmap) {
        Object obj;
        Path e = m10512e(bitmap);
        if (bitmap != null) {
            Paint b = m10508b(bitmap);
            e.setFillType(FillType.WINDING);
            canvas.drawPath(e, b);
        }
        if (this.f5723h != null) {
            canvas.drawPath(e, this.f5723h);
        }
        if (!this.f5717b.f5743a || this.f5717b.f5751i == 0 || this.f5717b.f5750h <= 0.0f || this.f5721f == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            canvas.drawCircle(this.f5728m.centerX(), this.f5728m.centerY(), ((this.f5728m.width() - this.f5717b.f5750h) + 1.0f) / 2.0f, this.f5721f);
        }
        this.f5730o = new WeakReference(bitmap);
    }

    public final void m10519a() {
        if (this.f5726k != null) {
            this.f5726k.recycle();
            this.f5726k = null;
        }
        this.f5727l = null;
        this.f5728m = null;
        this.f5729n = null;
        this.f5730o = null;
        this.f5731p = null;
        this.f5732q = null;
        this.f5733r = null;
    }

    private void m10509b(Canvas canvas, C05261 c05261) {
        c05261.m10529a(canvas);
        Path e = m10512e(null);
        if (this.f5723h != null) {
            e.setFillType(FillType.WINDING);
            canvas.drawPath(e, this.f5723h);
        }
        e.setFillType(FillType.INVERSE_WINDING);
        canvas.drawPath(e, this.f5720e);
    }

    @Nullable
    private Bitmap m10507b() {
        boolean z = true;
        if (this.f5726k != null) {
            Preconditions.checkArgument(this.f5726k.getWidth() == this.f5718c.f5752a);
            if (this.f5726k.getHeight() != this.f5718c.f5753b) {
                z = false;
            }
            Preconditions.checkArgument(z);
            return this.f5726k;
        }
        try {
            this.f5726k = m10510c();
            return this.f5726k;
        } catch (Throwable e) {
            BLog.b(f5716a, e, "RoundedBitmapHelper failed to create working bitmap (width = %d, height = %d)", new Object[]{Integer.valueOf(this.f5718c.f5752a), Integer.valueOf(this.f5718c.f5753b)});
            return null;
        }
    }

    @Nullable
    private Bitmap m10510c() {
        try {
            return Bitmap.createBitmap(this.f5718c.f5752a, this.f5718c.f5753b, Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(this.f5718c.f5752a, this.f5718c.f5753b, Config.ARGB_8888);
        }
    }

    private boolean m10511d() {
        return this.f5717b.f5743a || ((this.f5717b.f5744b || this.f5717b.f5745c || this.f5717b.f5746d || this.f5717b.f5747e) && Float.compare(this.f5717b.f5748f, 0.0f) > 0);
    }

    private boolean m10513e() {
        return this.f5717b.f5749g != 0;
    }

    private int m10515g() {
        if (m10513e()) {
            return this.f5717b.f5749g;
        }
        return -16777216;
    }

    private Paint m10517h() {
        Paint paint = new Paint(1);
        paint.setColor(m10515g());
        return paint;
    }

    private Paint m10518i() {
        Paint paint = new Paint(1);
        paint.setColor(this.f5717b.f5751i);
        paint.setStrokeWidth(this.f5717b.f5750h);
        paint.setStyle(Style.STROKE);
        return paint;
    }

    private Paint m10508b(Bitmap bitmap) {
        Shader shader;
        Matrix matrix;
        if (this.f5733r == null) {
            this.f5733r = new Paint();
        } else if (this.f5730o != null && this.f5730o.get() == bitmap) {
            return this.f5733r;
        } else {
            this.f5733r.reset();
        }
        if (this.f5730o == null || this.f5730o.get() != bitmap || this.f5731p == null) {
            this.f5731p = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
            shader = this.f5731p;
        } else {
            shader = this.f5731p;
        }
        Shader shader2 = shader;
        if (this.f5730o == null || this.f5730o.get() != bitmap || this.f5732q == null) {
            if (this.f5732q != null) {
                this.f5732q.reset();
            } else if (this.f5718c.f5758g != ScaleType.MATRIX || this.f5725j == null) {
                this.f5732q = new Matrix();
            } else {
                this.f5732q = this.f5725j;
            }
            matrix = this.f5732q;
            float width = this.f5719d.width();
            float height = this.f5719d.height();
            float a = m10506a(bitmap, width, height, this.f5718c.f5758g);
            switch (C05251.f5715a[this.f5718c.f5758g.ordinal()]) {
                case 1:
                    matrix.postTranslate((width - (((float) bitmap.getWidth()) * a)) / 2.0f, (height - (((float) bitmap.getHeight()) * a)) / 2.0f);
                    matrix.postScale(a, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    matrix.preScale(a, a);
                    matrix.postTranslate((width - (((float) bitmap.getWidth()) * a)) / 2.0f, (height - (a * ((float) bitmap.getHeight()))) / 2.0f);
                    break;
                default:
                    break;
            }
        }
        matrix = this.f5732q;
        shader2.setLocalMatrix(matrix);
        Paint paint = this.f5733r;
        paint.setAntiAlias(true);
        paint.setShader(shader2);
        paint.setColorFilter(this.f5722g);
        return paint;
    }

    public static float m10506a(Bitmap bitmap, float f, float f2, ScaleType scaleType) {
        float width = f / ((float) bitmap.getWidth());
        float height = f2 / ((float) bitmap.getHeight());
        switch (C05251.f5715a[scaleType.ordinal()]) {
            case 1:
                return Math.min(1.0f, Math.min(width, height));
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return Math.max(width, height);
            default:
                return 1.0f;
        }
    }

    private Path m10512e(@Nullable Bitmap bitmap) {
        if (this.f5727l == null) {
            this.f5727l = new Path();
        } else {
            this.f5727l.reset();
        }
        Path path = this.f5727l;
        RectF f = m10514f(bitmap);
        if (!m10516g(bitmap)) {
            path.addRect(f, Direction.CW);
        } else if (this.f5717b.f5743a) {
            path.addOval(f, Direction.CW);
        } else {
            float f2 = f.left;
            float f3 = f.right;
            float f4 = f.top;
            float f5 = f.bottom;
            path.addRoundRect(f, this.f5717b.f5748f, this.f5717b.f5748f, Direction.CW);
            float f6 = this.f5717b.f5748f * 2.0f;
            if (!this.f5717b.f5744b) {
                path.addRect(f2, f4, f2 + f6, f4 + f6, Direction.CW);
            }
            if (!this.f5717b.f5745c) {
                path.addRect(f3 - f6, f4, f3, f4 + f6, Direction.CW);
            }
            if (!this.f5717b.f5746d) {
                path.addRect(f2, f5 - f6, f2 + f6, f5, Direction.CW);
            }
            if (!this.f5717b.f5747e) {
                path.addRect(f3 - f6, f5 - f6, f3, f5, Direction.CW);
            }
        }
        return path;
    }

    private RectF m10514f(@Nullable Bitmap bitmap) {
        if (this.f5728m == null) {
            this.f5728m = new RectF(this.f5719d);
        } else {
            this.f5728m.set(this.f5719d);
        }
        RectF rectF = this.f5728m;
        if (bitmap != null && this.f5718c.f5758g == ScaleType.CENTER) {
            float a = m10506a(bitmap, rectF.width(), rectF.height(), this.f5718c.f5758g);
            if (((float) bitmap.getWidth()) < rectF.width()) {
                rectF.inset((rectF.width() - (((float) bitmap.getWidth()) * a)) / 2.0f, 0.0f);
            }
            if (((float) bitmap.getHeight()) < rectF.height()) {
                rectF.inset(0.0f, (rectF.height() - (a * ((float) bitmap.getHeight()))) / 2.0f);
            }
        }
        return rectF;
    }

    private boolean m10516g(@Nullable Bitmap bitmap) {
        if (!m10511d()) {
            return false;
        }
        if (bitmap == null || this.f5718c.f5758g != ScaleType.CENTER) {
            return true;
        }
        if (((float) bitmap.getWidth()) < this.f5719d.width() || ((float) bitmap.getHeight()) < this.f5719d.height()) {
            return true;
        }
        return false;
    }
}
