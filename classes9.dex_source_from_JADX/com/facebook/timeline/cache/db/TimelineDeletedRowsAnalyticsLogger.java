package com.facebook.timeline.cache.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: upper_bound */
public class TimelineDeletedRowsAnalyticsLogger {
    private static volatile TimelineDeletedRowsAnalyticsLogger f825d;
    private final BaseAnalyticsConfig f826a;
    private final AnalyticsLogger f827b;
    private final Clock f828c;

    public static com.facebook.timeline.cache.db.TimelineDeletedRowsAnalyticsLogger m871a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f825d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.cache.db.TimelineDeletedRowsAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f825d;	 Catch:{ all -> 0x003a }
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
        r0 = m873b(r0);	 Catch:{ all -> 0x0035 }
        f825d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f825d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.cache.db.TimelineDeletedRowsAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.timeline.cache.db.TimelineDeletedRowsAnalyticsLogger");
    }

    private static TimelineDeletedRowsAnalyticsLogger m873b(InjectorLike injectorLike) {
        return new TimelineDeletedRowsAnalyticsLogger((BaseAnalyticsConfig) FbAnalyticsConfig.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TimelineDeletedRowsAnalyticsLogger(BaseAnalyticsConfig baseAnalyticsConfig, AnalyticsLogger analyticsLogger, Clock clock) {
        this.f826a = baseAnalyticsConfig;
        this.f827b = analyticsLogger;
        this.f828c = clock;
    }

    public final void m875a(SQLiteDatabase sQLiteDatabase, int i) {
        long a = this.f828c.a();
        m872a(sQLiteDatabase, "fb4a_timeline_disk_cache_trim_table", TimelineDbCacheQueryFormatter.m866a(TimelineDbCacheQueryFormatter.f822c), new String[]{String.valueOf(a), String.valueOf(i)});
    }

    public final void m874a(SQLiteDatabase sQLiteDatabase) {
        m872a(sQLiteDatabase, "fb4a_timeline_disk_cache_drop_table", TimelineDbCacheQueryFormatter.m868b(), TimelineDbCacheQueryFormatter.m867a(this.f828c.a()));
    }

    private void m872a(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        if (this.f826a.a(str)) {
            this.f827b.a(TimelineDbCacheEntriesLogEventFactory.m864a(sQLiteDatabase, str, "deleted_rows_analytics", str2, strArr));
        }
    }
}
