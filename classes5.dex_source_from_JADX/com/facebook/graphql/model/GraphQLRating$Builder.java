package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;

/* compiled from: VIEWER_SELF */
public class GraphQLRating$Builder extends Builder {
    public int f12881d;
    public int f12882e;
    public double f12883f;

    public GraphQLRating$Builder() {
        Preconditions.checkState(this instanceof GraphQLRating$Builder);
    }

    public final GraphQLRating$Builder m21304a(double d) {
        this.f12883f = d;
        return this;
    }

    public final GraphQLRating m21305a() {
        return new GraphQLRating(this);
    }
}
