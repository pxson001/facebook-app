package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* compiled from: viewer_save_state */
class DrawableCompatKitKat {
    DrawableCompatKitKat() {
    }

    public static Drawable m254b(Drawable drawable) {
        if (drawable instanceof DrawableWrapperKitKat) {
            return drawable;
        }
        return new DrawableWrapperKitKat(drawable);
    }
}
