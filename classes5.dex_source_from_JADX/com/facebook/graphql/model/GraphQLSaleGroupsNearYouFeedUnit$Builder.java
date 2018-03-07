package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: VIDEO_ANNOTATION */
public class GraphQLSaleGroupsNearYouFeedUnit$Builder extends Builder {
    @Nullable
    public GraphQLSaleGroupsNearYouFeedUnitGroupsConnection f12940d;
    @Nullable
    public String f12941e;
    @Nullable
    public String f12942f;
    public long f12943g;
    @Nullable
    public String f12944h;
    @Nullable
    public String f12945i;
    @Nullable
    public GraphQLTextWithEntities f12946j;
    @Nullable
    public GraphQLTextWithEntities f12947k;
    @Nullable
    public String f12948l;
    @Nullable
    public String f12949m;
    @Nullable
    PropertyBag f12950n = null;

    public GraphQLSaleGroupsNearYouFeedUnit$Builder() {
        Preconditions.checkState(this instanceof GraphQLSaleGroupsNearYouFeedUnit$Builder);
    }

    public static GraphQLSaleGroupsNearYouFeedUnit$Builder m21506a(GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit) {
        GraphQLSaleGroupsNearYouFeedUnit$Builder graphQLSaleGroupsNearYouFeedUnit$Builder = new GraphQLSaleGroupsNearYouFeedUnit$Builder();
        graphQLSaleGroupsNearYouFeedUnit.h();
        graphQLSaleGroupsNearYouFeedUnit$Builder.f12940d = graphQLSaleGroupsNearYouFeedUnit.o();
        graphQLSaleGroupsNearYouFeedUnit$Builder.f12941e = graphQLSaleGroupsNearYouFeedUnit.g();
        graphQLSaleGroupsNearYouFeedUnit$Builder.f12942f = graphQLSaleGroupsNearYouFeedUnit.S_();
        graphQLSaleGroupsNearYouFeedUnit$Builder.f12943g = graphQLSaleGroupsNearYouFeedUnit.T_();
        graphQLSaleGroupsNearYouFeedUnit$Builder.f12944h = graphQLSaleGroupsNearYouFeedUnit.p();
        graphQLSaleGroupsNearYouFeedUnit$Builder.f12945i = graphQLSaleGroupsNearYouFeedUnit.q();
        graphQLSaleGroupsNearYouFeedUnit$Builder.f12946j = graphQLSaleGroupsNearYouFeedUnit.r();
        graphQLSaleGroupsNearYouFeedUnit$Builder.f12947k = graphQLSaleGroupsNearYouFeedUnit.s();
        graphQLSaleGroupsNearYouFeedUnit$Builder.f12948l = graphQLSaleGroupsNearYouFeedUnit.k();
        graphQLSaleGroupsNearYouFeedUnit$Builder.f12949m = graphQLSaleGroupsNearYouFeedUnit.t();
        Builder.a(graphQLSaleGroupsNearYouFeedUnit$Builder, graphQLSaleGroupsNearYouFeedUnit);
        graphQLSaleGroupsNearYouFeedUnit$Builder.f12950n = (PropertyBag) graphQLSaleGroupsNearYouFeedUnit.U_().clone();
        return graphQLSaleGroupsNearYouFeedUnit$Builder;
    }

    public final GraphQLSaleGroupsNearYouFeedUnit m21507a() {
        return new GraphQLSaleGroupsNearYouFeedUnit(this);
    }
}
