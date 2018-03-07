package com.facebook.photos.upload.manager;

import com.facebook.common.executors.NamedRunnable;
import com.facebook.photos.upload.disk.UploadTempFileManager;

/* compiled from: graph_search_results_page_app */
class UploadManager$4 extends NamedRunnable {
    final /* synthetic */ UploadManager f13641c;

    UploadManager$4(UploadManager uploadManager, String str, String str2) {
        this.f13641c = uploadManager;
        super(str, str2);
    }

    public void run() {
        ((UploadTempFileManager) this.f13641c.j.get()).m21337a();
    }
}
