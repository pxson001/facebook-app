package com.facebook.events.tickets;

import android.content.Context;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsGraphQL;
import com.facebook.events.graphql.EventsGraphQL.EventTicketOrderStatusSubscriptionString;
import com.facebook.events.graphql.EventsGraphQLModels.EventPurchaseTicketMutationResultModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventPurchaseTicketMutationResultModel.EventTicketsModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrderStatusSubscriptionModel;
import com.facebook.events.graphql.EventsMutations.EventPurchaseTicketMutationAsyncString;
import com.facebook.events.graphql.EventsMutationsModels.EventPurchaseTicketMutationAsyncModel;
import com.facebook.events.tickets.modal.EventBuyTicketController;
import com.facebook.events.tickets.modal.EventBuyTicketsModel.Mutator;
import com.facebook.events.tickets.modal.EventBuyTicketsModel.State;
import com.facebook.events.tickets.modal.fragments.EventTicketsCheckoutFragment;
import com.facebook.events.tickets.modal.fragments.EventTicketsCheckoutFragment.C27333;
import com.facebook.graphql.calls.EventPurchaseTicketsAsyncInputData;
import com.facebook.graphql.calls.EventPurchaseTicketsAsyncInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventPurchaseTicketsAsyncInputData.Tiers;
import com.facebook.graphql.calls.EventTicketOrderPurchaseStatusChangeInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.enums.GraphQLEventTicketOrderStatus;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.LinkableTextWithEntitiesModel;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionConnectorException;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: attemptNumber */
public class EventBuyTicketsPollingGraphQLMutator {
    public final Context f19156a;
    public final GraphQLQueryExecutor f19157b;
    public final ImpressionManager f19158c;
    private final TasksManager<String> f19159d;
    public final Executor f19160e;
    private final GraphQLSubscriptionConnector f19161f;
    @Nullable
    private GraphQLSubscriptionHandle f19162g;

    /* compiled from: attemptNumber */
    /* synthetic */ class C27164 {
        static final /* synthetic */ int[] f19155a = new int[GraphQLEventTicketOrderStatus.values().length];

        static {
            try {
                f19155a[GraphQLEventTicketOrderStatus.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19155a[GraphQLEventTicketOrderStatus.TIMED_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19155a[GraphQLEventTicketOrderStatus.REFUNDED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19155a[GraphQLEventTicketOrderStatus.PURCHASED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Inject
    public EventBuyTicketsPollingGraphQLMutator(Context context, GraphQLQueryExecutor graphQLQueryExecutor, ImpressionManager impressionManager, TasksManager tasksManager, Executor executor, GraphQLSubscriptionConnector graphQLSubscriptionConnector) {
        this.f19156a = context;
        this.f19157b = graphQLQueryExecutor;
        this.f19158c = impressionManager;
        this.f19159d = tasksManager;
        this.f19160e = executor;
        this.f19161f = graphQLSubscriptionConnector;
    }

    public final void m19336a(String str, String str2, int i, String str3, String str4, EventAnalyticsParams eventAnalyticsParams, C27333 c27333) {
        final String str5 = str;
        final int i2 = i;
        final EventAnalyticsParams eventAnalyticsParams2 = eventAnalyticsParams;
        final String str6 = str2;
        final String str7 = str4;
        final String str8 = str3;
        final C27333 c273332 = c27333;
        this.f19159d.a("event_ticket_purchase_async", new Callable<ListenableFuture<EventPurchaseTicketMutationAsyncModel>>(this) {
            final /* synthetic */ EventBuyTicketsPollingGraphQLMutator f19146g;

            public Object call() {
                List of;
                Tiers tiers = new Tiers();
                tiers.a("ticket_tier_id", str5);
                GraphQlCallInput graphQlCallInput = tiers;
                graphQlCallInput.a("quantity", Integer.valueOf(i2));
                graphQlCallInput = graphQlCallInput;
                EventPurchaseTicketsAsyncInputData eventPurchaseTicketsAsyncInputData = new EventPurchaseTicketsAsyncInputData();
                EventBuyTicketsPollingGraphQLMutator eventBuyTicketsPollingGraphQLMutator = this.f19146g;
                EventAnalyticsParams eventAnalyticsParams = eventAnalyticsParams2;
                EventActionHistory eventActionHistory = new EventActionHistory();
                eventActionHistory.a(eventAnalyticsParams.d);
                eventActionHistory.a("mechanism", ActionMechanism.PERMALINK.toString());
                String b = eventBuyTicketsPollingGraphQLMutator.f19158c.b(eventBuyTicketsPollingGraphQLMutator.f19156a);
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
                EventPurchaseTicketsAsyncInputData.Context context = new EventPurchaseTicketsAsyncInputData.Context();
                context.a("event_action_history", of);
                eventPurchaseTicketsAsyncInputData.a("context", context);
                GraphQlCallInput graphQlCallInput2 = eventPurchaseTicketsAsyncInputData;
                graphQlCallInput2.a("credential_id", str6);
                graphQlCallInput2 = graphQlCallInput2;
                graphQlCallInput2.a("customer_email", str7);
                graphQlCallInput2 = graphQlCallInput2;
                graphQlCallInput2.a("customer_name", str8);
                graphQlCallInput2 = graphQlCallInput2;
                graphQlCallInput2.a("tiers", ImmutableList.of(graphQlCallInput));
                graphQlCallInput = graphQlCallInput2;
                if (eventAnalyticsParams2.f != null) {
                    graphQlCallInput.a("tracking", ImmutableList.of(eventAnalyticsParams2.f));
                }
                GraphQlQueryString eventPurchaseTicketMutationAsyncString = new EventPurchaseTicketMutationAsyncString();
                eventPurchaseTicketMutationAsyncString.a("input", graphQlCallInput);
                return GraphQLQueryExecutor.a(this.f19146g.f19157b.a(GraphQLRequest.a(eventPurchaseTicketMutationAsyncString)));
            }
        }, new AbstractDisposableFutureCallback<EventPurchaseTicketMutationAsyncModel>(this) {
            final /* synthetic */ EventBuyTicketsPollingGraphQLMutator f19148b;

            protected final void m19329a(Object obj) {
                EventPurchaseTicketMutationAsyncModel eventPurchaseTicketMutationAsyncModel = (EventPurchaseTicketMutationAsyncModel) obj;
                if (eventPurchaseTicketMutationAsyncModel == null || eventPurchaseTicketMutationAsyncModel.a() == null) {
                    C27333 c27333 = c273332;
                    NullPointerException nullPointerException = new NullPointerException("Null result from GraphQL");
                    c27333.m19464a();
                    return;
                }
                GraphQLEventTicketOrderStatus n = eventPurchaseTicketMutationAsyncModel.a() != null ? eventPurchaseTicketMutationAsyncModel.a().n() : GraphQLEventTicketOrderStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                EventBuyTicketsPollingGraphQLMutator.m19333a(this.f19148b, eventPurchaseTicketMutationAsyncModel.a(), c273332);
                if (n == GraphQLEventTicketOrderStatus.RESERVED) {
                    this.f19148b.m19335a(eventPurchaseTicketMutationAsyncModel.a().l(), c273332);
                }
            }

            protected final void m19330a(Throwable th) {
                if (th instanceof GraphQLException) {
                    GraphQLException graphQLException = (GraphQLException) th;
                    C27333 c27333 = c273332;
                    if (graphQLException.error == null || Strings.isNullOrEmpty(graphQLException.error.c())) {
                        c27333.m19464a();
                        return;
                    } else {
                        c27333.m19465a(graphQLException.error.c());
                        return;
                    }
                }
                c273332.m19464a();
            }
        });
    }

    public final void m19335a(String str, final C27333 c27333) {
        if (this.f19162g == null) {
            EventTicketOrderStatusSubscriptionString T = EventsGraphQL.T();
            T.a("input", new EventTicketOrderPurchaseStatusChangeInputData().a(str));
            T.a("should_fetch_ticket_tiers", Boolean.valueOf(true));
            try {
                this.f19162g = this.f19161f.a(T, new AbstractDisposableFutureCallback<EventTicketOrderStatusSubscriptionModel>(this) {
                    final /* synthetic */ EventBuyTicketsPollingGraphQLMutator f19154b;

                    protected final void m19331a(Object obj) {
                        final EventTicketOrderStatusSubscriptionModel eventTicketOrderStatusSubscriptionModel = (EventTicketOrderStatusSubscriptionModel) obj;
                        ExecutorDetour.a(this.f19154b.f19160e, new Runnable(this) {
                            final /* synthetic */ C27153 f19150b;

                            public void run() {
                                EventBuyTicketsPollingGraphQLMutator.m19333a(this.f19150b.f19154b, eventTicketOrderStatusSubscriptionModel.a(), c27333);
                            }
                        }, -1294614374);
                    }

                    protected final void m19332a(final Throwable th) {
                        ExecutorDetour.a(this.f19154b.f19160e, new Runnable(this) {
                            final /* synthetic */ C27153 f19152b;

                            public void run() {
                                c27333.m19464a();
                            }
                        }, -1853379983);
                    }
                });
            } catch (GraphQLSubscriptionConnectorException e) {
                c27333.m19464a();
            }
        }
    }

    public static void m19333a(EventBuyTicketsPollingGraphQLMutator eventBuyTicketsPollingGraphQLMutator, EventPurchaseTicketMutationResultModel eventPurchaseTicketMutationResultModel, C27333 c27333) {
        if (eventPurchaseTicketMutationResultModel != null && eventPurchaseTicketMutationResultModel.n() != null) {
            switch (C27164.f19155a[eventPurchaseTicketMutationResultModel.n().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    eventBuyTicketsPollingGraphQLMutator.m19334a();
                    if (eventPurchaseTicketMutationResultModel.m() == null || Strings.isNullOrEmpty(eventPurchaseTicketMutationResultModel.m().a())) {
                        Throwable th = new Throwable(StringFormatUtil.formatStrLocaleSafe("Ticket Purchase Failed : %s", eventPurchaseTicketMutationResultModel.n().name()));
                        c27333.m19464a();
                        return;
                    }
                    c27333.m19465a(eventPurchaseTicketMutationResultModel.m().a());
                    return;
                case 4:
                    boolean z;
                    eventBuyTicketsPollingGraphQLMutator.m19334a();
                    LinkableTextWithEntitiesModel m = eventPurchaseTicketMutationResultModel.m();
                    Mutator a = c27333.f19299a.au.m19413a();
                    a.mo864a(State.BOUGHT);
                    if (eventPurchaseTicketMutationResultModel.j() != null) {
                        a.mo873f(eventPurchaseTicketMutationResultModel.j().j());
                        a.mo874g(eventPurchaseTicketMutationResultModel.j().a());
                    }
                    a.mo865a(m);
                    a.mo872e(eventPurchaseTicketMutationResultModel.l());
                    if (eventPurchaseTicketMutationResultModel.k() == null) {
                        z = false;
                    } else {
                        NodesModel nodesModel = (NodesModel) Iterables.a(eventPurchaseTicketMutationResultModel.k().a(), null);
                        z = (nodesModel == null || nodesModel.a() == null || nodesModel.a().j() == null) ? false : true;
                    }
                    a.mo867a(z);
                    c27333.f19299a.au = a.mo868a();
                    EventTicketsCheckoutFragment.ar(c27333.f19299a);
                    ((EventBuyTicketController) c27333.f19299a.a(EventBuyTicketController.class)).mo861b(c27333.f19299a.au);
                    return;
                default:
                    if (eventPurchaseTicketMutationResultModel.m() != null && !Strings.isNullOrEmpty(eventPurchaseTicketMutationResultModel.m().a())) {
                        CharSequence a2 = eventPurchaseTicketMutationResultModel.m().a();
                        EventTicketsCheckoutFragment eventTicketsCheckoutFragment = c27333.f19299a;
                        if (eventTicketsCheckoutFragment.at != null) {
                            eventTicketsCheckoutFragment.at.a(a2);
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    }

    public final void m19334a() {
        if (this.f19162g != null) {
            this.f19161f.a(Sets.a(new GraphQLSubscriptionHandle[]{this.f19162g}));
        }
    }
}
