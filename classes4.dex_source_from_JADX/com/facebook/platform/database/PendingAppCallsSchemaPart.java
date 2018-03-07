package com.facebook.platform.database;

import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: geopixel_config */
public class PendingAppCallsSchemaPart extends TablesDbSchemaPart {
    private static volatile PendingAppCallsSchemaPart f11280a;

    /* compiled from: geopixel_config */
    public final class PendingAppCallsTable extends SqlTable {
        public static final SqlKey f11281a;
        public static final ImmutableList<SqlKey> f11282b;
        private static final ImmutableList<SqlColumn> f11283c = ImmutableList.of(Columns.f11269a, Columns.f11270b, Columns.f11271c, Columns.f11272d, Columns.f11273e, Columns.f11274f, Columns.f11275g, Columns.f11276h, Columns.f11277i, Columns.f11278j);

        /* compiled from: geopixel_config */
        public class Columns {
            public static final SqlColumn f11269a = new SqlColumn("id", "TEXT");
            public static final SqlColumn f11270b = new SqlColumn("version", "INTEGER");
            public static final SqlColumn f11271c = new SqlColumn("is_bucketed", "INTEGER");
            public static final SqlColumn f11272d = new SqlColumn("calling_package", "TEXT");
            public static final SqlColumn f11273e = new SqlColumn("app_id", "TEXT");
            public static final SqlColumn f11274f = new SqlColumn("app_name", "TEXT");
            public static final SqlColumn f11275g = new SqlColumn("app_key_hash", "TEXT");
            public static final SqlColumn f11276h = new SqlColumn("app_metadata", "TEXT");
            public static final SqlColumn f11277i = new SqlColumn("action", "TEXT");
            public static final SqlColumn f11278j = new SqlColumn("session_id", "TEXT");
        }

        static {
            PrimaryKey primaryKey = new PrimaryKey(ImmutableList.of(Columns.f11269a));
            f11281a = primaryKey;
            f11282b = ImmutableList.of(primaryKey);
        }

        PendingAppCallsTable() {
            super("pending_app_calls", f11283c, f11282b);
        }
    }

    public static com.facebook.platform.database.PendingAppCallsSchemaPart m11682a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11280a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.platform.database.PendingAppCallsSchemaPart.class;
        monitor-enter(r1);
        r0 = f11280a;	 Catch:{ all -> 0x0039 }
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
        r0 = m11683d();	 Catch:{ all -> 0x0034 }
        f11280a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f11280a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.database.PendingAppCallsSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.platform.database.PendingAppCallsSchemaPart");
    }

    private static PendingAppCallsSchemaPart m11683d() {
        return new PendingAppCallsSchemaPart();
    }

    @Inject
    public PendingAppCallsSchemaPart() {
        super("pending_app_calls", 4, ImmutableList.of(new PendingAppCallsTable()));
    }
}
