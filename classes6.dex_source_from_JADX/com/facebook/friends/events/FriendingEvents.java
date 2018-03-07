package com.facebook.friends.events;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;

/* compiled from: max_ticket_price */
public class FriendingEvents {

    /* compiled from: max_ticket_price */
    public class FriendshipStatusChangedEvent extends FriendingEvent {
        public final long f10629a;
        public final GraphQLFriendshipStatus f10630b;
        public final boolean f10631c;

        public FriendshipStatusChangedEvent(long j, GraphQLFriendshipStatus graphQLFriendshipStatus, boolean z) {
            this.f10629a = j;
            this.f10630b = graphQLFriendshipStatus;
            this.f10631c = z;
        }
    }

    /* compiled from: max_ticket_price */
    public abstract class FriendshipStatusChangedEventSubscriber extends FriendingEventSubscriber<FriendshipStatusChangedEvent> {
        public final Class<FriendshipStatusChangedEvent> m16747a() {
            return FriendshipStatusChangedEvent.class;
        }
    }

    /* compiled from: max_ticket_price */
    public class PYMKBlacklistedEvent extends FriendingEvent {
        public final long f10632a;

        public PYMKBlacklistedEvent(long j) {
            this.f10632a = j;
        }
    }

    /* compiled from: max_ticket_price */
    public abstract class PYMKBlacklistedEventSubscriber extends FriendingEventSubscriber<PYMKBlacklistedEvent> {
        public final Class<PYMKBlacklistedEvent> m16748a() {
            return PYMKBlacklistedEvent.class;
        }
    }

    /* compiled from: max_ticket_price */
    public class SubscribeStatusChangedEvent extends FriendingEvent {
        public final long f10633a;
        public final GraphQLSubscribeStatus f10634b;
        public final GraphQLSecondarySubscribeStatus f10635c;
        public final boolean f10636d;

        public SubscribeStatusChangedEvent(long j, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus, boolean z) {
            this.f10633a = j;
            this.f10634b = graphQLSubscribeStatus;
            this.f10635c = graphQLSecondarySubscribeStatus;
            this.f10636d = z;
        }
    }

    /* compiled from: max_ticket_price */
    public abstract class SubscribeStatusChangedEventSubscriber extends FriendingEventSubscriber<SubscribeStatusChangedEvent> {
        public final Class<SubscribeStatusChangedEvent> m16749a() {
            return SubscribeStatusChangedEvent.class;
        }
    }

    /* compiled from: max_ticket_price */
    public class UserBlockedEvent extends FriendingEvent {
        public final long f10637a;

        public UserBlockedEvent(long j) {
            this.f10637a = j;
        }
    }

    /* compiled from: max_ticket_price */
    public abstract class UserBlockedEventSubscriber extends FriendingEventSubscriber<UserBlockedEvent> {
        public final Class<UserBlockedEvent> m16750a() {
            return UserBlockedEvent.class;
        }
    }
}
