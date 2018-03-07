package com.facebook.composer.attachments;

import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.google.common.collect.ImmutableList;

/* compiled from: place_picker_add_place_started */
public class MediaItemUtil {
    public static boolean m11255a(ImmutableList<MediaItem> immutableList) {
        return immutableList.size() == m11257c(immutableList);
    }

    public static boolean m11256b(ImmutableList<MediaItem> immutableList) {
        return immutableList.size() > 1 && m11257c(immutableList) > 0;
    }

    public static boolean m11254a(MediaItem mediaItem) {
        return mediaItem.m() == MediaType.VIDEO && MediaItem.a.equals(mediaItem.i());
    }

    public static int m11257c(ImmutableList<MediaItem> immutableList) {
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            MediaItem mediaItem = (MediaItem) immutableList.get(i);
            if (mediaItem.m() != MediaType.VIDEO || MediaItem.a.equals(mediaItem.i())) {
                i3 = i2;
            } else {
                i3 = i2 + 1;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    public static int m11258d(ImmutableList<MediaItem> immutableList) {
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            if (((MediaItem) immutableList.get(i)).m() == MediaType.PHOTO) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    public static boolean m11259e(ImmutableList<MediaItem> immutableList) {
        if (immutableList == null) {
            return false;
        }
        return immutableList.size() == 1 && ((MediaItem) immutableList.get(0)).m() == MediaType.VIDEO;
    }
}
