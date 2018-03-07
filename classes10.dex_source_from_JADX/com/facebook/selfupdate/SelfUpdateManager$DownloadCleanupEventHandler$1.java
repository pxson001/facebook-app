package com.facebook.selfupdate;

import com.facebook.selfupdate.SelfUpdateManager.DownloadCleanupEventHandler;

/* compiled from: has_logged_first_scroll */
class SelfUpdateManager$DownloadCleanupEventHandler$1 implements Runnable {
    final /* synthetic */ DownloadCleanupEventHandler f10000a;

    SelfUpdateManager$DownloadCleanupEventHandler$1(DownloadCleanupEventHandler downloadCleanupEventHandler) {
        this.f10000a = downloadCleanupEventHandler;
    }

    public void run() {
        ((SelfUpdateNotifier) this.f10000a.a.i.get()).m10102a("download_cleanup_event", null);
    }
}
