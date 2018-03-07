package com.facebook.friends.controllers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.util.FriendRequestUtil;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: me/blacklisted_pymi_contacts */
public class FriendRequestController {
    public final FriendingClient f10585a;
    public final FriendingEventBus f10586b;
    public final FriendingExceptionHandler f10587c;
    public final TasksManager<String> f10588d;

    /* compiled from: me/blacklisted_pymi_contacts */
    public class C06455 implements OnClickListener {
        final /* synthetic */ long f10583a;
        final /* synthetic */ FriendRequestController f10584b;

        /* compiled from: me/blacklisted_pymi_contacts */
        class C06442 extends AbstractDisposableFutureCallback<GraphQLFriendshipStatus> {
            final /* synthetic */ C06455 f10582a;

            C06442(C06455 c06455) {
                this.f10582a = c06455;
            }

            protected final void m16722a(Object obj) {
                this.f10582a.f10584b.f10586b.a(new FriendshipStatusChangedEvent(this.f10582a.f10583a, GraphQLFriendshipStatus.OUTGOING_REQUEST, false));
            }

            protected final void m16723a(Throwable th) {
                this.f10582a.f10584b.f10586b.a(new FriendshipStatusChangedEvent(this.f10582a.f10583a, GraphQLFriendshipStatus.CAN_REQUEST, false));
                this.f10582a.f10584b.f10587c.a(th);
            }
        }

        public C06455(FriendRequestController friendRequestController, long j) {
            this.f10584b = friendRequestController;
            this.f10583a = j;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            final ListenableFuture a = this.f10584b.f10585a.a(this.f10583a, FriendRequestHowFound.SUGGESTION, null, null);
            this.f10584b.f10586b.a(new FriendshipStatusChangedEvent(this.f10583a, GraphQLFriendshipStatus.OUTGOING_REQUEST, true));
            this.f10584b.f10588d.a("ADD_FRIEND_IGNORE_WARN" + this.f10583a, new Callable<ListenableFuture<GraphQLFriendshipStatus>>(this) {
                final /* synthetic */ C06455 f10581b;

                public Object call() {
                    return a;
                }
            }, new C06442(this));
        }
    }

    /* compiled from: me/blacklisted_pymi_contacts */
    public interface Callback {
        void m16724a();

        void m16725a(boolean z);
    }

    public static FriendRequestController m16726b(InjectorLike injectorLike) {
        return new FriendRequestController(FriendingClient.b(injectorLike), FriendingEventBus.m16746a(injectorLike), FriendingExceptionHandler.b(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public FriendRequestController(FriendingClient friendingClient, FriendingEventBus friendingEventBus, FriendingExceptionHandler friendingExceptionHandler, TasksManager tasksManager) {
        this.f10585a = friendingClient;
        this.f10586b = friendingEventBus;
        this.f10587c = friendingExceptionHandler;
        this.f10588d = tasksManager;
    }

    public final void m16728a(long j, FriendingLocation friendingLocation, FriendRequestResponse friendRequestResponse, Callback callback) {
        final GraphQLFriendshipStatus a = FriendRequestUtil.m17437a(friendRequestResponse, false);
        this.f10586b.a(new FriendshipStatusChangedEvent(j, a, true));
        TasksManager tasksManager = this.f10588d;
        String str = "RESPOND_TO_FRIEND_REQUEST_TASK" + j;
        final long j2 = j;
        final FriendRequestResponse friendRequestResponse2 = friendRequestResponse;
        final FriendingLocation friendingLocation2 = friendingLocation;
        Callable c06391 = new Callable<ListenableFuture<GraphQLFriendshipStatus>>(this) {
            final /* synthetic */ FriendRequestController f10567d;

            public Object call() {
                return this.f10567d.f10585a.a(j2, friendRequestResponse2, friendingLocation2.friendRequestResponseRef);
            }
        };
        final Callback callback2 = callback;
        final long j3 = j;
        tasksManager.a(str, c06391, new AbstractDisposableFutureCallback<GraphQLFriendshipStatus>(this) {
            final /* synthetic */ FriendRequestController f10571d;

            protected final void m16718a(Object obj) {
                callback2.m16724a();
                this.f10571d.f10586b.a(new FriendshipStatusChangedEvent(j3, a, false));
            }

            protected final void m16719a(Throwable th) {
                callback2.m16725a(th instanceof GraphQLException);
                this.f10571d.f10586b.a(new FriendshipStatusChangedEvent(j3, GraphQLFriendshipStatus.INCOMING_REQUEST, false));
                this.f10571d.f10587c.a(th);
            }
        });
    }

    public final void m16727a(final long j, FriendRequestResponse friendRequestResponse, Callback callback) {
        final boolean equals = FriendRequestResponse.CONFIRM.equals(friendRequestResponse);
        final GraphQLFriendshipStatus a = FriendRequestUtil.m17437a(friendRequestResponse, true);
        this.f10586b.a(new FriendshipStatusChangedEvent(j, a, true));
        final Callback callback2 = callback;
        final long j2 = j;
        this.f10588d.a("RESPOND_TO_FRIEND_SUGGEST_TASK" + j, new Callable<ListenableFuture<GraphQLFriendshipStatus>>(this) {
            final /* synthetic */ FriendRequestController f10574c;

            public Object call() {
                if (equals) {
                    return this.f10574c.f10585a.b(j, FriendRequestHowFound.SUGGESTION, null, null);
                }
                return this.f10574c.f10585a.a(j);
            }
        }, new AbstractDisposableFutureCallback<GraphQLFriendshipStatus>(this) {
            final /* synthetic */ FriendRequestController f10579e;

            protected final void m16720a(Object obj) {
                callback2.m16724a();
                this.f10579e.f10586b.a(new FriendshipStatusChangedEvent(j2, a, false));
            }

            protected final void m16721a(Throwable th) {
                this.f10579e.f10586b.a(new FriendshipStatusChangedEvent(j2, GraphQLFriendshipStatus.CAN_REQUEST, false));
                if (equals) {
                    this.f10579e.f10587c.a(th, new C06455(this.f10579e, j2));
                } else {
                    this.f10579e.f10587c.a(th);
                }
                callback2.m16725a(false);
            }
        });
    }
}
