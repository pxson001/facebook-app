package android.support.v7.widget;

import android.graphics.drawable.Drawable;

/* compiled from: uiRotateGestures */
interface CardViewDelegate {
    void mo430a(int i, int i2, int i3, int i4);

    Drawable getBackground();

    boolean getPreventCornerOverlap();

    boolean getUseCompatPadding();

    void setBackgroundDrawable(Drawable drawable);
}
