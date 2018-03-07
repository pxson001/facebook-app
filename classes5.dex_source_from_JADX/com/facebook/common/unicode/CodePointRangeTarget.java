package com.facebook.common.unicode;

/* compiled from: shold_show_intercept */
public final class CodePointRangeTarget<T> {
    public final CodePointRange f2777a;
    public final T f2778b;

    public CodePointRangeTarget(CodePointRange codePointRange, T t) {
        if (codePointRange == null) {
            throw new IllegalArgumentException("codePointRange may not be null");
        }
        this.f2777a = codePointRange;
        this.f2778b = t;
    }

    public final String toString() {
        if (this.f2778b == null) {
            return this.f2777a.toString() + " --> []";
        }
        return this.f2777a.toString() + " --> [" + this.f2778b.toString() + "]";
    }
}
