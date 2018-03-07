package com.facebook.appupdate;

import android.app.DownloadManager;
import com.facebook.appupdate.AppUpdateState.Builder;
import java.util.jar.JarFile;

/* compiled from: UNDER_MANUAL_REVIEW */
public class VerifyDownloadTask implements AppUpdateTask {
    private final DownloadManager f23832a;

    public VerifyDownloadTask(DownloadManager downloadManager) {
        this.f23832a = downloadManager;
    }

    public final AppUpdateTaskResult mo1098a(AppUpdateState appUpdateState) {
        if (appUpdateState.operationState != 3) {
            return new AppUpdateTaskResult();
        }
        this.f23832a.remove(new long[]{appUpdateState.downloadId});
        new JarFile(appUpdateState.localFile).close();
        Builder builder = new Builder(appUpdateState);
        builder.f23806c = 4;
        builder = builder;
        builder.f23812i = System.currentTimeMillis();
        builder = builder;
        builder.f23807d = -1;
        return new AppUpdateTaskResult(builder.m25818a());
    }
}
