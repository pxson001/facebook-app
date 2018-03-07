package com.facebook.redspace.fragment.controllercallbacks.controller;

import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.time.Clock;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.feed.fragment.controllercallbacks.SwipeRefreshController.Callback;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.RedspaceHomeViewInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.redspace.protocol.RedSpaceMutationFragments.RedSpaceHomeViewMutationString;
import com.facebook.ultralight.Inject;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: PageUpcomingEventsQuery */
public class RedSpaceHomeViewMutatorController extends BaseController implements ResumePauseCallbacks, Callback {
    @Inject
    public GraphQLQueryExecutor f12076a;
    @Inject
    public Clock f12077b;
    @Inject
    @LoggedInUserId
    public String f12078c;
    private long f12079d;

    @VisibleForTesting
    private void m12532b() {
        long a = this.f12077b.a();
        if (a - this.f12079d > 500) {
            RedspaceHomeViewInputData redspaceHomeViewInputData = new RedspaceHomeViewInputData();
            redspaceHomeViewInputData.a("actor_id", this.f12078c);
            GraphQlCallInput graphQlCallInput = redspaceHomeViewInputData;
            GraphQlQueryString redSpaceHomeViewMutationString = new RedSpaceHomeViewMutationString();
            redSpaceHomeViewMutationString.a("input", graphQlCallInput);
            this.f12076a.a(GraphQLRequest.a(redSpaceHomeViewMutationString));
            this.f12079d = a;
        }
    }

    public final void m12533c() {
        m12532b();
    }

    public final void m12534d() {
    }

    public final void av() {
        m12532b();
    }
}
