package com.facebook.react.bridge;

import javax.annotation.Nullable;

/* compiled from: group_reported_stories */
public class JSApplicationCausedNativeException extends RuntimeException {
    public JSApplicationCausedNativeException(String str) {
        super(str);
    }

    public JSApplicationCausedNativeException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }
}
