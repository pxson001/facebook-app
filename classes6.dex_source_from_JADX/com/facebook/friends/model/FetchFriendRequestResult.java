package com.facebook.friends.model;

import com.facebook.graphql.model.GraphQLPageInfo;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: max_likers */
public class FetchFriendRequestResult {
    public final ImmutableList<FriendRequest> f10645a;
    public final GraphQLPageInfo f10646b;

    public FetchFriendRequestResult(ImmutableList<FriendRequest> immutableList, GraphQLPageInfo graphQLPageInfo) {
        this.f10645a = immutableList;
        this.f10646b = graphQLPageInfo;
    }
}
