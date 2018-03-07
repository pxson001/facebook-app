package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: WORK_INVITE_LINK_SIGNUP */
public class GraphQLPeopleYouMayInviteFeedUnitContactsConnection$Builder extends Builder {
    public ImmutableList<GraphQLPeopleYouMayInviteFeedUnitContactsEdge> f12470d;
    @Nullable
    public GraphQLPageInfo f12471e;

    public GraphQLPeopleYouMayInviteFeedUnitContactsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLPeopleYouMayInviteFeedUnitContactsConnection$Builder);
    }

    public static GraphQLPeopleYouMayInviteFeedUnitContactsConnection$Builder m20646a(GraphQLPeopleYouMayInviteFeedUnitContactsConnection graphQLPeopleYouMayInviteFeedUnitContactsConnection) {
        GraphQLPeopleYouMayInviteFeedUnitContactsConnection$Builder graphQLPeopleYouMayInviteFeedUnitContactsConnection$Builder = new GraphQLPeopleYouMayInviteFeedUnitContactsConnection$Builder();
        graphQLPeopleYouMayInviteFeedUnitContactsConnection.h();
        graphQLPeopleYouMayInviteFeedUnitContactsConnection$Builder.f12470d = graphQLPeopleYouMayInviteFeedUnitContactsConnection.a();
        graphQLPeopleYouMayInviteFeedUnitContactsConnection$Builder.f12471e = graphQLPeopleYouMayInviteFeedUnitContactsConnection.j();
        Builder.a(graphQLPeopleYouMayInviteFeedUnitContactsConnection$Builder, graphQLPeopleYouMayInviteFeedUnitContactsConnection);
        return graphQLPeopleYouMayInviteFeedUnitContactsConnection$Builder;
    }

    public final GraphQLPeopleYouMayInviteFeedUnitContactsConnection m20647a() {
        return new GraphQLPeopleYouMayInviteFeedUnitContactsConnection(this);
    }
}
