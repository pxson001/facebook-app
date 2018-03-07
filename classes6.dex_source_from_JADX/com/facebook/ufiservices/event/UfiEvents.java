package com.facebook.ufiservices.event;

import com.facebook.feed.util.event.FeedEvent;
import com.facebook.feed.util.event.FeedEventSubscriber;
import com.facebook.graphql.model.GraphQLFeedback;

/* compiled from: da6c94ea0658ab58aa557a1167a3a43e */
public class UfiEvents {

    /* compiled from: da6c94ea0658ab58aa557a1167a3a43e */
    public class LikeStoryEvent extends FeedEvent {
        public final String f18017a;
    }

    /* compiled from: da6c94ea0658ab58aa557a1167a3a43e */
    public abstract class LikeStoryEventSubscriber extends FeedEventSubscriber<LikeStoryEvent> {
        public final Class<LikeStoryEvent> m26528a() {
            return LikeStoryEvent.class;
        }
    }

    /* compiled from: da6c94ea0658ab58aa557a1167a3a43e */
    public class LikeUpdatedUIEvent extends FeedEvent {
        public final String f18018a;
        public final boolean f18019b;
        public final boolean f18020c;
        public final GraphQLFeedback f18021d;

        public LikeUpdatedUIEvent(String str, boolean z, boolean z2, GraphQLFeedback graphQLFeedback) {
            this.f18018a = str;
            this.f18019b = z;
            this.f18020c = z2;
            this.f18021d = graphQLFeedback;
        }
    }

    /* compiled from: da6c94ea0658ab58aa557a1167a3a43e */
    public abstract class LikeUpdatedUIEventSubscriber extends FeedEventSubscriber<LikeUpdatedUIEvent> {
        public final Class<LikeUpdatedUIEvent> m26529a() {
            return LikeUpdatedUIEvent.class;
        }
    }
}
