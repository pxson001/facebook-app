package com.facebook.photos.upload.event;

import com.facebook.photos.upload.operation.UploadOperation;

/* compiled from: graph_search_results_page_user */
public class VideoUploadProgressEvent extends BaseMediaUploadEvent {
    public VideoUploadProgressEvent(UploadOperation uploadOperation, BaseMediaUploadEvent$Status baseMediaUploadEvent$Status, int i) {
        super(uploadOperation, baseMediaUploadEvent$Status, i);
        if (baseMediaUploadEvent$Status == BaseMediaUploadEvent$Status.PROCESSING) {
            if (i >= 0 && i < 100) {
                uploadOperation.f13772U = Math.max((uploadOperation.f13771T * i) / 100, uploadOperation.f13772U);
            }
        } else if (baseMediaUploadEvent$Status == BaseMediaUploadEvent$Status.UPLOADING) {
            uploadOperation.f13773V = Math.max(i, uploadOperation.f13773V);
        }
    }
}
