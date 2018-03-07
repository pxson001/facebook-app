package com.facebook.photos.upload.progresspage;

import com.facebook.common.init.INeedInitForEventBusSubscription;
import com.facebook.composer.publish.common.ErrorDetails.Builder;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.ExceptionInterpreter.Diagnostic;
import com.facebook.photos.upload.compost.CompostPendingPostStore;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadFailedEvent;
import com.facebook.photos.upload.operation.UploadInterruptionCause;
import javax.inject.Inject;

/* compiled from: topic_feeds_market_switcher_layout */
public class MediaUploadActivityReceiver$MediaFailedBusSubscriber extends INeedInitForEventBusSubscription<MediaUploadFailedEvent, MediaUploadActivityReceiver> {
    protected final void mo649a(FbEvent fbEvent, Object obj) {
        Result result;
        MediaUploadFailedEvent mediaUploadFailedEvent = (MediaUploadFailedEvent) fbEvent;
        MediaUploadActivityReceiver mediaUploadActivityReceiver = (MediaUploadActivityReceiver) obj;
        if (mediaUploadFailedEvent.f2397b) {
            result = Result.CANCELLED;
        } else {
            result = Result.EXCEPTION;
        }
        Builder builder = new Builder();
        builder.a = mediaUploadFailedEvent.f2398c;
        builder = builder;
        if (!(mediaUploadFailedEvent.f2399a == null || mediaUploadFailedEvent.f2399a.E == null)) {
            UploadInterruptionCause uploadInterruptionCause = mediaUploadFailedEvent.f2399a.E;
            Builder a = builder.a(uploadInterruptionCause.c);
            a.c = uploadInterruptionCause.d();
            a.d = uploadInterruptionCause.e();
            if (uploadInterruptionCause.d == Diagnostic.PERMANENT_VIDEO_PROCESSING_ERROR) {
                builder.h = true;
            }
        }
        mediaUploadActivityReceiver.e.a(result, null, null, mediaUploadFailedEvent.f2399a.p, mediaUploadFailedEvent.f2399a.f, builder.a());
        if (mediaUploadFailedEvent.f2397b) {
            String str = mediaUploadFailedEvent.f2399a.p;
            mediaUploadActivityReceiver.a.m14450a(str);
            if (mediaUploadActivityReceiver.a()) {
                ((CompostPendingPostStore) mediaUploadActivityReceiver.b.get()).a(str);
            }
        }
    }

    @Inject
    public MediaUploadActivityReceiver$MediaFailedBusSubscriber(MediaUploadEventBus mediaUploadEventBus, Lazy<MediaUploadActivityReceiver> lazy) {
        super(mediaUploadEventBus, lazy);
    }

    public final Class<MediaUploadFailedEvent> mo648a() {
        return MediaUploadFailedEvent.class;
    }
}
