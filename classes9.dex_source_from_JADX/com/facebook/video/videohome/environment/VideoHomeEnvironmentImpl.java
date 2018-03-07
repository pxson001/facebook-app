package com.facebook.video.videohome.environment;

import android.content.Context;
import android.view.View;
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
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.multirow.api.DirtyUnitObserver;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionItem;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEvents;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImpl;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.facebook.video.videohome.autoplay.VideoHomeAutoDimmingManager;
import com.facebook.video.videohome.autoplay.VideoHomeCenteredAutoplayManager;
import com.facebook.video.videohome.data.VideoHomeReactionItemCollection;
import com.facebook.video.videohome.partdefinitions.VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition.C02922;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager.SessionStatusListener;
import com.facebook.video.videohome.views.VideoHomeVideoPlayerView;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: start_time_ms */
public class VideoHomeEnvironmentImpl extends BaseFeedEnvironment implements HasVideoAutoDimming, HasVideoAutoplay, FeedEnvironment, HasLiveStatusPoller, InjectableComponentWithContext, DirtyUnitObserver, CanHandleHScrollPageChangedEvents, HasReactionAnalyticsParams, HasFeedMenuHelper, CanFetchHScrollSubComponents, CanHandleSectionReload, CanKnowPosition, HasReactionSessionId, HasReactionSurfaceType, HasRequestInformation, HasShownVideosContainer, HasVideoHomePersistentState {
    private final VideoHomeStoryKeyProvider f2840m;
    private final VideoHomeCenteredAutoplayManager f2841n;
    private final VideoHomeAutoDimmingManager f2842o;
    private final VideoFeedStoryMenuHelper f2843p;
    public final LiveStatusTracker f2844q;
    private final VideoHomeReactionItemCollection f2845r;
    private final ShownVideosContainer f2846s = new ShownVideosContainer();
    private final CanHandleHScrollPageChangedEventsImpl f2847t;
    private final VideoHomeCanHandleSectionReloadImpl f2848u;
    private final FeedListType f2849v;
    private final HasReactionAnalyticsParamsImpl f2850w;
    private final String f2851x;
    private final CanFetchHScrollSubComponents f2852y;
    private long f2853z;

    /* compiled from: start_time_ms */
    class C02661 implements SessionStatusListener {
        final /* synthetic */ VideoHomeEnvironmentImpl f2839a;

        C02661(VideoHomeEnvironmentImpl videoHomeEnvironmentImpl) {
            this.f2839a = videoHomeEnvironmentImpl;
        }

        public final void m2746a() {
            this.f2839a.f2844q.c();
        }

        public final void kM_() {
            this.f2839a.f2844q.b();
        }

        public final void kN_() {
            this.f2839a.f2844q.c();
        }

        public final void m2747e() {
            this.f2839a.f2844q.b();
        }
    }

    public final void m2754a(View view, VideoViewController videoViewController) {
        this.f2842o.m2666a((VideoHomeVideoPlayerView) view, videoViewController);
    }

    public final void m2759b(View view, VideoViewController videoViewController) {
        this.f2841n.m2671a((VideoHomeVideoPlayerView) view, videoViewController);
    }

    @Inject
    public VideoHomeEnvironmentImpl(@Assisted Context context, @Assisted FeedListType feedListType, @Nullable @Assisted BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, @Assisted Runnable runnable, @Nullable @Assisted ReactionAnalyticsParams reactionAnalyticsParams, @Assisted String str, @Assisted Delegate delegate, @Assisted VideoHomeReactionItemCollection videoHomeReactionItemCollection, @Assisted LiveStatusTracker liveStatusTracker, @Assisted CanFetchHScrollSubComponents canFetchHScrollSubComponents, VideoHomeCanHandlePageChangedEventsImpl videoHomeCanHandlePageChangedEventsImpl, VideoHomeCanHandleSectionReloadImpl videoHomeCanHandleSectionReloadImpl, VideoHomeLoggingCanHandlePageChangedEventsImpl videoHomeLoggingCanHandlePageChangedEventsImpl, VideoHomeAutoplayCanHandlePageChangedEventsImpl videoHomeAutoplayCanHandlePageChangedEventsImpl, VideoHomePrefetchCanHandlePageChangedEventsImpl videoHomePrefetchCanHandlePageChangedEventsImpl, HasReactionAnalyticsParamsImplProvider hasReactionAnalyticsParamsImplProvider, VideoHomeStoryKeyProvider videoHomeStoryKeyProvider, VideoHomeCenteredAutoplayManager videoHomeCenteredAutoplayManager, VideoHomeAutoDimmingManager videoHomeAutoDimmingManager, VideoHomeSessionManager videoHomeSessionManager, VideoFeedStoryMenuHelperProvider videoFeedStoryMenuHelperProvider) {
        super(context, runnable, delegate);
        this.f2849v = feedListType;
        if (baseFeedStoryMenuHelper != null) {
            baseFeedStoryMenuHelper.a(this);
        }
        this.f2847t = videoHomeCanHandlePageChangedEventsImpl;
        this.f2848u = videoHomeCanHandleSectionReloadImpl;
        this.f2848u.m2745a((HasShownVideosContainer) this);
        this.f2850w = HasReactionAnalyticsParamsImplProvider.a(reactionAnalyticsParams);
        this.f2851x = str;
        this.f2840m = videoHomeStoryKeyProvider;
        videoHomeAutoplayCanHandlePageChangedEventsImpl.m2736a(this);
        videoHomeCanHandlePageChangedEventsImpl.m2741a((CanHandleHScrollPageChangedEvents) videoHomeAutoplayCanHandlePageChangedEventsImpl);
        videoHomeCanHandlePageChangedEventsImpl.m2741a((CanHandleHScrollPageChangedEvents) videoHomeLoggingCanHandlePageChangedEventsImpl);
        videoHomeCanHandlePageChangedEventsImpl.m2741a((CanHandleHScrollPageChangedEvents) videoHomePrefetchCanHandlePageChangedEventsImpl);
        this.f2841n = videoHomeCenteredAutoplayManager;
        this.f2842o = videoHomeAutoDimmingManager;
        this.f2844q = liveStatusTracker;
        this.f2845r = videoHomeReactionItemCollection;
        videoHomeSessionManager.a(new C02661(this));
        this.f2843p = videoFeedStoryMenuHelperProvider.a(this, NegativeFeedbackExperienceLocation.VIDEO_CHANNEL, "video_home");
        this.f2852y = canFetchHScrollSubComponents;
    }

    public final VideoHomeStoryPersistentState m2751a(FeedProps<GraphQLStory> feedProps, String str) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        return (VideoHomeStoryPersistentState) a(this.f2840m.m2791a(feedProps, GraphQLMediaConversionHelper.b(StoryAttachmentHelper.o(graphQLStory).r()), str), graphQLStory);
    }

    public final LiveStatusTracker m2750a() {
        return this.f2844q;
    }

    public final BaseFeedStoryMenuHelper m2762e() {
        return this.f2843p;
    }

    public final BaseFeedStoryMenuHelper m2764l() {
        return m2762e();
    }

    public final int m2749a(@Nullable String str) {
        return this.f2845r.d(str);
    }

    public final int m2748a(int i, String str) {
        int i2;
        VideoHomeReactionItemCollection videoHomeReactionItemCollection = this.f2845r;
        if (i < 0 || videoHomeReactionItemCollection.a() <= i || str == null) {
            i2 = -1;
        } else {
            ReactionItem b = videoHomeReactionItemCollection.b(i);
            if (b == null) {
                i2 = -1;
            } else {
                ImmutableList s = b.k().s();
                int size = s.size();
                int i3 = -1;
                loop0:
                for (int i4 = 0; i4 < size; i4++) {
                    ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) s.get(i4);
                    if (!(reactionUnitComponentModel.dk() == null || reactionUnitComponentModel.dk().c() == null)) {
                        ImmutableList a = ReactionUnitComponentUtil.a(reactionUnitComponentModel);
                        int size2 = a.size();
                        int i5 = 0;
                        while (i5 < size2) {
                            GraphQLStory ax = ((ReactionUnitComponentFields) a.get(i5)).ax();
                            if (ax != null) {
                                i2 = i3 + 1;
                                if (str.equals(ax.g())) {
                                    break loop0;
                                }
                            } else {
                                i2 = i3;
                            }
                            i5++;
                            i3 = i2;
                        }
                        continue;
                    }
                }
                i2 = -1;
            }
        }
        return i2;
    }

    public final ShownVideosContainer m2763g() {
        return this.f2846s;
    }

    public final FeedListType m2760c() {
        return this.f2849v;
    }

    @Nullable
    public final ReactionAnalyticsParams m2765r() {
        return this.f2850w.r();
    }

    public final void m2752a(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f2847t.a(i, reactionUnitComponentFields, reactionUnitComponentNode);
    }

    public final void m2758b(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f2847t.b(i, reactionUnitComponentFields, reactionUnitComponentNode);
    }

    public final void m2756a(ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f2847t.a(reactionUnitComponentNode);
    }

    public final void m2755a(View view, VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState, ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f2848u.m2744a(view, videoHomeHScrollLiveVideosComponentPersistentState, reactionUnitComponentNode);
    }

    public final void m2753a(long j) {
        this.f2853z = j;
    }

    public final long kK_() {
        return this.f2853z;
    }

    public final void m2757a(ReactionUnitComponentNode reactionUnitComponentNode, C02922 c02922) {
        this.f2852y.a(reactionUnitComponentNode, c02922);
    }

    public final Surface m2761d() {
        return Surface.VIDEO_HOME;
    }

    public final String kL_() {
        return this.f2851x;
    }
}
