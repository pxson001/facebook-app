package com.facebook.react.bridge;

import javax.annotation.Nullable;

/* compiled from: group_events */
public class NativeArgumentsParseException extends JSApplicationCausedNativeException {
    public NativeArgumentsParseException(String str) {
        super(str);
    }

    public NativeArgumentsParseException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }
}
