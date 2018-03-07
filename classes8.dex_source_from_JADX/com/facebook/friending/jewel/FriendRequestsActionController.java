package com.facebook.friending.jewel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.friending.jewel.adapter.FriendRequestsAdapter;
import com.facebook.friends.FriendingCacheHandler;
import com.facebook.friends.FriendingCacheHandlerProvider;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.inject.Assisted;
import com.facebook.nux.status.NuxStepListener;
import com.facebook.ui.futures.TasksManager;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: flow_exit_since_background_conf */
public class FriendRequestsActionController {
    private final AnalyticsLogger f13155a;
    public final FriendingClient f13156b;
    private final FriendingEventBus f13157c;
    public final FriendingExceptionHandler f13158d;
    private final FriendingCacheHandler f13159e;
    private final Context f13160f;
    private final FriendingLocation f13161g;
    private final FriendRequestsAdapter f13162h;
    public final TasksManager<String> f13163i;

    @Inject
    public FriendRequestsActionController(AnalyticsLogger analyticsLogger, FriendingClient friendingClient, FriendingEventBus friendingEventBus, FriendingExceptionHandler friendingExceptionHandler, FriendingCacheHandlerProvider friendingCacheHandlerProvider, @Assisted Context context, @Assisted FriendingLocation friendingLocation, @Assisted FriendRequestsAdapter friendRequestsAdapter, @Assisted TasksManager tasksManager) {
        this.f13155a = analyticsLogger;
        this.f13156b = friendingClient;
        this.f13157c = friendingEventBus;
        this.f13158d = friendingExceptionHandler;
        this.f13159e = friendingCacheHandlerProvider.a(tasksManager);
        this.f13160f = context;
        this.f13161g = friendingLocation;
        this.f13162h = friendRequestsAdapter;
        this.f13163i = tasksManager;
    }

    public final void m14822a(final FriendRequest friendRequest, FriendRequestResponse friendRequestResponse) {
        this.f13159e.c();
        m14817a();
        m14820d(friendRequest);
        long a = friendRequest.a();
        ListenableFuture a2 = this.f13156b.a(a, friendRequestResponse, this.f13161g.friendRequestResponseRef);
        GraphQLFriendshipStatus graphQLFriendshipStatus = GraphQLFriendshipStatus.ARE_FRIENDS;
        if (friendRequestResponse == FriendRequestResponse.REJECT) {
            graphQLFriendshipStatus = GraphQLFriendshipStatus.CAN_REQUEST;
        }
        m14818a(this, a, graphQLFriendshipStatus, true);
        this.f13163i.b("RESPOND_TO_FRIEND_REQUEST_TASK" + a, a2, new AbstractDisposableFutureCallback<GraphQLFriendshipStatus>(this) {
            final /* synthetic */ FriendRequestsActionController f13144b;

            public final void m14810a(Throwable th) {
                FriendRequestsActionController.m14819a(this.f13144b, friendRequest, GraphQLFriendshipStatus.INCOMING_REQUEST, th);
            }
        });
    }

    public final void m14821a(final FriendRequest friendRequest) {
        this.f13159e.c();
        m14817a();
        m14820d(friendRequest);
        final long a = friendRequest.a();
        ListenableFuture b = this.f13156b.b(a, FriendRequestHowFound.SUGGESTION, null, null);
        m14818a(this, a, GraphQLFriendshipStatus.OUTGOING_REQUEST, true);
        this.f13163i.b("RESPOND_TO_FRIEND_SUGGEST_TASK" + a, b, new AbstractDisposableFutureCallback<GraphQLFriendshipStatus>(this) {
            final /* synthetic */ FriendRequestsActionController f13147c;

            public final void m14811a(@Nullable Object obj) {
                FriendRequestsActionController.m14818a(this.f13147c, a, GraphQLFriendshipStatus.OUTGOING_REQUEST, false);
            }

            public final void m14812a(Throwable th) {
                FriendRequestsActionController.m14818a(this.f13147c, a, GraphQLFriendshipStatus.CAN_REQUEST, false);
                FriendRequestsActionController.m14819a(this.f13147c, friendRequest, null, th);
            }
        });
    }

    public final void m14823b(final FriendRequest friendRequest) {
        this.f13159e.b();
        m14817a();
        m14820d(friendRequest);
        String str = friendRequest.b;
        ListenableFuture a = this.f13156b.a(Long.parseLong(str));
        this.f13162h.mo829a(str, FriendRequestState.REJECTED, false);
        this.f13163i.b("RESPOND_TO_FRIEND_SUGGEST_TASK" + str, a, new AbstractDisposableFutureCallback<GraphQLFriendshipStatus>(this) {
            final /* synthetic */ FriendRequestsActionController f13149b;

            public final void m14814a(Throwable th) {
                FriendRequestsActionController.m14819a(this.f13149b, friendRequest, null, th);
            }
        });
    }

    public static void m14819a(FriendRequestsActionController friendRequestsActionController, @Nullable final FriendRequest friendRequest, GraphQLFriendshipStatus graphQLFriendshipStatus, Throwable th) {
        friendRequestsActionController.f13158d.a(th, new OnClickListener(friendRequestsActionController) {
            final /* synthetic */ FriendRequestsActionController f13154b;

            /* compiled from: flow_exit_since_background_conf */
            class C13712 extends AbstractDisposableFutureCallback<GraphQLFriendshipStatus> {
                final /* synthetic */ C13724 f13152a;

                C13712(C13724 c13724) {
                    this.f13152a = c13724;
                }

                protected final void m14815a(@Nullable Object obj) {
                    FriendRequestsActionController.m14818a(this.f13152a.f13154b, friendRequest.a(), GraphQLFriendshipStatus.OUTGOING_REQUEST, false);
                }

                protected final void m14816a(Throwable th) {
                    FriendRequestsActionController.m14818a(this.f13152a.f13154b, friendRequest.a(), GraphQLFriendshipStatus.CAN_REQUEST, false);
                    this.f13152a.f13154b.f13158d.a(th);
                }
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                final ListenableFuture a = this.f13154b.f13156b.a(friendRequest.a(), FriendRequestHowFound.SUGGESTION, null, null);
                FriendRequestsActionController.m14818a(this.f13154b, friendRequest.a(), GraphQLFriendshipStatus.OUTGOING_REQUEST, true);
                this.f13154b.f13163i.a("ADD_FRIEND_IGNORE_WARN" + friendRequest.a(), new Callable<ListenableFuture<GraphQLFriendshipStatus>>(this) {
                    final /* synthetic */ C13724 f13151b;

                    public Object call() {
                        return a;
                    }
                }, new C13712(this));
            }
        });
        if (!(th instanceof GraphQLException) || friendRequest.l()) {
            friendRequestsActionController.f13162h.mo829a(friendRequest.b, FriendRequestState.NEEDS_RESPONSE, true);
        } else {
            friendRequestsActionController.f13162h.mo828a(friendRequest.b);
        }
        if (graphQLFriendshipStatus != null) {
            m14818a(friendRequestsActionController, friendRequest.a(), graphQLFriendshipStatus, false);
        }
    }

    private void m14820d(FriendRequest friendRequest) {
        if (friendRequest != null) {
            if (!StringUtil.a(new CharSequence[]{friendRequest.i, "friending_possibilities_click"})) {
                ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
                arrayNode.h(r0);
                this.f13155a.c(new HoneyClientEvent(r1).a("tracking", arrayNode));
            }
        }
    }

    private void m14817a() {
        if (this.f13160f instanceof NuxStepListener) {
            ((NuxStepListener) this.f13160f).c("people_you_may_know");
        }
    }

    public static void m14818a(FriendRequestsActionController friendRequestsActionController, long j, GraphQLFriendshipStatus graphQLFriendshipStatus, boolean z) {
        friendRequestsActionController.f13157c.a(new FriendshipStatusChangedEvent(j, graphQLFriendshipStatus, z));
    }
}
