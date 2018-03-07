package com.facebook.contextual;

import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: stale */
public class ContextHandler {
    public String f1922a;
    private long f1923b;
    private ContextsProvider f1924c;

    public ContextHandler(String str, @Nullable ContextsProvider contextsProvider, long j) {
        this.f1922a = str.toLowerCase(Locale.US);
        this.f1924c = contextsProvider;
        this.f1923b = j;
    }

    private boolean m1980b() {
        return this.f1924c == null;
    }

    @Nullable
    public final ContextValue m1981a(long j, @Nullable LocalContextsProvider localContextsProvider) {
        if (j == 0) {
            j = this.f1923b;
        }
        if (!m1980b()) {
            return this.f1924c.mo133a(j);
        }
        if (localContextsProvider != null) {
            return localContextsProvider.a();
        }
        return null;
    }

    public String toString() {
        if (m1980b()) {
            return this.f1922a + " => local context";
        }
        return this.f1922a + " => " + this.f1924c.toString() + " , " + this.f1923b;
    }
}
