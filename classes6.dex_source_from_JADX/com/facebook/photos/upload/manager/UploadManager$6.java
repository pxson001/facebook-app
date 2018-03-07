package com.facebook.photos.upload.manager;

import com.google.common.collect.Lists;
import java.util.ArrayList;

/* compiled from: graph_search_results_page_app */
class UploadManager$6 implements Runnable {
    final /* synthetic */ UploadManager f13645a;

    UploadManager$6(UploadManager uploadManager) {
        this.f13645a = uploadManager;
    }

    public void run() {
        ArrayList a = Lists.a(this.f13645a.w.values());
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ((UploadManager$QueuedOperation) a.get(i)).f13650a.f();
        }
    }
}
