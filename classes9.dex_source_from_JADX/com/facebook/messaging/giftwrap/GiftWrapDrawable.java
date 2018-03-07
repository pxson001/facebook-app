package com.facebook.messaging.giftwrap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.util.MathUtil;
import javax.annotation.Nullable;

/* compiled from: mSendPaymentBarCodeDetails */
public class GiftWrapDrawable extends Drawable {
    public final Resources f11107a;
    public final Paint f11108b = new Paint();
    public final Paint f11109c = new Paint();
    private final Bitmap f11110d;
    private final Rect f11111e = new Rect();
    private final Rect f11112f = new Rect();
    private final Matrix f11113g = new Matrix();
    @Nullable
    public String f11114h;
    @Nullable
    public Paint f11115i;
    @Nullable
    public Matrix f11116j;
    public int f11117k = -1;
    public float f11118l = 1.0f;
    public Shader f11119m;

    public GiftWrapDrawable(Resources resources) {
        this.f11107a = resources;
        this.f11110d = ((BitmapDrawable) resources.getDrawable(2130841322)).getBitmap();
        this.f11113g.setValues(new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
    }

    public final void m11498a(float f) {
        if (this.f11118l != f) {
            this.f11118l = f;
            m11494b();
            m11495c();
        }
    }

    protected void onBoundsChange(Rect rect) {
        m11494b();
    }

    private void m11494b() {
        Rect bounds = getBounds();
        int width = this.f11110d.getWidth();
        float a = m11493a(0.0f, 0.2f);
        int width2 = (bounds.width() - width) / 2;
        this.f11111e.set(width2, (int) ((a * a) * ((float) bounds.height())), width2 + width, bounds.height());
        a = m11493a(0.25f, 0.5f);
        width2 = (bounds.height() - width) / 2;
        this.f11112f.set(width2, 0, width + width2, (int) (((float) bounds.width()) * (1.0f - (a * a))));
        invalidateSelf();
    }

    private void m11495c() {
        if (this.f11116j != null) {
            float d = m11496d();
            this.f11116j.reset();
            this.f11116j.postTranslate(0.0f, (d * ((float) getBounds().height())) * 1.25f);
            this.f11119m.setLocalMatrix(this.f11116j);
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        float e = m11497e();
        canvas.drawRect(0.0f, e * ((float) canvas.getHeight()), (float) canvas.getWidth(), (float) canvas.getHeight(), this.f11108b);
        if (this.f11115i != null) {
            canvas.drawRect(0.0f, e * ((float) canvas.getHeight()), (float) canvas.getWidth(), (float) canvas.getHeight(), this.f11115i);
        }
        canvas.save();
        canvas.concat(this.f11113g);
        canvas.drawBitmap(this.f11110d, null, this.f11112f, this.f11109c);
        canvas.restore();
        canvas.drawBitmap(this.f11110d, null, this.f11111e, this.f11109c);
    }

    private float m11493a(float f, float f2) {
        return MathUtil.c(this.f11118l, f, f2);
    }

    private float m11496d() {
        float a = m11493a(0.4f, 1.0f);
        return a * (a * a);
    }

    private float m11497e() {
        return Math.max((m11496d() * 1.25f) - 0.25f, 0.0f);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
