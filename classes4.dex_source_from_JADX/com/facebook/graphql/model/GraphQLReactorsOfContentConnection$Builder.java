package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: rtc_video_params */
public class GraphQLReactorsOfContentConnection$Builder extends Builder {
    public int f3159d;
    public ImmutableList<GraphQLReactorsOfContentEdge> f3160e;
    @Nullable
    public GraphQLPageInfo f3161f;

    public GraphQLReactorsOfContentConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLReactorsOfContentConnection$Builder);
    }

    public final GraphQLReactorsOfContentConnection$Builder m3400a(int i) {
        this.f3159d = i;
        if (this.a != null && this.a.d) {
            this.a.b(this.b, 0, i);
        }
        return this;
    }

    public final GraphQLReactorsOfContentConnection m3401a() {
        return new GraphQLReactorsOfContentConnection(this);
    }
}
