package com.facebook.backstage.nub;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/* compiled from: reported */
public class NubView extends ImageView {
    public boolean f5457a;
    public final int f5458b = ((int) getResources().getDimension(2131433204));
    public final int f5459c = ((int) getResources().getDimension(2131433205));
    private Drawable f5460d;
    private Drawable f5461e;
    public DrawingMode f5462f = DrawingMode.CIRCLE;

    /* compiled from: reported */
    public enum DrawingMode {
        CIRCLE,
        ARC_LEFT,
        ARC_RIGHT
    }

    public NubView(Context context) {
        super(context);
        this.f5461e = context.getResources().getDrawable(2130841729);
        this.f5460d = context.getResources().getDrawable(2130839749);
        this.f5460d.setColorFilter(context.getResources().getColor(17170443), Mode.SRC_ATOP);
        setImageDrawable(this.f5460d);
        setScaleType(ScaleType.CENTER);
        int i = this.f5458b;
        int i2 = this.f5459c;
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(i, i2);
        } else if (!(layoutParams.width == i && layoutParams.height == i2)) {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        setLayoutParams(layoutParams);
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        if (this.f5457a) {
            canvas.translate(100000.0f, 0.0f);
        }
        switch (this.f5462f) {
            case CIRCLE:
                m5675a(canvas);
                super.onDraw(canvas);
                break;
            case ARC_LEFT:
                m5676b(canvas);
                break;
            case ARC_RIGHT:
                m5677c(canvas);
                break;
        }
        canvas.restore();
    }

    public final void m5679a(int i, int i2) {
        if (i >= i2 / 2) {
            this.f5462f = DrawingMode.ARC_RIGHT;
        } else {
            this.f5462f = DrawingMode.ARC_LEFT;
        }
    }

    private void m5675a(Canvas canvas) {
        this.f5461e.setBounds(0, 0, this.f5458b, this.f5458b);
        this.f5461e.draw(canvas);
    }

    private void m5676b(Canvas canvas) {
        canvas.translate(-m5678a(), 0.0f);
        m5675a(canvas);
    }

    private void m5677c(Canvas canvas) {
        canvas.translate(m5678a(), 0.0f);
        m5675a(canvas);
    }

    public final float m5678a() {
        return (2.0f * ((float) this.f5458b)) / 3.0f;
    }

    public float getArcWidth() {
        return ((float) this.f5458b) - m5678a();
    }

    public void setXBy(float f) {
        super.setX(getX() + f);
    }

    public void setYBy(float f) {
        super.setY(getY() + f);
    }
}
