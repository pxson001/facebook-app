package com.facebook.photos.upload.event;

import com.facebook.photos.upload.operation.UploadOperation;

/* compiled from: graph_search_results_page_place */
public class VideoUploadSlowEvent extends BaseMediaUploadEvent {
    public final long f13621a;

    public VideoUploadSlowEvent(UploadOperation uploadOperation, BaseMediaUploadEvent$Status baseMediaUploadEvent$Status, int i, long j) {
        super(uploadOperation, baseMediaUploadEvent$Status, i);
        this.f13621a = j;
    }
}
