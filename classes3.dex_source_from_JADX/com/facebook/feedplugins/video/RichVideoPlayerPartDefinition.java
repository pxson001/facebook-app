package com.facebook.feedplugins.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.debug.fps.frameblame.AutoPlayVideoBlameMarker;
import com.facebook.debug.fps.frameblame.VideoBindBlameMarker;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ui.fullscreenvideoplayer.FeedFullScreenVideoElapsedMonitor;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.feed.ui.inlinevideoplayer.ScrollSpeedEstimator;
import com.facebook.feed.util.composer.InlineCommentComposerCache;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.video.FeedFullScreenParams;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feedplugins.attachments.video.AutoplayVisibilityRunnableActivityListener;
import com.facebook.feedplugins.attachments.video.ChannelFeedEligibilityUtil;
import com.facebook.feedplugins.attachments.video.FeedAnalyticsUtil;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.attachments.video.InlineVideoStoryKey;
import com.facebook.feedplugins.attachments.video.LegacyFullscreenTransitionListener;
import com.facebook.feedplugins.attachments.video.LegacyFullscreenTransitionListenerProvider;
import com.facebook.feedplugins.attachments.video.MultiRunnableAutoplayPartDefinition;
import com.facebook.feedplugins.attachments.video.SingleRunnableAutoplayPartDefinition;
import com.facebook.feedplugins.attachments.video.VideoAutoplayTransitionManager;
import com.facebook.feedplugins.attachments.video.VideoPrefetchPartDefinition;
import com.facebook.feedplugins.attachments.video.VideoPrefetchPartDefinition.Props;
import com.facebook.feedplugins.attachments.video.VideoSizer;
import com.facebook.feedplugins.attachments.video.VideoSizer.VideoSize;
import com.facebook.feedplugins.attachments.video.VideoSubtitlesPartDefinition;
import com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition;
import com.facebook.feedplugins.base.VideoRegistryPartDefinition;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
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
import com.facebook.photos.dialog.PhotoAnimationDialogFragment;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.abtest.AutoplayFeedRunnableConfig;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo.Builder;
import com.facebook.video.analytics.VideoTransitionPerfLogger;
import com.facebook.video.engine.NativePlayerPool;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPrepareController;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.NonVideoPlayerObscuredFragment;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.settings.AutoplayRolloutNuxHelper;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Provider;

@TargetApi(14)
@ContextScoped
/* compiled from: ufi/reactions/v2/face_models/wow */
public class RichVideoPlayerPartDefinition<E extends CanShowVideoInFullScreen & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher, V extends RichVideoAttachmentView> extends BaseSinglePartDefinition<Props, State, E, V> {
    private static RichVideoPlayerPartDefinition f57G;
    private static final Object f58H = new Object();
    private static final CallerContext f59a = CallerContext.a(RichVideoPlayerPartDefinition.class, "native_newsfeed");
    public static final ImmutableList<String> f60b = ImmutableList.of("chromeless:content:fragment:tag", "consumptionsnowflake:fragment:tag", PhotoAnimationDialogFragment.an, PhotoAnimationDialogFragment.am, PhotoAnimationDialogFragment.ap);
    private final VideoSizer f61A;
    private final DialtoneController f62B;
    private final ChannelFeedEligibilityUtil f63C;
    private final LegacyFullscreenTransitionListenerProvider f64D;
    private final InlineCommentComposerCache f65E;
    private final CallToActionUtil f66F;
    private final FeedVideoPlayerParamBuilderProvider f67c;
    private final Provider<Boolean> f68d;
    private final VideoAutoPlaySettingsChecker f69e;
    private final VideoLoggingUtils f70f;
    public final FrameRateBlameMarkers f71g;
    private final QeAccessor f72h;
    private final AutoplayStateManagerProvider f73i;
    private final AutoplayRolloutNuxHelper f74j;
    private final VideoAutoplayVisibilityDecider f75k;
    private final Provider<ScrollSpeedEstimator> f76l;
    private final VideoPrepareController f77m;
    public final VideoTransitionPerfLogger f78n;
    private final NativePlayerPool f79o;
    private final AutoplayVisibilityRunnableActivityListener f80p;
    private final FbDraweeControllerBuilder f81q;
    private final VideoPrefetchPartDefinition f82r;
    private final Lazy<VideoSubtitlesPartDefinition> f83s;
    private final SingleRunnableAutoplayPartDefinition<E, V> f84t;
    private final MultiRunnableAutoplayPartDefinition<E> f85u;
    private final VideoZeroDialogPartDefinition<V> f86v;
    private final VideoRegistryPartDefinition f87w;
    private final FeedImageLoader f88x;
    private final FeedFullScreenVideoElapsedMonitor f89y;
    private final FeedEventBus f90z;

    private static RichVideoPlayerPartDefinition m49b(InjectorLike injectorLike) {
        return new RichVideoPlayerPartDefinition((FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), IdBasedProvider.a(injectorLike, 3975), VideoAutoPlaySettingsChecker.a(injectorLike), VideoLoggingUtils.a(injectorLike), VideoAutoplayVisibilityDecider.a(injectorLike), IdBasedProvider.a(injectorLike, 1746), FrameRateBlameMarkers.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), VideoPrepareController.m87a(injectorLike), VideoTransitionPerfLogger.a(injectorLike), NativePlayerPool.a(injectorLike), (AutoplayStateManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class), AutoplayRolloutNuxHelper.m90a(injectorLike), FbDraweeControllerBuilder.a(injectorLike), AutoplayVisibilityRunnableActivityListener.a(injectorLike), VideoZeroDialogPartDefinition.m92a(injectorLike), VideoRegistryPartDefinition.m98a(injectorLike), VideoPrefetchPartDefinition.m101a(injectorLike), IdBasedLazy.a(injectorLike, 1816), FeedImageLoader.a(injectorLike), FeedFullScreenVideoElapsedMonitor.a(injectorLike), FeedEventBus.a(injectorLike), VideoSizer.m108a(injectorLike), SingleRunnableAutoplayPartDefinition.m115a(injectorLike), MultiRunnableAutoplayPartDefinition.m120a(injectorLike), (DialtoneController) DialtoneControllerImpl.a(injectorLike), ChannelFeedEligibilityUtil.a(injectorLike), (LegacyFullscreenTransitionListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LegacyFullscreenTransitionListenerProvider.class), InlineCommentComposerCache.a(injectorLike), CallToActionUtil.a(injectorLike));
    }

    public static RichVideoPlayerPartDefinition m43a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichVideoPlayerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f58H) {
                RichVideoPlayerPartDefinition richVideoPlayerPartDefinition;
                if (a2 != null) {
                    richVideoPlayerPartDefinition = (RichVideoPlayerPartDefinition) a2.a(f58H);
                } else {
                    richVideoPlayerPartDefinition = f57G;
                }
                if (richVideoPlayerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m49b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f58H, b3);
                        } else {
                            f57G = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richVideoPlayerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final /* bridge */ /* synthetic */ void m55a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1263295774);
        m47a((Props) obj, (State) obj2, (RichVideoAttachmentView) view);
        Logger.a(8, EntryType.MARK_POP, 1968133531, a);
    }

    public final void m56b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        RichVideoAttachmentView richVideoAttachmentView = (RichVideoAttachmentView) view;
        state.a = null;
        if (!m52b(richVideoAttachmentView)) {
            RichVideoPlayer richVideoPlayer = richVideoAttachmentView.getRichVideoPlayer();
            boolean o = richVideoPlayer.o();
            boolean a = VideoAutoplayVisibilityDecider.a(this.f75k.a(richVideoPlayer));
            InlineVideoPersistentState inlineVideoPersistentState = state.j;
            if (o && a) {
                a = true;
            } else {
                a = false;
            }
            inlineVideoPersistentState.d = a;
            if (!state.s.a && o) {
                m50b(richVideoPlayer, state, this.f71g, state.j.c());
            }
            richVideoPlayer.v = null;
        }
    }

    @Inject
    public RichVideoPlayerPartDefinition(FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, Provider<Boolean> provider, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider, Provider<ScrollSpeedEstimator> provider2, FrameRateBlameMarkers frameRateBlameMarkers, QeAccessor qeAccessor, VideoPrepareController videoPrepareController, VideoTransitionPerfLogger videoTransitionPerfLogger, NativePlayerPool nativePlayerPool, AutoplayStateManagerProvider autoplayStateManagerProvider, AutoplayRolloutNuxHelper autoplayRolloutNuxHelper, FbDraweeControllerBuilder fbDraweeControllerBuilder, AutoplayVisibilityRunnableActivityListener autoplayVisibilityRunnableActivityListener, VideoZeroDialogPartDefinition videoZeroDialogPartDefinition, VideoRegistryPartDefinition videoRegistryPartDefinition, VideoPrefetchPartDefinition videoPrefetchPartDefinition, Lazy<VideoSubtitlesPartDefinition> lazy, FeedImageLoader feedImageLoader, FeedFullScreenVideoElapsedMonitor feedFullScreenVideoElapsedMonitor, FeedEventBus feedEventBus, VideoSizer videoSizer, SingleRunnableAutoplayPartDefinition singleRunnableAutoplayPartDefinition, MultiRunnableAutoplayPartDefinition multiRunnableAutoplayPartDefinition, DialtoneController dialtoneController, ChannelFeedEligibilityUtil channelFeedEligibilityUtil, LegacyFullscreenTransitionListenerProvider legacyFullscreenTransitionListenerProvider, InlineCommentComposerCache inlineCommentComposerCache, CallToActionUtil callToActionUtil) {
        this.f67c = feedVideoPlayerParamBuilderProvider;
        this.f68d = provider;
        this.f69e = videoAutoPlaySettingsChecker;
        this.f70f = videoLoggingUtils;
        this.f75k = videoAutoplayVisibilityDecider;
        this.f76l = provider2;
        this.f71g = frameRateBlameMarkers;
        this.f72h = qeAccessor;
        this.f77m = videoPrepareController;
        this.f78n = videoTransitionPerfLogger;
        this.f79o = nativePlayerPool;
        this.f73i = autoplayStateManagerProvider;
        this.f74j = autoplayRolloutNuxHelper;
        this.f81q = fbDraweeControllerBuilder;
        this.f80p = autoplayVisibilityRunnableActivityListener;
        this.f86v = videoZeroDialogPartDefinition;
        this.f87w = videoRegistryPartDefinition;
        this.f82r = videoPrefetchPartDefinition;
        this.f83s = lazy;
        this.f84t = singleRunnableAutoplayPartDefinition;
        this.f85u = multiRunnableAutoplayPartDefinition;
        this.f88x = feedImageLoader;
        this.f89y = feedFullScreenVideoElapsedMonitor;
        this.f90z = feedEventBus;
        this.f61A = videoSizer;
        this.f62B = dialtoneController;
        this.f63C = channelFeedEligibilityUtil;
        this.f64D = legacyFullscreenTransitionListenerProvider;
        this.f65E = inlineCommentComposerCache;
        this.f66F = callToActionUtil;
    }

    private State m42a(SubParts<E> subParts, Props props, E e) {
        TracerDetour.a("RichVideoPlayerPartDefinition.prepare", -1729742183);
        try {
            PlayerOrigin a;
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) props.a.a();
            FeedProps e2 = AttachmentProps.e(props.a);
            Preconditions.checkNotNull(e2);
            GraphQLStory graphQLStory = (GraphQLStory) e2.a();
            if (props.e == null) {
                a = FeedAnalyticsUtil.a(((HasFeedListType) e).c());
            } else {
                a = props.e;
            }
            GraphQLVideo b = GraphQLMediaConversionHelper.m236b(graphQLStoryAttachment.r());
            VideoPlayerParams a2 = this.f67c.m86a(props.a, b).a();
            GraphQLMedia r = graphQLStoryAttachment.r();
            VideoSize a3 = m40a(props);
            boolean p = StoryProps.p(e2);
            ImageRequest a4 = FeedImageLoader.a(this.f88x.a(r, a3.a, FeedImageType.Video));
            InlineVideoStoryKey inlineVideoStoryKey = new InlineVideoStoryKey(e2, b, this.f73i);
            InlineVideoPersistentState inlineVideoPersistentState = (InlineVideoPersistentState) ((HasPersistentState) e).a(inlineVideoStoryKey, graphQLStory);
            inlineVideoPersistentState.b().a(b);
            VideoFeedStoryInfo a5 = new Builder(TrackableFeedProps.a(e2)).a(p).a(this.f63C.a(props.a, ((HasFeedListType) e).c().a())).a(inlineVideoPersistentState.c()).a();
            FeedFullScreenParams feedFullScreenParams = new FeedFullScreenParams(new VideoAnalyticsRequiredInfo.Builder(b.J()).a(), a5, a4, b, props.a);
            feedFullScreenParams.a(a);
            AutoplayFeedRunnableConfig autoplayFeedRunnableConfig = new AutoplayFeedRunnableConfig(this.f72h);
            ImmutableMap.Builder builder = ImmutableMap.builder();
            ImageRequest a6 = m44a(graphQLStoryAttachment);
            builder.b("GraphQLStoryProps", AttachmentProps.e(props.a)).b("SubtitlesLocalesKey", b.bo()).b("ShowDeleteOptionKey", Boolean.valueOf(b.u()));
            if (a6 != null) {
                builder.b("CoverImageParamsKey", a6);
            }
            if (a3.d > 0) {
                builder.b("VideoAspectRatioKey", Double.valueOf(((double) a3.a) / ((double) a3.d)));
            }
            a6 = m45a(b);
            if (a6 != null) {
                builder.b("BlurredCoverImageParamsKey", a6);
            }
            GraphQLVideo graphQLVideo = b;
            VideoFeedStoryInfo videoFeedStoryInfo = a5;
            State state = new State(graphQLStoryAttachment, e2, graphQLVideo, ((Boolean) this.f68d.get()).booleanValue(), a, videoFeedStoryInfo, new RichVideoPlayerParams.Builder().a(a2).a(builder.b()).b(), inlineVideoPersistentState.b(), inlineVideoPersistentState, new 1(this, inlineVideoPersistentState, e, props), a4, feedFullScreenParams, a3, autoplayFeedRunnableConfig);
            State.a(state, new FullscreenListener(state, this.f71g, this.f70f, this.f89y, this.f90z, props.c, this.f66F));
            LegacyFullscreenTransitionListener a7 = this.f64D.m125a(props.a, m41a(state, (HasInvalidate) e), (HasInvalidate) e);
            state.u.a(a7);
            props.d.set(a7);
            m48a(a2, state.i);
            m46a((CanShowVideoInFullScreen) e, a4);
            subParts.a(this.f82r, new Props(props.a, props.b));
            if (autoplayFeedRunnableConfig.a()) {
                subParts.a(this.f84t, new SingleRunnableAutoplayPartDefinition.Props(inlineVideoStoryKey, graphQLStory, state.k, a2, State.a(state), State.h(state), new 2(this)));
            } else {
                subParts.a(this.f85u, new MultiRunnableAutoplayPartDefinition.Props(new InlineAutoplayVisibilityRunnable(state, this.f75k, this.f76l, this.f69e, this.f70f, this.f71g, this.f74j, this.f80p, autoplayFeedRunnableConfig.b()), inlineVideoStoryKey, graphQLStory, graphQLStoryAttachment));
            }
            subParts.a((SinglePartDefinition) this.f83s.get(), new VideoSubtitlesPartDefinition.Props(a2.b, state.e.bo()));
            SubParts<E> subParts2 = subParts;
            subParts2.a(this.f86v, new VideoZeroDialogPartDefinition.Props(new VideoPlayerOnClickListener(this, state, this.f71g, e), Functions.identity()));
            subParts.a(this.f87w, state.b);
            return state;
        } finally {
            TracerDetour.a(-77517209);
        }
    }

    @VisibleForTesting
    private void m48a(VideoPlayerParams videoPlayerParams, AutoplayStateManager autoplayStateManager) {
        if (this.f77m.m89a(autoplayStateManager.k())) {
            this.f79o.a(videoPlayerParams.b, videoPlayerParams);
        }
    }

    @VisibleForTesting
    private static void m46a(E e, ImageRequest imageRequest) {
        ((HasPrefetcher) e).a(imageRequest, f59a);
    }

    private VideoSize m40a(Props props) {
        if (!props.c.isPresent()) {
            return this.f61A.m113b(props.a, 0.0f);
        }
        VideoSizeAndBackgroundOverride videoSizeAndBackgroundOverride = (VideoSizeAndBackgroundOverride) props.c.get();
        return new VideoSize(videoSizeAndBackgroundOverride.a, videoSizeAndBackgroundOverride.b, videoSizeAndBackgroundOverride.a, videoSizeAndBackgroundOverride.b, 0);
    }

    private void m47a(Props props, State state, V v) {
        TracerDetour.a("RichVideoPlayerPartDefinition.bind", 1269074854);
        try {
            RichVideoPlayer richVideoPlayer = v.getRichVideoPlayer();
            state.u.a(richVideoPlayer);
            state.a = v;
            if (!m52b((RichVideoAttachmentView) v)) {
                int e;
                RichVideoPlayer a = v.getPluginSelector().a(richVideoPlayer, state.h, null);
                a.setShouldCropToFit(true);
                this.f71g.c(VideoBindBlameMarker.c());
                LayoutParams layoutParams = a.getLayoutParams();
                layoutParams.width = state.p.a;
                if (this.f62B.j()) {
                    e = this.f62B.e();
                } else {
                    e = state.p.b;
                }
                layoutParams.height = e;
                a.setLayoutParams(layoutParams);
                FbDraweeView coverImage = v.getRichVideoPlayer().getCoverImage();
                ((FbDraweeControllerBuilder) this.f81q.a(f59a).b(coverImage.getController())).c(state.n);
                coverImage.setController(this.f81q.s());
                v.getRichVideoPlayer().setBackgroundResource(m39a(props.c));
                a.setPlayerOrigin(state.f);
                a.setChannelEligibility(ChannelEligibility.NO_INFO);
                if (!(state.h.a.b == null || state.h.a.b.equals(a.getVideoId()))) {
                    if (a.m()) {
                        a.b(EventTriggerType.BY_PLAYER);
                    }
                    a.g();
                }
                a.a(state.h);
                a.setRichVideoPlayerCallbackListener(state.m);
                State.a(state, m52b((RichVideoAttachmentView) v));
                state.k.b(false);
                if (state.j.e()) {
                    m53c(state, EventTriggerType.UNSET);
                }
                if (!state.s.a() && state.j.g()) {
                    m51b(a, state, this.f71g, state.j.c(), new PlayPosition(state.j.a(), state.j.a()));
                }
                TracerDetour.a(1368559927);
            }
        } finally {
            TracerDetour.a(398587941);
        }
    }

    public static int m39a(Optional<VideoSizeAndBackgroundOverride> optional) {
        if (optional.isPresent()) {
            return ((VideoSizeAndBackgroundOverride) optional.get()).c;
        }
        return 0;
    }

    private RichVideoAutoplayTransitionManager m41a(State state, HasInvalidate hasInvalidate) {
        Preconditions.checkNotNull(state);
        Preconditions.checkNotNull(state.j);
        VideoAutoplayTransitionManager videoAutoplayTransitionManager = (RichVideoAutoplayTransitionManager) state.j.g;
        if (videoAutoplayTransitionManager == null) {
            videoAutoplayTransitionManager = new RichVideoAutoplayTransitionManager(state, hasInvalidate, this.f65E);
        } else {
            Preconditions.checkNotNull(state);
            videoAutoplayTransitionManager.c = state;
        }
        state.j.g = videoAutoplayTransitionManager;
        return videoAutoplayTransitionManager;
    }

    public static void m51b(RichVideoPlayer richVideoPlayer, State state, FrameRateBlameMarkers frameRateBlameMarkers, EventTriggerType eventTriggerType, PlayPosition playPosition) {
        boolean z = true;
        if (!state.q) {
            state.q = true;
            frameRateBlameMarkers.a(AutoPlayVideoBlameMarker.c());
        }
        if (state.j.c().equals(EventTriggerType.UNSET) && (EventTriggerType.BY_AUTOPLAY.equals(eventTriggerType) || EventTriggerType.BY_USER.equals(eventTriggerType))) {
            m53c(state, eventTriggerType);
        }
        if (state.g != null) {
            richVideoPlayer.setOriginalPlayReason(state.g.b);
            richVideoPlayer.setChannelEligibility(state.g.c);
        }
        if (state.d) {
            z = false;
        }
        richVideoPlayer.a(z, EventTriggerType.BY_PLAYER);
        if (eventTriggerType != EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION) {
            richVideoPlayer.a(playPosition.c, eventTriggerType);
        }
        richVideoPlayer.a(eventTriggerType, playPosition.d);
    }

    public static void m50b(RichVideoPlayer richVideoPlayer, State state, FrameRateBlameMarkers frameRateBlameMarkers, EventTriggerType eventTriggerType) {
        if (state.q) {
            state.q = false;
            frameRateBlameMarkers.b(AutoPlayVideoBlameMarker.c());
        }
        if (richVideoPlayer.m() && richVideoPlayer.getCurrentPositionMs() > 0) {
            state.j.a(richVideoPlayer.getCurrentPositionMs());
        }
        richVideoPlayer.b(eventTriggerType);
    }

    public static void m53c(State state, EventTriggerType eventTriggerType) {
        state.g.b = eventTriggerType;
        state.j.e = eventTriggerType;
    }

    private static ImageRequest m44a(GraphQLStoryAttachment graphQLStoryAttachment) {
        Preconditions.checkNotNull(graphQLStoryAttachment);
        return (graphQLStoryAttachment.r() == null || !GraphQLStoryAttachmentUtil.p(graphQLStoryAttachment) || graphQLStoryAttachment.r().S() == null) ? null : ImageRequest.a(graphQLStoryAttachment.r().S().b());
    }

    private static ImageRequest m45a(GraphQLVideo graphQLVideo) {
        Preconditions.checkNotNull(graphQLVideo);
        return graphQLVideo.bF() != null ? ImageRequest.a(graphQLVideo.bF().b()) : null;
    }

    public static boolean m52b(RichVideoAttachmentView richVideoAttachmentView) {
        boolean h;
        Preconditions.checkNotNull(richVideoAttachmentView);
        FullScreenVideoPlayerHost fullScreenVideoPlayerHost = (FullScreenVideoPlayerHost) ContextUtils.a(richVideoAttachmentView.getContext(), FullScreenVideoPlayerHost.class);
        if (fullScreenVideoPlayerHost != null) {
            h = fullScreenVideoPlayerHost.h();
        } else {
            h = false;
        }
        if (!h) {
            Object obj;
            RichVideoPlayer richVideoPlayer = richVideoAttachmentView.getRichVideoPlayer();
            if (richVideoPlayer == null) {
                obj = null;
            } else {
                FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(richVideoPlayer.getContext(), FragmentManagerHost.class);
                if (fragmentManagerHost == null || fragmentManagerHost.kO_() == null) {
                    obj = null;
                } else {
                    FragmentManager kO_ = fragmentManagerHost.kO_();
                    int size = f60b.size();
                    int i = 0;
                    while (i < size) {
                        Fragment a = kO_.a((String) f60b.get(i));
                        if (a == null || !a.z() || a.T == null || (a instanceof NonVideoPlayerObscuredFragment)) {
                            i++;
                        } else {
                            obj = a.T.findViewById(richVideoPlayer.getId()) == null ? 1 : null;
                        }
                    }
                    obj = null;
                }
            }
            if (obj == null) {
                return false;
            }
        }
        return true;
    }
}
