package com.facebook.photos.upload.progresspage;

import com.facebook.common.init.INeedInitForEventBusSubscription;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Lazy;
import com.facebook.photos.upload.event.BaseMediaUploadEvent.Status;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MultiPhotoUploadProgressEvent;
import javax.inject.Inject;

/* compiled from: topic_feeds_market_switcher_layout */
public class MediaUploadActivityReceiver$MediaProgressBusSubscriber extends INeedInitForEventBusSubscription<MultiPhotoUploadProgressEvent, MediaUploadActivityReceiver> {
    protected final void mo649a(FbEvent fbEvent, Object obj) {
        MultiPhotoUploadProgressEvent multiPhotoUploadProgressEvent = (MultiPhotoUploadProgressEvent) fbEvent;
        MediaUploadActivityReceiver mediaUploadActivityReceiver = (MediaUploadActivityReceiver) obj;
        if (!multiPhotoUploadProgressEvent.f2399a.Z() && multiPhotoUploadProgressEvent.f2400b == Status.UPLOADING) {
            int i = multiPhotoUploadProgressEvent.f2401c * 10;
            if (i >= 0 && i <= 1000) {
                mediaUploadActivityReceiver.e.a(multiPhotoUploadProgressEvent.f2399a.p, multiPhotoUploadProgressEvent.f2399a.f, Math.min(i, 999));
            }
        }
    }

    @Inject
    public MediaUploadActivityReceiver$MediaProgressBusSubscriber(MediaUploadEventBus mediaUploadEventBus, Lazy<MediaUploadActivityReceiver> lazy) {
        super(mediaUploadEventBus, lazy);
    }

    public final Class<MultiPhotoUploadProgressEvent> mo648a() {
        return MultiPhotoUploadProgressEvent.class;
    }
}
