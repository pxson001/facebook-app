package com.facebook.controller.mutation;

import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.api.ufiservices.common.TogglePostLikeParams;
import com.facebook.api.ufiservices.common.TogglePostLikeParams.Builder;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.controller.mutation.util.ModernFeedbackGraphQLGenerator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: tap_photos_feed_bling_bar_comment */
public class FeedbackMutationHelper {
    private final GraphQLActorCacheImpl f2263a;
    public final TasksManager f2264b;
    private final FeedbackGraphQLGenerator f2265c;
    private final ModernFeedbackGraphQLGenerator f2266d;
    private final FeedbackMutator f2267e;

    public static FeedbackMutationHelper m2217b(InjectorLike injectorLike) {
        return new FeedbackMutationHelper(FeedbackMutator.a(injectorLike), GraphQLActorCacheImpl.a(injectorLike), TasksManager.b(injectorLike), FeedbackGraphQLGenerator.a(injectorLike), ModernFeedbackGraphQLGenerator.b(injectorLike));
    }

    @Inject
    public FeedbackMutationHelper(FeedbackMutator feedbackMutator, GraphQLActorCacheImpl graphQLActorCacheImpl, TasksManager tasksManager, FeedbackGraphQLGenerator feedbackGraphQLGenerator, ModernFeedbackGraphQLGenerator modernFeedbackGraphQLGenerator) {
        this.f2267e = feedbackMutator;
        this.f2263a = graphQLActorCacheImpl;
        this.f2264b = tasksManager;
        this.f2265c = feedbackGraphQLGenerator;
        this.f2266d = modernFeedbackGraphQLGenerator;
    }

    public static FeedbackMutationHelper m2216a(InjectorLike injectorLike) {
        return m2217b(injectorLike);
    }

    public final void m2218a(final GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams, boolean z, final MutationCallback<GraphQLFeedback> mutationCallback) {
        Preconditions.checkNotNull(graphQLFeedback);
        GraphQLFeedback a = this.f2267e.a(graphQLFeedback, this.f2263a.a());
        Preconditions.checkNotNull(a);
        if (mutationCallback != null) {
            mutationCallback.a(a);
        }
        Builder a2 = TogglePostLikeParams.a();
        a2.d = feedbackLoggingParams;
        a2 = a2;
        a2.e = a;
        a2 = a2;
        a2.b = a.y_();
        Builder builder = a2;
        builder.c = this.f2263a.a();
        this.f2264b.a("toggle_like_" + graphQLFeedback.z_(), (z ? this.f2266d : this.f2265c).a(builder.a()), new OperationResultFutureCallback(this) {
            final /* synthetic */ FeedbackMutationHelper f2262c;

            public final void m2215a(Object obj) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) ((OperationResult) obj).k();
                if (mutationCallback != null && graphQLFeedback != null) {
                    mutationCallback.b(graphQLFeedback);
                }
            }

            public final void m2214a(ServiceException serviceException) {
                if (mutationCallback != null) {
                    mutationCallback.a(graphQLFeedback, serviceException);
                }
            }
        });
    }
}
