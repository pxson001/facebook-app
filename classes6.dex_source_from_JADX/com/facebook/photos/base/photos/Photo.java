package com.facebook.photos.base.photos;

import android.graphics.PointF;
import com.facebook.ui.images.fetch.FetchImageParams;

/* compiled from: page_video_only */
public abstract class Photo {
    public long f12744a;
    protected PointF f12745b;

    /* compiled from: page_video_only */
    public enum PhotoSize {
        THUMBNAIL,
        SCREENNAIL
    }

    @Deprecated
    public abstract FetchImageParams mo1095a(PhotoSize photoSize);

    public Photo(long j) {
        this.f12744a = j;
    }

    public final long m20124e() {
        return this.f12744a;
    }
}
