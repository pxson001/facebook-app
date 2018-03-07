package com.facebook.feedplugins.video;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.attachments.video.InlineVideoStoryKey;
import com.facebook.feedplugins.attachments.video.SingleRunnableAutoplayPartDefinition;
import com.facebook.feedplugins.attachments.video.SingleRunnableAutoplayPartDefinition.Props;
import com.facebook.feedplugins.attachments.video.SingleRunnableAutoplayPartDefinition.VideoViewControllerProvider;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.media.MediaItem;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.creativeediting.model.VideoTrimParams;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.abtest.AutoplayFeedRunnableConfig;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.creativeediting.abtest.ExperimentsForVideoCreativeEditingAbtestModule;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.plugins.TrimmedVideoLoopingPlugin;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: foregroundColor */
public class OfflineVideoPostingPartDefinition<E extends HasPositionInformation & HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher, V extends RichVideoAttachmentView> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, V> {
    public static final ViewType f13058a = new C13571();
    private static OfflineVideoPostingPartDefinition f13059l;
    private static final Object f13060m = new Object();
    private final Context f13061b;
    private final VideoAttachmentBackgroundPartDefinition<E> f13062c;
    private final Lazy<UploadManager> f13063d;
    public final QeAccessor f13064e;
    private final AutoplayStateManagerProvider f13065f;
    private final VideoAutoplayVisibilityDecider f13066g;
    private final SingleRunnableAutoplayPartDefinition<E, V> f13067h;
    private final OptimisticStoryStateCache f13068i;
    private final FeedRenderUtils f13069j;
    public final FrameRateBlameMarkers f13070k;

    /* compiled from: foregroundColor */
    final class C13571 extends ViewType {
        C13571() {
        }

        public final View m14738a(Context context) {
            return new RichVideoAttachmentView(context);
        }
    }

    /* compiled from: foregroundColor */
    class C13582 implements VideoViewControllerProvider {
        final /* synthetic */ OfflineVideoPostingPartDefinition f13049a;

        C13582(OfflineVideoPostingPartDefinition offlineVideoPostingPartDefinition) {
            this.f13049a = offlineVideoPostingPartDefinition;
        }

        public final VideoViewController m14739a(InlineVideoPersistentState inlineVideoPersistentState, VideoDisplayedInfo videoDisplayedInfo, VideoPlayerParams videoPlayerParams, VideoFeedStoryInfo videoFeedStoryInfo, PlayerOrigin playerOrigin, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils) {
            return new RichVideoController(inlineVideoPersistentState, videoDisplayedInfo, videoPlayerParams, videoFeedStoryInfo, playerOrigin, videoAutoPlaySettingsChecker, videoLoggingUtils, this.f13049a.f13070k);
        }
    }

    /* compiled from: foregroundColor */
    public final class State {
        public final InlineVideoPersistentState f13050a;
        public final RichVideoPlayerParams f13051b;
        private final VideoTrimParams f13052c;
        public final int f13053d;
        public final VideoFeedStoryInfo f13054e;
        public final PlayerOrigin f13055f;
        public final VideoDisplayedInfo f13056g = new VideoDisplayedInfo();
        private final AutoplayFeedRunnableConfig f13057h;

        public State(InlineVideoPersistentState inlineVideoPersistentState, RichVideoPlayerParams richVideoPlayerParams, VideoTrimParams videoTrimParams, int i, VideoFeedStoryInfo videoFeedStoryInfo, PlayerOrigin playerOrigin, AutoplayFeedRunnableConfig autoplayFeedRunnableConfig) {
            this.f13050a = inlineVideoPersistentState;
            this.f13051b = richVideoPlayerParams;
            this.f13052c = videoTrimParams;
            this.f13053d = i;
            this.f13054e = videoFeedStoryInfo;
            this.f13055f = playerOrigin;
            this.f13057h = autoplayFeedRunnableConfig;
        }
    }

    private static OfflineVideoPostingPartDefinition m14744b(InjectorLike injectorLike) {
        return new OfflineVideoPostingPartDefinition((Context) injectorLike.getInstance(Context.class), VideoAttachmentBackgroundPartDefinition.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2984), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (AutoplayStateManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class), VideoAutoplayVisibilityDecider.a(injectorLike), SingleRunnableAutoplayPartDefinition.a(injectorLike), OptimisticStoryStateCache.a(injectorLike), FeedRenderUtils.a(injectorLike), FrameRateBlameMarkers.a(injectorLike));
    }

    public static OfflineVideoPostingPartDefinition m14741a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineVideoPostingPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13060m) {
                OfflineVideoPostingPartDefinition offlineVideoPostingPartDefinition;
                if (a2 != null) {
                    offlineVideoPostingPartDefinition = (OfflineVideoPostingPartDefinition) a2.a(f13060m);
                } else {
                    offlineVideoPostingPartDefinition = f13059l;
                }
                if (offlineVideoPostingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14744b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13060m, b3);
                        } else {
                            f13059l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineVideoPostingPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m14750a(Object obj) {
        GraphQLStory c = AttachmentProps.c((FeedProps) obj);
        if (c == null) {
            return false;
        }
        GraphQLFeedOptimisticPublishState a = this.f13068i.a(c);
        if (a != GraphQLFeedOptimisticPublishState.SUCCESS && a != GraphQLFeedOptimisticPublishState.POSTING && a != GraphQLFeedOptimisticPublishState.FAILED && a != GraphQLFeedOptimisticPublishState.RETRYING_IN_BACKGROUND) {
            return false;
        }
        boolean z = false;
        if (this.f13064e.a(ExperimentsForVideoCreativeEditingAbtestModule.c, false) || this.f13064e.a(ExperimentsForComposerAbTestModule.ad, false)) {
            z = true;
        }
        if (z) {
            return true;
        }
        return false;
    }

    public final void m14751b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        RichVideoPlayer richVideoPlayer = ((RichVideoAttachmentView) view).getRichVideoPlayer();
        boolean o = richVideoPlayer.o();
        boolean a = VideoAutoplayVisibilityDecider.a(this.f13066g.a(richVideoPlayer));
        InlineVideoPersistentState inlineVideoPersistentState = state.f13050a;
        if (o && a) {
            o = true;
        } else {
            o = false;
        }
        inlineVideoPersistentState.d = o;
        richVideoPlayer.setRotation(0.0f);
        richVideoPlayer.g();
    }

    @Inject
    public OfflineVideoPostingPartDefinition(Context context, VideoAttachmentBackgroundPartDefinition videoAttachmentBackgroundPartDefinition, Lazy<UploadManager> lazy, QeAccessor qeAccessor, AutoplayStateManagerProvider autoplayStateManagerProvider, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider, SingleRunnableAutoplayPartDefinition singleRunnableAutoplayPartDefinition, OptimisticStoryStateCache optimisticStoryStateCache, FeedRenderUtils feedRenderUtils, FrameRateBlameMarkers frameRateBlameMarkers) {
        this.f13061b = context;
        this.f13062c = videoAttachmentBackgroundPartDefinition;
        this.f13063d = lazy;
        this.f13064e = qeAccessor;
        this.f13065f = autoplayStateManagerProvider;
        this.f13066g = videoAutoplayVisibilityDecider;
        this.f13067h = singleRunnableAutoplayPartDefinition;
        this.f13068i = optimisticStoryStateCache;
        this.f13069j = feedRenderUtils;
        this.f13070k = frameRateBlameMarkers;
    }

    public final ViewType m14747a() {
        return f13058a;
    }

    private State m14740a(SubParts<E> subParts, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        FeedProps e2 = AttachmentProps.e(feedProps);
        GraphQLStory graphQLStory = (GraphQLStory) e2.a();
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a();
        subParts.a(this.f13062c, feedProps);
        VideoCreativeEditingData b = m14745b((FeedProps) feedProps);
        int i = 0;
        VideoTrimParams videoTrimParams = null;
        if (b != null) {
            i = b.b();
            videoTrimParams = b.a();
        }
        InlineVideoStoryKey inlineVideoStoryKey = new InlineVideoStoryKey(e2, GraphQLMediaConversionHelper.b(graphQLStoryAttachment.r()), this.f13065f);
        InlineVideoPersistentState inlineVideoPersistentState = (InlineVideoPersistentState) ((HasPersistentState) e).a(inlineVideoStoryKey, graphQLStory);
        inlineVideoPersistentState.b().b(true);
        PlayerOrigin playerOrigin = PlayerOrigin.OPTIMISTIC_POSTING_INLINE;
        AutoplayFeedRunnableConfig autoplayFeedRunnableConfig = new AutoplayFeedRunnableConfig(this.f13064e);
        VideoPlayerParams m = VideoPlayerParams.newBuilder().a(VideoDataSource.newBuilder().a(Uri.parse(graphQLStoryAttachment.r().aO())).a(StreamSourceType.FROM_LOCAL_STORAGE).i()).c(false).e(false).m();
        Builder a = new Builder().a(m);
        if (videoTrimParams != null) {
            a.a("TrimStartPosition", Integer.valueOf(videoTrimParams.videoTrimStartTimeMs)).a("TrimEndPosition", Integer.valueOf(videoTrimParams.videoTrimEndTimeMs));
        }
        State state = new State(inlineVideoPersistentState, a.b(), videoTrimParams, i, new VideoFeedStoryInfo.Builder(TrackableFeedProps.a(e2)).a(false).a(ChannelEligibility.NO_INFO).a(inlineVideoPersistentState.c()).a(), playerOrigin, autoplayFeedRunnableConfig);
        if (m14746b() && autoplayFeedRunnableConfig.a()) {
            SubParts<E> subParts2 = subParts;
            subParts2.a(this.f13067h, new Props(inlineVideoStoryKey, graphQLStory, state.f13056g, m, state.f13054e, playerOrigin, new C13582(this)));
        }
        return state;
    }

    private void m14742a(FeedProps<GraphQLStoryAttachment> feedProps, State state, V v) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a();
        TracerDetour.a("OfflineVideoPostingPartDefinition.bind", 12332881);
        try {
            RichVideoPlayer richVideoPlayer = v.getRichVideoPlayer();
            if (!(state.f13051b.a.b == null || state.f13051b.a.b.equals(richVideoPlayer.getVideoId()))) {
                if (richVideoPlayer.m()) {
                    richVideoPlayer.b(EventTriggerType.BY_PLAYER);
                }
                richVideoPlayer.g();
            }
            m14743a(graphQLStoryAttachment, richVideoPlayer, state.f13053d, m14746b());
            if (m14746b()) {
                richVideoPlayer.setRotation((float) state.f13053d);
                if (richVideoPlayer.a(TrimmedVideoLoopingPlugin.class) == null) {
                    richVideoPlayer.a(new TrimmedVideoLoopingPlugin(this.f13061b));
                }
            } else {
                String b;
                GraphQLImage l = GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment);
                FbDraweeView coverImage = richVideoPlayer.getCoverImage();
                if (l != null) {
                    b = l.b();
                } else {
                    b = graphQLStoryAttachment.r().aO();
                }
                coverImage.a(Uri.parse(b), CallerContext.a(OfflineVideoPostingPartDefinition.class));
            }
            richVideoPlayer.setPlayerOrigin(state.f13055f);
            richVideoPlayer.a(state.f13051b);
            richVideoPlayer.a(true, EventTriggerType.BY_PLAYER);
        } finally {
            TracerDetour.a(-908201935);
        }
    }

    private VideoCreativeEditingData m14745b(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory c = AttachmentProps.c(feedProps);
        if (c == null) {
            return null;
        }
        UploadOperation d = ((UploadManager) this.f13063d.get()).d(c.T());
        if (d == null) {
            return null;
        }
        ImmutableList immutableList = d.a;
        if (immutableList == null || immutableList.isEmpty()) {
            return null;
        }
        MediaItem mediaItem = (MediaItem) immutableList.get(0);
        if (mediaItem == null || !mediaItem.e().equals(((GraphQLStoryAttachment) feedProps.a).r().aO())) {
            return null;
        }
        immutableList = d.b;
        if (immutableList == null || immutableList.isEmpty()) {
            return null;
        }
        Bundle bundle = (Bundle) immutableList.get(0);
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(VideoCreativeEditingData.class.getClassLoader());
        if (bundle.containsKey("video_creative_editing_metadata")) {
            return (VideoCreativeEditingData) bundle.getParcelable("video_creative_editing_metadata");
        }
        return null;
    }

    private static boolean m14746b() {
        return false;
    }

    private void m14743a(GraphQLStoryAttachment graphQLStoryAttachment, RichVideoPlayer richVideoPlayer, int i, boolean z) {
        int bo = graphQLStoryAttachment.r().bo();
        int R = graphQLStoryAttachment.r().R();
        float f = ((float) bo) / ((float) R);
        int a = this.f13069j.a();
        if (a > bo) {
            R = (int) (((float) a) / f);
            bo = a;
        }
        LayoutParams layoutParams = richVideoPlayer.getLayoutParams();
        layoutParams.height = Math.min(bo, R);
        layoutParams.width = bo;
        if (z && i % 180 != 0 && a > layoutParams.height) {
            layoutParams.height = a;
            layoutParams.width = (int) (((float) a) * f);
        }
        richVideoPlayer.setLayoutParams(layoutParams);
    }
}
