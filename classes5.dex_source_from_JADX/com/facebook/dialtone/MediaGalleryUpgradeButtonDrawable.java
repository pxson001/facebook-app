package com.facebook.dialtone;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: \\f */
public class MediaGalleryUpgradeButtonDrawable extends Drawable {
    private final Paint f11809a = new Paint();
    private final DialtoneController f11810b;

    public MediaGalleryUpgradeButtonDrawable(DialtoneController dialtoneController) {
        this.f11810b = dialtoneController;
        this.f11809a.setStrokeWidth(5.0f);
        this.f11809a.setColor(-16777216);
    }

    public void draw(Canvas canvas) {
        if (this.f11810b.j()) {
            Rect bounds = getBounds();
            canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.f11809a);
            float f = ((float) (bounds.left + bounds.right)) / 2.0f;
            float f2 = ((float) (bounds.top + bounds.bottom)) / 2.0f;
            this.f11809a.setColor(Color.argb(255, 0, 0, 0));
            Bitmap a = this.f11810b.a((float) (bounds.right - bounds.left), (float) (bounds.bottom - bounds.top), new DialtoneController$PlaceholderState(null, 0, DialtoneController$FeatureType.PHOTO));
            canvas.drawBitmap(a, f - (((float) a.getWidth()) / 2.0f), f2 - (((float) a.getHeight()) / 2.0f), this.f11809a);
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
