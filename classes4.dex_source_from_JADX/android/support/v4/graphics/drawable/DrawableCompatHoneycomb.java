package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* compiled from: qe_db */
class DrawableCompatHoneycomb {
    DrawableCompatHoneycomb() {
    }

    public static Drawable m4446b(Drawable drawable) {
        if (drawable instanceof DrawableWrapperHoneycomb) {
            return drawable;
        }
        return new DrawableWrapperHoneycomb(drawable);
    }
}
