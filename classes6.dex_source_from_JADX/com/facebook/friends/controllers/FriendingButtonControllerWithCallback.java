package com.facebook.friends.controllers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.interfaces.FriendingButtonControllerCallback;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: me/album_privacy_bulk_edit */
public class FriendingButtonControllerWithCallback extends BaseFriendingButtonController {
    public final TasksManager<String> f10627c;

    /* compiled from: me/album_privacy_bulk_edit */
    public class C06573 implements OnClickListener {
        final /* synthetic */ long f10623a;
        final /* synthetic */ FriendingLocation f10624b;
        final /* synthetic */ FriendingButtonControllerWithCallback f10625c;

        /* compiled from: me/album_privacy_bulk_edit */
        class C06562 extends AbstractDisposableFutureCallback<GraphQLFriendshipStatus> {
            final /* synthetic */ C06573 f10622a;

            C06562(C06573 c06573) {
                this.f10622a = c06573;
            }

            protected final void m16740a(Object obj) {
                this.f10622a.f10625c.m16715a(this.f10622a.f10623a, GraphQLFriendshipStatus.OUTGOING_REQUEST, false);
            }

            protected final void m16741a(Throwable th) {
                this.f10622a.f10625c.m16715a(this.f10622a.f10623a, GraphQLFriendshipStatus.CAN_REQUEST, false);
                this.f10622a.f10625c.f10561b.a(th);
            }
        }

        public C06573(FriendingButtonControllerWithCallback friendingButtonControllerWithCallback, long j, FriendingLocation friendingLocation) {
            this.f10625c = friendingButtonControllerWithCallback;
            this.f10623a = j;
            this.f10624b = friendingLocation;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            final ListenableFuture a = this.f10625c.f10560a.a(this.f10623a, this.f10624b.friendRequestHowFound, this.f10624b.peopleYouMayKnowLocation, null);
            this.f10625c.m16715a(this.f10623a, GraphQLFriendshipStatus.OUTGOING_REQUEST, true);
            this.f10625c.f10627c.a("ADD_FRIEND_IGNORE_WARN" + this.f10623a, new Callable<ListenableFuture<GraphQLFriendshipStatus>>(this) {
                final /* synthetic */ C06573 f10621b;

                public Object call() {
                    return a;
                }
            }, new C06562(this));
        }
    }

    /* compiled from: me/album_privacy_bulk_edit */
    /* synthetic */ class C06584 {
        static final /* synthetic */ int[] f10626a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f10626a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10626a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10626a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10626a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static FriendingButtonControllerWithCallback m16742b(InjectorLike injectorLike) {
        return new FriendingButtonControllerWithCallback(TasksManager.b(injectorLike), FriendingClient.b(injectorLike), FriendingEventBus.m16746a(injectorLike), FriendingExceptionHandler.b(injectorLike));
    }

    @Inject
    public FriendingButtonControllerWithCallback(TasksManager tasksManager, FriendingClient friendingClient, FriendingEventBus friendingEventBus, FriendingExceptionHandler friendingExceptionHandler) {
        super(friendingClient, friendingEventBus, friendingExceptionHandler);
        this.f10627c = tasksManager;
    }

    public final void m16743a(long j, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, FriendingButtonControllerCallback friendingButtonControllerCallback) {
        ListenableFuture a;
        GraphQLFriendshipStatus graphQLFriendshipStatus2;
        Object obj;
        Preconditions.checkNotNull(friendingLocation, "You need to provide a valid FriendingLocation.");
        switch (C06584.f10626a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                a = this.f10560a.a(j, friendingLocation.removeFriendRef);
                graphQLFriendshipStatus2 = GraphQLFriendshipStatus.CAN_REQUEST;
                obj = "REMOVE_FRIEND" + j;
                break;
            case 2:
                a = this.f10560a.b(j, friendingLocation.friendRequestHowFound, friendingLocation.peopleYouMayKnowLocation, null);
                graphQLFriendshipStatus2 = GraphQLFriendshipStatus.OUTGOING_REQUEST;
                obj = "ADD_FRIEND" + j;
                break;
            case 3:
                a = this.f10560a.a(j, FriendRequestResponse.CONFIRM, friendingLocation.friendRequestResponseRef);
                graphQLFriendshipStatus2 = GraphQLFriendshipStatus.ARE_FRIENDS;
                obj = "ACCEPT_FRIEND" + j;
                break;
            case 4:
                a = this.f10560a.a(j, friendingLocation.friendRequestCancelRef);
                graphQLFriendshipStatus2 = GraphQLFriendshipStatus.CAN_REQUEST;
                obj = "CANCEL_REQUEST" + j;
                break;
            default:
                return;
        }
        final FriendingButtonControllerCallback friendingButtonControllerCallback2 = friendingButtonControllerCallback;
        final long j2 = j;
        final GraphQLFriendshipStatus graphQLFriendshipStatus3 = graphQLFriendshipStatus;
        final FriendingLocation friendingLocation2 = friendingLocation;
        this.f10627c.a(obj, new Callable<ListenableFuture<GraphQLFriendshipStatus>>(this) {
            final /* synthetic */ FriendingButtonControllerWithCallback f10613b;

            public Object call() {
                return a;
            }
        }, new AbstractDisposableFutureCallback<GraphQLFriendshipStatus>(this) {
            final /* synthetic */ FriendingButtonControllerWithCallback f10619f;

            protected final void m16738a(@Nullable Object obj) {
                obj = (GraphQLFriendshipStatus) obj;
                BaseFriendingButtonController baseFriendingButtonController = this.f10619f;
                long j = j2;
                if (obj == null) {
                    obj = graphQLFriendshipStatus2;
                }
                baseFriendingButtonController.m16715a(j, obj, false);
            }

            protected final void m16739a(Throwable th) {
                if (friendingButtonControllerCallback2 != null) {
                    friendingButtonControllerCallback2.m16744a();
                }
                if (GraphQLFriendshipStatus.CAN_REQUEST.equals(graphQLFriendshipStatus3)) {
                    this.f10619f.f10561b.a(th, new C06573(this.f10619f, j2, friendingLocation2));
                } else {
                    this.f10619f.m16717a(th);
                }
            }
        });
    }
}
