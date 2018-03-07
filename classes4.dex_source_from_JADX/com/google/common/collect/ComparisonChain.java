package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Ints;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
@CheckReturnValue
/* compiled from: record_directory */
public abstract class ComparisonChain {
    public static final ComparisonChain f3556a = new C01651();
    public static final ComparisonChain f3557b = new InactiveComparisonChain(-1);
    public static final ComparisonChain f3558c = new InactiveComparisonChain(1);

    /* compiled from: record_directory */
    final class C01651 extends ComparisonChain {
        C01651() {
        }

        public final ComparisonChain mo286a(Comparable comparable, Comparable comparable2) {
            return C01651.m3946a(comparable.compareTo(comparable2));
        }

        public final ComparisonChain mo285a(int i, int i2) {
            return C01651.m3946a(Ints.a(i, i2));
        }

        private static ComparisonChain m3946a(int i) {
            if (i < 0) {
                return ComparisonChain.f3557b;
            }
            return i > 0 ? ComparisonChain.f3558c : ComparisonChain.f3556a;
        }

        public final int mo287b() {
            return 0;
        }
    }

    /* compiled from: record_directory */
    final class InactiveComparisonChain extends ComparisonChain {
        final int f3559a;

        InactiveComparisonChain(int i) {
            this.f3559a = i;
        }

        public final ComparisonChain mo286a(@Nullable Comparable comparable, @Nullable Comparable comparable2) {
            return this;
        }

        public final ComparisonChain mo285a(int i, int i2) {
            return this;
        }

        public final int mo287b() {
            return this.f3559a;
        }
    }

    public abstract ComparisonChain mo285a(int i, int i2);

    public abstract ComparisonChain mo286a(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract int mo287b();
}
