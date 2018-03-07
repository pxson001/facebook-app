package com.facebook.events.mutators;

import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsMutations;
import com.facebook.events.graphql.EventsMutations.ChangeSubscriptionMutationString;
import com.facebook.events.graphql.EventsMutationsModels.ChangeSubscriptionMutationModel;
import com.facebook.graphql.calls.ProfileSetEventsCalendarSubscriptionStatusInputData;
import com.facebook.graphql.calls.ProfileSetEventsCalendarSubscriptionStatusInputData.Context;
import com.facebook.graphql.calls.ProfileSetEventsCalendarSubscriptionStatusInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.ProfileSetEventsCalendarSubscriptionStatusInputData.SubscriptionStatus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: suggested_purpose */
public class SubscribeToPageEventsMutator {
    GraphQLQueryExecutor f2779a;

    public static SubscribeToPageEventsMutator m3055b(InjectorLike injectorLike) {
        return new SubscribeToPageEventsMutator(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public SubscribeToPageEventsMutator(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f2779a = graphQLQueryExecutor;
    }

    public final ListenableFuture<GraphQLResult<ChangeSubscriptionMutationModel>> m3057a(String str, SubscriptionStatus subscriptionStatus, ActionMechanism actionMechanism, String str2, String str3) {
        ProfileSetEventsCalendarSubscriptionStatusInputData a = new ProfileSetEventsCalendarSubscriptionStatusInputData().a(m3054a(actionMechanism, str2.toString(), null, str3.toString(), null)).a(str).a(subscriptionStatus);
        ChangeSubscriptionMutationString c = EventsMutations.c();
        c.a("input", a);
        return this.f2779a.a(GraphQLRequest.a(c));
    }

    public final ListenableFuture<GraphQLResult<ChangeSubscriptionMutationModel>> m3056a(String str, SubscriptionStatus subscriptionStatus, ActionMechanism actionMechanism, EventAnalyticsParams eventAnalyticsParams, @Nullable String str2) {
        ProfileSetEventsCalendarSubscriptionStatusInputData a = new ProfileSetEventsCalendarSubscriptionStatusInputData().a(m3054a(actionMechanism, eventAnalyticsParams.c, eventAnalyticsParams.e, eventAnalyticsParams.d, str2)).a(str).a(subscriptionStatus);
        ChangeSubscriptionMutationString c = EventsMutations.c();
        c.a("input", a);
        return this.f2779a.a(GraphQLRequest.a(c));
    }

    private static Context m3054a(ActionMechanism actionMechanism, String str, String str2, String str3, String str4) {
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(str);
        if (str2 != null) {
            eventActionHistory.b(str2);
        }
        EventActionHistory eventActionHistory2 = new EventActionHistory();
        eventActionHistory2.a(str3);
        eventActionHistory2.b(actionMechanism.toString());
        if (str4 != null) {
            eventActionHistory2.a("extra_data", str4);
        }
        Context context = new Context();
        context.a(ImmutableList.of(eventActionHistory, eventActionHistory2));
        return context;
    }
}
