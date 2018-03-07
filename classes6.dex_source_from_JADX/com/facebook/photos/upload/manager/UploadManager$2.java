package com.facebook.photos.upload.manager;

/* compiled from: graph_search_results_page_app */
public class UploadManager$2 {
    final /* synthetic */ UploadManager f13636a;

    UploadManager$2(UploadManager uploadManager) {
        this.f13636a = uploadManager;
    }

    public final void m21388a(int i) {
        this.f13636a.v = true;
        Integer.valueOf(i);
        if (i > 50) {
            UploadManager.g(this.f13636a, "Network connected retry");
        }
    }
}
