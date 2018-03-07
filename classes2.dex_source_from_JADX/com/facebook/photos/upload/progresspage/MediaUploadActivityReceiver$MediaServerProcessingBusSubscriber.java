package com.facebook.photos.upload.progresspage;

import com.facebook.common.init.INeedInitForEventBusSubscription;
import com.facebook.composer.publish.common.ErrorDetails.Builder;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Lazy;
import com.facebook.photos.upload.event.BaseMediaUploadEvent.Status;
import com.facebook.photos.upload.event.MediaServerProcessingEvent;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import javax.inject.Inject;

/* compiled from: topic_feeds_market_switcher_layout */
public class MediaUploadActivityReceiver$MediaServerProcessingBusSubscriber extends INeedInitForEventBusSubscription<MediaServerProcessingEvent, MediaUploadActivityReceiver> {
    protected final void mo649a(FbEvent fbEvent, Object obj) {
        MediaServerProcessingEvent mediaServerProcessingEvent = (MediaServerProcessingEvent) fbEvent;
        MediaUploadActivityReceiver mediaUploadActivityReceiver = (MediaUploadActivityReceiver) obj;
        if (mediaServerProcessingEvent.f2400b == Status.MEDIA_PROCESSING_SUCCESS || mediaServerProcessingEvent.f2400b == Status.MEDIA_PROCESSING_FAILED) {
            ComposerActivityBroadcaster composerActivityBroadcaster = mediaUploadActivityReceiver.e;
            Result result = Result.SUCCESS;
            String str = mediaServerProcessingEvent.f2407a;
            GraphQLStory graphQLStory = mediaServerProcessingEvent.f2408b;
            String str2 = mediaServerProcessingEvent.f2399a.p;
            long j = mediaServerProcessingEvent.f2399a.f;
            Builder builder = new Builder();
            builder.a = false;
            composerActivityBroadcaster.b(result, str, graphQLStory, str2, j, builder.a());
            mediaUploadActivityReceiver.a.m14450a(mediaServerProcessingEvent.f2399a.p);
        }
    }

    @Inject
    public MediaUploadActivityReceiver$MediaServerProcessingBusSubscriber(MediaUploadEventBus mediaUploadEventBus, Lazy<MediaUploadActivityReceiver> lazy) {
        super(mediaUploadEventBus, lazy);
    }

    public final Class<MediaServerProcessingEvent> mo648a() {
        return MediaServerProcessingEvent.class;
    }
}
