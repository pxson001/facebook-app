package com.facebook.feed.rows.photosfeed;

import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.ui.EventSubscriptions;
import com.facebook.feedback.ui.FeedbackController;
import com.facebook.feedback.ui.FeedbackControllerParams;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.Assisted;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.LikeUpdatedUIEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeUpdatedUIEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.ReactionUpdatedEvent;
import com.facebook.ufiservices.event.UfiEvents.ReactionUpdatedEventSubscriber;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: aTextureCoord */
public class PhotosFeedEventSubscriptions implements EventSubscriptions<GraphQLStory> {
    public final Function<GraphQLStory, Void> f20208a;
    public final FeedbackController f20209b;
    public final ReactionsMutationController f20210c;
    public FeedProps<GraphQLStory> f20211d;

    /* compiled from: aTextureCoord */
    public class LikeClickSubscriber extends LikeClickedEventSubscriber {
        final /* synthetic */ PhotosFeedEventSubscriptions f20205a;

        public LikeClickSubscriber(PhotosFeedEventSubscriptions photosFeedEventSubscriptions) {
            this.f20205a = photosFeedEventSubscriptions;
        }

        public final void m23342b(FbEvent fbEvent) {
            FeedProps a = StoryProps.a(this.f20205a.f20211d, ((LikeClickedEvent) fbEvent).a);
            if (a != null && a.a != null && ((GraphQLStory) a.a).z()) {
                this.f20205a.f20209b.m5067a(((GraphQLStory) a.a).l(), new FeedbackLoggingParams(TrackableFeedProps.a(a), "photos_feed_ufi", "photos_feed"));
            }
        }
    }

    /* compiled from: aTextureCoord */
    public class LikeUpdatedEventSubscriber extends LikeUpdatedUIEventSubscriber {
        final /* synthetic */ PhotosFeedEventSubscriptions f20206a;

        public LikeUpdatedEventSubscriber(PhotosFeedEventSubscriptions photosFeedEventSubscriptions) {
            this.f20206a = photosFeedEventSubscriptions;
        }

        public final void m23343b(FbEvent fbEvent) {
            LikeUpdatedUIEvent likeUpdatedUIEvent = (LikeUpdatedUIEvent) fbEvent;
            GraphQLFeedback l = ((GraphQLStory) this.f20206a.f20211d.a).l();
            if (l == null || !likeUpdatedUIEvent.a.equals(l.j())) {
                GraphQLStory graphQLStory;
                PhotosFeedEventSubscriptions photosFeedEventSubscriptions = this.f20206a;
                GraphQLFeedback graphQLFeedback = likeUpdatedUIEvent.d;
                GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) photosFeedEventSubscriptions.f20211d.a);
                if (o == null || o.x() == null || o.x().isEmpty()) {
                    graphQLStory = null;
                } else {
                    ImmutableList x = o.x();
                    Builder builder = ImmutableList.builder();
                    int size = x.size();
                    for (int i = 0; i < size; i++) {
                        Object obj = (GraphQLStoryAttachment) x.get(i);
                        if (obj.r() != null && obj.r().I().j().equals(graphQLFeedback.j())) {
                            GraphQLStoryAttachment.Builder a = GraphQLStoryAttachment.Builder.a(obj);
                            GraphQLMedia.Builder a2 = GraphQLMedia.Builder.a(obj.r());
                            a2.C = graphQLFeedback;
                            a.l = a2.a();
                            obj = a.a();
                        }
                        builder.c(obj);
                    }
                    ImmutableList b = builder.b();
                    GraphQLStory.Builder a3 = GraphQLStory.Builder.a((GraphQLStory) photosFeedEventSubscriptions.f20211d.a);
                    GraphQLStoryAttachment.Builder a4 = GraphQLStoryAttachment.Builder.a(o);
                    a4.r = b;
                    a3.m = ImmutableList.of(a4.a());
                    graphQLStory = a3.a();
                }
                GraphQLStory graphQLStory2 = graphQLStory;
                if (graphQLStory2 != null) {
                    this.f20206a.f20208a.apply(graphQLStory2);
                }
            }
        }
    }

    /* compiled from: aTextureCoord */
    public class ReactionUpdatedSubscriber extends ReactionUpdatedEventSubscriber {
        final /* synthetic */ PhotosFeedEventSubscriptions f20207a;

        public ReactionUpdatedSubscriber(PhotosFeedEventSubscriptions photosFeedEventSubscriptions) {
            this.f20207a = photosFeedEventSubscriptions;
        }

        public final void m23344b(FbEvent fbEvent) {
            ReactionUpdatedEvent reactionUpdatedEvent = (ReactionUpdatedEvent) fbEvent;
            this.f20207a.f20208a.apply(this.f20207a.f20210c.a((GraphQLStory) this.f20207a.f20211d.a, reactionUpdatedEvent.a, reactionUpdatedEvent.c));
        }
    }

    @Inject
    public PhotosFeedEventSubscriptions(@Assisted Function<GraphQLStory, Void> function, FeedbackControllerProvider feedbackControllerProvider, ReactionsMutationController reactionsMutationController) {
        this.f20208a = (Function) Preconditions.checkNotNull(function);
        this.f20209b = feedbackControllerProvider.m5074a(FeedbackControllerParams.f4498a);
        this.f20210c = reactionsMutationController;
    }

    public final void m23345a(GraphQLStory graphQLStory) {
        this.f20211d = FeedProps.c(graphQLStory);
    }
}
