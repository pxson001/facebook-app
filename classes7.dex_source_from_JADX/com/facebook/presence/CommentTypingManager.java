package com.facebook.presence;

import com.facebook.graphql.calls.FeedbackStartTypingInputData;
import com.facebook.graphql.calls.FeedbackStopTypingInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Lazy;
import com.facebook.presence.TypingPresenceManager.TypingState;
import com.facebook.presence.abtest.ExperimentsForPresenceTestModule;
import com.facebook.presence.protocol.FeedbackStartTypingMutations.FeedbackStartTypingCoreMutationString;
import com.facebook.presence.protocol.FeedbackStopTypingMutations.FeedbackStopTypingCoreMutationString;
import com.facebook.qe.api.QeAccessor;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;

/* compiled from: importantForAccessibility */
public class CommentTypingManager implements TypingPresenceManager {
    private final Lazy<GraphQLQueryExecutor> f11153a;
    private final QeAccessor f11154b;

    @Inject
    public CommentTypingManager(Lazy<GraphQLQueryExecutor> lazy, QeAccessor qeAccessor) {
        this.f11153a = lazy;
        this.f11154b = qeAccessor;
    }

    public final void mo616a(String str, TypingState typingState) {
        if (this.f11154b.a(ExperimentsForPresenceTestModule.f11203a, false)) {
            switch (typingState) {
                case ACTIVE:
                    m13083a(str);
                    return;
                case INACTIVE:
                    m13084b(str);
                    return;
                default:
                    return;
            }
        }
    }

    @VisibleForTesting
    private void m13083a(String str) {
        FeedbackStartTypingInputData feedbackStartTypingInputData = new FeedbackStartTypingInputData();
        feedbackStartTypingInputData.a("feedback_id", str);
        GraphQlCallInput graphQlCallInput = feedbackStartTypingInputData;
        GraphQlQueryString feedbackStartTypingCoreMutationString = new FeedbackStartTypingCoreMutationString();
        feedbackStartTypingCoreMutationString.a("input", graphQlCallInput);
        ((GraphQLQueryExecutor) this.f11153a.get()).a(GraphQLRequest.a(feedbackStartTypingCoreMutationString));
    }

    @VisibleForTesting
    private void m13084b(String str) {
        FeedbackStopTypingInputData feedbackStopTypingInputData = new FeedbackStopTypingInputData();
        feedbackStopTypingInputData.a("feedback_id", str);
        GraphQlCallInput graphQlCallInput = feedbackStopTypingInputData;
        GraphQlQueryString feedbackStopTypingCoreMutationString = new FeedbackStopTypingCoreMutationString();
        feedbackStopTypingCoreMutationString.a("input", graphQlCallInput);
        ((GraphQLQueryExecutor) this.f11153a.get()).a(GraphQLRequest.a(feedbackStopTypingCoreMutationString));
    }
}
