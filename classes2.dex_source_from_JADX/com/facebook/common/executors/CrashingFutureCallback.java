package com.facebook.common.executors;

import com.facebook.inject.InjectorLike;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: wal_autocheckpoint */
public class CrashingFutureCallback implements FutureCallback<Object> {
    public static CrashingFutureCallback m1825a(InjectorLike injectorLike) {
        return new CrashingFutureCallback();
    }

    public void onSuccess(@Nullable Object obj) {
    }

    public void onFailure(Throwable th) {
        throw Throwables.propagate(th);
    }
}
