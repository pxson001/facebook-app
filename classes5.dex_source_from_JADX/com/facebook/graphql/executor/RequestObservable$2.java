package com.facebook.graphql.executor;

import com.google.common.base.Function;
import rx.functions.Func1;

/* compiled from: legal_disclaimer_text */
class RequestObservable$2 implements Func1<T, TOut> {
    final /* synthetic */ Function f3229a;
    final /* synthetic */ RequestObservable f3230b;

    RequestObservable$2(RequestObservable requestObservable, Function function) {
        this.f3230b = requestObservable;
        this.f3229a = function;
    }

    public final TOut mo611a(T t) {
        return this.f3229a.apply(t);
    }
}
