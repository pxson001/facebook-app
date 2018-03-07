package com.facebook.graphql.executor;

import com.facebook.graphql.executor.cachekey.KeyFactory;

/* compiled from: res_man/ */
public interface GraphQLCacheKeySerializer {
    public static final GraphQLCacheKeySerializer f7183a = new C03021();
    public static final GraphQLCacheKeySerializer f7184b = new C03032();

    /* compiled from: res_man/ */
    final class C03021 implements GraphQLCacheKeySerializer {
        C03021() {
        }

        public final String mo1645a(GraphQLRequest graphQLRequest, Class<?> cls, KeyFactory keyFactory) {
            return keyFactory.m10337a(graphQLRequest.f7096o, cls, graphQLRequest.m11607d(), null);
        }
    }

    /* compiled from: res_man/ */
    final class C03032 implements GraphQLCacheKeySerializer {
        C03032() {
        }

        public final String mo1645a(GraphQLRequest graphQLRequest, Class<?> cls, KeyFactory keyFactory) {
            return keyFactory.m10338a(graphQLRequest.f7096o, (Class) cls, null);
        }
    }

    String mo1645a(GraphQLRequest graphQLRequest, Class<?> cls, KeyFactory keyFactory);
}
