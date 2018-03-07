package com.facebook.photos.upload.manager;

import com.facebook.photos.upload.operation.UploadOperation;
import java.io.DataOutput;
import java.io.DataOutputStream;

/* compiled from: graph_search/ */
class UploadQueueFileManager$1 extends UploadQueueFileManager$QueueWriter {
    final /* synthetic */ UploadQueueFileManager f13683a;

    UploadQueueFileManager$1(UploadQueueFileManager uploadQueueFileManager, UploadOperation uploadOperation) {
        this.f13683a = uploadQueueFileManager;
        super(uploadQueueFileManager, uploadOperation);
    }

    final void mo1141a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(UploadQueueFileManager$FieldType.QueuedOperation.ordinal());
        this.f13681b.m21527a((DataOutput) dataOutputStream);
    }
}
