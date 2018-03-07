package com.facebook.selfupdate;

import com.facebook.downloader.event.DownloadSuccessEvent;
import com.facebook.selfupdate.SelfUpdateManager.DownloadSuccessEventHandler;

/* compiled from: has_logged_first_scroll */
class SelfUpdateManager$DownloadSuccessEventHandler$1 implements Runnable {
    final /* synthetic */ DownloadSuccessEvent f10003a;
    final /* synthetic */ DownloadSuccessEventHandler f10004b;

    SelfUpdateManager$DownloadSuccessEventHandler$1(DownloadSuccessEventHandler downloadSuccessEventHandler, DownloadSuccessEvent downloadSuccessEvent) {
        this.f10004b = downloadSuccessEventHandler;
        this.f10003a = downloadSuccessEvent;
    }

    public void run() {
        this.f10004b.a.a(this.f10003a.d, this.f10003a.e);
    }
}
