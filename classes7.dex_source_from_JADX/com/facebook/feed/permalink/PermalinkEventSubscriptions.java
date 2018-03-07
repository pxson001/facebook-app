package com.facebook.feed.permalink;

import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.permalink.PermalinkController.C16932;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.ui.controllers.SeeMoreController;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEvent;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEventSubscriber;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEventSubscriber;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.feedback.logging.FeedbackAnalyticsLogger;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.ui.CommentsHelper;
import com.facebook.feedback.ui.EventSubscriptions;
import com.facebook.feedback.ui.FeedbackController;
import com.facebook.feedback.ui.FeedbackControllerParams;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.inject.Assisted;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.ufiservices.event.UfiEvents.CommentButtonClickedEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.ReactionUpdatedEvent;
import com.facebook.ufiservices.event.UfiEvents.SetNotifyMeEvent;
import com.facebook.ufiservices.event.UfiEvents.SetNotifyMeEventSubscriber;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: after_timestamp */
public class PermalinkEventSubscriptions implements EventSubscriptions<GraphQLStory> {
    public final FeedbackAnalyticsLogger f19579a;
    public final FeedbackController f19580b;
    public final FeedStoryMutator f19581c;
    public final GraphQLNotificationsContentProviderHelper f19582d;
    public final PermalinkController f19583e;
    public final Function<GraphQLStory, Void> f19584f;
    public final CommentsHelper f19585g;
    public final SeeMoreController f19586h;
    public final Provider<GraphQLActorCache> f19587i;
    public final ReactionsMutationController f19588j;
    public FeedbackLoggingParams f19589k;
    public FeedProps<GraphQLStory> f19590l;

    /* compiled from: after_timestamp */
    public class C16951 implements FutureCallback<GraphQLStory> {
        final /* synthetic */ PermalinkEventSubscriptions f19571a;

        public C16951(PermalinkEventSubscriptions permalinkEventSubscriptions) {
            this.f19571a = permalinkEventSubscriptions;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f19571a.f19584f.apply((GraphQLStory) obj);
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: after_timestamp */
    public class CommentButtonClickSubscriber extends CommentButtonClickedEventSubscriber {
        final /* synthetic */ PermalinkEventSubscriptions f19572a;

        public CommentButtonClickSubscriber(PermalinkEventSubscriptions permalinkEventSubscriptions) {
            this.f19572a = permalinkEventSubscriptions;
        }

        public final void m22882b(FbEvent fbEvent) {
            this.f19572a.f19585g.m4971f();
        }
    }

    /* compiled from: after_timestamp */
    public class FeedUnitMutatedEventSubscriber extends com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEventSubscriber {
        final /* synthetic */ PermalinkEventSubscriptions f19573a;

        public FeedUnitMutatedEventSubscriber(PermalinkEventSubscriptions permalinkEventSubscriptions) {
            this.f19573a = permalinkEventSubscriptions;
        }

        public final void m22883b(FbEvent fbEvent) {
            FeedUnit feedUnit = ((FeedUnitMutatedEvent) fbEvent).a;
            if (feedUnit instanceof GraphQLStory) {
                this.f19573a.f19584f.apply((GraphQLStory) feedUnit);
            }
        }
    }

    /* compiled from: after_timestamp */
    public class LikeClickSubscriber extends LikeClickedEventSubscriber {
        final /* synthetic */ PermalinkEventSubscriptions f19574a;

        public LikeClickSubscriber(PermalinkEventSubscriptions permalinkEventSubscriptions) {
            this.f19574a = permalinkEventSubscriptions;
        }

        public final void m22884b(FbEvent fbEvent) {
            FeedProps a = StoryProps.a(this.f19574a.f19590l, ((LikeClickedEvent) fbEvent).a);
            if (a != null && a.a != null && ((GraphQLStory) a.a).z()) {
                GraphQLStory graphQLStory = (GraphQLStory) a.a;
                FeedUnit f = StoryProps.f(this.f19574a.f19581c.a(a, ((GraphQLActorCacheImpl) this.f19574a.f19587i.get()).a()));
                if (f instanceof GraphQLStory) {
                    this.f19574a.f19584f.apply((GraphQLStory) f);
                }
                this.f19574a.f19580b.m5067a(graphQLStory.l(), this.f19574a.f19589k);
                this.f19574a.f19579a.b(graphQLStory.l(), this.f19574a.f19589k);
            }
        }
    }

    /* compiled from: after_timestamp */
    public class ReactionUpdatedEventSubscriber extends com.facebook.ufiservices.event.UfiEvents.ReactionUpdatedEventSubscriber {
        final /* synthetic */ PermalinkEventSubscriptions f19575a;

        public ReactionUpdatedEventSubscriber(PermalinkEventSubscriptions permalinkEventSubscriptions) {
            this.f19575a = permalinkEventSubscriptions;
        }

        public final void m22885b(FbEvent fbEvent) {
            ReactionUpdatedEvent reactionUpdatedEvent = (ReactionUpdatedEvent) fbEvent;
            if (this.f19575a.f19590l != null) {
                this.f19575a.f19584f.apply(this.f19575a.f19588j.a((GraphQLStory) this.f19575a.f19590l.a, reactionUpdatedEvent.a, reactionUpdatedEvent.c));
            }
        }
    }

    /* compiled from: after_timestamp */
    public class SetNotifyMeSubscriber extends SetNotifyMeEventSubscriber {
        final /* synthetic */ PermalinkEventSubscriptions f19576a;

        public SetNotifyMeSubscriber(PermalinkEventSubscriptions permalinkEventSubscriptions) {
            this.f19576a = permalinkEventSubscriptions;
        }

        public final void m22886b(FbEvent fbEvent) {
            SetNotifyMeEvent setNotifyMeEvent = (SetNotifyMeEvent) fbEvent;
            PermalinkController permalinkController = this.f19576a.f19583e;
            permalinkController.f19568j.a(setNotifyMeEvent.a, setNotifyMeEvent.h, "permalink_set_notify_me", "native_newsfeed", new C16932(permalinkController));
        }
    }

    /* compiled from: after_timestamp */
    public class StoryDeleteSubscriber extends StoryDeleteEventSubscriber {
        final /* synthetic */ PermalinkEventSubscriptions f19577a;

        public StoryDeleteSubscriber(PermalinkEventSubscriptions permalinkEventSubscriptions) {
            this.f19577a = permalinkEventSubscriptions;
        }

        public final void m22887b(FbEvent fbEvent) {
            String b = ((StoryDeleteEvent) fbEvent).b();
            if (b != null && this.f19577a.f19590l != null && StringUtil.a(b, Strings.nullToEmpty(((GraphQLStory) this.f19577a.f19590l.a).ai()))) {
                this.f19577a.f19582d.a(ImmutableList.of(((GraphQLStory) this.f19577a.f19590l.a).c()), false);
            }
        }
    }

    /* compiled from: after_timestamp */
    public class StoryVisibilitySubscriber extends StoryVisibilityEventSubscriber {
        final /* synthetic */ PermalinkEventSubscriptions f19578a;

        public StoryVisibilitySubscriber(PermalinkEventSubscriptions permalinkEventSubscriptions) {
            this.f19578a = permalinkEventSubscriptions;
        }

        public final void m22888b(FbEvent fbEvent) {
            StoryVisibilityEvent storyVisibilityEvent = (StoryVisibilityEvent) fbEvent;
            if (this.f19578a.f19590l != null) {
                GraphQLStory a = this.f19578a.f19581c.a((GraphQLStory) this.f19578a.f19590l.a);
                if (storyVisibilityEvent.a != null && storyVisibilityEvent.a.equals(a.g())) {
                    this.f19578a.f19584f.apply((GraphQLStory) FeedUnitMutator.a(a).a(storyVisibilityEvent.d).a(storyVisibilityEvent.e).a());
                }
            }
        }
    }

    @Inject
    public PermalinkEventSubscriptions(@Assisted Function<GraphQLStory, Void> function, @Assisted CommentsHelper commentsHelper, FeedbackAnalyticsLogger feedbackAnalyticsLogger, FeedbackControllerProvider feedbackControllerProvider, FeedStoryMutator feedStoryMutator, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, PermalinkController permalinkController, SeeMoreController seeMoreController, Provider<GraphQLActorCache> provider, ReactionsMutationController reactionsMutationController) {
        this.f19584f = function;
        this.f19585g = commentsHelper;
        this.f19579a = feedbackAnalyticsLogger;
        this.f19580b = feedbackControllerProvider.m5074a(FeedbackControllerParams.f4498a);
        this.f19581c = feedStoryMutator;
        this.f19582d = graphQLNotificationsContentProviderHelper;
        this.f19583e = permalinkController;
        this.f19586h = seeMoreController;
        this.f19587i = provider;
        this.f19588j = reactionsMutationController;
        this.f19586h.c = new C16951(this);
    }

    public final void m22889a(GraphQLStory graphQLStory) {
        this.f19590l = graphQLStory != null ? FeedProps.c(graphQLStory) : null;
    }
}
