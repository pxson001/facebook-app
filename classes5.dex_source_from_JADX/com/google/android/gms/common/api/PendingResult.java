package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result> {
    public abstract R mo824a();

    public abstract R mo825a(long j, TimeUnit timeUnit);

    public abstract void mo826a(ResultCallback<? super R> resultCallback);

    public Integer mo827b() {
        throw new UnsupportedOperationException();
    }
}
