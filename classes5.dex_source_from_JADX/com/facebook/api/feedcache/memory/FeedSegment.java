package com.facebook.api.feedcache.memory;

import com.facebook.graphql.model.GraphQLPageInfo;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: apps_data_power */
public class FeedSegment {
    private final GraphQLPageInfo f8810a;

    public String toString() {
        return getClass().getSimpleName() + ":" + String.valueOf(this.f8810a.v_()) + ":" + String.valueOf(this.f8810a.a());
    }
}
