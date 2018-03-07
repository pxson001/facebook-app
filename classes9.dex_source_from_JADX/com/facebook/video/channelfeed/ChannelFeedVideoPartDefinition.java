package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.autoplay.HasVideoAutoplay;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedplugins.attachments.video.VideoPrefetchPartDefinition;
import com.facebook.feedplugins.attachments.video.VideoSubtitlesPartDefinition;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.HasFeedUnit;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnDismissEventSubscriber;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnResumeEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.ShareStoryPublishEventSubscriber;
import com.facebook.video.analytics.VideoAnalytics.VideoHomeAnalyticsAttributes;
import com.facebook.video.analytics.VideoLoggingPropertyBag;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sync_latest_user_info_fetch_action_id */
public class ChannelFeedVideoPartDefinition<E extends HasPersistentState & HasFullscreenPlayer & HasPlayerOrigin & HasFeedListType & HasVideoAutoplay<ChannelFeedVideoAttachmentView> & CanShowVideoInFullScreen> extends MultiRowSinglePartDefinition<Props, VideoPlayerParams, E, ChannelFeedVideoAttachmentView> {
    public static final ViewType f2384b = new C02324();
    private static ChannelFeedVideoPartDefinition f2385l;
    private static final Object f2386m = new Object();
    protected final List<ChannelFeedVideoAttachmentView> f2387a = new ArrayList();
    private final FlyoutOnResumeEventSubscriber f2388c = new C02291(this);
    private final FlyoutOnDismissEventSubscriber f2389d = new C02302(this);
    private final ShareStoryPublishEventSubscriber f2390e = new C02313(this);
    private final ChannelFeedFullscreenPartDefinition f2391f;
    private final ChannelFeedImpressionLoggerPartDefinition f2392g;
    private final FeedVideoPlayerParamBuilderProvider f2393h;
    private final VideoPrefetchPartDefinition f2394i;
    private final Lazy<VideoSubtitlesPartDefinition> f2395j;
    private final VideoLoggingPropertyBag f2396k;

    /* compiled from: sync_latest_user_info_fetch_action_id */
    class C02291 extends FlyoutOnResumeEventSubscriber {
        final /* synthetic */ ChannelFeedVideoPartDefinition f2531a;

        C02291(ChannelFeedVideoPartDefinition channelFeedVideoPartDefinition) {
            this.f2531a = channelFeedVideoPartDefinition;
        }

        public final void m2462b(FbEvent fbEvent) {
            for (ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView : this.f2531a.f2387a) {
                channelFeedVideoAttachmentView.f2522f.q();
            }
        }
    }

    /* compiled from: sync_latest_user_info_fetch_action_id */
    class C02302 extends FlyoutOnDismissEventSubscriber {
        final /* synthetic */ ChannelFeedVideoPartDefinition f2532a;

        C02302(ChannelFeedVideoPartDefinition channelFeedVideoPartDefinition) {
            this.f2532a = channelFeedVideoPartDefinition;
        }

        public final void m2463b(FbEvent fbEvent) {
            for (ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView : this.f2532a.f2387a) {
                channelFeedVideoAttachmentView.f2522f.r();
            }
        }
    }

    /* compiled from: sync_latest_user_info_fetch_action_id */
    class C02313 extends ShareStoryPublishEventSubscriber {
        final /* synthetic */ ChannelFeedVideoPartDefinition f2533a;

        C02313(ChannelFeedVideoPartDefinition channelFeedVideoPartDefinition) {
            this.f2533a = channelFeedVideoPartDefinition;
        }

        public final void m2464b(FbEvent fbEvent) {
            for (ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView : this.f2533a.f2387a) {
                channelFeedVideoAttachmentView.f2522f.s();
            }
        }
    }

    /* compiled from: sync_latest_user_info_fetch_action_id */
    final class C02324 extends ViewType {
        C02324() {
        }

        public final View m2465a(Context context) {
            return new ChannelFeedVideoAttachmentView(context);
        }
    }

    @Immutable
    /* compiled from: sync_latest_user_info_fetch_action_id */
    public final class Props implements HasFeedProps<GraphQLStory>, HasFeedUnit {
        public final FeedProps<GraphQLStoryAttachment> f2534a;
        public final ChannelFeedStoryPersistentState f2535b;

        public Props(FeedProps<GraphQLStoryAttachment> feedProps, ChannelFeedStoryPersistentState channelFeedStoryPersistentState) {
            this.f2534a = feedProps;
            this.f2535b = channelFeedStoryPersistentState;
        }

        public final FeedUnit m2466c() {
            return this.f2534a != null ? AttachmentProps.c(this.f2534a) : null;
        }

        public final FeedProps<GraphQLStory> m2467f() {
            return AttachmentProps.e(this.f2534a);
        }
    }

    private static ChannelFeedVideoPartDefinition m2333a(InjectorLike injectorLike) {
        return new ChannelFeedVideoPartDefinition(ChannelFeedFullscreenPartDefinition.m2211a(injectorLike), ChannelFeedImpressionLoggerPartDefinition.m2302a(injectorLike), (FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), VideoPrefetchPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 1816), FlyoutEventBus.a(injectorLike), FeedEventBus.a(injectorLike), VideoLoggingPropertyBag.a(injectorLike));
    }

    public final Object m2336a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        GraphQLVideo b = GraphQLMediaConversionHelper.b(((GraphQLStoryAttachment) props.f2534a.a).r());
        props.f2535b.m2434b().a(b);
        if (b.bp() != null) {
            this.f2396k.a(b.J(), VideoHomeAnalyticsAttributes.CHANNEL_ID.value, b.bp().k());
        }
        VideoPlayerParams a = this.f2393h.a(props.f2534a, b).a();
        subParts.a(this.f2391f, b.J());
        subParts.a(this.f2394i, new com.facebook.feedplugins.attachments.video.VideoPrefetchPartDefinition.Props(props.f2534a, -1));
        subParts.a((SinglePartDefinition) this.f2395j.get(), new com.facebook.feedplugins.attachments.video.VideoSubtitlesPartDefinition.Props(a.b, b.bo()));
        subParts.a(this.f2392g, new com.facebook.video.channelfeed.ChannelFeedImpressionLoggerPartDefinition.Props(b.J(), AttachmentProps.e(props.f2534a)));
        return a;
    }

    public final void m2341b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        this.f2387a.remove((ChannelFeedVideoAttachmentView) view);
    }

    public static ChannelFeedVideoPartDefinition m2334b(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedVideoPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f2386m) {
                ChannelFeedVideoPartDefinition channelFeedVideoPartDefinition;
                if (a3 != null) {
                    channelFeedVideoPartDefinition = (ChannelFeedVideoPartDefinition) a3.a(f2386m);
                } else {
                    channelFeedVideoPartDefinition = f2385l;
                }
                if (channelFeedVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        a2 = m2333a(injectorThreadStack.e());
                        if (a3 != null) {
                            a3.a(f2386m, a2);
                        } else {
                            f2385l = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = channelFeedVideoPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ChannelFeedVideoPartDefinition(ChannelFeedFullscreenPartDefinition channelFeedFullscreenPartDefinition, ChannelFeedImpressionLoggerPartDefinition channelFeedImpressionLoggerPartDefinition, FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, VideoPrefetchPartDefinition videoPrefetchPartDefinition, Lazy<VideoSubtitlesPartDefinition> lazy, FlyoutEventBus flyoutEventBus, FeedEventBus feedEventBus, VideoLoggingPropertyBag videoLoggingPropertyBag) {
        this.f2391f = channelFeedFullscreenPartDefinition;
        this.f2392g = channelFeedImpressionLoggerPartDefinition;
        this.f2393h = feedVideoPlayerParamBuilderProvider;
        this.f2394i = videoPrefetchPartDefinition;
        this.f2395j = lazy;
        this.f2396k = videoLoggingPropertyBag;
        flyoutEventBus.a(this.f2388c);
        flyoutEventBus.a(this.f2389d);
        feedEventBus.a(this.f2390e);
    }

    public final ViewType m2335a() {
        return f2384b;
    }

    public boolean mo70a(Props props) {
        return true;
    }

    public void mo68a(Props props, VideoPlayerParams videoPlayerParams, E e, ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView) {
        ((HasVideoAutoplay) e).b(channelFeedVideoAttachmentView, props.f2535b.f2500b);
        channelFeedVideoAttachmentView.m2451a();
        channelFeedVideoAttachmentView.getRichVideoPlayer().setPlayerOrigin(((ChannelFeedEnvironment) e).f2136p);
        channelFeedVideoAttachmentView.m2453a(videoPlayerParams, props.f2535b.m2432a(), props.f2534a, props.f2535b.m2434b(), (ChannelFeedEnvironment) e);
        this.f2387a.add(channelFeedVideoAttachmentView);
    }
}
