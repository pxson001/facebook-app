package com.facebook.photos.pandora.common.futures;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: commercial_break_skywalker_subscription_success */
public class PandoraFutures {

    /* compiled from: commercial_break_skywalker_subscription_success */
    final class C18521 implements AsyncFunction<I, O> {
        final /* synthetic */ PandoraFunction f17380a;
        final /* synthetic */ Object f17381b;

        C18521(PandoraFunction pandoraFunction, Object obj) {
            this.f17380a = pandoraFunction;
            this.f17381b = obj;
        }

        public final ListenableFuture<O> m21377a(I i) {
            return Futures.a(this.f17380a.mo1042a(this.f17381b, i));
        }
    }

    /* compiled from: commercial_break_skywalker_subscription_success */
    public abstract class PandoraFunction<F, T, P> implements Function<F, T> {
        public abstract T mo1042a(P p, @Nullable F f);

        public final T apply(@Nullable F f) {
            throw new UnsupportedOperationException();
        }
    }

    static <I, O, P> ListenableFuture<O> m21379a(ListenableFuture<I> listenableFuture, PandoraFunction<? super I, ? extends O, P> pandoraFunction, P p, Executor executor) {
        Preconditions.checkNotNull(pandoraFunction);
        return Futures.b(listenableFuture, new C18521(pandoraFunction, p), executor);
    }
}
