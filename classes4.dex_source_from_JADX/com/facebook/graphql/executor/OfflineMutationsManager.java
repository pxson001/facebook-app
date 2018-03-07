package com.facebook.graphql.executor;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.init.INeedInit;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLWriteLock;
import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.ConsistencyCacheFactory;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.executor.iface.CustomMutationVisitorFactory;
import com.facebook.graphql.executor.iface.STATICDI_MULTIBIND_PROVIDER$CustomMutationVisitorFactory;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.offlinemode.common.OfflineModeHelper;
import com.facebook.offlinemode.common.PendingRequest;
import com.facebook.offlinemode.db.OfflineModeDbHandler;
import com.facebook.offlinemode.db.PendingGraphQlMutationRequest;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: malware_scan_finished */
public class OfflineMutationsManager implements INeedInit {
    public static final Class f8383a = OfflineMutationsManager.class;
    private static volatile OfflineMutationsManager f8384k;
    private final OfflineModeDbHandler f8385b;
    private final ConsistencyCacheFactoryImpl f8386c;
    private final GraphQLQueryScheduler f8387d;
    private final OfflineModeHelper f8388e;
    public final Set<CustomMutationVisitorFactory> f8389f;
    private final AbstractFbErrorReporter f8390g;
    private final DefaultAndroidThreadUtil f8391h;
    private volatile boolean f8392i = false;
    private final Map<PendingGraphQlMutationRequest, GraphQLWriteLock> f8393j = Maps.c();

    public static com.facebook.graphql.executor.OfflineMutationsManager m8657a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8384k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.executor.OfflineMutationsManager.class;
        monitor-enter(r1);
        r0 = f8384k;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8661b(r0);	 Catch:{ all -> 0x0035 }
        f8384k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8384k;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.OfflineMutationsManager.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.OfflineMutationsManager");
    }

    private static OfflineMutationsManager m8661b(InjectorLike injectorLike) {
        return new OfflineMutationsManager(OfflineModeDbHandler.a(injectorLike), ConsistencyCacheFactoryImpl.b(injectorLike), GraphQLQueryScheduler.a(injectorLike), OfflineModeHelper.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$CustomMutationVisitorFactory(injectorLike)), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public OfflineMutationsManager(OfflineModeDbHandler offlineModeDbHandler, ConsistencyCacheFactory consistencyCacheFactory, GraphQLQueryScheduler graphQLQueryScheduler, OfflineModeHelper offlineModeHelper, Set<CustomMutationVisitorFactory> set, FbErrorReporter fbErrorReporter, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f8385b = offlineModeDbHandler;
        this.f8386c = consistencyCacheFactory;
        this.f8387d = graphQLQueryScheduler;
        this.f8388e = offlineModeHelper;
        this.f8389f = set;
        this.f8390g = fbErrorReporter;
        this.f8391h = defaultAndroidThreadUtil;
    }

    public void init() {
        if (!this.f8392i) {
            if (this.f8391h.c()) {
                this.f8390g.a("offline", f8383a.getSimpleName() + " used on UI thread before initialized");
                return;
            }
            synchronized (this) {
                if (!this.f8392i) {
                    m8659a();
                }
            }
        }
    }

    private void m8659a() {
        if (this.f8388e.a()) {
            ImmutableList a = this.f8385b.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                PendingRequest pendingRequest = (PendingRequest) a.get(i);
                if (pendingRequest instanceof PendingGraphQlMutationRequest) {
                    PendingGraphQlMutationRequest pendingGraphQlMutationRequest = (PendingGraphQlMutationRequest) pendingRequest;
                    if (!this.f8393j.containsKey(pendingGraphQlMutationRequest)) {
                        GraphQLWriteLock b = m8660b(pendingGraphQlMutationRequest);
                        if (b != null) {
                            this.f8393j.put(pendingGraphQlMutationRequest, b);
                            b.a();
                        }
                    }
                }
            }
            this.f8392i = true;
            return;
        }
        this.f8392i = true;
    }

    @Nullable
    private GraphQLWriteLock m8660b(PendingGraphQlMutationRequest pendingGraphQlMutationRequest) {
        try {
            return this.f8387d.a(m8664a(pendingGraphQlMutationRequest.m12432d()));
        } catch (Throwable e) {
            this.f8390g.a("offline", e.getMessage(), e);
            return null;
        }
    }

    public final void m8666a(PendingGraphQlMutationRequest pendingGraphQlMutationRequest, GraphQLWriteLock graphQLWriteLock) {
        init();
        this.f8393j.put(pendingGraphQlMutationRequest, graphQLWriteLock);
        this.f8385b.a(pendingGraphQlMutationRequest);
        graphQLWriteLock.a();
        this.f8388e.a(pendingGraphQlMutationRequest);
    }

    public final GraphQLWriteLock m8662a(PendingGraphQlMutationRequest pendingGraphQlMutationRequest) {
        init();
        return (GraphQLWriteLock) this.f8393j.get(pendingGraphQlMutationRequest);
    }

    @Nullable
    public final CacheVisitor m8664a(MutationRequest mutationRequest) {
        GraphQLVisitableModel graphQLVisitableModel = mutationRequest.f11810c;
        if (graphQLVisitableModel != null) {
            return m8658a(mutationRequest.f11809b, graphQLVisitableModel, null);
        }
        return null;
    }

    @Nullable
    public final CacheVisitor m8663a(LegacyMutation legacyMutation) {
        GraphQLVisitableModel b = legacyMutation.b();
        if (b != null) {
            return m8658a(null, b, null);
        }
        return null;
    }

    public final CacheVisitor m8665a(@Nullable MutationRequest mutationRequest, GraphQLVisitableModel graphQLVisitableModel, @Nullable ConsistencyMemoryCache consistencyMemoryCache) {
        ImmutableSet immutableSet;
        if (mutationRequest != null) {
            immutableSet = mutationRequest.f11809b;
        } else {
            immutableSet = null;
        }
        return (mutationRequest == null || mutationRequest.f11810c == null || !mutationRequest.f11811d) ? m8658a(immutableSet, graphQLVisitableModel, consistencyMemoryCache) : m8658a(immutableSet, mutationRequest.f11810c, consistencyMemoryCache);
    }

    private CacheVisitor m8658a(@Nullable ImmutableSet immutableSet, GraphQLVisitableModel graphQLVisitableModel, @Nullable ConsistencyMemoryCache consistencyMemoryCache) {
        CacheVisitor a;
        CompositeCacheVisitor compositeCacheVisitor;
        Preconditions.checkNotNull(graphQLVisitableModel);
        if (consistencyMemoryCache == null) {
            consistencyMemoryCache = this.f8386c.a();
        }
        Class cls = graphQLVisitableModel.getClass();
        for (CustomMutationVisitorFactory customMutationVisitorFactory : this.f8389f) {
            if (customMutationVisitorFactory.mo883a().equals(cls)) {
                a = customMutationVisitorFactory.mo882a(graphQLVisitableModel);
                break;
            }
        }
        a = null;
        consistencyMemoryCache.mo871a(graphQLVisitableModel);
        CacheVisitor d = consistencyMemoryCache.mo878d();
        if (a != null) {
            compositeCacheVisitor = new CompositeCacheVisitor(new CacheVisitor[]{a, d});
        } else {
            compositeCacheVisitor = d;
        }
        CacheVisitor cacheVisitor = compositeCacheVisitor;
        if (immutableSet == null || immutableSet.isEmpty()) {
            return cacheVisitor;
        }
        return new DelegatingCacheVisitor(cacheVisitor, Sets.c(cacheVisitor.mo268a(), immutableSet));
    }
}
