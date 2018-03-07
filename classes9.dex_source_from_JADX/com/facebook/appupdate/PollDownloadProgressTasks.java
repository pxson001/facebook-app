package com.facebook.appupdate;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.database.Cursor;
import com.facebook.appupdate.AppUpdateState.Builder;

/* compiled from: UNGROUPED */
public class PollDownloadProgressTasks {
    public final DownloadManager f23820a;
    public boolean f23821b = false;
    public boolean f23822c = false;
    private final AppUpdateTask f23823d = new C28821(this);
    public final AppUpdateTask f23824e = new C28832(this);
    private final AppUpdateTask f23825f = new C28843(this);

    /* compiled from: UNGROUPED */
    class C28821 implements AppUpdateTask {
        final /* synthetic */ PollDownloadProgressTasks f23817a;

        C28821(PollDownloadProgressTasks pollDownloadProgressTasks) {
            this.f23817a = pollDownloadProgressTasks;
        }

        public final AppUpdateTaskResult mo1098a(AppUpdateState appUpdateState) {
            this.f23817a.f23821b = true;
            if (this.f23817a.f23822c) {
                return new AppUpdateTaskResult();
            }
            return new AppUpdateTaskResult(null, this.f23817a.f23824e, 0);
        }
    }

    /* compiled from: UNGROUPED */
    class C28832 implements AppUpdateTask {
        final /* synthetic */ PollDownloadProgressTasks f23818a;

        C28832(PollDownloadProgressTasks pollDownloadProgressTasks) {
            this.f23818a = pollDownloadProgressTasks;
        }

        public final AppUpdateTaskResult mo1098a(AppUpdateState appUpdateState) {
            boolean z = true;
            if (!this.f23818a.f23821b) {
                this.f23818a.f23822c = false;
                return new AppUpdateTaskResult();
            } else if (appUpdateState.operationState < 2) {
                return new AppUpdateTaskResult(null, this, 300);
            } else {
                if (appUpdateState.operationState != 2) {
                    return new AppUpdateTaskResult();
                }
                Preconditions.a(appUpdateState.downloadId > 0, "In STATE_DOWNLOADING but downloadId is " + appUpdateState.downloadId);
                Query query = new Query();
                query.setFilterById(new long[]{appUpdateState.downloadId});
                Cursor query2 = this.f23818a.f23820a.query(query);
                if (query2 == null) {
                    z = false;
                }
                Preconditions.a(z, "Download cursor is null!");
                Preconditions.a(query2.moveToFirst(), "Download not available for checking completion");
                long j = query2.getLong(query2.getColumnIndex("bytes_so_far"));
                long j2 = query2.getLong(query2.getColumnIndex("total_size"));
                query2.close();
                Builder builder = new Builder(appUpdateState);
                builder.f23808e = j;
                builder = builder;
                builder.f23809f = j2;
                return new AppUpdateTaskResult(builder.m25818a(), this, 300);
            }
        }
    }

    /* compiled from: UNGROUPED */
    class C28843 implements AppUpdateTask {
        final /* synthetic */ PollDownloadProgressTasks f23819a;

        C28843(PollDownloadProgressTasks pollDownloadProgressTasks) {
            this.f23819a = pollDownloadProgressTasks;
        }

        public final AppUpdateTaskResult mo1098a(AppUpdateState appUpdateState) {
            this.f23819a.f23821b = false;
            return new AppUpdateTaskResult();
        }
    }

    public PollDownloadProgressTasks(DownloadManager downloadManager) {
        this.f23820a = downloadManager;
    }

    public final AppUpdateTask m25825a() {
        return this.f23823d;
    }

    public final AppUpdateTask m25826b() {
        return this.f23825f;
    }
}
