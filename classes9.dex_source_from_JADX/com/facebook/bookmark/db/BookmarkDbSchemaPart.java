package com.facebook.bookmark.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarkGroupOrderTable;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarkSyncStatusTable;
import com.facebook.bookmark.ipc.BookmarkContract$BookmarksTable.Columns;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: regions */
public class BookmarkDbSchemaPart extends TablesDbSchemaPart {
    private static final Class<?> f5640a = BookmarkDbSchemaPart.class;
    private static volatile BookmarkDbSchemaPart f5641b;

    /* compiled from: regions */
    public final class BookmarkTable extends SqlTable {
        BookmarkTable() {
            super("bookmarks", ImmutableList.of(Columns.f5654a, Columns.f5655b, Columns.f5656c, Columns.f5657d, Columns.f5658e, Columns.f5659f, Columns.f5660g, Columns.f5661h, Columns.f5662i, Columns.f5663j, Columns.f5664k, Columns.f5665l, new SqlColumn[0]));
        }

        public final void m5850a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String a = SqlTable.a("bookmarks", "BOOKMARK_FBID_INDEX", ImmutableList.of(Columns.f5655b));
            SQLiteDetour.a(-1108916975);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(1849661129);
            a = SqlTable.a("bookmarks", "GROUP_ID_INDEX", ImmutableList.of(Columns.f5663j));
            SQLiteDetour.a(844854135);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-71022359);
        }
    }

    /* compiled from: regions */
    public final class GroupOrderTable extends SqlTable {
        GroupOrderTable() {
            super("bookmark_group", ImmutableList.of(BookmarkContract$BookmarkGroupOrderTable.Columns.f5645a, BookmarkContract$BookmarkGroupOrderTable.Columns.f5646b, BookmarkContract$BookmarkGroupOrderTable.Columns.f5647c, BookmarkContract$BookmarkGroupOrderTable.Columns.f5648d, BookmarkContract$BookmarkGroupOrderTable.Columns.f5649e));
        }
    }

    /* compiled from: regions */
    public final class SyncStatusTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f5638a = ImmutableList.of(BookmarkContract$BookmarkSyncStatusTable.Columns.f5651a, BookmarkContract$BookmarkSyncStatusTable.Columns.f5652b);
        private static final String f5639b = ("INSERT INTO bookmark_sync_status (" + BookmarkContract$BookmarkSyncStatusTable.Columns.f5651a.d + ", " + BookmarkContract$BookmarkSyncStatusTable.Columns.f5652b.d + ") VALUES (0, 0)");

        SyncStatusTable() {
            super("bookmark_sync_status", f5638a);
        }

        public final void m5851a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = f5639b;
            SQLiteDetour.a(1551330422);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-300334574);
        }

        public final void m5852d(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(BookmarkContract$BookmarkSyncStatusTable.Columns.f5652b.d, Integer.valueOf(0));
            contentValues.put(BookmarkContract$BookmarkSyncStatusTable.Columns.f5651a.d, Integer.valueOf(0));
            sQLiteDatabase.update("bookmark_sync_status", contentValues, null, null);
        }
    }

    public static com.facebook.bookmark.db.BookmarkDbSchemaPart m5853a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5641b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.bookmark.db.BookmarkDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f5641b;	 Catch:{ all -> 0x0039 }
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
        r0 = m5854d();	 Catch:{ all -> 0x0034 }
        f5641b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f5641b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bookmark.db.BookmarkDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.bookmark.db.BookmarkDbSchemaPart");
    }

    private static BookmarkDbSchemaPart m5854d() {
        return new BookmarkDbSchemaPart();
    }

    @Inject
    public BookmarkDbSchemaPart() {
        super("bookmark", 5, ImmutableList.of(new BookmarkTable(), new GroupOrderTable(), new SyncStatusTable()));
    }
}
