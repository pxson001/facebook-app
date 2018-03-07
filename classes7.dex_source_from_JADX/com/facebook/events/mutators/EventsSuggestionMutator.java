package com.facebook.events.mutators;

import com.facebook.events.graphql.EventsMutations.RemoveSuggestedEventMutationString;
import com.facebook.graphql.calls.EventSuggestionTakeNegativeActionInputData;
import com.facebook.graphql.calls.EventSuggestionTakeNegativeActionInputData.Context;
import com.facebook.graphql.calls.EventSuggestionTakeNegativeActionInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventSuggestionTakeNegativeActionInputData.NegativeActionType;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: suggestion_category */
public class EventsSuggestionMutator {
    GraphQLQueryExecutor f2769a;

    public static EventsSuggestionMutator m3030b(InjectorLike injectorLike) {
        return new EventsSuggestionMutator(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public EventsSuggestionMutator(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f2769a = graphQLQueryExecutor;
    }

    public final void m3031a(String str, String str2) {
        Context context = new Context();
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a("surface", str2);
        context.a("event_action_history", ImmutableList.of(eventActionHistory));
        GraphQlCallInput graphQlCallInput = context;
        EventSuggestionTakeNegativeActionInputData eventSuggestionTakeNegativeActionInputData = new EventSuggestionTakeNegativeActionInputData();
        eventSuggestionTakeNegativeActionInputData.a("event_id", str);
        GraphQlCallInput graphQlCallInput2 = eventSuggestionTakeNegativeActionInputData;
        graphQlCallInput2.a("negative_action_type", NegativeActionType.HIDE);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("context", graphQlCallInput);
        this.f2769a.a(GraphQLRequest.a((RemoveSuggestedEventMutationString) new RemoveSuggestedEventMutationString().a("input", graphQlCallInput2)));
    }
}
