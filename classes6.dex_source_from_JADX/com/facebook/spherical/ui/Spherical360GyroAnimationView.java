package com.facebook.spherical.ui;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.common.util.SizeUtil;
import com.google.common.base.Objects;

/* compiled from: entrypoints_for_flowing */
public class Spherical360GyroAnimationView extends View {
    private final int f16294a;
    private final int f16295b;
    private final int f16296c;
    private final int f16297d;
    private final int f16298e;
    private final int f16299f;
    private final int f16300g;
    private final int f16301h;
    public ObjectAnimator f16302i;
    private Paint f16303j;
    private RectF f16304k;
    private int f16305l;
    private int f16306m;
    private int f16307n;
    private int f16308o;
    private float f16309p;
    private float f16310q;
    private float f16311r;

    private void m23823a() {
        if (19 == VERSION.SDK_INT) {
            for (Object equal : SphericalIndicator360View.a) {
                if (Objects.equal(equal, Build.MODEL)) {
                    setLayerType(1, null);
                    return;
                }
            }
        }
    }

    public Spherical360GyroAnimationView(Context context) {
        this(context, null);
    }

    public Spherical360GyroAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Spherical360GyroAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16294a = 3;
        this.f16295b = 8;
        this.f16296c = 4;
        this.f16297d = 51;
        this.f16298e = 28;
        this.f16299f = 3;
        this.f16300g = 15;
        this.f16301h = 13;
        m23824b();
    }

    private void m23824b() {
        this.f16306m = m23822a(28.0f);
        this.f16307n = m23822a(3.0f);
        this.f16308o = m23822a(15.0f);
        this.f16305l = 0;
        this.f16303j = new Paint();
        this.f16304k = new RectF();
        m23823a();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("offset", new float[]{(float) this.f16305l, 100.0f});
        this.f16302i = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat});
    }

    public final void m23825a(long j, int i) {
        this.f16302i.setDuration(j);
        this.f16302i.setRepeatMode(1);
        this.f16302i.setRepeatCount(i);
    }

    public ObjectAnimator getAnimator() {
        return this.f16302i;
    }

    private int m23822a(float f) {
        return SizeUtil.a(getContext(), f);
    }

    public void setOffset(float f) {
        float f2 = (float) (((4.537855971961473d * ((double) f)) / 100.0d) + 0.8726646259971648d);
        float sqrt = (float) (0.75d / Math.sqrt(0.5625d + ((1.0d * Math.tan((double) f2)) * Math.tan((double) f2))));
        if (((double) f2) % 6.283185307179586d > 1.5707963267948966d && ((double) f2) % 6.283185307179586d < 4.71238898038469d) {
            sqrt = -sqrt;
        }
        this.f16305l = (int) (sqrt * ((float) this.f16306m));
        this.f16311r = (float) ((-this.f16305l) / 2);
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        this.f16309p = (float) (size / 2);
        this.f16310q = (float) (size2 / 2);
        super.onMeasure(i, i2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        this.f16303j.setStyle(Style.FILL);
        this.f16303j.setColor(-16777216);
        this.f16303j.setAlpha(127);
        this.f16304k.set((this.f16309p - ((float) this.f16306m)) - ((float) this.f16307n), (this.f16310q - ((float) this.f16306m)) - ((float) this.f16307n), (this.f16309p + ((float) this.f16306m)) + ((float) this.f16307n), (this.f16310q + ((float) this.f16306m)) + ((float) this.f16307n));
        canvas.drawOval(this.f16304k, this.f16303j);
        float min = Math.min(this.f16309p - ((float) this.f16305l), this.f16309p + ((float) this.f16305l));
        float max = Math.max(this.f16309p - ((float) this.f16305l), this.f16309p + ((float) this.f16305l));
        this.f16303j.setStrokeWidth(4.0f);
        this.f16303j.setStyle(Style.STROKE);
        this.f16303j.setColor(ContextCompat.b(getContext(), 2131362618));
        this.f16303j.setAlpha(150);
        this.f16304k.set(min, this.f16310q - ((float) this.f16306m), max, this.f16310q + ((float) this.f16306m));
        canvas.drawOval(this.f16304k, this.f16303j);
        canvas.rotate(3.0f, this.f16309p, this.f16310q);
        this.f16303j.setStyle(Style.FILL);
        this.f16303j.setColor(-1);
        this.f16303j.setAlpha(51);
        this.f16304k.set(this.f16309p - ((float) this.f16306m), (this.f16310q - ((float) this.f16308o)) - (this.f16311r / 6.0f), this.f16309p + ((float) this.f16306m), (this.f16310q + ((float) this.f16308o)) + (this.f16311r / 6.0f));
        canvas.drawOval(this.f16304k, this.f16303j);
        this.f16303j.setAlpha(255);
        this.f16303j.setColor(ContextCompat.b(getContext(), 2131362618));
        this.f16303j.setStyle(Style.STROKE);
        canvas.drawOval(this.f16304k, this.f16303j);
        canvas.rotate(-3.0f, this.f16309p, this.f16310q);
        this.f16304k.set(min, this.f16310q - ((float) this.f16306m), max, this.f16310q + ((float) this.f16306m));
        canvas.drawArc(this.f16304k, this.f16305l > 0 ? 90.0f : -90.0f, 360.0f, false, this.f16303j);
        this.f16303j.setStyle(Style.STROKE);
        this.f16303j.setColor(ContextCompat.b(getContext(), 2131362619));
        this.f16303j.setStrokeWidth(8.0f);
        this.f16304k.set(this.f16309p - ((float) this.f16306m), this.f16310q - ((float) this.f16306m), this.f16309p + ((float) this.f16306m), this.f16310q + ((float) this.f16306m));
        canvas.drawOval(this.f16304k, this.f16303j);
        if (this.f16305l >= 0) {
            this.f16304k.set(min, this.f16310q - ((float) this.f16306m), max, this.f16310q + ((float) this.f16306m));
            canvas.clipRect(this.f16304k);
            this.f16303j.setTextSize((float) m23822a(13.0f));
            this.f16303j.setColor(-1);
            this.f16303j.setStyle(Style.FILL);
            this.f16303j.setTextAlign(Align.CENTER);
            canvas.drawText(getResources().getString(2131232748), this.f16309p, this.f16310q + ((float) m23822a(4.0f)), this.f16303j);
            canvas.restore();
        }
    }
}
