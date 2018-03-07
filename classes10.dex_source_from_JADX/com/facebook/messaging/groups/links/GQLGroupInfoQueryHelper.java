package com.facebook.messaging.groups.links;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.groups.graphql.GroupThreadQueueEnabledQuery.GroupThreadQueueEnabledQueryString;
import com.facebook.messaging.groups.graphql.GroupThreadQueueEnabledQueryModels.GroupThreadQueueEnabledQueryModel;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.FetchIsThreadQueueEnabledResult;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;

/* compiled from: showFriendPicker */
public class GQLGroupInfoQueryHelper {
    public final GraphQLQueryExecutor f2472a;

    public static GQLGroupInfoQueryHelper m2477b(InjectorLike injectorLike) {
        return new GQLGroupInfoQueryHelper(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public GQLGroupInfoQueryHelper(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f2472a = graphQLQueryExecutor;
    }

    public final FetchIsThreadQueueEnabledResult m2478a(ThreadKey threadKey) {
        GraphQlQueryString groupThreadQueueEnabledQueryString = new GroupThreadQueueEnabledQueryString();
        groupThreadQueueEnabledQueryString.a("id", Long.valueOf(threadKey.i()));
        GroupThreadQueueEnabledQueryModel groupThreadQueueEnabledQueryModel = (GroupThreadQueueEnabledQueryModel) FutureDetour.a(GraphQLQueryExecutor.a(this.f2472a.a(GraphQLRequest.a(groupThreadQueueEnabledQueryString))), -1705114720);
        if (groupThreadQueueEnabledQueryModel != null) {
            return new FetchIsThreadQueueEnabledResult(groupThreadQueueEnabledQueryModel.m2434a());
        }
        throw new ExecutionException(new IllegalStateException("Unable to process GroupThreadQueueEnabledQueryModel."));
    }
}
