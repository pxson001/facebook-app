package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: bug_build_timestamp */
public class UncheckedExecutionException extends RuntimeException {
    protected UncheckedExecutionException() {
    }

    public UncheckedExecutionException(@Nullable Throwable th) {
        super(th);
    }
}
