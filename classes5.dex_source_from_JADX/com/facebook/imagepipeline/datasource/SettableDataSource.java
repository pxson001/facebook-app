package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: TRAIN_CHECKIN_SUGGESTIFIER */
public final class SettableDataSource<T> extends AbstractDataSource<CloseableReference<T>> {
    protected final void m23032a(@Nullable Object obj) {
        CloseableReference.c((CloseableReference) obj);
    }

    public final boolean m23033a(@Nullable CloseableReference<T> closeableReference) {
        return super.a(CloseableReference.b(closeableReference), true);
    }

    public final boolean m23034b(Throwable th) {
        return super.a(th);
    }

    @Nullable
    public final Object m23035d() {
        return CloseableReference.b((CloseableReference) super.d());
    }
}
