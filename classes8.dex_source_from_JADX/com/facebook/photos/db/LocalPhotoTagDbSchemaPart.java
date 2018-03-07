package com.facebook.photos.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.ipc.photos.PhotosContract.LocalPhotoMetaDataTableProp.Columns;
import com.facebook.ipc.photos.PhotosContract.LocalPhotoTagsTable;
import com.facebook.ipc.photos.PhotosContract.RemovedPreFilledTagsTableProp;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: source_filter_type */
public class LocalPhotoTagDbSchemaPart extends TablesDbSchemaPart {
    private static final Class<?> f2340a = LocalPhotoTagDbSchemaPart.class;
    private static volatile LocalPhotoTagDbSchemaPart f2341b;

    /* compiled from: source_filter_type */
    public final class LocalPhotoMetaDataTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f2337a = ImmutableList.of(Columns.b, Columns.d, Columns.f);

        LocalPhotoMetaDataTable() {
            super("localphotometadata", f2337a);
        }

        public final void m2450a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String a = SqlTable.a("localphotometadata", "local_photo_metadata_photo_hash_idx", ImmutableList.of(Columns.b));
            SQLiteDetour.a(1048504702);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(53052073);
        }
    }

    /* compiled from: source_filter_type */
    public final class LocalPhotoTagTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f2338a = ImmutableList.of(LocalPhotoTagsTable.Columns.a, LocalPhotoTagsTable.Columns.b, LocalPhotoTagsTable.Columns.c, LocalPhotoTagsTable.Columns.d, LocalPhotoTagsTable.Columns.e, LocalPhotoTagsTable.Columns.f, LocalPhotoTagsTable.Columns.g, LocalPhotoTagsTable.Columns.h, LocalPhotoTagsTable.Columns.i, LocalPhotoTagsTable.Columns.j, LocalPhotoTagsTable.Columns.k);

        LocalPhotoTagTable() {
            super("localphototags", f2338a);
        }

        public final void m2451a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String a = SqlTable.a("localphototags", "local_tag_image_hash_idx", ImmutableList.of(LocalPhotoTagsTable.Columns.k));
            SQLiteDetour.a(565523401);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-808363792);
        }
    }

    /* compiled from: source_filter_type */
    public final class RemovedPrefilledTagsTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f2339a = ImmutableList.of(RemovedPreFilledTagsTableProp.Columns.b, RemovedPreFilledTagsTableProp.Columns.a, RemovedPreFilledTagsTableProp.Columns.c);

        RemovedPrefilledTagsTable() {
            super("removedprefilledtags", f2339a);
        }

        public final void m2452a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String a = SqlTable.a("removedprefilledtags", "removed_prefilled_tag_idx", ImmutableList.of(RemovedPreFilledTagsTableProp.Columns.b, RemovedPreFilledTagsTableProp.Columns.a));
            SQLiteDetour.a(1965874458);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(192939863);
        }
    }

    public static com.facebook.photos.db.LocalPhotoTagDbSchemaPart m2453a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2341b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.photos.db.LocalPhotoTagDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f2341b;	 Catch:{ all -> 0x0039 }
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
        r0 = m2454d();	 Catch:{ all -> 0x0034 }
        f2341b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f2341b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.db.LocalPhotoTagDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.photos.db.LocalPhotoTagDbSchemaPart");
    }

    private static LocalPhotoTagDbSchemaPart m2454d() {
        return new LocalPhotoTagDbSchemaPart();
    }

    @Inject
    public LocalPhotoTagDbSchemaPart() {
        super("localphototags", 4, ImmutableList.of(new LocalPhotoTagTable(), new RemovedPrefilledTagsTable(), new LocalPhotoMetaDataTable()));
    }
}
