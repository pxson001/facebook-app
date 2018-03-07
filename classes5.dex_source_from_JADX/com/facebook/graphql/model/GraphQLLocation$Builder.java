package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: fb_sync */
public class GraphQLLocation$Builder extends Builder {
    public double f4412d;
    public double f4413e;
    @Nullable
    public String f4414f;

    public GraphQLLocation$Builder() {
        Preconditions.checkState(this instanceof GraphQLLocation$Builder);
    }

    public final GraphQLLocation m8960a() {
        return new GraphQLLocation(this);
    }
}
