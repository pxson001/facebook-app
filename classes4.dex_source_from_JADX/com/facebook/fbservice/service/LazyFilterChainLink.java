package com.facebook.fbservice.service;

import com.facebook.fbservice.service.BlueServiceHandler.LazyFilter;
import com.facebook.inject.Lazy;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.google.common.base.Preconditions;

/* compiled from: production_prompts */
public class LazyFilterChainLink implements BlueServiceHandler {
    private final Lazy<? extends BlueServiceHandler$Filter> f4151a;
    private final BlueServiceHandler f4152b;
    private final Lazy<? extends LazyFilter> f4153c;
    private final Lazy<? extends BlueServiceHandler> f4154d;

    public LazyFilterChainLink(Lazy<? extends BlueServiceHandler$Filter> lazy, BlueServiceHandler blueServiceHandler) {
        Preconditions.checkNotNull(lazy);
        Preconditions.checkNotNull(blueServiceHandler);
        this.f4151a = lazy;
        this.f4152b = blueServiceHandler;
        this.f4153c = null;
        this.f4154d = null;
    }

    public LazyFilterChainLink(Lazy<? extends LazyFilter> lazy, Lazy<? extends BlueServiceHandler> lazy2) {
        Preconditions.checkNotNull(lazy);
        Preconditions.checkNotNull(lazy2);
        this.f4153c = lazy;
        this.f4154d = lazy2;
        this.f4151a = null;
        this.f4152b = null;
    }

    public final OperationResult m4686a(OperationParams operationParams) {
        if (this.f4151a != null) {
            Systrace.a(1, "Filter.get");
            try {
                BlueServiceHandler$Filter blueServiceHandler$Filter = (BlueServiceHandler$Filter) this.f4151a.get();
                SystraceMessage.a(1).a("FilterClassName", blueServiceHandler$Filter != null ? blueServiceHandler$Filter.getClass().getName().toString() : "null").a();
                return blueServiceHandler$Filter.mo57a(operationParams, this.f4152b);
            } catch (Throwable th) {
                SystraceMessage.a(1).a("FilterClassName", "null").a();
            }
        } else if (this.f4153c != null) {
            Systrace.a(1, "LazyFilter.get");
            try {
                LazyAndNormalFilterAdapter lazyAndNormalFilterAdapter = (LazyAndNormalFilterAdapter) this.f4153c.get();
                SystraceMessage.a(1).a("LazyFilterClassName", lazyAndNormalFilterAdapter != null ? lazyAndNormalFilterAdapter.getClass().getName().toString() : "null").a();
                return lazyAndNormalFilterAdapter.a(operationParams, this.f4154d);
            } catch (Throwable th2) {
                SystraceMessage.a(1).a("LazyFilterClassName", "null").a();
            }
        } else {
            throw new IllegalStateException("Cannot handle current operation");
        }
    }
}
