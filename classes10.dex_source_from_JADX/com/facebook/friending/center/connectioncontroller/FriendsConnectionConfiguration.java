package com.facebook.friending.center.connectioncontroller;

import com.facebook.controller.connectioncontroller.common.ConnectionFetchOperation;
import com.facebook.controller.connectioncontroller.common.ConnectionPage;
import com.facebook.controller.connectioncontroller.common.SimpleConnectionConfiguration;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterFetchFriendsGraphQL;
import com.facebook.friending.center.protocol.FriendsCenterFetchFriendsGraphQL.FriendsCenterFetchFriendsQueryString;
import com.facebook.friending.center.protocol.FriendsCenterFetchFriendsGraphQLModels.FriendsCenterFetchFriendsQueryModel;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: all_friends_suggestion_section */
public class FriendsConnectionConfiguration implements SimpleConnectionConfiguration<FriendsCenterDefaultNodeModel, Void, FriendsCenterFetchFriendsQueryModel> {
    private static final List<String> f19963a = Lists.a(new String[]{"first_name"});

    public static FriendsConnectionConfiguration m20134a(InjectorLike injectorLike) {
        return new FriendsConnectionConfiguration();
    }

    public final TypedGraphQlQueryString m20136a(ConnectionFetchOperation connectionFetchOperation, Object obj) {
        FriendsCenterFetchFriendsQueryString a = FriendsCenterFetchFriendsGraphQL.m20213a();
        a.a("after_param", connectionFetchOperation.d).a("first_param", Integer.valueOf(connectionFetchOperation.e)).a("order_param", f19963a);
        return a;
    }

    public final ConnectionPage<FriendsCenterDefaultNodeModel> m20135a(GraphQLResult<FriendsCenterFetchFriendsQueryModel> graphQLResult) {
        DefaultPageInfoFieldsModel j = ((FriendsCenterFetchFriendsQueryModel) graphQLResult.e).m20224a().m20220j();
        return new ConnectionPage(((FriendsCenterFetchFriendsQueryModel) graphQLResult.e).m20224a().m20219a(), j.v_(), j.a(), j.c(), j.b());
    }
}
