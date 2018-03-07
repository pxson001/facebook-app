package com.facebook.location;

import android.os.DeadObjectException;
import android.os.TransactionTooLargeException;

/* compiled from: د.ا. */
public class GooglePlayServicesExceptionUtil {
    private GooglePlayServicesExceptionUtil() {
    }

    static void m33a(RuntimeException runtimeException) {
        if (!(runtimeException.getCause() instanceof DeadObjectException) && !(runtimeException.getCause() instanceof TransactionTooLargeException)) {
            throw runtimeException;
        }
    }
}
