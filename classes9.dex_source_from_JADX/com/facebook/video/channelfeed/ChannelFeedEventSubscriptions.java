package com.facebook.video.channelfeed;

import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.common.time.Clock;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEventSubscriber;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.feedback.ui.EventSubscriptions;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.inject.Assisted;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEventSubscriber;
import com.google.common.base.Function;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: task_key_fetch_native_sign_up_model */
public class ChannelFeedEventSubscriptions implements EventSubscriptions<VideoChannelItemCollection> {
    public final Function<GraphQLStory, Void> f2145a;
    public final FeedStoryMutator f2146b;
    public final Provider<GraphQLActorCache> f2147c;
    public final Clock f2148d;
    public final ReactionsMutationController f2149e;
    public final FeedbackReactionsController f2150f;
    public VideoChannelItemCollection f2151g;

    /* compiled from: task_key_fetch_native_sign_up_model */
    class FeedUnitMutatedEventSubscriber extends com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEventSubscriber {
        final /* synthetic */ ChannelFeedEventSubscriptions f2142a;

        public FeedUnitMutatedEventSubscriber(ChannelFeedEventSubscriptions channelFeedEventSubscriptions) {
            this.f2142a = channelFeedEventSubscriptions;
        }

        public final void m2148b(FbEvent fbEvent) {
            FeedUnit feedUnit = ((FeedUnitMutatedEvent) fbEvent).a;
            if (feedUnit instanceof GraphQLStory) {
                this.f2142a.f2145a.apply((GraphQLStory) feedUnit);
            }
        }
    }

    /* compiled from: task_key_fetch_native_sign_up_model */
    class LikeClickSubscriber extends LikeClickedEventSubscriber {
        final /* synthetic */ ChannelFeedEventSubscriptions f2143a;

        public LikeClickSubscriber(ChannelFeedEventSubscriptions channelFeedEventSubscriptions) {
            this.f2143a = channelFeedEventSubscriptions;
        }

        public final void m2149b(FbEvent fbEvent) {
            FeedProps a = this.f2143a.f2151g.m2560a(((LikeClickedEvent) fbEvent).a);
            if (a != null && ((GraphQLStory) a.a).z()) {
                FeedbackReaction feedbackReaction;
                this.f2143a.f2145a.apply(this.f2143a.f2146b.a(a, ((GraphQLActorCacheImpl) this.f2143a.f2147c.get()).a()).a);
                FeedbackLoggingParams feedbackLoggingParams = new FeedbackLoggingParams(TrackableFeedProps.a(a), "video_channel_feed_ufi", "video_channel_feed");
                if (((GraphQLStory) a.a).l().y_()) {
                    feedbackReaction = FeedbackReaction.c;
                } else {
                    feedbackReaction = this.f2143a.f2150f.d();
                }
                this.f2143a.f2149e.a(((GraphQLStory) a.a).l(), feedbackReaction, feedbackLoggingParams, null);
            }
        }
    }

    /* compiled from: task_key_fetch_native_sign_up_model */
    class StoryVisibilitySubscriber extends StoryVisibilityEventSubscriber {
        final /* synthetic */ ChannelFeedEventSubscriptions f2144a;

        public StoryVisibilitySubscriber(ChannelFeedEventSubscriptions channelFeedEventSubscriptions) {
            this.f2144a = channelFeedEventSubscriptions;
        }

        public final void m2150b(FbEvent fbEvent) {
            StoryVisibilityEvent storyVisibilityEvent = (StoryVisibilityEvent) fbEvent;
            FeedProps a = this.f2144a.f2151g.m2560a(storyVisibilityEvent.a);
            if (a != null) {
                this.f2144a.f2145a.apply((GraphQLStory) FeedUnitMutator.a((FeedUnit) a.a).a(this.f2144a.f2148d.a(), storyVisibilityEvent.d, storyVisibilityEvent.e).a());
            }
        }
    }

    public final /* bridge */ /* synthetic */ void m2151a(Object obj) {
        this.f2151g = (VideoChannelItemCollection) obj;
    }

    @Inject
    public ChannelFeedEventSubscriptions(@Assisted Function<GraphQLStory, Void> function, FeedStoryMutator feedStoryMutator, Provider<GraphQLActorCache> provider, Clock clock, ReactionsMutationController reactionsMutationController, FeedbackReactionsController feedbackReactionsController) {
        this.f2145a = function;
        this.f2146b = feedStoryMutator;
        this.f2147c = provider;
        this.f2148d = clock;
        this.f2149e = reactionsMutationController;
        this.f2150f = feedbackReactionsController;
    }

    public final FbEventSubscriber[] m2152a() {
        return new FbEventSubscriber[]{new LikeClickSubscriber(this), new StoryVisibilitySubscriber(this), new FeedUnitMutatedEventSubscriber(this)};
    }
}
