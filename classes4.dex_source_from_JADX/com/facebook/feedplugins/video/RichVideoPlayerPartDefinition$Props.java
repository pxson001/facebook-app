package com.facebook.feedplugins.video;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.VideoSizeAndBackgroundOverride;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.google.common.base.Optional;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: pic */
public final class RichVideoPlayerPartDefinition$Props {
    public final FeedProps<GraphQLStoryAttachment> f4791a;
    public final int f4792b;
    public final Optional<VideoSizeAndBackgroundOverride> f4793c;
    public final AtomicReference<FullscreenTransitionListener> f4794d;
    public final PlayerOrigin f4795e;

    public RichVideoPlayerPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, int i, Optional<VideoSizeAndBackgroundOverride> optional, AtomicReference<FullscreenTransitionListener> atomicReference, PlayerOrigin playerOrigin) {
        this.f4791a = feedProps;
        this.f4792b = i;
        this.f4793c = optional;
        this.f4794d = atomicReference;
        this.f4795e = playerOrigin;
    }

    public RichVideoPlayerPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, int i, Optional<VideoSizeAndBackgroundOverride> optional, AtomicReference<FullscreenTransitionListener> atomicReference) {
        this(feedProps, i, optional, atomicReference, null);
    }
}
