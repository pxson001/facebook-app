package com.facebook.video.downloadmanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: connection_sub_type */
public class SavedVideoDbAnalyticsSchemaPart extends TablesDbSchemaPart {
    public static final SqlTable f18675a = new SavedVideoDbAnalyticsTable();
    private static final String f18676b = (Columns.f18667a.d + "= ?");
    private static final String f18677c = (Columns.f18667a.d + " = ?");
    private static volatile SavedVideoDbAnalyticsSchemaPart f18678d;

    /* compiled from: connection_sub_type */
    public class Columns {
        public static final SqlColumn f18667a = new SqlColumn("video_id", "TEXT");
        public static final SqlColumn f18668b = new SqlColumn("download_attempts", "INT");
        public static final SqlColumn f18669c = new SqlColumn("download_start_time", "BIGINT");
        public static final SqlColumn f18670d = new SqlColumn("download_end_time", "BIGINT");
        public static final SqlColumn f18671e = new SqlColumn("view_count", "INT");
        public static final SqlColumn f18672f = new SqlColumn("download_origin", "TEXT");
    }

    /* compiled from: connection_sub_type */
    public class SavedVideoDbAnalyticsTable extends SqlTable {
        private static final SqlKey f18673a = new PrimaryKey(ImmutableList.of(Columns.f18667a));
        private static final ImmutableList<SqlColumn> f18674b = ImmutableList.of(Columns.f18667a, Columns.f18668b, Columns.f18669c, Columns.f18670d, Columns.f18671e, Columns.f18672f);

        public SavedVideoDbAnalyticsTable() {
            super("saved_videos_analytics", f18674b, f18673a);
        }
    }

    public static com.facebook.video.downloadmanager.SavedVideoDbAnalyticsSchemaPart m27420a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18678d;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.video.downloadmanager.SavedVideoDbAnalyticsSchemaPart.class;
        monitor-enter(r1);
        r0 = f18678d;	 Catch:{ all -> 0x0039 }
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
        r0 = m27427d();	 Catch:{ all -> 0x0034 }
        f18678d = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f18678d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.downloadmanager.SavedVideoDbAnalyticsSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.video.downloadmanager.SavedVideoDbAnalyticsSchemaPart");
    }

    private static SavedVideoDbAnalyticsSchemaPart m27427d() {
        return new SavedVideoDbAnalyticsSchemaPart();
    }

    @Inject
    public SavedVideoDbAnalyticsSchemaPart() {
        super("saved_videos_analytics", 1, ImmutableList.of(f18675a));
    }

    private static Cursor m27426d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.query("saved_videos_analytics", null, f18676b, new String[]{str}, null, null, null, null);
    }

    private static boolean m27428e(SQLiteDatabase sQLiteDatabase, String str) {
        Throwable th;
        Cursor cursor;
        boolean z = true;
        Cursor cursor2 = null;
        try {
            cursor2 = m27426d(sQLiteDatabase, str);
            try {
                boolean z2;
                if (cursor2.getCount() <= 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkState(z2);
                if (cursor2.getCount() != 1) {
                    z = false;
                }
                if (!(cursor2 == null || cursor2.isClosed())) {
                    cursor2.close();
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursor2;
                if (!(cursor == null || cursor.isClosed())) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = cursor2;
            cursor.close();
            throw th;
        }
    }

    public static VideoDownloadAnalyticsRecord m27421a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor d;
        Throwable th;
        VideoDownloadAnalyticsRecord videoDownloadAnalyticsRecord = null;
        try {
            d = m27426d(sQLiteDatabase, str);
            try {
                Preconditions.checkState(d.getCount() <= 1);
                if (d.getCount() == 1) {
                    d.moveToFirst();
                    videoDownloadAnalyticsRecord = new VideoDownloadAnalyticsRecord();
                    videoDownloadAnalyticsRecord.f18710a = d.getString(d.getColumnIndex(Columns.f18667a.a()));
                    videoDownloadAnalyticsRecord.f18711b = d.getInt(d.getColumnIndex(Columns.f18668b.a()));
                    videoDownloadAnalyticsRecord.f18712c = d.getLong(d.getColumnIndex(Columns.f18669c.a()));
                    videoDownloadAnalyticsRecord.f18713d = d.getLong(d.getColumnIndex(Columns.f18670d.a()));
                    videoDownloadAnalyticsRecord.f18714e = d.getInt(d.getColumnIndex(Columns.f18671e.a()));
                    videoDownloadAnalyticsRecord.f18715f = d.getString(d.getColumnIndex(Columns.f18672f.a()));
                }
                if (!(d == null || d.isClosed())) {
                    d.close();
                }
                return videoDownloadAnalyticsRecord;
            } catch (Throwable th2) {
                th = th2;
                if (!(d == null || d.isClosed())) {
                    d.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            d = null;
            d.close();
            throw th;
        }
    }

    public static boolean m27423a(SQLiteDatabase sQLiteDatabase, String str, long j, String str2) {
        if (m27428e(sQLiteDatabase, str)) {
            throw new IllegalArgumentException("Analytics record already exists");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f18667a.d, str);
        contentValues.put(Columns.f18668b.d, Integer.valueOf(0));
        contentValues.put(Columns.f18669c.d, Long.valueOf(j));
        contentValues.put(Columns.f18670d.d, Integer.valueOf(-1));
        contentValues.put(Columns.f18671e.d, Integer.valueOf(0));
        contentValues.put(Columns.f18672f.d, str2);
        SQLiteDetour.a(-625653912);
        long insert = sQLiteDatabase.insert("saved_videos_analytics", null, contentValues);
        SQLiteDetour.a(-64956660);
        if (insert != -1) {
            return true;
        }
        return false;
    }

    public static void m27422a(SQLiteDatabase sQLiteDatabase, String str, long j) {
        if (m27421a(sQLiteDatabase, str) != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.f18670d.d, Long.valueOf(j));
            sQLiteDatabase.update("saved_videos_analytics", contentValues, Columns.f18667a.d + "= ?", new String[]{r0.f18710a});
        }
    }

    public static void m27424b(SQLiteDatabase sQLiteDatabase, String str) {
        VideoDownloadAnalyticsRecord a = m27421a(sQLiteDatabase, str);
        if (a != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.f18668b.d, Integer.valueOf(a.f18711b + 1));
            sQLiteDatabase.update("saved_videos_analytics", contentValues, Columns.f18667a.d + "= ?", new String[]{a.f18710a});
        }
    }

    public static boolean m27425c(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.delete("saved_videos_analytics", f18677c, new String[]{str}) > 0;
    }
}
