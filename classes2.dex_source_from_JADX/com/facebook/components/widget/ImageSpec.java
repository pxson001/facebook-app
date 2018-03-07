package com.facebook.components.widget;

import android.graphics.drawable.Drawable;
import android.widget.ImageView.ScaleType;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.DrawableMatrix;
import com.facebook.components.MatrixDrawable;
import com.facebook.components.Output;
import com.facebook.components.Size;
import com.facebook.components.SizeSpec;
import com.facebook.components.annotations.MountSpec;
import com.facebook.components.reference.Reference;
import com.facebook.components.utils.MeasureUtils;
import com.facebook.components.utils.MeasureUtils.MeasureException;

@MountSpec
/* compiled from: from */
public class ImageSpec {
    public static final ScaleType[] f22972a = ScaleType.values();

    protected static void m31085a(ComponentContext componentContext, int i, int i2, Size size, Reference<Drawable> reference) {
        if (reference == null) {
            size.f22987a = 0;
            size.f22988b = 0;
            return;
        }
        Drawable drawable = (Drawable) Reference.m30531a(componentContext, (Reference) reference);
        if (drawable != null) {
            try {
                if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    if (SizeSpec.m30704a(i) == 0 && SizeSpec.m30704a(i2) == 0) {
                        size.f22987a = intrinsicWidth;
                        size.f22988b = intrinsicHeight;
                        return;
                    }
                    try {
                        MeasureUtils.m31107a(i, i2, intrinsicWidth, intrinsicHeight, ((float) intrinsicWidth) / ((float) intrinsicHeight), size);
                    } catch (MeasureException e) {
                        size.f22987a = intrinsicWidth;
                        size.f22988b = intrinsicHeight;
                    }
                    Reference.m30532a(componentContext, drawable, reference);
                    return;
                }
            } finally {
                Reference.m30532a(componentContext, drawable, reference);
            }
        }
        size.f22987a = 0;
        size.f22988b = 0;
        Reference.m30532a(componentContext, drawable, reference);
    }

    protected static void m31086a(ComponentContext componentContext, ComponentLayout componentLayout, Reference<Drawable> reference, ScaleType scaleType, Output<DrawableMatrix> output, Output<Integer> output2, Output<Integer> output3) {
        Drawable drawable = (Drawable) Reference.m30531a(componentContext, (Reference) reference);
        try {
            int h = componentLayout.m30805h() + componentLayout.d_();
            int e = componentLayout.m30796e() + componentLayout.m30801g();
            if (ScaleType.FIT_XY == scaleType || drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
                output.m31110a(null);
                output2.m31110a(Integer.valueOf(componentLayout.m30790c() - h));
                output3.m31110a(Integer.valueOf(componentLayout.m30793d() - e));
            } else {
                output.m31110a(DrawableMatrix.m31140a(drawable, scaleType, componentLayout.m30790c() - h, componentLayout.m30793d() - e));
                output2.m31110a(Integer.valueOf(drawable.getIntrinsicWidth()));
                output3.m31110a(Integer.valueOf(drawable.getIntrinsicHeight()));
            }
            Reference.m30532a(componentContext, drawable, reference);
        } catch (Throwable th) {
            Reference.m30532a(componentContext, drawable, reference);
        }
    }

    protected static MatrixDrawable m31084a(ComponentContext componentContext, MatrixDrawable matrixDrawable, Reference<Drawable> reference, DrawableMatrix drawableMatrix) {
        if (matrixDrawable == null) {
            matrixDrawable = new MatrixDrawable();
        }
        matrixDrawable.m31143a((Drawable) Reference.m30531a(componentContext, (Reference) reference), drawableMatrix);
        return matrixDrawable;
    }
}
