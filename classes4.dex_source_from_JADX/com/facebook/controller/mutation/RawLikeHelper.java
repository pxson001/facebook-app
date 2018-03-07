package com.facebook.controller.mutation;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.api.ufiservices.common.TogglePageLikeParams;
import com.facebook.api.ufiservices.common.TogglePostLikeParams;
import com.facebook.api.ufiservices.common.TogglePostLikeParams.Builder;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.controller.mutation.util.ModernFeedbackGraphQLGenerator;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;

@Deprecated
/* compiled from: onInfo MEDIA_INFO_UNKNOWN */
public class RawLikeHelper {
    public final AnalyticsLogger f6173a;
    private final CommonEventsBuilder f6174b;
    private final GraphQLActorCacheImpl f6175c;
    private final TasksManager f6176d;
    public final FeedbackGraphQLGenerator f6177e;
    public final ModernFeedbackGraphQLGenerator f6178f;

    public static RawLikeHelper m6644b(InjectorLike injectorLike) {
        return new RawLikeHelper(AnalyticsLoggerMethodAutoProvider.a(injectorLike), CommonEventsBuilder.b(injectorLike), GraphQLActorCacheImpl.a(injectorLike), TasksManager.b(injectorLike), FeedbackGraphQLGenerator.a(injectorLike), ModernFeedbackGraphQLGenerator.b(injectorLike));
    }

    @Inject
    public RawLikeHelper(AnalyticsLogger analyticsLogger, CommonEventsBuilder commonEventsBuilder, GraphQLActorCacheImpl graphQLActorCacheImpl, TasksManager tasksManager, FeedbackGraphQLGenerator feedbackGraphQLGenerator, ModernFeedbackGraphQLGenerator modernFeedbackGraphQLGenerator) {
        this.f6173a = analyticsLogger;
        this.f6174b = commonEventsBuilder;
        this.f6175c = graphQLActorCacheImpl;
        this.f6176d = tasksManager;
        this.f6177e = feedbackGraphQLGenerator;
        this.f6178f = modernFeedbackGraphQLGenerator;
    }

    public final void m6646a(String str, boolean z, String str2, String str3, String str4, String str5, ArrayNode arrayNode, boolean z2, MutationCallback<String> mutationCallback) {
        if (mutationCallback != null) {
            mutationCallback.a(str);
        }
        TogglePageLikeParams a = TogglePageLikeParams.a().a(str).a(z).a(this.f6175c.a()).a(new FeedbackLoggingParams(arrayNode, str4, str3)).b(str5).a();
        if (str2 != null) {
            this.f6173a.a(CommonEventsBuilder.a(str2, str, String.valueOf(z), str3));
        }
        this.f6176d.a("task_key_toggle_page_like" + str, new 1(this, z2, a), new 2(this, mutationCallback, str, str2, z, str3));
    }

    public final void m6645a(String str, boolean z, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams, MutationCallback<String> mutationCallback) {
        String str2;
        if (mutationCallback != null) {
            mutationCallback.a(str);
        }
        Builder a = TogglePostLikeParams.a();
        a.d = feedbackLoggingParams;
        Builder builder = a;
        if (graphQLFeedback == null) {
            str2 = str;
        } else {
            str2 = null;
        }
        builder.a = str2;
        a = builder;
        a.b = z;
        a = a;
        a.c = this.f6175c.a();
        a = a;
        a.e = graphQLFeedback;
        this.f6176d.a("task_key_toggle_post_like" + str, new 3(this, graphQLFeedback, a.a()), new 4(this, mutationCallback, str));
    }
}
