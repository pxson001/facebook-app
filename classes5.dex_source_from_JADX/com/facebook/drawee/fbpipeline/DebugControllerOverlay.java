package com.facebook.drawee.fbpipeline;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: [0-9]+ */
public class DebugControllerOverlay extends Drawable {
    private final Paint f11969a = new Paint();
    public String f11970b = null;

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.f11969a.setStyle(Style.STROKE);
        this.f11969a.setStrokeWidth(2.0f);
        this.f11969a.setColor(-65536);
        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.f11969a);
        if (this.f11970b != null) {
            this.f11969a.setStyle(Style.FILL);
            this.f11969a.setTextSize(24.0f);
            this.f11969a.setStrokeWidth(1.0f);
            this.f11969a.setColor(-65536);
            canvas.drawText(this.f11970b, (float) (bounds.left + 10), (float) (bounds.top + 34), this.f11969a);
        }
        String str = "DH";
        float f = (float) ((bounds.left + bounds.right) / 2);
        float f2 = (float) ((bounds.top + bounds.bottom) / 2);
        float height = (float) (bounds.height() / 2);
        this.f11969a.setStyle(Style.FILL_AND_STROKE);
        this.f11969a.setTextSize(height);
        this.f11969a.setStrokeWidth(height / 8.0f);
        this.f11969a.setColor(1090453504);
        float measureText = this.f11969a.measureText(str);
        int save = canvas.save();
        canvas.rotate(-45.0f, f, f2);
        canvas.drawText(str, f - (measureText / 2.0f), f2 + (height / 2.0f), this.f11969a);
        canvas.restoreToCount(save);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
