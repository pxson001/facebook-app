package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.graphics.drawable.DrawableCompat.KitKatDrawableImpl;

/* compiled from: viewer_timeline_collections_containing */
class DrawableCompat$LollipopDrawableImpl extends KitKatDrawableImpl {
    public final void m244a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public final void m246a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public final void m245a(Drawable drawable, int i) {
        if (drawable instanceof DrawableWrapperLollipop) {
            DrawableCompatBase.m251a(drawable, i);
        } else {
            drawable.setTint(i);
        }
    }

    public final void m247a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof DrawableWrapperLollipop) {
            DrawableCompatBase.m252a(drawable, colorStateList);
        } else {
            drawable.setTintList(colorStateList);
        }
    }

    public final void m248a(Drawable drawable, Mode mode) {
        if (drawable instanceof GradientDrawable) {
            DrawableCompatBase.m253a(drawable, mode);
        } else {
            drawable.setTintMode(mode);
        }
    }

    DrawableCompat$LollipopDrawableImpl() {
    }

    public final Drawable m249c(Drawable drawable) {
        return DrawableCompatLollipop.m255a(drawable);
    }
}
