package com.facebook.messaging.media.upload;

import com.facebook.ui.media.attachments.MediaResource.Type;

/* compiled from: loadingIndicatorLock */
/* synthetic */ class MediaUploadManagerImpl$15 {
    static final /* synthetic */ int[] f11904a = new int[Type.values().length];

    static {
        try {
            f11904a[Type.PHOTO.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11904a[Type.AUDIO.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11904a[Type.VIDEO.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
