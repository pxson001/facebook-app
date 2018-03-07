package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feed.environment.HasScrollListenerSupport.SimpleScrollListener;
import com.facebook.feed.feature.ExperimentsForFeedFeatureModule;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.ui.TranscodedAnimatedImageShareAttachmentView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.StoryAttachmentUtil;
import com.facebook.feed.video.util.VideoUtils;
import com.facebook.feedplugins.attachments.video.FeedAnalyticsUtil;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.attachments.video.InlineVideoStoryKey;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegate;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegateProvider;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo.Builder;
import com.facebook.video.engine.AbstractVideoPlayerListener;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.Constants.VideoMediaState;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerListener;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.feed.FeedVideoPlayerParamBuilder;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.InlineVideoPlayer;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.google.common.base.Absent;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: WaitTime */
public class TranscodedAnimatedImageShareAttachmentPartDefinition<E extends HasInvalidate & HasPositionInformation & HasFeedListType & HasPersistentState & HasPrefetcher & HasScrollListenerSupport> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, TranscodedAnimatedImageShareAttachmentView> {
    public static final ViewType f20842a = new C17781();
    private static final PaddingStyle f20843b = PaddingStyle.a;
    private static TranscodedAnimatedImageShareAttachmentPartDefinition f20844m;
    private static final Object f20845n = new Object();
    private final AttachmentLinkPartDefinition<E> f20846c;
    private final BackgroundPartDefinition f20847d;
    private final StoryAttachmentUtil f20848e;
    public final Provider<TriState> f20849f;
    public final VideoAutoPlaySettingsChecker f20850g;
    private final QeAccessor f20851h;
    private final VideoAttachmentDelegateProvider f20852i;
    private final FeedVideoPlayerParamBuilderProvider f20853j;
    public final VideoLoggingUtils f20854k;
    private final AutoplayStateManagerProvider f20855l;

    /* compiled from: WaitTime */
    final class C17781 extends ViewType {
        C17781() {
        }

        public final View m23779a(Context context) {
            return new TranscodedAnimatedImageShareAttachmentView(context);
        }
    }

    /* compiled from: WaitTime */
    class OnScrollListener implements SimpleScrollListener {
        final /* synthetic */ TranscodedAnimatedImageShareAttachmentPartDefinition f20822a;
        private State f20823b;

        public OnScrollListener(TranscodedAnimatedImageShareAttachmentPartDefinition transcodedAnimatedImageShareAttachmentPartDefinition) {
            this.f20822a = transcodedAnimatedImageShareAttachmentPartDefinition;
        }

        public final void m23781a(State state) {
            this.f20823b = state;
        }

        public final void m23780a() {
            if (this.f20823b.f20827a != null) {
                TranscodedAnimatedImageShareAttachmentView transcodedAnimatedImageShareAttachmentView = this.f20823b.f20827a;
                boolean c = this.f20823b.f20828b.c(transcodedAnimatedImageShareAttachmentView);
                boolean j = transcodedAnimatedImageShareAttachmentView.f21105b.j();
                boolean z;
                if (!c || j) {
                    z = false;
                } else {
                    this.f20823b.f20837k.clear();
                    z = this.f20823b.f20836j.a(this.f20823b.f20837k);
                }
                if (!c) {
                    VideoUtils.a(this.f20823b.f20832f);
                } else if (!j) {
                    VideoUtils.a(this.f20823b.f20832f, this.f20823b.f20837k, this.f20822a.f20850g, this.f20822a.f20854k, this.f20823b.f20829c.e, this.f20823b.f20829c.b, this.f20823b.f20828b.f(), this.f20823b.f20829c.f, ChannelEligibility.WRONG_STORY_TYPE, this.f20823b.f20829c);
                }
                if (!c && j) {
                    TranscodedAnimatedImageShareAttachmentPartDefinition.m23794a(this.f20822a, transcodedAnimatedImageShareAttachmentView, EventTriggerType.BY_AUTOPLAY);
                    this.f20823b.f20835i.a(transcodedAnimatedImageShareAttachmentView.getInlineVideoPlayer().getCurrentPosition());
                } else if (c && !j && r10) {
                    TranscodedAnimatedImageShareAttachmentPartDefinition transcodedAnimatedImageShareAttachmentPartDefinition = this.f20822a;
                    EventTriggerType eventTriggerType = EventTriggerType.BY_AUTOPLAY;
                    VideoFeedStoryInfo videoFeedStoryInfo = this.f20823b.f20831e;
                    VideoAttachmentDelegate videoAttachmentDelegate = this.f20823b.f20828b;
                    videoFeedStoryInfo.b = eventTriggerType;
                    videoAttachmentDelegate.a(eventTriggerType);
                    transcodedAnimatedImageShareAttachmentView.getDelegate().a(this.f20823b.f20831e);
                    TranscodedAnimatedImageShareAttachmentPartDefinition.m23795a(this.f20822a, transcodedAnimatedImageShareAttachmentView, EventTriggerType.BY_AUTOPLAY, new PlayPosition(this.f20823b.f20835i.a(), this.f20823b.f20835i.a()));
                }
            }
        }
    }

    /* compiled from: WaitTime */
    class OnVideoEventListener extends AbstractVideoPlayerListener {
        final /* synthetic */ TranscodedAnimatedImageShareAttachmentPartDefinition f20824a;
        private State f20825b;
        private boolean f20826c = false;

        public OnVideoEventListener(TranscodedAnimatedImageShareAttachmentPartDefinition transcodedAnimatedImageShareAttachmentPartDefinition) {
            this.f20824a = transcodedAnimatedImageShareAttachmentPartDefinition;
        }

        public final void m23783a(State state) {
            this.f20825b = state;
        }

        public final void m23785a(EventTriggerType eventTriggerType, boolean z) {
            super.a(eventTriggerType, z);
            if (!(this.f20825b.f20827a == null || this.f20826c)) {
                this.f20825b.f20827a.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.LOADING);
            }
            this.f20825b.f20836j.d();
        }

        public final void m23789c(EventTriggerType eventTriggerType) {
            super.c(eventTriggerType);
            this.f20826c = true;
            if (this.f20825b.f20827a != null) {
                this.f20825b.f20827a.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.DONE_LOADING);
            }
        }

        public final void m23788b(EventTriggerType eventTriggerType, boolean z) {
            super.b(eventTriggerType, z);
            if (this.f20825b.f20827a != null) {
                this.f20825b.f20827a.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.READY_TO_PLAY);
            }
        }

        public final void m23787b(EventTriggerType eventTriggerType) {
            super.b(eventTriggerType);
            this.f20826c = false;
        }

        public final void m23784a(EventTriggerType eventTriggerType) {
            super.a(eventTriggerType);
            this.f20826c = false;
            if (this.f20825b.f20827a != null) {
                this.f20825b.f20827a.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.READY_TO_PLAY);
            }
        }

        public final void m23790d() {
            super.d();
            if (this.f20825b.f20827a != null) {
                TranscodedAnimatedImageShareAttachmentPartDefinition transcodedAnimatedImageShareAttachmentPartDefinition = this.f20824a;
                TranscodedAnimatedImageShareAttachmentPartDefinition.m23796a(this.f20825b.f20827a);
            }
        }

        public final void m23782a(int i) {
            TranscodedAnimatedImageShareAttachmentPartDefinition transcodedAnimatedImageShareAttachmentPartDefinition = this.f20824a;
            EventTriggerType eventTriggerType = EventTriggerType.BY_USER;
            VideoFeedStoryInfo videoFeedStoryInfo = this.f20825b.f20831e;
            VideoAttachmentDelegate videoAttachmentDelegate = this.f20825b.f20828b;
            videoFeedStoryInfo.b = eventTriggerType;
            videoAttachmentDelegate.a(eventTriggerType);
        }

        public final void m23786a(String str, VideoError videoError) {
            if (videoError.value.equals(VideoError.ERROR_IO.value)) {
                this.f20825b.f20836j.i();
            }
        }
    }

    /* compiled from: WaitTime */
    public class State {
        public TranscodedAnimatedImageShareAttachmentView f20827a;
        public final VideoAttachmentDelegate f20828b;
        public final VideoPlayerParams f20829c;
        public final VideoPlayerListener f20830d;
        public final VideoFeedStoryInfo f20831e;
        public final VideoDisplayedInfo f20832f;
        public final OnClickListener f20833g;
        public final GraphQLStoryAttachment f20834h;
        public final InlineVideoPersistentState f20835i;
        public final AutoplayStateManager f20836j;
        public final Set<AutoPlayFailureReason> f20837k;
        public final SimpleScrollListener f20838l;
        public final CharSequence f20839m;

        public State(VideoAttachmentDelegate videoAttachmentDelegate, VideoPlayerParams videoPlayerParams, VideoPlayerListener videoPlayerListener, VideoFeedStoryInfo videoFeedStoryInfo, VideoDisplayedInfo videoDisplayedInfo, OnClickListener onClickListener, GraphQLStoryAttachment graphQLStoryAttachment, InlineVideoPersistentState inlineVideoPersistentState, AutoplayStateManager autoplayStateManager, Set<AutoPlayFailureReason> set, SimpleScrollListener simpleScrollListener, CharSequence charSequence) {
            this.f20828b = videoAttachmentDelegate;
            this.f20829c = videoPlayerParams;
            this.f20830d = videoPlayerListener;
            this.f20831e = videoFeedStoryInfo;
            this.f20832f = videoDisplayedInfo;
            this.f20833g = onClickListener;
            this.f20834h = graphQLStoryAttachment;
            this.f20835i = inlineVideoPersistentState;
            this.f20836j = autoplayStateManager;
            this.f20837k = set;
            this.f20838l = simpleScrollListener;
            this.f20839m = charSequence;
        }
    }

    /* compiled from: WaitTime */
    class VideoPlayerOnClickListener implements OnClickListener {
        final /* synthetic */ TranscodedAnimatedImageShareAttachmentPartDefinition f20840a;
        private final AutoplayStateManager f20841b;

        public VideoPlayerOnClickListener(TranscodedAnimatedImageShareAttachmentPartDefinition transcodedAnimatedImageShareAttachmentPartDefinition, AutoplayStateManager autoplayStateManager) {
            this.f20840a = transcodedAnimatedImageShareAttachmentPartDefinition;
            this.f20841b = autoplayStateManager;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -550415235);
            TranscodedAnimatedImageShareAttachmentView transcodedAnimatedImageShareAttachmentView = (TranscodedAnimatedImageShareAttachmentView) view;
            if (transcodedAnimatedImageShareAttachmentView.f21105b.b()) {
                this.f20841b.e();
                TranscodedAnimatedImageShareAttachmentPartDefinition transcodedAnimatedImageShareAttachmentPartDefinition = this.f20840a;
                EventTriggerType eventTriggerType = EventTriggerType.BY_USER;
                transcodedAnimatedImageShareAttachmentView.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.READY_TO_PLAY);
                transcodedAnimatedImageShareAttachmentView.f21105b.a(eventTriggerType, VideoMediaState.PAUSED);
                Logger.a(2, EntryType.UI_INPUT_END, 131033310, a);
                return;
            }
            transcodedAnimatedImageShareAttachmentPartDefinition = this.f20840a;
            eventTriggerType = EventTriggerType.BY_USER;
            transcodedAnimatedImageShareAttachmentView.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.LOADING);
            transcodedAnimatedImageShareAttachmentView.f21105b.a(eventTriggerType);
            LogUtils.a(1366559353, a);
        }
    }

    private static TranscodedAnimatedImageShareAttachmentPartDefinition m23797b(InjectorLike injectorLike) {
        return new TranscodedAnimatedImageShareAttachmentPartDefinition(AttachmentLinkPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), StoryAttachmentUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 683), VideoAutoPlaySettingsChecker.a(injectorLike), (VideoAttachmentDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoAttachmentDelegateProvider.class), (FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), VideoLoggingUtils.a(injectorLike), (AutoplayStateManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class));
    }

    public static TranscodedAnimatedImageShareAttachmentPartDefinition m23792a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TranscodedAnimatedImageShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20845n) {
                TranscodedAnimatedImageShareAttachmentPartDefinition transcodedAnimatedImageShareAttachmentPartDefinition;
                if (a2 != null) {
                    transcodedAnimatedImageShareAttachmentPartDefinition = (TranscodedAnimatedImageShareAttachmentPartDefinition) a2.a(f20845n);
                } else {
                    transcodedAnimatedImageShareAttachmentPartDefinition = f20844m;
                }
                if (transcodedAnimatedImageShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23797b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20845n, b3);
                        } else {
                            f20844m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = transcodedAnimatedImageShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m23803b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        TranscodedAnimatedImageShareAttachmentView transcodedAnimatedImageShareAttachmentView = (TranscodedAnimatedImageShareAttachmentView) view;
        if (transcodedAnimatedImageShareAttachmentView.f21105b.b()) {
            state.f20835i.a(transcodedAnimatedImageShareAttachmentView.f21105b.getCurrentPosition());
        }
        transcodedAnimatedImageShareAttachmentView.f21106c.b();
        m23796a(transcodedAnimatedImageShareAttachmentView);
        ((HasScrollListenerSupport) hasInvalidate).b(state.f20838l);
        state.f20827a = null;
    }

    @Inject
    public TranscodedAnimatedImageShareAttachmentPartDefinition(AttachmentLinkPartDefinition attachmentLinkPartDefinition, BackgroundPartDefinition backgroundPartDefinition, StoryAttachmentUtil storyAttachmentUtil, QeAccessor qeAccessor, Provider<TriState> provider, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoAttachmentDelegateProvider videoAttachmentDelegateProvider, FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, VideoLoggingUtils videoLoggingUtils, AutoplayStateManagerProvider autoplayStateManagerProvider) {
        this.f20846c = attachmentLinkPartDefinition;
        this.f20847d = backgroundPartDefinition;
        this.f20848e = storyAttachmentUtil;
        this.f20849f = provider;
        this.f20850g = videoAutoPlaySettingsChecker;
        this.f20852i = videoAttachmentDelegateProvider;
        this.f20853j = feedVideoPlayerParamBuilderProvider;
        this.f20854k = videoLoggingUtils;
        this.f20851h = qeAccessor;
        this.f20855l = autoplayStateManagerProvider;
    }

    public final ViewType<TranscodedAnimatedImageShareAttachmentView> m23798a() {
        return f20842a;
    }

    public final boolean m23801a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        boolean z = !GraphQLStoryAttachmentUtil.i(graphQLStoryAttachment) || this.f20851h.a(ExperimentsForFeedFeatureModule.b, false);
        GraphQLMedia r = graphQLStoryAttachment.r();
        if (!z || ((TriState) this.f20849f.get()).asBoolean(true) || r == null || r.j() == null || r.j().g() != 82650203) {
            return false;
        }
        return true;
    }

    private State m23791a(SubParts<E> subParts, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        Object stylingData;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a();
        if (GraphQLStoryAttachmentUtil.i(graphQLStoryAttachment)) {
            stylingData = new StylingData(AttachmentProps.e(feedProps), f20843b);
        } else {
            stylingData = new StylingData(AttachmentProps.e(feedProps), f20843b, 2130840170, -1);
        }
        subParts.a(this.f20847d, stylingData);
        if (!GraphQLStoryAttachmentUtil.i(graphQLStoryAttachment)) {
            subParts.a(this.f20846c, new Props(feedProps));
        }
        VideoAttachmentDelegate a = this.f20852i.a(feedProps, Absent.withType());
        GraphQLVideo c = a.c();
        FeedVideoPlayerParamBuilder a2 = this.f20853j.a(feedProps, c);
        a.a(FeedAnalyticsUtil.a(((HasFeedListType) e).c()), (HasPrefetcher) e);
        VideoPlayerParams a3 = a2.a();
        OnVideoEventListener onVideoEventListener = new OnVideoEventListener(this);
        VideoFeedStoryInfo a4 = new Builder(a3.e).a(ChannelEligibility.WRONG_STORY_TYPE).a(a3.f).a();
        VideoDisplayedInfo videoDisplayedInfo = new VideoDisplayedInfo();
        FeedProps e2 = AttachmentProps.e(feedProps);
        InlineVideoPersistentState inlineVideoPersistentState = (InlineVideoPersistentState) ((HasPersistentState) e).a(new InlineVideoStoryKey(e2, c, this.f20855l), (CacheableEntity) e2.a());
        AutoplayStateManager b = inlineVideoPersistentState.b();
        OnClickListener videoPlayerOnClickListener = new VideoPlayerOnClickListener(this, b);
        Set hashSet = new HashSet();
        OnScrollListener onScrollListener = new OnScrollListener(this);
        State state = new State(a, a3, onVideoEventListener, a4, videoDisplayedInfo, videoPlayerOnClickListener, graphQLStoryAttachment, inlineVideoPersistentState, b, hashSet, onScrollListener, !GraphQLStoryAttachmentUtil.i(graphQLStoryAttachment) ? StoryAttachmentUtil.a(graphQLStoryAttachment) : null);
        onVideoEventListener.m23783a(state);
        onScrollListener.m23781a(state);
        return state;
    }

    private void m23793a(FeedProps<GraphQLStoryAttachment> feedProps, State state, E e, TranscodedAnimatedImageShareAttachmentView transcodedAnimatedImageShareAttachmentView) {
        boolean z;
        state.f20827a = transcodedAnimatedImageShareAttachmentView;
        ((HasScrollListenerSupport) e).a(state.f20838l);
        transcodedAnimatedImageShareAttachmentView.f21106c.a(state.f20833g, transcodedAnimatedImageShareAttachmentView);
        transcodedAnimatedImageShareAttachmentView.f21106c.a(PlayerOrigin.FEED, true, state.f20829c, RegularImmutableBiMap.a);
        InlineVideoPlayer inlineVideoPlayer = transcodedAnimatedImageShareAttachmentView.f21105b;
        inlineVideoPlayer.A = false;
        inlineVideoPlayer.B = false;
        inlineVideoPlayer.y = false;
        inlineVideoPlayer.C = true;
        inlineVideoPlayer.setVideoListener(state.f20830d);
        inlineVideoPlayer.g();
        state.f20828b.a(transcodedAnimatedImageShareAttachmentView.f21106c);
        state.f20832f.b(false);
        m23796a(transcodedAnimatedImageShareAttachmentView);
        if (state.f20839m != null) {
            transcodedAnimatedImageShareAttachmentView.f21107d.setText(state.f20839m);
        }
        if (GraphQLStoryAttachmentUtil.i((GraphQLStoryAttachment) feedProps.a)) {
            z = false;
        } else {
            z = true;
        }
        transcodedAnimatedImageShareAttachmentView.f21107d.setVisibility(z ? 0 : 8);
    }

    public static void m23796a(TranscodedAnimatedImageShareAttachmentView transcodedAnimatedImageShareAttachmentView) {
        InlineVideoPlayer inlineVideoPlayer = transcodedAnimatedImageShareAttachmentView.f21105b;
        if (inlineVideoPlayer.b()) {
            inlineVideoPlayer.getInlineVideoView().setVisibility(0);
            inlineVideoPlayer.getCoverImage().setVisibility(4);
            transcodedAnimatedImageShareAttachmentView.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.HIDDEN);
            return;
        }
        inlineVideoPlayer.getInlineVideoView().setVisibility(4);
        inlineVideoPlayer.getCoverImage().setVisibility(0);
        transcodedAnimatedImageShareAttachmentView.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.READY_TO_PLAY);
    }

    static /* synthetic */ void m23795a(TranscodedAnimatedImageShareAttachmentPartDefinition transcodedAnimatedImageShareAttachmentPartDefinition, TranscodedAnimatedImageShareAttachmentView transcodedAnimatedImageShareAttachmentView, EventTriggerType eventTriggerType, PlayPosition playPosition) {
        transcodedAnimatedImageShareAttachmentView.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.LOADING);
        transcodedAnimatedImageShareAttachmentView.f21105b.a(eventTriggerType, playPosition);
    }

    static /* synthetic */ void m23794a(TranscodedAnimatedImageShareAttachmentPartDefinition transcodedAnimatedImageShareAttachmentPartDefinition, TranscodedAnimatedImageShareAttachmentView transcodedAnimatedImageShareAttachmentView, EventTriggerType eventTriggerType) {
        transcodedAnimatedImageShareAttachmentView.setPlayButtonState(com.facebook.gif.AnimatedImagePlayButtonView.State.READY_TO_PLAY);
        transcodedAnimatedImageShareAttachmentView.f21105b.a(eventTriggerType, VideoMediaState.PAUSED);
    }
}
