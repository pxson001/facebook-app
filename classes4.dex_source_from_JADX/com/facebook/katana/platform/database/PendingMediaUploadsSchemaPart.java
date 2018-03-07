package com.facebook.katana.platform.database;

import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.ForeignKey;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: geopixel_rtt */
public class PendingMediaUploadsSchemaPart extends TablesDbSchemaPart {
    private static volatile PendingMediaUploadsSchemaPart f11260a;

    /* compiled from: geopixel_rtt */
    public final class PendingMediaUploadsTable extends SqlTable {
        public static final SqlKey f11261a = new PrimaryKey(ImmutableList.of(Columns.f11255a));
        public static final SqlKey f11262b = new ForeignKey(ImmutableList.of(Columns.f11256b), "pending_app_calls", ImmutableList.of(com.facebook.platform.database.PendingAppCallsSchemaPart.PendingAppCallsTable.Columns.f11269a));
        public static final ImmutableList<SqlKey> f11263c = ImmutableList.of(f11261a, f11262b);
        private static final ImmutableList<SqlColumn> f11264d = ImmutableList.of(Columns.f11255a, Columns.f11256b);

        /* compiled from: geopixel_rtt */
        public class Columns {
            public static final SqlColumn f11255a = new SqlColumn("operation_id", "TEXT");
            public static final SqlColumn f11256b = new SqlColumn("app_call_id", "TEXT");
        }

        PendingMediaUploadsTable() {
            super("pending_media_uploads", f11264d, f11263c);
        }
    }

    public static com.facebook.katana.platform.database.PendingMediaUploadsSchemaPart m11679a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11260a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.katana.platform.database.PendingMediaUploadsSchemaPart.class;
        monitor-enter(r1);
        r0 = f11260a;	 Catch:{ all -> 0x0039 }
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
        r0 = m11680d();	 Catch:{ all -> 0x0034 }
        f11260a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f11260a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.platform.database.PendingMediaUploadsSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.katana.platform.database.PendingMediaUploadsSchemaPart");
    }

    private static PendingMediaUploadsSchemaPart m11680d() {
        return new PendingMediaUploadsSchemaPart();
    }

    @Inject
    public PendingMediaUploadsSchemaPart() {
        super("pending_media_uploads", 1, ImmutableList.of(new PendingMediaUploadsTable()));
    }
}
