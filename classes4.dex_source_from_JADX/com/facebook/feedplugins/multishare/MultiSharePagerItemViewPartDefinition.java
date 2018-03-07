package com.facebook.feedplugins.multishare;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.UriUtil;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.sections.attachments.linkshare.InstantArticleShareAttachmentPartDefinition;
import com.facebook.feed.ui.inlinevideoplayer.ScrollSpeedEstimator;
import com.facebook.feed.util.event.StoryEvents.OutboundClickedEvent;
import com.facebook.feedplugins.attachments.video.AutoplayVisibilityRunnableActivityListener;
import com.facebook.feedplugins.attachments.video.ChannelFeedEligibilityUtil;
import com.facebook.feedplugins.attachments.video.FeedAnalyticsUtil;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegate;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegateProvider;
import com.facebook.feedplugins.multishare.abtest.ExperimentsForMultiShareAbTestModule;
import com.facebook.feedplugins.multishare.ui.MultiSharePagerItemView;
import com.facebook.feedplugins.multishare.ui.MultiShareProductItemView;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.imagepipeline.request.ImageRequest;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.abtest.AutoplayFeedRunnableConfig;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import com.facebook.video.analytics.VideoTransitionPerfLogger;
import com.facebook.video.channelfeed.ChannelFeedParams;
import com.facebook.video.channelfeed.LaunchChannelFeedClickListener;
import com.facebook.video.channelfeed.LaunchChannelFeedClickListenerProvider;
import com.facebook.video.channelfeed.MultiShareNoLinkUtil;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.google.common.base.Absent;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: network_count */
public class MultiSharePagerItemViewPartDefinition<E extends HasFeedListType & HasPersistentState & HasPrefetcher, V extends MultiSharePagerItemView> extends BaseSinglePartDefinition<MultiShareAttachmentItemViewModel, State, E, V> {
    private static MultiSharePagerItemViewPartDefinition f7215r;
    private static final Object f7216s = new Object();
    private final Context f7217a;
    private final CommonEventsBuilder f7218b;
    private final DefaultFeedUnitRenderer f7219c;
    private final VideoAttachmentDelegateProvider f7220d;
    private final boolean f7221e;
    private final VideoLoggingUtils f7222f;
    private final VideoTransitionPerfLogger f7223g;
    private final VideoAutoPlaySettingsChecker f7224h;
    public final VideoAutoplayVisibilityDecider f7225i;
    private final Provider<ScrollSpeedEstimator> f7226j;
    private final AutoplayStateManagerProvider f7227k;
    private final AutoplayVisibilityRunnableActivityListener f7228l;
    private final QeAccessor f7229m;
    private final MultiShareLinkUtil f7230n;
    private final ClickListenerPartDefinition f7231o;
    private final LaunchChannelFeedClickListenerProvider f7232p;
    private final ChannelFeedEligibilityUtil f7233q;

    /* compiled from: network_count */
    public class State {
        public OnClickListener f13947a;
        public OnClickListener f13948b;
        public VideoAttachmentDelegate f13949c;
        public GraphQLVideo f13950d;
        public MultiShareInlineVideoView f13951e;
        public MultiShareProductItemView f13952f;
        public VideoPlayerParams f13953g;
        public VideoDisplayedInfo f13954h;
        public boolean f13955i = false;
        public InlineVideoPersistentState f13956j;
        public View f13957k;
        public AutoplayStateManager f13958l;
        public MultiShareAutoplayVisibilityRunnable f13959m;
        public HashSet<AutoPlayFailureReason> f13960n;
        public LaunchChannelFeedClickListener f13961o;
        public AtomicReference<FullscreenTransitionListener> f13962p;
    }

    private static MultiSharePagerItemViewPartDefinition m7553b(InjectorLike injectorLike) {
        return new MultiSharePagerItemViewPartDefinition((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4010), CommonEventsBuilder.a(injectorLike), DefaultFeedUnitRenderer.a(injectorLike), (VideoAttachmentDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoAttachmentDelegateProvider.class), VideoAutoplayVisibilityDecider.a(injectorLike), IdBasedProvider.a(injectorLike, 1746), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (AutoplayStateManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class), AutoplayVisibilityRunnableActivityListener.a(injectorLike), VideoLoggingUtils.a(injectorLike), VideoTransitionPerfLogger.a(injectorLike), VideoAutoPlaySettingsChecker.a(injectorLike), MultiShareLinkUtil.m7560a(injectorLike), ClickListenerPartDefinition.a(injectorLike), (LaunchChannelFeedClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LaunchChannelFeedClickListenerProvider.class), ChannelFeedEligibilityUtil.a(injectorLike));
    }

    private void m7550a(MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel, State state, MultiShareProductItemView multiShareProductItemView) {
        RichVideoPlayerParams richVideoPlayerParams;
        FeedProps feedProps = multiShareAttachmentItemViewModel.f13897a;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (graphQLStoryAttachment == null || GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment) == null || GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment).b() == null) {
            richVideoPlayerParams = null;
        } else {
            RichVideoPlayerParams richVideoPlayerParams2;
            feedProps = AttachmentProps.e(feedProps);
            GraphQLVideo graphQLVideo = state.f13950d;
            Uri a = ImageUtil.a(GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment));
            int i = multiShareAttachmentItemViewModel.f13900d;
            if (graphQLVideo == null || graphQLVideo.aE() == null) {
                richVideoPlayerParams2 = null;
            } else {
                VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
                newBuilder.f4829f = StreamSourceType.FROM_STREAM;
                newBuilder = newBuilder;
                newBuilder.f4824a = UriUtil.a(graphQLVideo.aE());
                newBuilder = newBuilder;
                newBuilder.f4825b = UriUtil.a(graphQLVideo.aA());
                VideoPlayerParamsBuilder a2 = VideoPlayerParams.newBuilder().m5261a(newBuilder.m5254i());
                a2.f4852b = graphQLVideo.J();
                a2 = a2.m5259a(graphQLVideo.s(), graphQLVideo.G());
                a2.f4861k = graphQLVideo.o();
                a2 = a2;
                a2.f4853c = graphQLVideo.aD();
                a2 = a2;
                a2.f4855e = TrackableFeedProps.a(feedProps);
                a2 = a2;
                a2.f4856f = StoryProps.p(feedProps);
                a2 = a2;
                a2.f4857g = graphQLVideo.af();
                a2 = a2;
                a2.f4867q = graphQLVideo.ap();
                VideoPlayerParams m = a2.m5271m();
                ImmutableMap b = new Builder().b("CoverImageParamsKey", ImageRequest.a(a)).b("MultiShareGraphQLSubStoryIndexKey", Integer.valueOf(i - 1)).b("MultiShareGraphQLSubStoryPropsKey", feedProps).b();
                RichVideoPlayerParams.Builder builder = new RichVideoPlayerParams.Builder();
                builder.f4958a = m;
                richVideoPlayerParams2 = builder.m5352a(b).m5355b();
            }
            richVideoPlayerParams = richVideoPlayerParams2;
            if (!(richVideoPlayerParams == null || richVideoPlayerParams.f4962a == null)) {
                state.f13953g = richVideoPlayerParams.f4962a;
            }
        }
        RichVideoPlayerParams richVideoPlayerParams3 = richVideoPlayerParams;
        if (richVideoPlayerParams3 != null) {
            multiShareProductItemView.m14787a(richVideoPlayerParams3);
            state.f13952f = multiShareProductItemView;
            state.f13951e = multiShareProductItemView.getInlineVideoView();
            state.f13951e.setShouldCropToFit(true);
            state.f13951e.f14029v = new OnVideoEventListener(this, state.f13956j, state.f13958l);
            state.f13951e.m14795a(state.f13948b, state.f13951e);
            if (state.f13956j.m5301e()) {
                state.f13956j.f4911e = EventTriggerType.UNSET;
                state.f13951e.getPlaybackController().m5475c();
            }
            FullscreenTransitionListener 3 = new 3(this, state, multiShareProductItemView);
            state.f13949c.m5286a(3);
            if (state.f13962p != null) {
                state.f13962p.set(3);
            }
            m7554c(state, multiShareProductItemView);
        }
    }

    private HoneyClientEvent m7546a(MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel, int i) {
        FeedProps feedProps = multiShareAttachmentItemViewModel.f13898b;
        return this.f7218b.a(Strings.nullToEmpty(((GraphQLStoryAttachment) multiShareAttachmentItemViewModel.f13897a.a).C()), StoryProps.p(feedProps), TrackableFeedProps.a(feedProps), "native_newsfeed", i);
    }

    public static MultiSharePagerItemViewPartDefinition m7547a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultiSharePagerItemViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7216s) {
                MultiSharePagerItemViewPartDefinition multiSharePagerItemViewPartDefinition;
                if (a2 != null) {
                    multiSharePagerItemViewPartDefinition = (MultiSharePagerItemViewPartDefinition) a2.a(f7216s);
                } else {
                    multiSharePagerItemViewPartDefinition = f7215r;
                }
                if (multiSharePagerItemViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7553b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7216s, b3);
                        } else {
                            f7215r = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = multiSharePagerItemViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m7556a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel = (MultiShareAttachmentItemViewModel) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        int i = multiShareAttachmentItemViewModel.f13900d;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) multiShareAttachmentItemViewModel.f13897a.a;
        if (!this.f7230n.m7562a(graphQLStoryAttachment)) {
            subParts.a(this.f7231o, this.f7219c.a(Strings.nullToEmpty(graphQLStoryAttachment.C()), m7546a(multiShareAttachmentItemViewModel, i), null));
        }
        final State state = new State();
        if (this.f7221e && GraphQLStoryAttachmentUtil.d(graphQLStoryAttachment)) {
            m7548a(multiShareAttachmentItemViewModel, state, hasFeedListType);
        }
        if (multiShareAttachmentItemViewModel.f13903g) {
            String H;
            FeedListName a = hasFeedListType.c() == null ? null : hasFeedListType.c().a();
            GraphQLStory graphQLStory = (GraphQLStory) multiShareAttachmentItemViewModel.f13898b.a;
            List c = MultiShareNoLinkUtil.m14671c(graphQLStory);
            GraphQLActor b = StoryActorHelper.b(graphQLStory);
            if (b != null) {
                H = b.H();
            } else {
                H = null;
            }
            ChannelFeedParams.Builder builder = new ChannelFeedParams.Builder();
            builder.f5858a = MultiShareNoLinkUtil.m14666a((FeedProps) c.get(multiShareAttachmentItemViewModel.f13899c));
            ChannelFeedParams.Builder builder2 = builder;
            builder2.f5859b = c;
            builder2 = builder2;
            builder2.f5865h = EventTriggerType.BY_USER;
            builder2 = builder2;
            builder2.f5864g = PlayerOrigin.VIDEO_SETS;
            builder2 = builder2;
            builder2.f5861d = ChannelFeedEligibilityUtil.a(a);
            builder2 = builder2;
            builder2.f5871n = i - 1;
            ChannelFeedParams a2 = builder2.m6346a(H).m6347a();
            state.f13962p = new AtomicReference();
            state.f13961o = this.f7232p.a(a2, state.f13956j, state.f13962p, null, null);
        }
        state.f13947a = new OnClickListener(this) {
            final /* synthetic */ MultiSharePagerItemViewPartDefinition f13965c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1906194971);
                if (view instanceof MultiShareInlineVideoView) {
                    view = (MultiShareInlineVideoView) view;
                    if (multiShareAttachmentItemViewModel.f13903g) {
                        MultiSharePagerItemViewPartDefinition.m7551a(state, view);
                    } else {
                        this.f13965c.m7557a(multiShareAttachmentItemViewModel, state, view, view.getLastStartPosition());
                    }
                }
                LogUtils.a(-930388337, a);
            }
        };
        state.f13948b = new OnClickListener(this) {
            final /* synthetic */ MultiSharePagerItemViewPartDefinition f13968c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 852442307);
                if (multiShareAttachmentItemViewModel.f13903g) {
                    MultiSharePagerItemViewPartDefinition.m7551a(state, view);
                } else {
                    this.f13968c.m7557a(multiShareAttachmentItemViewModel, state, view, 0);
                }
                LogUtils.a(2034526089, a);
            }
        };
        return state;
    }

    public final void m7559b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel = (MultiShareAttachmentItemViewModel) obj;
        State state = (State) obj2;
        MultiSharePagerItemView multiSharePagerItemView = (MultiSharePagerItemView) view;
        if (this.f7221e && (multiSharePagerItemView instanceof MultiShareProductItemView)) {
            ((MultiShareProductItemView) multiSharePagerItemView).m14789b();
        }
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) multiShareAttachmentItemViewModel.f13897a.a;
        multiSharePagerItemView.setOnClickListener(null);
        if (state.f13957k != null) {
            state.f13957k.setTag(2131558537, null);
        }
        multiSharePagerItemView.setTag(2131558515, null);
        multiSharePagerItemView.setTag(2131558542, null);
        if (this.f7221e && (multiSharePagerItemView instanceof MultiShareProductItemView) && GraphQLStoryAttachmentUtil.d((GraphQLStoryAttachment) multiShareAttachmentItemViewModel.f13897a.a)) {
            MultiShareProductItemView multiShareProductItemView = (MultiShareProductItemView) multiSharePagerItemView;
            if (GraphQLStoryAttachmentUtil.p((GraphQLStoryAttachment) multiShareAttachmentItemViewModel.f13897a.a)) {
                state.f13959m.m5404a();
                boolean a = VideoAutoplayVisibilityDecider.a(this.f7225i.a(multiShareProductItemView));
                InlineVideoPersistentState inlineVideoPersistentState = state.f13956j;
                if (a && state.f13951e.m14847m()) {
                    a = true;
                } else {
                    a = false;
                }
                inlineVideoPersistentState.f4910d = a;
                multiShareProductItemView.m14791e();
                multiShareProductItemView.m14789b();
                state.f13955i = false;
            }
        }
        if ((multiSharePagerItemView instanceof MultiShareProductItemView) && m7552a(graphQLStoryAttachment)) {
            ((MultiShareProductItemView) multiSharePagerItemView).setFlashIconVisibility(false);
        }
    }

    @Inject
    public MultiSharePagerItemViewPartDefinition(Context context, Provider<Boolean> provider, CommonEventsBuilder commonEventsBuilder, DefaultFeedUnitRenderer defaultFeedUnitRenderer, VideoAttachmentDelegateProvider videoAttachmentDelegateProvider, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider, Provider<ScrollSpeedEstimator> provider2, QeAccessor qeAccessor, AutoplayStateManagerProvider autoplayStateManagerProvider, AutoplayVisibilityRunnableActivityListener autoplayVisibilityRunnableActivityListener, VideoLoggingUtils videoLoggingUtils, VideoTransitionPerfLogger videoTransitionPerfLogger, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, MultiShareLinkUtil multiShareLinkUtil, ClickListenerPartDefinition clickListenerPartDefinition, LaunchChannelFeedClickListenerProvider launchChannelFeedClickListenerProvider, ChannelFeedEligibilityUtil channelFeedEligibilityUtil) {
        this.f7217a = context;
        this.f7225i = videoAutoplayVisibilityDecider;
        this.f7226j = provider2;
        this.f7229m = qeAccessor;
        this.f7227k = autoplayStateManagerProvider;
        this.f7228l = autoplayVisibilityRunnableActivityListener;
        this.f7218b = commonEventsBuilder;
        this.f7219c = defaultFeedUnitRenderer;
        this.f7220d = videoAttachmentDelegateProvider;
        this.f7231o = clickListenerPartDefinition;
        this.f7221e = ((Boolean) provider.get()).booleanValue();
        this.f7222f = videoLoggingUtils;
        this.f7223g = videoTransitionPerfLogger;
        this.f7224h = videoAutoPlaySettingsChecker;
        this.f7230n = multiShareLinkUtil;
        this.f7232p = launchChannelFeedClickListenerProvider;
        this.f7233q = channelFeedEligibilityUtil;
    }

    private void m7549a(MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel, State state, V v) {
        v.f13999a = multiShareAttachmentItemViewModel.f13900d;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) multiShareAttachmentItemViewModel.f13897a.a;
        if (this.f7221e && (v instanceof MultiShareProductItemView) && GraphQLStoryAttachmentUtil.d(graphQLStoryAttachment)) {
            MultiShareProductItemView multiShareProductItemView = (MultiShareProductItemView) v;
            OnClickListener onClickListener = state.f13947a;
            if (GraphQLStoryAttachmentUtil.d(graphQLStoryAttachment)) {
                multiShareProductItemView.f13991b.setOnClickListener(onClickListener);
                multiShareProductItemView.setInlineVideoViewVisibility(true);
                multiShareProductItemView.setItemImageViewVisibility(false);
            }
        }
        FeedProps feedProps = multiShareAttachmentItemViewModel.f13897a;
        GraphQLStory c = AttachmentProps.c(feedProps);
        if (c != null) {
            GraphQLStory a = AttachmentProps.a(feedProps);
            String g = (a == null || a == c) ? null : a.g();
            v.setTag(2131558515, new OutboundClickedEvent(c.g(), g));
        }
        state.f13957k = v.getCallToActionView();
        if (state.f13957k != null) {
            TextView textView = (TextView) state.f13957k.getRootView().findViewById(2131562505);
            state.f13957k.setTag(2131558537, Integer.valueOf(multiShareAttachmentItemViewModel.f13900d));
            state.f13957k.setTag(2131558538, Boolean.valueOf(true));
            if (textView != null) {
                textView.setTag(2131558537, Integer.valueOf(multiShareAttachmentItemViewModel.f13900d));
                textView.setTag(2131558538, Boolean.valueOf(true));
            }
        }
        feedProps = multiShareAttachmentItemViewModel.f13898b;
        if (feedProps != null) {
            v.setTag(2131558542, TrackableFeedProps.a(feedProps));
            v.setTag(2131558547, Boolean.valueOf(true));
        }
        if (this.f7221e && (v instanceof MultiShareProductItemView) && GraphQLStoryAttachmentUtil.d(graphQLStoryAttachment)) {
            m7550a(multiShareAttachmentItemViewModel, state, (MultiShareProductItemView) v);
        }
        if ((v instanceof MultiShareProductItemView) && m7552a(graphQLStoryAttachment)) {
            ((MultiShareProductItemView) v).setFlashIconVisibility(true);
        }
        LayoutParams layoutParams = v.findViewById(2131564012).getLayoutParams();
        layoutParams.width = (int) multiShareAttachmentItemViewModel.f13906j;
        layoutParams.height = (int) multiShareAttachmentItemViewModel.f13905i;
    }

    private void m7548a(MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel, State state, E e) {
        FeedProps feedProps = multiShareAttachmentItemViewModel.f13897a;
        if (GraphQLStoryAttachmentUtil.p((GraphQLStoryAttachment) feedProps.a)) {
            PlayerOrigin a = FeedAnalyticsUtil.m5245a(e.c());
            state.f13949c = this.f7220d.a(feedProps, Absent.INSTANCE);
            state.f13950d = state.f13949c.f4876e;
            state.f13949c.m5288a(a, (HasPrefetcher) e);
            FeedProps e2 = AttachmentProps.e(feedProps);
            state.f13956j = (InlineVideoPersistentState) ((HasPersistentState) e).a(new MultiShareVideoStoryKey(e2, state.f13950d, multiShareAttachmentItemViewModel.f13900d, this.f7227k), (CacheableEntity) e2.a);
            state.f13958l = state.f13956j.mo422b();
            state.f13959m = new MultiShareAutoplayVisibilityRunnable(new AutoplayFeedRunnableConfig(this.f7229m).f4957b, this.f7226j, this.f7225i, this.f7228l, this.f7222f, this.f7224h, state.f13956j, state);
            state.f13960n = new HashSet();
            state.f13954h = new VideoDisplayedInfo();
            state.f13956j.mo421a(0);
            state.f13956j.f4910d = false;
            state.f13956j.f4911e = EventTriggerType.BY_USER;
        }
    }

    public static void m7554c(State state, MultiShareProductItemView multiShareProductItemView) {
        if (state.f13955i) {
            multiShareProductItemView.m14786a(state.f13956j.mo420a(), EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION);
        }
        state.f13954h.b(false);
        if (!state.f13959m.f5023e) {
            state.f13959m.m5409d(multiShareProductItemView.f13991b);
        }
    }

    public final void m7557a(MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel, State state, View view, int i) {
        boolean z = state.f13956j.f4910d;
        this.f7223g.a(state.f13953g.f4833b);
        this.f7223g.a(state.f13953g.f4833b, z);
        ImmutableMap b = new Builder().b("MultiShareGraphQLSubStoryIndexKey", Integer.valueOf(multiShareAttachmentItemViewModel.f13900d - 1)).b("MultiShareGraphQLSubStoryPropsKey", AttachmentProps.e(multiShareAttachmentItemViewModel.f13897a)).b();
        state.f13949c.m5284a(view);
        state.f13958l.m5311a();
        state.f13949c.m5283a(state.f13951e.getCurrentPositionMs(), i, z, b);
        if (z) {
            state.f13951e.mo394b();
        }
    }

    public static void m7551a(State state, View view) {
        boolean z = state.f13956j.f4910d;
        state.f13961o.onClick(view);
        if (z) {
            state.f13951e.mo394b();
        }
    }

    public static void m7555d(State state, MultiShareProductItemView multiShareProductItemView) {
        state.f13956j.f4910d = true;
        multiShareProductItemView.f13991b.setOriginalPlayReason(state.f13956j.mo423c());
        multiShareProductItemView.m14786a(state.f13956j.mo420a(), state.f13956j.mo423c());
    }

    private boolean m7552a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f7229m.a(ExperimentsForMultiShareAbTestModule.f4216a, false) && InstantArticleShareAttachmentPartDefinition.a(graphQLStoryAttachment);
    }
}
