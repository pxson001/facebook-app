package com.facebook.fbui.nux.canvas;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.facebook.R;

/* compiled from: pending_send_message */
public class MobileChromeView extends ViewGroup {
    private Scale f6728a;
    private Paint f6729b;
    private Paint f6730c;
    private Paint f6731d;
    private Path f6732e;
    private Path f6733f;
    private Path f6734g;
    private final Matrix f6735h;
    private final RectF f6736i;
    private final RectF f6737j;

    /* compiled from: pending_send_message */
    public enum Scale {
        FIT,
        TOP,
        CENTER,
        BOTTOM
    }

    public MobileChromeView(Context context) {
        this(context, null);
    }

    public MobileChromeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MobileChromeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6735h = new Matrix();
        this.f6736i = new RectF();
        this.f6737j = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MobileChromeView, i, 0);
        this.f6728a = Scale.values()[obtainStyledAttributes.getInteger(3, 0)];
        int color = obtainStyledAttributes.getColor(0, -15333599);
        int color2 = obtainStyledAttributes.getColor(1, -1);
        int color3 = obtainStyledAttributes.getColor(2, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        this.f6729b = new Paint(1);
        this.f6729b.setStyle(Style.FILL);
        this.f6729b.setColor(color);
        this.f6730c = new Paint(this.f6729b);
        this.f6730c.setColor(color2);
        this.f6731d = new Paint(this.f6729b);
        this.f6731d.setColor(color3);
        this.f6732e = new Path();
        this.f6732e.moveTo(540.75f, 140.5f);
        this.f6732e.rLineTo(0.0f, -70.0f);
        this.f6732e.rCubicTo(0.0f, -75.25f, -92.75f, -63.0f, -264.25f, -66.5f);
        this.f6732e.rLineTo(-3.5f, 0.0f);
        this.f6732e.rCubicTo(-175.0f, 3.5f, -267.75f, -8.75f, -267.75f, 65.5f);
        this.f6732e.rLineTo(0.0f, 140.0f);
        this.f6732e.rLineTo(-5.25f, 0.0f);
        this.f6732e.rLineTo(0.0f, 169.75f);
        this.f6732e.rLineTo(5.25f, 0.0f);
        this.f6732e.rLineTo(0.0f, 621.25f);
        this.f6732e.rCubicTo(0.0f, 68.25f, 99.75f, 68.25f, 122.5f, 68.25f);
        this.f6732e.rLineTo(290.25f, 0.0f);
        this.f6732e.rCubicTo(22.75f, 0.0f, 122.5f, 0.0f, 122.5f, -68.25f);
        this.f6732e.rLineTo(0.0f, -792.75f);
        this.f6732e.rLineTo(5.25f, 0.0f);
        this.f6732e.rLineTo(0.0f, -65.0f);
        this.f6732e.rLineTo(-5.25f, 0.0f);
        this.f6732e.close();
        this.f6733f = new Path();
        this.f6733f.addCircle(262.875f, 50.0f, 10.0f, Direction.CCW);
        this.f6733f.close();
        this.f6734g = new Path();
        this.f6734g.addRect(29.75f, 89.0f, 516.25f, 950.0f, Direction.CCW);
        this.f6734g.close();
    }

    protected void onMeasure(int i, int i2) {
        float f = 0.0f;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f6732e.computeBounds(this.f6736i, true);
        float width = this.f6736i.width();
        float height = this.f6736i.height();
        float f2 = ((float) measuredWidth) / width;
        float f3 = ((float) measuredHeight) / height;
        if (this.f6728a == Scale.FIT) {
            f2 = Math.min(f2, f3);
            this.f6735h.setScale(f2, f2, 0.0f, 0.0f);
            this.f6735h.postTranslate((((float) measuredWidth) - (width * f2)) / 2.0f, (((float) measuredHeight) - (height * f2)) / 2.0f);
        } else {
            this.f6735h.setScale(f2, f2, 0.0f, 0.0f);
            width = (((float) measuredWidth) - (width * f2)) / 2.0f;
            if (this.f6728a != Scale.TOP) {
                if (this.f6728a == Scale.BOTTOM) {
                    f = ((float) measuredHeight) - (height * f2);
                } else {
                    f = (((float) measuredHeight) - (height * f2)) / 2.0f;
                }
            }
            this.f6735h.postTranslate(width, f);
        }
        this.f6732e.transform(this.f6735h);
        this.f6734g.transform(this.f6735h);
        this.f6733f.transform(this.f6735h);
        View onlyChild = getOnlyChild();
        if (onlyChild != null) {
            this.f6734g.computeBounds(this.f6737j, true);
            int height2 = (int) this.f6737j.height();
            onlyChild.measure(MeasureSpec.makeMeasureSpec(Math.min(measuredWidth, (int) this.f6737j.width()), 1073741824), MeasureSpec.makeMeasureSpec(Math.min(measuredHeight, height2), 1073741824));
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View onlyChild = getOnlyChild();
        if (onlyChild != null) {
            onlyChild.layout(Math.max(0, (int) this.f6737j.left), Math.max(0, (int) this.f6737j.top), Math.min(getMeasuredWidth(), (int) this.f6737j.right), Math.min(getMeasuredHeight(), (int) this.f6737j.bottom));
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawPath(this.f6732e, this.f6729b);
        canvas.drawPath(this.f6734g, this.f6731d);
        canvas.drawPath(this.f6733f, this.f6730c);
        canvas.restore();
    }

    public void setScale(Scale scale) {
        if (this.f6728a != scale) {
            this.f6728a = scale;
            invalidate();
            requestLayout();
        }
    }

    public void setChromeColor(int i) {
        this.f6729b.setColor(i);
        invalidate();
    }

    public void setChromeShader(Shader shader) {
        this.f6729b.setShader(shader);
        invalidate();
    }

    public void setScreenColor(int i) {
        this.f6731d.setColor(i);
        invalidate();
    }

    public void setScreenShader(Shader shader) {
        this.f6731d.setShader(shader);
        invalidate();
    }

    public void setCameraColor(int i) {
        this.f6730c.setColor(i);
        invalidate();
    }

    public void setCameraShader(Shader shader) {
        this.f6730c.setShader(shader);
        invalidate();
    }

    private View getOnlyChild() {
        if (getChildCount() <= 1) {
            return getChildAt(0);
        }
        throw new IllegalStateException("can have at most one child");
    }
}
