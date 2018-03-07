package com.facebook.graphql.connection.configuration;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.ConnectionFetcherState;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

/* compiled from: west_longitude */
public class SingleBatchConfiguration implements BatchConfiguration {
    @VisibleForTesting
    public final Configuration f257a;
    @VisibleForTesting
    public final long f258b;
    private final String f259c;

    public SingleBatchConfiguration(Configuration configuration, long j) {
        this.f259c = StringFormatUtil.formatStrLocaleSafe("SingleBatchConfiguration:%s", configuration.mo20a());
        this.f257a = configuration;
        boolean z = j == 0 || j > 3600;
        Preconditions.checkArgument(z);
        this.f258b = j;
    }

    public final long mo11a() {
        return this.f258b;
    }

    public final int mo13b() {
        return 1;
    }

    public final GraphQLBatchRequest mo12a(final QuickPerformanceLogger quickPerformanceLogger, final ConnectionFetcherState connectionFetcherState, Executor executor, final TailFetchLocation tailFetchLocation) {
        boolean z;
        GraphQLRequest a = ConfigurationLoggingHelper.m216a(quickPerformanceLogger, this.f257a, tailFetchLocation);
        if (a.a == GraphQLCachePolicy.c) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest(this.f259c);
        graphQLBatchRequest.a(a).b(executor).a(new RequestObserver<GraphQLResult>(this) {
            final /* synthetic */ SingleBatchConfiguration f255d;
            private TailFetchLocation f256e = ((TailFetchLocation) Preconditions.checkNotNull(tailFetchLocation));

            public final void m233a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null) {
                    BLog.b(SingleBatchConfiguration.class, "Null response from network");
                    return;
                }
                RowIterator a = ConfigurationLoggingHelper.m215a(quickPerformanceLogger, this.f255d.f257a, this.f256e, graphQLResult);
                this.f256e = (TailFetchLocation) Preconditions.checkNotNull(a.mo14d());
                connectionFetcherState.m186a(a);
            }

            public final void m234a(Throwable th) {
                connectionFetcherState.m187a(th);
                m232a();
            }

            public final void m232a() {
                connectionFetcherState.m188b();
            }
        });
        return graphQLBatchRequest;
    }
}
