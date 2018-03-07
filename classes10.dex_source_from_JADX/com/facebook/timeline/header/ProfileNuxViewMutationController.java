package com.facebook.timeline.header;

import com.facebook.graphql.calls.ProfileWizardNuxViewInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.timeline.protocol.ProfileNuxCancelMutation.ProfileNuxViewMutationString;
import javax.inject.Inject;

/* compiled from: friends_nearby_dashboard_invite_empty */
public class ProfileNuxViewMutationController {
    private GraphQLQueryExecutor f11312a;

    @Inject
    public ProfileNuxViewMutationController(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f11312a = graphQLQueryExecutor;
    }

    public final void m11399a(String str) {
        ProfileWizardNuxViewInputData profileWizardNuxViewInputData = new ProfileWizardNuxViewInputData();
        profileWizardNuxViewInputData.a("actor_id", str);
        GraphQlQueryString profileNuxViewMutationString = new ProfileNuxViewMutationString();
        profileNuxViewMutationString.a("input", profileWizardNuxViewInputData);
        this.f11312a.a(GraphQLRequest.a(profileNuxViewMutationString));
    }
}
