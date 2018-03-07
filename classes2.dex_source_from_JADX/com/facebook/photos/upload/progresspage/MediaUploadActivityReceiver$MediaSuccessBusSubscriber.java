package com.facebook.photos.upload.progresspage;

import com.facebook.common.init.INeedInitForEventBusSubscription;
import com.facebook.composer.publish.common.ErrorDetails.Builder;
import com.facebook.composer.publish.compost.store.CompostDraftStoryStore;
import com.facebook.composer.publish.compost.store.RecentlyUploadedStoryStore;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Lazy;
import com.facebook.photos.upload.compost.CompostPendingPost;
import com.facebook.photos.upload.compost.CompostPendingPostStore;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadSuccessEvent;
import javax.inject.Inject;

/* compiled from: topic_feeds_market_switcher_layout */
public class MediaUploadActivityReceiver$MediaSuccessBusSubscriber extends INeedInitForEventBusSubscription<MediaUploadSuccessEvent, MediaUploadActivityReceiver> {
    protected final void mo649a(FbEvent fbEvent, Object obj) {
        MediaUploadSuccessEvent mediaUploadSuccessEvent = (MediaUploadSuccessEvent) fbEvent;
        MediaUploadActivityReceiver mediaUploadActivityReceiver = (MediaUploadActivityReceiver) obj;
        ComposerActivityBroadcaster composerActivityBroadcaster = mediaUploadActivityReceiver.e;
        Result result = Result.SUCCESS;
        String str = mediaUploadSuccessEvent.f2402a;
        GraphQLStory graphQLStory = mediaUploadSuccessEvent.f2404c;
        String str2 = mediaUploadSuccessEvent.f2399a.p;
        long j = mediaUploadSuccessEvent.f2399a.f;
        Builder builder = new Builder();
        builder.a = false;
        composerActivityBroadcaster.a(result, str, graphQLStory, str2, j, builder.a());
        String str3 = mediaUploadSuccessEvent.f2399a.p;
        if (mediaUploadActivityReceiver.a()) {
            ((CompostDraftStoryStore) mediaUploadActivityReceiver.d.get()).a(str3);
            CompostPendingPost e = ((CompostPendingPostStore) mediaUploadActivityReceiver.b.get()).e(str3);
            ((CompostPendingPostStore) mediaUploadActivityReceiver.b.get()).a(str3);
            if (e != null) {
                ((RecentlyUploadedStoryStore) mediaUploadActivityReceiver.c.get()).a(e.a(), mediaUploadSuccessEvent.f2404c, e.b);
            } else if (mediaUploadSuccessEvent.f2404c != null) {
                ((RecentlyUploadedStoryStore) mediaUploadActivityReceiver.c.get()).a(mediaUploadSuccessEvent.f2404c);
            }
        }
        mediaUploadActivityReceiver.a.m14451b(str3);
    }

    @Inject
    public MediaUploadActivityReceiver$MediaSuccessBusSubscriber(MediaUploadEventBus mediaUploadEventBus, Lazy<MediaUploadActivityReceiver> lazy) {
        super(mediaUploadEventBus, lazy);
    }

    public final Class<MediaUploadSuccessEvent> mo648a() {
        return MediaUploadSuccessEvent.class;
    }
}
