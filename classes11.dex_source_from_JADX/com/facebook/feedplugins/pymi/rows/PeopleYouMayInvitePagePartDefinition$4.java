package com.facebook.feedplugins.pymi.rows;

import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.friends.constants.PeopleYouMayInviteLocation;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;

/* compiled from: cleanup */
class PeopleYouMayInvitePagePartDefinition$4 implements Runnable {
    final /* synthetic */ PeopleYouMayInvitePagePartDefinition$Props f8781a;
    final /* synthetic */ HasInvalidate f8782b;
    final /* synthetic */ PeopleYouMayInvitePagePartDefinition f8783c;

    PeopleYouMayInvitePagePartDefinition$4(PeopleYouMayInvitePagePartDefinition peopleYouMayInvitePagePartDefinition, PeopleYouMayInvitePagePartDefinition$Props peopleYouMayInvitePagePartDefinition$Props, HasInvalidate hasInvalidate) {
        this.f8783c = peopleYouMayInvitePagePartDefinition;
        this.f8781a = peopleYouMayInvitePagePartDefinition$Props;
        this.f8782b = hasInvalidate;
    }

    public void run() {
        PeopleYouMayInvitePagePartDefinition peopleYouMayInvitePagePartDefinition = this.f8783c;
        PeopleYouMayInvitePagePartDefinition$Props peopleYouMayInvitePagePartDefinition$Props = this.f8781a;
        HasInvalidate hasInvalidate = this.f8782b;
        GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge = peopleYouMayInvitePagePartDefinition$Props.f8793a;
        C1072x343a510a c1072x343a510a = new C1072x343a510a(graphQLPeopleYouMayInviteFeedUnitContactsEdge);
        C1073xf61787c c1073xf61787c = (C1073xf61787c) ((HasPersistentState) hasInvalidate).a(c1072x343a510a, graphQLPeopleYouMayInviteFeedUnitContactsEdge);
        if (c1073xf61787c.f8792b && !graphQLPeopleYouMayInviteFeedUnitContactsEdge.n().a) {
            peopleYouMayInvitePagePartDefinition.k.b(graphQLPeopleYouMayInviteFeedUnitContactsEdge.l(), peopleYouMayInvitePagePartDefinition.h.a(graphQLPeopleYouMayInviteFeedUnitContactsEdge.l(), PeopleYouMayInviteLocation.FEED, graphQLPeopleYouMayInviteFeedUnitContactsEdge.j(), PeopleYouMayInvitePagePartDefinition.a(peopleYouMayInvitePagePartDefinition, graphQLPeopleYouMayInviteFeedUnitContactsEdge.k())), new PeopleYouMayInvitePagePartDefinition$5(peopleYouMayInvitePagePartDefinition, graphQLPeopleYouMayInviteFeedUnitContactsEdge, peopleYouMayInvitePagePartDefinition$Props, hasInvalidate, c1072x343a510a, c1073xf61787c));
        }
    }
}
