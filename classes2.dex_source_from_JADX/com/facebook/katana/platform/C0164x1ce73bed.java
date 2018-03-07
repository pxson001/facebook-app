package com.facebook.katana.platform;

import com.facebook.inject.Lazy;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadSuccessEvent;
import javax.inject.Inject;

/* compiled from: tos_array */
public class C0164x1ce73bed extends C0163x7fbfbe44<MediaUploadSuccessEvent> {
    @Inject
    public C0164x1ce73bed(MediaUploadEventBus mediaUploadEventBus, Lazy<PlatformMediaUploadActivityReceiver> lazy) {
        super(MediaUploadSuccessEvent.class, mediaUploadEventBus, lazy, true);
    }
}
