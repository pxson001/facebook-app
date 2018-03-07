package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
@CheckReturnValue
/* compiled from: zeroOptinParams */
public abstract class Equivalence<T> {

    /* compiled from: zeroOptinParams */
    public final class Identity extends Equivalence<Object> implements Serializable {
        public static final Identity INSTANCE = new Identity();

        Identity() {
        }

        protected final boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        protected final int doHash(Object obj) {
            return System.identityHashCode(obj);
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    /* compiled from: zeroOptinParams */
    public final class Equals extends Equivalence<Object> implements Serializable {
        public static final Equals INSTANCE = new Equals();

        Equals() {
        }

        protected final boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        protected final int doHash(Object obj) {
            return obj.hashCode();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    protected abstract boolean doEquivalent(T t, T t2);

    protected abstract int doHash(T t);

    protected Equivalence() {
    }

    public final boolean equivalent(@Nullable T t, @Nullable T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return doEquivalent(t, t2);
    }

    public final int hash(@Nullable T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    public final <S extends T> Wrapper<S> wrap(@Nullable S s) {
        return new Wrapper(this, s);
    }
}
