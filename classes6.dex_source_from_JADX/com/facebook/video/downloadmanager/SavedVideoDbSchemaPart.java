package com.facebook.video.downloadmanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.video.events.VideoDownloadStatus.DownloadStatus;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: connection_manager_rtt_ms */
public class SavedVideoDbSchemaPart extends TablesDbSchemaPart {
    public static final SqlTable f18699a = new SavedVideoDbTable();
    private static final String f18700b = SavedVideoDbSchemaPart.class.getName();
    private static final String f18701c = (Columns.f18691a.d + "= ?");
    private static final String f18702d = (Columns.f18695e.d + "=" + DownloadStatus.DOWNLOAD_NOT_STARTED.mValue);
    private static final String f18703e = (Columns.f18695e.d + "=" + DownloadStatus.DOWNLOAD_FAILED.mValue);
    private static final String f18704f = (Columns.f18691a.d + " = ?");
    private static volatile SavedVideoDbSchemaPart f18705g;

    /* compiled from: connection_manager_rtt_ms */
    public class Columns {
        public static final SqlColumn f18691a = new SqlColumn("video_id", "TEXT");
        public static final SqlColumn f18692b = new SqlColumn("video_url", "TEXT");
        public static final SqlColumn f18693c = new SqlColumn("video_size", "INTEGER");
        public static final SqlColumn f18694d = new SqlColumn("video_downloaded_size", "INTEGER");
        public static final SqlColumn f18695e = new SqlColumn("download_status", "INTEGER");
        public static final SqlColumn f18696f = new SqlColumn("video_file", "TEXT");
    }

    /* compiled from: connection_manager_rtt_ms */
    public class SavedVideoDbTable extends SqlTable {
        private static final SqlKey f18697a = new PrimaryKey(ImmutableList.of(Columns.f18691a));
        private static final ImmutableList<SqlColumn> f18698b = ImmutableList.of(Columns.f18691a, Columns.f18692b, Columns.f18693c, Columns.f18694d, Columns.f18695e, Columns.f18696f);

        public SavedVideoDbTable() {
            super("saved_videos", f18698b, f18697a);
        }
    }

    public static com.facebook.video.downloadmanager.SavedVideoDbSchemaPart m27443a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18705g;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.video.downloadmanager.SavedVideoDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f18705g;	 Catch:{ all -> 0x0039 }
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
        r0 = m27455d();	 Catch:{ all -> 0x0034 }
        f18705g = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f18705g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.downloadmanager.SavedVideoDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.video.downloadmanager.SavedVideoDbSchemaPart");
    }

    private static SavedVideoDbSchemaPart m27455d() {
        return new SavedVideoDbSchemaPart();
    }

    @Inject
    public SavedVideoDbSchemaPart() {
        super("saved_videos", 1, ImmutableList.of(f18699a));
    }

    private static ContentValues m27442a(VideoDownloadRecord videoDownloadRecord, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put(Columns.f18691a.d, videoDownloadRecord.f18725a);
            contentValues.put(Columns.f18692b.d, videoDownloadRecord.f18726b.toString());
            contentValues.put(Columns.f18696f.d, videoDownloadRecord.f18729e);
        }
        contentValues.put(Columns.f18693c.d, Long.valueOf(videoDownloadRecord.f18727c));
        contentValues.put(Columns.f18694d.d, Long.valueOf(videoDownloadRecord.f18728d));
        contentValues.put(Columns.f18695e.d, Integer.valueOf(videoDownloadRecord.f18730f.mValue));
        return contentValues;
    }

    private static void m27451a(VideoDownloadRecord videoDownloadRecord) {
        if (videoDownloadRecord.f18725a == null || videoDownloadRecord.f18725a.isEmpty()) {
            throw new IllegalArgumentException("Video id cannot be empty or null");
        } else if (videoDownloadRecord.f18726b == null) {
            throw new IllegalArgumentException("Video URL cannot be empty.");
        } else if (videoDownloadRecord.f18728d > videoDownloadRecord.f18727c) {
            throw new IllegalArgumentException("Invalid stream sizes. Video size: " + videoDownloadRecord.f18727c + " Downloaded: " + videoDownloadRecord.f18728d);
        }
    }

    public static boolean m27452a(SQLiteDatabase sQLiteDatabase, VideoDownloadRecord videoDownloadRecord) {
        if (m27446a(sQLiteDatabase, videoDownloadRecord.f18725a) != null) {
            throw new IllegalArgumentException("Record already exists");
        }
        m27451a(videoDownloadRecord);
        ContentValues a = m27442a(videoDownloadRecord, true);
        SQLiteDetour.a(-836198264);
        long insert = sQLiteDatabase.insert("saved_videos", null, a);
        SQLiteDetour.a(-205180648);
        if (insert != -1) {
            return true;
        }
        return false;
    }

    private static void m27453b(SQLiteDatabase sQLiteDatabase, VideoDownloadRecord videoDownloadRecord) {
        m27451a(videoDownloadRecord);
        sQLiteDatabase.update("saved_videos", m27442a(videoDownloadRecord, false), Columns.f18691a.d + "= ?", new String[]{videoDownloadRecord.f18725a});
    }

    public static VideoDownloadRecord m27446a(SQLiteDatabase sQLiteDatabase, String str) {
        return m27448a(sQLiteDatabase, f18701c, new String[]{str});
    }

    public static VideoDownloadRecord m27445a(SQLiteDatabase sQLiteDatabase, DownloadStatus downloadStatus) {
        if (downloadStatus == DownloadStatus.DOWNLOAD_NOT_STARTED) {
            return m27448a(sQLiteDatabase, f18702d, null);
        }
        if (downloadStatus == DownloadStatus.DOWNLOAD_FAILED) {
            return m27448a(sQLiteDatabase, f18703e, null);
        }
        return null;
    }

    private static VideoDownloadRecord m27444a(Cursor cursor) {
        VideoDownloadRecord videoDownloadRecord = new VideoDownloadRecord();
        videoDownloadRecord.f18725a = cursor.getString(cursor.getColumnIndex(Columns.f18691a.d));
        String string = cursor.getString(cursor.getColumnIndex(Columns.f18692b.d));
        Uri parse = (string == null || string.isEmpty()) ? null : Uri.parse(string);
        videoDownloadRecord.f18726b = parse;
        videoDownloadRecord.f18727c = cursor.getLong(cursor.getColumnIndex(Columns.f18693c.d));
        videoDownloadRecord.f18728d = cursor.getLong(cursor.getColumnIndex(Columns.f18694d.d));
        videoDownloadRecord.f18730f = DownloadStatus.fromVal(cursor.getInt(cursor.getColumnIndex(Columns.f18695e.d)));
        videoDownloadRecord.f18729e = cursor.getString(cursor.getColumnIndex(Columns.f18696f.d));
        return videoDownloadRecord;
    }

    private static VideoDownloadRecord m27448a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        boolean z = true;
        List a = m27449a(sQLiteDatabase, str, strArr, 1);
        if (a.isEmpty()) {
            return null;
        }
        if (a.size() != 1) {
            z = false;
        }
        Preconditions.checkState(z);
        return (VideoDownloadRecord) a.get(0);
    }

    private static List<VideoDownloadRecord> m27449a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, int i) {
        String str2;
        List<VideoDownloadRecord> arrayList = new ArrayList();
        String str3 = "saved_videos";
        if (i == -1) {
            str2 = null;
        } else {
            str2 = String.valueOf(i);
        }
        Cursor query = sQLiteDatabase.query(str3, null, str, strArr, null, null, null, str2);
        try {
            if (query.moveToFirst()) {
                int count = i == -1 ? query.getCount() : Math.min(i, query.getCount());
                for (int i2 = 0; i2 < count; i2++) {
                    arrayList.add(m27444a(query));
                    if (!query.moveToNext()) {
                        break;
                    }
                }
            }
            if (!(query == null || query.isClosed())) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (!(query == null || query.isClosed())) {
                query.close();
            }
        }
    }

    public static boolean m27454b(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.delete("saved_videos", f18704f, new String[]{str}) > 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.video.downloadmanager.VideoDownloadRecord m27447a(android.database.sqlite.SQLiteDatabase r9, java.lang.String r10, com.facebook.video.events.VideoDownloadStatus.DownloadStatus r11) {
        /*
        r0 = m27446a(r9, r10);
        if (r0 != 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Unknown video id";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r6 = 0;
        r7 = com.facebook.video.downloadmanager.SavedVideoDbSchemaPart.C13951.f18690a;
        r8 = r11.ordinal();
        r7 = r7[r8];
        switch(r7) {
            case 1: goto L_0x0041;
            case 2: goto L_0x004f;
            case 3: goto L_0x0056;
            case 4: goto L_0x0056;
            case 5: goto L_0x0056;
            case 6: goto L_0x005d;
            default: goto L_0x001a;
        };
    L_0x001a:
        r1 = r6;
        if (r1 == 0) goto L_0x0023;
    L_0x001d:
        r0.f18730f = r11;
        m27453b(r9, r0);
    L_0x0022:
        return r0;
    L_0x0023:
        r1 = f18700b;
        r2 = "Invalid status update for video %s from %s to %s";
        r3 = 3;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r10;
        r4 = 1;
        r5 = r0.f18730f;
        r5 = r5.toString();
        r3[r4] = r5;
        r4 = 2;
        r5 = r11.toString();
        r3[r4] = r5;
        com.facebook.debug.log.BLog.b(r1, r2, r3);
        goto L_0x0022;
    L_0x0041:
        r7 = r0.f18730f;
        r8 = com.facebook.video.events.VideoDownloadStatus.DownloadStatus.DOWNLOAD_IN_PROGRESS;
        if (r7 == r8) goto L_0x001a;
    L_0x0047:
        r7 = r0.f18730f;
        r8 = com.facebook.video.events.VideoDownloadStatus.DownloadStatus.DOWNLOAD_COMPLETED;
        if (r7 == r8) goto L_0x001a;
    L_0x004d:
        r6 = 1;
        goto L_0x001a;
    L_0x004f:
        r7 = r0.f18730f;
        r8 = com.facebook.video.events.VideoDownloadStatus.DownloadStatus.DOWNLOAD_NOT_STARTED;
        if (r7 != r8) goto L_0x001a;
    L_0x0055:
        goto L_0x004d;
    L_0x0056:
        r7 = r0.f18730f;
        r8 = com.facebook.video.events.VideoDownloadStatus.DownloadStatus.DOWNLOAD_IN_PROGRESS;
        if (r7 != r8) goto L_0x001a;
    L_0x005c:
        goto L_0x004d;
    L_0x005d:
        r7 = r0.f18730f;
        r8 = com.facebook.video.events.VideoDownloadStatus.DownloadStatus.DOWNLOAD_NOT_STARTED;
        if (r7 == r8) goto L_0x004d;
    L_0x0063:
        r7 = r0.f18730f;
        r8 = com.facebook.video.events.VideoDownloadStatus.DownloadStatus.DOWNLOAD_IN_PROGRESS;
        if (r7 == r8) goto L_0x004d;
    L_0x0069:
        r7 = r0.f18730f;
        r8 = com.facebook.video.events.VideoDownloadStatus.DownloadStatus.DOWNLOAD_FAILED;
        if (r7 != r8) goto L_0x001a;
    L_0x006f:
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.downloadmanager.SavedVideoDbSchemaPart.a(android.database.sqlite.SQLiteDatabase, java.lang.String, com.facebook.video.events.VideoDownloadStatus$DownloadStatus):com.facebook.video.downloadmanager.VideoDownloadRecord");
    }

    public static void m27450a(SQLiteDatabase sQLiteDatabase, String str, long j) {
        VideoDownloadRecord a = m27446a(sQLiteDatabase, str);
        if (a == null) {
            throw new IllegalArgumentException("Unknown video id" + str);
        } else if (a.f18728d > a.f18727c) {
            throw new IllegalArgumentException("Video download delta exceeds total video size");
        } else {
            a.f18728d = j;
            m27453b(sQLiteDatabase, a);
        }
    }

    public static List<VideoDownloadRecord> m27456d(SQLiteDatabase sQLiteDatabase) {
        return m27449a(sQLiteDatabase, null, null, -1);
    }
}
