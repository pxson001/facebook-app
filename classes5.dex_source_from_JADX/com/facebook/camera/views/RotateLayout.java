package com.facebook.camera.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: allEventMaybes */
public class RotateLayout extends ViewGroup {
    private int f11080a;
    private View f11081b;

    public RotateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(17170445);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1813717048);
        this.f11081b = getChildAt(0);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 625182437, a);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        switch (this.f11080a) {
            case 0:
            case 180:
                this.f11081b.layout(0, 0, i5, i6);
                return;
            case 90:
            case 270:
                this.f11081b.layout(0, 0, i6, i5);
                return;
            default:
                return;
        }
    }

    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        int i3 = 0;
        switch (this.f11080a) {
            case 0:
            case 180:
                measureChild(this.f11081b, i, i2);
                measuredWidth = this.f11081b.getMeasuredWidth();
                i3 = this.f11081b.getMeasuredHeight();
                break;
            case 90:
            case 270:
                measureChild(this.f11081b, i2, i);
                measuredWidth = this.f11081b.getMeasuredHeight();
                i3 = this.f11081b.getMeasuredWidth();
                break;
            default:
                measuredWidth = 0;
                break;
        }
        setMeasuredDimension(measuredWidth, i3);
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.f11080a == 0) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        canvas.rotate((float) (-this.f11080a), (float) (this.f11081b.getMeasuredWidth() / 2), (float) (this.f11081b.getMeasuredHeight() / 2));
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f11080a != 0) {
            float[] fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
            Matrix matrix = new Matrix();
            matrix.postRotate((float) this.f11080a, (float) (this.f11081b.getMeasuredWidth() / 2), (float) (this.f11081b.getMeasuredHeight() / 2));
            matrix.mapPoints(fArr);
            motionEvent.setLocation(fArr[0], fArr[1]);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOrientation(int i) {
        int i2 = i % 360;
        if (this.f11080a != i2) {
            this.f11080a = i2;
            requestLayout();
        }
    }
}
