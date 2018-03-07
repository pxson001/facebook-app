package com.facebook.facecastdisplay;

import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.controller.mutation.FeedbackMutationHelper;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.GraphQLFeedback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: strip- */
public class LiveCommentLikeHelper {
    public static final String f2872a = LiveCommentLikeHelper.class.getName();
    public final FeedbackMutationHelper f2873b;
    @Nullable
    public FeedbackLoggingParams f2874c;

    /* compiled from: strip- */
    public class C02481 implements MutationCallback<GraphQLFeedback> {
        final /* synthetic */ LiveCommentEventModel f2870a;
        final /* synthetic */ LiveCommentLikeHelper f2871b;

        public C02481(LiveCommentLikeHelper liveCommentLikeHelper, LiveCommentEventModel liveCommentEventModel) {
            this.f2871b = liveCommentLikeHelper;
            this.f2870a = liveCommentEventModel;
        }

        public final void m3156a(Object obj) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
            this.f2870a.f2853e = graphQLFeedback.y_();
        }

        public final void m3157a(Object obj, ServiceException serviceException) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
            String str = LiveCommentLikeHelper.f2872a;
            graphQLFeedback.y_();
            this.f2870a.f2853e = graphQLFeedback.y_();
        }

        public final /* bridge */ /* synthetic */ void m3158b(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void m3159c(Object obj) {
        }
    }

    @Inject
    public LiveCommentLikeHelper(FeedbackMutationHelper feedbackMutationHelper) {
        this.f2873b = feedbackMutationHelper;
    }
}
