package com.facebook.feedplugins.attachments.video;

import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.fullscreenvideoplayer.FeedFullScreenVideoElapsedMonitor;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegate.VideoSizeAndBackgroundOverride;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.video.engine.VideoLoggingUtils;
import com.google.common.base.Optional;

/* compiled from: fetch_payment_pin */
public class VideoAttachmentDelegateProvider extends AbstractAssistedProvider<VideoAttachmentDelegate> {
    public final VideoAttachmentDelegate m32376a(FeedProps<GraphQLStoryAttachment> feedProps, Optional<VideoSizeAndBackgroundOverride> optional) {
        return new VideoAttachmentDelegate(feedProps, optional, FeedImageLoader.m28808a((InjectorLike) this), FeedFullScreenVideoElapsedMonitor.m20160a((InjectorLike) this), VideoSizer.a(this), FeedEventBus.m4573a(this), VideoLoggingUtils.m27031a((InjectorLike) this), FbDraweeControllerBuilder.m19410b((InjectorLike) this), DialtoneControllerImpl.m8272a((InjectorLike) this), ChannelFeedEligibilityUtil.m32392a((InjectorLike) this));
    }
}
