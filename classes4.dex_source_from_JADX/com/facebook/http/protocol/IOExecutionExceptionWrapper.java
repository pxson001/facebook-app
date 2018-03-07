package com.facebook.http.protocol;

import com.google.common.base.Throwables;
import java.io.IOException;

/* compiled from: inline_activities */
class IOExecutionExceptionWrapper extends IOException {
    private IOExecutionExceptionWrapper(Exception exception) {
        initCause(exception);
    }

    public static IOException m10856a(Exception exception) {
        Throwables.propagateIfInstanceOf(exception, IOException.class);
        throw new IOExecutionExceptionWrapper(exception);
    }

    public static Exception m10857b(Exception exception) {
        return exception instanceof IOExecutionExceptionWrapper ? (Exception) ((IOExecutionExceptionWrapper) exception).getCause() : exception;
    }
}
