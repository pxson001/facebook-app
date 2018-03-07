package com.facebook.inject;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: delta_hash */
public class LazyFutures$ListBuilder {
    private final List<Lazy<ListenableFuture<Object>>> f5141a = Lists.b();

    public final LazyFutures$ListBuilder m10025a(final Lazy<? extends ListenableFuture<?>> lazy) {
        this.f5141a.add(new Lazy<ListenableFuture<Object>>(this) {
            final /* synthetic */ LazyFutures$ListBuilder f5137b;

            public Object get() {
                return (ListenableFuture) lazy.get();
            }
        });
        return this;
    }

    private Lazy<ListenableFuture<List<Object>>> m10022a() {
        final ImmutableList copyOf = ImmutableList.copyOf(this.f5141a);
        return new LazyFuture<List<Object>>(this) {
            final /* synthetic */ LazyFutures$ListBuilder f5140b;

            /* compiled from: delta_hash */
            class C04851 implements Function<Lazy<ListenableFuture<Object>>, ListenableFuture<Object>> {
                final /* synthetic */ C04863 f5138a;

                C04851(C04863 c04863) {
                    this.f5138a = c04863;
                }

                public Object apply(Object obj) {
                    return (ListenableFuture) ((Lazy) obj).get();
                }
            }

            protected final ListenableFuture<List<Object>> m10021a() {
                return Futures.a(Lists.a(copyOf, new C04851(this)));
            }
        };
    }

    public final <T> Lazy<ListenableFuture<T>> m10023a(Function<List<Object>, T> function, Executor executor) {
        return LazyFutures.a(m10022a(), function, executor);
    }

    public final <T> Lazy<ListenableFuture<T>> m10024a(AsyncFunction<List<Object>, T> asyncFunction, Executor executor) {
        return new LazyFutures$3(m10022a(), asyncFunction, executor);
    }
}
