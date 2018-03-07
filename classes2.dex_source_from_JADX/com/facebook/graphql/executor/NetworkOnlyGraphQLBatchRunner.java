package com.facebook.graphql.executor;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLResponseParser.GraphQLBatchResultCallback;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;

/* compiled from: requiresCharging */
public class NetworkOnlyGraphQLBatchRunner implements Runnable {
    private static final Class<?> f7221a = NetworkOnlyGraphQLBatchRunner.class;
    private final GenericGraphQLBatchMethod f7222b;
    private final AbstractSingleMethodRunner f7223c;
    public final GraphQLBatchRequest f7224d;
    public GraphQLQueryAnalyticsEvent f7225e;
    private final AnalyticsLogger f7226f;
    private final GraphQLBatchResultCallback f7227g = new C03101(this);

    /* compiled from: requiresCharging */
    class C03101 implements GraphQLBatchResultCallback {
        final /* synthetic */ NetworkOnlyGraphQLBatchRunner f7307a;

        C03101(NetworkOnlyGraphQLBatchRunner networkOnlyGraphQLBatchRunner) {
            this.f7307a = networkOnlyGraphQLBatchRunner;
        }

        public final void mo1651a(GraphQLResult graphQLResult, GraphQLRequest graphQLRequest) {
            this.f7307a.f7224d.m11218a(graphQLRequest, graphQLResult);
            this.f7307a.f7225e.mo1462a(graphQLRequest);
        }

        public final void mo1652a(Exception exception, GraphQLRequest graphQLRequest) {
            this.f7307a.f7225e.mo1463a(graphQLRequest, exception);
            this.f7307a.f7225e.mo1462a(graphQLRequest);
            this.f7307a.f7224d.m11219a(graphQLRequest, exception);
        }

        public final void mo1650a() {
            this.f7307a.f7224d.m11229f();
        }
    }

    @Inject
    public NetworkOnlyGraphQLBatchRunner(@Assisted GraphQLBatchRequest graphQLBatchRequest, @Assisted GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent, GenericGraphQLBatchMethod genericGraphQLBatchMethod, AbstractSingleMethodRunner abstractSingleMethodRunner, AnalyticsLogger analyticsLogger) {
        this.f7224d = graphQLBatchRequest;
        this.f7222b = genericGraphQLBatchMethod;
        this.f7223c = abstractSingleMethodRunner;
        this.f7225e = graphQLQueryAnalyticsEvent;
        this.f7226f = analyticsLogger;
        this.f7224d.f6474e = this.f7227g;
    }

    public final void run() {
        this.f7225e.mo1465a("dequeue");
        try {
            m11698a();
        } catch (Exception e) {
            BLog.a(f7221a, "Exception during graphql executor query", e);
            this.f7224d.m11221a((Throwable) e);
            this.f7225e.mo1464a(e);
        } finally {
            HoneyAnalyticsEvent a = this.f7225e.mo1460a();
            if (a != null) {
                this.f7226f.mo526a(a);
            }
            this.f7225e = GraphQLQueryAnalyticsEventPool.f6284a;
        }
    }

    private void m11698a() {
        TracerDetour.a("GraphQLBatchRunner.tryFetch", -1958343005);
        try {
            this.f7223c.m11744a(this.f7222b, this.f7224d, CallerContext.m9060a(getClass()));
            this.f7225e.mo1466a("network", "success");
            this.f7224d.m11229f();
        } finally {
            TracerDetour.a(1601389136);
        }
    }
}
