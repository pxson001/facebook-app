package com.facebook.messaging.media.upload;

import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.messaging.media.upload.util.MediaUploadKey;

/* compiled from: local_status_on_client */
class MediaOperationManager$1 implements Runnable {
    final /* synthetic */ MediaUploadKey f11852a;
    final /* synthetic */ OperationFuture f11853b;
    final /* synthetic */ MediaOperationManager f11854c;

    MediaOperationManager$1(MediaOperationManager mediaOperationManager, MediaUploadKey mediaUploadKey, OperationFuture operationFuture) {
        this.f11854c = mediaOperationManager;
        this.f11852a = mediaUploadKey;
        this.f11853b = operationFuture;
    }

    public void run() {
        MediaOperationManager.a(this.f11854c, this.f11852a, this.f11853b);
    }
}
