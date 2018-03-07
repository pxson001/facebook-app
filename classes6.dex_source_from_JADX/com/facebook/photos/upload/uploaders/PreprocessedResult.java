package com.facebook.photos.upload.uploaders;

import com.facebook.photos.upload.disk.TempFiles;
import com.facebook.photos.upload.operation.UploadRecord;

/* compiled from: friends_locations_feedstory_see_all */
public class PreprocessedResult {
    private TempFiles f14430a;
    public Status f14431b;
    public UploadRecord f14432c;

    /* compiled from: friends_locations_feedstory_see_all */
    public enum Status {
        NEW,
        PREPROCESSED,
        USE_ORIGINAL,
        UPLOADED,
        FATAL
    }

    public PreprocessedResult(Status status, TempFiles tempFiles, UploadRecord uploadRecord) {
        this.f14431b = status;
        this.f14430a = tempFiles;
        this.f14432c = uploadRecord;
    }

    public final void m22060c() {
        if (this.f14430a != null) {
            this.f14430a.m21314a();
        }
    }
}
