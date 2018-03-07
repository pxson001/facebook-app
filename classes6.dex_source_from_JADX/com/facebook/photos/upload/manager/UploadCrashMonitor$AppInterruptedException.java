package com.facebook.photos.upload.manager;

import com.facebook.photos.base.analytics.ExceptionInterpreter.Diagnostic;
import com.facebook.photos.base.analytics.InterpretedException;

/* compiled from: graph_search_results_page_blended */
class UploadCrashMonitor$AppInterruptedException extends InterpretedException {
    final /* synthetic */ UploadCrashMonitor this$0;

    UploadCrashMonitor$AppInterruptedException(UploadCrashMonitor uploadCrashMonitor) {
        this.this$0 = uploadCrashMonitor;
        super("App Interrupted", true, Diagnostic.APP_INTERRUPTED_TOO_MANY_TIMES);
    }
}
