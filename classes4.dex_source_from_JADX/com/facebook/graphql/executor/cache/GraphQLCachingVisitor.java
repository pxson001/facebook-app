package com.facebook.graphql.executor.cache;

import com.facebook.graphql.executor.iface.CacheVisitor;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/* compiled from: rtccall/video/%s */
public abstract class GraphQLCachingVisitor implements CacheVisitor {
    public static final Object f3029a = new Object();
    private final LoadingCache<Object, Object> f3030b = CacheBuilder.newBuilder().g().i().b(2).a(5).a(new C01441(this));

    /* compiled from: rtccall/video/%s */
    class C01441 extends CacheLoader<Object, Object> {
        final /* synthetic */ GraphQLCachingVisitor f3031a;

        C01441(GraphQLCachingVisitor graphQLCachingVisitor) {
            this.f3031a = graphQLCachingVisitor;
        }

        public final Object m3343a(Object obj) {
            Object b = this.f3031a.mo269b(obj);
            return b == null ? GraphQLCachingVisitor.f3029a : b;
        }
    }

    public abstract <T> T mo269b(T t);

    public final <T> T mo270a(T t) {
        if (t == null) {
            return null;
        }
        try {
            T c = this.f3030b.c(t);
            if (c != f3029a) {
                return c;
            }
            return null;
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }
}
