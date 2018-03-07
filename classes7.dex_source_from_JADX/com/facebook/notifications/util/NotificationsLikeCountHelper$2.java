package com.facebook.notifications.util;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.notifications.protocol.FetchNotificationsLikeCountGraphQL.FetchNotificationsLikeCountString;
import com.facebook.notifications.protocol.FetchNotificationsLikeCountGraphQLModels.FetchNotificationsLikeCountModel;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* compiled from: minutiae_disk_storage_get_activities_found */
class NotificationsLikeCountHelper$2 implements AsyncFunction<ImmutableList<String>, Map<String, FetchNotificationsLikeCountModel>> {
    final /* synthetic */ NotificationsLikeCountHelper f8895a;

    NotificationsLikeCountHelper$2(NotificationsLikeCountHelper notificationsLikeCountHelper) {
        this.f8895a = notificationsLikeCountHelper;
    }

    public final ListenableFuture m10804a(Object obj) {
        return GraphQLQueryExecutor.c(((GraphQLQueryExecutor) this.f8895a.b.get()).a(GraphQLRequest.a((FetchNotificationsLikeCountString) new FetchNotificationsLikeCountString().a("node_ids", (ImmutableList) obj))));
    }
}
