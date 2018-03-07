package com.facebook.events.dashboard.subscriptions;

import android.content.Context;
import com.facebook.events.carousel.EventCardRemover;
import com.facebook.events.graphql.EventsMutations.RemoveSubscribedEventMutationString;
import com.facebook.events.model.Event;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.SubscribedEventTakeNegativeActionInputData;
import com.facebook.graphql.calls.SubscribedEventTakeNegativeActionInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.SubscribedEventTakeNegativeActionInputData.NegativeActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG */
public class EventCardSubscribedRemover extends EventCardRemover {
    private final GraphQLQueryExecutor f17156a;

    public static EventCardSubscribedRemover m17485b(InjectorLike injectorLike) {
        return new EventCardSubscribedRemover(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public EventCardSubscribedRemover(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f17156a = graphQLQueryExecutor;
    }

    public final String mo797a(Context context, Event event) {
        return context.getString(2131237191);
    }

    public final void mo798a(Event event) {
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a("surface", "MOBILE_SUBSCRIPTIONS_DASHBOARD");
        eventActionHistory = eventActionHistory;
        SubscribedEventTakeNegativeActionInputData.Context context = new SubscribedEventTakeNegativeActionInputData.Context();
        context.a("event_action_history", ImmutableList.of(eventActionHistory));
        GraphQlCallInput graphQlCallInput = context;
        SubscribedEventTakeNegativeActionInputData subscribedEventTakeNegativeActionInputData = new SubscribedEventTakeNegativeActionInputData();
        subscribedEventTakeNegativeActionInputData.a("event_id", event.a);
        GraphQlCallInput graphQlCallInput2 = subscribedEventTakeNegativeActionInputData;
        graphQlCallInput2.a("negative_action_type", NegativeActionType.HIDE);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("context", graphQlCallInput);
        this.f17156a.a(GraphQLRequest.a((RemoveSubscribedEventMutationString) new RemoveSubscribedEventMutationString().a("input", graphQlCallInput2)));
    }

    public final boolean mo799a() {
        return false;
    }
}
