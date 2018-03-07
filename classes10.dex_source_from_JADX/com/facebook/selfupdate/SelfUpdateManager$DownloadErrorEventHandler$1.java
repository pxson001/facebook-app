package com.facebook.selfupdate;

import com.facebook.downloader.event.DownloadErrorEvent;
import com.facebook.downloader.event.DownloadErrorEvent.ErrorCode;
import com.facebook.selfupdate.SelfUpdateManager.DownloadErrorEventHandler;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableMap;

/* compiled from: has_logged_first_scroll */
class SelfUpdateManager$DownloadErrorEventHandler$1 implements Runnable {
    final /* synthetic */ DownloadErrorEvent f10001a;
    final /* synthetic */ DownloadErrorEventHandler f10002b;

    SelfUpdateManager$DownloadErrorEventHandler$1(DownloadErrorEventHandler downloadErrorEventHandler, DownloadErrorEvent downloadErrorEvent) {
        this.f10002b = downloadErrorEventHandler;
        this.f10001a = downloadErrorEvent;
    }

    public void run() {
        SelfUpdateManager selfUpdateManager = this.f10002b.a;
        DownloadErrorEvent downloadErrorEvent = this.f10001a;
        ErrorCode errorCode = downloadErrorEvent.c;
        ((SelfUpdateLogger) selfUpdateManager.g.get()).a("selfupdate_download_failed_with_error", ImmutableMap.of("error", errorCode.name(), "source", selfUpdateManager.e.a(SelfUpdateConstants.r, "")));
        if (errorCode == ErrorCode.ERROR_NO_FREE_SPACE_TO_DOWNLOAD) {
            ((SelfUpdateLogger) selfUpdateManager.g.get()).a("selfupdate_no_free_space_to_download", null);
        } else if (errorCode == ErrorCode.ERROR_FAILED_TO_REMOVE_DOWNLOAD_ID) {
            ((SelfUpdateLogger) selfUpdateManager.g.get()).a("Failed to remove download ID from DownloadManager after making a copy: " + downloadErrorEvent.e, downloadErrorEvent.d);
        } else if (errorCode == ErrorCode.ERROR_DOWNLOAD_MANAGER_COMPLETION_EXCEPTION) {
            ((SelfUpdateLogger) selfUpdateManager.g.get()).a("Download Manager complete exception for ID " + downloadErrorEvent.e, downloadErrorEvent.d);
            ObjectNode e = selfUpdateManager.q.e();
            e.a("error_arg", downloadErrorEvent.e);
            e.a("error_exception", downloadErrorEvent.d.getMessage());
            ((SelfUpdateNotifier) selfUpdateManager.i.get()).m10102a("downloadmanager_completion_exception", e);
        } else if (errorCode == ErrorCode.ERROR_DOWNLOAD_MANAGER_FAILURE) {
            ((SelfUpdateNotifier) selfUpdateManager.i.get()).m10102a("downloadmanager_failure", null);
        }
    }
}
