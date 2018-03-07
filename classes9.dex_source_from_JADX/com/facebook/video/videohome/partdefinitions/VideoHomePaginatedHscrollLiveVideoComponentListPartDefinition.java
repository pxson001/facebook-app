package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.SizeUtil;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.debug.fps.FrameRateRecyclerViewScrollListener;
import com.facebook.debug.log.BLog;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEvents;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.styling.ReactionHScrollPagerPaddingResolver;
import com.facebook.reaction.feed.styling.ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionPaginatedComponentFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel.ReactionPaginatedComponentsModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MessageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitSubComponentModel;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import com.facebook.video.videohome.environment.CanFetchHScrollSubComponents;
import com.facebook.video.videohome.environment.CanHandleSectionReload;
import com.facebook.video.videohome.environment.HasReactionSurfaceType;
import com.facebook.video.videohome.environment.HasRequestInformation;
import com.facebook.video.videohome.environment.HasShownVideosContainer;
import com.facebook.video.videohome.environment.ShownVideosContainer;
import com.facebook.video.videohome.environment.VideoHomeHScrollLiveVideosComponentKey;
import com.facebook.video.videohome.environment.VideoHomeHScrollLiveVideosComponentPersistentState;
import com.facebook.video.videohome.liveupdates.LiveUpdatesManager;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager.SessionStatusListener;
import com.facebook.widget.hscrollrecyclerview.KeepAttachedHScrollRecyclerView;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: skip_android_hash_check */
public class VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition<E extends CanFetchHScrollSubComponents & CanHandleHScrollPageChangedEvents & CanHandleSectionReload & HasContext & HasInvalidate & HasPositionInformation & HasPersistentState & HasReactionInteractionTracker & HasRequestInformation & HasReactionSurfaceType & HasShownVideosContainer> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, KeepAttachedHScrollRecyclerView> {
    private static VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition f3104m;
    private static final Object f3105n = new Object();
    private final LiveUpdatesManager f3106a;
    private final ReactionHScrollPagerPaddingResolver f3107b;
    private final PageStyleFactory f3108c;
    private final PersistentRecyclerPartDefinition<Object, E> f3109d;
    public final ReactionUnitComponentStyleMapper f3110e;
    private final ReactionUnitValidator f3111f;
    private final ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition f3112g;
    public final VideoHomeLoadingPageHscrollLiveVideoPartDefinition f3113h;
    private final AbstractFbErrorReporter f3114i;
    private final VideoHomeConfig f3115j;
    private final FrameRateLoggerProvider f3116k;
    private final VideoHomeSessionManager f3117l;

    /* compiled from: skip_android_hash_check */
    public class C02922 {
        final /* synthetic */ VideoHomeHScrollLiveVideosComponentPersistentState f3095a;
        final /* synthetic */ VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition f3096b;

        public C02922(VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition videoHomePaginatedHscrollLiveVideoComponentListPartDefinition, VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState) {
            this.f3096b = videoHomePaginatedHscrollLiveVideoComponentListPartDefinition;
            this.f3095a = videoHomeHScrollLiveVideosComponentPersistentState;
        }

        public final void m2967a() {
            this.f3095a.f2861f = false;
        }
    }

    /* compiled from: skip_android_hash_check */
    class State {
        final OnScrollListener f3102a;
        final VideoHomeHScrollLiveVideosComponentPersistentState f3103b;

        State(OnScrollListener onScrollListener, VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState) {
            this.f3102a = onScrollListener;
            this.f3103b = videoHomeHScrollLiveVideosComponentPersistentState;
        }
    }

    private static VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition m2978b(InjectorLike injectorLike) {
        return new VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), LiveUpdatesManager.a(injectorLike), ReactionHScrollPagerPaddingResolver.a(injectorLike), ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition.a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), VideoHomeLoadingPageHscrollLiveVideoPartDefinition.m2961a(injectorLike), ReactionUnitComponentStyleMapper.a(injectorLike), ReactionUnitValidator.b(injectorLike), VideoHomeConfig.a(injectorLike), VideoHomeSessionManager.a(injectorLike));
    }

    private Callbacks<Object, E> m2970a(VideoHomeHScrollLiveVideosComponentKey videoHomeHScrollLiveVideosComponentKey, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        final DefaultPageInfoFields b = ((ReactionPaginatedComponentFragment) reactionUnitComponentNode.b).dk().c().b();
        final ImmutableList a = m2972a(reactionUnitComponentNode, (CanFetchHScrollSubComponents) e);
        final VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState = (VideoHomeHScrollLiveVideosComponentPersistentState) ((HasPersistentState) e).a(new VideoHomeHScrollLiveVideosComponentKey(reactionUnitComponentNode.c, ((HasRequestInformation) e).kK_()), reactionUnitComponentNode);
        videoHomeHScrollLiveVideosComponentPersistentState.f2859d = a.size();
        videoHomeHScrollLiveVideosComponentPersistentState.f2862g = a;
        final ReactionUnitComponentNode reactionUnitComponentNode2 = reactionUnitComponentNode;
        final E e2 = e;
        final VideoHomeHScrollLiveVideosComponentKey videoHomeHScrollLiveVideosComponentKey2 = videoHomeHScrollLiveVideosComponentKey;
        return new SimpleCallbacks<E>(this) {
            final /* synthetic */ VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition f3094g;

            public final void m2965a(PageSubParts<E> pageSubParts) {
                int size = a.size();
                int i = 0;
                Object obj = null;
                while (i < size) {
                    ReactionUnitComponentFields reactionUnitComponentFields = (ReactionUnitComponentFields) a.get(i);
                    ReactionUnitComponentNode reactionUnitComponentNode = new ReactionUnitComponentNode(reactionUnitComponentFields, reactionUnitComponentNode2.c, reactionUnitComponentNode2.d, reactionUnitComponentNode2.a);
                    MultiRowPartWithIsNeeded a = this.f3094g.f3110e.a(reactionUnitComponentFields.a());
                    if (a.a(reactionUnitComponentNode) && (a instanceof MultiRowSinglePartDefinition)) {
                        obj = 1;
                        pageSubParts.a((MultiRowSinglePartDefinition) a, reactionUnitComponentNode);
                    }
                    i++;
                    obj = obj;
                }
                if (obj == null) {
                    VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition.m2975a(this.f3094g, e2);
                    pageSubParts.a(this.f3094g.f3113h, null);
                    pageSubParts.a(this.f3094g.f3113h, null);
                    pageSubParts.a(this.f3094g.f3113h, null);
                }
            }

            public final void m2966c(int i) {
                if (!a.isEmpty()) {
                    ((VideoHomeHScrollLiveVideosComponentPersistentState) ((HasPersistentState) e2).a(videoHomeHScrollLiveVideosComponentKey2, reactionUnitComponentNode2)).f2860e = i;
                    ((CanHandleHScrollPageChangedEvents) e2).b(i, (ReactionUnitComponentFields) a.get(i), reactionUnitComponentNode2);
                }
                VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition videoHomePaginatedHscrollLiveVideoComponentListPartDefinition = this.f3094g;
                ReactionUnitComponentNode reactionUnitComponentNode = reactionUnitComponentNode2;
                CanFetchHScrollSubComponents canFetchHScrollSubComponents = e2;
                VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState = videoHomeHScrollLiveVideosComponentPersistentState;
                DefaultPageInfoFields defaultPageInfoFields = b;
                if (videoHomeHScrollLiveVideosComponentPersistentState.f2859d - videoHomeHScrollLiveVideosComponentPersistentState.f2860e <= 3 && defaultPageInfoFields != null && defaultPageInfoFields.b() && !videoHomeHScrollLiveVideosComponentPersistentState.f2861f) {
                    canFetchHScrollSubComponents.a(reactionUnitComponentNode, new C02922(videoHomePaginatedHscrollLiveVideoComponentListPartDefinition, videoHomeHScrollLiveVideosComponentPersistentState));
                    videoHomeHScrollLiveVideosComponentPersistentState.f2861f = true;
                }
            }
        };
    }

    public final boolean m2982a(ReactionUnitComponentNode reactionUnitComponentNode) {
        if (reactionUnitComponentNode.b.a() != GraphQLReactionUnitComponentStyle.PAGINATED_H_SCROLL_GENERIC_COMPONENTS_LIST_LIVE_VIDEO) {
            return false;
        }
        return ReactionUnitValidator.b(reactionUnitComponentNode);
    }

    public static VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition m2971a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3105n) {
                VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition videoHomePaginatedHscrollLiveVideoComponentListPartDefinition;
                if (a2 != null) {
                    videoHomePaginatedHscrollLiveVideoComponentListPartDefinition = (VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition) a2.a(f3105n);
                } else {
                    videoHomePaginatedHscrollLiveVideoComponentListPartDefinition = f3104m;
                }
                if (videoHomePaginatedHscrollLiveVideoComponentListPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2978b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3105n, b3);
                        } else {
                            f3104m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomePaginatedHscrollLiveVideoComponentListPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m2980a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanFetchHScrollSubComponents canFetchHScrollSubComponents = (CanFetchHScrollSubComponents) anyEnvironment;
        VideoHomeHScrollLiveVideosComponentKey videoHomeHScrollLiveVideosComponentKey = new VideoHomeHScrollLiveVideosComponentKey(reactionUnitComponentNode.c, ((HasRequestInformation) canFetchHScrollSubComponents).kK_());
        VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState = (VideoHomeHScrollLiveVideosComponentPersistentState) ((HasPersistentState) canFetchHScrollSubComponents).a(videoHomeHScrollLiveVideosComponentKey, reactionUnitComponentNode);
        videoHomeHScrollLiveVideosComponentPersistentState.f2858c = (long) this.f3115j.e;
        int c = SizeUtil.c(((HasContext) canFetchHScrollSubComponents).getContext(), (float) this.f3107b.a(((HasContext) canFetchHScrollSubComponents).getContext(), reactionUnitComponentNode));
        subParts.a(this.f3112g, new StylingData(PageStyle.a));
        subParts.a(this.f3109d, new Props(this.f3108c.a(((float) c) + 8.0f, PageStyle.a, true), videoHomeHScrollLiveVideosComponentPersistentState.f2860e, m2970a(videoHomeHScrollLiveVideosComponentKey, reactionUnitComponentNode, canFetchHScrollSubComponents), reactionUnitComponentNode.g(), reactionUnitComponentNode));
        return new State(m2977b(), videoHomeHScrollLiveVideosComponentPersistentState);
    }

    public final void m2984b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        State state = (State) obj2;
        CanFetchHScrollSubComponents canFetchHScrollSubComponents = (CanFetchHScrollSubComponents) anyEnvironment;
        KeepAttachedHScrollRecyclerView keepAttachedHScrollRecyclerView = (KeepAttachedHScrollRecyclerView) view;
        VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState = state.f3103b;
        if (videoHomeHScrollLiveVideosComponentPersistentState.f2863h != null) {
            this.f3117l.b(videoHomeHScrollLiveVideosComponentPersistentState.f2863h);
        }
        ((CanHandleHScrollPageChangedEvents) canFetchHScrollSubComponents).a(reactionUnitComponentNode);
        if (!this.f3117l.i()) {
            videoHomeHScrollLiveVideosComponentPersistentState.f2857b = SystemClock.uptimeMillis();
        }
        keepAttachedHScrollRecyclerView.b(state.f3102a);
        videoHomeHScrollLiveVideosComponentPersistentState.f2864i = null;
        videoHomeHScrollLiveVideosComponentPersistentState.f2863h = null;
    }

    private void m2973a(ReactionUnitComponentNode reactionUnitComponentNode, E e, KeepAttachedHScrollRecyclerView keepAttachedHScrollRecyclerView, VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState) {
        if (videoHomeHScrollLiveVideosComponentPersistentState.f2863h == null) {
            final VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState2 = videoHomeHScrollLiveVideosComponentPersistentState;
            final E e2 = e;
            final KeepAttachedHScrollRecyclerView keepAttachedHScrollRecyclerView2 = keepAttachedHScrollRecyclerView;
            final ReactionUnitComponentNode reactionUnitComponentNode2 = reactionUnitComponentNode;
            videoHomeHScrollLiveVideosComponentPersistentState.f2863h = new SessionStatusListener(this) {
                final /* synthetic */ VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition f3101e;

                public final void m2968a() {
                }

                public final void kM_() {
                    videoHomeHScrollLiveVideosComponentPersistentState2.f2857b = SystemClock.uptimeMillis();
                }

                public final void kN_() {
                    if (videoHomeHScrollLiveVideosComponentPersistentState2.m2769f()) {
                        ((CanHandleSectionReload) e2).a(keepAttachedHScrollRecyclerView2, videoHomeHScrollLiveVideosComponentPersistentState2, reactionUnitComponentNode2);
                    }
                }

                public final void m2969e() {
                }
            };
        }
        this.f3117l.a(videoHomeHScrollLiveVideosComponentPersistentState.f2863h);
    }

    @Inject
    public VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition(AbstractFbErrorReporter abstractFbErrorReporter, LiveUpdatesManager liveUpdatesManager, ReactionHScrollPagerPaddingResolver reactionHScrollPagerPaddingResolver, ReactionPaginatedHScrollUnitStyledBackgroundPartDefinition reactionPaginatedHScrollUnitStyledBackgroundPartDefinition, FrameRateLoggerProvider frameRateLoggerProvider, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, VideoHomeLoadingPageHscrollLiveVideoPartDefinition videoHomeLoadingPageHscrollLiveVideoPartDefinition, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper, ReactionUnitValidator reactionUnitValidator, VideoHomeConfig videoHomeConfig, VideoHomeSessionManager videoHomeSessionManager) {
        this.f3114i = abstractFbErrorReporter;
        this.f3106a = liveUpdatesManager;
        this.f3107b = reactionHScrollPagerPaddingResolver;
        this.f3112g = reactionPaginatedHScrollUnitStyledBackgroundPartDefinition;
        this.f3116k = frameRateLoggerProvider;
        this.f3108c = pageStyleFactory;
        this.f3109d = persistentRecyclerPartDefinition;
        this.f3113h = videoHomeLoadingPageHscrollLiveVideoPartDefinition;
        this.f3110e = reactionUnitComponentStyleMapper;
        this.f3111f = reactionUnitValidator;
        this.f3115j = videoHomeConfig;
        this.f3117l = videoHomeSessionManager;
    }

    public final ViewType<KeepAttachedHScrollRecyclerView> m2979a() {
        return HScrollRecyclerViewRowType.c;
    }

    private OnScrollListener m2977b() {
        return new FrameRateRecyclerViewScrollListener(this.f3116k.a(Boolean.valueOf(false), "video_home_live_hscroll_perf", Optional.of("video_home")));
    }

    public static void m2975a(VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition videoHomePaginatedHscrollLiveVideoComponentListPartDefinition, CanFetchHScrollSubComponents canFetchHScrollSubComponents) {
        if (((HasReactionSurfaceType) canFetchHScrollSubComponents).d() == Surface.VIDEO_HOME) {
            Object i = ((HasPositionInformation) canFetchHScrollSubComponents).i();
            if (i instanceof ReactionUnitComponentNode) {
                MessageModel bv = ((ReactionUnitComponentNode) i).b.bv();
                if (bv != null) {
                    videoHomePaginatedHscrollLiveVideoComponentListPartDefinition.f3114i.a("VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition.noPages", StringFormatUtil.formatStrLocaleSafe("No needed pages for section: %s", bv.a()));
                }
            }
        }
    }

    private boolean m2976a(E e, @Nullable GraphQLStory graphQLStory) {
        ShownVideosContainer g = ((HasShownVideosContainer) e).g();
        if (g == null || graphQLStory == null) {
            return false;
        }
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        if (o == null || o.r() == null) {
            BLog.b("VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition", "Attachment or video is null for story %s", new Object[]{graphQLStory.c()});
            return false;
        }
        if (g.f2832a.contains(o.r().b()) || this.f3106a.a(o.r())) {
            return true;
        }
        return false;
    }

    private ImmutableList<ReactionUnitComponentFields> m2972a(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        Builder builder = new Builder();
        ImmutableList a = ((ReactionPaginatedComponentFragment) reactionUnitComponentNode.b).dk().c().a();
        VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState = (VideoHomeHScrollLiveVideosComponentPersistentState) ((HasPersistentState) e).a(new VideoHomeHScrollLiveVideosComponentKey(reactionUnitComponentNode.c, ((HasRequestInformation) e).kK_()), reactionUnitComponentNode);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitSubComponentModel a2 = ((EdgesModel) a.get(i)).a();
            if (!videoHomeHScrollLiveVideosComponentPersistentState.f2856a.contains(a2.U()) && (!this.f3115j.c || m2976a((CanFetchHScrollSubComponents) e, a2.ax()))) {
                builder.c(a2);
            }
        }
        return builder.b();
    }

    private void m2974a(ReactionUnitComponentNode reactionUnitComponentNode, State state, E e, KeepAttachedHScrollRecyclerView keepAttachedHScrollRecyclerView) {
        ImmutableList immutableList = state.f3103b.f2862g;
        if (immutableList != null && !immutableList.isEmpty()) {
            VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState = state.f3103b;
            m2973a(reactionUnitComponentNode, (CanFetchHScrollSubComponents) e, keepAttachedHScrollRecyclerView, videoHomeHScrollLiveVideosComponentPersistentState);
            int i = videoHomeHScrollLiveVideosComponentPersistentState.f2860e;
            int i2 = i < immutableList.size() ? i : 0;
            ((CanHandleHScrollPageChangedEvents) e).a(i2, (ReactionUnitComponentFields) immutableList.get(i2), reactionUnitComponentNode);
            keepAttachedHScrollRecyclerView.a(state.f3102a);
            if (videoHomeHScrollLiveVideosComponentPersistentState.m2769f()) {
                ((CanHandleSectionReload) e).a(keepAttachedHScrollRecyclerView, videoHomeHScrollLiveVideosComponentPersistentState, reactionUnitComponentNode);
            }
            if (!this.f3117l.i()) {
                videoHomeHScrollLiveVideosComponentPersistentState.f2857b = 0;
            }
            videoHomeHScrollLiveVideosComponentPersistentState.f2864i = keepAttachedHScrollRecyclerView;
        }
    }
}
