package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ui.inlinevideoplayer.plugins.HasLiveStatusPoller;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feedplugins.attachments.video.ChannelFeedEligibilityUtil;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.VideoHomeAnalyticsAttributes;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo.Builder;
import com.facebook.video.analytics.VideoLoggingPropertyBag;
import com.facebook.video.channelfeed.ChannelFeedAdditionalRichVideoPlayerParamsBuilder;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.AnyPlayerEnvironment;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;
import com.facebook.video.videohome.environment.CanKnowPosition;
import com.facebook.video.videohome.environment.HasVideoHomePersistentState;
import com.facebook.video.videohome.environment.VideoHomeStoryPersistentState;
import com.facebook.video.videohome.partdefinitions.VideoHomeAutoplayPartDefinition.Props;
import com.facebook.video.videohome.plugins.VideoHomePlayerPluginSelector;
import com.facebook.video.videohome.views.VideoHomeVideoPlayerView;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: signInResultData */
public class VideoHomeVideoPlayerPartDefinition<E extends HasVideoHomePersistentState & HasFeedListType & HasLiveStatusPoller & HasFeedMenuHelper & CanKnowPosition> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, VideoHomeVideoPlayerView> {
    public static final ViewType<VideoHomeVideoPlayerView> f3262a = new C03001();
    private static VideoHomeVideoPlayerPartDefinition f3263h;
    private static final Object f3264i = new Object();
    private final FeedVideoPlayerParamBuilderProvider f3265b;
    private final VideoHomeAutoplayPartDefinition f3266c;
    private final ChannelFeedEligibilityUtil f3267d;
    private final VideoLoggingPropertyBag f3268e;
    private final VideoAutoplayVisibilityDecider f3269f;
    private final ChannelFeedAdditionalRichVideoPlayerParamsBuilder f3270g;

    /* compiled from: signInResultData */
    final class C03001 extends ViewType<VideoHomeVideoPlayerView> {
        C03001() {
        }

        public final View m3101a(Context context) {
            return new VideoHomeVideoPlayerView(context);
        }
    }

    /* compiled from: signInResultData */
    public class State {
        public final RichVideoPlayerCallbackListener f3257a;
        public final String f3258b;
        public final VideoHomeStoryPersistentState f3259c;
        public final RichVideoPlayerParams f3260d;
        public final PlayPosition f3261e;

        public State(RichVideoPlayerCallbackListener richVideoPlayerCallbackListener, String str, VideoHomeStoryPersistentState videoHomeStoryPersistentState, RichVideoPlayerParams richVideoPlayerParams, PlayPosition playPosition) {
            this.f3257a = richVideoPlayerCallbackListener;
            this.f3258b = str;
            this.f3259c = videoHomeStoryPersistentState;
            this.f3260d = richVideoPlayerParams;
            this.f3261e = playPosition;
        }
    }

    private static VideoHomeVideoPlayerPartDefinition m3112b(InjectorLike injectorLike) {
        return new VideoHomeVideoPlayerPartDefinition((FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), VideoHomeAutoplayPartDefinition.m2896a(injectorLike), ChannelFeedEligibilityUtil.a(injectorLike), VideoLoggingPropertyBag.a(injectorLike), VideoAutoplayVisibilityDecider.a(injectorLike), ChannelFeedAdditionalRichVideoPlayerParamsBuilder.m2099b(injectorLike));
    }

    public static VideoHomeVideoPlayerPartDefinition m3107a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeVideoPlayerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3264i) {
                VideoHomeVideoPlayerPartDefinition videoHomeVideoPlayerPartDefinition;
                if (a2 != null) {
                    videoHomeVideoPlayerPartDefinition = (VideoHomeVideoPlayerPartDefinition) a2.a(f3264i);
                } else {
                    videoHomeVideoPlayerPartDefinition = f3263h;
                }
                if (videoHomeVideoPlayerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3112b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3264i, b3);
                        } else {
                            f3263h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeVideoPlayerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final /* bridge */ /* synthetic */ void m3115a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -202614082);
        State state = (State) obj2;
        HasVideoHomePersistentState hasVideoHomePersistentState = (HasVideoHomePersistentState) anyEnvironment;
        view = (VideoHomeVideoPlayerView) view;
        if (!(m3110a(view) || m3109a(view.getContext()))) {
            RichVideoPlayer richVideoPlayer = view.getRichVideoPlayer();
            m3108a(richVideoPlayer, state.f3258b, state.f3257a, hasVideoHomePersistentState, view.f3364b, state.f3260d);
            if (state.f3259c.f2891e) {
                EventTriggerType c = state.f3259c.m2795c();
                PlayPosition playPosition = state.f3261e;
                if (c != EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION) {
                    richVideoPlayer.a(playPosition.c, c);
                }
                richVideoPlayer.a(c, playPosition.d);
            }
        }
        Logger.a(8, EntryType.MARK_POP, 150747619, a);
    }

    public final void m3117b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        view = (VideoHomeVideoPlayerView) view;
        if (!m3110a(view) && !m3109a(view.getContext())) {
            RichVideoPlayer richVideoPlayer = view.getRichVideoPlayer();
            boolean o = richVideoPlayer.o();
            boolean a = VideoAutoplayVisibilityDecider.a(this.f3269f.a(view));
            VideoHomeStoryPersistentState videoHomeStoryPersistentState = state.f3259c;
            if (o && a) {
                a = true;
            } else {
                a = false;
            }
            videoHomeStoryPersistentState.f2891e = a;
            if (o) {
                if (richVideoPlayer.m() && richVideoPlayer.getCurrentPositionMs() > 0) {
                    state.f3259c.m2793a(richVideoPlayer.getCurrentPositionMs());
                }
                richVideoPlayer.b(state.f3259c.m2795c());
            }
        }
    }

    @Inject
    public VideoHomeVideoPlayerPartDefinition(FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, VideoHomeAutoplayPartDefinition videoHomeAutoplayPartDefinition, ChannelFeedEligibilityUtil channelFeedEligibilityUtil, VideoLoggingPropertyBag videoLoggingPropertyBag, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider, ChannelFeedAdditionalRichVideoPlayerParamsBuilder channelFeedAdditionalRichVideoPlayerParamsBuilder) {
        this.f3265b = feedVideoPlayerParamBuilderProvider;
        this.f3266c = videoHomeAutoplayPartDefinition;
        this.f3267d = channelFeedEligibilityUtil;
        this.f3268e = videoLoggingPropertyBag;
        this.f3269f = videoAutoplayVisibilityDecider;
        this.f3270g = channelFeedAdditionalRichVideoPlayerParamsBuilder;
    }

    public final ViewType<VideoHomeVideoPlayerView> m3113a() {
        return f3262a;
    }

    public static boolean m3111a(ReactionUnitComponentNode reactionUnitComponentNode) {
        if (reactionUnitComponentNode.b == null) {
            return false;
        }
        GraphQLStory ax = reactionUnitComponentNode.b.ax();
        if (ax == null) {
            return false;
        }
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(ax);
        if (o == null) {
            return false;
        }
        GraphQLMedia r = o.r();
        Object obj = (r == null || r.j() == null || r.j().g() != 82650203) ? null : 1;
        if (obj != null) {
            return true;
        }
        return false;
    }

    private State m3106a(SubParts<E> subParts, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        GraphQLStory ax = reactionUnitComponentNode.f().ax();
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(ax);
        FeedProps c = FeedProps.c(ax);
        FeedProps a = c.a(o);
        GraphQLVideo b = GraphQLMediaConversionHelper.b(o.r());
        String k = reactionUnitComponentNode.k();
        VideoHomeStoryPersistentState a2 = e.a(c, k);
        a2.m2794b().a(b);
        boolean p = StoryProps.p(c);
        VideoPlayerParams a3 = this.f3265b.a(a, b).a();
        ArrayNode a4 = TrackableFeedProps.a(c);
        ChannelEligibility a5 = this.f3267d.a(a, ((HasFeedListType) e).c().a());
        Builder builder = new Builder(a4);
        builder.d = p;
        Builder builder2 = builder;
        builder2.c = a5;
        subParts.a(this.f3266c, new Props(c, new VideoDisplayedInfo(), a3, builder2.a(), PlayerOrigin.VIDEO_HOME, k));
        String J = b.J();
        String V = reactionUnitComponentNode.f().V();
        if (J != null) {
            this.f3268e.a(J, VideoHomeAnalyticsAttributes.REACTION_COMPONENT_TRACKING_FIELD.value, V);
            this.f3268e.a(J, VideoHomeAnalyticsAttributes.REACTION_UNIT_TYPE.value, reactionUnitComponentNode.l());
            if (b.aj()) {
                this.f3268e.a(J, VideoHomeAnalyticsAttributes.BROADCAST_STATUS_FIELD.value, b.t().toString());
            }
            int a6 = ((CanKnowPosition) e).a(reactionUnitComponentNode.k());
            this.f3268e.a(J, VideoHomeAnalyticsAttributes.UNIT_POSITION.value, Integer.valueOf(a6));
            if (ax != null) {
                int a7 = ((CanKnowPosition) e).a(a6, ax.g());
                if (a7 >= 0) {
                    this.f3268e.a(J, VideoHomeAnalyticsAttributes.POSITION_IN_UNIT.value, Integer.valueOf(a7));
                }
                this.f3268e.a(J, VideoHomeAnalyticsAttributes.TARGET_ID.value, ax.c());
            }
            this.f3268e.a(J, VideoHomeAnalyticsAttributes.EVENT_TARGET.value, "story");
        }
        ImmutableMap b2 = this.f3270g.m2100a(AttachmentProps.e(a)).b("AutoplayStateManager", a2.m2794b()).b("HideOnReportKey", Boolean.valueOf(true)).b("IsSmallVideoKey", Boolean.valueOf(reactionUnitComponentNode.f().a() == GraphQLReactionUnitComponentStyle.VIDEO_CHANNEL_FEED_UNIT_SQUARE)).b("UnitComponentTokenKey", reactionUnitComponentNode.l()).b("UnitPositionKey", Integer.valueOf(((CanKnowPosition) e).a(reactionUnitComponentNode.k()))).b();
        RichVideoPlayerParams.Builder builder3 = new RichVideoPlayerParams.Builder();
        builder3.a = a3;
        return new State(m3105a(a2), a3.b, a2, builder3.a(b2).b(), new PlayPosition(a2.m2792a(), a2.m2792a()));
    }

    public static boolean m3109a(Context context) {
        FullScreenVideoPlayerHost fullScreenVideoPlayerHost = (FullScreenVideoPlayerHost) ContextUtils.a(context, FullScreenVideoPlayerHost.class);
        if (fullScreenVideoPlayerHost != null) {
            return fullScreenVideoPlayerHost.h();
        }
        return false;
    }

    public static boolean m3110a(View view) {
        if (Boolean.TRUE.equals(view.getTag(2131558601))) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (parent == null || (parent instanceof RecyclerView) || (parent instanceof AdapterView)) {
            return false;
        }
        return m3110a((View) parent);
    }

    private RichVideoPlayerCallbackListener m3105a(final VideoHomeStoryPersistentState videoHomeStoryPersistentState) {
        return new RichVideoPlayerCallbackListener(this) {
            final /* synthetic */ VideoHomeVideoPlayerPartDefinition f3256b;

            public final void m3104a(RVPStreamCompleteEvent rVPStreamCompleteEvent) {
                AutoplayStateManager b = videoHomeStoryPersistentState.m2794b();
                if (b != null) {
                    b.f();
                }
            }

            public final void m3102a() {
            }

            public final void m3103a(RVPErrorEvent rVPErrorEvent) {
                AutoplayStateManager b = videoHomeStoryPersistentState.m2794b();
                if (b != null) {
                    b.i();
                }
            }
        };
    }

    public static void m3108a(RichVideoPlayer richVideoPlayer, String str, RichVideoPlayerCallbackListener richVideoPlayerCallbackListener, E e, VideoHomePlayerPluginSelector videoHomePlayerPluginSelector, RichVideoPlayerParams richVideoPlayerParams) {
        richVideoPlayer.setPlayerOrigin(PlayerOrigin.VIDEO_HOME);
        if (!str.equals(richVideoPlayer.getVideoId())) {
            richVideoPlayer.g();
        }
        videoHomePlayerPluginSelector.a(richVideoPlayer, richVideoPlayerParams, (AnyPlayerEnvironment) e);
        richVideoPlayer.v = richVideoPlayerCallbackListener;
        richVideoPlayer.setShouldCropToFit(true);
        richVideoPlayer.a(richVideoPlayerParams);
    }
}
