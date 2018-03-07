package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.videos.ui.HasChannelFeedLauncherInfo;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.ChannelFeedEligibilityUtil;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.feedplugins.attachments.video.InlineVideoStoryKey;
import com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition;
import com.facebook.feedplugins.storyset.funnel.StorySetFunnelLogger;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.channelfeed.ChannelFeedParams.Builder;
import com.facebook.video.channelfeed.LaunchChannelFeedClickListenerProvider;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: audience_educator_controller_activity_result_missing_field */
public class VideoSetsChannelFeedLauncherPartDefinition<E extends HasFeedListType & HasPersistentState, V extends View & HasChannelFeedLauncherInfo> extends BaseSinglePartDefinition<Props, Void, E, V> {
    private static VideoSetsChannelFeedLauncherPartDefinition f9804f;
    private static final Object f9805g = new Object();
    public final StorySetFunnelLogger f9806a;
    private final LaunchChannelFeedClickListenerProvider f9807b;
    private final AutoplayStateManagerProvider f9808c;
    private final ChannelFeedEligibilityUtil f9809d;
    private final Lazy<VideoZeroDialogPartDefinition> f9810e;

    @Immutable
    /* compiled from: audience_educator_controller_activity_result_missing_field */
    public class Props {
        StorySetPageProps f9795a;
        AtomicReference<FullscreenTransitionListener> f9796b;
        int f9797c;
        HasChannelFeedLauncherInfo f9798d;

        public Props(StorySetPageProps storySetPageProps, AtomicReference<FullscreenTransitionListener> atomicReference, int i, HasChannelFeedLauncherInfo hasChannelFeedLauncherInfo) {
            this.f9795a = storySetPageProps;
            this.f9796b = atomicReference;
            this.f9797c = i;
            this.f9798d = hasChannelFeedLauncherInfo;
        }

        public Props(StorySetPageProps storySetPageProps, AtomicReference<FullscreenTransitionListener> atomicReference, int i) {
            this(storySetPageProps, atomicReference, i, null);
        }
    }

    /* compiled from: audience_educator_controller_activity_result_missing_field */
    class VideoSetsChannelFeedLauncherClickListener implements OnClickListener {
        final /* synthetic */ VideoSetsChannelFeedLauncherPartDefinition f9799a;
        private final GraphQLStorySet f9800b;
        private final int f9801c;
        private final int f9802d;
        private final OnClickListener f9803e;

        public VideoSetsChannelFeedLauncherClickListener(VideoSetsChannelFeedLauncherPartDefinition videoSetsChannelFeedLauncherPartDefinition, Props props, OnClickListener onClickListener) {
            this.f9799a = videoSetsChannelFeedLauncherPartDefinition;
            this.f9800b = (GraphQLStorySet) props.f9795a.f9732a.a;
            this.f9801c = props.f9797c;
            this.f9802d = props.f9795a.f9734c;
            this.f9803e = onClickListener;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -611676718);
            this.f9799a.f9806a.a(FunnelRegistry.A, this.f9800b, this.f9801c, "position:" + this.f9802d);
            this.f9803e.onClick(view);
            Logger.a(2, EntryType.UI_INPUT_END, 2086262777, a);
        }
    }

    private static VideoSetsChannelFeedLauncherPartDefinition m10226b(InjectorLike injectorLike) {
        return new VideoSetsChannelFeedLauncherPartDefinition(StorySetFunnelLogger.b(injectorLike), (LaunchChannelFeedClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LaunchChannelFeedClickListenerProvider.class), (AutoplayStateManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class), ChannelFeedEligibilityUtil.a(injectorLike), IdBasedLazy.a(injectorLike, 1817));
    }

    public final Object m10227a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        VideoStoryPersistentState videoStoryPersistentState;
        Props props = (Props) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        FeedProps feedProps = props.f9795a.f9733b;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        GraphQLVideo b = GraphQLMediaConversionHelper.b(StoryAttachmentHelper.o(graphQLStory).r());
        if (props.f9798d == null || props.f9798d.getVideoStoryPersistentState() == null) {
            videoStoryPersistentState = (VideoStoryPersistentState) ((HasPersistentState) hasFeedListType).a(new InlineVideoStoryKey(feedProps, b, this.f9808c), graphQLStory);
        } else {
            videoStoryPersistentState = props.f9798d.getVideoStoryPersistentState();
        }
        Builder builder = new Builder();
        builder.a = feedProps;
        builder = builder;
        builder.b = m10225a(props.f9795a);
        builder = builder;
        builder.d = ChannelFeedEligibilityUtil.a(hasFeedListType.c().a());
        builder = builder;
        builder.h = EventTriggerType.BY_USER;
        builder = builder;
        builder.g = PlayerOrigin.VIDEO_SETS;
        subParts.a((SinglePartDefinition) this.f9810e.get(), new com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition.Props(new VideoSetsChannelFeedLauncherClickListener(this, props, this.f9807b.a(builder.a(), videoStoryPersistentState, props.f9796b, props.f9798d, null))));
        return null;
    }

    private static List<FeedProps<GraphQLStory>> m10225a(StorySetPageProps storySetPageProps) {
        FeedProps feedProps = storySetPageProps.f9732a;
        ImmutableList b = StorySetHelper.b((GraphQLStorySet) feedProps.a);
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            builder.c(feedProps.a((GraphQLStory) b.get(i)));
        }
        return builder.b();
    }

    public static VideoSetsChannelFeedLauncherPartDefinition m10224a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoSetsChannelFeedLauncherPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9805g) {
                VideoSetsChannelFeedLauncherPartDefinition videoSetsChannelFeedLauncherPartDefinition;
                if (a2 != null) {
                    videoSetsChannelFeedLauncherPartDefinition = (VideoSetsChannelFeedLauncherPartDefinition) a2.a(f9805g);
                } else {
                    videoSetsChannelFeedLauncherPartDefinition = f9804f;
                }
                if (videoSetsChannelFeedLauncherPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10226b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9805g, b3);
                        } else {
                            f9804f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoSetsChannelFeedLauncherPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoSetsChannelFeedLauncherPartDefinition(StorySetFunnelLogger storySetFunnelLogger, LaunchChannelFeedClickListenerProvider launchChannelFeedClickListenerProvider, AutoplayStateManagerProvider autoplayStateManagerProvider, ChannelFeedEligibilityUtil channelFeedEligibilityUtil, Lazy<VideoZeroDialogPartDefinition> lazy) {
        this.f9806a = storySetFunnelLogger;
        this.f9807b = launchChannelFeedClickListenerProvider;
        this.f9808c = autoplayStateManagerProvider;
        this.f9809d = channelFeedEligibilityUtil;
        this.f9810e = lazy;
    }
}
