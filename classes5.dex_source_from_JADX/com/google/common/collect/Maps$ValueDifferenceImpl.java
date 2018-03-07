package com.google.common.collect;

import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: camera */
public class Maps$ValueDifferenceImpl<V> {
    public final V f7490a;
    public final V f7491b;

    public Maps$ValueDifferenceImpl(@Nullable V v, @Nullable V v2) {
        this.f7490a = v;
        this.f7491b = v2;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Maps$ValueDifferenceImpl)) {
            return false;
        }
        Maps$ValueDifferenceImpl maps$ValueDifferenceImpl = (Maps$ValueDifferenceImpl) obj;
        if (Objects.equal(this.f7490a, maps$ValueDifferenceImpl.f7490a) && Objects.equal(this.f7491b, maps$ValueDifferenceImpl.f7491b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f7490a, this.f7491b});
    }

    public String toString() {
        return "(" + this.f7490a + ", " + this.f7491b + ")";
    }
}
