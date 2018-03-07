package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
@CheckReturnValue
/* compiled from: person_summary */
public final class Functions {

    /* compiled from: person_summary */
    public enum IdentityFunction implements Function<Object, Object> {
        INSTANCE;

        @Nullable
        public final Object apply(@Nullable Object obj) {
            return obj;
        }

        public final String toString() {
            return "Functions.identity()";
        }
    }

    /* compiled from: person_summary */
    public enum ToStringFunction implements Function<Object, String> {
        INSTANCE;

        public final String apply(Object obj) {
            Preconditions.checkNotNull(obj);
            return obj.toString();
        }

        public final String toString() {
            return "Functions.toStringFunction()";
        }
    }

    private Functions() {
    }

    public static <E> Function<E, E> identity() {
        return IdentityFunction.INSTANCE;
    }

    public static <E> Function<Object, E> constant(@Nullable E e) {
        return new ConstantFunction(e);
    }
}
