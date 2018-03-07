package com.facebook.feedplugins.attachments.video;

import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: ufi/reactions/v2/24x24/yay */
public class LegacyFullscreenTransitionListenerProvider extends AbstractAssistedProvider<LegacyFullscreenTransitionListener> {
    public final LegacyFullscreenTransitionListener m125a(FeedProps<GraphQLStoryAttachment> feedProps, VideoAutoplayTransitionManager videoAutoplayTransitionManager, HasInvalidate hasInvalidate) {
        return new LegacyFullscreenTransitionListener(feedProps, videoAutoplayTransitionManager, hasInvalidate, FrameRateBlameMarkers.a(this), CallToActionUtil.b(this));
    }
}
