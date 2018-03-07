package com.facebook.feedback.events;

import com.facebook.api.ufiservices.common.CommentLoadDirection;
import com.facebook.feed.rows.core.events.KeyedEvent;
import com.facebook.graphql.model.GraphQLFeedback;

/* compiled from: media_gallery */
public class FeedbackEvents {

    /* compiled from: media_gallery */
    public class FeedbackEvent implements KeyedEvent<String> {
        public final GraphQLFeedback f10454a;

        public /* synthetic */ Object mo1046c() {
            return mo1045a();
        }

        public FeedbackEvent(GraphQLFeedback graphQLFeedback) {
            this.f10454a = graphQLFeedback;
        }

        public String mo1045a() {
            return this.f10454a.z_();
        }
    }

    /* compiled from: media_gallery */
    public class LoadMoreCommentsEvent extends FeedbackEvent {
        public final CommentLoadDirection f10455a;

        public LoadMoreCommentsEvent(GraphQLFeedback graphQLFeedback, CommentLoadDirection commentLoadDirection) {
            super(graphQLFeedback);
            this.f10455a = commentLoadDirection;
        }
    }

    /* compiled from: media_gallery */
    public class UpdateLikeFeedbackEvent extends FeedbackEvent {
        public UpdateLikeFeedbackEvent(GraphQLFeedback graphQLFeedback) {
            super(graphQLFeedback);
        }
    }

    /* compiled from: media_gallery */
    public class UpdateThreadedFeedbackEvent extends FeedbackEvent {
        private final String f10456a;

        public final /* synthetic */ Object mo1046c() {
            return mo1045a();
        }

        public UpdateThreadedFeedbackEvent(GraphQLFeedback graphQLFeedback, String str) {
            super(graphQLFeedback);
            this.f10456a = str;
        }

        public final String mo1045a() {
            return this.f10456a;
        }
    }
}
