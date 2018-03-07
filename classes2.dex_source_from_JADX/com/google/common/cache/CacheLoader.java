package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;

@GwtCompatible
/* compiled from: zero_campaign */
public abstract class CacheLoader<K, V> {

    /* compiled from: zero_campaign */
    public final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private final Function<K, V> computingFunction;

        public FunctionToCacheLoader(Function<K, V> function) {
            this.computingFunction = (Function) Preconditions.checkNotNull(function);
        }

        public final V mo118a(K k) {
            return this.computingFunction.apply(Preconditions.checkNotNull(k));
        }
    }

    public abstract V mo118a(K k);

    protected CacheLoader() {
    }

    @GwtIncompatible("Futures")
    public final ListenableFuture<V> m1117a(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        return Futures.m2452a(mo118a(k));
    }
}
