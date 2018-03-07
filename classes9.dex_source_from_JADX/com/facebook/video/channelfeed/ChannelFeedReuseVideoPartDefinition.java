package com.facebook.video.channelfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.HasVideoAutoplay;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedplugins.attachments.video.VideoPrefetchPartDefinition;
import com.facebook.feedplugins.attachments.video.VideoSubtitlesPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.video.analytics.VideoLoggingPropertyBag;
import com.facebook.video.channelfeed.ChannelFeedVideoPartDefinition.Props;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sync_invalid_seq_id_from_fetch */
public class ChannelFeedReuseVideoPartDefinition<E extends HasPersistentState & HasFullscreenPlayer & HasPlayerOrigin & CanReusePlayer & HasFeedListType & HasVideoAutoplay<ChannelFeedVideoAttachmentView> & CanShowVideoInFullScreen> extends ChannelFeedVideoPartDefinition<E> {
    private static ChannelFeedReuseVideoPartDefinition f2397c;
    private static final Object f2398d = new Object();

    private static ChannelFeedReuseVideoPartDefinition m2343c(InjectorLike injectorLike) {
        return new ChannelFeedReuseVideoPartDefinition(ChannelFeedFullscreenPartDefinition.m2211a(injectorLike), ChannelFeedImpressionLoggerPartDefinition.m2302a(injectorLike), (FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), VideoPrefetchPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 1816), FlyoutEventBus.a(injectorLike), FeedEventBus.a(injectorLike), VideoLoggingPropertyBag.a(injectorLike));
    }

    @Inject
    public ChannelFeedReuseVideoPartDefinition(ChannelFeedFullscreenPartDefinition channelFeedFullscreenPartDefinition, ChannelFeedImpressionLoggerPartDefinition channelFeedImpressionLoggerPartDefinition, FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, VideoPrefetchPartDefinition videoPrefetchPartDefinition, Lazy<VideoSubtitlesPartDefinition> lazy, FlyoutEventBus flyoutEventBus, FeedEventBus feedEventBus, VideoLoggingPropertyBag videoLoggingPropertyBag) {
        super(channelFeedFullscreenPartDefinition, channelFeedImpressionLoggerPartDefinition, feedVideoPlayerParamBuilderProvider, videoPrefetchPartDefinition, lazy, flyoutEventBus, feedEventBus, videoLoggingPropertyBag);
    }

    public final boolean mo70a(Props props) {
        return props.f2535b.f2508j;
    }

    public static ChannelFeedReuseVideoPartDefinition m2342a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedReuseVideoPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2398d) {
                ChannelFeedReuseVideoPartDefinition channelFeedReuseVideoPartDefinition;
                if (a2 != null) {
                    channelFeedReuseVideoPartDefinition = (ChannelFeedReuseVideoPartDefinition) a2.a(f2398d);
                } else {
                    channelFeedReuseVideoPartDefinition = f2397c;
                }
                if (channelFeedReuseVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        c = m2343c(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2398d, c);
                        } else {
                            f2397c = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = channelFeedReuseVideoPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }

    public final void mo68a(Props props, VideoPlayerParams videoPlayerParams, E e, ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView) {
        RichVideoPlayer richVideoPlayer;
        ((HasVideoAutoplay) e).b(channelFeedVideoAttachmentView, props.f2535b.f2500b);
        InlineToChannelFeedTransitionManager inlineToChannelFeedTransitionManager = ((ChannelFeedEnvironment) e).f2139s;
        if (inlineToChannelFeedTransitionManager != null) {
            RichVideoPlayer richVideoPlayer2;
            if (inlineToChannelFeedTransitionManager.f2612e == null) {
                richVideoPlayer2 = null;
            } else {
                channelFeedVideoAttachmentView.a(inlineToChannelFeedTransitionManager.f2613f);
                if (!inlineToChannelFeedTransitionManager.f2618k) {
                    inlineToChannelFeedTransitionManager.f2618k = true;
                    List<RichVideoPlayerPlugin> additionalPlugins = channelFeedVideoAttachmentView.getAdditionalPlugins();
                    if (additionalPlugins != null) {
                        for (RichVideoPlayerPlugin a : additionalPlugins) {
                            inlineToChannelFeedTransitionManager.f2613f.a(a);
                        }
                    }
                }
                inlineToChannelFeedTransitionManager.f2613f.setPlayerType(channelFeedVideoAttachmentView.getPlayerType());
                richVideoPlayer2 = inlineToChannelFeedTransitionManager.f2613f;
            }
            richVideoPlayer = richVideoPlayer2;
        } else {
            channelFeedVideoAttachmentView.m2451a();
            richVideoPlayer = channelFeedVideoAttachmentView.getRichVideoPlayer();
        }
        richVideoPlayer.setPlayerOrigin(((ChannelFeedEnvironment) e).f2136p);
        channelFeedVideoAttachmentView.m2453a(videoPlayerParams, props.f2535b.m2432a(), props.f2534a, props.f2535b.m2434b(), (ChannelFeedEnvironment) e);
        this.f2387a.add(channelFeedVideoAttachmentView);
    }
}
