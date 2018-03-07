package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: bug_id */
public final class Callables {

    /* compiled from: bug_id */
    final class C08671 implements Callable<T> {
        final /* synthetic */ Object f7654a;

        C08671(Object obj) {
            this.f7654a = obj;
        }

        public final T call() {
            return this.f7654a;
        }
    }

    private Callables() {
    }

    public static <T> Callable<T> m13827a(@Nullable T t) {
        return new C08671(t);
    }
}
