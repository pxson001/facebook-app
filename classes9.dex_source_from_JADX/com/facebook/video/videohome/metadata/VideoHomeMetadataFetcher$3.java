package com.facebook.video.videohome.metadata;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.video.analytics.VideoAnalytics.PrefetchReason;
import com.facebook.video.videohome.metadata.VideoHomeMetadata.Builder;
import com.facebook.video.videohome.prefetching.VideoHomeReactionSessionHelper;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomePrefetchMetadataQueryModel;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: source_component */
class VideoHomeMetadataFetcher$3 implements FutureCallback<GraphQLResult<VideoHomePrefetchMetadataQueryModel>> {
    final /* synthetic */ VideoHomeMetadataFetcher f2987a;

    VideoHomeMetadataFetcher$3(VideoHomeMetadataFetcher videoHomeMetadataFetcher) {
        this.f2987a = videoHomeMetadataFetcher;
    }

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null) {
            BLog.b(VideoHomeMetadataFetcher.d, "Video Home prefetch metadata query succeeded but result was null.");
            return;
        }
        int j = ((VideoHomePrefetchMetadataQueryModel) graphQLResult.e).j();
        int a = ((VideoHomePrefetchMetadataQueryModel) graphQLResult.e).a();
        boolean a2 = this.f2987a.a(j, a, false);
        Builder builder = new Builder();
        builder.f2976c = j;
        Builder builder2 = builder;
        builder2.f2974a = a;
        builder2 = builder2;
        builder2.f2978e = (long) ((VideoHomePrefetchMetadataQueryModel) graphQLResult.e).k();
        VideoHomeMetadata a3 = builder2.m2884a();
        String str = VideoHomeMetadataFetcher.d;
        Integer.valueOf(a3.f2982c);
        Boolean.valueOf(a2);
        VideoHomeReactionSessionHelper videoHomeReactionSessionHelper = (VideoHomeReactionSessionHelper) this.f2987a.g.get();
        VideoHomeBadgeUpdater videoHomeBadgeUpdater = (VideoHomeBadgeUpdater) this.f2987a.j.get();
        videoHomeBadgeUpdater.f2973d = a3;
        videoHomeReactionSessionHelper.m3140a(a3);
        if (a2) {
            videoHomeReactionSessionHelper.m3139a(videoHomeBadgeUpdater, PrefetchReason.BADGE_FETCH);
            return;
        }
        videoHomeBadgeUpdater.m2882c();
        if (!this.f2987a.b()) {
            this.f2987a.a(a3);
        }
    }

    public void onFailure(Throwable th) {
        BLog.b(VideoHomeMetadataFetcher.d, "Video Home prefetch metadata query failed", th);
    }
}
