package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: UNBLOCK_PROMOTION */
public class GraphQLTopLevelCommentsConnection$Builder extends Builder {
    public int f13353d;
    public ImmutableList<GraphQLComment> f13354e;
    @Nullable
    public GraphQLPageInfo f13355f;
    public int f13356g;

    public GraphQLTopLevelCommentsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLTopLevelCommentsConnection$Builder);
    }

    public static GraphQLTopLevelCommentsConnection$Builder m22240a(GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection) {
        GraphQLTopLevelCommentsConnection$Builder graphQLTopLevelCommentsConnection$Builder = new GraphQLTopLevelCommentsConnection$Builder();
        graphQLTopLevelCommentsConnection.h();
        graphQLTopLevelCommentsConnection$Builder.f13353d = graphQLTopLevelCommentsConnection.a();
        graphQLTopLevelCommentsConnection$Builder.f13354e = graphQLTopLevelCommentsConnection.j();
        graphQLTopLevelCommentsConnection$Builder.f13355f = graphQLTopLevelCommentsConnection.k();
        graphQLTopLevelCommentsConnection$Builder.f13356g = graphQLTopLevelCommentsConnection.b();
        Builder.a(graphQLTopLevelCommentsConnection$Builder, graphQLTopLevelCommentsConnection);
        return graphQLTopLevelCommentsConnection$Builder;
    }

    public final GraphQLTopLevelCommentsConnection$Builder m22241a(int i) {
        this.f13353d = i;
        if (this.a != null && this.a.d) {
            this.a.b(this.b, 0, i);
        }
        return this;
    }

    public final GraphQLTopLevelCommentsConnection$Builder m22243b(int i) {
        this.f13356g = i;
        if (this.a != null && this.a.d) {
            this.a.b(this.b, 3, i);
        }
        return this;
    }

    public final GraphQLTopLevelCommentsConnection m22242a() {
        return new GraphQLTopLevelCommentsConnection(this);
    }
}
