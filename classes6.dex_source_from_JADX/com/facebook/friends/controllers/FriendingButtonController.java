package com.facebook.friends.controllers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: me/audience_alignment_info */
public class FriendingButtonController extends BaseFriendingButtonController {
    public final Context f10610c;
    public final DefaultAndroidThreadUtil f10611d;

    /* compiled from: me/audience_alignment_info */
    class C06472 implements OnClickListener {
        final /* synthetic */ FriendingButtonController f10593a;

        C06472(FriendingButtonController friendingButtonController) {
            this.f10593a = friendingButtonController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* compiled from: me/audience_alignment_info */
    public class C06515 implements OnClickListener {
        final /* synthetic */ long f10603a;
        final /* synthetic */ FriendingLocation f10604b;
        final /* synthetic */ FriendingButtonController f10605c;

        /* compiled from: me/audience_alignment_info */
        class C06501 implements FutureCallback<GraphQLFriendshipStatus> {
            final /* synthetic */ C06515 f10602a;

            C06501(C06515 c06515) {
                this.f10602a = c06515;
            }

            public void onSuccess(@Nullable Object obj) {
                FriendingButtonController.m16734b(this.f10602a.f10605c, this.f10602a.f10603a, GraphQLFriendshipStatus.OUTGOING_REQUEST, false);
            }

            public void onFailure(Throwable th) {
                FriendingButtonController.m16734b(this.f10602a.f10605c, this.f10602a.f10603a, GraphQLFriendshipStatus.CAN_REQUEST, false);
                this.f10602a.f10605c.f10561b.a(th);
            }
        }

        public C06515(FriendingButtonController friendingButtonController, long j, FriendingLocation friendingLocation) {
            this.f10605c = friendingButtonController;
            this.f10603a = j;
            this.f10604b = friendingLocation;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ListenableFuture a = this.f10605c.f10560a.a(this.f10603a, this.f10604b.friendRequestHowFound, this.f10604b.peopleYouMayKnowLocation, null);
            FriendingButtonController.m16734b(this.f10605c, this.f10603a, GraphQLFriendshipStatus.OUTGOING_REQUEST, true);
            this.f10605c.f10611d.a(a, new C06501(this));
        }
    }

    public static FriendingButtonController m16732b(InjectorLike injectorLike) {
        return new FriendingButtonController((Context) injectorLike.getInstance(Context.class), FriendingClient.b(injectorLike), FriendingEventBus.m16746a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), FriendingExceptionHandler.b(injectorLike));
    }

    @Inject
    public FriendingButtonController(Context context, FriendingClient friendingClient, FriendingEventBus friendingEventBus, DefaultAndroidThreadUtil defaultAndroidThreadUtil, FriendingExceptionHandler friendingExceptionHandler) {
        super(friendingClient, friendingEventBus, friendingExceptionHandler);
        this.f10610c = context;
        this.f10611d = defaultAndroidThreadUtil;
    }

    public static FriendingButtonController m16731a(InjectorLike injectorLike) {
        return m16732b(injectorLike);
    }

    public final void m16736a(long j, String str, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        if (GraphQLFriendshipStatus.ARE_FRIENDS.equals(graphQLFriendshipStatus)) {
            m16733b(j, str, friendingLocation, graphQLFriendshipStatus);
        } else {
            m16737b(j, friendingLocation, graphQLFriendshipStatus);
        }
    }

    private void m16733b(long j, String str, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        Builder a = m16735a(j, friendingLocation, graphQLFriendshipStatus);
        a.b(StringLocaleUtil.a(this.f10610c.getString(2131233233), new Object[]{str}));
        a.b();
    }

    protected final Builder m16735a(final long j, FriendingLocation friendingLocation, final GraphQLFriendshipStatus graphQLFriendshipStatus) {
        final long j2 = j;
        final FriendingLocation friendingLocation2 = friendingLocation;
        final GraphQLFriendshipStatus graphQLFriendshipStatus2 = graphQLFriendshipStatus;
        OnClickListener c06461 = new OnClickListener(this) {
            final /* synthetic */ FriendingButtonController f10592d;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f10592d.m16737b(j2, friendingLocation2, graphQLFriendshipStatus2);
            }
        };
        OnClickListener c06472 = new C06472(this);
        return new Builder(this.f10610c).a(2131230729, c06461).b(2131230727, c06472).a(new OnCancelListener(this) {
            final /* synthetic */ FriendingButtonController f10596c;

            public void onCancel(DialogInterface dialogInterface) {
                FriendingButtonController.m16734b(this.f10596c, j, graphQLFriendshipStatus, false);
            }
        }).a(true);
    }

    protected final void m16737b(long j, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        GraphQLFriendshipStatus graphQLFriendshipStatus2;
        ListenableFuture listenableFuture;
        ListenableFuture a;
        if (GraphQLFriendshipStatus.ARE_FRIENDS.equals(graphQLFriendshipStatus)) {
            a = this.f10560a.a(j, friendingLocation.removeFriendRef);
            graphQLFriendshipStatus2 = GraphQLFriendshipStatus.CAN_REQUEST;
            listenableFuture = a;
        } else if (GraphQLFriendshipStatus.OUTGOING_REQUEST.equals(graphQLFriendshipStatus)) {
            a = this.f10560a.a(j, friendingLocation.friendRequestCancelRef);
            graphQLFriendshipStatus2 = GraphQLFriendshipStatus.CAN_REQUEST;
            listenableFuture = a;
        } else if (GraphQLFriendshipStatus.INCOMING_REQUEST.equals(graphQLFriendshipStatus)) {
            a = this.f10560a.a(j, FriendRequestResponse.CONFIRM, friendingLocation.friendRequestResponseRef);
            graphQLFriendshipStatus2 = GraphQLFriendshipStatus.ARE_FRIENDS;
            listenableFuture = a;
        } else if (GraphQLFriendshipStatus.CAN_REQUEST.equals(graphQLFriendshipStatus)) {
            a = this.f10560a.b(j, friendingLocation.friendRequestHowFound, friendingLocation.peopleYouMayKnowLocation, null);
            graphQLFriendshipStatus2 = GraphQLFriendshipStatus.OUTGOING_REQUEST;
            listenableFuture = a;
        } else {
            return;
        }
        m16734b(this, j, graphQLFriendshipStatus2, true);
        final long j2 = j;
        final GraphQLFriendshipStatus graphQLFriendshipStatus3 = graphQLFriendshipStatus;
        final FriendingLocation friendingLocation2 = friendingLocation;
        this.f10611d.a(listenableFuture, new AbstractDisposableFutureCallback<GraphQLFriendshipStatus>(this) {
            final /* synthetic */ FriendingButtonController f10601e;

            public final void m16729a(Object obj) {
                FriendingButtonController.m16734b(this.f10601e, j2, graphQLFriendshipStatus2, false);
            }

            public final void m16730a(Throwable th) {
                FriendingButtonController.m16734b(this.f10601e, j2, graphQLFriendshipStatus3, false);
                if (!GraphQLFriendshipStatus.CAN_REQUEST.equals(graphQLFriendshipStatus3)) {
                    this.f10601e.m16717a(th);
                } else if (!this.f10601e.f10563d) {
                    this.f10601e.f10561b.a(th, new C06515(this.f10601e, j2, friendingLocation2));
                }
            }
        });
    }

    public static void m16734b(FriendingButtonController friendingButtonController, long j, GraphQLFriendshipStatus graphQLFriendshipStatus, boolean z) {
        final long j2 = j;
        final GraphQLFriendshipStatus graphQLFriendshipStatus2 = graphQLFriendshipStatus;
        final boolean z2 = z;
        friendingButtonController.f10611d.a(new Runnable(friendingButtonController) {
            final /* synthetic */ FriendingButtonController f10609d;

            public void run() {
                this.f10609d.m16715a(j2, graphQLFriendshipStatus2, z2);
            }
        });
    }
}
