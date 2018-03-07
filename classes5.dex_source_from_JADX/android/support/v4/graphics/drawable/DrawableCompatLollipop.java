package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* compiled from: viewer_request_to_join_subscription_level */
class DrawableCompatLollipop {
    DrawableCompatLollipop() {
    }

    public static Drawable m255a(Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            return new DrawableWrapperLollipop(drawable);
        }
        return drawable;
    }
}
