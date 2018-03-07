package com.facebook.vault.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.ipc.vault.VaultContract.ImagesTable.Columns;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: thumbnail_resolution */
public class VaultImageDbSchemaPart extends TablesDbSchemaPart {
    private static final Class<?> f1704a = VaultImageDbSchemaPart.class;
    private static volatile VaultImageDbSchemaPart f1705b;

    /* compiled from: thumbnail_resolution */
    public final class VaultImagesTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f1703a = ImmutableList.of(Columns.a, Columns.b, Columns.c, Columns.d, Columns.e, Columns.f, Columns.g, Columns.h, Columns.i);

        public final void m1734a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String a = SqlTable.a("images", "vault_upload_state_idx", ImmutableList.of(Columns.f));
            SQLiteDetour.a(1221752461);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(1247695254);
            a = SqlTable.a("images", "vault_image_hash_idx", ImmutableList.of(Columns.a));
            SQLiteDetour.a(1873866565);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-1165952724);
        }

        VaultImagesTable() {
            super("images", f1703a);
        }
    }

    public static com.facebook.vault.db.VaultImageDbSchemaPart m1735a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1705b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.vault.db.VaultImageDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f1705b;	 Catch:{ all -> 0x0039 }
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
        r0 = m1736d();	 Catch:{ all -> 0x0034 }
        f1705b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1705b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.vault.db.VaultImageDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.vault.db.VaultImageDbSchemaPart");
    }

    private static VaultImageDbSchemaPart m1736d() {
        return new VaultImageDbSchemaPart();
    }

    @Inject
    public VaultImageDbSchemaPart() {
        super("vault", 1, ImmutableList.of(new VaultImagesTable()));
    }
}
