package com.facebook.photos.creativeediting.swipeable.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.widget.viewpageindicator.HScrollCirclePageIndicator;

/* compiled from: mComposerHint */
public class SwipeableFramesHScrollCirclePageIndicator extends HScrollCirclePageIndicator {
    private final Paint f9762a = new Paint(1);
    private final Paint f9763b = new Paint(1);
    private final Paint f9764c = new Paint(1);
    private final Paint f9765d = new Paint(1);
    private float f9766e;
    private boolean f9767f;
    private float f9768g;
    private int f9769h;
    private int f9770i = 10;
    private int f9771j = -1;

    public SwipeableFramesHScrollCirclePageIndicator(Context context) {
        super(context);
        m11701a(context, null);
    }

    public SwipeableFramesHScrollCirclePageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11701a(context, attributeSet);
    }

    public SwipeableFramesHScrollCirclePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        m11701a(context, attributeSet);
    }

    private void m11701a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwipeableFramesHScrollCirclePageIndicator, 0, 0);
        this.f9766e = obtainStyledAttributes.getDimension(3, 0.0f);
        this.f9769h = obtainStyledAttributes.getInt(0, 17);
        this.f9768g = obtainStyledAttributes.getDimension(1, 0.0f);
        this.f9762a.setColor(getPageColor());
        this.f9762a.setStyle(Style.FILL);
        this.f9764c.setColor(getFillColor());
        this.f9764c.setStyle(Style.FILL);
        this.f9763b.setColor(getStrokeColor());
        this.f9763b.setStrokeWidth(getStrokeWidth());
        this.f9763b.setStyle(Style.FILL);
        this.f9765d.setColor(obtainStyledAttributes.getColor(2, 0));
        this.f9765d.setStrokeWidth(this.f9768g);
        this.f9765d.setStyle(Style.STROKE);
        if (this.f9766e == 0.0f) {
            this.f9766e = this.a;
        }
        obtainStyledAttributes.recycle();
    }

    public void setFillFirstCircle(boolean z) {
        this.f9767f = z;
        invalidate();
    }

    public void setCurrentItem(int i) {
        this.f9771j = i;
        super.setCurrentItem(i);
    }

    public final void m11702a(int i, int i2, boolean z) {
        this.f9771j = i2;
        super.a(i, i2, z);
    }

    public void setMaxCircles(int i) {
        this.f9770i = i;
        super.setMaxCircles(i);
    }

    protected void onDraw(Canvas canvas) {
        int circleCount = getCircleCount();
        if (circleCount != 0) {
            float f;
            float strokeWidth;
            int width = getWidth();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            float f2 = this.a;
            float f3 = (f2 * 2.0f) + this.f9766e;
            float f4 = ((float) paddingTop) + f2;
            if ((this.f9769h & 8388611) == 8388611 || (this.f9769h & 8388613) != 8388613) {
                f = ((float) paddingLeft) + f2;
            } else {
                f = ((float) (width - paddingRight)) - (((float) circleCount) * f3);
            }
            if ((this.f9769h & 17) == 17) {
                f += (((float) ((width - paddingLeft) - paddingRight)) - (((float) circleCount) * f3)) / 2.0f;
            }
            if (this.f9763b.getStrokeWidth() > 0.0f) {
                strokeWidth = f2 - (this.f9763b.getStrokeWidth() / 2.0f);
            } else {
                strokeWidth = f2;
            }
            for (paddingLeft = 0; paddingLeft < circleCount; paddingLeft++) {
                float f5 = (((float) paddingLeft) * f3) + f;
                if (paddingLeft != 0 || this.f9767f || this.f9768g == 0.0f) {
                    if (this.f9762a.getAlpha() > 0) {
                        canvas.drawCircle(f5, f4, strokeWidth, this.f9762a);
                    }
                    if (strokeWidth != f2) {
                        canvas.drawCircle(f5, f4, f2, this.f9763b);
                    }
                } else {
                    canvas.drawCircle(f5, f4, f2, this.f9765d);
                }
            }
            canvas.drawCircle(f + (((float) this.f9771j) * f3), f4, f2, this.f9764c);
        }
    }

    private int getCircleCount() {
        int i = this.l;
        return i < this.f9770i ? i : this.f9770i;
    }
}
