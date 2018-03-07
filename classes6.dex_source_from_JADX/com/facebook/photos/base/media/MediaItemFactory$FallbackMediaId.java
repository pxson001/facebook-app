package com.facebook.photos.base.media;

/* compiled from: initiator */
public enum MediaItemFactory$FallbackMediaId {
    CREATIVECAM_MEDIA(-3),
    REMOTE_MEDIA(-2),
    SINGLE_SHOT_CAMERA(-1),
    DEFAULT(0);
    
    private long mValue;

    private MediaItemFactory$FallbackMediaId(long j) {
        this.mValue = j;
    }

    public final long getValue() {
        return this.mValue;
    }
}
