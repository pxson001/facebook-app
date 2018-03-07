package com.facebook.events.permalink.invitedbybar;

import android.content.Context;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.graphql.EventsMutations.EventUserBlockMutationString;
import com.facebook.events.graphql.EventsMutationsModels.EventUserBlockMutationModel;
import com.facebook.graphql.calls.EventUserBlockInputData;
import com.facebook.graphql.calls.EventUserBlockInputData.BlockType;
import com.facebook.graphql.calls.EventUserBlockInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: birthday_fetch_more_birthdays */
public class BlockUserInvitesController {
    private final GraphQLQueryExecutor f18568a;
    private final ExecutorService f18569b;
    public final Toaster f18570c;
    private final String f18571d;

    @Inject
    public BlockUserInvitesController(Toaster toaster, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, String str) {
        this.f18570c = toaster;
        this.f18569b = executorService;
        this.f18568a = graphQLQueryExecutor;
        this.f18571d = str;
    }

    public final void m18903a(String str, final String str2, EventAnalyticsParams eventAnalyticsParams, final Context context) {
        List c26372;
        C26361 c26361 = new FutureCallback<GraphQLResult<EventUserBlockMutationModel>>(this) {
            final /* synthetic */ BlockUserInvitesController f18567c;

            public void onSuccess(Object obj) {
                Toaster toaster = this.f18567c.f18570c;
                ToastBuilder toastBuilder = new ToastBuilder(context.getResources().getString(2131237068, new Object[]{str2}));
                toastBuilder.b = 17;
                toaster.b(toastBuilder);
            }

            public void onFailure(Throwable th) {
                Toaster toaster = this.f18567c.f18570c;
                ToastBuilder toastBuilder = new ToastBuilder(context.getResources().getString(2131237069, new Object[]{str2}));
                toastBuilder.b = 17;
                toaster.b(toastBuilder);
            }
        };
        EventUserBlockInputData eventUserBlockInputData = new EventUserBlockInputData();
        eventUserBlockInputData.a("actor_id", this.f18571d);
        GraphQlCallInput graphQlCallInput = eventUserBlockInputData;
        graphQlCallInput.a("target_user_id", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("block_type", BlockType.INVITE);
        graphQlCallInput = graphQlCallInput;
        final EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(eventAnalyticsParams.d);
        eventActionHistory.a("mechanism", ActionMechanism.PERMALINK.toString());
        if (eventAnalyticsParams.c == null) {
            c26372 = new ArrayList<EventActionHistory>(1) {
            };
        } else {
            final EventActionHistory eventActionHistory2 = new EventActionHistory();
            eventActionHistory2.a(eventAnalyticsParams.c);
            c26372 = new ArrayList<EventActionHistory>(2) {
            };
        }
        EventUserBlockInputData.Context context2 = new EventUserBlockInputData.Context();
        context2.a("event_action_history", c26372);
        graphQlCallInput.a("context", context2);
        Futures.a(this.f18568a.a(GraphQLRequest.a((EventUserBlockMutationString) new EventUserBlockMutationString().a("input", graphQlCallInput))), c26361, this.f18569b);
    }
}
