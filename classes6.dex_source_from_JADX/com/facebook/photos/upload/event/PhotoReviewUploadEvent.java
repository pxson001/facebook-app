package com.facebook.photos.upload.event;

import com.facebook.photos.upload.operation.UploadOperation;

/* compiled from: graph_search_results_page_video_channels */
public class PhotoReviewUploadEvent extends BaseMediaUploadEvent {
    public PhotoReviewUploadEvent(UploadOperation uploadOperation) {
        super(uploadOperation, BaseMediaUploadEvent$Status.UPLOAD_SUCCESS, -1);
    }
}
