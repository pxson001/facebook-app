package com.facebook.events.tickets.modal.protocol;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.internal.Preconditions;
import com.facebook.events.graphql.EventsGraphQL.EventTicketOrdersQueryString;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrderModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrdersQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrdersQueryModel.PurchasedTicketOrdersModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrdersQueryModel.PurchasedTicketOrdersModel.EdgesModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.LinkableTextWithEntitiesModel;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: archiveThread */
public class EventTicketOrdersFetcher {
    public final String f19326a;
    public final Callback f19327b;
    public final GraphQLQueryExecutor f19328c;
    public final TasksManager<String> f19329d;
    @Nullable
    public String f19330e;
    public boolean f19331f;

    /* compiled from: archiveThread */
    public interface Callback {
        void mo875a(EventTicketOrderModel eventTicketOrderModel);

        void mo876a(LinkableTextWithEntitiesModel linkableTextWithEntitiesModel, String str);

        void mo877a(ImmutableList<EdgesModel> immutableList);
    }

    /* compiled from: archiveThread */
    public class C27381 extends AbstractDisposableFutureCallback<GraphQLResult<EventTicketOrderModel>> {
        final /* synthetic */ EventTicketOrdersFetcher f19323a;

        public C27381(EventTicketOrdersFetcher eventTicketOrdersFetcher) {
            this.f19323a = eventTicketOrdersFetcher;
        }

        protected final void m19481a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e == null) {
                m19482a(new NullPointerException("Null GraphQL result"));
            } else {
                this.f19323a.f19327b.mo875a((EventTicketOrderModel) graphQLResult.e);
            }
        }

        protected final void m19482a(Throwable th) {
        }
    }

    /* compiled from: archiveThread */
    class C27392 implements Callable<ListenableFuture<GraphQLResult<EventTicketOrdersQueryModel>>> {
        final /* synthetic */ EventTicketOrdersFetcher f19324a;

        C27392(EventTicketOrdersFetcher eventTicketOrdersFetcher) {
            this.f19324a = eventTicketOrdersFetcher;
        }

        public Object call() {
            GraphQlQueryString eventTicketOrdersQueryString = new EventTicketOrdersQueryString();
            eventTicketOrdersQueryString.a("event_id", this.f19324a.f19326a).a("first_count", Integer.valueOf(20)).a("after_cursor", this.f19324a.f19330e);
            return this.f19324a.f19328c.a(GraphQLRequest.a(eventTicketOrdersQueryString));
        }
    }

    /* compiled from: archiveThread */
    class C27403 extends AbstractDisposableFutureCallback<GraphQLResult<EventTicketOrdersQueryModel>> {
        final /* synthetic */ EventTicketOrdersFetcher f19325a;

        C27403(EventTicketOrdersFetcher eventTicketOrdersFetcher) {
            this.f19325a = eventTicketOrdersFetcher;
        }

        protected final void m19483a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e == null || ((EventTicketOrdersQueryModel) graphQLResult.e).k() == null) {
                m19484a(new NullPointerException("Null GraphQL result"));
                return;
            }
            if (this.f19325a.f19330e == null && ((EventTicketOrdersQueryModel) graphQLResult.e).j() != null) {
                this.f19325a.f19327b.mo876a(((EventTicketOrdersQueryModel) graphQLResult.e).j().a(), ((EventTicketOrdersQueryModel) graphQLResult.e).j().j());
            }
            EventTicketOrdersFetcher eventTicketOrdersFetcher = this.f19325a;
            PurchasedTicketOrdersModel k = ((EventTicketOrdersQueryModel) graphQLResult.e).k();
            ImmutableList a = k.a();
            eventTicketOrdersFetcher.f19330e = k.j() != null ? k.j().a() : null;
            if (eventTicketOrdersFetcher.f19330e == null) {
                eventTicketOrdersFetcher.f19331f = true;
            }
            eventTicketOrdersFetcher.f19327b.mo877a(a);
        }

        protected final void m19484a(Throwable th) {
        }
    }

    @Inject
    public EventTicketOrdersFetcher(@Assisted String str, @Assisted Callback callback, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f19326a = (String) Preconditions.a(str);
        this.f19327b = (Callback) Preconditions.a(callback);
        this.f19328c = graphQLQueryExecutor;
        this.f19329d = tasksManager;
    }

    public final void m19485a() {
        this.f19329d.a("initial_fetch", new C27392(this), new C27403(this));
    }
}
