package com.facebook.attachments.angora;

import com.facebook.drawee.interfaces.DraweeController;
import javax.annotation.Nullable;

/* compiled from: feed_clear_cache */
public interface AttachmentHasLargeImage {
    void setLargeImageAspectRatio(float f);

    void setLargeImageController(@Nullable DraweeController draweeController);
}
