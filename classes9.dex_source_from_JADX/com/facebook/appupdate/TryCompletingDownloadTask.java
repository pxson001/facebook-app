package com.facebook.appupdate;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.database.Cursor;
import com.facebook.appupdate.AppUpdateState.Builder;
import java.io.File;

/* compiled from: UNDIMMED */
public class TryCompletingDownloadTask implements AppUpdateTask {
    private final AppUpdateFilesManager f23829a;
    private final DownloadManager f23830b;
    private final VerifyDownloadTask f23831c;

    public TryCompletingDownloadTask(AppUpdateFilesManager appUpdateFilesManager, DownloadManager downloadManager, VerifyDownloadTask verifyDownloadTask) {
        this.f23829a = appUpdateFilesManager;
        this.f23830b = downloadManager;
        this.f23831c = verifyDownloadTask;
    }

    public final AppUpdateTaskResult mo1098a(AppUpdateState appUpdateState) {
        if (appUpdateState.operationState != 2) {
            return new AppUpdateTaskResult();
        }
        Query query = new Query();
        query.setFilterById(new long[]{appUpdateState.downloadId});
        Cursor query2 = this.f23830b.query(query);
        Preconditions.a(query2 != null, "Download cursor is null!");
        Preconditions.a(query2.moveToFirst(), "Download not available for checking completion");
        long j = query2.getLong(query2.getColumnIndex("bytes_so_far"));
        long j2 = query2.getLong(query2.getColumnIndex("total_size"));
        int i = query2.getInt(query2.getColumnIndex("status"));
        int i2 = query2.getInt(query2.getColumnIndex("reason"));
        String string = query2.getString(query2.getColumnIndex("local_filename"));
        query2.close();
        if (i == 8) {
            File a = this.f23829a.a(appUpdateState.downloadId);
            Utils.m25832a(new File(string), a);
            a.setReadable(true, false);
            Builder builder = new Builder(appUpdateState);
            builder.f23806c = 3;
            builder = builder;
            builder.f23808e = j;
            builder = builder;
            builder.f23809f = j2;
            builder = builder;
            builder.f23810g = a;
            return new AppUpdateTaskResult(builder.m25818a(), this.f23831c, 0);
        } else if (i != 16) {
            return new AppUpdateTaskResult();
        } else {
            throw new Exception("Download Failed (" + Utils.m25831a(i2) + ")");
        }
    }
}
