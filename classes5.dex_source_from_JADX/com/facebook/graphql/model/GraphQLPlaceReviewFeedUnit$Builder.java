package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: WATERFALL */
public class GraphQLPlaceReviewFeedUnit$Builder extends Builder {
    @Nullable
    public String f12653d;
    @Nullable
    public String f12654e;
    public long f12655f;
    public ImmutableList<GraphQLPlaceReviewFeedUnitItem> f12656g;
    @Nullable
    public String f12657h;
    @Nullable
    public GraphQLTextWithEntities f12658i;
    @Nullable
    public String f12659j;
    @Nullable
    public PropertyBag f12660k = null;

    public GraphQLPlaceReviewFeedUnit$Builder() {
        Preconditions.checkState(this instanceof GraphQLPlaceReviewFeedUnit$Builder);
    }
}
