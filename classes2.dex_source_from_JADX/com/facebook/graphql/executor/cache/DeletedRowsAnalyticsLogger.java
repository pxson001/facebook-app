package com.facebook.graphql.executor.cache;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.google.common.collect.ObjectArrays;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: saved_dashboard_item_clicked */
public class DeletedRowsAnalyticsLogger {
    private static volatile DeletedRowsAnalyticsLogger f6163d;
    private final BaseAnalyticsConfig f6164a;
    private final AnalyticsLogger f6165b;
    private final GraphQLDiskCacheQueryFormatter f6166c;

    public static com.facebook.graphql.executor.cache.DeletedRowsAnalyticsLogger m10347a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6163d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.executor.cache.DeletedRowsAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f6163d;	 Catch:{ all -> 0x003a }
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
        r0 = m10349b(r0);	 Catch:{ all -> 0x0035 }
        f6163d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6163d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.cache.DeletedRowsAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.cache.DeletedRowsAnalyticsLogger");
    }

    private static DeletedRowsAnalyticsLogger m10349b(InjectorLike injectorLike) {
        return new DeletedRowsAnalyticsLogger(FbAnalyticsConfig.m3559a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), GraphQLDiskCacheQueryFormatter.m10353a(injectorLike));
    }

    @Inject
    public DeletedRowsAnalyticsLogger(BaseAnalyticsConfig baseAnalyticsConfig, AnalyticsLogger analyticsLogger, GraphQLDiskCacheQueryFormatter graphQLDiskCacheQueryFormatter) {
        this.f6164a = baseAnalyticsConfig;
        this.f6165b = analyticsLogger;
        this.f6166c = graphQLDiskCacheQueryFormatter;
    }

    public final void m10352a(SQLiteDatabase sQLiteDatabase, long j, String str) {
        GraphQLDiskCacheQueryFormatter graphQLDiskCacheQueryFormatter = this.f6166c;
        String str2 = GraphQLDiskCacheQueryFormatter.f6167a + "WHERE rowid IN(" + GraphQLDiskCacheQueryFormatter.m10355a(str) + ") " + GraphQLDiskCacheQueryFormatter.f6168b;
        GraphQLDiskCacheQueryFormatter graphQLDiskCacheQueryFormatter2 = this.f6166c;
        m10348a(sQLiteDatabase, "fb4a_graphql_disk_cache_gc_table", str2, (String[]) ObjectArrays.m628a(String.valueOf(j), GraphQLDiskCacheQueryFormatter.m10358b(j)));
    }

    public final void m10351a(SQLiteDatabase sQLiteDatabase, long j, long j2, String str) {
        GraphQLDiskCacheQueryFormatter graphQLDiskCacheQueryFormatter = this.f6166c;
        String str2 = GraphQLDiskCacheQueryFormatter.f6167a + "WHERE rowid IN(" + GraphQLDiskCacheQueryFormatter.m10360c(str) + ") " + GraphQLDiskCacheQueryFormatter.f6168b;
        GraphQLDiskCacheQueryFormatter graphQLDiskCacheQueryFormatter2 = this.f6166c;
        m10348a(sQLiteDatabase, "fb4a_graphql_disk_cache_trim_table", str2, (String[]) ObjectArrays.m628a(String.valueOf(j2), GraphQLDiskCacheQueryFormatter.m10361d(j)));
    }

    public final void m10350a(SQLiteDatabase sQLiteDatabase, long j) {
        m10348a(sQLiteDatabase, "fb4a_graphql_disk_cache_drop_table", GraphQLDiskCacheQueryFormatter.m10357b(), GraphQLDiskCacheQueryFormatter.m10356a(j));
    }

    private void m10348a(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        if (this.f6164a.m3563a(str)) {
            this.f6165b.mo526a(DiskCacheEntriesLogEventFactory.a(sQLiteDatabase, str, "deleted_rows_analytics", str2, strArr));
        }
    }
}
