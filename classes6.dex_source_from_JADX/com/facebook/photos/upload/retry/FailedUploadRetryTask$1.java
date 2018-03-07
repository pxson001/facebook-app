package com.facebook.photos.upload.retry;

import com.facebook.photos.upload.manager.UploadManager;

/* compiled from: fundraiser_cover_photo */
class FailedUploadRetryTask$1 implements Runnable {
    final /* synthetic */ UploadManager f14218a;
    final /* synthetic */ FailedUploadRetryTask f14219b;

    FailedUploadRetryTask$1(FailedUploadRetryTask failedUploadRetryTask, UploadManager uploadManager) {
        this.f14219b = failedUploadRetryTask;
        this.f14218a = uploadManager;
    }

    public void run() {
        this.f14218a.c("Scheduled retry");
    }
}
