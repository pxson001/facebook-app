package com.facebook.photos.upload.event;

import com.facebook.photos.upload.event.BaseMediaUploadEvent.Status;
import com.facebook.photos.upload.operation.UploadOperation;

/* compiled from: topic_feeds_enabled */
public class MultiPhotoUploadProgressEvent extends BaseMediaUploadEvent {
    public final int f2405a;
    public final int f2406b;

    public MultiPhotoUploadProgressEvent(UploadOperation uploadOperation, int i, int i2, ProgressType progressType, int i3) {
        super(uploadOperation, progressType == ProgressType.UPLOADING ? Status.UPLOADING : Status.PUBLISHING, i3);
        this.f2405a = i;
        this.f2406b = i2;
    }

    public MultiPhotoUploadProgressEvent(UploadOperation uploadOperation, int i, int i2, ProgressType progressType) {
        this(uploadOperation, i, i2, progressType, -1);
    }
}
