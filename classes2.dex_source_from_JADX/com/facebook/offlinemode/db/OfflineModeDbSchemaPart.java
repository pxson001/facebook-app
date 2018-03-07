package com.facebook.offlinemode.db;

import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: network_operator_mcc_mnc */
public class OfflineModeDbSchemaPart extends TablesDbSchemaPart {
    private static volatile OfflineModeDbSchemaPart f12442a;

    /* compiled from: network_operator_mcc_mnc */
    public final class OfflineRequestsTable extends SqlTable {
        public static final ImmutableList<SqlColumn> f12443a;
        public static final String[] f12444b;

        /* compiled from: network_operator_mcc_mnc */
        public class Columns {
            public static final SqlColumn f12445a = new SqlColumn("request_id", "TEXT PRIMARY KEY");
            public static final SqlColumn f12446b = new SqlColumn("conflict_key", "TEXT");
            public static final SqlColumn f12447c = new SqlColumn("operation_type", "BLOB");
            public static final SqlColumn f12448d = new SqlColumn("serialized_param_data", "BLOB");
            public static final SqlColumn f12449e = new SqlColumn("mutation_query_class", "TEXT");
            public static final SqlColumn f12450f = new SqlColumn("serialized_mutation_param", "BLOB");
            public static final SqlColumn f12451g = new SqlColumn("optimistic_model_class", "TEXT");
            public static final SqlColumn f12452h = new SqlColumn("serialized_optimistic_model", "BLOB");
            public static final SqlColumn f12453i = new SqlColumn("serialized_ignored_tags", "BLOB");
            public static final SqlColumn f12454j = new SqlColumn("created_time", "INTEGER");
            public static final SqlColumn f12455k = new SqlColumn("expire_duration_ms", "INTEGER");
            public static final SqlColumn f12456l = new SqlColumn("attempts_number", "INTEGER");
            public static final SqlColumn f12457m = new SqlColumn("max_attempts", "INTEGER");
            public static final SqlColumn f12458n = new SqlColumn("android_build_fingerprint", "INTEGER");
            public static final SqlColumn f12459o = new SqlColumn("app_version_name", "TEXT");
        }

        static {
            ImmutableList of = ImmutableList.of(Columns.f12445a, Columns.f12446b, Columns.f12447c, Columns.f12448d, Columns.f12449e, Columns.f12450f, Columns.f12451g, Columns.f12452h, Columns.f12453i, Columns.f12454j, Columns.f12455k, Columns.f12456l, Columns.f12457m, Columns.f12458n, Columns.f12459o);
            f12443a = of;
            f12444b = new String[of.size()];
            for (int i = 0; i < f12443a.size(); i++) {
                f12444b[i] = ((SqlColumn) f12443a.get(i)).m2091a();
            }
        }

        OfflineRequestsTable() {
            super("pending_request", f12443a);
        }
    }

    public static com.facebook.offlinemode.db.OfflineModeDbSchemaPart m18524a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12442a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.offlinemode.db.OfflineModeDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f12442a;	 Catch:{ all -> 0x0039 }
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
        r0 = m18525d();	 Catch:{ all -> 0x0034 }
        f12442a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12442a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offlinemode.db.OfflineModeDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.offlinemode.db.OfflineModeDbSchemaPart");
    }

    private static OfflineModeDbSchemaPart m18525d() {
        return new OfflineModeDbSchemaPart();
    }

    @Inject
    OfflineModeDbSchemaPart() {
        super("offline_mode", 15, ImmutableList.of(new OfflineRequestsTable()));
    }
}
