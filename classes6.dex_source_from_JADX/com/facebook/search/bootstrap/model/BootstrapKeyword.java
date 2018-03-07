package com.facebook.search.bootstrap.model;

import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchException;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: exception_stack */
public class BootstrapKeyword {
    public final String f15783a;
    public final String f15784b;
    @Nullable
    public final String f15785c;
    @Nullable
    public final String f15786d;
    @Nullable
    public final String f15787e;
    public final ImmutableList<String> f15788f;
    public final double f15789g;
    @Nullable
    public final String f15790h;

    /* compiled from: exception_stack */
    public class Builder {
        public String f15775a;
        public String f15776b;
        @Nullable
        public String f15777c;
        @Nullable
        public String f15778d;
        @Nullable
        public String f15779e;
        public ImmutableList<String> f15780f;
        public double f15781g = -1.0d;
        @Nullable
        public String f15782h;

        public final Builder m23441a(@Nullable ImmutableList<String> immutableList) {
            if (immutableList == null) {
                immutableList = RegularImmutableList.a;
            }
            this.f15780f = immutableList;
            return this;
        }
    }

    public BootstrapKeyword(Builder builder) {
        this.f15783a = builder.f15775a;
        this.f15784b = builder.f15776b;
        this.f15785c = builder.f15777c;
        this.f15786d = builder.f15778d;
        this.f15787e = builder.f15779e;
        this.f15788f = builder.f15780f;
        this.f15789g = builder.f15781g;
        this.f15790h = builder.f15782h;
    }

    public static void m23442i(BootstrapKeyword bootstrapKeyword) {
        if (Strings.isNullOrEmpty(bootstrapKeyword.f15783a)) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "Missing name for keyword suggestion");
        } else if (Strings.isNullOrEmpty(bootstrapKeyword.f15784b)) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "Missing type for keyword suggestion " + bootstrapKeyword.f15783a);
        } else if (bootstrapKeyword.f15789g <= 0.0d) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "Missing costs for keyword suggestion " + bootstrapKeyword.f15783a);
        } else if (bootstrapKeyword.f15788f.isEmpty()) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "Missing or empty name search tokens for keyword suggestion " + bootstrapKeyword.f15783a);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof BootstrapKeyword) {
            return this.f15783a.equals(((BootstrapKeyword) obj).f15783a);
        }
        return false;
    }

    public int hashCode() {
        return this.f15783a.hashCode();
    }

    public String toString() {
        return "BootstrapKeyword[" + this.f15783a + "]";
    }
}
