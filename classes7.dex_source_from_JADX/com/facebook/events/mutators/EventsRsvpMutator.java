package com.facebook.events.mutators;

import com.facebook.events.common.ActionMechanism;
import com.facebook.events.graphql.EventsMutationsModels.EventRsvpMutationModel;
import com.facebook.events.graphql.EventsMutationsModels.OptimisticRsvpEventModel;
import com.facebook.events.graphql.EventsMutationsModels.WatchEventMutationModel;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.inject.Inject;

/* compiled from: suggestion_token */
public class EventsRsvpMutator {
    private static final Function<GraphQLResult<WatchEventMutationModel>, EventRsvpResponse> f2765c = new C02401();
    private static final Function<GraphQLResult<EventRsvpMutationModel>, EventRsvpResponse> f2766d = new C02412();
    private final PrivateEventsRsvpMutator f2767a;
    private final PublicEventsRsvpMutator f2768b;

    /* compiled from: suggestion_token */
    final class C02401 implements Function<GraphQLResult<WatchEventMutationModel>, EventRsvpResponse> {
        C02401() {
        }

        public final Object apply(Object obj) {
            OptimisticRsvpEventModel a = ((WatchEventMutationModel) ((GraphQLResult) obj).e).a();
            return a != null ? new EventRsvpResponse(a.j(), a.k()) : null;
        }
    }

    /* compiled from: suggestion_token */
    final class C02412 implements Function<GraphQLResult<EventRsvpMutationModel>, EventRsvpResponse> {
        C02412() {
        }

        public final Object apply(Object obj) {
            OptimisticRsvpEventModel a = ((EventRsvpMutationModel) ((GraphQLResult) obj).e).a();
            return a != null ? new EventRsvpResponse(a.j(), a.k()) : null;
        }
    }

    /* compiled from: suggestion_token */
    public class EventRsvpResponse {
        public String f2763a;
        public GraphQLEventGuestStatus f2764b;

        public EventRsvpResponse(String str, GraphQLEventGuestStatus graphQLEventGuestStatus) {
            this.f2763a = str;
            this.f2764b = graphQLEventGuestStatus;
        }
    }

    @Inject
    public EventsRsvpMutator(PrivateEventsRsvpMutator privateEventsRsvpMutator, PublicEventsRsvpMutator publicEventsRsvpMutator) {
        this.f2767a = privateEventsRsvpMutator;
        this.f2768b = publicEventsRsvpMutator;
    }

    public final ListenableFuture<EventRsvpResponse> m3029a(String str, GraphQLEventGuestStatus graphQLEventGuestStatus, String str2, String str3, ActionMechanism actionMechanism) {
        return Futures.a(this.f2767a.m3043a(str, graphQLEventGuestStatus, str3, str2, actionMechanism, null), f2766d, MoreExecutors.a());
    }
}
