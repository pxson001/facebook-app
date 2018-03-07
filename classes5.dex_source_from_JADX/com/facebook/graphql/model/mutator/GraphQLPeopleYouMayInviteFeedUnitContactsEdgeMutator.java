package com.facebook.graphql.model.mutator;

import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge.PeopleYouMayInviteFeedUnitContactsEdgeExtra;
import com.google.common.base.Preconditions;

/* compiled from: TT */
public class GraphQLPeopleYouMayInviteFeedUnitContactsEdgeMutator {
    public final GraphQLPeopleYouMayInviteFeedUnitContactsEdge f13499a;

    private GraphQLPeopleYouMayInviteFeedUnitContactsEdgeMutator(GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge) {
        this.f13499a = graphQLPeopleYouMayInviteFeedUnitContactsEdge;
    }

    public static GraphQLPeopleYouMayInviteFeedUnitContactsEdgeMutator m22632a(GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge) {
        Preconditions.checkNotNull(graphQLPeopleYouMayInviteFeedUnitContactsEdge);
        return new GraphQLPeopleYouMayInviteFeedUnitContactsEdgeMutator((GraphQLPeopleYouMayInviteFeedUnitContactsEdge) graphQLPeopleYouMayInviteFeedUnitContactsEdge.f());
    }

    public final GraphQLPeopleYouMayInviteFeedUnitContactsEdgeMutator m22633a(boolean z) {
        PeopleYouMayInviteFeedUnitContactsEdgeExtra n = this.f13499a.m20665n();
        if (z != n.f12472a) {
            n.f12472a = z;
            n.c();
        }
        return this;
    }
}
