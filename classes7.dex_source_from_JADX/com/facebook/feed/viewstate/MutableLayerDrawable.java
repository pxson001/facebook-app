package com.facebook.feed.viewstate;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: share_story_url */
public class MutableLayerDrawable extends Drawable implements Callback {
    private static final Rect f3850a = new Rect();
    private List<Drawable> f3851b;
    private List<Rect> f3852c;
    private boolean f3853d;
    private int f3854e;

    public MutableLayerDrawable() {
        this(null);
    }

    public MutableLayerDrawable(Drawable[] drawableArr) {
        this.f3853d = false;
        int length = drawableArr != null ? drawableArr.length : 4;
        this.f3851b = new ArrayList(length);
        this.f3852c = new ArrayList(length);
        if (drawableArr != null) {
            for (Drawable a : drawableArr) {
                m4486a(a, null);
            }
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public boolean getPadding(Rect rect) {
        return ((Drawable) this.f3851b.get(0)).getPadding(rect);
    }

    public void draw(Canvas canvas) {
        int size = this.f3851b.size();
        for (int i = 0; i < size; i++) {
            ((Drawable) this.f3851b.get(i)).draw(canvas);
        }
    }

    public void setDither(boolean z) {
        int size = this.f3851b.size();
        for (int i = 0; i < size; i++) {
            ((Drawable) this.f3851b.get(i)).setDither(z);
        }
    }

    public void setAlpha(int i) {
        int size = this.f3851b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Drawable) this.f3851b.get(i2)).setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        int size = this.f3851b.size();
        for (int i = 0; i < size; i++) {
            ((Drawable) this.f3851b.get(i)).setColorFilter(colorFilter);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i = 0; i < this.f3851b.size(); i++) {
            z |= ((Drawable) this.f3851b.get(i)).setState(iArr);
        }
        return z;
    }

    protected boolean onLevelChange(int i) {
        boolean z = false;
        for (int i2 = 0; i2 < this.f3851b.size(); i2++) {
            z |= ((Drawable) this.f3851b.get(i2)).setLevel(i);
        }
        return z;
    }

    protected void onBoundsChange(Rect rect) {
        int size = this.f3851b.size();
        for (int i = 0; i < size; i++) {
            Rect rect2 = (Rect) this.f3852c.get(i);
            ((Drawable) this.f3851b.get(i)).setBounds(rect.left + rect2.left, rect.top + rect2.top, rect.right - rect2.right, rect.bottom - rect2.bottom);
        }
    }

    public int getOpacity() {
        if (this.f3853d) {
            return this.f3854e;
        }
        int size = this.f3851b.size();
        int i = -2;
        for (int i2 = 0; i2 < size; i2++) {
            i = Drawable.resolveOpacity(i, ((Drawable) this.f3851b.get(i2)).getOpacity());
        }
        this.f3854e = i;
        this.f3853d = true;
        return this.f3854e;
    }

    private void m4486a(Drawable drawable, Rect rect) {
        if (rect == null) {
            rect = f3850a;
        }
        this.f3851b.add(drawable);
        this.f3852c.add(rect);
        drawable.setCallback(this);
    }
}
