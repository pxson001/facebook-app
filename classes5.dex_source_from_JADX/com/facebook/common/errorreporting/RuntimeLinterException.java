package com.facebook.common.errorreporting;

import com.facebook.acra.NonCrashException;

/* compiled from: steps */
public class RuntimeLinterException extends Exception implements NonCrashException {
    public RuntimeLinterException() {
        this("Runtime lint report");
    }

    public RuntimeLinterException(String str) {
        super(str);
    }

    public String getExceptionFriendlyName() {
        return "runtime lint report";
    }
}
