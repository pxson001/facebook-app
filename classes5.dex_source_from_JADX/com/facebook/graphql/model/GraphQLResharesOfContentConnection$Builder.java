package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;

/* compiled from: VIDEO_CHANNEL */
public class GraphQLResharesOfContentConnection$Builder extends Builder {
    public int f12939d;

    public GraphQLResharesOfContentConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLResharesOfContentConnection$Builder);
    }

    public final GraphQLResharesOfContentConnection$Builder m21498a(int i) {
        this.f12939d = i;
        if (this.a != null && this.a.d) {
            this.a.b(this.b, 0, i);
        }
        return this;
    }

    public final GraphQLResharesOfContentConnection m21499a() {
        return new GraphQLResharesOfContentConnection(this);
    }
}
