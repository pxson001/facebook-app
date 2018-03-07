package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: WIZARD_SEARCH */
public class GraphQLPeopleYouShouldFollowFeedUnit$Builder extends Builder {
    @Nullable
    public String f12483d;
    @Nullable
    public String f12484e;
    public long f12485f;
    @Nullable
    public String f12486g;
    @Nullable
    public GraphQLPeopleToFollowConnection f12487h;
    @Nullable
    public String f12488i;
    @Nullable
    public GraphQLTextWithEntities f12489j;
    @Nullable
    public GraphQLTextWithEntities f12490k;
    @Nullable
    public String f12491l;
    @Nullable
    public String f12492m;
    @Nullable
    PropertyBag f12493n = null;

    public GraphQLPeopleYouShouldFollowFeedUnit$Builder() {
        Preconditions.checkState(this instanceof GraphQLPeopleYouShouldFollowFeedUnit$Builder);
    }

    public static GraphQLPeopleYouShouldFollowFeedUnit$Builder m20691a(GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit) {
        GraphQLPeopleYouShouldFollowFeedUnit$Builder graphQLPeopleYouShouldFollowFeedUnit$Builder = new GraphQLPeopleYouShouldFollowFeedUnit$Builder();
        graphQLPeopleYouShouldFollowFeedUnit.h();
        graphQLPeopleYouShouldFollowFeedUnit$Builder.f12483d = graphQLPeopleYouShouldFollowFeedUnit.g();
        graphQLPeopleYouShouldFollowFeedUnit$Builder.f12484e = graphQLPeopleYouShouldFollowFeedUnit.S_();
        graphQLPeopleYouShouldFollowFeedUnit$Builder.f12485f = graphQLPeopleYouShouldFollowFeedUnit.T_();
        graphQLPeopleYouShouldFollowFeedUnit$Builder.f12486g = graphQLPeopleYouShouldFollowFeedUnit.p();
        graphQLPeopleYouShouldFollowFeedUnit$Builder.f12487h = graphQLPeopleYouShouldFollowFeedUnit.q();
        graphQLPeopleYouShouldFollowFeedUnit$Builder.f12488i = graphQLPeopleYouShouldFollowFeedUnit.r();
        graphQLPeopleYouShouldFollowFeedUnit$Builder.f12489j = graphQLPeopleYouShouldFollowFeedUnit.s();
        graphQLPeopleYouShouldFollowFeedUnit$Builder.f12490k = graphQLPeopleYouShouldFollowFeedUnit.t();
        graphQLPeopleYouShouldFollowFeedUnit$Builder.f12491l = graphQLPeopleYouShouldFollowFeedUnit.k();
        graphQLPeopleYouShouldFollowFeedUnit$Builder.f12492m = graphQLPeopleYouShouldFollowFeedUnit.u();
        Builder.a(graphQLPeopleYouShouldFollowFeedUnit$Builder, graphQLPeopleYouShouldFollowFeedUnit);
        graphQLPeopleYouShouldFollowFeedUnit$Builder.f12493n = (PropertyBag) graphQLPeopleYouShouldFollowFeedUnit.U_().clone();
        return graphQLPeopleYouShouldFollowFeedUnit$Builder;
    }
}
