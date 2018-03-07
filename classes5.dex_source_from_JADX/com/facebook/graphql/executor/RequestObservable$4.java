package com.facebook.graphql.executor;

import com.google.common.base.Function;
import javax.annotation.Nullable;
import rx.Observable;

/* compiled from: legal_disclaimer_text */
final class RequestObservable$4 implements Function<RequestObservable<T>, Observable<T>> {
    RequestObservable$4() {
    }

    @Nullable
    public final Object apply(@Nullable Object obj) {
        RequestObservable requestObservable = (RequestObservable) obj;
        return requestObservable != null ? requestObservable.a : null;
    }
}
