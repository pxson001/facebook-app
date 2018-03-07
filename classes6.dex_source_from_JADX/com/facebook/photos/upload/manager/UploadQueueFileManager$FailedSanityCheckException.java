package com.facebook.photos.upload.manager;

import java.io.IOException;

/* compiled from: graph_search/ */
class UploadQueueFileManager$FailedSanityCheckException extends IOException {
    final /* synthetic */ UploadQueueFileManager this$0;

    UploadQueueFileManager$FailedSanityCheckException(UploadQueueFileManager uploadQueueFileManager, String str) {
        this.this$0 = uploadQueueFileManager;
        super(str);
    }
}
