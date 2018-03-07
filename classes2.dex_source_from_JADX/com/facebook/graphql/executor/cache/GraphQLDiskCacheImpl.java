package com.facebook.graphql.executor.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteStatement;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.cache.DiskCacheManager;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQuerySubscriber;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResponseParser;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cache.AbstractGraphQLDiskCache.CacheResult;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.executor.filemap.DefaultFlatBufferCorruptionHandlerProvider;
import com.facebook.graphql.executor.filemap.FlatBufferDirectorySizeLimiter;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.CacheVisitorAnalytics;
import com.facebook.graphql.executor.iface.SubscriptionRegistry;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: saved_text_zoom_level */
public class GraphQLDiskCacheImpl extends AbstractGraphQLDiskCache implements GraphQLDiskCache {
    private static final String f6107b = GraphQLDiskCache.class.getSimpleName();
    private static volatile GraphQLDiskCacheImpl f6108p;
    @VisibleForTesting
    protected long f6109a = 102400;
    public final GraphQLDiskCacheDatabaseSupplier f6110c;
    public final Clock f6111d;
    private final ConsistencyTypeHelper f6112e;
    private final ViewerContextManager f6113f;
    @BackgroundExecutorService
    private final Lazy<ExecutorService> f6114g;
    public final DeletedRowsAnalyticsLogger f6115h;
    private final GraphQLDiskCacheQueryFormatter f6116i;
    private final GraphQLDiskCacheTrimHelper f6117j;
    private final QuickPerformanceLogger f6118k;
    private final Provider<FlatBufferDirectorySizeLimiter> f6119l;
    private final GraphQLQuerySubscriber f6120m;
    private KeyFactory f6121n;
    private final AtomicInteger f6122o = new AtomicInteger(0);

    /* compiled from: saved_text_zoom_level */
    public class UpdateReadstampRunnable implements Runnable {
        final /* synthetic */ GraphQLDiskCacheImpl f15046a;
        private final long f15047b;

        public UpdateReadstampRunnable(GraphQLDiskCacheImpl graphQLDiskCacheImpl, long j) {
            this.f15046a = graphQLDiskCacheImpl;
            this.f15047b = j;
        }

        public void run() {
            GraphQLDiskCacheImpl.m10268b(this.f15046a, this.f15047b);
        }
    }

    public static com.facebook.graphql.executor.cache.GraphQLDiskCacheImpl m10254a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6108p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.executor.cache.GraphQLDiskCacheImpl.class;
        monitor-enter(r1);
        r0 = f6108p;	 Catch:{ all -> 0x003a }
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
        r0 = m10266b(r0);	 Catch:{ all -> 0x0035 }
        f6108p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6108p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.cache.GraphQLDiskCacheImpl.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.cache.GraphQLDiskCacheImpl");
    }

    private static GraphQLDiskCacheImpl m10266b(InjectorLike injectorLike) {
        return new GraphQLDiskCacheImpl(GraphQLDiskCacheDatabaseSupplier.m10310a(injectorLike), DiskCacheManager.m9192a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), KeyFactory.m10333b(injectorLike), ViewerContextManagerProvider.m2496b(injectorLike), ConsistencyTypeHelper.m10340a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3832), DeletedRowsAnalyticsLogger.m10347a(injectorLike), GraphQLDiskCacheQueryFormatter.m10353a(injectorLike), GraphQLDiskCacheTrimHelper.m10362a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 6858), (DefaultFlatBufferCorruptionHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultFlatBufferCorruptionHandlerProvider.class), GraphQLQuerySubscriber.m10365a(injectorLike));
    }

    @Inject
    public GraphQLDiskCacheImpl(GraphQLDiskCacheDatabaseSupplier graphQLDiskCacheDatabaseSupplier, DiskCacheManager diskCacheManager, Clock clock, KeyFactory keyFactory, ViewerContextManager viewerContextManager, ConsistencyTypeHelper consistencyTypeHelper, Lazy<ExecutorService> lazy, DeletedRowsAnalyticsLogger deletedRowsAnalyticsLogger, GraphQLDiskCacheQueryFormatter graphQLDiskCacheQueryFormatter, GraphQLDiskCacheTrimHelper graphQLDiskCacheTrimHelper, QuickPerformanceLogger quickPerformanceLogger, Provider<FlatBufferDirectorySizeLimiter> provider, DefaultFlatBufferCorruptionHandlerProvider defaultFlatBufferCorruptionHandlerProvider, SubscriptionRegistry subscriptionRegistry) {
        super(defaultFlatBufferCorruptionHandlerProvider);
        this.f6110c = graphQLDiskCacheDatabaseSupplier;
        this.f6111d = clock;
        this.f6121n = keyFactory;
        this.f6112e = consistencyTypeHelper;
        this.f6113f = viewerContextManager;
        this.f6114g = lazy;
        this.f6115h = deletedRowsAnalyticsLogger;
        this.f6116i = graphQLDiskCacheQueryFormatter;
        this.f6117j = graphQLDiskCacheTrimHelper;
        this.f6118k = quickPerformanceLogger;
        this.f6119l = provider;
        this.f6120m = subscriptionRegistry;
        diskCacheManager.mo1325a((DiskTrimmable) this);
    }

    private static String m10273e() {
        return "SELECT " + GraphQLDBContract$QueriesTable$Columns.f6132d.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6129a.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6133e.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6135g.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6136h.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6137i.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6139k.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6140l.f1025d + " FROM queries" + " WHERE " + GraphQLDBContract$QueriesTable$Columns.f6129a + "=?";
    }

    @Nullable
    private Set<String> m10255a(long j) {
        Cursor rawQuery = this.f6110c.mo2480a().rawQuery("SELECT " + GraphQLDBContract$TagsTable$Columns.f6143b.m2091a() + " FROM tags" + " WHERE " + GraphQLDBContract$TagsTable$Columns.f6142a + "=?", new String[]{String.valueOf(j)});
        int a = GraphQLDBContract$TagsTable$Columns.f6143b.m2089a(rawQuery);
        Set<String> set = null;
        try {
            if (rawQuery.getCount() > 0) {
                set = Sets.m1314a(rawQuery.getCount());
                while (rawQuery.moveToNext()) {
                    set.add(rawQuery.getString(a));
                }
            }
            rawQuery.close();
            return set;
        } catch (Throwable th) {
            rawQuery.close();
        }
    }

    @Nullable
    protected final <T> CacheResult<ByteBuffer> mo1439a(GraphQLRequest<T> graphQLRequest) {
        return m10253a("SELECT " + GraphQLDBContract$QueriesTable$Columns.f6132d.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6129a.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6133e.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6135g.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6136h.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6137i.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6139k.f1025d + ", " + GraphQLDBContract$QueriesTable$Columns.f6140l.f1025d + " FROM queries" + " WHERE " + GraphQLDBContract$QueriesTable$Columns.f6130b.f1025d + "=? AND " + GraphQLDBContract$QueriesTable$Columns.f6131c + "=?", new String[]{m10274e(graphQLRequest), m10280k()}, graphQLRequest.f7086d, true, true);
    }

    @Nullable
    private CacheResult<ByteBuffer> m10252a(long j, long j2, boolean z, boolean z2) {
        return m10253a(m10273e(), new String[]{String.valueOf(j)}, j2, z, z2);
    }

    public static synchronized void m10268b(GraphQLDiskCacheImpl graphQLDiskCacheImpl, long j) {
        synchronized (graphQLDiskCacheImpl) {
            try {
                SQLiteDatabase a = graphQLDiskCacheImpl.f6110c.mo2480a();
                ContentValues contentValues = new ContentValues();
                contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6134f.m2091a(), Long.valueOf(graphQLDiskCacheImpl.f6111d.mo211a()));
                Expression a2 = SqlExpression.m10727a(GraphQLDBContract$QueriesTable$Columns.f6129a.m2091a(), String.valueOf(j));
                a.update("queries", contentValues, a2.mo1476a(), a2.mo1477b());
            } catch (Throwable e) {
                BLog.b(f6107b, e, "Error updating the readstamp for row id %d", new Object[]{Long.valueOf(j)});
            }
        }
    }

    @Nullable
    private CacheResult<ByteBuffer> m10253a(String str, String[] strArr, long j, boolean z, boolean z2) {
        Throwable e;
        long j2 = -1;
        try {
            Cursor rawQuery = this.f6110c.mo2480a().rawQuery(str, strArr);
            try {
                if (rawQuery.moveToFirst()) {
                    long j3 = rawQuery.getLong(GraphQLDBContract$QueriesTable$Columns.f6129a.m2089a(rawQuery));
                    try {
                        byte[] blob = rawQuery.getBlob(GraphQLDBContract$QueriesTable$Columns.f6132d.m2089a(rawQuery));
                        Object wrap = blob != null ? ByteBuffer.wrap(blob) : null;
                        j2 = rawQuery.getLong(GraphQLDBContract$QueriesTable$Columns.f6133e.m2089a(rawQuery));
                        int i = rawQuery.getInt(GraphQLDBContract$QueriesTable$Columns.f6136h.m2089a(rawQuery));
                        Class cls = Class.forName(rawQuery.getString(GraphQLDBContract$QueriesTable$Columns.f6135g.m2089a(rawQuery)));
                        byte[] blob2 = rawQuery.getBlob(GraphQLDBContract$QueriesTable$Columns.f6139k.m2089a(rawQuery));
                        byte[] blob3 = rawQuery.getBlob(GraphQLDBContract$QueriesTable$Columns.f6140l.m2089a(rawQuery));
                        byte[] blob4 = rawQuery.getBlob(GraphQLDBContract$QueriesTable$Columns.f6137i.m2089a(rawQuery));
                        if (this.f6111d.mo211a() - j2 > j) {
                            try {
                                rawQuery.close();
                                return null;
                            } catch (ClassNotFoundException e2) {
                                e = e2;
                                j2 = j3;
                                BLog.a(f6107b, e, "Failed to deserialize cache item", new Object[0]);
                                if (j2 != -1) {
                                    m10272c(j2);
                                }
                                return null;
                            }
                        }
                        Set a = z2 ? m10255a(j3) : ImmutableSet.of();
                        if (z) {
                            ExecutorDetour.a((ExecutorService) this.f6114g.get(), new UpdateReadstampRunnable(this, j3), 1652909272);
                        }
                        CacheResult<ByteBuffer> cacheResult = new CacheResult(j2, wrap, blob2, blob3, a, cls, i, blob4, DataFreshnessResult.FROM_CACHE_UP_TO_DATE);
                        rawQuery.close();
                        return cacheResult;
                    } catch (Throwable th) {
                        e = th;
                        j2 = j3;
                        rawQuery.close();
                        throw e;
                    }
                }
                rawQuery.close();
                return null;
            } catch (Throwable th2) {
                e = th2;
                rawQuery.close();
                throw e;
            }
        } catch (ClassNotFoundException e3) {
            e = e3;
            BLog.a(f6107b, e, "Failed to deserialize cache item", new Object[0]);
            if (j2 != -1) {
                m10272c(j2);
            }
            return null;
        }
    }

    protected final synchronized <T> void mo1441a(GraphQLRequest<T> graphQLRequest, GraphQLResult<T> graphQLResult) {
        byte[] bArr;
        SQLiteDatabase a = this.f6110c.mo2480a();
        String c = m10271c(graphQLRequest, graphQLResult);
        boolean z = graphQLRequest.m11606c() == GraphQLCachePolicy.f7113e;
        int a2 = AbstractGraphQLDiskCache.m10291a((GraphQLResult) graphQLResult);
        byte[] a3 = m10297a(a2, graphQLResult.m10400d());
        if (graphQLResult.m10399c().isEmpty()) {
            bArr = null;
        } else {
            bArr = DiskCacheFlattenableHelper.b(graphQLResult.m10399c());
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6130b.m2091a(), c);
        String k = m10280k();
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6131c.m2091a(), k);
        long a4 = this.f6111d.mo211a();
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6133e.m2091a(), Long.valueOf(a4));
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6134f.m2091a(), Long.valueOf(m10250a(z, a4)));
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6132d.m2091a(), a3);
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6135g.m2091a(), graphQLRequest.m11614n().getName());
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6136h.m2091a(), Integer.valueOf(a2));
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6137i.m2091a(), bArr);
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6138j.m2091a(), Long.valueOf(graphQLRequest.f7086d));
        Collection f = graphQLResult.m10402f();
        if (!m10264a(a, c, k, f, contentValues)) {
            ai_();
            m10264a(a, c, k, f, contentValues);
        }
    }

    private static long m10250a(boolean z, long j) {
        if (z) {
            return j - 2419200000L;
        }
        return j;
    }

    private synchronized boolean m10264a(SQLiteDatabase sQLiteDatabase, String str, String str2, Collection<String> collection, ContentValues contentValues) {
        boolean z;
        SQLException sQLException = true;
        int i = 0;
        synchronized (this) {
            SQLiteDetour.a(sQLiteDatabase, 1824281825);
            try {
                m10247a(sQLiteDatabase, str, str2);
                SQLiteDetour.a(1234234562);
                long insert = sQLiteDatabase.insert("queries", null, contentValues);
                SQLiteDetour.a(-1037113761);
                m10260a(sQLiteDatabase, insert, (Collection) collection);
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    SQLiteDetour.b(sQLiteDatabase, i);
                } catch (SQLiteException e) {
                }
            } catch (SQLiteFullException e2) {
                sQLException = e2;
                sQLException = new Object[r0];
                sQLException[0] = str;
                sQLException[1] = str2;
                try {
                    SQLiteDetour.b(sQLiteDatabase, r0);
                    z = r1;
                } catch (SQLiteException e3) {
                    z = r1;
                }
                return z;
            } catch (SQLException e4) {
                sQLException = e4;
                Object[] objArr = new Object[i];
                objArr[0] = str;
                objArr[1] = str2;
                throw sQLException;
            } finally {
                i = 61335568;
                try {
                    SQLiteDetour.b(sQLiteDatabase, 61335568);
                } catch (SQLiteException e5) {
                }
            }
        }
        return z;
    }

    private synchronized void m10260a(SQLiteDatabase sQLiteDatabase, long j, @Nullable Collection<String> collection) {
        if (!(collection == null || collection.size() == 0)) {
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("INSERT OR REPLACE INTO tags (" + GraphQLDBContract$TagsTable$Columns.f6142a.m2091a() + ", " + GraphQLDBContract$TagsTable$Columns.f6143b.m2091a() + ") VALUES (?, ?)");
            try {
                for (String str : collection) {
                    if (str != null) {
                        try {
                            compileStatement.clearBindings();
                            compileStatement.bindLong(1, j);
                            compileStatement.bindString(2, str);
                            SQLiteDetour.a(75286750);
                            compileStatement.execute();
                            SQLiteDetour.a(1544795608);
                        } catch (Throwable e) {
                            BLog.b(f6107b, e, "Error inserting data with rowid %d and tag %s", new Object[]{Long.valueOf(j), str});
                            throw e;
                        }
                    }
                }
            } finally {
                compileStatement.close();
            }
        }
    }

    public final synchronized void mo1444a(Set<String> set) {
        SQLiteDatabase a = this.f6110c.mo2480a();
        SQLiteDetour.a(a, 1386436887);
        try {
            long[] a2 = m10265a(a, (Set) set, "-1");
            m10249a(a, a2);
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, a2);
        } finally {
            SQLiteDetour.b(a, -834902455);
        }
    }

    public final void mo1442a(CacheVisitor cacheVisitor) {
        if (!cacheVisitor.a().isEmpty()) {
            int incrementAndGet = this.f6122o.incrementAndGet();
            this.f6118k.mo478e(3211297, incrementAndGet);
            try {
                m10262a(cacheVisitor, incrementAndGet);
                this.f6118k.mo466b(3211297, incrementAndGet, (short) 2);
            } catch (Throwable e) {
                this.f6118k.mo466b(3211297, incrementAndGet, (short) 3);
                throw Throwables.propagate(e);
            }
        }
    }

    private void m10262a(CacheVisitor cacheVisitor, int i) {
        Set a = cacheVisitor.a();
        if (this.f6118k.mo484j(3211297, i)) {
            String b;
            if (cacheVisitor instanceof CacheVisitorAnalytics) {
                b = ((CacheVisitorAnalytics) cacheVisitor).b();
            } else {
                b = cacheVisitor.getClass().getName();
            }
            this.f6118k.mo465b(3211297, i, "visitor_class", b);
        }
        long[] b2 = m10270b(this.f6110c.mo2480a(), a, m10280k());
        this.f6118k.mo465b(3211297, i, "num_rows", String.valueOf(b2.length));
        int i2 = 0;
        int i3 = 0;
        while (i2 < b2.length) {
            int i4;
            long j = b2[i2];
            try {
                CacheResult a2 = m10252a(j, Long.MAX_VALUE, false, false);
                if (a2 == null) {
                    i4 = i3;
                } else {
                    Object a3 = m10295a(a2);
                    if (a3 == null) {
                        i4 = i3;
                    } else {
                        Object a4 = cacheVisitor.a(a3);
                        if (a4 != a3) {
                            i3++;
                            if (a4 == null) {
                                m10272c(j);
                                i4 = i3;
                            } else {
                                Collection a5 = GraphQLResponseParser.m11708a(a4);
                                byte[] a6 = m10297a(a2.f15052e, a4);
                                byte[] bArr = null;
                                MutableFlatBuffer a7 = m10251a(a4);
                                if (a7 != null) {
                                    ByteBuffer e = a7.m21554e();
                                    if (e != null) {
                                        bArr = e.array();
                                    }
                                }
                                m10258a(j, a6, null, bArr, a2.f15052e);
                                m10260a(this.f6110c.mo2480a(), j, a5);
                                i4 = i3;
                            }
                        } else {
                            MutableFlatBuffer a8 = m10251a(a4);
                            if (a8 != null && (a8.m21553d() || a8.m21545b())) {
                                i3++;
                                m10257a(j, a8);
                            }
                            i4 = i3;
                        }
                    }
                }
            } catch (Throwable e2) {
                BLog.a(f6107b, e2, "Failed to read and visit rowid %d", new Object[]{Long.valueOf(j)});
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        this.f6118k.mo465b(3211297, i, "rows_changed", String.valueOf(i3));
    }

    @Nullable
    private static MutableFlatBuffer m10251a(Object obj) {
        Preconditions.checkNotNull(obj);
        if (obj instanceof BaseModel) {
            return ((BaseModel) obj).w_();
        }
        Preconditions.checkState(obj instanceof Map);
        Map map = (Map) obj;
        if (map.isEmpty()) {
            return null;
        }
        Object next = map.values().iterator().next();
        return next instanceof BaseModel ? ((BaseModel) next).w_() : null;
    }

    private static long[] m10265a(SQLiteDatabase sQLiteDatabase, Set<String> set, String str) {
        String str2;
        String[] strArr;
        String str3 = "\"" + Joiner.on("\",\"").join((Iterable) set) + '\"';
        if ("-1".equals(str)) {
            str2 = "SELECT DISTINCT " + GraphQLDBContract$TagsTable$Columns.f6142a.m2091a() + " FROM tags" + " WHERE " + GraphQLDBContract$TagsTable$Columns.f6143b + " IN (" + str3 + ")";
            strArr = null;
        } else {
            str2 = "SELECT DISTINCT " + GraphQLDBContract$TagsTable$Columns.f6142a.m2091a() + " FROM tags" + ", queries" + " WHERE " + GraphQLDBContract$TagsTable$Columns.f6143b + " IN (" + str3 + ") AND " + GraphQLDBContract$QueriesTable$Columns.f6131c + " =?";
            strArr = new String[]{str};
        }
        Cursor rawQuery = sQLiteDatabase.rawQuery(str2, strArr);
        long[] jArr = new long[rawQuery.getCount()];
        int i = 0;
        while (rawQuery.moveToNext()) {
            try {
                int i2 = i + 1;
                jArr[i] = rawQuery.getLong(0);
                i = i2;
            } finally {
                rawQuery.close();
            }
        }
        return jArr;
    }

    private long[] m10270b(SQLiteDatabase sQLiteDatabase, Set<String> set, String str) {
        long[] jArr;
        Preconditions.checkNotNull(set);
        Preconditions.checkArgument(!set.isEmpty());
        long a = this.f6111d.mo211a();
        Set hashSet = new HashSet(this.f6120m.m10367a());
        String str2 = "SELECT DISTINCT " + GraphQLDBContract$QueriesTable$Columns.f6129a + ", " + GraphQLDBContract$QueriesTable$Columns.f6130b + ", (? - " + GraphQLDBContract$QueriesTable$Columns.f6133e + ") >= " + GraphQLDBContract$QueriesTable$Columns.f6138j + " FROM queries" + ", tags" + " WHERE " + GraphQLDBContract$TagsTable$Columns.f6142a + " = " + GraphQLDBContract$QueriesTable$Columns.f6129a + " AND " + GraphQLDBContract$QueriesTable$Columns.f6131c + " = ? AND " + GraphQLDBContract$TagsTable$Columns.f6143b + " IN (" + m10267b((Collection) set) + ")";
        String[] strArr = new String[]{String.valueOf(a), str};
        synchronized (this) {
            Cursor rawQuery = sQLiteDatabase.rawQuery(str2, strArr);
            try {
                Object obj = new long[rawQuery.getCount()];
                int i = 0;
                while (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery.getInt(2) == 0) {
                        int i2 = i + 1;
                        obj[i] = j;
                        i = i2;
                    } else {
                        int i3;
                        if (hashSet.isEmpty() || !hashSet.contains(rawQuery.getString(1))) {
                            i3 = i;
                        } else {
                            i3 = i + 1;
                            obj[i] = j;
                        }
                        i = i3;
                    }
                }
                if (i != obj.length) {
                    jArr = new long[i];
                    System.arraycopy(obj, 0, jArr, 0, i);
                } else {
                    Object obj2 = obj;
                }
            } finally {
                rawQuery.close();
            }
        }
        return jArr;
    }

    private void m10272c(long j) {
        m10263a(new long[]{j});
    }

    private synchronized void m10263a(long[] jArr) {
        if (jArr.length != 0) {
            SQLiteDatabase a = this.f6110c.mo2480a();
            SQLiteDetour.a(a, -1880150227);
            try {
                m10249a(a, jArr);
                a.setTransactionSuccessful();
                SQLiteDetour.b(a, -1880150227);
            } finally {
                SQLiteDetour.b(a, -2045858556);
            }
        }
    }

    private static long m10249a(SQLiteDatabase sQLiteDatabase, long[] jArr) {
        if (jArr.length == 0) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder(GraphQLDBContract$QueriesTable$Columns.f6129a.toString());
        stringBuilder.append(" IN (");
        for (int i = 0; i < jArr.length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(jArr[i]);
        }
        stringBuilder.append(")");
        return (long) sQLiteDatabase.delete("queries", stringBuilder.toString(), null);
    }

    private static long m10247a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        return (long) sQLiteDatabase.delete("queries", GraphQLDBContract$QueriesTable$Columns.f6130b + "=? AND " + GraphQLDBContract$QueriesTable$Columns.f6131c + "=?", new String[]{str, str2});
    }

    public final synchronized void mo1445c() {
        SQLiteDatabase a = this.f6110c.mo2480a();
        a.delete("tags", null, null);
        a.delete("queries", null, null);
        a.delete("consistency", null, null);
    }

    public void clearUserData() {
        this.f6110c.mo2481e();
    }

    private long m10275f() {
        return this.f6110c.m2025d();
    }

    public final void ai_() {
        if (m10275f() > this.f6109a) {
            this.f6118k.mo462b(3211265);
            try {
                m10276g();
                m10278i();
                this.f6118k.mo468b(3211265, (short) 2);
            } catch (Throwable e) {
                this.f6118k.mo468b(3211265, (short) 3);
                BLog.b(f6107b, "Failed to trim to minimum, truncating", e);
                mo1323b();
            }
        }
    }

    private synchronized void m10276g() {
        SQLiteDatabase a = this.f6110c.mo2480a();
        SQLiteDetour.a(a, -1939075877);
        try {
            int a2 = this.f6117j.m10364a(a);
            Integer.valueOf(a2);
            a2 = Math.max(1, (int) (((double) a2) * 0.5d));
            Integer.valueOf(a2);
            m10256a(a2);
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, a2);
        } finally {
            SQLiteDetour.b(a, 373644873);
        }
    }

    @VisibleForTesting
    private void m10256a(int i) {
        String b = m10267b(this.f6120m.m10367a());
        long a = this.f6111d.mo211a();
        SQLiteDatabase a2 = this.f6110c.mo2480a();
        this.f6115h.m10352a(a2, a, b);
        a = m10248a(a2, GraphQLDiskCacheQueryFormatter.m10355a(b), GraphQLDiskCacheQueryFormatter.m10358b(a));
        Long.valueOf(a);
        m10259a(a2);
        int i2 = (int) (((long) i) - a);
        if (i2 > 0) {
            SQLiteDatabase a3 = this.f6110c.mo2480a();
            this.f6115h.m10351a(a3, (long) i2, this.f6111d.mo211a(), b);
            Long.valueOf(m10248a(a3, GraphQLDiskCacheQueryFormatter.m10360c(b), GraphQLDiskCacheQueryFormatter.m10361d((long) i2)));
            m10259a(a3);
        }
    }

    public static void m10259a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("consistency", GraphQLDBContract$ConsistencyTable$Columns.f6147a.f1025d + " IN (" + "SELECT DISTINCT consistency.id FROM consistency LEFT JOIN tags ON tags.tag = consistency.id WHERE tags.tag IS NULL" + ")", null);
    }

    public static long m10248a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        return (long) sQLiteDatabase.delete("queries", GraphQLDBContract$QueriesTable$Columns.f6129a.f1025d + " IN (" + str + ")", strArr);
    }

    private synchronized void m10277h() {
        SQLiteDatabase a = this.f6110c.mo2480a();
        SQLiteDetour.a(a, -1785685082);
        try {
            this.f6115h.m10350a(a, this.f6111d.mo211a());
            a.delete("tags", null, null);
            a.delete("queries", null, null);
            int i = "consistency";
            a.delete(i, null, null);
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, i);
        } finally {
            SQLiteDetour.b(a, -303190115);
        }
    }

    public final void mo1323b() {
        this.f6118k.mo462b(3211266);
        try {
            m10277h();
            m10278i();
            this.f6118k.mo468b(3211266, (short) 2);
        } catch (Throwable e) {
            this.f6118k.mo468b(3211266, (short) 3);
            BLog.b(f6107b, "Failed to trim to nothing", e);
        }
    }

    private void m10278i() {
        try {
            SQLiteDetour.a(55327007);
            this.f6110c.mo2480a().execSQL("VACUUM");
            SQLiteDetour.a(338666530);
        } catch (Throwable e) {
            BLog.b(f6107b, "SQLite disk too full to vacuum", e);
        }
    }

    public final boolean mo1447d(GraphQLRequest graphQLRequest) {
        Cursor rawQuery = this.f6110c.mo2480a().rawQuery("SELECT " + GraphQLDBContract$QueriesTable$Columns.f6133e.m2091a() + " FROM queries" + " WHERE " + GraphQLDBContract$QueriesTable$Columns.f6130b.m2091a() + " =? AND " + GraphQLDBContract$QueriesTable$Columns.f6131c + " =?", new String[]{m10274e(graphQLRequest), m10280k()});
        try {
            if (rawQuery.moveToFirst()) {
                if (this.f6111d.mo211a() - Long.valueOf(rawQuery.getLong(GraphQLDBContract$QueriesTable$Columns.f6133e.m2089a(rawQuery))).longValue() <= graphQLRequest.f7086d) {
                    return true;
                }
            }
            rawQuery.close();
            return false;
        } finally {
            rawQuery.close();
        }
    }

    private String m10274e(GraphQLRequest graphQLRequest) {
        return graphQLRequest.m11601a(this.f6121n);
    }

    private <T> String m10271c(GraphQLRequest<T> graphQLRequest, GraphQLResult<T> graphQLResult) {
        return graphQLRequest.m11602a(this.f6121n, (GraphQLResult) graphQLResult);
    }

    private void m10258a(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        SQLiteDatabase a = this.f6110c.mo2480a();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6132d.f1025d, bArr);
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6139k.f1025d, bArr2);
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6140l.f1025d, bArr3);
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6136h.f1025d, Integer.valueOf(i));
        a.update("queries", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
    }

    private void m10257a(long j, MutableFlatBuffer mutableFlatBuffer) {
        byte[] bArr = null;
        ByteBuffer e = mutableFlatBuffer.m21554e();
        byte[] array = e != null ? e.array() : null;
        ByteBuffer c = mutableFlatBuffer.m21548c();
        if (c != null) {
            bArr = c.array();
        }
        SQLiteDatabase a = this.f6110c.mo2480a();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6139k.f1025d, bArr);
        contentValues.put(GraphQLDBContract$QueriesTable$Columns.f6140l.f1025d, array);
        a.update("queries", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
    }

    private SQLiteStatement m10279j() {
        return this.f6110c.mo2480a().compileStatement("INSERT OR REPLACE INTO consistency (" + GraphQLDBContract$ConsistencyTable$Columns.f6147a.f1025d + ", " + GraphQLDBContract$ConsistencyTable$Columns.f6149c.f1025d + ", " + GraphQLDBContract$ConsistencyTable$Columns.f6148b.f1025d + ", " + GraphQLDBContract$ConsistencyTable$Columns.f6150d.f1025d + ", " + GraphQLDBContract$ConsistencyTable$Columns.f6151e.f1025d + ", " + GraphQLDBContract$ConsistencyTable$Columns.f6152f.f1025d + ", " + GraphQLDBContract$ConsistencyTable$Columns.f6153g.f1025d + ") VALUES (?, ?, ?, ?, ?, ?, ?)");
    }

    private void m10261a(SQLiteStatement sQLiteStatement, String str, String str2, Object obj) {
        int b = ConsistencyTypeHelper.m10342b(obj);
        if (b == 7) {
            throw new RuntimeException("Unsupported type for consistency id = " + str + " path = " + str2);
        }
        int i;
        if (obj instanceof List) {
            i = 1;
        } else {
            i = 0;
        }
        String str3 = null;
        if (b == 6) {
            str3 = ConsistencyTypeHelper.m10344c(obj);
        }
        String d = this.f6112e.m10346d(obj);
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindString(1, str);
        if (str2 == null) {
            sQLiteStatement.bindNull(2);
        } else {
            sQLiteStatement.bindString(2, str2);
        }
        sQLiteStatement.bindString(3, m10280k());
        sQLiteStatement.bindString(4, d);
        sQLiteStatement.bindLong(5, (long) b);
        if (str3 == null) {
            sQLiteStatement.bindNull(6);
        } else {
            sQLiteStatement.bindString(6, str3);
        }
        sQLiteStatement.bindLong(7, (long) i);
        SQLiteDetour.a(235291415);
        sQLiteStatement.execute();
        SQLiteDetour.a(1381135509);
    }

    public final void mo1443a(Map<String, Map<String, Object>> map) {
        try {
            m10269b((Map) map);
        } catch (SQLiteFullException e) {
            ai_();
            m10269b((Map) map);
        }
    }

    private synchronized void m10269b(Map<String, Map<String, Object>> map) {
        SQLiteDatabase a = this.f6110c.mo2480a();
        SQLiteStatement j = m10279j();
        SQLiteDetour.a(a, -1104467872);
        try {
            int hasNext;
            Iterator it = map.keySet().iterator();
            while (true) {
                hasNext = it.hasNext();
                if (hasNext == 0) {
                    break;
                }
                String str = (String) it.next();
                Map map2 = (Map) map.get(str);
                for (String str2 : map2.keySet()) {
                    m10261a(j, str, str2, map2.get(str2));
                }
            }
            a.setTransactionSuccessful();
            try {
                SQLiteDetour.b(a, hasNext);
            } catch (SQLiteException e) {
            }
        } finally {
            j.close();
            try {
                SQLiteDetour.b(a, 664271502);
            } catch (SQLiteException e2) {
            }
        }
    }

    public final Map<String, Map<String, Object>> mo1440a(Collection<String> collection) {
        SQLiteDatabase a = this.f6110c.mo2480a();
        Map<String, Map<String, Object>> c = Maps.m838c();
        String str = "SELECT * FROM consistency WHERE user_id = \"" + m10280k() + '\"';
        if (collection != null) {
            if (collection.isEmpty()) {
                return c;
            }
            str = "SELECT * FROM consistency WHERE ID IN (" + ("\"" + Joiner.on("\",\"").join((Iterable) collection) + '\"') + ") AND user_id = \"" + m10280k() + '\"';
        }
        Cursor rawQuery = a.rawQuery(str, null);
        try {
            int a2 = GraphQLDBContract$ConsistencyTable$Columns.f6147a.m2089a(rawQuery);
            int a3 = GraphQLDBContract$ConsistencyTable$Columns.f6149c.m2089a(rawQuery);
            int a4 = GraphQLDBContract$ConsistencyTable$Columns.f6150d.m2089a(rawQuery);
            int a5 = GraphQLDBContract$ConsistencyTable$Columns.f6151e.m2089a(rawQuery);
            int a6 = GraphQLDBContract$ConsistencyTable$Columns.f6152f.m2089a(rawQuery);
            int a7 = GraphQLDBContract$ConsistencyTable$Columns.f6153g.m2089a(rawQuery);
            while (rawQuery.moveToNext()) {
                Object b;
                String string = rawQuery.getString(a2);
                String string2 = rawQuery.getString(a3);
                String string3 = rawQuery.getString(a4);
                int i = rawQuery.getInt(a5);
                String string4 = rawQuery.getString(a6);
                if ((rawQuery.getInt(a7) == 1 ? 1 : null) != null) {
                    b = this.f6112e.m10345b(i, string3, string4);
                } else {
                    b = ConsistencyTypeHelper.m10341a(i, string3, string4);
                }
                Map map = (Map) c.get(string);
                if (map == null) {
                    map = Maps.m838c();
                    c.put(string, map);
                }
                map.put(string2, b);
            }
            return c;
        } finally {
            if (rawQuery != null) {
                rawQuery.close();
            }
        }
    }

    public final synchronized void mo1446c(GraphQLRequest graphQLRequest) {
        SQLiteDatabase a = this.f6110c.mo2480a();
        SQLiteDetour.a(a, -1635703142);
        try {
            String e = m10274e(graphQLRequest);
            m10247a(a, e, m10280k());
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, e);
        } finally {
            SQLiteDetour.b(a, -1609009178);
        }
    }

    private String m10280k() {
        return this.f6113f.mo217d().mUserId;
    }

    private static String m10267b(Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : collection) {
            if (obj == null) {
                stringBuilder.append(",");
            }
            stringBuilder.append("'").append(str).append("'");
            obj = null;
        }
        return stringBuilder.toString();
    }
}
