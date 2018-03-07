package com.facebook.video.channelfeed;

import com.facebook.attachments.videos.ui.HasChannelFeedLauncherInfo;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.video.analytics.VideoAnalytics.ExternalLogType;
import com.facebook.video.channelfeed.LaunchChannelFeedClickListener.OnLaunchCallback;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: photosync */
public final class ChannelFeedFromVideoLauncherPartDefinition$Props {
    public final FeedProps<GraphQLStoryAttachment> f4796a;
    public final AtomicReference<FullscreenTransitionListener> f4797b;
    @Nullable
    public final HasChannelFeedLauncherInfo f4798c;
    @Nullable
    public final ChannelFeedHeaderParams f4799d;
    @Nullable
    public final OnLaunchCallback f4800e;
    @Nullable
    public final ExternalLogType f4801f;
    @Nullable
    public final String f4802g;

    public ChannelFeedFromVideoLauncherPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, AtomicReference<FullscreenTransitionListener> atomicReference) {
        this(feedProps, atomicReference, null, null);
    }

    private ChannelFeedFromVideoLauncherPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, AtomicReference<FullscreenTransitionListener> atomicReference, HasChannelFeedLauncherInfo hasChannelFeedLauncherInfo, ChannelFeedHeaderParams channelFeedHeaderParams) {
        this(feedProps, atomicReference, hasChannelFeedLauncherInfo, channelFeedHeaderParams, null);
    }

    private ChannelFeedFromVideoLauncherPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, AtomicReference<FullscreenTransitionListener> atomicReference, HasChannelFeedLauncherInfo hasChannelFeedLauncherInfo, ChannelFeedHeaderParams channelFeedHeaderParams, OnLaunchCallback onLaunchCallback) {
        this(feedProps, atomicReference, hasChannelFeedLauncherInfo, channelFeedHeaderParams, onLaunchCallback, null, null);
    }

    public ChannelFeedFromVideoLauncherPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, AtomicReference<FullscreenTransitionListener> atomicReference, HasChannelFeedLauncherInfo hasChannelFeedLauncherInfo, ChannelFeedHeaderParams channelFeedHeaderParams, OnLaunchCallback onLaunchCallback, ExternalLogType externalLogType, String str) {
        this.f4796a = feedProps;
        this.f4797b = atomicReference;
        this.f4798c = hasChannelFeedLauncherInfo;
        this.f4799d = channelFeedHeaderParams;
        this.f4800e = onLaunchCallback;
        this.f4801f = externalLogType;
        this.f4802g = str;
    }
}
