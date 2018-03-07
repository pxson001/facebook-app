package com.facebook.timeline.event;

import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.ipc.profile.TimelineFriendParams;

/* compiled from: main_filter_list */
public class TimelineFriendingEvents {

    /* compiled from: main_filter_list */
    public class AddFriendClickedEvent extends TimelineHeaderEvent {
        public final long f9150a;

        public AddFriendClickedEvent(long j) {
            this.f9150a = j;
        }
    }

    /* compiled from: main_filter_list */
    public abstract class AddFriendClickedEventSubscriber extends TimelineHeaderEventSubscriber<AddFriendClickedEvent> {
        public final Class<AddFriendClickedEvent> m10925a() {
            return AddFriendClickedEvent.class;
        }
    }

    /* compiled from: main_filter_list */
    public class CancelFriendRequestClickedEvent extends TimelineHeaderEvent {
        public final long f9151a;

        public CancelFriendRequestClickedEvent(long j) {
            this.f9151a = j;
        }
    }

    /* compiled from: main_filter_list */
    public abstract class CancellingFriendRequestClickedEventSubscriber extends TimelineHeaderEventSubscriber<CancelFriendRequestClickedEvent> {
        public final Class<CancelFriendRequestClickedEvent> m10926a() {
            return CancelFriendRequestClickedEvent.class;
        }
    }

    /* compiled from: main_filter_list */
    public class FriendRequestResponseClickedEvent extends TimelineHeaderEvent {
        public final long f9152a;
        public final FriendRequestResponse f9153b;

        public FriendRequestResponseClickedEvent(long j, FriendRequestResponse friendRequestResponse) {
            this.f9152a = j;
            this.f9153b = friendRequestResponse;
        }
    }

    /* compiled from: main_filter_list */
    public abstract class FriendRequestResponseClickedEventSubscriber extends TimelineHeaderEventSubscriber<FriendRequestResponseClickedEvent> {
        public final Class<FriendRequestResponseClickedEvent> m10927a() {
            return FriendRequestResponseClickedEvent.class;
        }
    }

    /* compiled from: main_filter_list */
    public class SubscribeStatusChangeClickedEvent extends TimelineHeaderEvent {
        public final boolean f9154a;
        public final boolean f9155b;

        public SubscribeStatusChangeClickedEvent(boolean z, boolean z2) {
            this.f9154a = z;
            this.f9155b = z2;
        }
    }

    /* compiled from: main_filter_list */
    public abstract class SubscribeStatusChangeClickedEventSubscriber extends TimelineHeaderEventSubscriber<SubscribeStatusChangeClickedEvent> {
        public final Class<SubscribeStatusChangeClickedEvent> m10928a() {
            return SubscribeStatusChangeClickedEvent.class;
        }
    }

    /* compiled from: main_filter_list */
    public class SubscribeStatusChangedEvent extends TimelineHeaderEvent {
        public final TimelineFriendParams f9156a;

        public SubscribeStatusChangedEvent(TimelineFriendParams timelineFriendParams) {
            this.f9156a = timelineFriendParams;
        }
    }

    /* compiled from: main_filter_list */
    public abstract class SubscribeStatusChangedEventSubscriber extends TimelineHeaderEventSubscriber<SubscribeStatusChangedEvent> {
        public final Class<SubscribeStatusChangedEvent> m10929a() {
            return SubscribeStatusChangedEvent.class;
        }
    }

    /* compiled from: main_filter_list */
    public class UnfriendClickedEvent extends TimelineHeaderEvent {
        public final long f9157a;

        public UnfriendClickedEvent(long j) {
            this.f9157a = j;
        }
    }

    /* compiled from: main_filter_list */
    public abstract class UnfriendClickedEventSubscriber extends TimelineHeaderEventSubscriber<UnfriendClickedEvent> {
        public final Class<UnfriendClickedEvent> m10930a() {
            return UnfriendClickedEvent.class;
        }
    }
}
