package com.facebook.video.feed;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.server.VideoServerMethodAutoProvider;

/* compiled from: ufi/reactions/v2/face_models/like */
public class FeedVideoPlayerParamBuilderProvider extends AbstractAssistedProvider<FeedVideoPlayerParamBuilder> {
    public final FeedVideoPlayerParamBuilder m86a(FeedProps<GraphQLStoryAttachment> feedProps, GraphQLVideo graphQLVideo) {
        return new FeedVideoPlayerParamBuilder(feedProps, graphQLVideo, VideoServerMethodAutoProvider.a(this), IdBasedProvider.a(this, 3634), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.a(this, 3635));
    }
}
