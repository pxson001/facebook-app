package com.facebook.photos.base.tagging;

import android.graphics.PointF;
import android.graphics.RectF;
import com.facebook.inject.InjectorLike;

/* compiled from: infinite_disambiguation_serp */
public class TaggingHelper {
    public static TaggingHelper m20199a(InjectorLike injectorLike) {
        return new TaggingHelper();
    }

    public final double m20200a(PointF pointF, PointF pointF2, RectF rectF) {
        return m20198a(pointF.x, pointF.y, pointF2.x, pointF2.y, rectF);
    }

    public static double m20198a(float f, float f2, float f3, float f4, RectF rectF) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float f7 = (f >= rectF.right || f <= rectF.left) ? 6.0f : 1.0f;
        return Math.sqrt((((double) (rectF.top - f2 > 0.0f ? 1.0f : 9.0f)) * Math.pow((double) (f6 / rectF.height()), 2.0d)) + (((double) f7) * Math.pow((double) (f5 / rectF.width()), 2.0d)));
    }
}
