package com.facebook.messaging.model.attachment;

import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: v2.3/ */
public class AttachmentImageMapBuilder {
    public final Map<AttachmentImageType, ImageUrl> f1883a = Maps.c();

    public final AttachmentImageMapBuilder m3260a(AttachmentImageType attachmentImageType, ImageUrl imageUrl) {
        this.f1883a.put(attachmentImageType, imageUrl);
        return this;
    }

    public final AttachmentImageMap m3261b() {
        return new AttachmentImageMap(this);
    }
}
