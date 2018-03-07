package com.facebook.analytics.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.properties.DbPropertyUtil;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: title=? */
public class AnalyticsDbSchemaPart extends TablesDbSchemaPart {
    private static final Class<?> f969a = AnalyticsDbSchemaPart.class;
    private static volatile AnalyticsDbSchemaPart f970b;

    /* compiled from: title=? */
    public final class PropertiesTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f971a = ImmutableList.of(DbPropertyUtil.f8245a, DbPropertyUtil.f8246b);

        PropertiesTable() {
            super("analytics_db_properties", f971a);
        }
    }

    /* compiled from: title=? */
    public final class EventsTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f972a = ImmutableList.of(Columns.f973a, Columns.f974b, Columns.f975c, Columns.f976d, Columns.f977e, Columns.f978f, Columns.f979g);

        /* compiled from: title=? */
        public class Columns {
            public static final SqlColumn f973a = new SqlColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
            public static final SqlColumn f974b = new SqlColumn("session_id", "TEXT");
            public static final SqlColumn f975c = new SqlColumn("app_version_name", "TEXT");
            public static final SqlColumn f976d = new SqlColumn("app_version_code", "INTEGER");
            public static final SqlColumn f977e = new SqlColumn("flush_tag", "TEXT");
            public static final SqlColumn f978f = new SqlColumn("data", "TEXT");
            public static final SqlColumn f979g = new SqlColumn("timestamp", "INTEGER");
        }

        EventsTable() {
            super("events", f972a);
        }
    }

    public static com.facebook.analytics.db.AnalyticsDbSchemaPart m1294a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f970b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.analytics.db.AnalyticsDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f970b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m1295d();	 Catch:{ all -> 0x0034 }
        f970b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f970b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.db.AnalyticsDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.analytics.db.AnalyticsDbSchemaPart");
    }

    private static AnalyticsDbSchemaPart m1295d() {
        return new AnalyticsDbSchemaPart();
    }

    @Inject
    public AnalyticsDbSchemaPart() {
        super("analytics", 6, ImmutableList.of(new PropertiesTable(), new EventsTable()));
    }

    protected final void m1296a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String a = SqlTable.a("batches");
        SQLiteDetour.a(1733249992);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(-1164320966);
        super.a(sQLiteDatabase, i, i2);
    }
}
