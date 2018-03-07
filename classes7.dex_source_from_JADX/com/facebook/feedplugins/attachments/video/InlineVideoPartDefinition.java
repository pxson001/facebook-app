package com.facebook.feedplugins.attachments.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.debug.fps.frameblame.AutoPlayVideoBlameMarker;
import com.facebook.debug.fps.frameblame.VideoBindBlameMarker;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.inlinevideoplayer.ScrollSpeedEstimator;
import com.facebook.feed.util.composer.InlineCommentComposerCache;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.video.util.VideoUtils;
import com.facebook.feedplugins.base.VideoRegistryPartDefinition;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
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
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo.Builder;
import com.facebook.video.analytics.VideoTransitionPerfLogger;
import com.facebook.video.engine.AbstractVideoPlayerListener;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.Constants.VideoMediaState;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.engine.NativePlayerPool;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerListener;
import com.facebook.video.engine.VideoPlayerManager;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPrepareController;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.BaseInlineVideoPlayer;
import com.facebook.video.player.InlineVideoPlayer;
import com.facebook.video.settings.AutoplayRolloutNuxHelper;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import javax.inject.Provider;

@TargetApi(14)
@ContextScoped
@Deprecated
/* compiled from: TEXT_EDIT */
public class InlineVideoPartDefinition<E extends CanShowVideoInFullScreen & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher, V extends InlineVideoAttachmentView> extends BaseSinglePartDefinition<Props, State, E, V> {
    private static InlineVideoPartDefinition f22806B;
    private static final Object f22807C = new Object();
    public static final ImmutableList<String> f22808a = ImmutableList.of("chromeless:content:fragment:tag", "consumptionsnowflake:fragment:tag", PhotoAnimationDialogFragment.an, PhotoAnimationDialogFragment.am, PhotoAnimationDialogFragment.ap);
    public final CallToActionUtil f22809A;
    private final VideoAttachmentDelegateProvider f22810b;
    private final FeedVideoPlayerParamBuilderProvider f22811c;
    private final Provider<Boolean> f22812d;
    private final VideoAutoPlaySettingsChecker f22813e;
    private final Lazy<VideoLoggingUtils> f22814f;
    private final FrameRateBlameMarkers f22815g;
    private final QeAccessor f22816h;
    private final AutoplayStateManagerProvider f22817i;
    private final AutoplayRolloutNuxHelper f22818j;
    private final VideoAutoplayVisibilityDecider f22819k;
    private final Provider<ScrollSpeedEstimator> f22820l;
    private final Lazy<VideoPrepareController> f22821m;
    public final VideoTransitionPerfLogger f22822n;
    private final NativePlayerPool f22823o;
    private final AutoplayVisibilityRunnableActivityListener f22824p;
    private final VideoPrefetchPartDefinition f22825q;
    private final Lazy<VideoSubtitlesPartDefinition> f22826r;
    private final SingleRunnableAutoplayPartDefinition<E, V> f22827s;
    private final MultiRunnableAutoplayPartDefinition<E> f22828t;
    private final Lazy<VideoZeroDialogPartDefinition> f22829u;
    private final LegacyInlineVideoPartDefinition f22830v;
    private final ChannelFeedEligibilityUtil f22831w;
    private final VideoRegistryPartDefinition f22832x;
    private final LegacyFullscreenTransitionListenerProvider f22833y;
    public final InlineCommentComposerCache f22834z;

    /* compiled from: TEXT_EDIT */
    class C19781 implements SingleRunnableAutoplayPartDefinition$VideoViewControllerProvider {
        final /* synthetic */ InlineVideoPartDefinition f22763a;

        C19781(InlineVideoPartDefinition inlineVideoPartDefinition) {
            this.f22763a = inlineVideoPartDefinition;
        }

        public final VideoViewController mo1571a(InlineVideoPersistentState inlineVideoPersistentState, VideoDisplayedInfo videoDisplayedInfo, VideoPlayerParams videoPlayerParams, VideoFeedStoryInfo videoFeedStoryInfo, PlayerOrigin playerOrigin, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils) {
            return new InlineVideoController(inlineVideoPersistentState, videoDisplayedInfo, videoPlayerParams, videoFeedStoryInfo, playerOrigin, videoAutoPlaySettingsChecker, videoLoggingUtils);
        }
    }

    /* compiled from: TEXT_EDIT */
    public class EndscreenReplayVideoOnClickListener implements OnClickListener {
        private final State f22764a;

        public EndscreenReplayVideoOnClickListener(State state) {
            this.f22764a = state;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1818194288);
            this.f22764a.f22789k.a = false;
            Preconditions.checkNotNull(this.f22764a.f22793o);
            this.f22764a.f22793o.f();
            this.f22764a.f22793o.getInlineVideoView().performClick();
            this.f22764a.f22793o.h();
            Logger.a(2, EntryType.UI_INPUT_END, 1075638560, a);
        }
    }

    /* compiled from: TEXT_EDIT */
    public class InlineAutoplayVisibilityRunnable extends AutoplayVisibilityRunnable<InlineVideoAttachmentView> {
        private final State f22765a;
        private final VideoAutoPlaySettingsChecker f22766b;
        private final VideoLoggingUtils f22767c;
        private final FrameRateBlameMarkers f22768d;
        private final AutoplayRolloutNuxHelper f22769e;

        private static boolean m25366c(InlineVideoAttachmentView inlineVideoAttachmentView) {
            return inlineVideoAttachmentView.a.k();
        }

        public final void m25367a(View view) {
            view = (InlineVideoAttachmentView) view;
            if (!InlineVideoPartDefinition.m25393b(view)) {
                this.f22765a.f22791m.clear();
                boolean a = this.f22765a.f22788j.a(this.f22765a.f22791m);
                if (!this.f22765a.f22790l.f) {
                    VideoUtils.a(this.f22765a.f22790l, this.f22765a.f22791m, this.f22766b, this.f22767c, this.f22765a.f22787i.e, this.f22765a.f22787i.b, this.f22765a.f22783e.k, this.f22765a.f22787i.f, this.f22765a.f22786h.c, this.f22765a.f22787i);
                }
                if (a) {
                    InlineVideoPartDefinition.m25387a(view, this.f22765a, this.f22768d, EventTriggerType.BY_AUTOPLAY, new PlayPosition(this.f22765a.f22789k.a(), this.f22765a.f22789k.a()));
                    if (!this.f22765a.f22786h.d) {
                        this.f22769e.a(view);
                    }
                }
            }
        }

        public final void m25368b(View view) {
            InlineVideoAttachmentView inlineVideoAttachmentView = (InlineVideoAttachmentView) view;
            this.f22765a.f22790l.b(false);
            if (m25366c(inlineVideoAttachmentView)) {
                InlineVideoPartDefinition.m25391b(inlineVideoAttachmentView, this.f22765a, this.f22768d, EventTriggerType.BY_AUTOPLAY);
            }
            this.f22765a.f22788j.g();
        }

        public InlineAutoplayVisibilityRunnable(State state, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider, Provider<ScrollSpeedEstimator> provider, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils, FrameRateBlameMarkers frameRateBlameMarkers, AutoplayRolloutNuxHelper autoplayRolloutNuxHelper, AutoplayVisibilityRunnableActivityListener autoplayVisibilityRunnableActivityListener, int i) {
            super(autoplayVisibilityRunnableActivityListener, videoAutoplayVisibilityDecider, provider, i);
            this.f22765a = state;
            this.f22766b = videoAutoPlaySettingsChecker;
            this.f22767c = videoLoggingUtils;
            this.f22768d = frameRateBlameMarkers;
            this.f22769e = autoplayRolloutNuxHelper;
            autoplayVisibilityRunnableActivityListener.a(this);
        }
    }

    /* compiled from: TEXT_EDIT */
    public final class InlineVideoAutoplayTransitionManager implements VideoAutoplayTransitionManager {
        public State f22770a;

        public InlineVideoAutoplayTransitionManager(State state) {
            Preconditions.checkNotNull(state);
            this.f22770a = state;
        }

        public final void m25370a() {
            this.f22770a.f22797s = false;
        }

        public final void m25373a(boolean z) {
            this.f22770a.f22794p.b.a(this.f22770a.f22786h);
            this.f22770a.f22794p.a.setIsVideoCompleted(z);
        }

        public final void m25371a(FrameRateBlameMarkers frameRateBlameMarkers, EventTriggerType eventTriggerType, PlayPosition playPosition) {
            if (this.f22770a.f22792n) {
                this.f22770a.f22794p.a.a(eventTriggerType, playPosition);
            } else {
                InlineVideoPartDefinition.m25387a(this.f22770a.f22794p, this.f22770a, frameRateBlameMarkers, eventTriggerType, playPosition);
            }
        }

        public final void m25374b() {
            InlineVideoPartDefinition.m25389a(this.f22770a, EventTriggerType.BY_USER);
        }

        public final void m25372a(ExitFullScreenResult exitFullScreenResult) {
            if (this.f22770a.f22793o != null && (this.f22770a.f22793o instanceof InlineVideoPlayer)) {
                this.f22770a.f22793o.a(exitFullScreenResult.g);
            }
        }

        public final View m25375c() {
            return this.f22770a.f22794p;
        }

        public final AutoplayStateManager m25376d() {
            return this.f22770a.f22788j;
        }

        public final InlineVideoPersistentState m25377e() {
            return this.f22770a.f22789k;
        }

        public final GraphQLStoryAttachment m25378f() {
            return (GraphQLStoryAttachment) this.f22770a.f22779a.a;
        }
    }

    /* compiled from: TEXT_EDIT */
    class OnVideoEventListener extends AbstractVideoPlayerListener {
        final /* synthetic */ InlineVideoPartDefinition f22771a;
        private final State f22772b;
        private final E f22773c;
        private final FeedProps<GraphQLStoryAttachment> f22774d;

        public OnVideoEventListener(InlineVideoPartDefinition inlineVideoPartDefinition, FeedProps<GraphQLStoryAttachment> feedProps, State state, E e) {
            this.f22771a = inlineVideoPartDefinition;
            this.f22772b = state;
            this.f22773c = e;
            this.f22774d = feedProps;
        }

        public final void m25380a(int i) {
            this.f22772b.f22788j.f();
            this.f22772b.f22789k.a(0);
            this.f22772b.f22789k.a = true;
            if (this.f22771a.f22809A.c((GraphQLStoryAttachment) this.f22772b.f22779a.a)) {
                this.f22772b.f22793o.e();
            }
            ((HasInvalidate) this.f22773c).a(new FeedProps[]{this.f22774d});
        }

        public final void m25381a(String str, VideoError videoError) {
            if (videoError.value.equals(VideoError.ERROR_IO.value) || videoError.value.equals(VideoError.SERVER_DIED.value) || videoError.value.equals(VideoError.UNSUPPORTED.value)) {
                this.f22772b.f22788j.i();
            }
        }

        public final void m25383c(EventTriggerType eventTriggerType, boolean z) {
            if (z) {
                m25379d(eventTriggerType);
            }
        }

        public final void m25382b(EventTriggerType eventTriggerType) {
            m25379d(eventTriggerType);
        }

        private void m25379d(EventTriggerType eventTriggerType) {
            if (this.f22772b.f22793o == null) {
                return;
            }
            if (eventTriggerType == EventTriggerType.BY_NEWSFEED_OCCLUSION || eventTriggerType == EventTriggerType.BY_NEWSFEED_ONPAUSE || VideoPlayerManager.c(eventTriggerType)) {
                this.f22772b.f22789k.a(this.f22772b.f22793o.getCurrentPosition());
            }
        }
    }

    @Immutable
    /* compiled from: TEXT_EDIT */
    public final class Props {
        public final FeedProps<GraphQLStoryAttachment> f22775a;
        public final int f22776b;
        public final Optional<VideoAttachmentDelegate$VideoSizeAndBackgroundOverride> f22777c;
        public final AtomicReference<FullscreenTransitionListener> f22778d;

        public Props(FeedProps<GraphQLStoryAttachment> feedProps, int i, Optional<VideoAttachmentDelegate$VideoSizeAndBackgroundOverride> optional, AtomicReference<FullscreenTransitionListener> atomicReference) {
            this.f22775a = feedProps;
            this.f22776b = i;
            this.f22777c = optional;
            this.f22778d = atomicReference;
        }
    }

    /* compiled from: TEXT_EDIT */
    public final class State {
        public final FeedProps<GraphQLStoryAttachment> f22779a;
        public final GraphQLStory f22780b;
        public final boolean f22781c;
        public final ImmutableMap<String, ?> f22782d;
        public final VideoAttachmentDelegate f22783e;
        public final GraphQLVideo f22784f;
        public final PlayerOrigin f22785g;
        public final VideoFeedStoryInfo f22786h;
        public final VideoPlayerParams f22787i;
        public final AutoplayStateManager f22788j;
        public final InlineVideoPersistentState f22789k;
        public final VideoDisplayedInfo f22790l = new VideoDisplayedInfo();
        public final Set<AutoPlayFailureReason> f22791m = new HashSet();
        public final boolean f22792n;
        public BaseInlineVideoPlayer f22793o;
        public InlineVideoAttachmentView f22794p;
        public VideoPlayerListener f22795q;
        public boolean f22796r;
        public boolean f22797s;
        public String f22798t;
        public GraphQLStoryActionLink f22799u;
        public EndscreenReplayVideoOnClickListener f22800v;
        public AutoplayFeedRunnableConfig f22801w;

        public State(FeedProps<GraphQLStoryAttachment> feedProps, GraphQLStory graphQLStory, GraphQLVideo graphQLVideo, boolean z, ImmutableMap<String, ?> immutableMap, VideoAttachmentDelegate videoAttachmentDelegate, PlayerOrigin playerOrigin, VideoFeedStoryInfo videoFeedStoryInfo, VideoPlayerParams videoPlayerParams, AutoplayStateManager autoplayStateManager, InlineVideoPersistentState inlineVideoPersistentState, boolean z2) {
            this.f22779a = feedProps;
            this.f22780b = graphQLStory;
            this.f22784f = graphQLVideo;
            this.f22781c = z;
            this.f22782d = immutableMap;
            this.f22783e = videoAttachmentDelegate;
            this.f22785g = playerOrigin;
            this.f22786h = videoFeedStoryInfo;
            this.f22787i = videoPlayerParams;
            this.f22788j = autoplayStateManager;
            this.f22789k = inlineVideoPersistentState;
            this.f22792n = z2;
        }
    }

    /* compiled from: TEXT_EDIT */
    public class VideoPlayerOnClickListener implements OnClickListener {
        final /* synthetic */ InlineVideoPartDefinition f22802a;
        public final State f22803b;
        private final FrameRateBlameMarkers f22804c;
        private final E f22805d;

        public VideoPlayerOnClickListener(InlineVideoPartDefinition inlineVideoPartDefinition, State state, FrameRateBlameMarkers frameRateBlameMarkers, E e) {
            this.f22802a = inlineVideoPartDefinition;
            this.f22803b = state;
            this.f22804c = frameRateBlameMarkers;
            this.f22805d = e;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r13) {
            /*
            r12 = this;
            r6 = 2;
            r5 = 1;
            r0 = com.facebook.loom.logger.LogEntry.EntryType.UI_INPUT_START;
            r1 = -559721973; // 0xffffffffdea3520b float:-5.8842404E18 double:NaN;
            r1 = com.facebook.loom.logger.Logger.a(r6, r0, r1);
            r0 = r12.f22802a;
            r2 = r0.f22834z;
            r0 = r12.f22803b;
            r3 = r0.f22780b;
            r0 = r12.f22805d;
            r0 = (com.facebook.feed.environment.HasInvalidate) r0;
            r4 = java.lang.Boolean.valueOf(r5);
            r2.a(r3, r0, r4);
            r0 = r12.f22803b;
            r0 = r0.f22797s;
            if (r0 == 0) goto L_0x002d;
        L_0x0024:
            r0 = com.facebook.loom.logger.LogEntry.EntryType.UI_INPUT_END;
            r2 = -1990877906; // 0xffffffff89559d2e float:-2.5712848E-33 double:NaN;
            com.facebook.loom.logger.Logger.a(r6, r0, r2, r1);
        L_0x002c:
            return;
        L_0x002d:
            r0 = r13;
            r0 = (com.facebook.attachments.videos.ui.InlineVideoAttachmentView) r0;
            r2 = r12.f22803b;
            r2.f22797s = r5;
            r9 = r12.f22803b;
            r9 = r9.f22789k;
            r9 = r9.a();
            r11 = r0.a;
            r10 = r11;
            r10 = r10.k();
            if (r10 == 0) goto L_0x004c;
        L_0x0045:
            r11 = r0.a;
            r9 = r11;
            r9 = r9.getCurrentPosition();
        L_0x004c:
            r10 = r12.f22803b;
            r10 = r10.f22784f;
            r10 = r10.aD();
            if (r9 == r10) goto L_0x005d;
        L_0x0056:
            r11 = r0.a;
            r10 = r11;
            r11 = 0;
            r10 = r11;
            if (r10 == 0) goto L_0x005e;
        L_0x005d:
            r9 = 0;
        L_0x005e:
            r2 = r9;
            r9 = r0.a;
            r3 = r9;
            r4 = r3.b();
            r5 = r12.f22802a;
            r5 = r5.f22822n;
            r6 = r12.f22803b;
            r6 = r6.f22787i;
            r6 = r6.b;
            r5.a(r6);
            r5 = r12.f22802a;
            r5 = r5.f22822n;
            r6 = r12.f22803b;
            r6 = r6.f22787i;
            r6 = r6.b;
            r5.a(r6, r4);
            r9 = r0.b;
            r5 = r9;
            r5 = r5.a(r2);
            if (r4 == 0) goto L_0x0092;
        L_0x0089:
            r6 = r12.f22803b;
            r7 = r12.f22804c;
            r8 = com.facebook.video.analytics.VideoAnalytics.EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION;
            com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition.m25391b(r0, r6, r7, r8);
        L_0x0092:
            r6 = r12.f22803b;
            r6 = r6.f22783e;
            r6.a(r13);
            r6 = r12.f22803b;
            r6 = r6.f22783e;
            r6.a(r3, r4);
            r3 = r12.f22803b;
            r3 = r3.f22783e;
            r0 = r0.getAndClearShowLiveCommentDialogFragment();
            r9 = r3.s;
            r9.k = r0;
            r0 = r12.f22803b;
            r0 = r0.f22788j;
            r0.a();
            r0 = r12.f22803b;
            r0 = r0.f22783e;
            r0.a(r2, r5, r4);
            r0 = -1998399427; // 0xffffffff88e2d83d float:-1.3652718E-33 double:NaN;
            com.facebook.tools.dextr.runtime.LogUtils.a(r0, r1);
            goto L_0x002c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition.VideoPlayerOnClickListener.onClick(android.view.View):void");
        }
    }

    private static InlineVideoPartDefinition m25390b(InjectorLike injectorLike) {
        return new InlineVideoPartDefinition((VideoAttachmentDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoAttachmentDelegateProvider.class), (FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), IdBasedProvider.a(injectorLike, 3975), VideoAutoPlaySettingsChecker.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3663), VideoAutoplayVisibilityDecider.a(injectorLike), IdBasedProvider.a(injectorLike, 1746), FrameRateBlameMarkers.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3670), VideoTransitionPerfLogger.a(injectorLike), NativePlayerPool.a(injectorLike), (AutoplayStateManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class), AutoplayRolloutNuxHelper.a(injectorLike), AutoplayVisibilityRunnableActivityListener.a(injectorLike), IdBasedLazy.a(injectorLike, 1817), VideoPrefetchPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 1816), SingleRunnableAutoplayPartDefinition.a(injectorLike), MultiRunnableAutoplayPartDefinition.a(injectorLike), LegacyInlineVideoPartDefinition.m25397a(injectorLike), ChannelFeedEligibilityUtil.a(injectorLike), VideoRegistryPartDefinition.a(injectorLike), (LegacyFullscreenTransitionListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LegacyFullscreenTransitionListenerProvider.class), InlineCommentComposerCache.a(injectorLike), CallToActionUtil.a(injectorLike));
    }

    public static InlineVideoPartDefinition m25386a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22807C) {
                InlineVideoPartDefinition inlineVideoPartDefinition;
                if (a2 != null) {
                    inlineVideoPartDefinition = (InlineVideoPartDefinition) a2.a(f22807C);
                } else {
                    inlineVideoPartDefinition = f22806B;
                }
                if (inlineVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25390b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22807C, b3);
                        } else {
                            f22806B = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final /* bridge */ /* synthetic */ void m25395a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1864683657);
        m25388a((State) obj2, (InlineVideoAttachmentView) view);
        Logger.a(8, EntryType.MARK_POP, -1419820640, a);
    }

    public final void m25396b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        InlineVideoAttachmentView inlineVideoAttachmentView = (InlineVideoAttachmentView) view;
        boolean k = inlineVideoAttachmentView.a.k();
        boolean a = VideoAutoplayVisibilityDecider.a(this.f22819k.a(inlineVideoAttachmentView));
        InlineVideoPersistentState inlineVideoPersistentState = state.f22789k;
        if (k && a) {
            a = true;
        } else {
            a = false;
        }
        inlineVideoPersistentState.d = a;
        if (!state.f22801w.a && k) {
            m25391b(inlineVideoAttachmentView, state, this.f22815g, state.f22789k.c());
        }
        state.f22794p = null;
        inlineVideoAttachmentView.b.b();
    }

    @Inject
    public InlineVideoPartDefinition(VideoAttachmentDelegateProvider videoAttachmentDelegateProvider, FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, Provider<Boolean> provider, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, Lazy<VideoLoggingUtils> lazy, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider, Provider<ScrollSpeedEstimator> provider2, FrameRateBlameMarkers frameRateBlameMarkers, QeAccessor qeAccessor, Lazy<VideoPrepareController> lazy2, VideoTransitionPerfLogger videoTransitionPerfLogger, NativePlayerPool nativePlayerPool, AutoplayStateManagerProvider autoplayStateManagerProvider, AutoplayRolloutNuxHelper autoplayRolloutNuxHelper, AutoplayVisibilityRunnableActivityListener autoplayVisibilityRunnableActivityListener, Lazy<VideoZeroDialogPartDefinition> lazy3, VideoPrefetchPartDefinition videoPrefetchPartDefinition, Lazy<VideoSubtitlesPartDefinition> lazy4, SingleRunnableAutoplayPartDefinition singleRunnableAutoplayPartDefinition, MultiRunnableAutoplayPartDefinition multiRunnableAutoplayPartDefinition, LegacyInlineVideoPartDefinition legacyInlineVideoPartDefinition, ChannelFeedEligibilityUtil channelFeedEligibilityUtil, VideoRegistryPartDefinition videoRegistryPartDefinition, LegacyFullscreenTransitionListenerProvider legacyFullscreenTransitionListenerProvider, InlineCommentComposerCache inlineCommentComposerCache, CallToActionUtil callToActionUtil) {
        this.f22810b = videoAttachmentDelegateProvider;
        this.f22811c = feedVideoPlayerParamBuilderProvider;
        this.f22812d = provider;
        this.f22813e = videoAutoPlaySettingsChecker;
        this.f22814f = lazy;
        this.f22819k = videoAutoplayVisibilityDecider;
        this.f22820l = provider2;
        this.f22815g = frameRateBlameMarkers;
        this.f22816h = qeAccessor;
        this.f22821m = lazy2;
        this.f22822n = videoTransitionPerfLogger;
        this.f22823o = nativePlayerPool;
        this.f22817i = autoplayStateManagerProvider;
        this.f22818j = autoplayRolloutNuxHelper;
        this.f22824p = autoplayVisibilityRunnableActivityListener;
        this.f22829u = lazy3;
        this.f22825q = videoPrefetchPartDefinition;
        this.f22826r = lazy4;
        this.f22827s = singleRunnableAutoplayPartDefinition;
        this.f22828t = multiRunnableAutoplayPartDefinition;
        this.f22830v = legacyInlineVideoPartDefinition;
        this.f22831w = channelFeedEligibilityUtil;
        this.f22832x = videoRegistryPartDefinition;
        this.f22833y = legacyFullscreenTransitionListenerProvider;
        this.f22834z = inlineCommentComposerCache;
        this.f22809A = callToActionUtil;
    }

    private State m25385a(SubParts<E> subParts, Props props, E e) {
        TracerDetour.a("InlineVideoPartDefinition.prepare", 98300796);
        try {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) props.f22775a.a();
            subParts.a(this.f22825q, new com.facebook.feedplugins.attachments.video.VideoPrefetchPartDefinition.Props(props.f22775a, props.f22776b));
            FeedProps e2 = AttachmentProps.e(props.f22775a);
            Preconditions.checkNotNull(e2);
            PlayerOrigin a = FeedAnalyticsUtil.a(((HasFeedListType) e).c());
            VideoAttachmentDelegate a2 = this.f22810b.a(props.f22775a, props.f22777c);
            GraphQLVideo c = a2.c();
            InlineVideoStoryKey inlineVideoStoryKey = new InlineVideoStoryKey(e2, c, this.f22817i);
            GraphQLStory graphQLStory = (GraphQLStory) e2.a();
            InlineVideoPersistentState inlineVideoPersistentState = (InlineVideoPersistentState) ((HasPersistentState) e).a(inlineVideoStoryKey, graphQLStory);
            VideoPlayerParams a3 = this.f22811c.a(props.f22775a, c).a(true, inlineVideoPersistentState.b().j());
            a2.a(a, (HasPrefetcher) e);
            AutoplayFeedRunnableConfig autoplayFeedRunnableConfig = new AutoplayFeedRunnableConfig(this.f22816h);
            State state = new State(props.f22775a, graphQLStory, c, ((Boolean) this.f22812d.get()).booleanValue(), ImmutableBiMap.b("GraphQLStoryProps", AttachmentProps.e(props.f22775a)), a2, a, new Builder(a3.e).a(a3.f).a(this.f22831w.a(props.f22775a, ((HasFeedListType) e).c().a())).a(inlineVideoPersistentState.c()).a(), a3, inlineVideoPersistentState.b(), inlineVideoPersistentState, false);
            state.f22795q = new OnVideoEventListener(this, props.f22775a, state, e);
            state.f22801w = autoplayFeedRunnableConfig;
            LegacyFullscreenTransitionListener a4 = this.f22833y.a(props.f22775a, m25384a(state), (HasInvalidate) e);
            a2.a(a4);
            props.f22778d.set(a4);
            if (autoplayFeedRunnableConfig.a()) {
                subParts.a(this.f22827s, new SingleRunnableAutoplayPartDefinition$Props(inlineVideoStoryKey, state.f22780b, state.f22790l, state.f22787i, state.f22786h, state.f22785g, new C19781(this)));
            } else {
                subParts.a(this.f22828t, new com.facebook.feedplugins.attachments.video.MultiRunnableAutoplayPartDefinition.Props(new InlineAutoplayVisibilityRunnable(state, this.f22819k, this.f22820l, this.f22813e, (VideoLoggingUtils) this.f22814f.get(), this.f22815g, this.f22818j, this.f22824p, autoplayFeedRunnableConfig.b()), inlineVideoStoryKey, graphQLStory, graphQLStoryAttachment));
            }
            state.f22799u = ActionLinkHelper.a(graphQLStoryAttachment, -508788748);
            if (this.f22809A.c(graphQLStoryAttachment)) {
                state.f22800v = new EndscreenReplayVideoOnClickListener(state);
                state.f22798t = state.f22799u.X() != null ? state.f22799u.X().b() : null;
            }
            if (((VideoPrepareController) this.f22821m.get()).a(state.f22788j.k())) {
                this.f22823o.a(a3.b, a3);
            }
            subParts.a(2131563180, (SinglePartDefinition) this.f22826r.get(), new com.facebook.feedplugins.attachments.video.VideoSubtitlesPartDefinition.Props(a3.b, state.f22784f.bo()));
            subParts.a((SinglePartDefinition) this.f22829u.get(), new com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition.Props(new VideoPlayerOnClickListener(this, state, this.f22815g, e)));
            subParts.a(this.f22830v, state);
            subParts.a(this.f22832x, state.f22779a.a());
            return state;
        } finally {
            TracerDetour.a(-433438406);
        }
    }

    private void m25388a(State state, V v) {
        TracerDetour.a("InlineVideoPartDefinition.bind", -2042885447);
        try {
            this.f22815g.c(VideoBindBlameMarker.c());
            v.getDelegate().a(state.f22785g, state.f22781c, state.f22787i, state.f22782d);
            state.f22793o = v.getInlineVideoPlayer();
            state.f22793o.setVideoListener(state.f22795q);
            state.f22793o.g();
            state.f22797s = m25393b((View) v);
            state.f22783e.a(v.getVideoAspectRatio());
            state.f22783e.a(v.getDelegate());
            state.f22790l.b(false);
            if (state.f22789k.e()) {
                m25392b(state, EventTriggerType.UNSET);
            }
            if (!state.f22801w.a() && state.f22789k.g()) {
                m25387a(v, state, this.f22815g, state.f22789k.c(), new PlayPosition(state.f22789k.a(), state.f22789k.a()));
            }
            state.f22794p = v;
        } finally {
            TracerDetour.a(1658993817);
        }
    }

    private static InlineVideoAutoplayTransitionManager m25384a(State state) {
        Preconditions.checkNotNull(state);
        Preconditions.checkNotNull(state.f22789k);
        VideoAutoplayTransitionManager videoAutoplayTransitionManager = (InlineVideoAutoplayTransitionManager) state.f22789k.g;
        if (videoAutoplayTransitionManager == null) {
            videoAutoplayTransitionManager = new InlineVideoAutoplayTransitionManager(state);
        } else {
            Preconditions.checkNotNull(state);
            videoAutoplayTransitionManager.f22770a = state;
        }
        state.f22789k.g = videoAutoplayTransitionManager;
        return videoAutoplayTransitionManager;
    }

    public static void m25387a(InlineVideoAttachmentView inlineVideoAttachmentView, State state, FrameRateBlameMarkers frameRateBlameMarkers, EventTriggerType eventTriggerType, PlayPosition playPosition) {
        if (!state.f22796r) {
            state.f22796r = true;
            frameRateBlameMarkers.a(AutoPlayVideoBlameMarker.c());
        }
        m25389a(state, eventTriggerType);
        inlineVideoAttachmentView.b.a(state.f22786h);
        inlineVideoAttachmentView.a.a(eventTriggerType, playPosition);
    }

    public static void m25391b(InlineVideoAttachmentView inlineVideoAttachmentView, State state, FrameRateBlameMarkers frameRateBlameMarkers, EventTriggerType eventTriggerType) {
        if (state.f22796r) {
            state.f22796r = false;
            frameRateBlameMarkers.b(AutoPlayVideoBlameMarker.c());
        }
        if (inlineVideoAttachmentView.a.b()) {
            state.f22789k.a(inlineVideoAttachmentView.a.getCurrentPosition());
        }
        inlineVideoAttachmentView.a.a(eventTriggerType, VideoMediaState.PAUSED);
    }

    public static boolean m25393b(View view) {
        boolean h;
        Preconditions.checkNotNull(view);
        FullScreenVideoPlayerHost fullScreenVideoPlayerHost = (FullScreenVideoPlayerHost) ContextUtils.a(view.getContext(), FullScreenVideoPlayerHost.class);
        if (fullScreenVideoPlayerHost != null) {
            h = fullScreenVideoPlayerHost.h();
        } else {
            h = false;
        }
        if (!h) {
            Object obj;
            FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(view.getContext(), FragmentManagerHost.class);
            if (fragmentManagerHost == null || fragmentManagerHost.kO_() == null) {
                obj = null;
            } else {
                FragmentManager kO_ = fragmentManagerHost.kO_();
                int size = f22808a.size();
                int i = 0;
                while (i < size) {
                    Fragment a = kO_.a((String) f22808a.get(i));
                    if (a == null || !a.z() || a.T == null) {
                        i++;
                    } else {
                        obj = a.T.findViewById(view.getId()) != null ? 1 : null;
                    }
                }
                obj = null;
            }
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static void m25389a(State state, EventTriggerType eventTriggerType) {
        if (!state.f22789k.c().equals(EventTriggerType.UNSET)) {
            return;
        }
        if (EventTriggerType.BY_AUTOPLAY.equals(eventTriggerType) || EventTriggerType.BY_USER.equals(eventTriggerType)) {
            m25392b(state, eventTriggerType);
        }
    }

    private static void m25392b(State state, EventTriggerType eventTriggerType) {
        state.f22786h.b = eventTriggerType;
        state.f22783e.a(eventTriggerType);
        state.f22789k.e = eventTriggerType;
    }
}
