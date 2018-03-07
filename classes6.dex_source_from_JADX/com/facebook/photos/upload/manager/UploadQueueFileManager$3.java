package com.facebook.photos.upload.manager;

/* compiled from: graph_search/ */
class UploadQueueFileManager$3 implements Runnable {
    final /* synthetic */ UploadQueueFileManager f13685a;

    UploadQueueFileManager$3(UploadQueueFileManager uploadQueueFileManager) {
        this.f13685a = uploadQueueFileManager;
    }

    public void run() {
        this.f13685a.d.delete();
    }
}
