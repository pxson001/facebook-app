package com.facebook.search.protocol;

import android.content.Context;
import android.os.Handler;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.protocol.sports.FetchSportMatchDataGraphQL.FetchSportMatchDataGraphQLString;
import com.facebook.search.results.rows.sections.sports.SportsDetailPartDefinition.C26333;
import com.facebook.search.results.rows.sections.sports.SportsDetailPartDefinition.C26344;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@ContextScoped
/* compiled from: no_context_token */
public class BatchedSearchLoader {
    private static BatchedSearchLoader f7867g;
    private static final Object f7868h = new Object();
    private final GraphQLQueryExecutor f7869a;
    public final Handler f7870b;
    @ForUiThread
    private final Executor f7871c;
    public final HashMap<String, Subscription> f7872d = new HashMap();
    public final int f7873e;
    public final Runnable f7874f = new C08991(this);

    /* compiled from: no_context_token */
    class C08991 implements Runnable {
        final /* synthetic */ BatchedSearchLoader f7862a;

        C08991(BatchedSearchLoader batchedSearchLoader) {
            this.f7862a = batchedSearchLoader;
        }

        public void run() {
            this.f7862a.m8263c();
            HandlerDetour.b(this.f7862a.f7870b, this.f7862a.f7874f, (long) (this.f7862a.f7873e * 1000), 1032765961);
        }
    }

    /* compiled from: no_context_token */
    class Subscription {
        public C26333 f7865a;
        public C26344 f7866b;

        public Subscription(C26333 c26333, C26344 c26344) {
            this.f7865a = c26333;
            this.f7866b = c26344;
        }
    }

    private static BatchedSearchLoader m8260b(InjectorLike injectorLike) {
        return new BatchedSearchLoader(GraphQLQueryExecutor.a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BatchedSearchLoader(GraphQLQueryExecutor graphQLQueryExecutor, Handler handler, Executor executor) {
        this.f7869a = graphQLQueryExecutor;
        this.f7870b = handler;
        this.f7873e = 30;
        this.f7871c = executor;
    }

    public static BatchedSearchLoader m8259a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BatchedSearchLoader b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7868h) {
                BatchedSearchLoader batchedSearchLoader;
                if (a2 != null) {
                    batchedSearchLoader = (BatchedSearchLoader) a2.a(f7868h);
                } else {
                    batchedSearchLoader = f7867g;
                }
                if (batchedSearchLoader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8260b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7868h, b3);
                        } else {
                            f7867g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = batchedSearchLoader;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m8262b() {
        this.f7870b.removeCallbacksAndMessages(null);
    }

    public final String m8261a(C26333 c26333, C26344 c26344) {
        String uuid = UUID.randomUUID().toString();
        this.f7872d.put(uuid, new Subscription(c26333, c26344));
        return uuid;
    }

    public final void m8263c() {
        GraphQLBatchRequest graphQLBatchRequest = null;
        for (final Subscription subscription : this.f7872d.values()) {
            if (graphQLBatchRequest == null) {
                graphQLBatchRequest = new GraphQLBatchRequest("BatchedSearchLoader");
            }
            C26333 c26333 = subscription.f7865a;
            GraphQlQueryString fetchSportMatchDataGraphQLString = new FetchSportMatchDataGraphQLString();
            fetchSportMatchDataGraphQLString.a("live_page_id", c26333.f25030a.f23530b);
            fetchSportMatchDataGraphQLString.a("facts_after_cursor", c26333.f25030a.f23538j);
            fetchSportMatchDataGraphQLString.a("facts_count", Integer.valueOf(10));
            GraphQLRequest a = GraphQLRequest.a(fetchSportMatchDataGraphQLString);
            a.a(GraphQLCachePolicy.c);
            if (c26333.f25031b.f25043g.a(ExperimentsForSearchAbTestModule.aP, false)) {
                a.q = null;
            }
            graphQLBatchRequest.a(a).a(this.f7871c).a(new RequestObserver(this) {
                final /* synthetic */ BatchedSearchLoader f7864b;

                public final void m8256a() {
                }

                public final void m8258a(Throwable th) {
                    subscription.f7866b.f25034c.f25038b.a("SportsDetailPartDefinition.BatchedSearchLoader.onError: ", th == null ? "" : th.toString());
                }

                public final void m8257a(Object obj) {
                    subscription.f7866b.m28361a(obj);
                }
            });
        }
        if (graphQLBatchRequest != null) {
            this.f7869a.a(graphQLBatchRequest);
        }
    }
}
