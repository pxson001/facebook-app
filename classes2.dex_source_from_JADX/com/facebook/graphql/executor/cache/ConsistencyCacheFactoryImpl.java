package com.facebook.graphql.executor.cache;

import com.facebook.graphql.executor.cache.ConsistencyConfigImpl.LazyHolder;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: saved_video_dummy_autoplay */
public class ConsistencyCacheFactoryImpl {
    private final GraphQLDiskCache f6103a;
    private final ConsistencyConfigImpl f6104b;
    private final QeAccessor f6105c;
    private final QuickPerformanceLogger f6106d;

    public static ConsistencyCacheFactoryImpl m10244b(InjectorLike injectorLike) {
        return new ConsistencyCacheFactoryImpl(GraphQLDiskCacheImpl.m10254a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike));
    }

    @Inject
    public ConsistencyCacheFactoryImpl(GraphQLDiskCache graphQLDiskCache, QeAccessor qeAccessor, QuickPerformanceLogger quickPerformanceLogger) {
        this(graphQLDiskCache, null, qeAccessor, quickPerformanceLogger);
    }

    @VisibleForTesting
    private ConsistencyCacheFactoryImpl(GraphQLDiskCache graphQLDiskCache, @Nullable ConsistencyConfigImpl consistencyConfigImpl, QeAccessor qeAccessor, QuickPerformanceLogger quickPerformanceLogger) {
        this.f6103a = graphQLDiskCache;
        this.f6104b = consistencyConfigImpl;
        this.f6105c = qeAccessor;
        this.f6106d = quickPerformanceLogger;
    }

    public static ConsistencyCacheFactoryImpl m10243a(InjectorLike injectorLike) {
        return m10244b(injectorLike);
    }

    public final ConsistencyMemoryCache m10246a(Collection collection) {
        return new GraphQLConsistencyMemoryCache(this.f6104b == null ? LazyHolder.f12473a : this.f6104b, this.f6103a, this.f6106d, this.f6105c, collection);
    }

    public final ConsistencyMemoryCache m10245a() {
        return new GraphQLConsistencyMemoryCache(this.f6104b == null ? LazyHolder.f12473a : this.f6104b, this.f6103a, this.f6106d, this.f6105c);
    }
}
