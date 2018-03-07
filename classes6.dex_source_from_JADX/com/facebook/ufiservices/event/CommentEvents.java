package com.facebook.ufiservices.event;

import com.facebook.feed.rows.core.events.KeyedEvent;
import com.facebook.graphql.model.GraphQLComment;

/* compiled from: daa424daec4f3e7f2386443387d633f0 */
public class CommentEvents {

    /* compiled from: daa424daec4f3e7f2386443387d633f0 */
    public class CommentEvent implements KeyedEvent<String> {
        public final GraphQLComment f18014a;
        private final String f18015b;

        public CommentEvent(GraphQLComment graphQLComment, String str) {
            this.f18014a = graphQLComment;
            this.f18015b = str;
        }

        public final Object m26527c() {
            return this.f18015b;
        }
    }

    /* compiled from: daa424daec4f3e7f2386443387d633f0 */
    public class AddCommentEvent extends CommentEvent {
        public AddCommentEvent(GraphQLComment graphQLComment, String str) {
            super(graphQLComment, str);
        }
    }

    /* compiled from: daa424daec4f3e7f2386443387d633f0 */
    public class DeleteCommentEvent extends CommentEvent {
        public DeleteCommentEvent(GraphQLComment graphQLComment, String str) {
            super(graphQLComment, str);
        }
    }

    /* compiled from: daa424daec4f3e7f2386443387d633f0 */
    public class GraphQLSubscriptionAddCommentEvent extends CommentEvent {
        public GraphQLSubscriptionAddCommentEvent(GraphQLComment graphQLComment, String str) {
            super(graphQLComment, str);
        }
    }

    /* compiled from: daa424daec4f3e7f2386443387d633f0 */
    public class GraphQLSubscriptionAddPublicContentCommentEvent extends CommentEvent {
        public GraphQLSubscriptionAddPublicContentCommentEvent(GraphQLComment graphQLComment, String str) {
            super(graphQLComment, str);
        }
    }

    /* compiled from: daa424daec4f3e7f2386443387d633f0 */
    public class GraphQLSubscriptionFriendsTypingEvent extends CommentEvent {
        public final int f18016a;

        public GraphQLSubscriptionFriendsTypingEvent(String str, int i) {
            super(null, str);
            this.f18016a = i;
        }
    }

    /* compiled from: daa424daec4f3e7f2386443387d633f0 */
    public class UpdateCommentEvent extends CommentEvent {
        public UpdateCommentEvent(GraphQLComment graphQLComment, String str) {
            super(graphQLComment, str);
        }
    }
}
