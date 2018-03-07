package com.facebook.photos.upload.manager;

import com.facebook.photos.upload.operation.UploadOperation;
import java.io.DataOutputStream;

/* compiled from: graph_search/ */
class UploadQueueFileManager$2 extends UploadQueueFileManager$QueueWriter {
    final /* synthetic */ UploadQueueFileManager f13684a;

    UploadQueueFileManager$2(UploadQueueFileManager uploadQueueFileManager, UploadOperation uploadOperation) {
        this.f13684a = uploadQueueFileManager;
        super(uploadQueueFileManager, uploadOperation);
    }

    final void mo1141a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(UploadQueueFileManager$FieldType.CompletedOperation.ordinal());
        dataOutputStream.writeUTF(this.f13681b.f13793p);
    }
}
