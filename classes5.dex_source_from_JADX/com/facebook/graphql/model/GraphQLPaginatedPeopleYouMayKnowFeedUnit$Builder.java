package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: WRAPPER_OBJECT */
public class GraphQLPaginatedPeopleYouMayKnowFeedUnit$Builder extends Builder {
    @Nullable
    public GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection f12424d;
    @Nullable
    public String f12425e;
    @Nullable
    public String f12426f;
    public long f12427g;
    @Nullable
    public String f12428h;
    @Nullable
    public String f12429i;
    @Nullable
    public GraphQLTextWithEntities f12430j;
    @Nullable
    public GraphQLTextWithEntities f12431k;
    @Nullable
    public String f12432l;
    @Nullable
    public String f12433m;
    @Nullable
    PropertyBag f12434n = null;

    public GraphQLPaginatedPeopleYouMayKnowFeedUnit$Builder() {
        Preconditions.checkState(this instanceof GraphQLPaginatedPeopleYouMayKnowFeedUnit$Builder);
    }

    public static GraphQLPaginatedPeopleYouMayKnowFeedUnit$Builder m20611a(GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit) {
        GraphQLPaginatedPeopleYouMayKnowFeedUnit$Builder graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder = new GraphQLPaginatedPeopleYouMayKnowFeedUnit$Builder();
        graphQLPaginatedPeopleYouMayKnowFeedUnit.h();
        graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder.f12424d = graphQLPaginatedPeopleYouMayKnowFeedUnit.o();
        graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder.f12425e = graphQLPaginatedPeopleYouMayKnowFeedUnit.g();
        graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder.f12426f = graphQLPaginatedPeopleYouMayKnowFeedUnit.S_();
        graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder.f12427g = graphQLPaginatedPeopleYouMayKnowFeedUnit.T_();
        graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder.f12428h = graphQLPaginatedPeopleYouMayKnowFeedUnit.p();
        graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder.f12429i = graphQLPaginatedPeopleYouMayKnowFeedUnit.q();
        graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder.f12430j = graphQLPaginatedPeopleYouMayKnowFeedUnit.r();
        graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder.f12431k = graphQLPaginatedPeopleYouMayKnowFeedUnit.s();
        graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder.f12432l = graphQLPaginatedPeopleYouMayKnowFeedUnit.k();
        graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder.f12433m = graphQLPaginatedPeopleYouMayKnowFeedUnit.t();
        Builder.a(graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder, graphQLPaginatedPeopleYouMayKnowFeedUnit);
        graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder.f12434n = (PropertyBag) graphQLPaginatedPeopleYouMayKnowFeedUnit.U_().clone();
        return graphQLPaginatedPeopleYouMayKnowFeedUnit$Builder;
    }

    public final GraphQLPaginatedPeopleYouMayKnowFeedUnit m20612a() {
        return new GraphQLPaginatedPeopleYouMayKnowFeedUnit(this);
    }
}
