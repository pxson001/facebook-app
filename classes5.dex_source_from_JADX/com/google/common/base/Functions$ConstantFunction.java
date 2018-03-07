package com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

/* compiled from: can_cast_video */
class Functions$ConstantFunction<E> implements Function<Object, E>, Serializable {
    private final E value;

    public Functions$ConstantFunction(@Nullable E e) {
        this.value = e;
    }

    public E apply(@Nullable Object obj) {
        return this.value;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Functions$ConstantFunction)) {
            return false;
        }
        return Objects.equal(this.value, ((Functions$ConstantFunction) obj).value);
    }

    public int hashCode() {
        return this.value == null ? 0 : this.value.hashCode();
    }

    public String toString() {
        return "Functions.constant(" + this.value + ")";
    }
}
