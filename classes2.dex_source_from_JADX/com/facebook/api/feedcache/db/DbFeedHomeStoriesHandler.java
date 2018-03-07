package com.facebook.api.feedcache.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import com.facebook.analytics.cache.CacheTracker;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.data.FetchPortion;
import com.facebook.api.feed.data.GapFactory;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns;
import com.facebook.api.feedtype.FeedType;
import com.facebook.cache.DiskCacheManager;
import com.facebook.cache.common.CacheEventListener.EvictionReason;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.udppriming.client.ColdStartPrimingInformation;
import com.facebook.common.util.Tuple;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.feed.model.ClientFeedUnitEdgeBuilder;
import com.facebook.feed.model.ClientFeedUnitEdgeStoryTypeClassifier;
import com.facebook.feed.model.FeedUnitInflater;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.enums.GraphQLBumpReason;
import com.facebook.graphql.executor.filemap.DefaultFlatBufferCorruptionHandler;
import com.facebook.graphql.executor.filemap.DefaultFlatBufferCorruptionHandlerProvider;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLModelFlatbufferHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.model.IsValidUtil;
import com.facebook.graphql.model.NewsFeedEdge;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.VirtualFlattenableResolverImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: set_nonce */
public class DbFeedHomeStoriesHandler implements DiskTrimmable {
    private static final Class<DbFeedHomeStoriesHandler> f5244a = DbFeedHomeStoriesHandler.class;
    private static final String[] f5245b = new String[]{Columns.f5265a.toString(), Columns.f5266b.toString(), Columns.f5267c.toString(), Columns.f5268d.toString(), Columns.f5269e.toString(), Columns.f5270f.toString(), Columns.f5271g.toString(), Columns.f5272h.toString(), Columns.f5275k.toString(), Columns.f5277m.toString(), Columns.f5278n.toString(), Columns.f5279o.toString(), Columns.f5280p.toString(), Columns.f5281q.toString(), Columns.f5282r.toString(), Columns.f5283s.toString(), Columns.f5284t.toString(), Columns.f5285u.toString(), Columns.f5286v.toString(), Columns.f5287w.toString(), Columns.f5288x.toString(), Columns.f5289y.toString(), Columns.f5273i.toString(), Columns.f5276l.toString(), Columns.f5274j.toString(), Columns.f5290z.toString()};
    private static final String[] f5246c = new String[]{Columns.f5267c.toString(), Columns.f5288x.toString()};
    private static volatile DbFeedHomeStoriesHandler f5247u;
    private final List<String> f5248d = Lists.m1300a(FeedType.f5038a.toString(), FeedType.f5039b.toString());
    public final Lazy<FeedDatabaseSupplier> f5249e;
    private final PerformanceLogger f5250f;
    private final CacheTracker f5251g;
    private final Lazy<Integer> f5252h;
    private final Clock f5253i;
    private final NewsFeedXConfigReader f5254j;
    private final DefaultFlatBufferCorruptionHandlerProvider f5255k;
    @Nullable
    private DefaultFlatBufferCorruptionHandler f5256l;
    public final File f5257m;
    private final ArrayList<String> f5258n;
    private final FeedUnitInflater f5259o;
    private final QeAccessor f5260p;
    private final FeedStoryRefetchLogger f5261q;
    private final DbStoryLookup f5262r = new DbStoryLookup(this);
    public final DbFeedHomeStoriesMediaTable f5263s;
    private final FbSharedPreferences f5264t;

    /* compiled from: set_nonce */
    public class DbStoryLookup {
        final /* synthetic */ DbFeedHomeStoriesHandler f5400a;

        DbStoryLookup(DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler) {
            this.f5400a = dbFeedHomeStoriesHandler;
        }

        public final boolean m9293a(String str, FeedType feedType) {
            Expression a = SqlExpression.m10723a(Columns.f5268d.m2090a(str), Columns.f5265a.m2090a(feedType.m8961a()));
            return DatabaseUtils.queryNumEntries(((FeedDatabaseSupplier) this.f5400a.f5249e.get()).mo2480a(), "home_stories", a.mo1476a(), a.mo1477b()) > 0;
        }
    }

    public static com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler m9120a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5247u;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler.class;
        monitor-enter(r1);
        r0 = f5247u;	 Catch:{ all -> 0x003a }
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
        r0 = m9136b(r0);	 Catch:{ all -> 0x0035 }
        f5247u = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5247u;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler");
    }

    private static DbFeedHomeStoriesHandler m9136b(InjectorLike injectorLike) {
        return new DbFeedHomeStoriesHandler(IdBasedSingletonScopeProvider.m1810b(injectorLike, 234), DelegatingPerformanceLogger.m2803a(injectorLike), Factory.m9186a(injectorLike), DiskCacheManager.m9192a(injectorLike), IdBasedLazy.m1808a(injectorLike, 4404), SystemClockMethodAutoProvider.m1498a(injectorLike), NewsFeedXConfigReader.m8187a(injectorLike), (DefaultFlatBufferCorruptionHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultFlatBufferCorruptionHandlerProvider.class), File_FeedCacheStorageDirectoryMethodAutoProvider.m9266b(injectorLike), FeedUnitInflater.m9272a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FeedStoryRefetchLogger.m9281a(injectorLike), DbFeedHomeStoriesMediaTable.m9284a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    private static boolean m9144e(FetchFeedResult fetchFeedResult) {
        FetchFeedParams fetchFeedParams = fetchFeedResult.f15756a;
        if (fetchFeedResult.m22439d() == null || fetchFeedResult.m22439d().isEmpty() || fetchFeedParams == null) {
            return false;
        }
        return true;
    }

    private boolean m9146f(FetchFeedResult fetchFeedResult) {
        FetchFeedParams fetchFeedParams = fetchFeedResult.f15756a;
        if (fetchFeedParams == null || !m9140c(fetchFeedParams) || fetchFeedResult.m22440e() == null || !fetchFeedResult.m22440e().mo1407b() || fetchFeedResult.m22439d().isEmpty()) {
            return false;
        }
        return true;
    }

    public final void m9173b(FetchFeedResult fetchFeedResult) {
        FetchPortion fetchPortion = fetchFeedResult.f15759d;
        FetchFeedParams fetchFeedParams = fetchFeedResult.f15756a;
        GraphQLFeedHomeStories graphQLFeedHomeStories = fetchFeedResult.f15757b;
        if (!(fetchFeedParams.f5787e != null || fetchPortion != FetchPortion.CHUNKED_REMAINDER || graphQLFeedHomeStories == null || graphQLFeedHomeStories.m22433n() == null || graphQLFeedHomeStories.m22433n().mo1407b())) {
            m9143d(fetchFeedResult);
        }
        m9132a(fetchFeedResult, ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a());
    }

    private static boolean m9140c(FetchFeedParams fetchFeedParams) {
        return fetchFeedParams.f5786d != null;
    }

    @Inject
    public DbFeedHomeStoriesHandler(Lazy<FeedDatabaseSupplier> lazy, PerformanceLogger performanceLogger, Factory factory, DiskCacheManager diskCacheManager, Lazy<Integer> lazy2, Clock clock, NewsFeedXConfigReader newsFeedXConfigReader, DefaultFlatBufferCorruptionHandlerProvider defaultFlatBufferCorruptionHandlerProvider, File file, FeedUnitInflater feedUnitInflater, QeAccessor qeAccessor, FeedStoryRefetchLogger feedStoryRefetchLogger, DbFeedHomeStoriesMediaTable dbFeedHomeStoriesMediaTable, FbSharedPreferences fbSharedPreferences) {
        this.f5260p = qeAccessor;
        this.f5249e = (Lazy) Preconditions.checkNotNull(lazy);
        this.f5250f = performanceLogger;
        this.f5251g = factory.m9188a("newsfeed");
        diskCacheManager.mo1325a((DiskTrimmable) this);
        this.f5252h = lazy2;
        this.f5253i = clock;
        this.f5254j = newsFeedXConfigReader;
        this.f5257m = file;
        this.f5255k = defaultFlatBufferCorruptionHandlerProvider;
        this.f5258n = Lists.m1305b(1);
        this.f5259o = feedUnitInflater;
        this.f5261q = feedStoryRefetchLogger;
        this.f5263s = dbFeedHomeStoriesMediaTable;
        this.f5264t = fbSharedPreferences;
    }

    public final void m9165a(String str) {
        Expression a = SqlExpression.m10727a(Columns.f5268d.m2091a(), str);
        try {
            String c = m9139c(FeedType.f5039b, str);
            if (c != null) {
                this.f5263s.m9292c(c);
            }
            SQLiteDatabase a2 = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a();
            SQLiteDetour.a(a2, -922860547);
            a2.delete("home_stories", a.mo1476a(), a.mo1477b());
            a2.setTransactionSuccessful();
            try {
                SQLiteDetour.b(a2, 1551785440);
            } catch (Throwable e) {
                BLog.b(f5244a, "Failed to close the connection to the DB!", e);
            }
        } catch (Throwable e2) {
            BLog.b(f5244a, "Delete Story failed!", e2);
            try {
                SQLiteDetour.b(null, -235337152);
            } catch (Throwable e22) {
                BLog.b(f5244a, "Failed to close the connection to the DB!", e22);
            }
        } catch (Throwable th) {
            try {
                SQLiteDetour.b(null, 945013484);
            } catch (Throwable e3) {
                BLog.b(f5244a, "Failed to close the connection to the DB!", e3);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int m9155a(com.google.common.collect.ImmutableList<java.lang.String> r9) {
        /*
        r8 = this;
        r1 = 0;
        if (r9 != 0) goto L_0x000c;
    L_0x0003:
        r0 = f5244a;
        r2 = "Inconsistent input for deleteStories!";
        com.facebook.debug.log.BLog.b(r0, r2);
        r0 = r1;
    L_0x000b:
        return r0;
    L_0x000c:
        r2 = 0;
        r0 = com.facebook.api.feedtype.FeedType.f5039b;	 Catch:{ SQLiteException -> 0x00b6, all -> 0x00a2 }
        r0 = r8.m9122a(r0, r9);	 Catch:{ SQLiteException -> 0x00b6, all -> 0x00a2 }
        if (r0 == 0) goto L_0x0020;
    L_0x0015:
        r3 = r0.isEmpty();	 Catch:{ SQLiteException -> 0x00b6, all -> 0x00a2 }
        if (r3 != 0) goto L_0x0020;
    L_0x001b:
        r3 = r8.f5263s;	 Catch:{ SQLiteException -> 0x00b6, all -> 0x00a2 }
        r3.m9287a(r0);	 Catch:{ SQLiteException -> 0x00b6, all -> 0x00a2 }
    L_0x0020:
        r0 = r8.f5249e;	 Catch:{ SQLiteException -> 0x00b6, all -> 0x00a2 }
        r0 = r0.get();	 Catch:{ SQLiteException -> 0x00b6, all -> 0x00a2 }
        r0 = (com.facebook.api.feedcache.db.FeedDatabaseSupplier) r0;	 Catch:{ SQLiteException -> 0x00b6, all -> 0x00a2 }
        r2 = r0.mo2480a();	 Catch:{ SQLiteException -> 0x00b6, all -> 0x00a2 }
        r0 = 1266184814; // 0x4b78726e float:1.6282222E7 double:6.25578418E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r2, r0);	 Catch:{ SQLiteException -> 0x007b, all -> 0x00a2 }
        r4 = com.facebook.database.sqlite.SqlExpression.m10730b();	 Catch:{ SQLiteException -> 0x007b, all -> 0x00a2 }
        r5 = r9.size();	 Catch:{ SQLiteException -> 0x007b, all -> 0x00a2 }
        r3 = r1;
    L_0x003b:
        if (r3 >= r5) goto L_0x0050;
    L_0x003d:
        r0 = r9.get(r3);	 Catch:{ SQLiteException -> 0x007b, all -> 0x00a2 }
        r0 = (java.lang.String) r0;	 Catch:{ SQLiteException -> 0x007b, all -> 0x00a2 }
        r6 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5268d;	 Catch:{ SQLiteException -> 0x007b, all -> 0x00a2 }
        r0 = r6.m2090a(r0);	 Catch:{ SQLiteException -> 0x007b, all -> 0x00a2 }
        r4.m10741a(r0);	 Catch:{ SQLiteException -> 0x007b, all -> 0x00a2 }
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x003b;
    L_0x0050:
        r0 = "home_stories";
        r3 = r4.mo1476a();	 Catch:{ Exception -> 0x0072 }
        r4 = r4.mo1477b();	 Catch:{ Exception -> 0x0072 }
        r1 = r2.delete(r0, r3, r4);	 Catch:{ Exception -> 0x0072 }
    L_0x005e:
        r2.setTransactionSuccessful();	 Catch:{  }
        r0 = 1911144187; // 0x71e9befb float:2.3149084E30 double:9.44230687E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r2, r0);	 Catch:{ Exception -> 0x008e }
        r0 = r1;
    L_0x0068:
        if (r0 <= 0) goto L_0x000b;
    L_0x006a:
        r1 = "mutateAndDeleteInSingleTransaction";
        r2 = com.facebook.cache.common.CacheEventListener.EvictionReason.CONTENT_STALE;
        r8.m9130a(r1, r2);
        goto L_0x000b;
    L_0x0072:
        r0 = move-exception;
        r3 = f5244a;	 Catch:{  }
        r4 = "One Delete operation failed!";
        com.facebook.debug.log.BLog.b(r3, r4, r0);	 Catch:{  }
        goto L_0x005e;
    L_0x007b:
        r0 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r7;
    L_0x007f:
        r3 = f5244a;	 Catch:{ all -> 0x00b3 }
        r4 = "Delete Stories failed!";
        com.facebook.debug.log.BLog.b(r3, r4, r0);	 Catch:{ all -> 0x00b3 }
        r0 = 397744467; // 0x17b51953 float:1.1703244E-24 double:1.96511877E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r0);	 Catch:{ Exception -> 0x0098 }
        r0 = r2;
        goto L_0x0068;
    L_0x008e:
        r0 = move-exception;
        r2 = f5244a;
        r3 = "Failed to close the connection to the DB!";
        com.facebook.debug.log.BLog.b(r2, r3, r0);
        r0 = r1;
        goto L_0x0068;
    L_0x0098:
        r0 = move-exception;
        r1 = f5244a;
        r3 = "Failed to close the connection to the DB!";
        com.facebook.debug.log.BLog.b(r1, r3, r0);
        r0 = r2;
        goto L_0x0068;
    L_0x00a2:
        r0 = move-exception;
    L_0x00a3:
        r1 = 1577521723; // 0x5e07123b float:2.43322665E18 double:7.79399289E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r2, r1);	 Catch:{ Exception -> 0x00aa }
    L_0x00a9:
        throw r0;
    L_0x00aa:
        r1 = move-exception;
        r2 = f5244a;
        r3 = "Failed to close the connection to the DB!";
        com.facebook.debug.log.BLog.b(r2, r3, r1);
        goto L_0x00a9;
    L_0x00b3:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00a3;
    L_0x00b6:
        r0 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler.a(com.google.common.collect.ImmutableList):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int m9156a(com.google.common.collect.ImmutableList<java.lang.String> r13, com.google.common.collect.ImmutableList<java.lang.String> r14, com.google.common.collect.ImmutableList<com.facebook.graphql.model.GraphQLStory> r15) {
        /*
        r12 = this;
        r3 = 1;
        r1 = 0;
        if (r13 == 0) goto L_0x001c;
    L_0x0004:
        if (r14 == 0) goto L_0x001c;
    L_0x0006:
        if (r15 == 0) goto L_0x001c;
    L_0x0008:
        r0 = r13.size();
        r2 = r14.size();
        if (r0 != r2) goto L_0x001c;
    L_0x0012:
        r0 = r14.size();
        r2 = r15.size();
        if (r0 == r2) goto L_0x0025;
    L_0x001c:
        r0 = f5244a;
        r2 = "Inconsistent input for mutateStories!";
        com.facebook.debug.log.BLog.b(r0, r2);
        r0 = r1;
    L_0x0024:
        return r0;
    L_0x0025:
        r2 = 0;
        r0 = r12.f5249e;	 Catch:{ SQLiteFullException -> 0x0123, Exception -> 0x0141, all -> 0x0167 }
        r0 = r0.get();	 Catch:{ SQLiteFullException -> 0x0123, Exception -> 0x0141, all -> 0x0167 }
        r0 = (com.facebook.api.feedcache.db.FeedDatabaseSupplier) r0;	 Catch:{ SQLiteFullException -> 0x0123, Exception -> 0x0141, all -> 0x0167 }
        r5 = r0.mo2480a();	 Catch:{ SQLiteFullException -> 0x0123, Exception -> 0x0141, all -> 0x0167 }
        r0 = -1197035975; // 0xffffffffb8a6ae39 float:-7.947948E-5 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r5, r0);	 Catch:{ SQLiteFullException -> 0x0176, Exception -> 0x016d }
        r6 = r1;
        r2 = r1;
        r4 = r1;
    L_0x003b:
        r0 = r13.size();	 Catch:{ SQLiteFullException -> 0x017a, Exception -> 0x0171 }
        if (r6 >= r0) goto L_0x0108;
    L_0x0041:
        r0 = r15.get(r6);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r0 = (com.facebook.graphql.model.GraphQLStory) r0;	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r7 = com.facebook.database.sqlite.SqlExpression.m10722a();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r8 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5268d;	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r1 = r13.get(r6);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r1 = (java.lang.String) r1;	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r1 = r8.m2090a(r1);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r7.m10741a(r1);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r8 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5266b;	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r1 = r14.get(r6);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r1 = (java.lang.String) r1;	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r1 = r8.m2090a(r1);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r7.m10741a(r1);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r1 = new android.content.ContentValues;	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r1.<init>();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r8 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5266b;	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r8 = r8.toString();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r10 = r0.T_();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r9 = java.lang.Long.valueOf(r10);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r1.put(r8, r9);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r0 = r0.w_();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        if (r0 == 0) goto L_0x00ed;
    L_0x0085:
        r8 = r0.m21548c();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        if (r8 == 0) goto L_0x00c3;
    L_0x008b:
        r9 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5284t;	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r9 = r9.toString();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r8 = r8.array();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r1.put(r9, r8);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
    L_0x0098:
        r0 = r0.m21554e();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        if (r0 == 0) goto L_0x00d8;
    L_0x009e:
        r8 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5285u;	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r8 = r8.toString();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r0 = r0.array();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r1.put(r8, r0);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
    L_0x00ab:
        r0 = "home_stories";
        r8 = r7.mo1476a();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r7 = r7.mo1477b();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r0 = r5.update(r0, r1, r8, r7);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r0 = r0 + r4;
        r1 = r0;
        r0 = r2;
    L_0x00bc:
        r2 = r6 + 1;
        r6 = r2;
        r4 = r1;
        r2 = r0;
        goto L_0x003b;
    L_0x00c3:
        r8 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5284t;	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r8 = r8.toString();	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        r1.putNull(r8);	 Catch:{ SQLiteFullException -> 0x00cd, Exception -> 0x00e2 }
        goto L_0x0098;
    L_0x00cd:
        r0 = move-exception;
        r1 = f5244a;	 Catch:{ SQLiteFullException -> 0x017a, Exception -> 0x0173 }
        r2 = "One update operation failed!";
        com.facebook.debug.log.BLog.b(r1, r2, r0);	 Catch:{ SQLiteFullException -> 0x017a, Exception -> 0x0173 }
        r0 = r3;
        r1 = r4;
        goto L_0x00bc;
    L_0x00d8:
        r0 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5285u;	 Catch:{  }
        r0 = r0.toString();	 Catch:{  }
        r1.putNull(r0);	 Catch:{  }
        goto L_0x00ab;
    L_0x00e2:
        r0 = move-exception;
        r1 = f5244a;	 Catch:{  }
        r7 = "One update operation failed!";
        com.facebook.debug.log.BLog.b(r1, r7, r0);	 Catch:{  }
        r0 = r2;
        r1 = r4;
        goto L_0x00bc;
    L_0x00ed:
        r0 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5284t;	 Catch:{  }
        r0 = r0.toString();	 Catch:{  }
        r1.putNull(r0);	 Catch:{  }
        r0 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5285u;	 Catch:{  }
        r0 = r0.toString();	 Catch:{  }
        r1.putNull(r0);	 Catch:{  }
        goto L_0x00ab;
    L_0x0100:
        r0 = move-exception;
    L_0x0101:
        r1 = 588307100; // 0x2310da9c float:7.852548E-18 double:2.906623273E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r5, r1);	 Catch:{ Exception -> 0x015e }
    L_0x0107:
        throw r0;
    L_0x0108:
        r5.setTransactionSuccessful();	 Catch:{  }
        r0 = 1943167915; // 0x73d263ab float:3.333752E31 double:9.60052511E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r5, r0);	 Catch:{ Exception -> 0x0119 }
        r0 = r4;
    L_0x0112:
        if (r2 == 0) goto L_0x0024;
    L_0x0114:
        r12.ai_();
        goto L_0x0024;
    L_0x0119:
        r0 = move-exception;
        r1 = f5244a;
        r3 = "Failed to close the connection to the DB!";
        com.facebook.debug.log.BLog.b(r1, r3, r0);
        r0 = r4;
        goto L_0x0112;
    L_0x0123:
        r0 = move-exception;
        r4 = r1;
        r1 = r2;
    L_0x0126:
        r2 = f5244a;	 Catch:{ all -> 0x016a }
        r5 = "Updating cache DB failed!";
        com.facebook.debug.log.BLog.b(r2, r5, r0);	 Catch:{ all -> 0x016a }
        r0 = -1775357860; // 0xffffffff962e305c float:-1.4070868E-25 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r0);	 Catch:{ Exception -> 0x0136 }
        r2 = r3;
        r0 = r4;
        goto L_0x0112;
    L_0x0136:
        r0 = move-exception;
        r1 = f5244a;
        r2 = "Failed to close the connection to the DB!";
        com.facebook.debug.log.BLog.b(r1, r2, r0);
        r2 = r3;
        r0 = r4;
        goto L_0x0112;
    L_0x0141:
        r0 = move-exception;
        r5 = r2;
        r4 = r1;
        r2 = r1;
    L_0x0145:
        r1 = f5244a;	 Catch:{ all -> 0x0100 }
        r3 = "Updating cache DB failed!";
        com.facebook.debug.log.BLog.b(r1, r3, r0);	 Catch:{ all -> 0x0100 }
        r0 = 2120701610; // 0x7e6756aa float:7.6875413E37 double:1.0477658106E-314;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r5, r0);	 Catch:{ Exception -> 0x0154 }
        r0 = r4;
        goto L_0x0112;
    L_0x0154:
        r0 = move-exception;
        r1 = f5244a;
        r3 = "Failed to close the connection to the DB!";
        com.facebook.debug.log.BLog.b(r1, r3, r0);
        r0 = r4;
        goto L_0x0112;
    L_0x015e:
        r1 = move-exception;
        r2 = f5244a;
        r3 = "Failed to close the connection to the DB!";
        com.facebook.debug.log.BLog.b(r2, r3, r1);
        goto L_0x0107;
    L_0x0167:
        r0 = move-exception;
        r5 = r2;
        goto L_0x0101;
    L_0x016a:
        r0 = move-exception;
        r5 = r1;
        goto L_0x0101;
    L_0x016d:
        r0 = move-exception;
        r2 = r1;
        r4 = r1;
        goto L_0x0145;
    L_0x0171:
        r0 = move-exception;
        goto L_0x0145;
    L_0x0173:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0145;
    L_0x0176:
        r0 = move-exception;
        r4 = r1;
        r1 = r5;
        goto L_0x0126;
    L_0x017a:
        r0 = move-exception;
        r1 = r5;
        goto L_0x0126;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler.a(com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableList):int");
    }

    public final ImmutableList<ClientFeedUnitEdge> m9174c() {
        Expression a = SqlExpression.m10727a(Columns.f5265a.f1025d, FeedType.f5039b.m8961a());
        Expression a2 = SqlExpression.m10727a(Columns.f5273i.f1025d, "1");
        Expression a3 = SqlExpression.m10722a();
        a3.m10741a(a);
        a3.m10741a(a2);
        return m9123a(a3.mo1476a(), a3.mo1477b(), Columns.f5269e.m2100e());
    }

    @Nullable
    public final ClientFeedUnitEdge m9160a(FeedType feedType, String str) {
        Expression a = SqlExpression.m10723a(SqlExpression.m10727a(Columns.f5265a.f1025d, feedType.toString()), SqlExpression.m10727a(Columns.f5268d.f1025d, str));
        ImmutableList a2 = m9123a(a.mo1476a(), a.mo1477b(), null);
        if (a2.isEmpty()) {
            return null;
        }
        return (ClientFeedUnitEdge) a2.get(0);
    }

    public final ImmutableList<ClientFeedUnitEdge> m9179d() {
        Expression a = SqlExpression.m10727a(Columns.f5265a.f1025d, FeedType.f5039b.m8961a());
        return m9123a(a.mo1476a(), a.mo1477b(), Columns.f5269e.m2100e());
    }

    public final ImmutableList<ClientFeedUnitEdge> m9161a(FeedType feedType, long j) {
        Preconditions.checkArgument(j > 0);
        Expression a = SqlExpression.m10723a(Columns.f5265a.m2090a(feedType.toString()), Columns.f5266b.m2099e(Long.toString(this.f5253i.mo211a() - j)));
        return m9123a(a.mo1476a(), a.mo1477b(), Columns.f5287w.m2100e());
    }

    private ImmutableList<ClientFeedUnitEdge> m9123a(String str, String[] strArr, String str2) {
        Throwable th;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), f5245b, str, strArr, null, null, str2);
        Throwable th2 = null;
        try {
            int a = Columns.f5265a.m2089a(query);
            int a2 = Columns.f5266b.m2089a(query);
            int a3 = Columns.f5267c.m2089a(query);
            int a4 = Columns.f5268d.m2089a(query);
            int a5 = Columns.f5269e.m2089a(query);
            int a6 = Columns.f5270f.m2089a(query);
            int a7 = Columns.f5271g.m2089a(query);
            int a8 = Columns.f5272h.m2089a(query);
            int a9 = Columns.f5275k.m2089a(query);
            int a10 = Columns.f5277m.m2089a(query);
            int a11 = Columns.f5280p.m2089a(query);
            int a12 = Columns.f5281q.m2089a(query);
            int a13 = Columns.f5282r.m2089a(query);
            int a14 = Columns.f5283s.m2089a(query);
            int a15 = Columns.f5284t.m2089a(query);
            int a16 = Columns.f5285u.m2089a(query);
            int a17 = Columns.f5286v.m2089a(query);
            int a18 = Columns.f5287w.m2089a(query);
            int a19 = Columns.f5288x.m2089a(query);
            int a20 = Columns.f5279o.m2089a(query);
            int a21 = Columns.f5273i.m2089a(query);
            int a22 = Columns.f5276l.m2089a(query);
            int a23 = Columns.f5274j.m2089a(query);
            int a24 = Columns.f5289y.m2089a(query);
            int a25 = Columns.f5290z.m2089a(query);
            Builder builder = ImmutableList.builder();
            while (query.moveToNext()) {
                if (2 != query.getInt(a10)) {
                    boolean z;
                    ByteBuffer byteBuffer;
                    String string = query.getString(a11);
                    int i = query.getInt(a12);
                    int i2 = query.getInt(a13);
                    int i3 = query.getInt(a14);
                    if (query.getInt(a17) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ByteBuffer byteBuffer2 = null;
                    if (z) {
                        byte[] blob = query.getBlob(a15);
                        if (blob != null && blob.length > 0) {
                            byteBuffer2 = ByteBuffer.wrap(blob);
                        }
                        blob = query.getBlob(a16);
                        if (blob == null || blob.length <= 0) {
                            byteBuffer = byteBuffer2;
                            byteBuffer2 = null;
                        } else {
                            ByteBuffer wrap = ByteBuffer.wrap(blob);
                            byteBuffer = byteBuffer2;
                            byteBuffer2 = wrap;
                        }
                    } else {
                        byteBuffer = null;
                        byteBuffer2 = null;
                    }
                    String string2 = query.getString(a4);
                    String string3 = query.getString(a5);
                    String string4 = query.getString(a18);
                    String string5 = query.getString(a19);
                    String string6 = query.getString(a);
                    String string7 = query.getString(a24);
                    boolean z2 = query.getInt(a8) == 1;
                    long j = query.getLong(a2);
                    String string8 = query.getString(a20);
                    int i4 = query.getInt(a21);
                    int i5 = query.getInt(a22);
                    GraphQLFeedUnitEdge a26 = new ClientFeedUnitEdgeBuilder().m21169a(string3).m21163a(query.getDouble(a6)).m21189i(query.getString(a7)).m21176b(z2).m21174b(query.getString(a3)).m21167a(GraphQLBumpReason.BUMP_NONE).m21178c(string4).m21181d(string5).m21183e(string2).m21185f(string).m21177c(i).m21182e(i2).m21180d(i3).m21171a(z).m21170a(byteBuffer).m21175b(byteBuffer2).m21187g(string6).m21165a(j).m21188h(string8).m21184f(query.getInt(a9)).m21186g(i4).m21164a(i5).m21172b(query.getInt(a23)).m21168a(m9147g()).m21166a(this.f5259o).m21179c(true).m21190j(string7).m21173b(query.getLong(a25)).m21162a();
                    if (string7 != null) {
                        PropertyHelper.m21271a(a26, this.f5263s.m9291b(string7));
                    }
                    if (this.f5264t.mo286a(FeedPrefKeys.f5760x, false)) {
                        FeedUnit c = a26.mo2540c();
                        if (c != null) {
                            PropertyHelper.m21269a(c, true);
                            PropertyHelper.m21291b(c, String.valueOf(i4));
                        }
                    }
                    builder.m1069c(a26);
                }
            }
            ImmutableList<ClientFeedUnitEdge> b = builder.m1068b();
            query.close();
            if (query != null) {
                query.close();
            }
            return b;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (query != null) {
            if (th22 != null) {
                try {
                    query.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                query.close();
            }
        }
        throw th;
    }

    public final void m9164a(FeedType feedType, String str, ComparisonType comparisonType, EvictionReason evictionReason) {
        if (str != null) {
            ConjunctionExpression a = SqlExpression.m10722a();
            a.m10741a(Columns.f5265a.m2090a(feedType.m8961a()));
            switch (1.a[comparisonType.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    a.m10741a(Columns.f5269e.m2092b(String.valueOf(str)));
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    a.m10741a(Columns.f5269e.m2095c(String.valueOf(str)));
                    break;
                case 3:
                    a.m10741a(Columns.f5269e.m2097d(String.valueOf(str)));
                    break;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    a.m10741a(Columns.f5269e.m2099e(String.valueOf(str)));
                    break;
            }
            m9128a(a);
            int delete = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a().delete("home_stories", a.mo1476a(), a.mo1477b());
            m9130a("clearBySortKey", evictionReason);
            this.f5251g.mo1344a(evictionReason, delete, 0);
        }
    }

    private List<File> m9124a(File file) {
        if (file != null) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                List<File> arrayList = new ArrayList();
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        arrayList.addAll(m9124a(file2));
                    }
                    arrayList.add(file2);
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    private void m9130a(String str, EvictionReason evictionReason) {
        List<File> a = m9124a(this.f5257m);
        Cursor query = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a().query(true, "home_stories", new String[]{Columns.f5280p.toString()}, null, null, Columns.f5280p.toString(), null, null, null);
        try {
            int a2 = Columns.f5280p.m2089a(query);
            Collection a3 = Lists.m1296a();
            while (query.moveToNext()) {
                String string = query.getString(a2);
                if (!(string == null || string.isEmpty())) {
                    a3.add(new File(string));
                }
            }
            a.removeAll(a3);
            for (File file : a) {
                synchronized (this.f5258n) {
                    if (file.isFile() && !this.f5258n.contains(file.getAbsolutePath())) {
                        if (file.delete()) {
                            file.toString();
                        } else {
                            file.toString();
                        }
                    }
                }
            }
        } finally {
            query.close();
        }
    }

    public final void m9163a(FeedType feedType) {
        int delete;
        if (feedType != null) {
            Expression a = SqlExpression.m10727a(Columns.f5265a.toString(), feedType.toString());
            delete = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a().delete("home_stories", a.mo1476a(), a.mo1477b());
        } else {
            delete = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a().delete("home_stories", null, null);
        }
        ((FeedDatabaseSupplier) this.f5263s.f5396b.get()).mo2480a().delete("home_stories_media", null, null);
        m9130a("clearAllForFeedType", EvictionReason.CONTENT_STALE);
        if (feedType == null || FeedType.f5039b.equals(feedType)) {
            ColdStartPrimingInformation.a.a(null);
        }
        this.f5251g.mo1344a(EvictionReason.CONTENT_STALE, delete, 0);
    }

    private String m9139c(FeedType feedType, String str) {
        String str2 = null;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        a.m10741a(Columns.f5268d.m2090a(str));
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), new String[]{Columns.f5289y.toString()}, a.mo1476a(), a.mo1477b(), null, null, SqlColumn.f1022a.m2100e(), "1");
        try {
            if (query.moveToNext()) {
                str2 = query.getString(Columns.f5289y.m2089a(query));
            } else {
                query.close();
            }
            return str2;
        } finally {
            query.close();
        }
    }

    private ImmutableList<String> m9122a(FeedType feedType, List<String> list) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        a.m10741a(SqlExpression.m10728a(Columns.f5268d.toString(), (Collection) list));
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), new String[]{Columns.f5289y.toString()}, a.mo1476a(), a.mo1477b(), null, null, SqlColumn.f1022a.m2100e(), "1");
        Builder builder = ImmutableList.builder();
        try {
            int a2 = Columns.f5289y.m2089a(query);
            while (query.moveToNext()) {
                builder.m1069c(query.getString(a2));
            }
            return builder.m1068b();
        } finally {
            query.close();
        }
    }

    private String m9142d(String str) {
        String str2 = null;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10727a(Columns.f5288x.toString(), str);
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), new String[]{Columns.f5287w.toString()}, a.mo1476a(), a.mo1477b(), null, null, SqlColumn.f1022a.m2100e(), "1");
        try {
            if (query.moveToNext()) {
                str2 = query.getString(Columns.f5287w.m2089a(query));
            } else {
                query.close();
            }
            return str2;
        } finally {
            query.close();
        }
    }

    public final ImmutableList<Tuple<String, String>> m9170b(FeedType feedType) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        a.m10741a(Columns.f5277m.m2090a(Integer.toString(0)));
        String[] strArr = new String[]{Columns.f5268d.toString(), Columns.f5269e.toString()};
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), strArr, a.mo1476a(), a.mo1477b(), null, null, Columns.f5269e.m2100e(), String.valueOf(m9180e()));
        Builder builder = ImmutableList.builder();
        int a2 = Columns.f5268d.m2089a(query);
        int a3 = Columns.f5269e.m2089a(query);
        while (query.moveToNext()) {
            try {
                builder.m1069c(new Tuple(query.getString(a2), query.getString(a3)));
            } finally {
                query.close();
            }
        }
        return builder.m1068b();
    }

    public final FetchFeedResult m9159a(FetchFeedParams fetchFeedParams) {
        String uuid = SafeUUIDGenerator.m2795a().toString();
        this.f5250f.mo386b(655371, "NNFDbFeedLoadStories", uuid);
        try {
            FetchFeedResult fetchFeedResult;
            DbFeedResult b = m9137b(fetchFeedParams);
            if (b.a()) {
                fetchFeedResult = new FetchFeedResult(fetchFeedParams, b.b(), DataFreshnessResult.FROM_CACHE_STALE, b.c(), false);
            } else {
                fetchFeedResult = FetchFeedResult.m22436a(fetchFeedParams);
            }
            this.f5250f.mo376a(655371, "NNFDbFeedLoadStories", uuid);
            return fetchFeedResult;
        } catch (Throwable e) {
            throw new DiskCacheReadException(e);
        }
    }

    private DbFeedResult m9137b(FetchFeedParams fetchFeedParams) {
        DefaultFlatBufferCorruptionHandler g = m9147g();
        if (g.f14815b.mo286a(g.f14816c, false)) {
            m9163a(null);
            m9147g().m21222c();
            return DbFeedResult.a;
        }
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5265a.m2090a(fetchFeedParams.f5784b.toString()));
        long o = fetchFeedParams.m9921o();
        if (o != 0) {
            a.m10741a(Columns.f5266b.m2095c(Long.toString(this.f5253i.mo211a() - o)));
        }
        o = fetchFeedParams.m9922p();
        if (o != 0) {
            a.m10741a(Columns.f5266b.m2099e(Long.toString(this.f5253i.mo211a() - o)));
        }
        String e = Columns.f5287w.m2100e();
        String d;
        if (fetchFeedParams.f5787e != null) {
            d = m9142d(fetchFeedParams.f5787e);
            if (d == null) {
                return DbFeedResult.a;
            }
            a.m10741a(Columns.f5287w.m2092b(d));
        } else if (fetchFeedParams.f5786d != null) {
            d = m9142d(fetchFeedParams.f5786d);
            if (d == null) {
                return DbFeedResult.a;
            }
            a.m10741a(Columns.f5287w.m2097d(d));
            e = Columns.f5287w.m2098d();
        }
        return m9121a(sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), f5245b, a.mo1476a(), a.mo1477b(), null, null, e, String.valueOf(fetchFeedParams.f5785c)), fetchFeedParams);
    }

    private DbFeedResult m9121a(Cursor cursor, FetchFeedParams fetchFeedParams) {
        int a = Columns.f5266b.m2089a(cursor);
        int a2 = Columns.f5267c.m2089a(cursor);
        int a3 = Columns.f5265a.m2089a(cursor);
        int a4 = Columns.f5268d.m2089a(cursor);
        int a5 = Columns.f5269e.m2089a(cursor);
        int a6 = Columns.f5270f.m2089a(cursor);
        int a7 = Columns.f5271g.m2089a(cursor);
        int a8 = Columns.f5272h.m2089a(cursor);
        int a9 = Columns.f5275k.m2089a(cursor);
        int a10 = Columns.f5277m.m2089a(cursor);
        int a11 = Columns.f5279o.m2089a(cursor);
        int a12 = Columns.f5280p.m2089a(cursor);
        int a13 = Columns.f5281q.m2089a(cursor);
        int a14 = Columns.f5282r.m2089a(cursor);
        int a15 = Columns.f5283s.m2089a(cursor);
        int a16 = Columns.f5284t.m2089a(cursor);
        int a17 = Columns.f5285u.m2089a(cursor);
        int a18 = Columns.f5286v.m2089a(cursor);
        int a19 = Columns.f5287w.m2089a(cursor);
        int a20 = Columns.f5288x.m2089a(cursor);
        int a21 = Columns.f5273i.m2089a(cursor);
        int a22 = Columns.f5276l.m2089a(cursor);
        int a23 = Columns.f5274j.m2089a(cursor);
        int a24 = Columns.f5289y.m2089a(cursor);
        int a25 = Columns.f5290z.m2089a(cursor);
        try {
            DbFeedResult dbFeedResult;
            Builder builder = ImmutableList.builder();
            long j = -1;
            while (cursor.moveToNext()) {
                if (2 == cursor.getInt(a10)) {
                    if (!fetchFeedParams.m9920n()) {
                        break;
                    }
                    builder.m1069c(GapFactory.a(cursor.getString(a2), cursor.getString(a5), cursor.getString(a4), cursor.getString(a20), cursor.getString(a19), "Database_Gap"));
                } else {
                    boolean z;
                    ByteBuffer byteBuffer;
                    String string = cursor.getString(a12);
                    int i = cursor.getInt(a13);
                    int i2 = cursor.getInt(a14);
                    int i3 = cursor.getInt(a15);
                    if (cursor.getInt(a18) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ByteBuffer byteBuffer2 = null;
                    if (z) {
                        byte[] blob = cursor.getBlob(a16);
                        if (blob != null && blob.length > 0) {
                            byteBuffer2 = ByteBuffer.wrap(blob);
                        }
                        blob = cursor.getBlob(a17);
                        if (blob == null || blob.length <= 0) {
                            byteBuffer = byteBuffer2;
                            byteBuffer2 = null;
                        } else {
                            ByteBuffer wrap = ByteBuffer.wrap(blob);
                            byteBuffer = byteBuffer2;
                            byteBuffer2 = wrap;
                        }
                    } else {
                        byteBuffer = null;
                        byteBuffer2 = null;
                    }
                    String string2 = cursor.getString(a3);
                    String string3 = cursor.getString(a4);
                    String string4 = cursor.getString(a5);
                    String string5 = cursor.getString(a19);
                    String string6 = cursor.getString(a20);
                    String string7 = cursor.getString(a24);
                    boolean z2 = cursor.getInt(a8) == 1;
                    long j2 = cursor.getLong(a);
                    String string8 = cursor.getString(a11);
                    int i4 = cursor.getInt(a21);
                    int i5 = cursor.getInt(a22);
                    GraphQLFeedUnitEdge a26 = new ClientFeedUnitEdgeBuilder().m21169a(string4).m21163a(cursor.getDouble(a6)).m21189i(cursor.getString(a7)).m21176b(z2).m21174b(cursor.getString(a2)).m21167a(GraphQLBumpReason.BUMP_NONE).m21178c(string5).m21181d(string6).m21183e(string3).m21185f(string).m21177c(i).m21182e(i2).m21180d(i3).m21171a(z).m21170a(byteBuffer).m21175b(byteBuffer2).m21187g(string2).m21165a(j2).m21188h(string8).m21184f(cursor.getInt(a9)).m21186g(i4).m21164a(i5).m21172b(cursor.getInt(a23)).m21168a(m9147g()).m21166a(this.f5259o).m21190j(string7).m21173b(cursor.getLong(a25)).m21162a();
                    if (string7 != null) {
                        PropertyHelper.m21271a(a26, this.f5263s.m9291b(string7));
                    }
                    FeedUnit feedUnit = null;
                    try {
                        feedUnit = a26.mo2540c();
                    } catch (Throwable e) {
                        BLog.a(f5244a, e, "Not able to load feed unit", new Object[0]);
                    }
                    if (feedUnit != null) {
                        builder.m1069c(a26);
                        j = j2;
                    } else {
                        j = j2;
                    }
                }
            }
            ImmutableList b = builder.m1068b();
            if (b.isEmpty()) {
                dbFeedResult = DbFeedResult.a;
            } else {
                dbFeedResult = new DbFeedResult(new GraphQLFeedHomeStories.Builder().m22421a(b).m22420a(GraphQLHelper.m22460a(((GraphQLFeedUnitEdge) b.get(0)).W_(), ((GraphQLFeedUnitEdge) b.get(b.size() - 1)).W_(), true, false)).m22424a(), j);
                cursor.close();
            }
            return dbFeedResult;
        } finally {
            cursor.close();
        }
    }

    public final void m9168a(String str, String str2, String str3, String str4, byte[] bArr, byte[] bArr2) {
        SQLiteDatabase a = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a();
        ContentValues contentValues = new ContentValues();
        if (bArr != null) {
            contentValues.put(Columns.f5284t.m2091a(), bArr);
        }
        if (bArr2 != null) {
            contentValues.put(Columns.f5285u.m2091a(), bArr2);
        }
        Object obj = null;
        try {
            SQLiteDetour.a(a, -168492171);
            a.update("home_stories", contentValues, Columns.f5268d.m2091a() + " = ? AND " + Columns.f5269e.m2091a() + " = ? AND " + Columns.f5265a.m2091a() + " = ? AND " + Columns.f5266b.m2091a() + " = ?", new String[]{str2, str3, str, str4});
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, 1605289933);
        } catch (Throwable e) {
            int length = bArr != null ? bArr.length : 0;
            int length2 = bArr2 != null ? bArr2.length : 0;
            BLog.c(f5244a, e, "Error mutating a story. mutationLength=%d, extraLength=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(length2)});
            if (e instanceof SQLiteFullException) {
                obj = 1;
            }
            SQLiteDetour.b(a, -546861480);
        } catch (Throwable th) {
            SQLiteDetour.b(a, 1688821390);
        }
        if (obj != null) {
            ai_();
        }
    }

    public final int m9157a(String str, int i) {
        return m9118a(Columns.f5289y, str, i);
    }

    public final int m9169b(String str, int i) {
        return m9118a(Columns.f5268d, str, i);
    }

    private int m9118a(SqlColumn sqlColumn, String str, int i) {
        SQLiteDatabase a = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f5273i.m2091a(), Integer.valueOf(1));
        contentValues.put(Columns.f5274j.m2091a(), Integer.valueOf(i));
        int i2 = 0;
        Expression a2 = SqlExpression.m10727a(sqlColumn.m2091a(), str);
        try {
            i2 = a.update("home_stories", contentValues, a2.mo1476a(), a2.mo1477b());
            if (i2 == 0) {
                sqlColumn.m2091a();
            }
        } catch (SQLiteFullException e) {
            ai_();
        } catch (Throwable e2) {
            BLog.b(f5244a, "Update operation failed!", e2);
        }
        return i2;
    }

    public final void m9167a(String str, String str2, int i) {
        try {
            this.f5263s.m9290a(str, str2, i);
        } catch (SQLiteFullException e) {
            ai_();
        } catch (Throwable e2) {
            BLog.b(f5244a, "Update operation failed!", e2);
        }
    }

    public final void m9166a(String str, String str2) {
        try {
            this.f5263s.m9289a(str, str2);
        } catch (SQLiteFullException e) {
            ai_();
        } catch (Throwable e2) {
            BLog.b(f5244a, "Update/Insert operation failed!", e2);
        } catch (Throwable e22) {
            BLog.b(f5244a, "exception", e22);
        }
    }

    private List<SerializedFeedUnitInfo> m9125a(List<GraphQLFeedUnitEdge> list, String str, long j) {
        Throwable e;
        Object obj;
        int i;
        int length;
        List<SerializedFeedUnitInfo> b = Lists.m1305b(list.size());
        if (list.isEmpty()) {
            return b;
        }
        File f = m9145f(str + "_" + j);
        FileOutputStream fileOutputStream = new FileOutputStream(f, true);
        synchronized (this.f5258n) {
            this.f5258n.add(f.getCanonicalPath());
        }
        long length2 = f != null ? f.length() : 0;
        int i2 = -1;
        Object obj2 = null;
        try {
            int i3 = 0;
            long j2 = length2;
            long j3 = length2;
            for (GraphQLFeedUnitEdge c : list) {
                int i4;
                Object obj3;
                int i5;
                byte[] bArr;
                int i6;
                long j4;
                Flattenable c2 = c.mo2540c();
                try {
                    if (c2.w_() != null) {
                        MutableFlatBuffer w_ = c2.w_();
                        byte[] array;
                        if (w_.m21541b(4) == null || !w_.m21541b(4).equals(Boolean.valueOf(true))) {
                            try {
                                array = c2.w_().m21533a().array();
                                if (FlatBuffer.m4026a(w_.m21533a()) == 0) {
                                    BLog.c("FlatBuffer", "Trying to write flatbuffer with zero rootObjectPosition");
                                    array = FlatBufferBuilder.m21464b(c2, VirtualFlattenableResolverImpl.f15617a);
                                }
                                i4 = 0;
                                obj3 = obj2;
                                i5 = i2;
                                bArr = array;
                            } catch (Exception e2) {
                                e = e2;
                                obj = obj2;
                                i = 0;
                                BLog.c("FlatBuffer", e, "Error serializing feed unit to flatbuffer", new Object[0]);
                                i4 = i;
                                obj3 = obj;
                                i5 = i2;
                                bArr = null;
                                if (bArr != null) {
                                    fileOutputStream.write(bArr);
                                    length = bArr.length;
                                    Integer.valueOf(FlatBuffer.m4026a(ByteBuffer.wrap(bArr)));
                                    i3 = length;
                                    i6 = length;
                                    j4 = j3;
                                } else {
                                    i6 = i3;
                                    j4 = j2;
                                    i3 = 0;
                                }
                                b.add(new SerializedFeedUnitInfo(f.getAbsolutePath(), j4, i6, i4));
                                Integer.valueOf(i4);
                                i3 = i6;
                                j2 = j4;
                                j3 = ((long) i3) + j3;
                                i2 = i5;
                                obj2 = obj3;
                            }
                            if (bArr != null) {
                                fileOutputStream.write(bArr);
                                length = bArr.length;
                                Integer.valueOf(FlatBuffer.m4026a(ByteBuffer.wrap(bArr)));
                                i3 = length;
                                i6 = length;
                                j4 = j3;
                            } else {
                                i6 = i3;
                                j4 = j2;
                                i3 = 0;
                            }
                            b.add(new SerializedFeedUnitInfo(f.getAbsolutePath(), j4, i6, i4));
                            Integer.valueOf(i4);
                            i3 = i6;
                            j2 = j4;
                            j3 = ((long) i3) + j3;
                            i2 = i5;
                            obj2 = obj3;
                        } else {
                            Object obj4;
                            if (i2 == System.identityHashCode(w_)) {
                                obj4 = 1;
                            } else {
                                obj4 = null;
                            }
                            i2 = System.identityHashCode(w_);
                            if (obj4 == null) {
                                obj = w_.m21529a(VirtualFlattenableResolverImpl.f15617a);
                            } else {
                                obj = obj2;
                            }
                            try {
                                if (obj instanceof GraphQLViewer) {
                                    i = m9116a(c2.u_(), w_, (GraphQLViewer) obj);
                                    array = null;
                                } else if (obj instanceof FeedUnit) {
                                    i = FlatBuffer.m4026a(w_.m21533a());
                                    array = null;
                                } else if (obj instanceof GraphQLFeedHomeStories) {
                                    i = m9115a(c2.u_(), w_, (GraphQLFeedHomeStories) obj);
                                    array = null;
                                } else {
                                    String str2;
                                    String str3 = "FlatBuffer";
                                    String str4 = "unable to determine root object of flatbuffer: class = %s";
                                    String[] strArr = new Object[1];
                                    if (obj == null) {
                                        str2 = "null";
                                    } else {
                                        str2 = obj.getClass().getCanonicalName();
                                    }
                                    strArr[0] = str2;
                                    BLog.c(str3, str4, strArr);
                                    i = 0;
                                    array = FlatBufferBuilder.m21464b(c2, VirtualFlattenableResolverImpl.f15617a);
                                }
                                if (i != 0 && obj4 == null) {
                                    try {
                                        array = c2.w_().m21533a().array();
                                    } catch (Exception e3) {
                                        e = e3;
                                        BLog.c("FlatBuffer", e, "Error serializing feed unit to flatbuffer", new Object[0]);
                                        i4 = i;
                                        obj3 = obj;
                                        i5 = i2;
                                        bArr = null;
                                        if (bArr != null) {
                                            i6 = i3;
                                            j4 = j2;
                                            i3 = 0;
                                        } else {
                                            fileOutputStream.write(bArr);
                                            length = bArr.length;
                                            Integer.valueOf(FlatBuffer.m4026a(ByteBuffer.wrap(bArr)));
                                            i3 = length;
                                            i6 = length;
                                            j4 = j3;
                                        }
                                        b.add(new SerializedFeedUnitInfo(f.getAbsolutePath(), j4, i6, i4));
                                        Integer.valueOf(i4);
                                        i3 = i6;
                                        j2 = j4;
                                        j3 = ((long) i3) + j3;
                                        i2 = i5;
                                        obj2 = obj3;
                                    }
                                }
                                int i7 = i;
                                obj2 = obj;
                                bArr = array;
                                length = i7;
                            } catch (Exception e4) {
                                e = e4;
                                i = 0;
                                BLog.c("FlatBuffer", e, "Error serializing feed unit to flatbuffer", new Object[0]);
                                i4 = i;
                                obj3 = obj;
                                i5 = i2;
                                bArr = null;
                                if (bArr != null) {
                                    fileOutputStream.write(bArr);
                                    length = bArr.length;
                                    Integer.valueOf(FlatBuffer.m4026a(ByteBuffer.wrap(bArr)));
                                    i3 = length;
                                    i6 = length;
                                    j4 = j3;
                                } else {
                                    i6 = i3;
                                    j4 = j2;
                                    i3 = 0;
                                }
                                b.add(new SerializedFeedUnitInfo(f.getAbsolutePath(), j4, i6, i4));
                                Integer.valueOf(i4);
                                i3 = i6;
                                j2 = j4;
                                j3 = ((long) i3) + j3;
                                i2 = i5;
                                obj2 = obj3;
                            }
                        }
                    } else {
                        length = 0;
                        try {
                            bArr = FlatBufferBuilder.m21464b(c2, VirtualFlattenableResolverImpl.f15617a);
                        } catch (Throwable e5) {
                            Throwable th = e5;
                            obj = obj2;
                            i = 0;
                            e = th;
                            BLog.c("FlatBuffer", e, "Error serializing feed unit to flatbuffer", new Object[0]);
                            i4 = i;
                            obj3 = obj;
                            i5 = i2;
                            bArr = null;
                            if (bArr != null) {
                                fileOutputStream.write(bArr);
                                length = bArr.length;
                                Integer.valueOf(FlatBuffer.m4026a(ByteBuffer.wrap(bArr)));
                                i3 = length;
                                i6 = length;
                                j4 = j3;
                            } else {
                                i6 = i3;
                                j4 = j2;
                                i3 = 0;
                            }
                            b.add(new SerializedFeedUnitInfo(f.getAbsolutePath(), j4, i6, i4));
                            Integer.valueOf(i4);
                            i3 = i6;
                            j2 = j4;
                            j3 = ((long) i3) + j3;
                            i2 = i5;
                            obj2 = obj3;
                        }
                    }
                    i4 = length;
                    obj3 = obj2;
                    i5 = i2;
                } catch (Exception e6) {
                    e = e6;
                    obj = obj2;
                    i = 0;
                    BLog.c("FlatBuffer", e, "Error serializing feed unit to flatbuffer", new Object[0]);
                    i4 = i;
                    obj3 = obj;
                    i5 = i2;
                    bArr = null;
                    if (bArr != null) {
                        i6 = i3;
                        j4 = j2;
                        i3 = 0;
                    } else {
                        fileOutputStream.write(bArr);
                        length = bArr.length;
                        Integer.valueOf(FlatBuffer.m4026a(ByteBuffer.wrap(bArr)));
                        i3 = length;
                        i6 = length;
                        j4 = j3;
                    }
                    b.add(new SerializedFeedUnitInfo(f.getAbsolutePath(), j4, i6, i4));
                    Integer.valueOf(i4);
                    i3 = i6;
                    j2 = j4;
                    j3 = ((long) i3) + j3;
                    i2 = i5;
                    obj2 = obj3;
                }
                if (bArr != null) {
                    i6 = i3;
                    j4 = j2;
                    i3 = 0;
                } else {
                    fileOutputStream.write(bArr);
                    length = bArr.length;
                    Integer.valueOf(FlatBuffer.m4026a(ByteBuffer.wrap(bArr)));
                    i3 = length;
                    i6 = length;
                    j4 = j3;
                }
                b.add(new SerializedFeedUnitInfo(f.getAbsolutePath(), j4, i6, i4));
                Integer.valueOf(i4);
                i3 = i6;
                j2 = j4;
                j3 = ((long) i3) + j3;
                i2 = i5;
                obj2 = obj3;
            }
            return b;
        } finally {
            fileOutputStream.close();
        }
    }

    private static int m9116a(int i, MutableFlatBuffer mutableFlatBuffer, GraphQLViewer graphQLViewer) {
        ImmutableList j;
        int i2 = 0;
        if (graphQLViewer.m11333A() != null) {
            j = graphQLViewer.m11333A().m22216j();
        } else {
            j = graphQLViewer.m11359q().a();
        }
        if (j == null) {
            BLog.c("FlatBuffer", "root viewer object contains no edges");
        }
        int size = j.size();
        for (int i3 = 0; i3 < size; i3++) {
            i2 = mutableFlatBuffer.m21560g(((MutableFlattenable) ((NewsFeedEdge) j.get(i3))).u_(), 6);
            if (i == mutableFlatBuffer.m21560g(i2, 1)) {
                break;
            }
        }
        return i2;
    }

    private static int m9115a(int i, MutableFlatBuffer mutableFlatBuffer, GraphQLFeedHomeStories graphQLFeedHomeStories) {
        int i2 = 0;
        ImmutableList k = graphQLFeedHomeStories.m22430k();
        if (k == null) {
            BLog.c("FlatBuffer", "root viewer object contains no edges");
        }
        int size = k.size();
        for (int i3 = 0; i3 < size; i3++) {
            i2 = mutableFlatBuffer.m21560g(((GraphQLFeedUnitEdge) k.get(i3)).u_(), 5);
            if (i == mutableFlatBuffer.m21560g(i2, 1)) {
                break;
            }
        }
        return i2;
    }

    private DefaultFlatBufferCorruptionHandler m9147g() {
        if (this.f5256l == null) {
            this.f5256l = this.f5255k.m8185a(FeedPrefKeys.f5758v);
        }
        return this.f5256l;
    }

    public final String m9175c(FeedType feedType) {
        String str = null;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        a.m10741a(Columns.f5277m.m2090a(Integer.toString(0)));
        long h = m9149h();
        if (h >= 0) {
            a.m10741a(Columns.f5266b.m2099e(Long.toString(this.f5253i.mo211a() - h)));
        }
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), f5246c, a.mo1476a(), a.mo1477b(), null, null, Columns.f5287w.m2100e(), "1");
        int a2 = Columns.f5288x.m2089a(query);
        try {
            if (query.moveToNext()) {
                str = query.getString(a2);
            } else {
                query.close();
            }
            return str;
        } finally {
            query.close();
        }
    }

    private long m9149h() {
        return TimeUnit.HOURS.toMillis((long) this.f5254j.m8197i());
    }

    public final String m9162a(String str, FeedType feedType) {
        String str2 = null;
        String d = m9142d(str);
        if (d != null) {
            SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
            sQLiteQueryBuilder.setTables("home_stories");
            Expression a = SqlExpression.m10722a();
            a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
            a.m10741a(Columns.f5287w.m2092b(d));
            a.m10741a(Columns.f5277m.m2090a(Integer.toString(2)));
            Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), f5246c, a.mo1476a(), a.mo1477b(), null, null, Columns.f5287w.m2100e(), "1");
            int a2 = Columns.f5288x.m2089a(query);
            try {
                if (query.moveToNext()) {
                    str2 = query.getString(a2);
                } else {
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return str2;
    }

    public final void m9177c(String str) {
        if (str != null) {
            String d = m9142d(str);
            if (d != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(Columns.f5275k.f1025d, Integer.valueOf(0));
                Expression a = SqlExpression.m10722a();
                a.m10741a(Columns.f5275k.m2090a("1"));
                a.m10741a(Columns.f5287w.m2095c(d));
                ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a().update("home_stories", contentValues, a.mo1476a(), a.mo1477b());
            }
        }
    }

    public static void m9126a(FetchFeedResult fetchFeedResult) {
        if (fetchFeedResult.m22439d() != null) {
            ImmutableList d = fetchFeedResult.m22439d();
            int size = d.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3;
                GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) d.get(i);
                FeedUnit c = graphQLFeedUnitEdge.mo2540c();
                if (c != null) {
                    try {
                        if (c.w_() == null) {
                            c = (FeedUnit) GraphQLModelFlatbufferHelper.a(c);
                            graphQLFeedUnitEdge.m19077a(c);
                        }
                    } catch (Throwable e) {
                        if (i2 == 0) {
                            BLog.c("FlatBuffer", e, "Error serializing feed unit to flatbuffer", new Object[0]);
                            i3 = 1;
                        } else {
                            i3 = i2;
                        }
                    }
                }
                if (c != null) {
                    m9129a(c, fetchFeedResult.m22442g().m9913f().toString(), GraphQLHelper.m22472a(graphQLFeedUnitEdge), graphQLFeedUnitEdge.m19084d(), String.valueOf(fetchFeedResult.m10405b()));
                }
                i3 = i2;
                i++;
                i2 = i3;
            }
        }
    }

    private static void m9129a(FeedUnit feedUnit, String str, String str2, String str3, String str4) {
        MutableFlatBuffer w_ = feedUnit.w_();
        if (w_ != null && w_.m21541b(1) == null) {
            w_.m21539a(0, (Object) str);
            w_.m21539a(1, (Object) str2);
            w_.m21539a(2, (Object) str3);
            w_.m21539a(3, (Object) str4);
        }
    }

    private void m9143d(FetchFeedResult fetchFeedResult) {
        FeedType f = fetchFeedResult.m22442g().m9913f();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5265a.m2090a(f.toString()));
        a.m10741a(Columns.f5277m.m2090a(Integer.toString(2)));
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), f5246c, a.mo1476a(), a.mo1477b(), null, null, Columns.f5287w.m2100e(), "1");
        int a2 = Columns.f5288x.m2089a(query);
        try {
            if (query.moveToNext()) {
                m9141d(f, query.getString(a2));
            }
            query.close();
        } catch (Throwable th) {
            query.close();
        }
    }

    public final void m9176c(FetchFeedResult fetchFeedResult) {
        FetchFeedParams g = fetchFeedResult.m22442g();
        FeedType f = g.m9913f();
        m9173b(fetchFeedResult);
        if (fetchFeedResult.m22440e() != null && IsValidUtil.m22952a(fetchFeedResult.m22440e())) {
            SQLiteDatabase a = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a();
            List d = fetchFeedResult.m22439d();
            List a2 = m9125a(d, f.toString(), fetchFeedResult.m10405b());
            boolean c = m9140c(g);
            Object obj = (g.m9914h() == FetchFeedCause.PREFETCH || !c) ? null : 1;
            HashSet j;
            if (obj != null) {
                j = m9152j(f);
            } else {
                j = null;
            }
            List arrayList = new ArrayList();
            ContentValues contentValues = new ContentValues(25);
            SQLiteDetour.a(a, 605340578);
            int i = 0;
            while (i < d.size()) {
                try {
                    GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) d.get(i);
                    String a3 = DedupableUtil.m23084a(graphQLFeedUnitEdge);
                    if (obj != null && r5 != null && r5.contains(a3) && m9133a(graphQLFeedUnitEdge.m19090m())) {
                        arrayList.add(a3);
                    }
                    FeedUnit c2 = graphQLFeedUnitEdge.mo2540c();
                    PropertyHelper.m21296c(c2, a3);
                    PropertyHelper.m21299d(c2, graphQLFeedUnitEdge.m19084d());
                    PropertyHelper.m21269a(c2, false);
                    if (c2 instanceof GraphQLStory) {
                        contentValues.put(Columns.f5290z.toString(), Long.valueOf(((GraphQLStory) c2).aZ()));
                    }
                    this.f5261q.m9283a(g, i, a3, this.f5262r);
                    contentValues.put(Columns.f5265a.toString(), f.toString());
                    contentValues.put(Columns.f5266b.toString(), Long.valueOf(fetchFeedResult.m10405b()));
                    contentValues.put(Columns.f5267c.toString(), graphQLFeedUnitEdge.m19086g());
                    contentValues.put(Columns.f5268d.toString(), DedupableUtil.m23084a(graphQLFeedUnitEdge));
                    contentValues.put(Columns.f5269e.toString(), graphQLFeedUnitEdge.m19084d());
                    contentValues.put(Columns.f5287w.toString(), graphQLFeedUnitEdge.V_());
                    contentValues.put(Columns.f5288x.toString(), graphQLFeedUnitEdge.W_());
                    contentValues.put(Columns.f5270f.toString(), Double.valueOf(graphQLFeedUnitEdge.X_()));
                    contentValues.put(Columns.f5271g.toString(), graphQLFeedUnitEdge.m19088k());
                    contentValues.put(Columns.f5272h.toString(), Integer.valueOf(graphQLFeedUnitEdge.m19089l() ? 1 : 0));
                    contentValues.put(Columns.f5273i.toString(), Integer.valueOf(0));
                    contentValues.put(Columns.f5274j.toString(), Integer.valueOf(0));
                    contentValues.put(Columns.f5276l.toString(), Integer.valueOf(0));
                    contentValues.put(Columns.f5277m.toString(), Integer.valueOf(0));
                    contentValues.put(Columns.f5279o.toString(), ClientFeedUnitEdgeStoryTypeClassifier.m25093a(graphQLFeedUnitEdge));
                    SerializedFeedUnitInfo serializedFeedUnitInfo = (SerializedFeedUnitInfo) a2.get(i);
                    contentValues.put(Columns.f5280p.toString(), serializedFeedUnitInfo.a);
                    contentValues.put(Columns.f5281q.toString(), Long.valueOf(serializedFeedUnitInfo.b));
                    contentValues.put(Columns.f5282r.toString(), Integer.valueOf(serializedFeedUnitInfo.c));
                    contentValues.put(Columns.f5283s.toString(), Integer.valueOf(serializedFeedUnitInfo.d));
                    contentValues.putNull(Columns.f5284t.toString());
                    contentValues.putNull(Columns.f5285u.toString());
                    contentValues.put(Columns.f5286v.toString(), Integer.valueOf(1));
                    if ((c2 instanceof GraphQLStory) && ((GraphQLStory) c2).ah()) {
                        contentValues.put(Columns.f5275k.toString(), Boolean.valueOf(PropertyHelper.m21308j((GraphQLStory) c2)));
                    } else {
                        contentValues.putNull(Columns.f5275k.toString());
                    }
                    contentValues.put(Columns.f5289y.toString(), c2.mo2507g());
                    if (c2 instanceof GraphQLStory) {
                        contentValues.put(Columns.f5290z.toString(), Long.valueOf(((GraphQLStory) c2).aZ()));
                    } else {
                        contentValues.put(Columns.f5290z.toString(), Long.valueOf(0));
                    }
                    Preconditions.checkState(contentValues.size() <= 25);
                    int i2 = c ? 5 : 4;
                    SQLiteDetour.a(1105778083);
                    a.insertWithOnConflict("home_stories", "", contentValues, i2);
                    SQLiteDetour.a(141031359);
                    i++;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    SQLiteDetour.b(a, -1642529253);
                    if (!a2.isEmpty()) {
                        synchronized (this.f5258n) {
                            this.f5258n.remove(((SerializedFeedUnitInfo) a2.get(0)).a);
                        }
                    }
                }
            }
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, 707400499);
            if (!a2.isEmpty()) {
                synchronized (this.f5258n) {
                    this.f5258n.remove(((SerializedFeedUnitInfo) a2.get(0)).a);
                }
            }
            if (FeedType.f5039b.equals(f) && g.m9911d() == null) {
                ColdStartPrimingInformation.a().a(m9175c(FeedType.f5039b));
            }
            m9138b(fetchFeedResult, a);
            if (obj != null) {
                m9158a(arrayList, f);
            }
            m9151i(f);
        }
    }

    private static boolean m9133a(GraphQLBumpReason graphQLBumpReason) {
        return GraphQLBumpReason.BUMP_UNREAD == graphQLBumpReason;
    }

    private boolean m9132a(FetchFeedResult fetchFeedResult, SQLiteDatabase sQLiteDatabase) {
        if (!m9144e(fetchFeedResult)) {
            return false;
        }
        FeedType f = fetchFeedResult.m22442g().m9913f();
        GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) fetchFeedResult.m22439d().get(0);
        GraphQLFeedUnitEdge graphQLFeedUnitEdge2 = (GraphQLFeedUnitEdge) fetchFeedResult.m22439d().get(fetchFeedResult.m22439d().size() - 1);
        SQLiteDetour.a(sQLiteDatabase, 310103187);
        try {
            Expression a = SqlExpression.m10722a();
            a.m10741a(Columns.f5287w.m2095c(GapFactory.a(graphQLFeedUnitEdge.V_())));
            a.m10741a(Columns.f5287w.m2099e(graphQLFeedUnitEdge2.V_()));
            a.m10741a(Columns.f5277m.m2090a(Integer.toString(2)));
            a.m10741a(Columns.f5265a.m2090a(f.toString()));
            Object delete = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a().delete("home_stories", a.mo1476a(), a.mo1477b());
            sQLiteDatabase.setTransactionSuccessful();
            if (delete > null) {
                return true;
            }
            return false;
        } finally {
            SQLiteDetour.b(sQLiteDatabase, 1210739974);
        }
    }

    private void m9128a(ConjunctionExpression conjunctionExpression) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), new String[]{Columns.f5289y.toString()}, conjunctionExpression.mo1476a(), conjunctionExpression.mo1477b(), null, null, null);
        Collection arrayList = new ArrayList(query.getCount());
        while (query.moveToNext()) {
            try {
                if (query.getString(0) != null) {
                    arrayList.add(query.getString(0));
                }
            } finally {
                query.close();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f5263s.m9287a(ImmutableList.copyOf(arrayList));
        }
    }

    private void m9138b(FetchFeedResult fetchFeedResult, SQLiteDatabase sQLiteDatabase) {
        Cursor a;
        IllegalArgumentException e;
        FetchFeedParams g = fetchFeedResult.m22442g();
        FeedType f = g.m9913f();
        if (m9146f(fetchFeedResult)) {
            a = m9119a(f, ((GraphQLFeedUnitEdge) fetchFeedResult.m22439d().get(fetchFeedResult.m22439d().size() - 1)).m19084d(), 1);
            try {
                if (!a.moveToNext() || m9131a(a)) {
                    a.close();
                    a.close();
                    return;
                }
                int a2 = Columns.f5269e.m2089a(a);
                GraphQLFeedUnitEdge a3 = GapFactory.a(a.getString(Columns.f5267c.m2089a(a)), a.getString(a2), a.getString(Columns.f5268d.m2089a(a)), a.getString(Columns.f5288x.m2089a(a)), a.getString(Columns.f5287w.m2089a(a)), "Database_Gap");
                a.close();
                if (a3 == null) {
                    throw new IllegalStateException("null gap feed edge");
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(Columns.f5265a.toString(), f.toString());
                contentValues.put(Columns.f5266b.toString(), Long.valueOf(fetchFeedResult.m10405b()));
                contentValues.put(Columns.f5277m.toString(), Integer.valueOf(2));
                contentValues.put(Columns.f5279o.toString(), "Gap");
                contentValues.put(Columns.f5268d.toString(), DedupableUtil.m23084a(a3));
                contentValues.put(Columns.f5269e.toString(), a3.m19084d());
                contentValues.put(Columns.f5267c.toString(), a3.m19086g());
                contentValues.put(Columns.f5287w.toString(), a3.V_());
                contentValues.put(Columns.f5288x.toString(), a3.W_());
                int i = m9140c(g) ? 5 : 4;
                SQLiteDetour.a(sQLiteDatabase, -505601654);
                try {
                    SQLiteDetour.a(172894246);
                    sQLiteDatabase.insertWithOnConflict("home_stories", "", contentValues, i);
                    SQLiteDetour.a(-148312906);
                    sQLiteDatabase.setTransactionSuccessful();
                    return;
                } finally {
                    SQLiteDetour.b(sQLiteDatabase, -140597965);
                }
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw e;
            } catch (Exception e3) {
                e = e3;
                a.close();
                return;
            } catch (Throwable th) {
                e = th;
            }
        } else {
            return;
        }
        a.close();
    }

    private int m9117a(FeedType feedType, int i, boolean z) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        a.m10741a(Columns.f5273i.m2090a(String.valueOf(i)));
        if (!z) {
            Expression b = SqlExpression.m10730b();
            b.m10741a(Columns.f5279o.m2090a("Page"));
            b.m10741a(Columns.f5279o.m2090a("User"));
            a.m10741a(b);
        }
        a.m10741a(Columns.f5277m.m2090a("0"));
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), new String[]{"COUNT(" + Columns.f5273i.toString() + ")"}, a.mo1476a(), a.mo1477b(), null, null, null);
        try {
            int i2;
            if (query.moveToFirst()) {
                i2 = query.getInt(0);
            } else {
                i2 = 0;
            }
            query.close();
            return i2;
        } catch (Throwable th) {
            query.close();
        }
    }

    public final int m9154a(FeedType feedType, boolean z) {
        return m9117a(feedType, 0, z);
    }

    public final int m9178d(FeedType feedType) {
        return m9114a(2, feedType);
    }

    private int m9114a(int i, FeedType feedType) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        a.m10741a(Columns.f5277m.m2090a(Integer.toString(i)));
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), new String[]{"COUNT()"}, a.mo1476a(), a.mo1477b(), null, null, null);
        try {
            int i2;
            if (query.moveToFirst()) {
                i2 = query.getInt(0);
            } else {
                i2 = 0;
            }
            query.close();
            return i2;
        } catch (Throwable th) {
            query.close();
        }
    }

    private static boolean m9131a(Cursor cursor) {
        return cursor.getInt(Columns.f5277m.m2089a(cursor)) == 2;
    }

    public final void ai_() {
        m9150i();
        m9134b(FeedType.f5039b, TimeUnit.HOURS.toMillis((long) this.f5254j.m8197i()));
        String[] strArr = new String[]{Columns.f5265a.toString(), "count(" + Columns.f5265a.toString() + ")"};
        Cursor query = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a().query("home_stories".toString(), strArr, null, null, Columns.f5265a.toString(), null, null);
        int e = this.f5254j.m8193e();
        while (query.moveToNext()) {
            try {
                if (query.getInt(1) > e) {
                    m9127a(new FeedType(query.getString(0), null), e);
                }
            } finally {
                query.close();
            }
        }
        m9153j();
    }

    public final void mo1323b() {
        ai_();
    }

    private void m9150i() {
        try {
            SQLiteDatabase a = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a();
            if (!a.inTransaction()) {
                SQLiteDetour.a(1045441559);
                a.execSQL("VACUUM");
                SQLiteDetour.a(1666770037);
            }
        } catch (Throwable e) {
            BLog.b(f5244a, "Vacuum failed due to SQLite disk too full", e);
        } catch (Throwable e2) {
            BLog.b(f5244a, "Vacuum failed", e2);
        }
    }

    @VisibleForTesting
    public final long m9181e(FeedType feedType) {
        long j = " = ?";
        SQLiteStatement compileStatement = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a().compileStatement("select count(" + Columns.f5265a + ") from home_stories" + " where " + Columns.f5265a + j);
        try {
            compileStatement.bindString(1, feedType.toString());
            SQLiteDetour.a(2141748561);
            j = compileStatement.simpleQueryForLong();
            SQLiteDetour.a(-1753393743);
            return j;
        } finally {
            compileStatement.close();
        }
    }

    private void m9151i(FeedType feedType) {
        if (m9181e(feedType) > ((long) m9180e())) {
            m9127a(feedType, m9180e());
        }
    }

    public final int m9180e() {
        return ((Integer) this.f5252h.get()).intValue();
    }

    private void m9127a(FeedType feedType, int i) {
        Preconditions.checkArgument(i > 0);
        Expression a = SqlExpression.m10727a(Columns.f5265a.toString(), feedType.toString());
        Cursor query = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a().query("home_stories".toString(), new String[]{Columns.f5287w.toString()}, a.mo1476a(), a.mo1477b(), null, null, Columns.f5287w.m2100e(), String.valueOf(i));
        int a2 = Columns.f5287w.m2089a(query);
        try {
            query.moveToLast();
            m9164a(feedType, query.getString(a2), ComparisonType.LT, EvictionReason.CACHE_FULL);
        } finally {
            query.close();
        }
    }

    private void m9153j() {
        Expression b = SqlExpression.m10733b(Columns.f5266b.toString(), String.valueOf(this.f5253i.mo211a() - 604800000));
        Expression b2 = SqlExpression.m10734b(Columns.f5265a.toString(), this.f5248d);
        ConjunctionExpression a = SqlExpression.m10723a(b, b2);
        m9128a(a);
        int delete = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a().delete("home_stories", a.mo1476a(), a.mo1477b());
        m9130a("evictStaleStories", EvictionReason.CONTENT_STALE);
        this.f5251g.mo1344a(EvictionReason.CONTENT_STALE, delete, 0);
    }

    private Cursor m9119a(FeedType feedType, String str, int i) {
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(i > 0);
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5287w.m2092b(str));
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        return sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), f5245b, a.mo1476a(), a.mo1477b(), null, null, Columns.f5287w.m2100e(), String.valueOf(i));
    }

    private int m9141d(FeedType feedType, String str) {
        ConjunctionExpression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        a.m10741a(Columns.f5277m.m2090a(Integer.toString(2)));
        a.m10741a(Columns.f5288x.m2090a(str));
        m9128a(a);
        return ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a().delete("home_stories", a.mo1476a(), a.mo1477b());
    }

    public final String m9171b(FeedType feedType, String str) {
        Preconditions.checkNotNull(str);
        Cursor b = m9135b(feedType, str, 1);
        int a = Columns.f5288x.m2089a(b);
        String str2 = null;
        try {
            if (b.moveToNext()) {
                str2 = b.getString(a);
            }
            b.close();
            return str2;
        } catch (Throwable th) {
            b.close();
        }
    }

    private Cursor m9135b(FeedType feedType, String str, int i) {
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(i > 0);
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5287w.m2097d(str));
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        return sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), f5245b, a.mo1476a(), a.mo1477b(), null, null, Columns.f5287w.m2100e(), String.valueOf(i));
    }

    public final String m9182f(FeedType feedType) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        String[] strArr = new String[]{Columns.f5267c.toString(), Columns.f5268d.toString(), Columns.f5269e.toString(), Columns.f5277m.toString()};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cache_size: " + m9181e(feedType) + "\n");
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), strArr, a.mo1476a(), a.mo1477b(), null, null, Columns.f5269e.m2100e(), "100");
        int a2 = Columns.f5267c.m2089a(query);
        int a3 = Columns.f5268d.m2089a(query);
        int a4 = Columns.f5269e.m2089a(query);
        int a5 = Columns.f5277m.m2089a(query);
        while (query.moveToNext()) {
            try {
                stringBuilder.append(query.getInt(a5) + " :\t ");
                stringBuilder.append(query.getString(a2) + " :\t ");
                stringBuilder.append(query.getString(a3) + " :\t ");
                stringBuilder.append(query.getString(a4) + "\n");
            } finally {
                query.close();
            }
        }
        return stringBuilder.toString();
    }

    public final String m9183g(FeedType feedType) {
        String str = null;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5277m.m2090a(Integer.toString(0)));
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), f5245b, a.mo1476a(), a.mo1477b(), null, null, Columns.f5287w.m2098d(), "1");
        int a2 = Columns.f5288x.m2089a(query);
        try {
            if (query.moveToNext()) {
                str = query.getString(a2);
            }
            query.close();
            return str;
        } catch (Throwable th) {
            query.close();
        }
    }

    @VisibleForTesting
    private int m9134b(FeedType feedType, long j) {
        Expression b = SqlExpression.m10733b(Columns.f5266b.toString(), String.valueOf(this.f5253i.mo211a() - j));
        Expression a = SqlExpression.m10727a(Columns.f5265a.toString(), feedType.toString());
        ConjunctionExpression a2 = SqlExpression.m10723a(b, a);
        m9128a(a2);
        try {
            int delete = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a().delete("home_stories", a2.mo1476a(), a2.mo1477b());
            m9130a("evictStoriesByLastRefreshedTime", EvictionReason.CONTENT_STALE);
            this.f5251g.mo1344a(EvictionReason.CONTENT_STALE, delete, 0);
            return delete;
        } catch (Throwable e) {
            BLog.a(f5244a, e, "evictStoriesByLastRefreshedTime failed", new Object[0]);
            return 0;
        }
    }

    private File m9145f(String str) {
        String g = m9148g(str);
        File file = null;
        if (this.f5257m.exists() || this.f5257m.mkdirs()) {
            File file2 = new File(this.f5257m, g);
            if (file2.exists() || file2.mkdirs()) {
                file = file2;
            }
        }
        File file3 = file;
        if (file3 != null) {
            return new File(file3, str);
        }
        BLog.b(f5244a, "Failed to create directory to save cache file.");
        return null;
    }

    public final int m9158a(List<String> list, FeedType feedType) {
        int i = 0;
        SQLiteDatabase a = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a();
        SQLiteDetour.a(a, 1131966488);
        int i2 = 0;
        while (i < list.size()) {
            try {
                String str = (String) list.get(i);
                ContentValues contentValues = new ContentValues();
                contentValues.put(Columns.f5273i.m2091a(), "1");
                Expression a2 = SqlExpression.m10722a();
                a2.m10741a(Columns.f5268d.m2090a(str));
                a2.m10741a(Columns.f5265a.m2090a(feedType.toString()));
                i2 += a.update("home_stories", contentValues, a2.mo1476a(), a2.mo1477b());
                i++;
            } finally {
                SQLiteDetour.b(a, -385202985);
            }
        }
        a.setTransactionSuccessful();
        return i2;
    }

    private HashSet<String> m9152j(FeedType feedType) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        a.m10741a(Columns.f5273i.m2090a("1"));
        Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) this.f5249e.get()).mo2480a(), new String[]{Columns.f5268d.toString()}, a.mo1476a(), a.mo1477b(), null, null, null, null);
        int a2 = Columns.f5268d.m2089a(query);
        HashSet<String> hashSet = new HashSet();
        while (query.moveToNext()) {
            try {
                hashSet.add(query.getString(a2));
            } finally {
                query.close();
            }
        }
        return hashSet;
    }

    @VisibleForTesting
    private static String m9148g(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA-1").digest(str.getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte valueOf : digest) {
                stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%02X", Byte.valueOf(valueOf)));
            }
            return stringBuilder.substring(0, 2);
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (UnsupportedEncodingException e2) {
            return "";
        }
    }

    public final StorySeenStats m9184h(FeedType feedType) {
        int i = 0;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("home_stories");
        Expression a = SqlExpression.m10722a();
        a.m10741a(Columns.f5265a.m2090a(feedType.toString()));
        Expression b = SqlExpression.m10730b();
        b.m10741a(Columns.f5279o.m2090a("Page"));
        b.m10741a(Columns.f5279o.m2090a("User"));
        a.m10741a(b);
        a.m10741a(Columns.f5277m.m2090a("0"));
        SQLiteDatabase a2 = ((FeedDatabaseSupplier) this.f5249e.get()).mo2480a();
        String[] strArr = new String[]{Columns.f5273i.toString(), Columns.f5274j.toString(), Columns.f5276l.toString()};
        String a3 = a.mo1476a();
        StorySeenStats b2 = a.mo1477b();
        Cursor query = sQLiteQueryBuilder.query(a2, strArr, a3, b2, null, null, null);
        try {
            int a4 = Columns.f5273i.m2089a(query);
            int a5 = Columns.f5274j.m2089a(query);
            int a6 = Columns.f5276l.m2089a(query);
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (query.moveToNext()) {
                int i5 = query.getInt(a4);
                if (i5 == 1) {
                    i5 = query.getInt(a5);
                    i++;
                    if (i5 == 0 || i5 == 1) {
                        i3++;
                    }
                } else if (i5 == 0) {
                    i4++;
                    if (query.getInt(a6) == 2) {
                        i2++;
                    }
                }
            }
            b2 = new StorySeenStats(i, i4, i3, i2);
            return b2;
        } finally {
            query.close();
        }
    }
}
