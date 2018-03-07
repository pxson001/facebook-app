package com.facebook.graphql.executor;

import com.google.common.base.Function;
import rx.functions.Func1;

/* compiled from: legal_disclaimer_text */
class RequestObservable$3 implements Func1<T, Boolean> {
    final /* synthetic */ Function f3231a;
    final /* synthetic */ RequestObservable f3232b;

    RequestObservable$3(RequestObservable requestObservable, Function function) {
        this.f3232b = requestObservable;
        this.f3231a = function;
    }

    public final Object mo611a(Object obj) {
        return (Boolean) this.f3231a.apply(obj);
    }
}
