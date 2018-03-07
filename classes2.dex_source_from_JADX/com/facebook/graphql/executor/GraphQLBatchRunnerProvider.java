package com.facebook.graphql.executor;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.executor.iface.STATICDI_MULTIBIND_PROVIDER$ConsistentMemoryCache;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import java.util.concurrent.locks.ReadWriteLock;

/* compiled from: save_button */
public class GraphQLBatchRunnerProvider extends AbstractAssistedProvider<GraphQLBatchRunner> {
    public final GraphQLBatchRunner m10493a(ReadWriteLock readWriteLock, GraphQLBatchRequest graphQLBatchRequest, GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent, int i) {
        return new GraphQLBatchRunner(readWriteLock, graphQLBatchRequest, graphQLQueryAnalyticsEvent, i, IdBasedSingletonScopeProvider.m1810b(this, 2183), ConsistencyCacheFactoryImpl.m10243a((InjectorLike) this), GraphQLQueryScheduler.m10388a((InjectorLike) this), GenericGraphQLBatchMethod.m11699a((InjectorLike) this), SingleMethodRunnerImpl.m11724a((InjectorLike) this), DefaultCacheProcessorFactory.m10240a((InjectorLike) this), AnalyticsLoggerMethodAutoProvider.m3509a(this), FbErrorReporterImpl.m2317a((InjectorLike) this), KeyFactory.m10331a(this), STATICDI_MULTIBIND_PROVIDER$ConsistentMemoryCache.m10387a(this), QuickPerformanceLoggerMethodAutoProvider.m2859a(this));
    }
}
