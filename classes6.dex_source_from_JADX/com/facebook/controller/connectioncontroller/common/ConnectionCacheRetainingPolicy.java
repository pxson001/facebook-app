package com.facebook.controller.connectioncontroller.common;

import com.facebook.graphql.executor.GraphQLCachePolicy;

/* compiled from: original_bytes */
public class ConnectionCacheRetainingPolicy {
    public static final ConnectionCacheRetainingPolicy f8587a = new ConnectionCacheRetainingPolicy(0, null);
    public final long f8588b;
    public final GraphQLCachePolicy f8589c;

    /* compiled from: original_bytes */
    public class Builder {
        public long f8585a;
        public GraphQLCachePolicy f8586b;

        public final ConnectionCacheRetainingPolicy m12399a() {
            return new ConnectionCacheRetainingPolicy(this.f8585a, this.f8586b);
        }
    }

    ConnectionCacheRetainingPolicy(long j, GraphQLCachePolicy graphQLCachePolicy) {
        this.f8588b = j;
        this.f8589c = graphQLCachePolicy;
    }

    public final long m12400a() {
        return this.f8588b;
    }
}
