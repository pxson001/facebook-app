package com.facebook.events.tickets;

import android.content.Context;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsMutations.EventPurchaseTicketMutationString;
import com.facebook.events.graphql.EventsMutationsModels.EventPurchaseTicketMutationModel;
import com.facebook.events.tickets.EventBuyTicketsDialogAdapter.C27053;
import com.facebook.graphql.calls.EventPurchaseTicketsInputData;
import com.facebook.graphql.calls.EventPurchaseTicketsInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventPurchaseTicketsInputData.Tiers;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: attempt_login */
public class EventBuyTicketsGraphQLMutator {
    public final Context f19136a;
    private final GraphQLQueryExecutor f19137b;
    public final ImpressionManager f19138c;
    private final TasksManager<String> f19139d;

    @Inject
    public EventBuyTicketsGraphQLMutator(Context context, GraphQLQueryExecutor graphQLQueryExecutor, ImpressionManager impressionManager, TasksManager tasksManager) {
        this.f19136a = context;
        this.f19137b = graphQLQueryExecutor;
        this.f19138c = impressionManager;
        this.f19139d = tasksManager;
    }

    public final void m19328a(String str, String str2, int i, EventAnalyticsParams eventAnalyticsParams, C27053 c27053) {
        m19327a(str, str2, i, null, null, eventAnalyticsParams, c27053);
    }

    private void m19327a(String str, String str2, int i, String str3, String str4, EventAnalyticsParams eventAnalyticsParams, C27053 c27053) {
        final String str5 = str;
        final String str6 = str2;
        final int i2 = i;
        final String str7 = str3;
        final String str8 = str4;
        final EventAnalyticsParams eventAnalyticsParams2 = eventAnalyticsParams;
        final C27053 c270532 = c27053;
        this.f19139d.a("task_event_tickets_purchase", new Callable<ListenableFuture<EventPurchaseTicketMutationModel>>(this) {
            final /* synthetic */ EventBuyTicketsGraphQLMutator f19133g;

            public Object call() {
                return this.f19133g.m19326a(str5, str6, i2, str7, str8, eventAnalyticsParams2);
            }
        }, new AbstractDisposableFutureCallback<EventPurchaseTicketMutationModel>(this) {
            final /* synthetic */ EventBuyTicketsGraphQLMutator f19135b;

            protected final void m19323a(Object obj) {
                EventPurchaseTicketMutationModel eventPurchaseTicketMutationModel = (EventPurchaseTicketMutationModel) obj;
                if (eventPurchaseTicketMutationModel == null) {
                    c270532.m19313a(new Throwable("Null GraphQL mutation result"));
                } else if ("success".equals(eventPurchaseTicketMutationModel.m())) {
                    C27053 c27053 = c270532;
                    eventPurchaseTicketMutationModel.k();
                    eventPurchaseTicketMutationModel.l();
                    eventPurchaseTicketMutationModel.a();
                    c27053.f19087a.f19113m.a("payments_pay_success");
                    c27053.f19087a.f19124x.f17776d = c27053.f19087a.f19121u;
                    c27053.f19087a.f19106D.a();
                    Toaster toaster = c27053.f19087a.f19118r;
                    ToastBuilder toastBuilder = new ToastBuilder(2131241922);
                    toastBuilder.b = 17;
                    toaster.a(toastBuilder);
                } else {
                    String j = eventPurchaseTicketMutationModel.j();
                    if (Strings.isNullOrEmpty(j)) {
                        c270532.m19313a(new Throwable("Generic Failure"));
                    } else {
                        c270532.m19312a(eventPurchaseTicketMutationModel.k(), j);
                    }
                }
            }

            protected final void m19324a(Throwable th) {
                c270532.m19313a(th);
            }
        });
    }

    private ListenableFuture<EventPurchaseTicketMutationModel> m19326a(String str, String str2, int i, String str3, String str4, EventAnalyticsParams eventAnalyticsParams) {
        List of;
        Tiers tiers = new Tiers();
        tiers.a("ticket_tier_id", str);
        GraphQlCallInput graphQlCallInput = tiers;
        graphQlCallInput.a("quantity", Integer.valueOf(i));
        graphQlCallInput = graphQlCallInput;
        EventPurchaseTicketsInputData eventPurchaseTicketsInputData = new EventPurchaseTicketsInputData();
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(eventAnalyticsParams.d);
        eventActionHistory.a("mechanism", ActionMechanism.PERMALINK.toString());
        String b = this.f19138c.b(this.f19136a);
        if (b != null) {
            eventActionHistory.a("extra_data", new JSONObject(ImmutableBiMap.b("impression_id", b)).toString());
        }
        if (eventAnalyticsParams.c == null) {
            of = ImmutableList.of(eventActionHistory);
        } else {
            EventActionHistory eventActionHistory2 = new EventActionHistory();
            eventActionHistory2.a(eventAnalyticsParams.c);
            of = ImmutableList.of(eventActionHistory2, eventActionHistory);
        }
        EventPurchaseTicketsInputData.Context context = new EventPurchaseTicketsInputData.Context();
        context.a("event_action_history", of);
        eventPurchaseTicketsInputData.a("context", context);
        GraphQlCallInput graphQlCallInput2 = eventPurchaseTicketsInputData;
        graphQlCallInput2.a("credential_id", str2);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("customer_email", str4);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("customer_name", str3);
        graphQlCallInput2 = graphQlCallInput2;
        graphQlCallInput2.a("tiers", ImmutableList.of(graphQlCallInput));
        graphQlCallInput = graphQlCallInput2;
        if (eventAnalyticsParams.f != null) {
            graphQlCallInput.a("tracking", ImmutableList.of(eventAnalyticsParams.f));
        }
        GraphQlQueryString eventPurchaseTicketMutationString = new EventPurchaseTicketMutationString();
        eventPurchaseTicketMutationString.a("input", graphQlCallInput);
        return GraphQLQueryExecutor.a(this.f19137b.a(GraphQLRequest.a(eventPurchaseTicketMutationString)));
    }
}
