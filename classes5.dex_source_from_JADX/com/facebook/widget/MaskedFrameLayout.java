package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.R;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: com.google.android.gms.maps.SupportMapFragment */
public class MaskedFrameLayout extends FrameLayout {
    private static final Class<?> f5665a = MaskedFrameLayout.class;
    private static final PorterDuffXfermode f5666b = new PorterDuffXfermode(Mode.DST_IN);
    private Drawable f5667c;
    private Bitmap f5668d;
    private Bitmap f5669e;
    private Paint f5670f;
    private boolean f5671g;
    private AbstractFbErrorReporter f5672h;

    public MaskedFrameLayout(Context context) {
        super(context);
        m10455a(context, null, 0);
    }

    public MaskedFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10455a(context, attributeSet, 0);
    }

    public MaskedFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10455a(context, attributeSet, i);
    }

    private final void m10455a(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        this.f5672h = (AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(context));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaskedFrameLayout, i, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                setMaskDrawable(drawable);
            }
            z = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
        } else {
            z = false;
        }
        setUsesFboToMask(z);
        this.f5670f = new Paint();
        this.f5670f.setXfermode(f5666b);
        this.f5670f.setAntiAlias(true);
        this.f5670f.setDither(true);
        this.f5670f.setFilterBitmap(true);
    }

    public void setMaskDrawable(Drawable drawable) {
        this.f5667c = drawable;
        m10454a();
        invalidate();
    }

    public void setUsesFboToMask(boolean z) {
        this.f5671g = z;
        if (this.f5671g) {
            m10457b();
        }
        invalidate();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1471508068);
        super.onSizeChanged(i, i2, i3, i4);
        m10454a();
        m10457b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1084179247, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1353673348);
        m10454a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2115237119, a);
    }

    private void m10454a() {
        if (this.f5668d != null) {
            this.f5668d.recycle();
            this.f5668d = null;
        }
    }

    private void m10457b() {
        if (this.f5669e != null) {
            this.f5669e.recycle();
            this.f5669e = null;
        }
    }

    private Bitmap getMaskBitmap() {
        if (this.f5668d != null) {
            return this.f5668d;
        }
        int width = getWidth();
        int height = getHeight();
        this.f5668d = m10453a(width, height);
        Canvas canvas = new Canvas(this.f5668d);
        this.f5667c.setBounds(0, 0, width, height);
        this.f5667c.draw(canvas);
        return this.f5668d;
    }

    protected void dispatchDraw(Canvas canvas) {
        boolean z = false;
        if (this.f5667c == null) {
            super.dispatchDraw(canvas);
            z = true;
        } else if (!this.f5671g) {
            z = m10458b(canvas);
        }
        if (!z) {
            m10456a(canvas);
        }
    }

    private void m10456a(Canvas canvas) {
        canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
        m10460c(canvas);
        canvas.restore();
    }

    private boolean m10458b(Canvas canvas) {
        Bitmap c = m10459c();
        if (c == null) {
            return false;
        }
        Canvas canvas2 = new Canvas(c);
        canvas2.drawColor(0, Mode.CLEAR);
        m10460c(canvas2);
        canvas.drawBitmap(c, 0.0f, 0.0f, null);
        return true;
    }

    private Bitmap m10459c() {
        if (this.f5669e == null) {
            int width = getWidth();
            int height = getHeight();
            try {
                this.f5669e = m10453a(width, height);
            } catch (OutOfMemoryError e) {
                String str = "MaskedFrameLayout failed to create working bitmap";
                this.f5672h.a("T2335831:masked_frame_layout_oom", str);
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
            }
        }
        return this.f5669e;
    }

    private void m10460c(Canvas canvas) {
        super.dispatchDraw(canvas);
        Paint maskDrawablePaint = getMaskDrawablePaint();
        if (maskDrawablePaint != null) {
            Xfermode xfermode = maskDrawablePaint.getXfermode();
            maskDrawablePaint.setXfermode(f5666b);
            this.f5667c.setBounds(0, 0, getWidth(), getHeight());
            this.f5667c.draw(canvas);
            maskDrawablePaint.setXfermode(xfermode);
            return;
        }
        canvas.drawBitmap(getMaskBitmap(), 0.0f, 0.0f, this.f5670f);
    }

    private Paint getMaskDrawablePaint() {
        if (this.f5667c instanceof BitmapDrawable) {
            return ((BitmapDrawable) this.f5667c).getPaint();
        }
        if (this.f5667c instanceof NinePatchDrawable) {
            return ((NinePatchDrawable) this.f5667c).getPaint();
        }
        if (this.f5667c instanceof ShapeDrawable) {
            return ((ShapeDrawable) this.f5667c).getPaint();
        }
        return null;
    }

    private static Bitmap m10453a(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
    }
}
