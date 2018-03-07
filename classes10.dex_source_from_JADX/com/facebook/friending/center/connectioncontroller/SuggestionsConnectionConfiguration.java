package com.facebook.friending.center.connectioncontroller;

import com.facebook.controller.connectioncontroller.common.ConnectionFetchOperation;
import com.facebook.controller.connectioncontroller.common.ConnectionPage;
import com.facebook.controller.connectioncontroller.common.SimpleConnectionConfiguration;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterFetchSuggestionsGraphQL;
import com.facebook.friending.center.protocol.FriendsCenterFetchSuggestionsGraphQL.FriendsCenterFetchSuggestionsQueryString;
import com.facebook.friending.center.protocol.FriendsCenterFetchSuggestionsGraphQLModels.FriendsCenterFetchSuggestionsQueryModel;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;

/* compiled from: all_friends */
public class SuggestionsConnectionConfiguration implements SimpleConnectionConfiguration<FriendsCenterDefaultNodeModel, Void, FriendsCenterFetchSuggestionsQueryModel> {
    public final TypedGraphQlQueryString m20138a(ConnectionFetchOperation connectionFetchOperation, Object obj) {
        FriendsCenterFetchSuggestionsQueryString a = FriendsCenterFetchSuggestionsGraphQL.m20290a();
        a.a("location", FriendingLocation.FRIENDS_CENTER_SUGGESTIONS.peopleYouMayKnowLocation.value).a("max", "250").a("after", connectionFetchOperation.d).a("first", Integer.valueOf(connectionFetchOperation.e));
        return a;
    }

    public final ConnectionPage<FriendsCenterDefaultNodeModel> m20137a(GraphQLResult<FriendsCenterFetchSuggestionsQueryModel> graphQLResult) {
        DefaultPageInfoFieldsModel j = ((FriendsCenterFetchSuggestionsQueryModel) graphQLResult.e).m20300a().m20297j();
        return new ConnectionPage(((FriendsCenterFetchSuggestionsQueryModel) graphQLResult.e).m20300a().m20296a(), j.v_(), j.a(), j.c(), j.b());
    }
}
