package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: bug_git_hash */
public class ExecutionError extends Error {
    protected ExecutionError() {
    }

    public ExecutionError(@Nullable Error error) {
        super(error);
    }
}
