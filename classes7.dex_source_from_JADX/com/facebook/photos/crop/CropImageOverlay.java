package com.facebook.photos.crop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.facebook.common.util.SizeUtil;

/* compiled from: live_photo */
public class CropImageOverlay extends View {
    public int f10063a;
    public Paint f10064b;
    public RectF f10065c;
    public float f10066d = -1.0f;
    public float f10067e = 1.0f;
    private boolean f10068f = false;

    public CropImageOverlay(Context context, boolean z) {
        super(context);
        this.f10068f = z;
        boolean z2 = this.f10068f;
        if (z2) {
            this.f10063a = getResources().getColor(2131363502);
        } else {
            this.f10063a = getResources().getColor(2131363501);
        }
        this.f10064b = new Paint(1);
        if (z2) {
            this.f10064b.setColor(getResources().getColor(2131361917));
            this.f10064b.setStrokeWidth((float) SizeUtil.a(getContext(), 2.0f));
        } else {
            this.f10064b.setColor(getResources().getColor(2131361864));
            this.f10064b.setStrokeWidth(3.0f);
        }
        this.f10064b.setStyle(Style.STROKE);
        ViewCompat.a(this, 1, null);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.clipRect(this.f10065c, Op.DIFFERENCE);
        canvas.drawColor(this.f10063a);
        canvas.restore();
        canvas.drawRect(this.f10065c, this.f10064b);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.f10066d > 0.0f) {
            int i5 = i4 - i2;
            int i6 = i3 - i;
            float min = ((float) Math.min(i5, i6)) * this.f10066d;
            float f = (((float) i6) - (this.f10067e * min)) / 2.0f;
            float f2 = (((float) i5) - min) / 2.0f;
            this.f10065c = new RectF(f, f2, (this.f10067e * min) + f, min + f2);
        }
    }

    public RectF getHightedRect() {
        return this.f10065c;
    }
}
