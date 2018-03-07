package com.facebook.messaging.media.upload;

import com.google.common.base.Preconditions;

/* compiled from: linkify_message */
public class MessageMediaUploadState {
    public final MediaItemUploadStatus f11997a;
    public final UploadState f11998b;

    /* compiled from: linkify_message */
    public enum UploadState {
        NO_MEDIA_ITEMS,
        IN_PROGRESS,
        FAILED,
        SUCCEEDED,
        NOT_ALL_STARTED
    }

    public MessageMediaUploadState(MediaItemUploadStatus mediaItemUploadStatus, UploadState uploadState) {
        this.f11997a = (MediaItemUploadStatus) Preconditions.checkNotNull(mediaItemUploadStatus);
        this.f11998b = uploadState;
    }
}
