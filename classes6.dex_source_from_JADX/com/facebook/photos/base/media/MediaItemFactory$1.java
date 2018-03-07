package com.facebook.photos.base.media;

import com.facebook.ipc.media.MediaItem.MediaType;

/* compiled from: initiator */
/* synthetic */ class MediaItemFactory$1 {
    static final /* synthetic */ int[] f12712a = new int[MediaType.values().length];
    static final /* synthetic */ int[] f12713b = new int[MediaItemFactory$Storage.values().length];

    static {
        try {
            f12713b[MediaItemFactory$Storage.EXTERNAL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f12713b[MediaItemFactory$Storage.INTERNAL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f12712a[MediaType.PHOTO.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f12712a[MediaType.VIDEO.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
    }
}
