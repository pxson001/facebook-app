package com.facebook.video.videohome.metadata;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.video.analytics.VideoAnalytics.PrefetchReason;
import com.facebook.video.videohome.metadata.VideoHomeMetadata.Builder;
import com.facebook.video.videohome.prefetching.VideoHomeReactionSessionHelper;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomePrefetchMetadataNoBadgingQueryModel;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: source_component */
class VideoHomeMetadataFetcher$4 implements FutureCallback<GraphQLResult<VideoHomePrefetchMetadataNoBadgingQueryModel>> {
    final /* synthetic */ VideoHomeMetadataFetcher f2988a;

    VideoHomeMetadataFetcher$4(VideoHomeMetadataFetcher videoHomeMetadataFetcher) {
        this.f2988a = videoHomeMetadataFetcher;
    }

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null) {
            BLog.b(VideoHomeMetadataFetcher.d, "Video Home prefetch metadata no badging query succeeded but result was null.");
            return;
        }
        int j = ((VideoHomePrefetchMetadataNoBadgingQueryModel) graphQLResult.e).j();
        boolean a = this.f2988a.a(j, 0, false);
        Builder builder = new Builder();
        builder.f2976c = j;
        builder = builder;
        builder.f2978e = (long) ((VideoHomePrefetchMetadataNoBadgingQueryModel) graphQLResult.e).k();
        builder = builder;
        builder.f2977d = this.f2988a.a((long) ((VideoHomePrefetchMetadataNoBadgingQueryModel) graphQLResult.e).a());
        VideoHomeMetadata a2 = builder.m2884a();
        String str = VideoHomeMetadataFetcher.d;
        Integer.valueOf(a2.f2982c);
        Boolean.valueOf(a);
        Long.valueOf(a2.f2983d);
        VideoHomeReactionSessionHelper videoHomeReactionSessionHelper = (VideoHomeReactionSessionHelper) this.f2988a.g.get();
        videoHomeReactionSessionHelper.m3140a(a2);
        if (a) {
            videoHomeReactionSessionHelper.m3139a(null, PrefetchReason.BADGE_FETCH);
        } else if (!this.f2988a.b()) {
            this.f2988a.a(a2);
        }
        VideoHomeMetadataFetcher.b(this.f2988a, a2);
    }

    public void onFailure(Throwable th) {
        BLog.b(VideoHomeMetadataFetcher.d, "Video Home prefetch no badging metadata query failed", th);
    }
}
