package com.facebook.photos.creativeediting.swipeable.common;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.photos.creativeediting.model.DraweeSwipeableItem;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.SwipingTouchEventState;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: mDictionary */
public class SwipeableDrawHelper {
    private static final Rect f9757a = new Rect();

    /* compiled from: mDictionary */
    public enum DrawingType {
        FRAME_TO_FRAME,
        FILTER_TO_FILTER,
        FRAME_TO_FILTER,
        FILTER_TO_FRAME,
        NONE;

        public static DrawingType getType(SwipingTouchEventState swipingTouchEventState, DraweeSwipeableItem draweeSwipeableItem, DraweeSwipeableItem draweeSwipeableItem2, DraweeSwipeableItem draweeSwipeableItem3) {
            Preconditions.checkNotNull(draweeSwipeableItem);
            Preconditions.checkNotNull(draweeSwipeableItem2);
            Preconditions.checkNotNull(draweeSwipeableItem3);
            if (swipingTouchEventState.e()) {
                if (draweeSwipeableItem.b()) {
                    if (draweeSwipeableItem2.b()) {
                        return FRAME_TO_FRAME;
                    }
                    return FILTER_TO_FRAME;
                } else if (draweeSwipeableItem2.b()) {
                    return FRAME_TO_FILTER;
                } else {
                    return FILTER_TO_FILTER;
                }
            } else if (!swipingTouchEventState.d()) {
                return NONE;
            } else {
                if (draweeSwipeableItem3.b()) {
                    if (draweeSwipeableItem2.b()) {
                        return FRAME_TO_FRAME;
                    }
                    return FILTER_TO_FRAME;
                } else if (draweeSwipeableItem2.b()) {
                    return FRAME_TO_FILTER;
                } else {
                    return FILTER_TO_FILTER;
                }
            }
        }
    }

    public static void m11693a(Canvas canvas, SwipingTouchEventState swipingTouchEventState, FrameImageView frameImageView, DraweeSwipeableItem draweeSwipeableItem, DraweeSwipeableItem draweeSwipeableItem2, RectF rectF, int i, int i2, int i3) {
        Preconditions.checkNotNull(swipingTouchEventState);
        frameImageView.setSwipeableItem(null);
        if (swipingTouchEventState.d()) {
            m11689a(canvas, draweeSwipeableItem2, i, i2, i3);
            m11690a(canvas, draweeSwipeableItem2, rectF, i3);
        } else if (swipingTouchEventState.e()) {
            m11696b(canvas, draweeSwipeableItem, i, i2, i3);
            m11691a(canvas, draweeSwipeableItem, rectF, i, i3);
        }
    }

    public static void m11695a(Canvas canvas, SwipingTouchEventState swipingTouchEventState, FrameImageView frameImageView, DraweeSwipeableItem draweeSwipeableItem, DraweeSwipeableItem draweeSwipeableItem2, DraweeSwipeableItem draweeSwipeableItem3, RectF rectF, int i, int i2, int i3) {
        Preconditions.checkNotNull(swipingTouchEventState);
        frameImageView.setSwipeableItem(null);
        if (swipingTouchEventState.d()) {
            m11689a(canvas, draweeSwipeableItem3, i, i2, i3);
            m11691a(canvas, draweeSwipeableItem2, rectF, i, i3);
        } else if (swipingTouchEventState.e()) {
            m11696b(canvas, draweeSwipeableItem, i, i2, i3);
            m11690a(canvas, draweeSwipeableItem2, rectF, i3);
        }
    }

    public static void m11692a(Canvas canvas, DraweeSwipeableItem draweeSwipeableItem, DraweeSwipeableItem draweeSwipeableItem2, SwipingTouchEventState swipingTouchEventState, int i, int i2, int i3) {
        Preconditions.checkNotNull(swipingTouchEventState);
        if (swipingTouchEventState.d()) {
            m11689a(canvas, draweeSwipeableItem2, i, i2, i3);
        } else if (swipingTouchEventState.e()) {
            m11696b(canvas, draweeSwipeableItem, i, i2, i3);
        }
    }

    public static void m11694a(Canvas canvas, SwipingTouchEventState swipingTouchEventState, FrameImageView frameImageView, DraweeSwipeableItem draweeSwipeableItem, DraweeSwipeableItem draweeSwipeableItem2, DraweeSwipeableItem draweeSwipeableItem3, RectF rectF, int i, int i2) {
        Preconditions.checkNotNull(swipingTouchEventState);
        Preconditions.checkNotNull(draweeSwipeableItem2);
        frameImageView.setSwipeableItem(null);
        if (swipingTouchEventState.d()) {
            m11690a(canvas, draweeSwipeableItem3, rectF, i2);
            if (draweeSwipeableItem2.b()) {
                m11691a(canvas, draweeSwipeableItem2, rectF, i, i2);
            }
        } else if (swipingTouchEventState.e()) {
            m11691a(canvas, draweeSwipeableItem, rectF, i, i2);
            if (draweeSwipeableItem2.b()) {
                m11690a(canvas, draweeSwipeableItem2, rectF, i2);
            }
        }
    }

    private static void m11689a(Canvas canvas, DraweeSwipeableItem draweeSwipeableItem, int i, int i2, int i3) {
        if (draweeSwipeableItem.c != null) {
            Preconditions.checkNotNull(draweeSwipeableItem);
            Drawable h = draweeSwipeableItem.c.h();
            f9757a.set(0, 0, i, i2);
            h.setBounds(f9757a);
            canvas.save();
            f9757a.set(i3, 0, i, i2);
            canvas.clipRect(f9757a);
            h.draw(canvas);
            canvas.restore();
        }
    }

    private static void m11696b(Canvas canvas, DraweeSwipeableItem draweeSwipeableItem, int i, int i2, int i3) {
        if (draweeSwipeableItem.c != null) {
            Preconditions.checkNotNull(draweeSwipeableItem);
            Drawable h = draweeSwipeableItem.c.h();
            f9757a.set(0, 0, i, i2);
            h.setBounds(f9757a);
            canvas.save();
            f9757a.set(0, 0, i3, i2);
            canvas.clipRect(f9757a);
            h.draw(canvas);
            canvas.restore();
        }
    }

    private static void m11691a(Canvas canvas, DraweeSwipeableItem draweeSwipeableItem, RectF rectF, int i, int i2) {
        boolean z;
        int i3 = 0;
        Preconditions.checkNotNull(draweeSwipeableItem);
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        ImmutableList c = draweeSwipeableItem.c();
        int size = c.size();
        while (i3 < size) {
            StickerParams stickerParams = (StickerParams) c.get(i3);
            if (draweeSwipeableItem.a(stickerParams) != null) {
                Drawable h = draweeSwipeableItem.a(stickerParams).h();
                if (h != null) {
                    m11688a(canvas, h, stickerParams, -(i - i2), rectF);
                }
            }
            i3++;
        }
    }

    private static void m11690a(Canvas canvas, DraweeSwipeableItem draweeSwipeableItem, RectF rectF, int i) {
        boolean z;
        int i2 = 0;
        Preconditions.checkNotNull(draweeSwipeableItem);
        if (rectF.width() > 0.0f) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        ImmutableList c = draweeSwipeableItem.c();
        int size = c.size();
        while (i2 < size) {
            StickerParams stickerParams = (StickerParams) c.get(i2);
            if (draweeSwipeableItem.a(stickerParams) != null) {
                Drawable h = draweeSwipeableItem.a(stickerParams).h();
                if (h != null) {
                    m11688a(canvas, h, stickerParams, i, rectF);
                }
            }
            i2++;
        }
    }

    public static void m11688a(Canvas canvas, Drawable drawable, StickerParams stickerParams, int i, RectF rectF) {
        float width = (rectF.width() * stickerParams.n()) + rectF.left;
        float height = (rectF.height() * stickerParams.o()) + rectF.top;
        f9757a.set((int) width, (int) height, (int) ((rectF.width() * stickerParams.e()) + width), (int) ((rectF.height() * stickerParams.f()) + height));
        drawable.setBounds(f9757a);
        int save = canvas.save();
        canvas.translate((float) i, 0.0f);
        canvas.rotate(stickerParams.c(), (float) f9757a.centerX(), (float) f9757a.centerY());
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }
}
