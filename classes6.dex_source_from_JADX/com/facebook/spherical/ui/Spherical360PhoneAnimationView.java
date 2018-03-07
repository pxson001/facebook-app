package com.facebook.spherical.ui;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.common.util.SizeUtil;

/* compiled from: entry_point_impression */
public class Spherical360PhoneAnimationView extends View {
    private RectF f16312A;
    private String f16313B;
    private Typeface f16314C;
    private Path f16315D;
    private Path f16316E;
    private Path f16317F;
    private Path f16318G;
    private final int f16319a;
    private final int f16320b;
    private final int f16321c;
    private final int f16322d;
    private final int f16323e;
    private final int f16324f;
    private final int f16325g;
    private final int f16326h;
    private final int f16327i;
    public int f16328j;
    private int f16329k;
    private float f16330l;
    private float f16331m;
    private float f16332n;
    private float f16333o;
    private float f16334p;
    private float f16335q;
    private float f16336r;
    private ObjectAnimator f16337s;
    private Paint f16338t;
    private Paint f16339u;
    private Paint f16340v;
    private CornerPathEffect f16341w;
    private CornerPathEffect f16342x;
    private CornerPathEffect f16343y;
    private CornerPathEffect f16344z;

    public Spherical360PhoneAnimationView(Context context) {
        this(context, null);
    }

    public Spherical360PhoneAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Spherical360PhoneAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16319a = 68;
        this.f16320b = 12;
        this.f16321c = 2;
        this.f16322d = 4;
        this.f16323e = 36;
        this.f16324f = 24;
        this.f16325g = 25;
        this.f16326h = 16;
        this.f16327i = 16;
        this.f16328j = 12;
        m23827a();
    }

    private void m23827a() {
        this.f16333o = (float) m23826a(5.0f);
        this.f16334p = (float) m23826a(4.0f);
        this.f16335q = (float) m23826a(1.0f);
        this.f16336r = (float) m23826a(2.0f);
        this.f16338t = new Paint();
        this.f16339u = new Paint();
        this.f16340v = new Paint();
        this.f16312A = new RectF();
        this.f16329k = m23826a(25.0f);
        this.f16332n = 0.0f;
        this.f16313B = getResources().getString(2131232749);
        this.f16315D = new Path();
        this.f16316E = new Path();
        this.f16317F = new Path();
        this.f16318G = new Path();
        this.f16341w = new CornerPathEffect(this.f16333o);
        this.f16342x = new CornerPathEffect(this.f16334p);
        this.f16343y = new CornerPathEffect(this.f16335q);
        this.f16344z = new CornerPathEffect(this.f16336r);
        this.f16314C = Typeface.create("roboto-medium", 0);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("offset", new float[]{this.f16332n, 100.0f});
        this.f16337s = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat});
    }

    public void setVerticalOffset(int i) {
        this.f16328j = i;
    }

    public int getVerticalOffset() {
        return this.f16328j;
    }

    private int m23826a(float f) {
        return SizeUtil.a(getContext(), f);
    }

    public void setOffset(float f) {
        if (f <= 25.0f) {
            this.f16332n = (f / 25.0f) * ((float) (-this.f16329k));
        } else if (f <= 50.0f) {
            this.f16332n = (((f - 25.0f) / 25.0f) * ((float) this.f16329k)) - ((float) this.f16329k);
        } else if (f <= 75.0f) {
            this.f16332n = ((f - 50.0f) / 25.0f) * ((float) this.f16329k);
        } else {
            this.f16332n = (((f - 75.0f) / 25.0f) * ((float) (-this.f16329k))) + ((float) this.f16329k);
        }
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        this.f16330l = (float) (size / 2);
        this.f16331m = (float) size2;
        super.onMeasure(i, i2);
    }

    public ObjectAnimator getPhoneAnimator() {
        return this.f16337s;
    }

    public final void m23828a(long j, int i) {
        this.f16337s.setDuration(j);
        this.f16337s.setRepeatMode(1);
        this.f16337s.setRepeatCount(i);
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        if (this.f16314C != null) {
            this.f16339u.setTypeface(this.f16314C);
        }
        this.f16339u.setTextSize((float) m23826a(12.0f));
        this.f16339u.setAlpha(255);
        this.f16339u.setColor(-1);
        this.f16339u.setStyle(Style.STROKE);
        this.f16339u.setTextAlign(Align.CENTER);
        this.f16339u.setShadowLayer((float) m23826a(5.0f), (float) m23826a(1.0f), (float) m23826a(1.0f), -16777216);
        canvas.drawText(this.f16313B, this.f16330l, this.f16331m - ((float) m23826a((float) this.f16328j)), this.f16339u);
        int a = m23826a((float) (this.f16328j + 66));
        this.f16340v.setColor(-16777216);
        this.f16340v.setStyle(Style.FILL);
        this.f16340v.setPathEffect(this.f16341w);
        this.f16340v.setAntiAlias(true);
        this.f16340v.setAlpha(68);
        float f = this.f16332n / 10.0f;
        float abs = ((this.f16330l + this.f16332n) + (this.f16332n / 20.0f)) + Math.abs(this.f16332n / 10.0f);
        float a2 = (((this.f16330l + ((float) m23826a(24.0f))) + this.f16332n) + (this.f16332n / 20.0f)) - Math.abs(this.f16332n / 10.0f);
        float f2 = this.f16331m - ((float) a);
        float a3 = (this.f16331m + ((float) m23826a(36.0f))) - ((float) a);
        float f3 = (a2 - abs) / 2.0f;
        abs -= f3;
        a2 -= f3;
        f3 = (float) m23826a(2.0f);
        this.f16315D.rewind();
        this.f16315D.moveTo(abs - f3, (f2 + f) - f3);
        this.f16315D.lineTo(a2 + f3, (f2 - f) - f3);
        this.f16315D.lineTo(a2 + f3, (a3 + f) + f3);
        this.f16315D.lineTo(abs - f3, (a3 - f) + f3);
        this.f16315D.close();
        canvas.drawPath(this.f16315D, this.f16340v);
        this.f16340v.setColor(-1);
        this.f16340v.setStyle(Style.FILL);
        this.f16340v.setPathEffect(this.f16342x);
        this.f16340v.setAntiAlias(true);
        f = this.f16332n / 10.0f;
        abs = ((this.f16330l + this.f16332n) + (this.f16332n / 20.0f)) + Math.abs(this.f16332n / 10.0f);
        a2 = (((this.f16330l + ((float) m23826a(24.0f))) + this.f16332n) + (this.f16332n / 20.0f)) - Math.abs(this.f16332n / 10.0f);
        f2 = this.f16331m - ((float) a);
        a3 = (this.f16331m + ((float) m23826a(36.0f))) - ((float) a);
        f3 = (a2 - abs) / 2.0f;
        abs -= f3;
        a2 -= f3;
        this.f16316E.rewind();
        this.f16316E.moveTo(abs, f2 + f);
        this.f16316E.lineTo(a2, f2 - f);
        this.f16316E.lineTo(a2, a3 + f);
        this.f16316E.lineTo(abs, a3 - f);
        this.f16316E.close();
        canvas.drawPath(this.f16316E, this.f16340v);
        this.f16338t.setStyle(Style.FILL);
        this.f16338t.setColor(ContextCompat.b(getContext(), 2131362622));
        this.f16338t.setAlpha(216);
        this.f16338t.setPathEffect(this.f16343y);
        abs = (0.77f * f) * 0.75f;
        a2 = (0.61f * f) * 0.75f;
        float a4 = (this.f16331m - ((float) a)) + ((float) m23826a(4.0f));
        float a5 = ((this.f16331m + ((float) m23826a(25.0f))) - ((float) a)) + ((float) m23826a(4.0f));
        f2 = ((((this.f16330l + this.f16332n) + (this.f16332n / 20.0f)) + ((float) m23826a(4.0f))) + Math.abs(this.f16332n / 10.0f)) - f3;
        a3 = (((((this.f16330l + ((float) m23826a(16.0f))) + this.f16332n) + (this.f16332n / 20.0f)) + ((float) m23826a(4.0f))) - Math.abs(this.f16332n / 10.0f)) - f3;
        this.f16317F.rewind();
        this.f16317F.moveTo(f2, a4 + abs);
        this.f16317F.lineTo(a3, a4 - abs);
        this.f16317F.lineTo(a3, a5 + a2);
        this.f16317F.lineTo(f2, a5 - a2);
        this.f16317F.close();
        canvas.drawPath(this.f16317F, this.f16338t);
        this.f16338t.setPathEffect(this.f16344z);
        f *= 0.11f;
        abs = (f2 + a3) / 2.0f;
        a5 += (float) (m23826a(7.0f) / 2);
        a2 = this.f16336r;
        f2 = this.f16336r - Math.abs(this.f16332n / 30.0f);
        a3 = abs - f2;
        abs += f2;
        f2 = a5 - a2;
        a5 += a2;
        this.f16318G.rewind();
        this.f16318G.moveTo(a3, f2 + f);
        this.f16318G.lineTo(abs, f2 - f);
        this.f16318G.lineTo(abs, a5 + f);
        this.f16318G.lineTo(a3, a5 - f);
        this.f16318G.close();
        canvas.drawPath(this.f16318G, this.f16338t);
        canvas.restore();
    }
}
