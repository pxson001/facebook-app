package com.facebook.video.activity;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.albums.protocols.VideoConversionHelper;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import javax.inject.Inject;

/* compiled from: mArtistName */
public class FullscreenVideoPlayerLauncher {
    private final SecureContextHelper f9575a;

    public static FullscreenVideoPlayerLauncher m11255b(InjectorLike injectorLike) {
        return new FullscreenVideoPlayerLauncher((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public FullscreenVideoPlayerLauncher(SecureContextHelper secureContextHelper) {
        this.f9575a = secureContextHelper;
    }

    public final void m11257a(VideoDetailFragmentModel videoDetailFragmentModel, Context context, PlayerOrigin playerOrigin) {
        m11254a(VideoConversionHelper.a(videoDetailFragmentModel), context, playerOrigin, true);
    }

    public final void m11258b(VideoDetailFragmentModel videoDetailFragmentModel, Context context, PlayerOrigin playerOrigin) {
        m11254a(VideoConversionHelper.a(videoDetailFragmentModel), context, playerOrigin, false);
    }

    public static FullscreenVideoPlayerLauncher m11253a(InjectorLike injectorLike) {
        return m11255b(injectorLike);
    }

    public final void m11256a(GraphQLVideo graphQLVideo, Context context, PlayerOrigin playerOrigin) {
        m11254a(graphQLVideo, context, playerOrigin, false);
    }

    private void m11254a(GraphQLVideo graphQLVideo, Context context, PlayerOrigin playerOrigin, boolean z) {
        Intent a = FullScreenVideoPlayerActivity.m11245a(context, playerOrigin);
        FlatBufferModelHelper.a(a, "video_graphql_object", graphQLVideo);
        a.putExtra("video_player_allow_looping", z);
        this.f9575a.a(a, context);
    }
}
