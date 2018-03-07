package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.LightBitmapDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.RoundedLightBitmapDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.RoundingParams.RoundingMethod;
import javax.annotation.Nullable;

/* compiled from: messaging/compose/%s */
public class WrappingUtils {
    public static final Drawable f14249a = new ColorDrawable(0);

    public static void m20648a(Rounded rounded, RoundingParams roundingParams) {
        rounded.mo3382a(roundingParams.b);
        rounded.mo3383a(roundingParams.c);
        rounded.mo3381a(roundingParams.f, roundingParams.e);
        rounded.mo3384b(roundingParams.g);
    }

    @Nullable
    public static Drawable m20643a(@Nullable Drawable drawable, @Nullable ScalingUtils$ScaleType scalingUtils$ScaleType) {
        return m20644a(drawable, scalingUtils$ScaleType, null);
    }

    @Nullable
    public static Drawable m20644a(@Nullable Drawable drawable, @Nullable ScalingUtils$ScaleType scalingUtils$ScaleType, @Nullable PointF pointF) {
        if (drawable == null || scalingUtils$ScaleType == null) {
            return drawable;
        }
        Drawable scaleTypeDrawable = new ScaleTypeDrawable(drawable, scalingUtils$ScaleType);
        if (pointF != null) {
            scaleTypeDrawable.m20653a(pointF);
        }
        return scaleTypeDrawable;
    }

    @Nullable
    public static Drawable m20642a(@Nullable Drawable drawable, @Nullable Matrix matrix) {
        return (drawable == null || matrix == null) ? drawable : new MatrixDrawable(drawable, matrix);
    }

    public static Drawable m20645a(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams) {
        if (drawable == null || roundingParams == null || roundingParams.a != RoundingMethod.OVERLAY_COLOR) {
            return drawable;
        }
        Rounded roundedCornersDrawable = new RoundedCornersDrawable(drawable);
        m20648a(roundedCornersDrawable, roundingParams);
        roundedCornersDrawable.m31161a(roundingParams.d);
        return roundedCornersDrawable;
    }

    static Drawable m20646a(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams, Resources resources) {
        if (drawable == null || roundingParams == null || roundingParams.a != RoundingMethod.BITMAP_ONLY) {
            return drawable;
        }
        if (!(drawable instanceof ForwardingDrawable)) {
            return m20649b(drawable, roundingParams, resources);
        }
        DrawableParent a = m20647a((ForwardingDrawable) drawable);
        a.mo2740a(m20649b(a.mo2740a(f14249a), roundingParams, resources));
        return drawable;
    }

    public static Drawable m20649b(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        Rounded roundedBitmapDrawable;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            roundedBitmapDrawable = new RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            m20648a(roundedBitmapDrawable, roundingParams);
            return roundedBitmapDrawable;
        } else if (drawable instanceof LightBitmapDrawable) {
            LightBitmapDrawable lightBitmapDrawable = (LightBitmapDrawable) drawable;
            roundedBitmapDrawable = new RoundedLightBitmapDrawable(resources, lightBitmapDrawable.a, lightBitmapDrawable.e);
            m20648a(roundedBitmapDrawable, roundingParams);
            return roundedBitmapDrawable;
        } else if (!(drawable instanceof ColorDrawable) || VERSION.SDK_INT < 11) {
            return drawable;
        } else {
            Rounded roundedColorDrawable = new RoundedColorDrawable(((ColorDrawable) drawable).getColor());
            m20648a(roundedColorDrawable, roundingParams);
            return roundedColorDrawable;
        }
    }

    public static DrawableParent m20647a(DrawableParent drawableParent) {
        while (true) {
            Drawable a = r2.mo2739a();
            if (a == r2 || !(a instanceof DrawableParent)) {
                return r2;
            }
            Object obj = (DrawableParent) a;
        }
        return r2;
    }
}
