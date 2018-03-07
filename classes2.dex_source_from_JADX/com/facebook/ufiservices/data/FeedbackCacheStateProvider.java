package com.facebook.ufiservices.data;

import com.facebook.api.ufiservices.FeedbackPrefetchPolicyProvider;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import javax.inject.Inject;

/* compiled from: has_seen_saved_dashboard_interstitial */
public class FeedbackCacheStateProvider {
    public final GraphQLDiskCache f21265a;
    public final FeedbackPrefetchPolicyProvider f21266b;

    @Inject
    public FeedbackCacheStateProvider(GraphQLDiskCache graphQLDiskCache, FeedbackPrefetchPolicyProvider feedbackPrefetchPolicyProvider) {
        this.f21265a = graphQLDiskCache;
        this.f21266b = feedbackPrefetchPolicyProvider;
    }
}
