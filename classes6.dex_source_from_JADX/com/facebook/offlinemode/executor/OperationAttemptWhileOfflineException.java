package com.facebook.offlinemode.executor;

import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;

/* compiled from: thanks_header */
public class OperationAttemptWhileOfflineException extends Exception {
    public OperationAttemptWhileOfflineException(Operation operation, Throwable th) {
        this(operation.e(), th);
    }

    private OperationAttemptWhileOfflineException(String str, Throwable th) {
        super("An operation of type " + str + " was attempted while offline", th);
    }
}
