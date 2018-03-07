package com.facebook.katana.platform;

import com.facebook.inject.Lazy;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadFailedEvent;
import javax.inject.Inject;

/* compiled from: tos_array */
public class C0162xf3aead23 extends C0163x7fbfbe44<MediaUploadFailedEvent> {
    @Inject
    public C0162xf3aead23(MediaUploadEventBus mediaUploadEventBus, Lazy<PlatformMediaUploadActivityReceiver> lazy) {
        super(MediaUploadFailedEvent.class, mediaUploadEventBus, lazy, false);
    }
}
