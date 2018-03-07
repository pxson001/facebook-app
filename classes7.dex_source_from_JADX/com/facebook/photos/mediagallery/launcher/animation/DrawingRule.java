package com.facebook.photos.mediagallery.launcher.animation;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import com.google.common.base.Preconditions;

/* compiled from: is_truncated_at_beginning */
public class DrawingRule {
    public final Rect f10719a;
    public final Rect f10720b;

    public static DrawingRule m12761a(DraweeView<GenericDraweeHierarchy> draweeView) {
        Preconditions.checkNotNull(draweeView);
        Preconditions.checkNotNull(draweeView.getHierarchy());
        RectF rectF = new RectF();
        ((GenericDraweeHierarchy) draweeView.getHierarchy()).a(rectF);
        int[] iArr = new int[2];
        draweeView.getLocationOnScreen(iArr);
        rectF.offset((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) draweeView.getPaddingLeft(), (float) draweeView.getPaddingTop());
        Rect rect = new Rect();
        draweeView.getGlobalVisibleRect(rect);
        rect.left += draweeView.getPaddingLeft();
        rect.top += draweeView.getPaddingTop();
        rect.right -= draweeView.getPaddingRight();
        rect.bottom -= draweeView.getPaddingBottom();
        return new DrawingRule(new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom), rect);
    }

    public static DrawingRule m12760a(GenericDraweeHierarchy genericDraweeHierarchy, View view, Rect rect) {
        Preconditions.checkNotNull(genericDraweeHierarchy);
        Preconditions.checkNotNull(view);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        RectF rectF = new RectF();
        genericDraweeHierarchy.a(rectF);
        rectF.offset((float) iArr[0], (float) iArr[1]);
        Rect rect2 = new Rect(rect);
        rect2.offset(iArr[0], iArr[1]);
        Rect rect3 = new Rect();
        view.getGlobalVisibleRect(rect3);
        rect3.intersect(rect2);
        return new DrawingRule(new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom), rect3);
    }

    public static DrawingRule m12759a(ImageView imageView) {
        Preconditions.checkNotNull(imageView);
        Preconditions.checkNotNull(imageView.getDrawable());
        int[] iArr = new int[2];
        imageView.getLocationOnScreen(iArr);
        Matrix imageMatrix = imageView.getImageMatrix();
        RectF rectF = new RectF(imageView.getDrawable().getBounds());
        imageMatrix.mapRect(rectF);
        int i = (int) (((float) iArr[0]) + rectF.left);
        int i2 = (int) (((float) iArr[1]) + rectF.top);
        int width = ((int) rectF.width()) + i;
        int height = ((int) rectF.height()) + i2;
        Rect rect = new Rect();
        imageView.getGlobalVisibleRect(rect);
        return new DrawingRule(new Rect(i, i2, width, height), rect);
    }

    private static DrawingRule m12757a(int i, int i2, Rect rect, ScaleType scaleType) {
        float width = (float) rect.width();
        float height = (float) rect.height();
        if (scaleType == ScaleType.CENTER_CROP || scaleType == ScaleType.CENTER_INSIDE) {
            if (scaleType == ScaleType.CENTER_CROP) {
                width = Math.max(width / ((float) i), height / ((float) i2));
            } else {
                width = Math.min(width / ((float) i), height / ((float) i2));
            }
            height = ((float) i) * width;
            width *= (float) i2;
            int centerX = (int) (((float) rect.centerX()) - (height / 2.0f));
            int i3 = (int) (height + ((float) centerX));
            int centerY = (int) (((float) rect.centerY()) - (width / 2.0f));
            int i4 = (int) (width + ((float) centerY));
            return new DrawingRule(new Rect(centerX, centerY, i3, i4), new Rect(Math.max(centerX, rect.left), Math.max(centerY, rect.top), Math.min(i3, rect.right), Math.min(i4, rect.bottom)));
        }
        throw new RuntimeException("Not yet supported: " + scaleType.name());
    }

    public static DrawingRule m12758a(Drawable drawable, Rect rect, ScaleType scaleType) {
        return m12757a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, scaleType);
    }

    public DrawingRule(Rect rect, Rect rect2) {
        this.f10719a = rect;
        this.f10720b = rect2;
    }

    public DrawingRule() {
        this.f10719a = new Rect();
        this.f10720b = new Rect();
    }
}
