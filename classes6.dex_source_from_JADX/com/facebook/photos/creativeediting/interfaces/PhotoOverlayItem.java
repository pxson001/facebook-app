package com.facebook.photos.creativeediting.interfaces;

import android.graphics.PointF;
import android.graphics.RectF;

/* compiled from: tag_src */
public interface PhotoOverlayItem {

    /* compiled from: tag_src */
    public enum OverlayItemType {
        STICKER,
        TEXT,
        DOODLE
    }

    RectF mo221a();

    PhotoOverlayItem mo222a(RectF rectF, PointF pointF, float f);

    PointF mo223b();

    float mo224c();
}
