package com.facebook.photos.upload.manager;

import com.facebook.photos.upload.operation.UploadOperation;

/* compiled from: graph_search_results_page_app */
public class UploadManager$7 {
    public final /* synthetic */ UploadOperation f13646a;
    public final /* synthetic */ String f13647b;
    public final /* synthetic */ UploadManager f13648c;

    UploadManager$7(UploadManager uploadManager, UploadOperation uploadOperation, String str) {
        this.f13648c = uploadManager;
        this.f13646a = uploadOperation;
        this.f13647b = str;
    }

    public final void m21389a() {
        ((UploadNotificationManager) this.f13648c.c.get()).m21418a(this.f13646a, this.f13647b, false, null);
    }
}
