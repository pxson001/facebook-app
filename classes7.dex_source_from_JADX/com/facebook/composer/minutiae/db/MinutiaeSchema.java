package com.facebook.composer.minutiae.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: topLoadingFinish */
public class MinutiaeSchema extends TablesDbSchemaPart {
    private static volatile MinutiaeSchema f1495b;
    private final AnalyticsLogger f1496a;

    /* compiled from: topLoadingFinish */
    public final class VerbTable extends SqlTable {
        public static final int f1493a;
        private static final ImmutableList<SqlColumn> f1494b;

        /* compiled from: topLoadingFinish */
        public class Columns {
            public static final SqlColumn f1478a = new SqlColumn("id", "TEXT");
            public static final SqlColumn f1479b = new SqlColumn("legacy_api_id", "TEXT");
            public static final SqlColumn f1480c = new SqlColumn("present_participle", "TEXT");
            public static final SqlColumn f1481d = new SqlColumn("prompt", "TEXT");
            public static final SqlColumn f1482e = new SqlColumn("is_linking_verb", "INTEGER");
            public static final SqlColumn f1483f = new SqlColumn("supports_audio_suggestion", "INTEGER");
            public static final SqlColumn f1484g = new SqlColumn("supports_free_form", "INTEGER");
            public static final SqlColumn f1485h = new SqlColumn("supports_offline_posting", "INTEGER");
            public static final SqlColumn f1486i = new SqlColumn("glyph_uri", "TEXT");
            public static final SqlColumn f1487j = new SqlColumn("icon_image_large", "TEXT");
            public static final SqlColumn f1488k = new SqlColumn("icon_count", "INTEGER");
            public static final SqlColumn f1489l = new SqlColumn("position", "INTEGER");
            public static final SqlColumn f1490m = new SqlColumn("cache_key", "TEXT");
            public static final SqlColumn f1491n = new SqlColumn("user_id", "TEXT");
            public static final SqlColumn f1492o = new SqlColumn("cache_time", "LONG");
        }

        static {
            ImmutableList of = ImmutableList.of(Columns.f1478a, Columns.f1479b, Columns.f1480c, Columns.f1481d, Columns.f1482e, Columns.f1483f, Columns.f1484g, Columns.f1485h, Columns.f1486i, Columns.f1487j, Columns.f1488k, Columns.f1489l, new SqlColumn[]{Columns.f1490m, Columns.f1491n, Columns.f1492o});
            f1494b = of;
            f1493a = of.size();
        }

        VerbTable() {
            super("minutiae_verb_table", f1494b);
        }
    }

    public static com.facebook.composer.minutiae.db.MinutiaeSchema m1576a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1495b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.minutiae.db.MinutiaeSchema.class;
        monitor-enter(r1);
        r0 = f1495b;	 Catch:{ all -> 0x003a }
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
        r0 = m1577b(r0);	 Catch:{ all -> 0x0035 }
        f1495b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1495b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.db.MinutiaeSchema.a(com.facebook.inject.InjectorLike):com.facebook.composer.minutiae.db.MinutiaeSchema");
    }

    private static MinutiaeSchema m1577b(InjectorLike injectorLike) {
        return new MinutiaeSchema(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MinutiaeSchema(AnalyticsLogger analyticsLogger) {
        super("minutiae_tables", 3, ImmutableList.of(new VerbTable()));
        this.f1496a = analyticsLogger;
    }

    public final void m1578b(SQLiteDatabase sQLiteDatabase) {
        super.b(sQLiteDatabase);
        HoneyClientEventFast a = this.f1496a.a("minutiae_schema_clear_all_data", false);
        if (a.a()) {
            a.b();
        }
    }
}
