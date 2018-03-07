package com.facebook.feedplugins.attachments.video;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.videos.ui.Inline360VideoAttachmentView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.debug.fps.frameblame.AutoPlayVideoBlameMarker;
import com.facebook.debug.fps.frameblame.VideoBindBlameMarker;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.inlinevideoplayer.ScrollSpeedEstimator;
import com.facebook.feedplugins.attachments.video.VideoPrefetchPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.feed.FeedVideoPlayerParamBuilder;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.plugins.VideoVRCastPlugin;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.google.common.base.Absent;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: ufi/reactions/v2/16x16/confused */
public class Inline360VideoPartDefinition<E extends HasFeedListType & HasPersistentState & HasPrefetcher> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, Inline360VideoAttachmentView> {
    private static Inline360VideoPartDefinition f206l;
    private static final Object f207m = new Object();
    private final AutoplayVisibilityRunnableActivityListener f208a;
    private final VideoAutoplayVisibilityDecider f209b;
    private final VideoAutoPlaySettingsChecker f210c;
    private final VideoLoggingUtils f211d;
    private final AutoplayStateManagerProvider f212e;
    private final VideoAttachmentDelegateProvider f213f;
    private final FeedVideoPlayerParamBuilderProvider f214g;
    private final VideoPrefetchPartDefinition f215h;
    public final FrameRateBlameMarkers f216i;
    private final Provider<ScrollSpeedEstimator> f217j;
    private final VideoZeroDialogPartDefinition f218k;

    private static Inline360VideoPartDefinition m194b(InjectorLike injectorLike) {
        return new Inline360VideoPartDefinition(AutoplayVisibilityRunnableActivityListener.a(injectorLike), VideoAutoplayVisibilityDecider.a(injectorLike), VideoAutoPlaySettingsChecker.a(injectorLike), VideoLoggingUtils.a(injectorLike), (VideoAttachmentDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoAttachmentDelegateProvider.class), (FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), (AutoplayStateManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class), VideoPrefetchPartDefinition.m101a(injectorLike), FrameRateBlameMarkers.a(injectorLike), IdBasedProvider.a(injectorLike, 1746), VideoZeroDialogPartDefinition.m92a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m198a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1803133587);
        FeedProps feedProps = (FeedProps) obj;
        State state = (State) obj2;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        Inline360VideoAttachmentView inline360VideoAttachmentView = (Inline360VideoAttachmentView) view;
        this.f216i.c(VideoBindBlameMarker.c());
        inline360VideoAttachmentView.a(state.e, feedProps);
        if (!state.j) {
            inline360VideoAttachmentView.getRichVideoPlayer().v = new RVPListener(this, state);
        }
        state.c.a(inline360VideoAttachmentView);
        boolean a2 = VideoVRCastPlugin.a(inline360VideoAttachmentView.getContext().getPackageManager());
        state.f.e = TriState.valueOf(a2);
        state.f.b(false);
        state.l.d(inline360VideoAttachmentView);
        state.m = FeedAnalyticsUtil.a(hasFeedListType.c());
        if (state.h.d) {
            m196b(inline360VideoAttachmentView, state, this.f216i, state.h.c(), new PlayPosition(state.h.a(), state.h.a()));
        }
        Logger.a(8, EntryType.MARK_POP, -1234896763, a);
    }

    public final void m199b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        Inline360VideoAttachmentView inline360VideoAttachmentView = (Inline360VideoAttachmentView) view;
        boolean o = inline360VideoAttachmentView.getRichVideoPlayer().o();
        m193a(state, this.f216i);
        state.l.a();
        boolean a = VideoAutoplayVisibilityDecider.a(this.f209b.a(inline360VideoAttachmentView));
        InlineVideoPersistentState inlineVideoPersistentState = state.h;
        if (o && a) {
            a = true;
        } else {
            a = false;
        }
        inlineVideoPersistentState.d = a;
        if (o) {
            m195b(inline360VideoAttachmentView, state, this.f216i, state.h.c());
        }
    }

    public static Inline360VideoPartDefinition m192a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            Inline360VideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f207m) {
                Inline360VideoPartDefinition inline360VideoPartDefinition;
                if (a2 != null) {
                    inline360VideoPartDefinition = (Inline360VideoPartDefinition) a2.a(f207m);
                } else {
                    inline360VideoPartDefinition = f206l;
                }
                if (inline360VideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m194b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f207m, b3);
                        } else {
                            f206l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = inline360VideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public Inline360VideoPartDefinition(AutoplayVisibilityRunnableActivityListener autoplayVisibilityRunnableActivityListener, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils, VideoAttachmentDelegateProvider videoAttachmentDelegateProvider, FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, AutoplayStateManagerProvider autoplayStateManagerProvider, VideoPrefetchPartDefinition videoPrefetchPartDefinition, FrameRateBlameMarkers frameRateBlameMarkers, Provider<ScrollSpeedEstimator> provider, VideoZeroDialogPartDefinition videoZeroDialogPartDefinition) {
        this.f208a = autoplayVisibilityRunnableActivityListener;
        this.f209b = videoAutoplayVisibilityDecider;
        this.f210c = videoAutoPlaySettingsChecker;
        this.f211d = videoLoggingUtils;
        this.f213f = videoAttachmentDelegateProvider;
        this.f214g = feedVideoPlayerParamBuilderProvider;
        this.f215h = videoPrefetchPartDefinition;
        this.f212e = autoplayStateManagerProvider;
        this.f216i = frameRateBlameMarkers;
        this.f217j = provider;
        this.f218k = videoZeroDialogPartDefinition;
    }

    private State m191a(SubParts<E> subParts, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        subParts.a(this.f215h, new Props(feedProps, -1));
        FeedProps e2 = AttachmentProps.e(feedProps);
        Preconditions.checkNotNull(e2);
        VideoAttachmentDelegate a = this.f213f.a(feedProps, Absent.withType());
        GraphQLVideo c = a.c();
        FeedVideoPlayerParamBuilder a2 = this.f214g.m86a(feedProps, c);
        a.a(PlayerOrigin.FEED, (HasPrefetcher) e);
        GraphQLStory graphQLStory = (GraphQLStory) e2.a();
        InlineVideoPersistentState inlineVideoPersistentState = (InlineVideoPersistentState) ((HasPersistentState) e).a(new InlineVideoStoryKey(e2, c, this.f212e), graphQLStory);
        State state = new State(feedProps, graphQLStory, c, a, a2.a(), new VideoDisplayedInfo(), inlineVideoPersistentState.b(), inlineVideoPersistentState);
        if (!(state.e.s == null || state.e.s.b == null)) {
            state.f.a(state.e.s.b);
        }
        State.a(state, new Inline360AutoplayVisibilityRunnable(state, this.f208a, this.f209b, this.f210c, this.f211d, this.f216i, this.f217j));
        a.a(new FullscreenListener(this, state));
        subParts.a(this.f218k, new VideoZeroDialogPartDefinition.Props(new VideoPlayerOnClickListener(this, state)));
        return state;
    }

    private static void m193a(State state, FrameRateBlameMarkers frameRateBlameMarkers) {
        if (state.k) {
            state.k = false;
            frameRateBlameMarkers.b(AutoPlayVideoBlameMarker.c());
        }
    }

    public static void m196b(Inline360VideoAttachmentView inline360VideoAttachmentView, State state, FrameRateBlameMarkers frameRateBlameMarkers, EventTriggerType eventTriggerType, PlayPosition playPosition) {
        if (!state.k) {
            state.k = true;
            frameRateBlameMarkers.a(AutoPlayVideoBlameMarker.c());
        }
        state.h.e = eventTriggerType;
        inline360VideoAttachmentView.getRichVideoPlayer().setOriginalPlayReason(eventTriggerType);
        inline360VideoAttachmentView.getRichVideoPlayer().setPlayerOrigin(state.m);
        if (inline360VideoAttachmentView.e) {
            if (eventTriggerType != EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION) {
                inline360VideoAttachmentView.b.a(playPosition.c, eventTriggerType);
            }
            inline360VideoAttachmentView.b.a(eventTriggerType, playPosition.d);
        }
    }

    public static void m195b(Inline360VideoAttachmentView inline360VideoAttachmentView, State state, FrameRateBlameMarkers frameRateBlameMarkers, EventTriggerType eventTriggerType) {
        m193a(state, frameRateBlameMarkers);
        if (inline360VideoAttachmentView.getRichVideoPlayer().m()) {
            state.h.a(inline360VideoAttachmentView.getRichVideoPlayer().getCurrentPositionMs());
        }
        if (inline360VideoAttachmentView.e) {
            inline360VideoAttachmentView.getRichVideoPlayer().b(eventTriggerType);
        }
    }
}
