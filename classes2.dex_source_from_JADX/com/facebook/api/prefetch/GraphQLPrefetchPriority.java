package com.facebook.api.prefetch;

/* compiled from: post_check_in */
public enum GraphQLPrefetchPriority {
    UNKNOWN(0),
    LOW(1),
    HIGH(2);
    
    private final int mPriority;

    private GraphQLPrefetchPriority(int i) {
        this.mPriority = i;
    }

    public final boolean isAtLeast(GraphQLPrefetchPriority graphQLPrefetchPriority) {
        return this.mPriority >= graphQLPrefetchPriority.mPriority;
    }
}
