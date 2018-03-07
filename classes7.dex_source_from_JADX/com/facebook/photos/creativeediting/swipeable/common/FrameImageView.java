package com.facebook.photos.creativeediting.swipeable.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.photos.creativeediting.model.DraweeSwipeableItem;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: mHref */
public class FrameImageView extends ImageView {
    @Nullable
    private DraweeSwipeableItem f9744a;
    @Nullable
    private RectF f9745b;

    public FrameImageView(Context context) {
        super(context);
    }

    public FrameImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FrameImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setSwipeableItem(DraweeSwipeableItem draweeSwipeableItem) {
        this.f9744a = draweeSwipeableItem;
        invalidate();
    }

    public void setActualImageBounds(RectF rectF) {
        if (!m11674a(this.f9745b, rectF)) {
            this.f9745b = rectF;
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (this.f9744a == null || !this.f9744a.a(drawable)) {
            return super.verifyDrawable(drawable);
        }
        return true;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f9744a != null) {
            if (this.f9745b == null) {
                this.f9745b = new RectF((float) getLeft(), (float) getTop(), (float) getRight(), (float) getBottom());
            }
            ImmutableList c = this.f9744a.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                StickerParams stickerParams = (StickerParams) c.get(i);
                if (this.f9744a.a(stickerParams) != null) {
                    SwipeableDrawHelper.m11688a(canvas, this.f9744a.a(stickerParams).h(), stickerParams, 0, this.f9745b);
                }
            }
        }
    }

    private static boolean m11674a(@Nullable RectF rectF, @Nullable RectF rectF2) {
        if (rectF == null && rectF2 == null) {
            return true;
        }
        if (rectF != null && rectF2 != null && rectF.left == rectF2.left && rectF.top == rectF2.top && rectF.right == rectF2.right && rectF.bottom == rectF2.bottom) {
            return true;
        }
        return false;
    }
}
