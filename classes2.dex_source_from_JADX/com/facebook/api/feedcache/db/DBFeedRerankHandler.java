package com.facebook.api.feedcache.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.api.feed.xconfig.FeedClientXConfig;
import com.facebook.api.feed.xconfig.FeedClientXConfigReader;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.data.freshfeed.ranking.ClientFeedUnitEdgeScorer;
import com.facebook.feed.data.freshfeed.ranking.ClientFeedUnitEdgeScorerProvider;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: session_secret */
public class DBFeedRerankHandler {
    private static final FeedType f5407a = FeedType.f5039b;
    private static volatile DBFeedRerankHandler f5408k;
    private final QeAccessor f5409b;
    private final Lazy<FeedDatabaseSupplier> f5410c;
    private final AsyncFeedXConfigReader f5411d;
    private final NewsFeedXConfigReader f5412e;
    private final AbstractFbErrorReporter f5413f;
    public final FeedClientXConfigReader f5414g;
    public ClientFeedUnitEdgeScorer f5415h = null;
    public final ClientFeedUnitEdgeScorerProvider f5416i;
    private final Clock f5417j;

    public static com.facebook.api.feedcache.db.DBFeedRerankHandler m9321a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5408k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.db.DBFeedRerankHandler.class;
        monitor-enter(r1);
        r0 = f5408k;	 Catch:{ all -> 0x003a }
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
        r0 = m9328b(r0);	 Catch:{ all -> 0x0035 }
        f5408k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5408k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.DBFeedRerankHandler.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.db.DBFeedRerankHandler");
    }

    private static DBFeedRerankHandler m9328b(InjectorLike injectorLike) {
        return new DBFeedRerankHandler(IdBasedSingletonScopeProvider.m1810b(injectorLike, 234), QeInternalImplMethodAutoProvider.m3744a(injectorLike), AsyncFeedXConfigReader.m9332a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), FeedClientXConfigReader.m9358a(injectorLike), (ClientFeedUnitEdgeScorerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ClientFeedUnitEdgeScorerProvider.class), SystemClockMethodAutoProvider.m1498a(injectorLike), NewsFeedXConfigReader.m8187a(injectorLike));
    }

    @Inject
    public DBFeedRerankHandler(Lazy<FeedDatabaseSupplier> lazy, QeAccessor qeAccessor, AsyncFeedXConfigReader asyncFeedXConfigReader, FbErrorReporter fbErrorReporter, FeedClientXConfigReader feedClientXConfigReader, ClientFeedUnitEdgeScorerProvider clientFeedUnitEdgeScorerProvider, Clock clock, NewsFeedXConfigReader newsFeedXConfigReader) {
        this.f5410c = lazy;
        this.f5409b = qeAccessor;
        this.f5411d = asyncFeedXConfigReader;
        this.f5413f = fbErrorReporter;
        this.f5414g = feedClientXConfigReader;
        this.f5416i = clientFeedUnitEdgeScorerProvider;
        this.f5417j = clock;
        this.f5412e = newsFeedXConfigReader;
    }

    public final int m9330a(String str) {
        TracerDetour.a("DBFeedRerankHandler.rerank", -1834515708);
        try {
            int a = m9319a(f5407a, str);
            return a;
        } finally {
            TracerDetour.a(-1044136367);
        }
    }

    private int m9319a(FeedType feedType, String str) {
        ImmutableList a = m9323a(feedType);
        if (a == null || a.isEmpty()) {
            return 0;
        }
        List list;
        if (this.f5409b.mo596a(ExperimentsForNewsFeedAbTestModule.f5101b, false)) {
            List a2 = Lists.m1298a((Iterable) a);
            if (this.f5415h == null) {
                this.f5415h = this.f5416i.m9360a(this.f5414g.m9088a(FeedClientXConfig.f5468d, 0, "{ \"ctr_multiply_values\" : {\"base_values\" : { \"weight_final\" : \"1\", \"seen\" : {\"viewed\" : \"-10000\"}} }, \"ctr_value_features\":  {\"seen\": \"client_has_seen\"}}"));
            }
            this.f5415h.m30093a(a2);
            list = a2;
        } else {
            list = m9324a(a, str);
        }
        return m9320a(a, list);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.common.collect.ImmutableList<com.facebook.feed.model.ClientFeedUnitEdge> m9323a(com.facebook.api.feedtype.FeedType r29) {
        /*
        r28 = this;
        r4 = "DBFeedRerankHandler.loadRowsToRerank";
        r5 = 1818337902; // 0x6c61a26e float:1.09110145E27 double:8.9837829E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r4, r5);
        r12 = com.google.common.collect.ImmutableList.builder();
        r4 = new android.database.sqlite.SQLiteQueryBuilder;	 Catch:{ all -> 0x0228 }
        r4.<init>();	 Catch:{ all -> 0x0228 }
        r5 = "home_stories";
        r4.setTables(r5);	 Catch:{ all -> 0x0228 }
        r5 = 14;
        r6 = new java.lang.String[r5];	 Catch:{ all -> 0x0228 }
        r5 = 0;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5266b;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 1;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5269e;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 2;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5267c;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 3;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5268d;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 4;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5270f;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 5;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5271g;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 6;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5287w;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 7;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5288x;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 8;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5279o;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 9;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5273i;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 10;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5274j;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 11;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5276l;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 12;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5289y;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r5 = 13;
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5290z;	 Catch:{ all -> 0x0228 }
        r7 = r7.toString();	 Catch:{ all -> 0x0228 }
        r6[r5] = r7;	 Catch:{ all -> 0x0228 }
        r8 = com.facebook.database.sqlite.SqlExpression.m10722a();	 Catch:{ all -> 0x0228 }
        r5 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5265a;	 Catch:{ all -> 0x0228 }
        r7 = r29.toString();	 Catch:{ all -> 0x0228 }
        r5 = r5.m2090a(r7);	 Catch:{ all -> 0x0228 }
        r8.m10741a(r5);	 Catch:{ all -> 0x0228 }
        r5 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5277m;	 Catch:{ all -> 0x0228 }
        r7 = "0";
        r5 = r5.m2090a(r7);	 Catch:{ all -> 0x0228 }
        r8.m10741a(r5);	 Catch:{ all -> 0x0228 }
        r10 = r28.m9327b();	 Catch:{ all -> 0x0228 }
        r14 = 0;
        r5 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r5 == 0) goto L_0x00db;
    L_0x00c4:
        r5 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5266b;	 Catch:{ all -> 0x0228 }
        r0 = r28;
        r7 = r0.f5417j;	 Catch:{ all -> 0x0228 }
        r14 = r7.mo211a();	 Catch:{ all -> 0x0228 }
        r10 = r14 - r10;
        r7 = java.lang.Long.toString(r10);	 Catch:{ all -> 0x0228 }
        r5 = r5.m2099e(r7);	 Catch:{ all -> 0x0228 }
        r8.m10741a(r5);	 Catch:{ all -> 0x0228 }
    L_0x00db:
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ all -> 0x0228 }
        r7 = 0;
        r9 = "Page";
        r5[r7] = r9;	 Catch:{ all -> 0x0228 }
        r7 = 1;
        r9 = "User";
        r5[r7] = r9;	 Catch:{ all -> 0x0228 }
        r5 = com.google.common.collect.Lists.m1300a(r5);	 Catch:{ all -> 0x0228 }
        r5 = m9322a(r5);	 Catch:{ all -> 0x0228 }
        r8.m10741a(r5);	 Catch:{ all -> 0x0228 }
        r5 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5287w;	 Catch:{ all -> 0x0228 }
        r11 = r5.m2100e();	 Catch:{ all -> 0x0228 }
        r0 = r28;
        r5 = r0.f5410c;	 Catch:{ all -> 0x0228 }
        r5 = r5.get();	 Catch:{ all -> 0x0228 }
        r5 = (com.facebook.api.feedcache.db.FeedDatabaseSupplier) r5;	 Catch:{ all -> 0x0228 }
        r5 = r5.mo2480a();	 Catch:{ all -> 0x0228 }
        r7 = r8.mo1476a();	 Catch:{ all -> 0x0228 }
        r8 = r8.mo1477b();	 Catch:{ all -> 0x0228 }
        r9 = 0;
        r10 = 0;
        r5 = r4.query(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x0228 }
        r4 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5266b;	 Catch:{ all -> 0x0228 }
        r4 = r4.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r6 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5269e;	 Catch:{ all -> 0x0228 }
        r6 = r6.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r7 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5267c;	 Catch:{ all -> 0x0228 }
        r7 = r7.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r8 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5268d;	 Catch:{ all -> 0x0228 }
        r8 = r8.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r9 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5270f;	 Catch:{ all -> 0x0228 }
        r9 = r9.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r10 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5271g;	 Catch:{ all -> 0x0228 }
        r10 = r10.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r11 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5287w;	 Catch:{ all -> 0x0228 }
        r11 = r11.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r13 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5288x;	 Catch:{ all -> 0x0228 }
        r13 = r13.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r14 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5279o;	 Catch:{ all -> 0x0228 }
        r14 = r14.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r15 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5273i;	 Catch:{ all -> 0x0228 }
        r15 = r15.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r16 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5274j;	 Catch:{ all -> 0x0228 }
        r0 = r16;
        r16 = r0.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r17 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5276l;	 Catch:{ all -> 0x0228 }
        r0 = r17;
        r17 = r0.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r18 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5289y;	 Catch:{ all -> 0x0228 }
        r0 = r18;
        r18 = r0.m2089a(r5);	 Catch:{ all -> 0x0228 }
        r19 = com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns.f5290z;	 Catch:{ all -> 0x0228 }
        r0 = r19;
        r19 = r0.m2089a(r5);	 Catch:{ all -> 0x0228 }
    L_0x0171:
        r20 = r5.moveToNext();	 Catch:{ all -> 0x0223 }
        if (r20 == 0) goto L_0x0230;
    L_0x0177:
        r20 = r5.getString(r14);	 Catch:{ all -> 0x0223 }
        r21 = r5.getInt(r15);	 Catch:{ all -> 0x0223 }
        r0 = r17;
        r22 = r5.getInt(r0);	 Catch:{ all -> 0x0223 }
        r0 = r16;
        r23 = r5.getInt(r0);	 Catch:{ all -> 0x0223 }
        r24 = new com.facebook.feed.model.ClientFeedUnitEdgeBuilder;	 Catch:{ all -> 0x0223 }
        r24.<init>();	 Catch:{ all -> 0x0223 }
        r26 = r5.getLong(r4);	 Catch:{ all -> 0x0223 }
        r0 = r24;
        r1 = r26;
        r24 = r0.m21165a(r1);	 Catch:{ all -> 0x0223 }
        r25 = r5.getString(r6);	 Catch:{ all -> 0x0223 }
        r24 = r24.m21169a(r25);	 Catch:{ all -> 0x0223 }
        r25 = r5.getString(r7);	 Catch:{ all -> 0x0223 }
        r24 = r24.m21174b(r25);	 Catch:{ all -> 0x0223 }
        r25 = r5.getString(r8);	 Catch:{ all -> 0x0223 }
        r24 = r24.m21183e(r25);	 Catch:{ all -> 0x0223 }
        r26 = r5.getDouble(r9);	 Catch:{ all -> 0x0223 }
        r0 = r24;
        r1 = r26;
        r24 = r0.m21163a(r1);	 Catch:{ all -> 0x0223 }
        r25 = r5.getString(r10);	 Catch:{ all -> 0x0223 }
        r24 = r24.m21189i(r25);	 Catch:{ all -> 0x0223 }
        r25 = r5.getString(r11);	 Catch:{ all -> 0x0223 }
        r24 = r24.m21178c(r25);	 Catch:{ all -> 0x0223 }
        r25 = r5.getString(r13);	 Catch:{ all -> 0x0223 }
        r24 = r24.m21181d(r25);	 Catch:{ all -> 0x0223 }
        r0 = r24;
        r1 = r20;
        r20 = r0.m21188h(r1);	 Catch:{ all -> 0x0223 }
        r24 = r29.m8961a();	 Catch:{ all -> 0x0223 }
        r0 = r20;
        r1 = r24;
        r20 = r0.m21187g(r1);	 Catch:{ all -> 0x0223 }
        r20 = r20.m21186g(r21);	 Catch:{ all -> 0x0223 }
        r0 = r20;
        r1 = r22;
        r20 = r0.m21164a(r1);	 Catch:{ all -> 0x0223 }
        r0 = r20;
        r1 = r23;
        r20 = r0.m21172b(r1);	 Catch:{ all -> 0x0223 }
        r0 = r18;
        r21 = r5.getString(r0);	 Catch:{ all -> 0x0223 }
        r20 = r20.m21190j(r21);	 Catch:{ all -> 0x0223 }
        r0 = r19;
        r22 = r5.getLong(r0);	 Catch:{ all -> 0x0223 }
        r0 = r20;
        r1 = r22;
        r20 = r0.m21173b(r1);	 Catch:{ all -> 0x0223 }
        r20 = r20.m21162a();	 Catch:{ all -> 0x0223 }
        r0 = r20;
        r12.m1069c(r0);	 Catch:{ all -> 0x0223 }
        goto L_0x0171;
    L_0x0223:
        r4 = move-exception;
        r5.close();	 Catch:{  }
        throw r4;	 Catch:{  }
    L_0x0228:
        r4 = move-exception;
        r5 = 884243188; // 0x34b47af4 float:3.3617073E-7 double:4.36874182E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r5);
        throw r4;
    L_0x0230:
        r5.close();	 Catch:{  }
        r4 = 1392934291; // 0x53067d93 float:5.776324E11 double:6.8820098E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r4);
        r4 = r12.m1068b();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.DBFeedRerankHandler.a(com.facebook.api.feedtype.FeedType):com.google.common.collect.ImmutableList<com.facebook.feed.model.ClientFeedUnitEdge>");
    }

    private long m9327b() {
        return TimeUnit.HOURS.toMillis((long) this.f5412e.m8197i());
    }

    private int m9320a(ImmutableList<ClientFeedUnitEdge> immutableList, List<ClientFeedUnitEdge> list) {
        int i = 0;
        SQLiteDatabase a = ((FeedDatabaseSupplier) this.f5410c.get()).mo2480a();
        if (!(list == null || list.isEmpty())) {
            SQLiteDetour.a(a, -1450538295);
            TracerDetour.a("DBFeedRerankHandler.WriteClientRerankingRows", 748353550);
            try {
                int size = immutableList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    int i4;
                    ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) immutableList.get(i2);
                    ClientFeedUnitEdge clientFeedUnitEdge2 = (ClientFeedUnitEdge) list.get(i3);
                    i3++;
                    String V_ = clientFeedUnitEdge.V_();
                    String W_ = clientFeedUnitEdge.W_();
                    if (StringUtil.m3590a(W_, clientFeedUnitEdge2.W_()) && StringUtil.m3590a(V_, clientFeedUnitEdge2.V_())) {
                        i4 = i;
                    } else {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(Columns.f5287w.m2091a(), V_);
                        contentValues.put(Columns.f5288x.m2091a(), W_);
                        Expression a2 = SqlExpression.m10722a();
                        a2.m10741a(Columns.f5268d.m2090a(clientFeedUnitEdge2.m19080b()));
                        a2.m10741a(Columns.f5265a.m2090a(clientFeedUnitEdge2.m21237v()));
                        i4 = a.update("home_stories", contentValues, a2.mo1476a(), a2.mo1477b()) + i;
                    }
                    i2++;
                    i = i4;
                }
                a.setTransactionSuccessful();
            } catch (IndexOutOfBoundsException e) {
                this.f5413f.m2340a("diversityRuleRerankIndexOutOfBound", "rerankedStoriesSize: " + list.size() + ", originalOrderSize: " + immutableList.size());
            } finally {
                TracerDetour.a(437730265);
                SQLiteDetour.b(a, -50873868);
            }
        }
        return i;
    }

    private List<ClientFeedUnitEdge> m9324a(ImmutableList<ClientFeedUnitEdge> immutableList, String str) {
        String str2;
        List<ClientFeedUnitEdge> a = Lists.m1298a((Iterable) immutableList);
        if (str.equals("sort_key")) {
            Collections.sort(a, SeenStateSortKeyComparator.a);
        } else {
            Collections.sort(a, RankingComparator.a);
        }
        String b = this.f5411d.m9343b(null);
        if (m9329b(b)) {
            str2 = b;
        } else {
            str2 = "O";
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        for (ClientFeedUnitEdge clientFeedUnitEdge : a) {
            if (clientFeedUnitEdge.m21227E()) {
                arrayList3.add(clientFeedUnitEdge);
            } else if (clientFeedUnitEdge.f14834z.equals("User")) {
                arrayList.add(clientFeedUnitEdge);
            } else {
                arrayList2.add(clientFeedUnitEdge);
            }
        }
        return m9326a(str2, arrayList, arrayList2, arrayList3);
    }

    @VisibleForTesting
    private static boolean m9329b(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int i = 0;
        while (i < str.length()) {
            switch (str.charAt(i)) {
                case 'O':
                case 'P':
                case 'U':
                    i++;
                default:
                    return false;
            }
        }
        return true;
    }

    private static Expression m9322a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return Columns.f5279o.m2090a((String) list.get(0));
        }
        Expression b = SqlExpression.m10730b();
        for (String a : list) {
            b.m10741a(Columns.f5279o.m2090a(a));
        }
        return b;
    }

    @VisibleForTesting
    private static List<ClientFeedUnitEdge> m9326a(String str, List<ClientFeedUnitEdge> list, List<ClientFeedUnitEdge> list2, List<ClientFeedUnitEdge> list3) {
        if (list == null || list2 == null || list3 == null || str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Parameters can't be null");
        }
        List<ClientFeedUnitEdge> arrayList = new ArrayList((list.size() + list2.size()) + list3.size());
        arrayList.addAll(m9325a(str, list, list2));
        arrayList.addAll(list3);
        return arrayList;
    }

    private static List<ClientFeedUnitEdge> m9325a(String str, List<ClientFeedUnitEdge> list, List<ClientFeedUnitEdge> list2) {
        PeekingIterator i = Iterators.m1430i(list.iterator());
        PeekingIterator i2 = Iterators.m1430i(list2.iterator());
        List<ClientFeedUnitEdge> arrayList = new ArrayList(list.size() + list2.size());
        while (i.hasNext() && i2.hasNext()) {
            for (int i3 = 0; i3 < str.length(); i3++) {
                switch (str.charAt(i3)) {
                    case 'O':
                        if (i.hasNext() && i2.hasNext()) {
                            Object obj;
                            if (((ClientFeedUnitEdge) i.a()).X_() >= ((ClientFeedUnitEdge) i2.a()).X_()) {
                                obj = (ClientFeedUnitEdge) i.next();
                            } else {
                                ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) i2.next();
                            }
                            arrayList.add(obj);
                            break;
                        }
                    case 'P':
                        if (!i2.hasNext()) {
                            break;
                        }
                        arrayList.add(i2.next());
                        break;
                    case 'U':
                        if (!i.hasNext()) {
                            break;
                        }
                        arrayList.add(i.next());
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported diversity rule " + str);
                }
            }
        }
        while (i.hasNext()) {
            arrayList.add(i.next());
        }
        while (i2.hasNext()) {
            arrayList.add(i2.next());
        }
        return arrayList;
    }
}
