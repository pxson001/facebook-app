package com.facebook.photos.base.util;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.ipc.media.MediaItem;
import com.google.common.base.Preconditions;

/* compiled from: inconceivable JSON exception */
public class PhotoHashUtil {
    public static String m20207a(String str, long j) {
        return StringFormatUtil.a("%s/%d", new Object[]{str, Long.valueOf(j)});
    }

    public static String m20206a(MediaItem mediaItem) {
        Preconditions.checkNotNull(mediaItem);
        return m20207a(mediaItem.h(), mediaItem.j());
    }
}
