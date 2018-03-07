package com.facebook.messaging.business.common.calltoaction;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.calls.MessengerCallToActionPostbackInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.messaging.business.common.calltoaction.CallToActionContainerView.C09981.C09971;
import com.facebook.messaging.business.common.calltoaction.graphql.CTAPostbackMutations.CTAPostbackMutationString;
import com.facebook.messaging.business.common.calltoaction.graphql.CTAPostbackMutationsModels.CTAPostbackMutationModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: newFavoriteBookmarksGroup */
public final class CTAPostbackMutationHelper {
    public final GraphQLQueryExecutor f8717a;
    private final TasksManager<String> f8718b;

    @Inject
    public CTAPostbackMutationHelper(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f8717a = graphQLQueryExecutor;
        this.f8718b = tasksManager;
    }

    public final void m8924a(String str, @Nullable final C09971 c09971) {
        MessengerCallToActionPostbackInputData messengerCallToActionPostbackInputData = new MessengerCallToActionPostbackInputData();
        messengerCallToActionPostbackInputData.a("postback_call_to_action_id", str);
        final GraphQlQueryString cTAPostbackMutationString = new CTAPostbackMutationString();
        cTAPostbackMutationString.a("input", messengerCallToActionPostbackInputData);
        this.f8718b.a(str, new Callable<ListenableFuture<GraphQLResult<CTAPostbackMutationModel>>>(this) {
            final /* synthetic */ CTAPostbackMutationHelper f8714b;

            public Object call() {
                return this.f8714b.f8717a.a(GraphQLRequest.a(cTAPostbackMutationString));
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<CTAPostbackMutationModel>>(this) {
            final /* synthetic */ CTAPostbackMutationHelper f8716b;

            protected final void m8922a(Object obj) {
                if (c09971 != null) {
                    c09971.m8928b();
                }
            }

            protected final void m8923a(Throwable th) {
                if (c09971 != null) {
                    c09971.m8928b();
                }
            }
        });
    }
}
