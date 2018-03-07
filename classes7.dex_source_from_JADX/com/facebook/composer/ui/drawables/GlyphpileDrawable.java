package com.facebook.composer.ui.drawables;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.common.collect.ImmutableList;

/* compiled from: composer_event_details_fetch_error */
public class GlyphpileDrawable extends Drawable {
    private final ImmutableList<Drawable> f17070a;
    private final int f17071b;
    private final int f17072c;
    private final int f17073d;

    public GlyphpileDrawable(ImmutableList<Drawable> immutableList, int i) {
        this.f17070a = immutableList;
        this.f17071b = i;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f17070a.size(); i4++) {
            Drawable drawable = (Drawable) this.f17070a.get(i4);
            i3 += drawable.getIntrinsicWidth();
            i2 = Math.max(i2, drawable.getIntrinsicHeight());
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.f17073d = (this.f17071b * (this.f17070a.size() - 1)) + i3;
        this.f17072c = i2;
    }

    public void draw(Canvas canvas) {
        canvas.save();
        Rect bounds = getBounds();
        canvas.translate((float) (bounds.left + ((bounds.width() - getIntrinsicWidth()) / 2)), (float) (((bounds.height() - getIntrinsicHeight()) / 2) + bounds.top));
        int size = this.f17070a.size();
        for (int i = 0; i < size; i++) {
            Drawable drawable = (Drawable) this.f17070a.get(i);
            drawable.draw(canvas);
            canvas.translate((float) (drawable.getIntrinsicWidth() + this.f17071b), 0.0f);
        }
        canvas.restore();
    }

    public int getIntrinsicHeight() {
        return this.f17072c;
    }

    public int getIntrinsicWidth() {
        return this.f17073d;
    }

    public void setAlpha(int i) {
        int size = this.f17070a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Drawable) this.f17070a.get(i2)).setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        int size = this.f17070a.size();
        for (int i = 0; i < size; i++) {
            ((Drawable) this.f17070a.get(i)).setColorFilter(colorFilter);
        }
    }

    public int getOpacity() {
        return 0;
    }
}
