package com.facebook.timeline.data;

/* compiled from: feather_overlay_extras_extracted */
public enum PhotoLoadState {
    PHOTO_NOT_LOADED,
    PHOTO_MINI_PREVIEW,
    PHOTO_LOW_RES,
    PHOTO_HIGH_RES,
    PHOTO_NONE,
    PHOTO_MINI_PREVIEW_FAILED,
    PHOTO_LOW_RES_FAILED,
    PHOTO_HIGH_RES_FAILED;

    public static boolean isFailLoadState(PhotoLoadState photoLoadState) {
        return photoLoadState == PHOTO_LOW_RES_FAILED || photoLoadState == PHOTO_HIGH_RES_FAILED;
    }

    public static boolean isPhotoLoaded(PhotoLoadState photoLoadState) {
        return photoLoadState == PHOTO_MINI_PREVIEW || photoLoadState == PHOTO_LOW_RES || photoLoadState == PHOTO_HIGH_RES || photoLoadState == PHOTO_NONE;
    }

    public static boolean isFinalPhotoLoadState(PhotoLoadState photoLoadState) {
        return photoLoadState == PHOTO_HIGH_RES || photoLoadState == PHOTO_NONE;
    }
}
