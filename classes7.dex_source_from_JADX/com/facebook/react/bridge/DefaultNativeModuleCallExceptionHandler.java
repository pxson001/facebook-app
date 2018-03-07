package com.facebook.react.bridge;

/* compiled from: group_unhide */
public class DefaultNativeModuleCallExceptionHandler implements NativeModuleCallExceptionHandler {
    public final void m13450a(Exception exception) {
        if (exception instanceof RuntimeException) {
            throw ((RuntimeException) exception);
        }
        throw new RuntimeException(exception);
    }
}
