package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;

/* compiled from: com.google.android.gms.common.internal.IAccountAccessor */
public class RoundedCornersFrameLayout extends CustomFrameLayout {
    private final Paint f5710a;
    private final Paint f5711b;
    private final float[] f5712c;
    private final Path f5713d;
    private final RectF f5714e;

    public RoundedCornersFrameLayout(Context context) {
        super(context);
        this.f5710a = new Paint(3);
        this.f5711b = new Paint(1);
        this.f5712c = new float[8];
        this.f5713d = new Path();
        this.f5714e = new RectF();
        m10504a(context, null);
    }

    public RoundedCornersFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5710a = new Paint(3);
        this.f5711b = new Paint(1);
        this.f5712c = new float[8];
        this.f5713d = new Path();
        this.f5714e = new RectF();
        m10504a(context, attributeSet);
    }

    public RoundedCornersFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5710a = new Paint(3);
        this.f5711b = new Paint(1);
        this.f5712c = new float[8];
        this.f5713d = new Path();
        this.f5714e = new RectF();
        m10504a(context, attributeSet);
    }

    private void m10502a(float f, float f2, float f3, float f4) {
        float[] fArr = this.f5712c;
        this.f5712c[1] = f;
        fArr[0] = f;
        fArr = this.f5712c;
        this.f5712c[3] = f2;
        fArr[2] = f2;
        fArr = this.f5712c;
        this.f5712c[5] = f3;
        fArr[4] = f3;
        fArr = this.f5712c;
        this.f5712c[7] = f4;
        fArr[6] = f4;
    }

    public void setBackGroundColor(int i) {
        this.f5711b.setColor(i);
    }

    private void m10504a(Context context, AttributeSet attributeSet) {
        int i = 0;
        setWillNotDraw(false);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedView);
            try {
                float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(5, 0);
                m10502a(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                i = obtainStyledAttributes.getColor(6, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f5711b.setColor(i);
        this.f5710a.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.f5713d.setFillType(FillType.INVERSE_WINDING);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1752772007);
        super.onSizeChanged(i, i2, i3, i4);
        m10503a(i, i2);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1243157648, a);
    }

    private void m10503a(int i, int i2) {
        this.f5713d.reset();
        this.f5714e.set(0.0f, 0.0f, (float) i, (float) i2);
        this.f5713d.addRoundRect(this.f5714e, this.f5712c, Direction.CW);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        m10505a(canvas);
    }

    private void m10505a(Canvas canvas) {
        TracerDetour.a("RoundedCornersFrameLayout applying mask", -820914074);
        try {
            canvas.drawPath(this.f5713d, this.f5710a);
            canvas.drawPath(this.f5713d, this.f5711b);
        } finally {
            TracerDetour.a(-490116991);
        }
    }
}
