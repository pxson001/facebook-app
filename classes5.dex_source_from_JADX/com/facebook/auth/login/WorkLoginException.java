package com.facebook.auth.login;

import android.os.Bundle;
import com.facebook.fbservice.service.ErrorCode;

/* compiled from: surveyTitle */
public class WorkLoginException extends Exception {
    private final Bundle mBundle;
    private final ErrorCode mErrorCode;

    public WorkLoginException(ErrorCode errorCode) {
        this(errorCode, null);
    }

    public WorkLoginException(ErrorCode errorCode, Bundle bundle) {
        this.mErrorCode = errorCode;
        this.mBundle = bundle;
    }
}
