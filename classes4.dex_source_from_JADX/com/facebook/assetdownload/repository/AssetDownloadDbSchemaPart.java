package com.facebook.assetdownload.repository;

import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@VisibleForTesting
/* compiled from: facing */
public class AssetDownloadDbSchemaPart extends TablesDbSchemaPart {
    private static volatile AssetDownloadDbSchemaPart f12330a;

    /* compiled from: facing */
    public final class ConfigurationRepositoryTable extends SqlTable {
        public static final ImmutableList<SqlKey> f12331a = ImmutableList.of(new PrimaryKey(ImmutableList.of(Columns.f12333a)));
        private static final ImmutableList<SqlColumn> f12332b = ImmutableList.of(Columns.f12333a, Columns.f12334b, Columns.f12335c, Columns.f12336d, Columns.f12337e, Columns.f12338f, Columns.f12339g);

        /* compiled from: facing */
        public class Columns {
            public static final SqlColumn f12333a = new SqlColumn("identifier", "TEXT NOT NULL");
            public static final SqlColumn f12334b = new SqlColumn("namespace", "TEXT");
            public static final SqlColumn f12335c = new SqlColumn("configuration", "BLOB");
            public static final SqlColumn f12336d = new SqlColumn("priority", "INTEGER");
            public static final SqlColumn f12337e = new SqlColumn("connection", "STRING");
            public static final SqlColumn f12338f = new SqlColumn("available_since", "INTEGER DEFAULT -1");
            public static final SqlColumn f12339g = new SqlColumn("last_failure", "INTEGER DEFAULT -1");
        }

        ConfigurationRepositoryTable() {
            super("configurations", f12332b, f12331a);
        }
    }

    public static com.facebook.assetdownload.repository.AssetDownloadDbSchemaPart m13020a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12330a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.assetdownload.repository.AssetDownloadDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f12330a;	 Catch:{ all -> 0x0039 }
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
        r0 = m13021d();	 Catch:{ all -> 0x0034 }
        f12330a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12330a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.assetdownload.repository.AssetDownloadDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.assetdownload.repository.AssetDownloadDbSchemaPart");
    }

    private static AssetDownloadDbSchemaPart m13021d() {
        return new AssetDownloadDbSchemaPart();
    }

    @Inject
    public AssetDownloadDbSchemaPart() {
        super("assetdownload", 2, ImmutableList.of(new ConfigurationRepositoryTable()));
    }
}
