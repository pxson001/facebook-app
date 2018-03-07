package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import javax.annotation.Nullable;

/* compiled from: messaging/compose/new */
public class DrawableUtils {
    public static void m20640a(Drawable drawable, Drawable drawable2) {
        if (drawable2 != null && drawable != null && drawable != drawable2) {
            drawable.setBounds(drawable2.getBounds());
            drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
            drawable.setLevel(drawable2.getLevel());
            drawable.setVisible(drawable2.isVisible(), false);
            drawable.setState(drawable2.getState());
        }
    }

    public static void m20641a(Drawable drawable, DrawableProperties drawableProperties) {
        if (drawable != null && drawableProperties != null) {
            boolean z = true;
            if (drawable != null) {
                if (drawableProperties.f14244a != -1) {
                    drawable.setAlpha(drawableProperties.f14244a);
                }
                if (drawableProperties.f14245b) {
                    drawable.setColorFilter(drawableProperties.f14246c);
                }
                if (drawableProperties.f14247d != -1) {
                    boolean z2;
                    if (drawableProperties.f14247d != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    drawable.setDither(z2);
                }
                if (drawableProperties.f14248e != -1) {
                    if (drawableProperties.f14248e == 0) {
                        z = false;
                    }
                    drawable.setFilterBitmap(z);
                }
            }
        }
    }

    public static void m20639a(Drawable drawable, @Nullable Callback callback, @Nullable TransformCallback transformCallback) {
        if (drawable != null) {
            drawable.setCallback(callback);
            if (drawable instanceof TransformAwareDrawable) {
                ((TransformAwareDrawable) drawable).mo2743a(transformCallback);
            }
        }
    }

    public static int m20638a(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & 16777215;
        }
        return (((((i2 >> 7) + i2) * (i >>> 24)) >> 8) << 24) | (i & 16777215);
    }
}
