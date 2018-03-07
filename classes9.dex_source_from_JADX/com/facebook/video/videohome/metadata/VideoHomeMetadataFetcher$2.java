package com.facebook.video.videohome.metadata;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.video.videohome.metadata.VideoHomeMetadata.Builder;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomeBadgeQueryModel;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: source_component */
class VideoHomeMetadataFetcher$2 implements FutureCallback<GraphQLResult<VideoHomeBadgeQueryModel>> {
    final /* synthetic */ VideoHomeMetadataFetcher f2986a;

    VideoHomeMetadataFetcher$2(VideoHomeMetadataFetcher videoHomeMetadataFetcher) {
        this.f2986a = videoHomeMetadataFetcher;
    }

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null) {
            BLog.b(VideoHomeMetadataFetcher.d, "Video Home badge count query succeeded but result was null.");
            return;
        }
        ((JewelCounters) this.f2986a.k.get()).a(Jewel.VIDEO_HOME);
        int j = ((VideoHomeBadgeQueryModel) graphQLResult.e).j();
        Builder builder = new Builder();
        builder.f2974a = j;
        builder = builder;
        builder.f2975b = ((VideoHomeBadgeQueryModel) graphQLResult.e).k();
        builder = builder;
        builder.f2977d = this.f2986a.a((long) ((VideoHomeBadgeQueryModel) graphQLResult.e).a());
        VideoHomeMetadata a = builder.m2884a();
        this.f2986a.t = ((VideoHomeBadgeQueryModel) graphQLResult.e).k();
        String str = VideoHomeMetadataFetcher.d;
        Integer.valueOf(a.f2980a);
        Long.valueOf(a.f2983d);
        ((VideoHomeBadgeUpdater) this.f2986a.j.get()).f2973d = a;
        VideoHomeMetadataFetcher.b(this.f2986a, a);
    }

    public void onFailure(Throwable th) {
        BLog.b(VideoHomeMetadataFetcher.d, "Video Home badge count query failed", th);
    }
}
