package com.facebook.gametime.ui.components.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.DimenRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

/* compiled from: Starting... */
public class TwoColorBarView extends View {
    private final Paint f25306a = new Paint(1);
    private int f25307b;
    private int f25308c;
    private float f25309d;
    private float f25310e;
    private float f25311f;
    private float f25312g;
    private float f25313h;
    private float f25314i;

    public TwoColorBarView(Context context) {
        super(context);
        setBackgroundDrawable(new ColorDrawable(ContextCompat.b(context, 2131361920)));
    }

    public TwoColorBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundDrawable(new ColorDrawable(ContextCompat.b(context, 2131361920)));
    }

    public final void m27217a(int i, int i2) {
        this.f25307b = i;
        this.f25308c = i2;
    }

    public final void m27216a(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            f2 = 1.0f;
            f = 1.0f;
        }
        this.f25310e = f / (f + f2);
    }

    public final void m27218a(@DimenRes int i, Context context) {
        this.f25309d = (float) context.getResources().getDimensionPixelSize(i);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size2 = (int) (this.f25309d + getResources().getDimension(2131427449));
        }
        setMeasuredDimension(size, size2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        float dimension = getResources().getDimension(2131431388);
        float f = (((float) i5) - (2.0f * dimension)) * this.f25310e;
        this.f25311f = dimension;
        this.f25312g = f + this.f25311f;
        Object obj = (this.f25310e == 0.0f || this.f25310e == 1.0f) ? null : 1;
        this.f25313h = this.f25312g;
        if (obj != null) {
            this.f25313h += getResources().getDimension(2131434008);
        }
        this.f25314i = ((float) i5) - dimension;
    }

    protected void onDraw(Canvas canvas) {
        this.f25306a.setColor(this.f25307b);
        canvas.drawRect(this.f25311f, 0.0f, this.f25312g, this.f25309d, this.f25306a);
        this.f25306a.setColor(this.f25308c);
        canvas.drawRect(this.f25313h, 0.0f, this.f25314i, this.f25309d, this.f25306a);
    }
}
