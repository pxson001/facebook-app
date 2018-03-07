package com.facebook.spherical.ui;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: pic_url */
public class SphericalIndicator360View extends View {
    public static String[] f4761a = new String[]{"SAMSUNG-SGH-I747", "GT-I9300", "GT-I9305", "GT-I9305T", "SGH-T999", "SGH-T999V", "SGH-T999L", "SPH-L710", "SCH-I535", "SCH-R530U", "SGH-I747M", "GT-I9300T", "SGH-I747", "SHV-E210S", "SHV-E210K", "SCH-R530M", "SAMSUNG-SGH-I337", "SGH-I337M", "GT-I9500", "GT-I9505", "GT-I9505G", "SCH-I545", "SGH-M919", "SPH-L720", "SAMSUNG-SGH-I537"};
    private Drawable f4762b;
    private Paint f4763c;
    public ObjectAnimator f4764d;
    private Path f4765e;
    private float f4766f;
    private float f4767g;
    private float f4768h;

    public SphericalIndicator360View(Context context) {
        this(context, null);
    }

    public SphericalIndicator360View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SphericalIndicator360View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5215a();
    }

    private void m5215a() {
        if (!isInEditMode()) {
            m5216b();
            m5218d();
            m5219e();
            m5220f();
            m5217c();
            invalidate();
        }
    }

    private void m5216b() {
        if (19 == VERSION.SDK_INT) {
            for (String equals : f4761a) {
                if (equals.equals(Build.MODEL)) {
                    setLayerType(1, null);
                    return;
                }
            }
        }
    }

    private void m5217c() {
        this.f4765e = new Path();
    }

    private void m5218d() {
        this.f4767g = (float) getResources().getDimensionPixelSize(2131428264);
        this.f4768h = (float) getResources().getDimensionPixelSize(2131428265);
        this.f4762b = getResources().getDrawable(2130843431);
        if (this.f4762b == null) {
            throw new IllegalStateException("Invalid drawable id: " + 2130843431);
        }
        this.f4762b.setBounds(0, 0, this.f4762b.getIntrinsicWidth(), this.f4762b.getIntrinsicHeight());
    }

    private void m5219e() {
        this.f4763c = new Paint();
        this.f4763c.setStyle(Style.STROKE);
        this.f4763c.setColor(-1);
        this.f4763c.setStrokeWidth((float) getResources().getDimensionPixelSize(2131428263));
        this.f4763c.setAntiAlias(true);
    }

    private void m5220f() {
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(2131428266);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("backgroundOffsetX", new float[]{this.f4767g, dimensionPixelSize});
        this.f4764d = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat});
        this.f4764d.setDuration(2000);
        this.f4764d.setRepeatMode(2);
        this.f4764d.setRepeatCount(3);
    }

    public ObjectAnimator getAnimator() {
        return this.f4764d;
    }

    public void setBackgroundOffsetX(float f) {
        this.f4766f = f;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            super.onDraw(canvas);
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131428262);
        if (this.f4765e.isEmpty()) {
            this.f4765e.addCircle((float) (canvas.getWidth() / 2), (float) (canvas.getHeight() / 2), (float) dimensionPixelSize, Direction.CCW);
            this.f4765e.close();
        }
        canvas.save();
        canvas.clipPath(this.f4765e);
        canvas.translate(this.f4766f, this.f4768h);
        this.f4762b.draw(canvas);
        canvas.restore();
        canvas.drawCircle((float) (canvas.getWidth() / 2), (float) (canvas.getHeight() / 2), (float) dimensionPixelSize, this.f4763c);
    }
}
