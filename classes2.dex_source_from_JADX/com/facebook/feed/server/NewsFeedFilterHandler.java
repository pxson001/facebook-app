package com.facebook.feed.server;

import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.build.BuildConstants;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: sans-serif-light */
public class NewsFeedFilterHandler {
    private final Lazy<FeedUnitFilter> f6294a;

    public static NewsFeedFilterHandler m10531b(InjectorLike injectorLike) {
        return new NewsFeedFilterHandler(IdBasedLazy.m1808a(injectorLike, 1712));
    }

    @Inject
    public NewsFeedFilterHandler(Lazy<FeedUnitFilter> lazy) {
        this.f6294a = lazy;
    }

    public final FetchFeedResult m10532a(FetchFeedResult fetchFeedResult, boolean z) {
        if (fetchFeedResult == null || fetchFeedResult.f15757b == null || fetchFeedResult.m22439d() == null) {
            return fetchFeedResult;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList d = fetchFeedResult.m22439d();
        int size = d.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) d.get(i);
            GraphQLFeedUnitEdge a = m10530a(graphQLFeedUnitEdge, z, fetchFeedResult.f15756a.f5784b);
            if (a != graphQLFeedUnitEdge) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            if (a != null) {
                builder.m1069c(a);
            }
            i++;
            obj = obj2;
        }
        return obj != null ? new FetchFeedResult(fetchFeedResult.f15756a, builder.m1068b(), fetchFeedResult.m22440e(), fetchFeedResult.m22441f(), fetchFeedResult.freshness, fetchFeedResult.clientTimeMs, fetchFeedResult.f15758c) : fetchFeedResult;
    }

    private GraphQLFeedUnitEdge m10530a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, boolean z, FeedType feedType) {
        if (graphQLFeedUnitEdge.mo2540c() != null && (!z || graphQLFeedUnitEdge.m19086g() != null)) {
            FeedUnit a = ((FeedUnitFilter) this.f6294a.get()).m22698a(graphQLFeedUnitEdge.mo2540c(), Optional.of(feedType));
            if (a == graphQLFeedUnitEdge.mo2540c()) {
                return graphQLFeedUnitEdge;
            }
            if (a == null) {
                return null;
            }
            GraphQLFeedUnitEdge.Builder a2 = GraphQLFeedUnitEdge.Builder.m22409a(graphQLFeedUnitEdge);
            a2.f15732i = a;
            return a2.m22415a();
        } else if (!BuildConstants.i) {
            return null;
        } else {
            if (graphQLFeedUnitEdge.mo2540c() == null) {
                throw new IllegalStateException("The feedUnit cannot be null");
            }
            throw new IllegalStateException("If the FeedType has a caching policy, the cursor cannot be null");
        }
    }
}
