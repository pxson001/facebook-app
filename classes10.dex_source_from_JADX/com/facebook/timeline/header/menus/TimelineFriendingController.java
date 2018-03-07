package com.facebook.timeline.header.menus;

import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestCancelRef;
import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.constants.FriendRequestResponseRef;
import com.facebook.friends.constants.RemoveFriendRef;
import com.facebook.friends.events.FriendingEventSubscriber;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.Assisted;
import com.facebook.timeline.TimelineFragment;
import com.facebook.timeline.cache.TimelineUserDataCleaner;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.datafetcher.TimelineDataFetcher;
import com.facebook.timeline.event.TimelineFriendingEvents.AddFriendClickedEvent;
import com.facebook.timeline.event.TimelineFriendingEvents.AddFriendClickedEventSubscriber;
import com.facebook.timeline.event.TimelineFriendingEvents.CancelFriendRequestClickedEvent;
import com.facebook.timeline.event.TimelineFriendingEvents.CancellingFriendRequestClickedEventSubscriber;
import com.facebook.timeline.event.TimelineFriendingEvents.FriendRequestResponseClickedEvent;
import com.facebook.timeline.event.TimelineFriendingEvents.FriendRequestResponseClickedEventSubscriber;
import com.facebook.timeline.event.TimelineFriendingEvents.SubscribeStatusChangeClickedEvent;
import com.facebook.timeline.event.TimelineFriendingEvents.SubscribeStatusChangeClickedEventSubscriber;
import com.facebook.timeline.event.TimelineFriendingEvents.UnfriendClickedEvent;
import com.facebook.timeline.event.TimelineFriendingEvents.UnfriendClickedEventSubscriber;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.menus.TimelineFriendingClient.C17022;
import com.facebook.timeline.header.menus.TimelineFriendingClient.C17033;
import com.facebook.timeline.header.menus.TimelineFriendingClient.C17044;
import com.facebook.timeline.header.menus.TimelineFriendingClient.ViewCallback;
import com.facebook.timeline.protiles.model.ProtilesData;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fetch_birthdays_task */
public class TimelineFriendingController {
    public final TimelineUserContext f11921a;
    public final TimelineDataFetcher f11922b;
    public final TimelineFriendingClient f11923c;
    public final ProtilesData f11924d;
    public final TimelineFragment f11925e;
    public final TimelineHeaderUserData f11926f;
    public final Provider<TimelineUserDataCleaner> f11927g;
    public GraphQLFriendshipStatus f11928h;

    /* compiled from: fetch_birthdays_task */
    class C17091 extends FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ TimelineFriendingController f11914a;

        C17091(TimelineFriendingController timelineFriendingController) {
            this.f11914a = timelineFriendingController;
        }

        public final boolean m11961a(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            return (friendshipStatusChangedEvent == null || this.f11914a.f11921a == null || this.f11914a.f11921a.b != friendshipStatusChangedEvent.a) ? false : true;
        }

        public final void m11962b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            TimelineFriendingController timelineFriendingController;
            GraphQLFriendshipStatus graphQLFriendshipStatus;
            if (friendshipStatusChangedEvent.c) {
                timelineFriendingController = this.f11914a;
                graphQLFriendshipStatus = friendshipStatusChangedEvent.b;
                if (graphQLFriendshipStatus == GraphQLFriendshipStatus.OUTGOING_REQUEST || graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST || graphQLFriendshipStatus == GraphQLFriendshipStatus.ARE_FRIENDS) {
                    timelineFriendingController.f11928h = timelineFriendingController.f11926f.B();
                    timelineFriendingController.f11926f.a(graphQLFriendshipStatus);
                    if (graphQLFriendshipStatus == GraphQLFriendshipStatus.OUTGOING_REQUEST && timelineFriendingController.f11926f.C().equals(GraphQLSubscribeStatus.CAN_SUBSCRIBE)) {
                        timelineFriendingController.f11926f.a(GraphQLSubscribeStatus.IS_SUBSCRIBED);
                    }
                    if (graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST && timelineFriendingController.f11926f.C().equals(GraphQLSubscribeStatus.IS_SUBSCRIBED)) {
                        timelineFriendingController.f11926f.a(GraphQLSubscribeStatus.CAN_SUBSCRIBE);
                    }
                    if (timelineFriendingController.f11925e != null) {
                        timelineFriendingController.f11925e.mo_();
                    }
                    return;
                }
                timelineFriendingController.f11928h = null;
                return;
            }
            Object obj;
            timelineFriendingController = this.f11914a;
            graphQLFriendshipStatus = friendshipStatusChangedEvent.b;
            if (graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST && timelineFriendingController.f11928h == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null || graphQLFriendshipStatus == GraphQLFriendshipStatus.OUTGOING_REQUEST || graphQLFriendshipStatus == GraphQLFriendshipStatus.INCOMING_REQUEST) {
                timelineFriendingController.f11922b.m10555a().m10620g();
            } else if (graphQLFriendshipStatus == GraphQLFriendshipStatus.ARE_FRIENDS) {
                timelineFriendingController.f11922b.m10561a(true);
            } else {
                if (graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST && timelineFriendingController.f11928h == GraphQLFriendshipStatus.INCOMING_REQUEST) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    timelineFriendingController.f11922b.m10561a(false);
                } else {
                    if (graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST && timelineFriendingController.f11928h == GraphQLFriendshipStatus.ARE_FRIENDS) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        ((TimelineUserDataCleaner) timelineFriendingController.f11927g.get()).a("RemoveFriendOnSuccess");
                        timelineFriendingController.f11922b.m10556a(1);
                    }
                }
            }
        }
    }

    /* compiled from: fetch_birthdays_task */
    class C17102 extends SubscribeStatusChangeClickedEventSubscriber {
        final /* synthetic */ TimelineFriendingController f11915a;

        C17102(TimelineFriendingController timelineFriendingController) {
            this.f11915a = timelineFriendingController;
        }

        public final void m11963b(FbEvent fbEvent) {
            SubscribeStatusChangeClickedEvent subscribeStatusChangeClickedEvent = (SubscribeStatusChangeClickedEvent) fbEvent;
            if (this.f11915a.f11923c != null) {
                this.f11915a.f11923c.m11957a(subscribeStatusChangeClickedEvent.a, subscribeStatusChangeClickedEvent.b);
            }
        }
    }

    /* compiled from: fetch_birthdays_task */
    class C17113 extends AddFriendClickedEventSubscriber {
        final /* synthetic */ TimelineFriendingController f11916a;

        C17113(TimelineFriendingController timelineFriendingController) {
            this.f11916a = timelineFriendingController;
        }

        public final void m11964b(FbEvent fbEvent) {
            AddFriendClickedEvent addFriendClickedEvent = (AddFriendClickedEvent) fbEvent;
            if (this.f11916a.f11923c != null) {
                this.f11916a.f11923c.m11958a(addFriendClickedEvent.a, FriendRequestHowFound.PROFILE_BUTTON, null, this.f11916a.f11921a.a);
            }
        }
    }

    /* compiled from: fetch_birthdays_task */
    class C17124 extends FriendRequestResponseClickedEventSubscriber {
        final /* synthetic */ TimelineFriendingController f11917a;

        C17124(TimelineFriendingController timelineFriendingController) {
            this.f11917a = timelineFriendingController;
        }

        public final void m11965b(FbEvent fbEvent) {
            FriendRequestResponseClickedEvent friendRequestResponseClickedEvent = (FriendRequestResponseClickedEvent) fbEvent;
            if (this.f11917a.f11923c != null) {
                TimelineFriendingClient timelineFriendingClient = this.f11917a.f11923c;
                long j = friendRequestResponseClickedEvent.a;
                FriendRequestResponse friendRequestResponse = friendRequestResponseClickedEvent.b;
                FriendRequestResponseRef friendRequestResponseRef = FriendRequestResponseRef.PROFILE;
                GraphQLFriendshipStatus graphQLFriendshipStatus = friendRequestResponse == FriendRequestResponse.CONFIRM ? GraphQLFriendshipStatus.ARE_FRIENDS : GraphQLFriendshipStatus.CAN_REQUEST;
                TimelineFriendingClient.m11951a(timelineFriendingClient, j, graphQLFriendshipStatus, true);
                Futures.a(((FriendingClient) timelineFriendingClient.f11900a.get()).a(j, friendRequestResponse, friendRequestResponseRef), new C17022(timelineFriendingClient, j, graphQLFriendshipStatus), timelineFriendingClient.f11908i);
            }
        }
    }

    /* compiled from: fetch_birthdays_task */
    class C17135 extends UnfriendClickedEventSubscriber {
        final /* synthetic */ TimelineFriendingController f11918a;

        C17135(TimelineFriendingController timelineFriendingController) {
            this.f11918a = timelineFriendingController;
        }

        public final void m11966b(FbEvent fbEvent) {
            UnfriendClickedEvent unfriendClickedEvent = (UnfriendClickedEvent) fbEvent;
            if (this.f11918a.f11923c != null) {
                TimelineFriendingClient timelineFriendingClient = this.f11918a.f11923c;
                long j = unfriendClickedEvent.a;
                TimelineFriendingClient.m11951a(timelineFriendingClient, j, GraphQLFriendshipStatus.CAN_REQUEST, true);
                Futures.a(((FriendingClient) timelineFriendingClient.f11900a.get()).a(j, RemoveFriendRef.PROFILE_BUTTON), new C17033(timelineFriendingClient, j), timelineFriendingClient.f11908i);
            }
        }
    }

    /* compiled from: fetch_birthdays_task */
    class C17146 extends CancellingFriendRequestClickedEventSubscriber {
        final /* synthetic */ TimelineFriendingController f11919a;

        C17146(TimelineFriendingController timelineFriendingController) {
            this.f11919a = timelineFriendingController;
        }

        public final void m11967b(FbEvent fbEvent) {
            CancelFriendRequestClickedEvent cancelFriendRequestClickedEvent = (CancelFriendRequestClickedEvent) fbEvent;
            if (this.f11919a.f11923c != null) {
                TimelineFriendingClient timelineFriendingClient = this.f11919a.f11923c;
                long j = cancelFriendRequestClickedEvent.a;
                FriendRequestCancelRef friendRequestCancelRef = FriendRequestCancelRef.PROFILE;
                TimelineFriendingClient.m11951a(timelineFriendingClient, j, GraphQLFriendshipStatus.CAN_REQUEST, true);
                Futures.a(((FriendingClient) timelineFriendingClient.f11900a.get()).a(j, friendRequestCancelRef), new C17044(timelineFriendingClient, j), timelineFriendingClient.f11908i);
            }
        }
    }

    /* compiled from: fetch_birthdays_task */
    public class C17157 extends FriendingEventSubscriber<FriendshipStatusChangedEvent> {
        final /* synthetic */ TimelineFriendingController f11920a;

        public C17157(TimelineFriendingController timelineFriendingController) {
            this.f11920a = timelineFriendingController;
        }

        public final void m11969b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            this.f11920a.f11924d.m12121a(String.valueOf(friendshipStatusChangedEvent.a), friendshipStatusChangedEvent.b);
            this.f11920a.f11925e.mo_();
        }

        public final Class<FriendshipStatusChangedEvent> m11968a() {
            return FriendshipStatusChangedEvent.class;
        }
    }

    @Inject
    public TimelineFriendingController(@Assisted TimelineUserContext timelineUserContext, @Assisted TimelineDataFetcher timelineDataFetcher, @Assisted ViewCallback viewCallback, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted TimelineFriendingClient timelineFriendingClient, ProtilesData protilesData, Provider<TimelineUserDataCleaner> provider) {
        this.f11921a = timelineUserContext;
        this.f11924d = protilesData;
        this.f11922b = (TimelineDataFetcher) Preconditions.checkNotNull(timelineDataFetcher);
        this.f11925e = viewCallback;
        this.f11926f = (TimelineHeaderUserData) Preconditions.checkNotNull(timelineHeaderUserData);
        this.f11923c = timelineFriendingClient;
        this.f11927g = provider;
    }

    public final void m11970a(FbEventSubscriberListManager fbEventSubscriberListManager) {
        fbEventSubscriberListManager.a(new C17091(this));
        fbEventSubscriberListManager.a(new C17102(this));
        fbEventSubscriberListManager.a(new C17113(this));
        fbEventSubscriberListManager.a(new C17124(this));
        fbEventSubscriberListManager.a(new C17135(this));
        fbEventSubscriberListManager.a(new C17146(this));
    }
}
