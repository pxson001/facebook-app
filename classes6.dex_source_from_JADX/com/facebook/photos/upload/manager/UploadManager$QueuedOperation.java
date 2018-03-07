package com.facebook.photos.upload.manager;

import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.photos.upload.operation.UploadOperation;

/* compiled from: graph_search_results_page_app */
class UploadManager$QueuedOperation {
    public OperationFuture f13650a;
    public UploadOperation f13651b;

    public UploadManager$QueuedOperation(OperationFuture operationFuture, UploadOperation uploadOperation) {
        this.f13650a = operationFuture;
        this.f13651b = uploadOperation;
    }
}
