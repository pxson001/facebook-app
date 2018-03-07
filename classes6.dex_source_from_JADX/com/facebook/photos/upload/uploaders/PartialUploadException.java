package com.facebook.photos.upload.uploaders;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.fbservice.results.ExceptionWithExtraData;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.upload.operation.UploadInterruptionCause;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.operation.UploadRecords;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: friends_locations_feedstory_tap_profile */
public class PartialUploadException extends Exception implements ExceptionWithExtraData {
    private final UploadInterruptionCause mCause;
    private final UploadRecords mUploadRecords;

    public final UploadInterruptionCause m22040b() {
        return this.mCause;
    }

    public final UploadRecords m22041c() {
        return this.mUploadRecords;
    }

    public final Parcelable m22039a() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("interruption_cause", this.mCause);
        bundle.putParcelable("upload_records", this.mUploadRecords);
        return bundle;
    }

    public static UploadInterruptionCause m22037a(Bundle bundle) {
        return (UploadInterruptionCause) bundle.getParcelable("interruption_cause");
    }

    public static UploadRecords m22038b(Bundle bundle) {
        return (UploadRecords) bundle.getParcelable("upload_records");
    }

    public PartialUploadException(ExceptionInterpreter exceptionInterpreter) {
        super(exceptionInterpreter.f12622g);
        this.mCause = new UploadInterruptionCause(exceptionInterpreter);
        this.mUploadRecords = new UploadRecords(Maps.c());
    }

    public PartialUploadException(ExceptionInterpreter exceptionInterpreter, Map<String, UploadRecord> map) {
        super(exceptionInterpreter.f12622g);
        this.mCause = new UploadInterruptionCause(exceptionInterpreter);
        this.mUploadRecords = new UploadRecords((Map) map);
    }
}
