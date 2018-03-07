package com.facebook.photos.editgallery.animations;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import com.google.common.base.Preconditions;

/* compiled from: last_screen */
public class AnimationParam {
    private final PointF f10482a;

    public static AnimationParam m12362a(View view) {
        Preconditions.checkNotNull(view);
        int[] iArr = new int[]{view.getLeft(), view.getTop()};
        view.getLocationOnScreen(iArr);
        return new AnimationParam(new PointF((float) iArr[0], (float) iArr[1]));
    }

    public static AnimationParam m12363a(View view, RectF rectF) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(rectF);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new AnimationParam(new PointF(((float) iArr[0]) + rectF.left, ((float) iArr[1]) + rectF.top));
    }

    private AnimationParam(PointF pointF) {
        this.f10482a = pointF;
    }

    public final float m12364a() {
        return this.f10482a.y;
    }
}
