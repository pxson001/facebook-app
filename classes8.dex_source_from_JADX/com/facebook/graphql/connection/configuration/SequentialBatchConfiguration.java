package com.facebook.graphql.connection.configuration;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.ConnectionFetcherState;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.cursor.database.SortKeyHelper;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLBatchRequest.EndpointScheduler;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

/* compiled from: white_place */
public class SequentialBatchConfiguration implements BatchConfiguration {
    public final Configuration f247a;
    public final String f248b;
    public final Configuration f249c;
    public final long f250d;
    private final String f251e;

    /* compiled from: white_place */
    public abstract class StreamingConfiguration extends Configuration {
        public abstract GraphQLRequest m225a(GraphQLRefParam graphQLRefParam);
    }

    public SequentialBatchConfiguration(Configuration configuration, Configuration configuration2, long j) {
        this(configuration, null, configuration2, j);
    }

    public SequentialBatchConfiguration(Configuration configuration, String str, StreamingConfiguration streamingConfiguration, long j) {
        this(configuration, str, (Configuration) streamingConfiguration, j);
    }

    private SequentialBatchConfiguration(Configuration configuration, String str, Configuration configuration2, long j) {
        this.f247a = configuration;
        this.f248b = str;
        this.f249c = configuration2;
        this.f250d = j;
        this.f251e = StringFormatUtil.formatStrLocaleSafe("SequentialBatchConfiguration:%s:%s", this.f247a.mo20a(), this.f249c.mo20a());
    }

    public final long mo11a() {
        return this.f250d;
    }

    public final int mo13b() {
        return 1;
    }

    public final GraphQLBatchRequest mo12a(QuickPerformanceLogger quickPerformanceLogger, ConnectionFetcherState connectionFetcherState, Executor executor, TailFetchLocation tailFetchLocation) {
        if (tailFetchLocation.f261b == null) {
            return m227b(quickPerformanceLogger, connectionFetcherState, executor, tailFetchLocation);
        }
        return m228c(quickPerformanceLogger, connectionFetcherState, executor, tailFetchLocation);
    }

    private GraphQLBatchRequest m227b(QuickPerformanceLogger quickPerformanceLogger, ConnectionFetcherState connectionFetcherState, Executor executor, TailFetchLocation tailFetchLocation) {
        boolean z;
        boolean z2;
        GraphQLRequest a = ConfigurationLoggingHelper.m216a(quickPerformanceLogger, this.f247a, tailFetchLocation);
        if (a.a == GraphQLCachePolicy.c) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest(this.f251e);
        graphQLBatchRequest.j = EndpointScheduler.PHASED;
        if (this.f248b == null || !(this.f249c instanceof StreamingConfiguration)) {
            z2 = false;
        } else {
            z2 = true;
        }
        final TailFetchLocation tailFetchLocation2 = tailFetchLocation;
        final QuickPerformanceLogger quickPerformanceLogger2 = quickPerformanceLogger;
        final ConnectionFetcherState connectionFetcherState2 = connectionFetcherState;
        graphQLBatchRequest.a(a).a(executor).a(new RequestObserver<GraphQLResult>(this) {
            final /* synthetic */ SequentialBatchConfiguration f240e;
            private TailFetchLocation f241f = ((TailFetchLocation) Preconditions.checkNotNull(tailFetchLocation2));

            public final void m220a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null) {
                    BLog.b(SequentialBatchConfiguration.class, "Null response from network");
                    return;
                }
                RowIterator a = ConfigurationLoggingHelper.m215a(quickPerformanceLogger2, this.f240e.f247a, this.f241f, graphQLResult);
                this.f241f = (TailFetchLocation) Preconditions.checkNotNull(a.mo14d());
                connectionFetcherState2.m186a(a);
            }

            public final void m221a(Throwable th) {
                connectionFetcherState2.m187a(th);
                m219a();
            }

            public final void m219a() {
                if (!z2) {
                    connectionFetcherState2.m188b();
                }
            }
        });
        if (z2) {
            m226a(quickPerformanceLogger, connectionFetcherState, executor, new TailFetchLocation(SortKeyHelper.a(tailFetchLocation.f260a, 256), null, true), graphQLBatchRequest, ConfigurationLoggingHelper.m217a(quickPerformanceLogger, (StreamingConfiguration) this.f249c, a.b(this.f248b)));
        }
        return graphQLBatchRequest;
    }

    private GraphQLBatchRequest m228c(QuickPerformanceLogger quickPerformanceLogger, ConnectionFetcherState connectionFetcherState, Executor executor, TailFetchLocation tailFetchLocation) {
        boolean z;
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest(this.f251e);
        GraphQLRequest a = ConfigurationLoggingHelper.m216a(quickPerformanceLogger, this.f249c, tailFetchLocation);
        if (a.a == GraphQLCachePolicy.c) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        m226a(quickPerformanceLogger, connectionFetcherState, executor, tailFetchLocation, graphQLBatchRequest, a);
        return graphQLBatchRequest;
    }

    private void m226a(final QuickPerformanceLogger quickPerformanceLogger, final ConnectionFetcherState connectionFetcherState, Executor executor, final TailFetchLocation tailFetchLocation, GraphQLBatchRequest graphQLBatchRequest, GraphQLRequest graphQLRequest) {
        graphQLBatchRequest.a(graphQLRequest).b(executor).a(new RequestObserver<GraphQLResult>(this) {
            final /* synthetic */ SequentialBatchConfiguration f245d;
            private TailFetchLocation f246e = ((TailFetchLocation) Preconditions.checkNotNull(tailFetchLocation));

            public final void m223a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null) {
                    BLog.b(SequentialBatchConfiguration.class, "Null response from network");
                    return;
                }
                RowIterator a = ConfigurationLoggingHelper.m215a(quickPerformanceLogger, this.f245d.f249c, this.f246e, graphQLResult);
                this.f246e = (TailFetchLocation) Preconditions.checkNotNull(a.mo14d());
                connectionFetcherState.m186a(a);
            }

            public final void m224a(Throwable th) {
                connectionFetcherState.m187a(th);
                m222a();
            }

            public final void m222a() {
                connectionFetcherState.m188b();
            }
        });
    }
}
