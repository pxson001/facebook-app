package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible
/* compiled from: campaignId */
final class LongAddables {
    private static final Supplier<LongAddable> f7239a;

    /* compiled from: campaignId */
    final class C08051 implements Supplier<LongAddable> {
        C08051() {
        }

        public final Object get() {
            return new LongAdder();
        }
    }

    /* compiled from: campaignId */
    final class C08062 implements Supplier<LongAddable> {
        C08062() {
        }

        public final Object get() {
            return new PureJavaLongAddable();
        }
    }

    /* compiled from: campaignId */
    final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        public final void mo874a() {
            getAndIncrement();
        }

        public final void mo875a(long j) {
            getAndAdd(j);
        }
    }

    LongAddables() {
    }

    static {
        Supplier c08051;
        try {
            LongAdder longAdder = new LongAdder();
            c08051 = new C08051();
        } catch (Throwable th) {
            c08051 = new C08062();
        }
        f7239a = c08051;
    }

    public static LongAddable m13178a() {
        return (LongAddable) f7239a.get();
    }
}
