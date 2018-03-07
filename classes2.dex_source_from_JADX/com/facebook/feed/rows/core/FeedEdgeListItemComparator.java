package com.facebook.feed.rows.core;

import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.feed.model.GapFeedEdge;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: permitted_max_txns */
public class FeedEdgeListItemComparator<T> implements ListItemComparator<T> {
    private final OptimisticStoryStateCache f10204a;

    public static FeedEdgeListItemComparator m15279a(InjectorLike injectorLike) {
        return new FeedEdgeListItemComparator(OptimisticStoryStateCache.m9726a(injectorLike));
    }

    @Inject
    public FeedEdgeListItemComparator(OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f10204a = optimisticStoryStateCache;
    }

    public final boolean mo1978a(T t, @Nullable T t2) {
        if ((t instanceof GraphQLFeedUnitEdge) && (t2 instanceof GraphQLFeedUnitEdge)) {
            return m15281a((GraphQLFeedUnitEdge) t, (GraphQLFeedUnitEdge) t2);
        }
        return false;
    }

    private boolean m15281a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, GraphQLFeedUnitEdge graphQLFeedUnitEdge2) {
        if ((graphQLFeedUnitEdge instanceof GapFeedEdge) || (graphQLFeedUnitEdge2 instanceof GapFeedEdge)) {
            if (graphQLFeedUnitEdge2 == graphQLFeedUnitEdge) {
                return true;
            }
            return false;
        } else if (graphQLFeedUnitEdge.mo2540c().mo2507g() == null) {
            return m15280a(graphQLFeedUnitEdge.mo2540c(), graphQLFeedUnitEdge2.mo2540c());
        } else {
            if (graphQLFeedUnitEdge == graphQLFeedUnitEdge2 || graphQLFeedUnitEdge.mo2540c() == graphQLFeedUnitEdge2.mo2540c() || graphQLFeedUnitEdge.mo2540c().mo2507g().equals(graphQLFeedUnitEdge2.mo2540c().mo2507g())) {
                return true;
            }
            return false;
        }
    }

    private boolean m15280a(FeedUnit feedUnit, FeedUnit feedUnit2) {
        if (!(feedUnit instanceof GraphQLStory) || !(feedUnit2 instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        GraphQLStory graphQLStory2 = (GraphQLStory) feedUnit2;
        if (this.f10204a.m9728a(graphQLStory) == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || this.f10204a.m9728a(graphQLStory2) == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || graphQLStory.m22336V() != graphQLStory2.m22336V()) {
            return false;
        }
        return true;
    }

    public final boolean mo1979a(T t, T t2, long j) {
        if ((t instanceof GraphQLFeedUnitEdge) && (t2 instanceof GraphQLFeedUnitEdge)) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) t;
            GraphQLFeedUnitEdge graphQLFeedUnitEdge2 = (GraphQLFeedUnitEdge) t2;
            Object obj = null;
            if ((graphQLFeedUnitEdge instanceof GapFeedEdge) || (graphQLFeedUnitEdge2 instanceof GapFeedEdge)) {
                obj = 1;
            } else if (graphQLFeedUnitEdge.mo2540c().mo2507g() != null && graphQLFeedUnitEdge.mo2540c().mo2507g().equals(graphQLFeedUnitEdge2.mo2540c().mo2507g()) && graphQLFeedUnitEdge.mo2540c().T_() == j) {
                int i = 1;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
}
