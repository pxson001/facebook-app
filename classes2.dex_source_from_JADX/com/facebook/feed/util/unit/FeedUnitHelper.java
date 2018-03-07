package com.facebook.feed.util.unit;

import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.HasFeedUnit;
import javax.annotation.Nullable;

/* compiled from: measurement.monitoring.sample_period_millis */
public class FeedUnitHelper {
    private FeedUnitHelper() {
    }

    @Nullable
    public static FeedUnit m21141a(@Nullable Object obj) {
        if (obj instanceof FeedUnit) {
            return (FeedUnit) obj;
        }
        if (obj instanceof HasFeedUnit) {
            return ((HasFeedUnit) obj).mo2540c();
        }
        return null;
    }

    @Nullable
    public static GraphQLFeedUnitEdge m21142b(@Nullable Object obj) {
        if (obj instanceof GraphQLFeedUnitEdge) {
            return (GraphQLFeedUnitEdge) obj;
        }
        if (obj instanceof BoundedAdapter) {
            return ((BoundedAdapter) obj).f13449d;
        }
        return null;
    }
}
