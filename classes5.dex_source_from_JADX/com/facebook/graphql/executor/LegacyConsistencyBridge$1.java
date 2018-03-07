package com.facebook.graphql.executor;

import com.facebook.graphql.executor.iface.CacheVisitor;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: life_event_type_picker */
class LegacyConsistencyBridge$1 implements FutureCallback<Object> {
    final /* synthetic */ int f3217a;
    final /* synthetic */ CacheVisitor f3218b;
    final /* synthetic */ LegacyConsistencyBridge f3219c;

    LegacyConsistencyBridge$1(LegacyConsistencyBridge legacyConsistencyBridge, int i, CacheVisitor cacheVisitor) {
        this.f3219c = legacyConsistencyBridge;
        this.f3217a = i;
        this.f3218b = cacheVisitor;
    }

    public void onSuccess(@Nullable Object obj) {
        this.f3219c.e.b(this.f3217a, this.f3218b);
    }

    public void onFailure(Throwable th) {
        this.f3219c.e.a(this.f3217a);
    }
}
