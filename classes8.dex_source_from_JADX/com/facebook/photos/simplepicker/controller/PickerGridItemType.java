package com.facebook.photos.simplepicker.controller;

/* compiled from: share_open_browser */
public enum PickerGridItemType {
    PHOTO,
    VIDEO,
    GIF,
    LIVE_CAMERA;

    public static PickerGridItemType fromOrdinal(int i) {
        switch (i) {
            case 0:
                return PHOTO;
            case 1:
                return VIDEO;
            case 2:
                return GIF;
            case 3:
                return LIVE_CAMERA;
            default:
                return null;
        }
    }
}
