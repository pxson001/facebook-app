package com.facebook.events.mutators;

import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsMutations.CancelEventMutationString;
import com.facebook.events.graphql.EventsMutationsModels.CancelEventMutationModel;
import com.facebook.graphql.calls.EventCancelInputData;
import com.facebook.graphql.calls.EventCancelInputData.Context;
import com.facebook.graphql.calls.EventCancelInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: sun */
public class EventDeleteAndCancelMutator {
    public GraphQLQueryExecutor f2762a;

    public static EventDeleteAndCancelMutator m3027b(InjectorLike injectorLike) {
        return new EventDeleteAndCancelMutator(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public EventDeleteAndCancelMutator(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f2762a = graphQLQueryExecutor;
    }

    public final ListenableFuture<GraphQLResult<CancelEventMutationModel>> m3028a(String str, EventAnalyticsParams eventAnalyticsParams, String str2) {
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(eventAnalyticsParams.c);
        EventActionHistory eventActionHistory2 = new EventActionHistory();
        eventActionHistory2.a(eventAnalyticsParams.d);
        eventActionHistory2.a("mechanism", str2);
        Context context = new Context();
        context.a("event_action_history", ImmutableList.of(eventActionHistory, eventActionHistory2));
        EventCancelInputData eventCancelInputData = new EventCancelInputData();
        eventCancelInputData.a("event_id", str);
        GraphQlCallInput graphQlCallInput = eventCancelInputData;
        graphQlCallInput.a("context", context);
        return this.f2762a.a(GraphQLRequest.a((CancelEventMutationString) new CancelEventMutationString().a("input", graphQlCallInput)));
    }
}
