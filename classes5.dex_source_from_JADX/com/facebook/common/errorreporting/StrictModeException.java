package com.facebook.common.errorreporting;

import com.facebook.acra.NonCrashException;

/* compiled from: stateful_title */
public class StrictModeException extends Exception implements NonCrashException {
    public StrictModeException(String str) {
        super(str);
    }

    public String getExceptionFriendlyName() {
        return "strict mode violation";
    }
}
