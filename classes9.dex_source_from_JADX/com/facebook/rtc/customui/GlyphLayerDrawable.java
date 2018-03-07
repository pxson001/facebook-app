package com.facebook.rtc.customui;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* compiled from: audio/x-mpeg3 */
public class GlyphLayerDrawable extends LayerDrawable {
    private final ColorStateList[] f19311a;

    public GlyphLayerDrawable(Drawable[] drawableArr, ColorStateList[] colorStateListArr) {
        super(drawableArr);
        this.f19311a = colorStateListArr;
    }

    protected boolean onStateChange(int[] iArr) {
        for (int i = 0; i < this.f19311a.length; i++) {
            getDrawable(i).setColorFilter(this.f19311a[i].getColorForState(iArr, this.f19311a[i].getDefaultColor()), Mode.SRC_IN);
        }
        return super.onStateChange(iArr);
    }

    public boolean isStateful() {
        return true;
    }
}
