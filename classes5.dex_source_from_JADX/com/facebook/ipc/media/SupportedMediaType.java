package com.facebook.ipc.media;

/* compiled from: THINGS_TO_DO_SUGGESTION */
public enum SupportedMediaType {
    PHOTO_ONLY,
    VIDEO_ONLY,
    ALL,
    PHOTO_ONLY_EXCLUDING_GIFS;

    public final boolean supportsVideos() {
        return this == VIDEO_ONLY || this == ALL;
    }

    public final boolean supportsPhotos() {
        return this == PHOTO_ONLY || this == ALL;
    }
}
