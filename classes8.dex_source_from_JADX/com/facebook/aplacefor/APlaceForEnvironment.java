package com.facebook.aplacefor;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.feed.autoplay.HasVideoAutoDimming;
import com.facebook.feed.autoplay.HasVideoAutoplay;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.VideoFeedStoryMenuHelper;
import com.facebook.feed.ui.VideoFeedStoryMenuHelperProvider;
import com.facebook.feed.ui.inlinevideoplayer.plugins.HasLiveStatusPoller;
import com.facebook.feed.ui.inlinevideoplayer.plugins.LiveStatusTracker;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.multirow.api.DirtyUnitObserver;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.feed.ReactionItemCollection;
import com.facebook.reaction.feed.environment.CanAddReactionComponents;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImpl;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImplProvider;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEvents;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImpl;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.reaction.feed.environment.HasReactionCardBackground;
import com.facebook.reaction.feed.environment.HasReactionCardContainer;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel.ReactionPaginatedComponentsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.facebook.video.videohome.autoplay.VideoHomeAutoDimmingManager;
import com.facebook.video.videohome.autoplay.VideoHomeCenteredAutoplayManager;
import com.facebook.video.videohome.environment.CanFetchHScrollSubComponents;
import com.facebook.video.videohome.environment.CanHandleSectionReload;
import com.facebook.video.videohome.environment.CanKnowPosition;
import com.facebook.video.videohome.environment.HasReactionSessionId;
import com.facebook.video.videohome.environment.HasReactionSurfaceType;
import com.facebook.video.videohome.environment.HasRequestInformation;
import com.facebook.video.videohome.environment.HasShownVideosContainer;
import com.facebook.video.videohome.environment.HasVideoHomePersistentState;
import com.facebook.video.videohome.environment.ShownVideosContainer;
import com.facebook.video.videohome.environment.VideoHomeAutoplayCanHandlePageChangedEventsImpl;
import com.facebook.video.videohome.environment.VideoHomeCanHandlePageChangedEventsImpl;
import com.facebook.video.videohome.environment.VideoHomeCanHandleSectionReloadImpl;
import com.facebook.video.videohome.environment.VideoHomeHScrollLiveVideosComponentPersistentState;
import com.facebook.video.videohome.environment.VideoHomeLoggingCanHandlePageChangedEventsImpl;
import com.facebook.video.videohome.environment.VideoHomePrefetchCanHandlePageChangedEventsImpl;
import com.facebook.video.videohome.environment.VideoHomeStoryKeyProvider;
import com.facebook.video.videohome.environment.VideoHomeStoryPersistentState;
import com.facebook.video.videohome.partdefinitions.VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition.2;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager$SessionStatusListener;
import com.facebook.video.videohome.utils.VideoHomeLiveUpdatesHelper;
import com.facebook.video.videohome.views.VideoHomeVideoPlayerView;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: land_on_uploads_tab */
public class APlaceForEnvironment extends BaseFeedEnvironment implements HasVideoAutoDimming<VideoHomeVideoPlayerView>, HasVideoAutoplay<VideoHomeVideoPlayerView>, FeedEnvironment, HasLiveStatusPoller, InjectableComponentWithContext, DirtyUnitObserver, CanAddReactionComponents, CanHandleHScrollPageChangedEvents, CanLaunchReactionIntent, HasReactionAnalyticsParams, HasReactionCardBackground, HasReactionCardContainer, HasReactionInteractionTracker, HasReactionSession, HasFeedMenuHelper, CanFetchHScrollSubComponents, CanHandleSectionReload, CanKnowPosition, HasReactionSessionId, HasReactionSurfaceType, HasRequestInformation, HasShownVideosContainer, HasVideoHomePersistentState {
    private final HasReactionAnalyticsParamsImpl f10435A;
    private final CanHandleHScrollPageChangedEventsImpl f10436B;
    private final VideoHomeCanHandleSectionReloadImpl f10437C;
    private final ReactionUtil f10438D;
    public final VideoHomeLiveUpdatesHelper f10439E;
    private final Context f10440m;
    private final ReactionInteractionTracker f10441n;
    private final ReactionIntentLauncher f10442o;
    private final WeakReference<ReactionCardContainer> f10443p;
    private final VideoHomeStoryKeyProvider f10444q;
    private final VideoHomeCenteredAutoplayManager f10445r;
    private final VideoHomeAutoDimmingManager f10446s;
    public final LiveStatusTracker f10447t;
    private final VideoFeedStoryMenuHelper f10448u;
    private final ReactionItemCollection f10449v;
    private final ShownVideosContainer f10450w = new ShownVideosContainer();
    private final FeedListType f10451x;
    private final ReactionSession f10452y;
    private final CanAddReactionComponentsImpl f10453z;

    /* compiled from: land_on_uploads_tab */
    class C11191 implements VideoHomeSessionManager$SessionStatusListener {
        final /* synthetic */ APlaceForEnvironment f10431a;

        C11191(APlaceForEnvironment aPlaceForEnvironment) {
            this.f10431a = aPlaceForEnvironment;
        }

        public final void mo682a() {
            this.f10431a.f10447t.c();
        }

        public final void kM_() {
            this.f10431a.f10447t.b();
        }

        public final void kN_() {
            this.f10431a.f10447t.c();
        }

        public final void mo683e() {
            this.f10431a.f10447t.b();
        }
    }

    /* compiled from: land_on_uploads_tab */
    class FetchHScrollRequestCallback extends AbstractDisposableFutureCallback<GraphQLResult<ReactionMoreSubComponentsResultModel>> {
        final /* synthetic */ APlaceForEnvironment f10432a;
        private final ReactionUnitComponentNode f10433b;
        private final 2 f10434c;

        protected final void m12262a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f10434c.a();
            if (graphQLResult != null && graphQLResult.e != null && ((ReactionMoreSubComponentsResultModel) graphQLResult.e).a() != null) {
                ReactionPaginatedComponentsModel a = ((ReactionMoreSubComponentsResultModel) graphQLResult.e).a();
                this.f10432a.mo694a(a, this.f10433b);
                this.f10432a.f10439E.a(a);
            }
        }

        public FetchHScrollRequestCallback(APlaceForEnvironment aPlaceForEnvironment, ReactionUnitComponentNode reactionUnitComponentNode, 2 2) {
            this.f10432a = aPlaceForEnvironment;
            this.f10433b = reactionUnitComponentNode;
            this.f10434c = 2;
        }

        protected final void m12263a(Throwable th) {
            this.f10434c.a();
        }
    }

    public final void m12288a(View view, VideoViewController videoViewController) {
        this.f10446s.a((VideoHomeVideoPlayerView) view, videoViewController);
    }

    public final void m12297b(View view, VideoViewController videoViewController) {
        this.f10445r.a((VideoHomeVideoPlayerView) view, videoViewController);
    }

    public final VideoHomeStoryPersistentState mo688a(FeedProps<GraphQLStory> feedProps, String str) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        return (VideoHomeStoryPersistentState) a(this.f10444q.a(feedProps, GraphQLMediaConversionHelper.b(StoryAttachmentHelper.o(graphQLStory).r()), str), graphQLStory);
    }

    @Inject
    public APlaceForEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Nullable @Assisted BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, @Assisted Runnable runnable, @Nullable @Assisted ReactionAnalyticsParams reactionAnalyticsParams, @Assisted ReactionInteractionTracker reactionInteractionTracker, @Assisted ReactionSession reactionSession, @Assisted Delegate delegate, @Assisted ReactionItemCollection reactionItemCollection, @Assisted ReactionCardContainer reactionCardContainer, VideoHomeCanHandlePageChangedEventsImpl videoHomeCanHandlePageChangedEventsImpl, VideoHomeCanHandleSectionReloadImpl videoHomeCanHandleSectionReloadImpl, VideoHomeLoggingCanHandlePageChangedEventsImpl videoHomeLoggingCanHandlePageChangedEventsImpl, VideoHomeAutoplayCanHandlePageChangedEventsImpl videoHomeAutoplayCanHandlePageChangedEventsImpl, VideoHomePrefetchCanHandlePageChangedEventsImpl videoHomePrefetchCanHandlePageChangedEventsImpl, HasReactionAnalyticsParamsImplProvider hasReactionAnalyticsParamsImplProvider, VideoHomeStoryKeyProvider videoHomeStoryKeyProvider, VideoHomeCenteredAutoplayManager videoHomeCenteredAutoplayManager, VideoHomeAutoDimmingManager videoHomeAutoDimmingManager, VideoHomeSessionManager videoHomeSessionManager, VideoFeedStoryMenuHelperProvider videoFeedStoryMenuHelperProvider, LiveStatusTracker liveStatusTracker, ReactionIntentLauncher reactionIntentLauncher, CanAddReactionComponentsImplProvider canAddReactionComponentsImplProvider, ReactionUtil reactionUtil, VideoHomeLiveUpdatesHelper videoHomeLiveUpdatesHelper) {
        super(context, runnable, delegate);
        if (baseFeedStoryMenuHelper != null) {
            baseFeedStoryMenuHelper.a(this);
        }
        videoHomeAutoplayCanHandlePageChangedEventsImpl.a(this);
        videoHomeCanHandlePageChangedEventsImpl.a(videoHomeAutoplayCanHandlePageChangedEventsImpl);
        videoHomeCanHandlePageChangedEventsImpl.a(videoHomeLoggingCanHandlePageChangedEventsImpl);
        videoHomeCanHandlePageChangedEventsImpl.a(videoHomePrefetchCanHandlePageChangedEventsImpl);
        videoHomeSessionManager.a(new C11191(this));
        this.f10440m = context;
        this.f10441n = reactionInteractionTracker;
        this.f10442o = reactionIntentLauncher;
        this.f10444q = videoHomeStoryKeyProvider;
        this.f10445r = videoHomeCenteredAutoplayManager;
        this.f10446s = videoHomeAutoDimmingManager;
        this.f10447t = liveStatusTracker;
        this.f10448u = videoFeedStoryMenuHelperProvider.a(this, NegativeFeedbackExperienceLocation.A_PLACE_FOR, "a_place_for");
        this.f10449v = reactionItemCollection;
        this.f10451x = feedListType;
        this.f10452y = reactionSession;
        this.f10453z = CanAddReactionComponentsImplProvider.m23141a(this);
        this.f10435A = HasReactionAnalyticsParamsImplProvider.m23151a(reactionAnalyticsParams);
        this.f10436B = videoHomeCanHandlePageChangedEventsImpl;
        this.f10437C = videoHomeCanHandleSectionReloadImpl;
        this.f10438D = reactionUtil;
        this.f10439E = videoHomeLiveUpdatesHelper;
        this.f10443p = new WeakReference(reactionCardContainer);
    }

    public final LiveStatusTracker m12284a() {
        return this.f10447t;
    }

    public final BaseFeedStoryMenuHelper m12300e() {
        return this.f10448u;
    }

    public final BaseFeedStoryMenuHelper m12302l() {
        return m12300e();
    }

    public final int mo687a(@Nullable String str) {
        return this.f10449v.m22978d(str);
    }

    public final int mo686a(int i, String str) {
        return -1;
    }

    public final ShownVideosContainer mo700g() {
        return this.f10450w;
    }

    public final FeedListType m12298c() {
        return this.f10451x;
    }

    public final ReactionInteractionTracker kE_() {
        return this.f10441n;
    }

    public final ReactionSession mo704p() {
        return this.f10452y;
    }

    public final void mo695a(String str, String str2, @Nullable ReactionAttachmentIntent reactionAttachmentIntent) {
        if (reactionAttachmentIntent != null) {
            ReactionCardContainer reactionCardContainer = (ReactionCardContainer) this.f10443p.get();
            if (reactionCardContainer != null) {
                if (this.f10441n != null) {
                    this.f10441n.mo981a(str, str2, reactionAttachmentIntent);
                }
                this.f10442o.m24384a(str, reactionAttachmentIntent, reactionCardContainer, this.f10440m);
            }
        }
    }

    public final void mo696a(String str, String str2, @Nullable String str3, @Nullable ReactionAttachmentIntent reactionAttachmentIntent) {
        if (reactionAttachmentIntent != null) {
            ReactionCardContainer reactionCardContainer = (ReactionCardContainer) this.f10443p.get();
            if (reactionCardContainer != null) {
                if (this.f10441n != null) {
                    this.f10441n.m18943a(str, str2, str3, reactionAttachmentIntent);
                }
                this.f10442o.m24384a(str, reactionAttachmentIntent, reactionCardContainer, this.f10440m);
            }
        }
    }

    @Nullable
    public final ReactionCardContainer mo705q() {
        return (ReactionCardContainer) this.f10443p.get();
    }

    public final void mo694a(ReactionPaginatedComponentsModel reactionPaginatedComponentsModel, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f10453z.mo694a(reactionPaginatedComponentsModel, reactionUnitComponentNode);
    }

    @Nullable
    public final ReactionAnalyticsParams mo706r() {
        return this.f10435A.mo706r();
    }

    public final void mo689a(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f10436B.mo689a(i, reactionUnitComponentFields, reactionUnitComponentNode);
    }

    public final void mo698b(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f10436B.mo698b(i, reactionUnitComponentFields, reactionUnitComponentNode);
    }

    public final void mo692a(ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f10436B.mo692a(reactionUnitComponentNode);
    }

    public final void mo691a(View view, VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f10437C.a(view, videoHomeHScrollLiveVideosComponentPersistentState, reactionUnitComponentNode);
    }

    public final void mo690a(long j) {
    }

    public final long kK_() {
        return 0;
    }

    public final Drawable mo697b(ReactionUnitComponentNode reactionUnitComponentNode) {
        return new ColorDrawable(-1);
    }

    public final Surface mo699d() {
        return Surface.A_PLACE_FOR;
    }

    public final String kL_() {
        return this.f10452y.f18658a;
    }

    public final void mo693a(ReactionUnitComponentNode reactionUnitComponentNode, 2 2) {
        PaginatedComponentsModel c = ReactionUnitComponentUtil.m22903c(reactionUnitComponentNode);
        DefaultPageInfoFields b = c.c().b();
        this.f10438D.m22664a(b.a(), new FetchHScrollRequestCallback(this, reactionUnitComponentNode, 2), 5, c.b(), this.f10452y);
    }
}
