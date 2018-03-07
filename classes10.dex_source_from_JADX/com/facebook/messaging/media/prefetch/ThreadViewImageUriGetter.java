package com.facebook.messaging.media.prefetch;

import android.net.Uri;
import com.facebook.messaging.attachments.ImageAttachmentUris;

/* compiled from: searchText */
public class ThreadViewImageUriGetter {
    public static Uri m3136a(int i, ImageAttachmentUris imageAttachmentUris) {
        if (imageAttachmentUris == null) {
            return null;
        }
        if (i == 1) {
            return imageAttachmentUris.d;
        }
        if (i == 2 || i == 4) {
            return imageAttachmentUris.c;
        }
        return imageAttachmentUris.b;
    }
}
