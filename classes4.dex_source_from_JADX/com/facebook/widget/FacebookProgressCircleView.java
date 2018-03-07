package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.facebook.R;

/* compiled from: pos */
public class FacebookProgressCircleView extends View {
    private static int f4396b = 30;
    private static int f4397c = 4;
    private static int f4398d = 127;
    private static int f4399e = 255;
    protected double f4400a = 0.0d;
    private Paint f4401f;
    private RectF f4402g;
    private int f4403h;
    private int f4404i;
    private int f4405j;
    private int f4406k;
    private int f4407l;
    private int f4408m;
    private int f4409n;
    private boolean f4410o;
    private LinearGradient f4411p;

    public FacebookProgressCircleView(Context context) {
        super(context);
        m4922a(context, null);
    }

    public FacebookProgressCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4922a(context, attributeSet);
    }

    private final void m4922a(Context context, AttributeSet attributeSet) {
        this.f4406k = getResources().getColor(2131361864);
        this.f4407l = this.f4406k;
        this.f4408m = f4398d;
        this.f4409n = f4399e;
        this.f4410o = false;
        this.f4404i = (int) Math.ceil((double) TypedValue.applyDimension(1, (float) f4396b, getResources().getDisplayMetrics()));
        this.f4405j = (int) Math.ceil((double) TypedValue.applyDimension(1, (float) f4397c, getResources().getDisplayMetrics()));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FacebookProgressCircleView);
            this.f4406k = obtainStyledAttributes.getColor(1, this.f4406k);
            this.f4407l = obtainStyledAttributes.getColor(3, this.f4406k);
            this.f4408m = obtainStyledAttributes.getInt(0, this.f4408m);
            this.f4409n = obtainStyledAttributes.getInt(2, this.f4409n);
            this.f4405j = (int) obtainStyledAttributes.getDimension(5, (float) this.f4405j);
            this.f4404i = (int) obtainStyledAttributes.getDimension(6, (float) this.f4404i);
            this.f4410o = obtainStyledAttributes.getBoolean(4, this.f4410o);
            obtainStyledAttributes.recycle();
        }
        this.f4401f = new Paint();
        this.f4401f.setStyle(Style.STROKE);
        this.f4401f.setAntiAlias(true);
        this.f4401f.setStrokeWidth((float) this.f4405j);
        this.f4401f.setColor(this.f4406k);
        this.f4403h = (int) Math.ceil(((double) this.f4405j) / 2.0d);
        this.f4402g = new RectF((float) this.f4403h, (float) this.f4403h, (float) this.f4404i, (float) this.f4404i);
        m4921a();
    }

    private void m4921a() {
        if (this.f4410o) {
            int i = -16777216 | (this.f4406k & 16777215);
            this.f4411p = new LinearGradient(((float) this.f4404i) / 3.0f, ((float) this.f4404i) / 3.0f, ((float) this.f4404i) / 1.4f, ((float) this.f4404i) / 1.4f, i, (this.f4406k & 16777215) | 0, TileMode.CLAMP);
        }
    }

    public void setProgress(long j) {
        setProgress((double) j);
    }

    public void setProgress(double d) {
        if (d != this.f4400a) {
            this.f4400a = Math.min(100.0d, Math.max(0.0d, d));
            invalidate();
        }
    }

    public double getProgress() {
        return this.f4400a;
    }

    public void setProgressBarColor(int i) {
        this.f4406k = i;
        this.f4407l = i;
        this.f4401f.setColor(this.f4406k);
        m4921a();
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (((float) this.f4400a) * 360.0f) / 100.0f;
        if (this.f4400a > 0.0d) {
            if (this.f4410o) {
                m4923a(canvas, f);
            } else {
                m4924b(canvas, f);
            }
        }
        if (this.f4400a < 100.0d) {
            this.f4401f.setColor(this.f4406k);
            this.f4401f.setAlpha(this.f4408m);
            canvas.drawArc(this.f4402g, 270.0f + f, 360.0f - f, false, this.f4401f);
        }
    }

    private void m4923a(Canvas canvas, float f) {
        this.f4401f.setColor(this.f4406k);
        this.f4401f.setAlpha(255);
        this.f4401f.setShader(this.f4411p);
        canvas.drawArc(this.f4402g, 270.0f, 90.0f, false, this.f4401f);
        this.f4401f.setShader(null);
        if (this.f4400a > 90.0d) {
            this.f4401f.setAlpha(this.f4409n);
            canvas.drawArc(this.f4402g, 0.0f, f - 90.0f, false, this.f4401f);
        }
    }

    private void m4924b(Canvas canvas, float f) {
        this.f4401f.setColor(this.f4407l);
        this.f4401f.setAlpha(this.f4409n);
        canvas.drawArc(this.f4402g, 270.0f, f, false, this.f4401f);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f4404i + (this.f4405j / 2), this.f4404i + (this.f4405j / 2));
    }
}
