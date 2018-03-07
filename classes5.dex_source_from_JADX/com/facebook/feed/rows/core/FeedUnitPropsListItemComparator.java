package com.facebook.feed.rows.core;

import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.feed.model.GapFeedEdge.GapFeedUnit;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: WifiSentBytes */
public class FeedUnitPropsListItemComparator implements ListItemComparator<FeedProps<? extends FeedUnit>> {
    private final OptimisticStoryStateCache f12249a;

    public static FeedUnitPropsListItemComparator m20271a(InjectorLike injectorLike) {
        return new FeedUnitPropsListItemComparator(OptimisticStoryStateCache.a(injectorLike));
    }

    public final boolean m20274a(Object obj, @Nullable Object obj2) {
        FeedProps feedProps = (FeedProps) obj;
        FeedProps feedProps2 = (FeedProps) obj2;
        return (feedProps == null || feedProps2 == null || !m20273b(feedProps, feedProps2)) ? false : true;
    }

    public final boolean m20275a(Object obj, Object obj2, long j) {
        FeedProps feedProps = (FeedProps) obj;
        FeedProps feedProps2 = (FeedProps) obj2;
        if (feedProps == null || feedProps2 == null) {
            return false;
        }
        FeedUnit feedUnit = (FeedUnit) feedProps.a;
        FeedUnit feedUnit2 = (FeedUnit) feedProps2.a;
        if ((feedUnit instanceof GapFeedUnit) || (feedUnit2 instanceof GapFeedUnit)) {
            return true;
        }
        if (feedUnit.g() == null) {
            return false;
        }
        return feedUnit.g().equals(feedUnit2.g()) && feedUnit.T_() == j;
    }

    @Inject
    public FeedUnitPropsListItemComparator(OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f12249a = optimisticStoryStateCache;
    }

    private boolean m20273b(FeedProps<? extends FeedUnit> feedProps, FeedProps<? extends FeedUnit> feedProps2) {
        FeedUnit feedUnit = (FeedUnit) feedProps.a;
        FeedUnit feedUnit2 = (FeedUnit) feedProps2.a;
        if ((feedUnit instanceof GapFeedUnit) || (feedUnit2 instanceof GapFeedUnit)) {
            return feedUnit2 == feedUnit;
        } else {
            if (feedUnit.g() == null) {
                return m20272a(feedUnit, feedUnit2);
            }
            return feedUnit == feedUnit2 || feedUnit.g().equals(feedUnit2.g());
        }
    }

    private boolean m20272a(FeedUnit feedUnit, FeedUnit feedUnit2) {
        if (!(feedUnit instanceof GraphQLStory) || !(feedUnit2 instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        GraphQLStory graphQLStory2 = (GraphQLStory) feedUnit2;
        if (this.f12249a.a(graphQLStory) == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || this.f12249a.a(graphQLStory2) == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || graphQLStory.V() != graphQLStory2.V()) {
            return false;
        }
        return true;
    }
}
