package com.facebook.friends;

import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.error.GraphQLException;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: me/privacy_checkup_mobile_events */
class FriendingClient$7 implements FutureCallback<GraphQLFriendshipStatus> {
    final /* synthetic */ short f10550a;
    final /* synthetic */ FriendRequestHowFound f10551b;
    final /* synthetic */ FriendingClient f10552c;

    FriendingClient$7(FriendingClient friendingClient, short s, FriendRequestHowFound friendRequestHowFound) {
        this.f10552c = friendingClient;
        this.f10550a = s;
        this.f10551b = friendRequestHowFound;
    }

    public void onSuccess(@Nullable Object obj) {
        this.f10552c.k.b(FunnelRegistry.w, (long) this.f10550a, "success");
        this.f10552c.k.b(FunnelRegistry.w, (long) this.f10550a, this.f10551b.value);
        this.f10552c.k.b(FunnelRegistry.w, (long) this.f10550a);
    }

    public void onFailure(Throwable th) {
        String str = "failure_local";
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        if (th instanceof GraphQLException) {
            GraphQLException graphQLException = (GraphQLException) th;
            objectNode.a("error_code", graphQLException.error.a());
            objectNode.a("error_domain", graphQLException.error.h().toString());
            str = "failure_api";
        }
        objectNode.a("error_class", th.getClass().getName());
        objectNode.a("error_message", th.getMessage());
        this.f10552c.k.a(FunnelRegistry.w, (long) this.f10550a, str, objectNode.toString());
        this.f10552c.k.b(FunnelRegistry.w, (long) this.f10550a, this.f10551b.value);
        this.f10552c.k.b(FunnelRegistry.w, (long) this.f10550a);
    }
}
