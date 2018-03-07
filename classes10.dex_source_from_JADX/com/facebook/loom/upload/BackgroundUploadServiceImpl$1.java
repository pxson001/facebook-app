package com.facebook.loom.upload;

import com.facebook.loom.core.BackgroundUploadService.BackgroundUploadListener;
import java.io.File;

/* compiled from: thread_view_messages_init_params */
class BackgroundUploadServiceImpl$1 implements Runnable {
    final /* synthetic */ File f1452a;
    final /* synthetic */ BackgroundUploadListener f1453b;
    final /* synthetic */ boolean f1454c;
    final /* synthetic */ BackgroundUploadServiceImpl f1455d;

    BackgroundUploadServiceImpl$1(BackgroundUploadServiceImpl backgroundUploadServiceImpl, File file, BackgroundUploadListener backgroundUploadListener, boolean z) {
        this.f1455d = backgroundUploadServiceImpl;
        this.f1452a = file;
        this.f1453b = backgroundUploadListener;
        this.f1454c = z;
    }

    public void run() {
        if (this.f1452a.exists()) {
            synchronized (this.f1455d.f) {
                this.f1455d.f.add(this.f1452a);
            }
            BackgroundUploadServiceImpl.a(this.f1455d, this.f1452a, this.f1453b, this.f1454c);
            synchronized (this.f1455d.f) {
                this.f1455d.f.remove(this.f1452a);
            }
        }
    }
}
