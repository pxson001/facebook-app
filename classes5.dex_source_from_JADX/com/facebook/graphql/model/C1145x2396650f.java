package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: WRITE_INVALID_ENTRY */
public class C1145x2396650f extends Builder {
    public ImmutableList<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge> f12419d;
    @Nullable
    public GraphQLPageInfo f12420e;

    public C1145x2396650f() {
        Preconditions.checkState(this instanceof C1145x2396650f);
    }

    public static C1145x2396650f m20588a(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection) {
        C1145x2396650f c1145x2396650f = new C1145x2396650f();
        graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.h();
        c1145x2396650f.f12419d = graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.a();
        c1145x2396650f.f12420e = graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.j();
        Builder.a(c1145x2396650f, graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection);
        return c1145x2396650f;
    }

    public final GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection m20589a() {
        return new GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection(this);
    }
}
