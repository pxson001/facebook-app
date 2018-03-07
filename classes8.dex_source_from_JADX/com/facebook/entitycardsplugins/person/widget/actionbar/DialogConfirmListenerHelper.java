package com.facebook.entitycardsplugins.person.widget.actionbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* compiled from: heisman_return_to_camera */
class DialogConfirmListenerHelper {

    /* compiled from: heisman_return_to_camera */
    final class C12141 implements OnClickListener {
        final /* synthetic */ FriendingClient f11264a;
        final /* synthetic */ long f11265b;
        final /* synthetic */ FriendRequestHowFound f11266c;
        final /* synthetic */ FriendRequestMakeRef f11267d;
        final /* synthetic */ FriendingEventBus f11268e;
        final /* synthetic */ FriendingExceptionHandler f11269f;
        final /* synthetic */ Context f11270g;
        final /* synthetic */ ExecutorService f11271h;

        /* compiled from: heisman_return_to_camera */
        class C12131 implements FutureCallback<GraphQLFriendshipStatus> {
            final /* synthetic */ C12141 f11263a;

            C12131(C12141 c12141) {
                this.f11263a = c12141;
            }

            public void onSuccess(@Nullable Object obj) {
                this.f11263a.f11268e.a(new FriendshipStatusChangedEvent(this.f11263a.f11265b, GraphQLFriendshipStatus.OUTGOING_REQUEST, false));
            }

            public void onFailure(Throwable th) {
                this.f11263a.f11269f.a(th, 2131230758, null, this.f11263a.f11270g);
                this.f11263a.f11268e.a(new FriendshipStatusChangedEvent(this.f11263a.f11265b, GraphQLFriendshipStatus.CAN_REQUEST, false));
            }
        }

        C12141(FriendingClient friendingClient, long j, FriendRequestHowFound friendRequestHowFound, FriendRequestMakeRef friendRequestMakeRef, FriendingEventBus friendingEventBus, FriendingExceptionHandler friendingExceptionHandler, Context context, ExecutorService executorService) {
            this.f11264a = friendingClient;
            this.f11265b = j;
            this.f11266c = friendRequestHowFound;
            this.f11267d = friendRequestMakeRef;
            this.f11268e = friendingEventBus;
            this.f11269f = friendingExceptionHandler;
            this.f11270g = context;
            this.f11271h = executorService;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ListenableFuture a = this.f11264a.a(this.f11265b, this.f11266c, null, this.f11267d);
            this.f11268e.a(new FriendshipStatusChangedEvent(this.f11265b, GraphQLFriendshipStatus.OUTGOING_REQUEST, true));
            Futures.a(a, new C12131(this), this.f11271h);
        }
    }

    DialogConfirmListenerHelper() {
    }

    static OnClickListener m13248a(long j, Context context, FriendRequestHowFound friendRequestHowFound, FriendRequestMakeRef friendRequestMakeRef, FriendingClient friendingClient, FriendingEventBus friendingEventBus, FriendingExceptionHandler friendingExceptionHandler, ExecutorService executorService) {
        return new C12141(friendingClient, j, friendRequestHowFound, friendRequestMakeRef, friendingEventBus, friendingExceptionHandler, context, executorService);
    }
}
