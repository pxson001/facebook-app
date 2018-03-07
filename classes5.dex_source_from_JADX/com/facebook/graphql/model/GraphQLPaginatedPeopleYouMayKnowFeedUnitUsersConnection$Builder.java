package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: WORK_TOP_GROUPS_COMPOSER */
public class GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection$Builder extends Builder {
    public ImmutableList<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge> f12435d;
    @Nullable
    public GraphQLPageInfo f12436e;

    public GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection$Builder);
    }

    public static GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection$Builder m20617a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection) {
        GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection$Builder graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection$Builder = new GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection$Builder();
        graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.h();
        graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection$Builder.f12435d = graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.a();
        graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection$Builder.f12436e = graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.j();
        Builder.a(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection$Builder, graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection);
        return graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection$Builder;
    }

    public final GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection m20618a() {
        return new GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection(this);
    }
}
