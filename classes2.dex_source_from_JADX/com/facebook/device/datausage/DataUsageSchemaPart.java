package com.facebook.device.datausage;

import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys$PrimaryKey;
import com.facebook.database.sqlite.SqlKeys$SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: now_ms */
public class DataUsageSchemaPart extends TablesDbSchemaPart {
    private static volatile DataUsageSchemaPart f12069a;

    /* compiled from: now_ms */
    public final class TrafficStatsTable extends SqlTable {
        private static final SqlKeys$SqlKey f12070a = new SqlKeys$PrimaryKey(ImmutableList.of(Columns.f12064a, Columns.f12067d));
        private static final ImmutableList<SqlColumn> f12071b = ImmutableList.of(Columns.f12064a, Columns.f12065b, Columns.f12066c, Columns.f12067d);
        private static final ImmutableList<SqlKeys$SqlKey> f12072c = ImmutableList.of(f12070a);

        /* compiled from: now_ms */
        public class Columns {
            public static final SqlColumn f12064a = new SqlColumn("date_col", "DATETIME");
            public static final SqlColumn f12065b = new SqlColumn("data_received", "INTEGER");
            public static final SqlColumn f12066c = new SqlColumn("data_sent", "INTEGER");
            public static final SqlColumn f12067d = new SqlColumn("type", "INTEGER");
        }

        TrafficStatsTable() {
            super("traffic_stats", f12071b, f12072c);
        }
    }

    public static com.facebook.device.datausage.DataUsageSchemaPart m17776a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12069a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.device.datausage.DataUsageSchemaPart.class;
        monitor-enter(r1);
        r0 = f12069a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m17777d();	 Catch:{ all -> 0x0034 }
        f12069a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12069a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.datausage.DataUsageSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.device.datausage.DataUsageSchemaPart");
    }

    private static DataUsageSchemaPart m17777d() {
        return new DataUsageSchemaPart();
    }

    @Inject
    public DataUsageSchemaPart() {
        super("datausage", 3, ImmutableList.of(new TrafficStatsTable()));
    }
}
