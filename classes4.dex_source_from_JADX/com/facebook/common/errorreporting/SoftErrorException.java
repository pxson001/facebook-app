package com.facebook.common.errorreporting;

import com.facebook.acra.NonCrashException;
import javax.annotation.Nullable;

/* compiled from: primary_field */
public class SoftErrorException extends Exception implements NonCrashException {
    public SoftErrorException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    public String getExceptionFriendlyName() {
        return "soft error";
    }
}
