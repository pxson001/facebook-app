package com.facebook.events.dashboard.subscriptions;

import android.content.Context;
import com.facebook.events.carousel.EventCardRemover;
import com.facebook.events.graphql.EventsMutations;
import com.facebook.events.graphql.EventsMutations.ChangeSubscriptionMutationString;
import com.facebook.events.model.Event;
import com.facebook.graphql.calls.ProfileSetEventsCalendarSubscriptionStatusInputData;
import com.facebook.graphql.calls.ProfileSetEventsCalendarSubscriptionStatusInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.ProfileSetEventsCalendarSubscriptionStatusInputData.SubscriptionStatus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.action.request.MESSAGE_DIALOG */
public class EventCardUnsubscribeRemover extends EventCardRemover {
    private final GraphQLQueryExecutor f17157a;

    public static EventCardUnsubscribeRemover m17489b(InjectorLike injectorLike) {
        return new EventCardUnsubscribeRemover(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public EventCardUnsubscribeRemover(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f17157a = graphQLQueryExecutor;
    }

    public final String mo797a(Context context, Event event) {
        return context.getString(2131237192, new Object[]{event.am});
    }

    public final void mo798a(Event event) {
        ProfileSetEventsCalendarSubscriptionStatusInputData.Context a = new ProfileSetEventsCalendarSubscriptionStatusInputData.Context().a(ImmutableList.of(new EventActionHistory().a("MOBILE_SUBSCRIPTIONS_DASHBOARD")));
        ProfileSetEventsCalendarSubscriptionStatusInputData a2 = new ProfileSetEventsCalendarSubscriptionStatusInputData().a(event.al);
        a2.a("event_id", event.a);
        this.f17157a.a(GraphQLRequest.a((ChangeSubscriptionMutationString) EventsMutations.c().a("input", a2.a(SubscriptionStatus.NONE).a(a))));
    }

    public final boolean mo799a() {
        return true;
    }
}
