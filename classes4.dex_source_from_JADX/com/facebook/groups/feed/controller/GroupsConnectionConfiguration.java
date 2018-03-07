package com.facebook.groups.feed.controller;

import com.facebook.api.feed.FeedFetchContext;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feedtype.FeedType;
import com.facebook.controller.connectioncontroller.common.ConnectionFetchOperation;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionPage;
import com.facebook.controller.connectioncontroller.common.LegacyConnectionConfiguration;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLGroup;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupFeedMethod;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: messenger_status */
public class GroupsConnectionConfiguration implements LegacyConnectionConfiguration<GraphQLFeedUnitEdge, Boolean, GraphQLGroup, GraphQLFeedHomeStories> {
    private FetchGroupFeedMethod f7930a;
    public FeedType f7931b;
    public FeedFetchContext f7932c;

    public static GroupsConnectionConfiguration m8240a(InjectorLike injectorLike) {
        return new GroupsConnectionConfiguration(FetchGroupFeedMethod.b(injectorLike));
    }

    public final TypedGraphQlQueryString m8242a(ConnectionFetchOperation connectionFetchOperation, Object obj) {
        boolean z;
        Object obj2;
        FetchFeedParams q;
        Boolean bool = (Boolean) obj;
        if (connectionFetchOperation.b == ConnectionOrder.FIRST) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (connectionFetchOperation.d == null) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        FetchFeedParamsBuilder a;
        if (obj2 != null) {
            FetchFeedCause fetchFeedCause = bool.booleanValue() ? FetchFeedCause.PULL_TO_REFRESH : FetchFeedCause.INITIALIZATION;
            FetchFeedParamsBuilder fetchFeedParamsBuilder = new FetchFeedParamsBuilder();
            fetchFeedParamsBuilder.c = connectionFetchOperation.e;
            fetchFeedParamsBuilder = fetchFeedParamsBuilder;
            fetchFeedParamsBuilder.b = this.f7931b;
            fetchFeedParamsBuilder = fetchFeedParamsBuilder;
            fetchFeedParamsBuilder.a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
            fetchFeedParamsBuilder = fetchFeedParamsBuilder;
            fetchFeedParamsBuilder.l = this.f7932c;
            a = fetchFeedParamsBuilder.a(fetchFeedCause);
            a.g = connectionFetchOperation.c;
            q = a.q();
        } else {
            if (connectionFetchOperation.c != null || connectionFetchOperation.d == null) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                a = new FetchFeedParamsBuilder();
                a.c = connectionFetchOperation.e;
                a = a;
                a.b = this.f7931b;
                a = a;
                a.a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
                a = a;
                a.l = this.f7932c;
                a = a;
                a.f = connectionFetchOperation.d;
                q = a.q();
            } else {
                throw new RuntimeException("Neck Fetch not supported in Groups!");
            }
        }
        return this.f7930a.e(q);
    }

    @Inject
    public GroupsConnectionConfiguration(FetchGroupFeedMethod fetchGroupFeedMethod) {
        this.f7930a = fetchGroupFeedMethod;
    }

    public final ConnectionPage<GraphQLFeedUnitEdge> m8241a(GraphQLResult<GraphQLFeedHomeStories> graphQLResult) {
        GraphQLFeedHomeStories graphQLFeedHomeStories = (GraphQLFeedHomeStories) graphQLResult.e;
        return new ConnectionPage(graphQLFeedHomeStories.k(), graphQLFeedHomeStories.n().v_(), graphQLFeedHomeStories.n().a(), graphQLFeedHomeStories.n().c(), graphQLFeedHomeStories.n().b());
    }
}
