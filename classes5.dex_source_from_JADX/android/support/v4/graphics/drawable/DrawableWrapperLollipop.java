package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: viewer_newly_added */
public class DrawableWrapperLollipop extends DrawableWrapperKitKat {
    DrawableWrapperLollipop(Drawable drawable) {
        super(drawable);
    }

    public void setHotspot(float f, float f2) {
        this.f225b.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f225b.setHotspotBounds(i, i2, i3, i4);
    }

    public void setTint(int i) {
        this.f225b.setTint(i);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f225b.setTintList(colorStateList);
    }

    public void setTintMode(Mode mode) {
        this.f225b.setTintMode(mode);
    }

    public void getOutline(Outline outline) {
        this.f225b.getOutline(outline);
    }

    public void applyTheme(Theme theme) {
        this.f225b.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        return this.f225b.canApplyTheme();
    }

    public Rect getDirtyBounds() {
        return this.f225b.getDirtyBounds();
    }
}
