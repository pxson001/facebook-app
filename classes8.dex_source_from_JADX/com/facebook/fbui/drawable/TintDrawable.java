package com.facebook.fbui.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.AttributeSet;
import com.facebook.R;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: hashtag.disallowed_too_long */
public class TintDrawable extends Drawable implements Callback {
    private DrawableState f11569a;

    /* compiled from: hashtag.disallowed_too_long */
    class DrawableState extends ConstantState {
        final Drawable f11566a;
        final boolean f11567b;
        final int f11568c;

        public DrawableState(Drawable drawable, boolean z, int i) {
            this.f11566a = drawable;
            this.f11567b = z;
            this.f11568c = i;
        }

        DrawableState(DrawableState drawableState) {
            this.f11568c = drawableState.f11568c;
            this.f11567b = drawableState.f11567b;
            this.f11566a = drawableState.f11566a.getConstantState().newDrawable();
            this.f11566a.setColorFilter(this.f11568c, Mode.SRC_IN);
        }

        public Drawable newDrawable() {
            return new TintDrawable(this);
        }

        public int getChangingConfigurations() {
            return 0;
        }
    }

    public TintDrawable(DrawableState drawableState) {
        this.f11569a = new DrawableState(drawableState);
        this.f11569a.f11566a.setCallback(this);
    }

    public void draw(Canvas canvas) {
        this.f11569a.f11566a.draw(canvas);
    }

    public void setAlpha(int i) {
        this.f11569a.f11566a.setAlpha(i);
    }

    public int getAlpha() {
        return this.f11569a.f11566a.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (!this.f11569a.f11567b) {
            this.f11569a.f11566a.setColorFilter(colorFilter);
        }
    }

    public Drawable mutate() {
        this.f11569a.f11566a.mutate();
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        this.f11569a.f11566a.setBounds(rect);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.TintDrawable);
        int resourceId = obtainAttributes.getResourceId(0, 0);
        int color = obtainAttributes.getColor(1, 0);
        boolean z = obtainAttributes.getBoolean(2, false);
        obtainAttributes.recycle();
        this.f11569a = new DrawableState(resources.getDrawable(resourceId).mutate(), z, color);
        if (this.f11569a.f11566a.getConstantState() == null) {
            throw new RuntimeException("getConstantState() should not return null during inflate");
        }
        this.f11569a.f11566a.setCallback(this);
        this.f11569a.f11566a.setColorFilter(new PorterDuffColorFilter(color, Mode.SRC_IN));
    }

    public int getIntrinsicWidth() {
        return this.f11569a.f11566a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f11569a.f11566a.getIntrinsicHeight();
    }

    public int getOpacity() {
        return this.f11569a.f11566a.getOpacity();
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.f11569a.f11566a == drawable) {
            invalidateSelf();
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (this.f11569a.f11566a == drawable) {
            scheduleSelf(runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (this.f11569a.f11566a == drawable) {
            unscheduleSelf(runnable);
        }
    }

    public final ConstantState getConstantState() {
        return this.f11569a;
    }
}
