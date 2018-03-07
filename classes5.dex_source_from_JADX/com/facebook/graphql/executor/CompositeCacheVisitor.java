package com.facebook.graphql.executor;

import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.CacheVisitorAnalytics;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Set;

/* compiled from: like_place */
public class CompositeCacheVisitor implements CacheVisitorAnalytics {
    private final CacheVisitor[] f3194a;
    private final ImmutableSet<String> f3195b;

    public CompositeCacheVisitor(CacheVisitor... cacheVisitorArr) {
        this.f3194a = cacheVisitorArr;
        Builder builder = ImmutableSet.builder();
        for (CacheVisitor a : cacheVisitorArr) {
            builder.b(a.a());
        }
        this.f3195b = builder.b();
    }

    public final <T> T m6249a(T t) {
        for (CacheVisitor a : this.f3194a) {
            t = a.a(t);
        }
        return t;
    }

    public final Set<String> m6250a() {
        return this.f3195b;
    }

    public final String m6251b() {
        int i = 0;
        int i2 = 11;
        for (int i3 = 0; i3 < this.f3194a.length; i3++) {
            i2 += this.f3194a[i3].getClass().getName().length();
            if (i3 != 0) {
                i2++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(i2);
        stringBuilder.append("Composite[");
        while (i < this.f3194a.length) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(this.f3194a[i].getClass().getName());
            i++;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
