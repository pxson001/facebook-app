package com.facebook.tablet.sideshow.pymk.events;

import com.facebook.feed.util.event.FeedEvent;
import com.facebook.feed.util.event.FeedEventSubscriber;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;

/* compiled from: onLoadEnd */
public class SideshowFriendingEvents {

    /* compiled from: onLoadEnd */
    public abstract class FriendRequestClickedEventSubscriber extends FeedEventSubscriber<FriendRequestClickedEvent> {
        public final Class<FriendRequestClickedEvent> m5903a() {
            return FriendRequestClickedEvent.class;
        }
    }

    /* compiled from: onLoadEnd */
    public class FriendRequestClickedEvent extends FeedEvent {
        public final String f4747a;
        public final GraphQLFriendshipStatus f4748b;
        public final String f4749c;

        public FriendRequestClickedEvent(String str, GraphQLFriendshipStatus graphQLFriendshipStatus, String str2) {
            this.f4747a = str;
            this.f4748b = graphQLFriendshipStatus;
            this.f4749c = str2;
        }
    }
}
