package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: is_album_attachment */
public class GraphQLCommentsConnection$Builder extends Builder {
    public int f3479d;
    public ImmutableList<GraphQLComment> f3480e;
    @Nullable
    public GraphQLPageInfo f3481f;

    public GraphQLCommentsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLCommentsConnection$Builder);
    }

    public final GraphQLCommentsConnection$Builder m6813a(int i) {
        this.f3479d = i;
        if (this.a != null && this.a.d) {
            this.a.b(this.b, 0, i);
        }
        return this;
    }

    public final GraphQLCommentsConnection m6814a() {
        return new GraphQLCommentsConnection(this);
    }
}
