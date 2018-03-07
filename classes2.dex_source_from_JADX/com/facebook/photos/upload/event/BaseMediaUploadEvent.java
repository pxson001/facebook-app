package com.facebook.photos.upload.event;

import com.facebook.photos.upload.operation.UploadOperation;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: topics_prediction_visual_feedback_enabled */
public class BaseMediaUploadEvent extends MediaUploadEvent {
    public final UploadOperation f2399a;
    public final Status f2400b;
    public final int f2401c;

    public BaseMediaUploadEvent(UploadOperation uploadOperation, Status status, int i) {
        this.f2399a = uploadOperation;
        this.f2400b = status;
        this.f2401c = i;
    }

    public final UploadOperation m4578a() {
        return this.f2399a;
    }

    public final Status m4579b() {
        return this.f2400b;
    }
}
