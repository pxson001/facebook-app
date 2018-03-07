package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: WRITE_ON_TIMELINE */
public class GraphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder extends Builder {
    @Nullable
    public GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection f12408d;
    @Nullable
    public String f12409e;
    @Nullable
    public String f12410f;
    public long f12411g;
    @Nullable
    public String f12412h;
    @Nullable
    public String f12413i;
    @Nullable
    public GraphQLTextWithEntities f12414j;
    @Nullable
    public GraphQLTextWithEntities f12415k;
    @Nullable
    public String f12416l;
    @Nullable
    public String f12417m;
    @Nullable
    PropertyBag f12418n = null;

    public GraphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder() {
        Preconditions.checkState(this instanceof GraphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder);
    }

    public static GraphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder m20583a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit) {
        GraphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder = new GraphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder();
        graphQLPaginatedGroupsYouShouldJoinFeedUnit.h();
        graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder.f12408d = graphQLPaginatedGroupsYouShouldJoinFeedUnit.o();
        graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder.f12409e = graphQLPaginatedGroupsYouShouldJoinFeedUnit.g();
        graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder.f12410f = graphQLPaginatedGroupsYouShouldJoinFeedUnit.S_();
        graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder.f12411g = graphQLPaginatedGroupsYouShouldJoinFeedUnit.T_();
        graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder.f12412h = graphQLPaginatedGroupsYouShouldJoinFeedUnit.p();
        graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder.f12413i = graphQLPaginatedGroupsYouShouldJoinFeedUnit.q();
        graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder.f12414j = graphQLPaginatedGroupsYouShouldJoinFeedUnit.r();
        graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder.f12415k = graphQLPaginatedGroupsYouShouldJoinFeedUnit.s();
        graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder.f12416l = graphQLPaginatedGroupsYouShouldJoinFeedUnit.k();
        graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder.f12417m = graphQLPaginatedGroupsYouShouldJoinFeedUnit.t();
        Builder.a(graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder, graphQLPaginatedGroupsYouShouldJoinFeedUnit);
        graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder.f12418n = (PropertyBag) graphQLPaginatedGroupsYouShouldJoinFeedUnit.U_().clone();
        return graphQLPaginatedGroupsYouShouldJoinFeedUnit$Builder;
    }

    public final GraphQLPaginatedGroupsYouShouldJoinFeedUnit m20584a() {
        return new GraphQLPaginatedGroupsYouShouldJoinFeedUnit(this);
    }
}
