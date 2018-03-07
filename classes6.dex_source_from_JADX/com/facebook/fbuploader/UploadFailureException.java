package com.facebook.fbuploader;

import android.util.Log;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: newListener is required */
public final class UploadFailureException extends Exception {
    public final long mBytesTransferred;
    public final String mFailureReason;
    public final Exception mInnerException;
    public final boolean mIsCancellation;

    public UploadFailureException(String str, long j, boolean z, Exception exception) {
        this.mFailureReason = str;
        this.mBytesTransferred = j;
        this.mIsCancellation = z;
        this.mInnerException = exception;
    }

    public UploadFailureException(String str) {
        this(str, 0, false, null);
    }

    public final String getMessage() {
        return "Failure Reason: " + this.mFailureReason + (this.mIsCancellation ? " (Cancellation), " : ", ") + "InnerException: " + (this.mInnerException != null ? this.mInnerException.toString() + ", InnerStack: " + Log.getStackTraceString(this.mInnerException) : "None");
    }
}
