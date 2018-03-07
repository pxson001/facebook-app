package com.facebook.dialtone;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: \\d */
public class UpgradeButtonDrawable extends Drawable {
    private final Paint f11811a = new Paint();
    private final DialtoneController f11812b;
    private final DialtoneController$PlaceholderState f11813c;

    public UpgradeButtonDrawable(DialtoneController dialtoneController, DialtoneController$PlaceholderState dialtoneController$PlaceholderState) {
        this.f11812b = dialtoneController;
        this.f11813c = dialtoneController$PlaceholderState;
    }

    public void draw(Canvas canvas) {
        if (this.f11812b.j()) {
            Rect bounds = getBounds();
            this.f11811a.setStyle(Style.STROKE);
            this.f11811a.setStrokeWidth(2.0f);
            this.f11811a.setColor(Color.argb(255, 215, 215, 215));
            canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.f11811a);
            float f = ((float) (bounds.left + bounds.right)) / 2.0f;
            float f2 = ((float) (bounds.top + bounds.bottom)) / 2.0f;
            this.f11811a.setColor(Color.argb(255, 0, 0, 0));
            Bitmap a = this.f11812b.a((float) (bounds.right - bounds.left), (float) (bounds.bottom - bounds.top), this.f11813c);
            canvas.drawBitmap(a, f - (((float) a.getWidth()) / 2.0f), f2 - (((float) a.getHeight()) / 2.0f), this.f11811a);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
