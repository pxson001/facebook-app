package com.facebook.goodwill.feed.data;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.goodwill.feed.protocol.FetchThrowbackSettingsGraphQL.ThrowbackSettingsSubscriptionMutationString;
import com.facebook.goodwill.feed.protocol.FetchThrowbackSettingsGraphQLModels.ThrowbackSettingsSubscriptionMutationModel;
import com.facebook.graphql.calls.ThrowbackSettingsEditInputData;
import com.facebook.graphql.calls.ThrowbackSettingsEditInputData.SubscriptionStatus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: VOIP_SELECT_SEARCH_LIST */
public class ThrowbackSettingsProtocol {
    public GraphQLQueryExecutor f21121a;
    private final TasksManager f21122b;

    @Inject
    public ThrowbackSettingsProtocol(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f21121a = graphQLQueryExecutor;
        this.f21122b = tasksManager;
    }

    public final void m22071a(AbstractDisposableFutureCallback<GraphQLResult<ThrowbackSettingsSubscriptionMutationModel>> abstractDisposableFutureCallback, boolean z) {
        Enum enumR;
        TasksManager tasksManager = this.f21122b;
        Integer valueOf = Integer.valueOf(1);
        if (z) {
            enumR = SubscriptionStatus.SUBSCRIBED_ALL;
        } else {
            enumR = SubscriptionStatus.UNSUBSCRIBED;
        }
        ThrowbackSettingsEditInputData throwbackSettingsEditInputData = new ThrowbackSettingsEditInputData();
        throwbackSettingsEditInputData.a("subscription_status", enumR);
        tasksManager.a(valueOf, this.f21121a.a(new MutationRequest((ThrowbackSettingsSubscriptionMutationString) new ThrowbackSettingsSubscriptionMutationString().a("input", throwbackSettingsEditInputData))), abstractDisposableFutureCallback);
    }
}
