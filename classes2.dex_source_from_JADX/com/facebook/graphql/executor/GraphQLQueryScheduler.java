package com.facebook.graphql.executor;

import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLQueryExecutor.DataSource;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: saved_caret_nux_imp */
public class GraphQLQueryScheduler {
    static final GraphQLResult f6187a = new GraphQLResult(new Object(), DataFreshnessResult.NO_DATA, 0);
    private static volatile GraphQLQueryScheduler f6188l;
    @VisibleForTesting
    protected volatile long f6189b = 0;
    protected volatile long f6190c = 0;
    protected volatile long f6191d = 0;
    protected volatile long f6192e = 0;
    @VisibleForTesting
    protected final List<GraphQLRequestLock> f6193f = new CopyOnWriteArrayList();
    @VisibleForTesting
    protected final List<GraphQLRequestLock> f6194g = new CopyOnWriteArrayList();
    public final GraphQLQuerySubscriber f6195h;
    public final Lock f6196i = new ReentrantLock();
    public final LinkedList<GraphQLRequestLock> f6197j = new LinkedList();
    public final LinkedList<GraphQLRequestLock> f6198k = new LinkedList();

    /* compiled from: saved_caret_nux_imp */
    public class GraphQLRequestLock {
        private final long f14127a;
        protected volatile long f14128b;
        protected volatile long f14129c;
        protected volatile DataSource f14130d;
        protected boolean f14131e;
        public final GraphQLMutex f14132f;
        final /* synthetic */ GraphQLQueryScheduler f14133g;

        public GraphQLRequestLock(GraphQLQueryScheduler graphQLQueryScheduler, GraphQLReadMutex graphQLReadMutex) {
            this(graphQLQueryScheduler, graphQLReadMutex, false);
        }

        public GraphQLRequestLock(GraphQLQueryScheduler graphQLQueryScheduler, GraphQLMutex graphQLMutex, boolean z) {
            this.f14133g = graphQLQueryScheduler;
            this.f14128b = -1;
            this.f14129c = -1;
            this.f14130d = DataSource.NETWORK;
            this.f14131e = false;
            this.f14132f = graphQLMutex;
            if (z) {
                this.f14127a = -1;
                return;
            }
            synchronized (graphQLQueryScheduler.f6193f) {
                long j = graphQLQueryScheduler.f6192e + 1;
                graphQLQueryScheduler.f6192e = j;
                this.f14127a = j;
                graphQLQueryScheduler.f6193f.add(this);
            }
        }

        public GraphQLRequestLock mo3496a(DataSource dataSource) {
            this.f14130d = dataSource;
            return mo3087a();
        }

        private GraphQLRequestLock mo3087a() {
            synchronized (this.f14133g) {
                if (this.f14130d == DataSource.NETWORK) {
                    this.f14128b = this.f14133g.f6189b;
                } else if (this.f14130d == DataSource.MEMORY_CACHE) {
                    this.f14128b = this.f14133g.f6191d;
                } else {
                    this.f14128b = this.f14133g.f6190c;
                }
                for (GraphQLRequestLock graphQLRequestLock : this.f14133g.f6193f) {
                    if (graphQLRequestLock == this) {
                        return null;
                    } else if (m20445a(graphQLRequestLock.f14132f) && !graphQLRequestLock.f14132f.mo2717a(this)) {
                        return graphQLRequestLock;
                    }
                }
                return null;
            }
        }

        private boolean m20445a(GraphQLMutex graphQLMutex) {
            Iterator it = this.f14132f.mo2716a().iterator();
            while (it.hasNext()) {
                if (graphQLMutex.mo2716a().contains((String) it.next())) {
                    return true;
                }
            }
            return false;
        }

        public final GraphQLResult m20449a(GraphQLResult graphQLResult) {
            return m20450a(graphQLResult, null, -1, -1);
        }

        public final GraphQLResult m20450a(GraphQLResult graphQLResult, @Nullable QuickPerformanceLogger quickPerformanceLogger, int i, int i2) {
            int i3;
            int i4 = 0;
            if (graphQLResult != null && graphQLResult.f6200b) {
                this.f14132f.mo2714a(graphQLResult.m10402f());
            }
            this.f14133g.f6196i.lock();
            this.f14131e = true;
            synchronized (this.f14133g) {
                if (this.f14130d == DataSource.NETWORK) {
                    GraphQLQueryScheduler graphQLQueryScheduler = this.f14133g;
                    graphQLQueryScheduler.f6189b++;
                }
                this.f14129c = this.f14133g.f6189b;
                if (graphQLResult != null) {
                    int i5 = 0;
                    i3 = 0;
                    GraphQLResult graphQLResult2 = graphQLResult;
                    for (GraphQLRequestLock graphQLRequestLock : this.f14133g.f6194g) {
                        GraphQLResult graphQLResult3;
                        if (graphQLRequestLock.f14129c <= this.f14128b || !m20445a(graphQLRequestLock.f14132f)) {
                            i4 = i3;
                            graphQLResult3 = graphQLResult2;
                        } else {
                            graphQLResult2 = m20444a(graphQLResult2, graphQLRequestLock);
                            if (GraphQLQueryScheduler.m10392b(graphQLRequestLock)) {
                                i5++;
                            } else {
                                i4 = i3 + 1;
                                graphQLResult3 = graphQLResult2;
                            }
                        }
                        graphQLResult2 = graphQLResult3;
                        i3 = i4;
                    }
                    i4 = i5;
                    graphQLResult = graphQLResult2;
                } else {
                    i3 = 0;
                }
                if (this.f14130d == DataSource.NETWORK && !this.f14133g.f6194g.contains(this)) {
                    this.f14133g.f6194g.add(this);
                }
                this.f14133g.f6193f.remove(this);
                if (!this.f14133g.f6198k.contains(this)) {
                    this.f14133g.f6198k.add(this);
                }
                if (!this.f14133g.f6197j.contains(this)) {
                    this.f14133g.f6197j.add(this);
                }
                ObjectDetour.c(this.f14133g, 409645270);
            }
            int i6 = i3 + i4;
            GraphQLQueryScheduler.m10391b(quickPerformanceLogger, i, i2, (short) 153, "start_callback_count", i6);
            return graphQLResult;
        }

        private static <T> GraphQLResult<T> m20444a(GraphQLResult<T> graphQLResult, GraphQLRequestLock graphQLRequestLock) {
            boolean z = false;
            TracerDetour.a("GraphQLQueryScheduler.updateResultFromBlocker", 1934432440);
            try {
                Object d = graphQLResult.m10400d();
                GraphQLResult<T> a = graphQLRequestLock.f14132f.mo2715a((GraphQLResult) graphQLResult);
                if (a == GraphQLQueryScheduler.f6187a) {
                    DataFreshnessResult a2 = graphQLResult.m10404a();
                    if (a2 == DataFreshnessResult.FROM_CACHE_UP_TO_DATE || a2 == DataFreshnessResult.FROM_CACHE_STALE) {
                        z = true;
                    }
                    String str = "Unexpected blocker condition. Result model = %s, freshness = %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = d != null ? d.getClass().getName() : "NULL";
                    objArr[1] = a2.name();
                    Preconditions.checkState(z, str, objArr);
                    GraphQLResult b = graphQLRequestLock.f14132f.mo2718b(graphQLResult);
                    if (b != GraphQLQueryScheduler.f6187a) {
                        a = Builder.m21595a(b).m21596a(DataFreshnessResult.FROM_CACHE_STALE).m21600a();
                    } else {
                        a = Builder.m21595a((GraphQLResult) graphQLResult).m21596a(DataFreshnessResult.FROM_CACHE_STALE).m21600a();
                    }
                }
                TracerDetour.a(1161669445);
                return a;
            } catch (Throwable th) {
                TracerDetour.a(199254086);
            }
        }

        protected final GraphQLResult m20452b(GraphQLResult graphQLResult) {
            return m20446c(graphQLResult, null, -1, -1);
        }

        private GraphQLResult m20446c(GraphQLResult graphQLResult, @Nullable QuickPerformanceLogger quickPerformanceLogger, int i, int i2) {
            int i3;
            GraphQLResult graphQLResult2;
            GraphQLResult a;
            long j = -1;
            if (this.f14129c < this.f14133g.f6189b) {
                int i4 = 0;
                for (GraphQLRequestLock graphQLRequestLock : this.f14133g.f6194g) {
                    int i5;
                    if (graphQLRequestLock.f14129c <= this.f14128b || graphQLRequestLock.f14129c <= this.f14129c || graphQLRequestLock.f14129c <= graphQLResult.f6202d || (((graphQLRequestLock instanceof GraphQLWriteLock) && graphQLRequestLock.f14127a <= graphQLResult.f6201c) || !(this.f14129c == -1 || (graphQLRequestLock instanceof GraphQLWriteLock)))) {
                        i5 = i4;
                    } else {
                        if (m20445a(graphQLRequestLock.f14132f)) {
                            graphQLResult = m20444a(graphQLResult, graphQLRequestLock);
                            i4++;
                        }
                        j = graphQLRequestLock.f14129c;
                        i5 = i4;
                    }
                    i4 = i5;
                }
                i3 = i4;
                graphQLResult2 = graphQLResult;
            } else {
                i3 = 0;
                graphQLResult2 = graphQLResult;
            }
            if (j != -1) {
                Builder a2 = Builder.m21595a(graphQLResult2);
                a2.f15066h = j;
                a = a2.m21600a();
            } else {
                a = graphQLResult2;
            }
            GraphQLQueryScheduler.m10391b(quickPerformanceLogger, i, i2, (short) 154, "apply_later_finished_count", i3);
            return a;
        }

        public final GraphQLResult m20455c(GraphQLResult graphQLResult) {
            return m20453b(graphQLResult, null, -1, -1);
        }

        public final GraphQLResult m20453b(GraphQLResult graphQLResult, @Nullable QuickPerformanceLogger quickPerformanceLogger, int i, int i2) {
            GraphQLResult a;
            int i3 = 0;
            BaseResult c = m20446c(graphQLResult, quickPerformanceLogger, i, i2);
            long j = -1;
            for (GraphQLRequestLock graphQLRequestLock : this.f14133g.f6193f) {
                BaseResult baseResult;
                long j2;
                if ((graphQLRequestLock instanceof GraphQLWriteLock) && graphQLRequestLock.f14127a > c.f6201c) {
                    if (m20445a(graphQLRequestLock.f14132f)) {
                        BaseResult a2 = graphQLRequestLock.f14132f.mo2715a((GraphQLResult) c);
                        Preconditions.checkState(a2.m10400d() != GraphQLQueryScheduler.f6187a);
                        i3++;
                        c = a2;
                    }
                    if (c.m10404a() != DataFreshnessResult.FROM_CACHE_STALE) {
                        baseResult = c;
                        j2 = graphQLRequestLock.f14127a;
                        c = baseResult;
                        j = j2;
                    }
                }
                long j3 = j;
                baseResult = c;
                j2 = j3;
                c = baseResult;
                j = j2;
            }
            if (j != -1) {
                a = Builder.m21595a((GraphQLResult) c).m21601b(j).m21600a();
            } else {
                a = c;
            }
            GraphQLQueryScheduler.m10391b(quickPerformanceLogger, i, i2, (short) 152, "apply_all_ops_count", i3);
            return a;
        }

        public final void m20454b() {
            if (this.f14131e) {
                this.f14133g.f6196i.unlock();
                this.f14131e = false;
            }
        }

        public final void m20456c() {
            Object obj = null;
            try {
                m20454b();
                synchronized (this.f14133g) {
                    while (this.f14133g.f6198k.peek() != this) {
                        try {
                            ObjectDetour.a(this.f14133g, 692674212);
                        } catch (InterruptedException e) {
                            obj = 1;
                        }
                    }
                }
            } finally {
                if (obj != null) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public final void m20457d() {
            Object obj = null;
            try {
                Preconditions.checkState(!this.f14131e);
                synchronized (this.f14133g) {
                    if (this.f14130d == DataSource.NETWORK) {
                        this.f14133g.f6191d = Math.max(this.f14133g.f6191d, this.f14129c);
                    }
                    this.f14133g.f6198k.remove(this);
                    ObjectDetour.c(this.f14133g, -906629068);
                    while (this.f14133g.f6197j.peek() != this) {
                        try {
                            ObjectDetour.a(this.f14133g, 343587607);
                        } catch (InterruptedException e) {
                            obj = 1;
                        }
                    }
                }
            } finally {
                if (obj != null) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public final void m20458e() {
            m20451a(-1);
        }

        public final void m20451a(int i) {
            if (this.f14130d == DataSource.NETWORK) {
                this.f14133g.f6195h.m10368a(i, this.f14132f.mo2716a());
            }
            m20454b();
            synchronized (this.f14133g) {
                if (this.f14130d == DataSource.NETWORK) {
                    this.f14133g.f6190c = Math.max(this.f14133g.f6190c, this.f14129c);
                    this.f14133g.f6191d = Math.max(this.f14133g.f6191d, this.f14129c);
                }
                this.f14133g.f6198k.remove(this);
                this.f14133g.f6197j.remove(this);
                this.f14133g.f6193f.remove(this);
                ObjectDetour.c(this.f14133g, 32403735);
                long j = this.f14133g.f6190c;
                long j2 = j;
                for (GraphQLRequestLock graphQLRequestLock : this.f14133g.f6193f) {
                    if (graphQLRequestLock.f14128b != -1) {
                        j2 = Math.min(j2, graphQLRequestLock.f14128b);
                    }
                }
                while (this.f14133g.f6194g.size() > 10) {
                    this.f14133g.f6194g.remove(0);
                }
                while (!this.f14133g.f6194g.isEmpty() && ((GraphQLRequestLock) this.f14133g.f6194g.get(0)).f14129c <= j2) {
                    this.f14133g.f6194g.remove(0);
                }
            }
        }

        public final void m20459f() {
            Object obj = null;
            try {
                synchronized (this.f14133g) {
                    while (!mo3497g() && (this.f14133g.f6197j.contains(this) || this.f14133g.f6193f.contains(this))) {
                        try {
                            ObjectDetour.a(this.f14133g, 1883832182);
                        } catch (InterruptedException e) {
                            obj = 1;
                        }
                    }
                }
            } finally {
                if (obj != null) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        private boolean mo3497g() {
            if ((this.f14132f instanceof GraphQLWriteMutex) && ((GraphQLWriteMutex) this.f14132f).b) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: saved_caret_nux_imp */
    public class GraphQLMainThreadLock extends GraphQLRequestLock {
        final /* synthetic */ GraphQLQueryScheduler f19193a;

        public final void mo3087a() {
            this.d = DataSource.MEMORY_CACHE;
            this.b = this.f19193a.f6191d;
        }

        public GraphQLMainThreadLock(GraphQLQueryScheduler graphQLQueryScheduler, GraphQLReadMutex graphQLReadMutex) {
            this.f19193a = graphQLQueryScheduler;
            super(graphQLQueryScheduler, graphQLReadMutex, true);
        }
    }

    /* compiled from: saved_caret_nux_imp */
    public class GraphQLWriteLock extends GraphQLRequestLock {
        boolean f23623a = false;
        final /* synthetic */ GraphQLQueryScheduler f23624h;

        public final void m32019a(CacheVisitor cacheVisitor) {
            GraphQLWriteMutex graphQLWriteMutex = (GraphQLWriteMutex) this.f14132f;
            graphQLWriteMutex.a = cacheVisitor;
            if (graphQLWriteMutex.a != null && graphQLWriteMutex.a.a() != null) {
                graphQLWriteMutex.c = new ImmutableSet.Builder().m4809b(graphQLWriteMutex.c).m4809b(graphQLWriteMutex.a.a()).m4812b();
            }
        }

        public final void m32020a(boolean z) {
            this.f23624h.f6196i.lock();
            this.e = true;
            synchronized (this.f23624h) {
                GraphQLQueryScheduler graphQLQueryScheduler = this.f23624h;
                graphQLQueryScheduler.f6189b++;
                this.c = this.f23624h.f6189b;
                if (z) {
                    this.f23624h.f6194g.add(this);
                }
                this.f23624h.f6193f.remove(this);
                if (z) {
                    this.f23624h.f6198k.add(this);
                    this.f23624h.f6197j.add(this);
                }
                ObjectDetour.c(this.f23624h, -1325412954);
            }
        }

        public final void mo3087a() {
            ((GraphQLWriteMutex) this.f14132f).b = true;
            synchronized (this.f23624h) {
                ObjectDetour.c(this.f23624h, 1831361279);
            }
        }

        public final int m32016a(@Nullable QuickPerformanceLogger quickPerformanceLogger, int i, int i2) {
            ((GraphQLWriteMutex) this.f14132f).b = false;
            m32015j();
            boolean z = true;
            if (quickPerformanceLogger != null) {
                Preconditions.checkState(i != -1);
                if (i2 == -1) {
                    z = false;
                }
                Preconditions.checkState(z);
                quickPerformanceLogger.mo445a(i, i2, (short) 158);
            }
            int i3 = 0;
            GraphQLRequestLock a = mo3496a(DataSource.NETWORK);
            while (a != null) {
                a.m20459f();
                a = mo3496a(DataSource.NETWORK);
                i3++;
            }
            return i3;
        }

        public final int mo3497g() {
            return m32016a(null, -1, -1);
        }

        public GraphQLWriteLock(GraphQLQueryScheduler graphQLQueryScheduler, GraphQLWriteMutex graphQLWriteMutex) {
            this.f23624h = graphQLQueryScheduler;
            super(graphQLQueryScheduler, graphQLWriteMutex, false);
        }

        public final CacheVisitor m32022h() {
            return ((GraphQLWriteMutex) this.f14132f).a;
        }

        public final GraphQLRequestLock mo3496a(DataSource dataSource) {
            m32015j();
            return super.mo3496a(dataSource);
        }

        private void m32015j() {
            if (!this.f23623a && ((GraphQLWriteMutex) this.f14132f).b()) {
                this.f23624h.f6195h.m10368a(-1, this.f14132f.mo2716a());
                this.f23623a = true;
            }
        }
    }

    public static com.facebook.graphql.executor.GraphQLQueryScheduler m10388a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6188l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.executor.GraphQLQueryScheduler.class;
        monitor-enter(r1);
        r0 = f6188l;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10390b(r0);	 Catch:{ all -> 0x0035 }
        f6188l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6188l;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.GraphQLQueryScheduler.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.GraphQLQueryScheduler");
    }

    private static GraphQLQueryScheduler m10390b(InjectorLike injectorLike) {
        return new GraphQLQueryScheduler(GraphQLQuerySubscriber.m10365a(injectorLike));
    }

    @Inject
    public GraphQLQueryScheduler(GraphQLQuerySubscriber graphQLQuerySubscriber) {
        this.f6195h = graphQLQuerySubscriber;
    }

    public final GraphQLWriteLock m10395a(CacheVisitor cacheVisitor) {
        return new GraphQLWriteLock(this, new GraphQLWriteMutex(cacheVisitor));
    }

    public final GraphQLBatchRequestLock m10393a(boolean z, Collection<String> collection) {
        GraphQLRequestLock graphQLBatchRequestLock = new GraphQLBatchRequestLock(this, new GraphQLReadMutex(z));
        ((GraphQLReadMutex) graphQLBatchRequestLock.f14132f).m20463a(null, collection);
        return graphQLBatchRequestLock;
    }

    public final GraphQLRequestLock m10396b(boolean z, Collection<String> collection) {
        GraphQLRequestLock graphQLRequestLock = new GraphQLRequestLock(this, new GraphQLReadMutex(z));
        ((GraphQLReadMutex) graphQLRequestLock.f14132f).m20463a(null, collection);
        return graphQLRequestLock;
    }

    public final GraphQLMainThreadLock m10394a(boolean z) {
        return new GraphQLMainThreadLock(this, new GraphQLReadMutex(z));
    }

    public static boolean m10392b(GraphQLRequestLock graphQLRequestLock) {
        return graphQLRequestLock.f14132f instanceof GraphQLWriteMutex;
    }

    private static void m10391b(@Nullable QuickPerformanceLogger quickPerformanceLogger, int i, int i2, short s, String str, int i3) {
        boolean z = true;
        if (quickPerformanceLogger != null) {
            Preconditions.checkState(i != -1);
            if (i2 == -1) {
                z = false;
            }
            Preconditions.checkState(z);
            quickPerformanceLogger.mo447a(i, i2, s, str, String.valueOf(i3));
        }
    }
}
