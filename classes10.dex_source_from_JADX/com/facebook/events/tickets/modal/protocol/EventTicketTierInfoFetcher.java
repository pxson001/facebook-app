package com.facebook.events.tickets.modal.protocol;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.graphql.EventsGraphQL.EventDefaultTicketHolderInfoString;
import com.facebook.events.graphql.EventsGraphQL.EventTicketingInfoString;
import com.facebook.events.graphql.EventsGraphQLModels.EventDefaultTicketHolderInfoModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierFragmentModel;
import com.facebook.events.tickets.modal.EventBuyTicketsModel.State;
import com.facebook.events.tickets.modal.fragments.EventSelectTicketsFragment;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: approval_queue_thread_summary */
public class EventTicketTierInfoFetcher {
    private final GraphQLQueryExecutor f19336a;
    private final Executor f19337b;
    public final AbstractFbErrorReporter f19338c;

    @Inject
    public EventTicketTierInfoFetcher(GraphQLQueryExecutor graphQLQueryExecutor, Executor executor, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f19336a = graphQLQueryExecutor;
        this.f19337b = executor;
        this.f19338c = abstractFbErrorReporter;
    }

    public final void m19489a(String str, final EventSelectTicketsFragment eventSelectTicketsFragment) {
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("event_ticketing");
        final ListenableFuture a = GraphQLQueryExecutor.a(graphQLBatchRequest.b(GraphQLRequest.a(new EventDefaultTicketHolderInfoString())));
        GraphQlQueryString eventTicketingInfoString = new EventTicketingInfoString();
        eventTicketingInfoString.a("event_id", str);
        final ListenableFuture a2 = GraphQLQueryExecutor.a(graphQLBatchRequest.b(GraphQLRequest.a(eventTicketingInfoString)));
        Futures.a(Futures.b(new ListenableFuture[]{a, a2}), new AbstractDisposableFutureCallback<List<Object>>(this) {
            final /* synthetic */ EventTicketTierInfoFetcher f19335d;

            protected final void m19487a(Object obj) {
                try {
                    EventTicketTierFragmentModel eventTicketTierFragmentModel = (EventTicketTierFragmentModel) FutureDetour.a(a2, 951938640);
                    if (eventTicketTierFragmentModel == null || eventTicketTierFragmentModel.k() == null || eventTicketTierFragmentModel.k().a().isEmpty()) {
                        m19488a(new NullPointerException("Got empty result from GraphQL"));
                        return;
                    }
                    EventDefaultTicketHolderInfoModel eventDefaultTicketHolderInfoModel;
                    try {
                        eventDefaultTicketHolderInfoModel = (EventDefaultTicketHolderInfoModel) FutureDetour.a(a, 289189490);
                    } catch (Throwable e) {
                        m19486b(e);
                        eventDefaultTicketHolderInfoModel = null;
                    } catch (Throwable e2) {
                        m19486b(e2);
                        eventDefaultTicketHolderInfoModel = null;
                    }
                    eventSelectTicketsFragment.m19456a(eventTicketTierFragmentModel, eventDefaultTicketHolderInfoModel);
                } catch (Throwable e3) {
                    m19488a(e3);
                } catch (Throwable e32) {
                    m19488a(e32);
                }
            }

            protected final void m19488a(Throwable th) {
                m19486b(th);
                EventSelectTicketsFragment eventSelectTicketsFragment = eventSelectTicketsFragment;
                eventSelectTicketsFragment.f19295h = eventSelectTicketsFragment.f19295h.m19413a().mo864a(State.ERROR).mo868a();
                EventSelectTicketsFragment.m19450a(eventSelectTicketsFragment, eventSelectTicketsFragment.f19295h);
            }

            private void m19486b(Throwable th) {
                this.f19335d.f19338c.a(EventTicketTierInfoFetcher.class.getSimpleName(), th);
            }
        }, this.f19337b);
        this.f19336a.a(graphQLBatchRequest);
    }
}
