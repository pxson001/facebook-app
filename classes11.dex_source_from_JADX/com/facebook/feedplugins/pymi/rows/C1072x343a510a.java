package com.facebook.feedplugins.pymi.rows;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;

/* compiled from: cleanup */
public class C1072x343a510a implements ContextStateKey<String, C1073xf61787c> {
    private final GraphQLPeopleYouMayInviteFeedUnitContactsEdge f8790a;

    public C1072x343a510a(GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge) {
        this.f8790a = graphQLPeopleYouMayInviteFeedUnitContactsEdge;
    }

    public final Object m9558b() {
        return this.f8790a.k();
    }

    public final Object m9557a() {
        return new C1073xf61787c(null, false);
    }
}
