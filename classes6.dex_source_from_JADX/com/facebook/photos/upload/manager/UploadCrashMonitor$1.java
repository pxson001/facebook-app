package com.facebook.photos.upload.manager;

import com.google.common.util.concurrent.FutureCallback;

/* compiled from: graph_search_results_page_blended */
class UploadCrashMonitor$1 implements FutureCallback<Void> {
    final /* synthetic */ UploadCrashMonitor f13635a;

    UploadCrashMonitor$1(UploadCrashMonitor uploadCrashMonitor) {
        this.f13635a = uploadCrashMonitor;
    }

    public void onSuccess(Object obj) {
        UploadCrashMonitor.a(this.f13635a);
    }

    public void onFailure(Throwable th) {
        UploadCrashMonitor.a(this.f13635a);
    }
}
