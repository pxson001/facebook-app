package com.facebook.photos.base.media;

import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;

/* compiled from: initial_target_album */
public class SphericalMediaItemUtil {
    public static boolean m20118a(MediaItem mediaItem) {
        return mediaItem != null && mediaItem.m() == MediaType.PHOTO && ((PhotoItem) mediaItem).f12736c;
    }
}
