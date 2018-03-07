package com.facebook.backgroundlocation.reporting;

import com.facebook.backgroundlocation.reporting.LocationSignalPackageDbContract.SnapshotsTable.Columns;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: dialog_version */
public class LocationSignalPackageDbSchemaPart extends TablesDbSchemaPart {
    private static volatile LocationSignalPackageDbSchemaPart f14985a;

    /* compiled from: dialog_version */
    class LocationSignalPackageSnapshotTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f14984a = ImmutableList.of(Columns.f14982a, Columns.f14983b);

        LocationSignalPackageSnapshotTable() {
            super("snapshots", f14984a);
        }
    }

    public static com.facebook.backgroundlocation.reporting.LocationSignalPackageDbSchemaPart m15415a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14985a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.backgroundlocation.reporting.LocationSignalPackageDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f14985a;	 Catch:{ all -> 0x0039 }
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
        r0 = m15416d();	 Catch:{ all -> 0x0034 }
        f14985a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f14985a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.reporting.LocationSignalPackageDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.backgroundlocation.reporting.LocationSignalPackageDbSchemaPart");
    }

    private static LocationSignalPackageDbSchemaPart m15416d() {
        return new LocationSignalPackageDbSchemaPart();
    }

    @Inject
    public LocationSignalPackageDbSchemaPart() {
        super("location_package", 4, ImmutableList.of(new LocationSignalPackageSnapshotTable()));
    }
}
