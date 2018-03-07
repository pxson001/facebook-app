package com.facebook.loom.upload;

import com.facebook.loom.core.BackgroundUploadService.BackgroundUploadListener;
import java.io.File;

/* compiled from: thread_view_messages_init_params */
class BackgroundUploadServiceImpl$2 implements Runnable {
    final /* synthetic */ BackgroundUploadListener f1456a;
    final /* synthetic */ File f1457b;
    final /* synthetic */ BackgroundUploadServiceImpl f1458c;

    BackgroundUploadServiceImpl$2(BackgroundUploadServiceImpl backgroundUploadServiceImpl, BackgroundUploadListener backgroundUploadListener, File file) {
        this.f1458c = backgroundUploadServiceImpl;
        this.f1456a = backgroundUploadListener;
        this.f1457b = file;
    }

    public void run() {
        this.f1456a.a(this.f1457b);
    }
}
