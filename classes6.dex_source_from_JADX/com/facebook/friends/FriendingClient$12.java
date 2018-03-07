package com.facebook.friends;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import javax.annotation.Nullable;

/* compiled from: me/privacy_checkup_mobile_events */
class FriendingClient$12 extends AbstractDisposableFutureCallback<GraphQLFriendshipStatus> {
    final /* synthetic */ long f10539a;
    final /* synthetic */ GraphQLFriendshipStatus f10540b;
    final /* synthetic */ FriendingClient f10541c;

    FriendingClient$12(FriendingClient friendingClient, long j, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        this.f10541c = friendingClient;
        this.f10539a = j;
        this.f10540b = graphQLFriendshipStatus;
    }

    public final void m16711a(@Nullable Object obj) {
        GraphQLFriendshipStatus graphQLFriendshipStatus = (GraphQLFriendshipStatus) obj;
        if (graphQLFriendshipStatus != null) {
            this.f10541c.j.a(this.f10539a, graphQLFriendshipStatus);
        } else {
            this.f10541c.j.a(this.f10539a, this.f10540b);
        }
    }

    public final void m16712a(Throwable th) {
    }
}
