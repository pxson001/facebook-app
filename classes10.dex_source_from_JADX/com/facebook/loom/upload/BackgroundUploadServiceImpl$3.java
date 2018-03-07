package com.facebook.loom.upload;

import com.facebook.loom.core.BackgroundUploadService.BackgroundUploadListener;
import java.io.File;

/* compiled from: thread_view_messages_init_params */
class BackgroundUploadServiceImpl$3 implements Runnable {
    final /* synthetic */ BackgroundUploadListener f1459a;
    final /* synthetic */ File f1460b;
    final /* synthetic */ BackgroundUploadServiceImpl f1461c;

    BackgroundUploadServiceImpl$3(BackgroundUploadServiceImpl backgroundUploadServiceImpl, BackgroundUploadListener backgroundUploadListener, File file) {
        this.f1461c = backgroundUploadServiceImpl;
        this.f1459a = backgroundUploadListener;
        this.f1460b = file;
    }

    public void run() {
        this.f1459a.b(this.f1460b);
    }
}
