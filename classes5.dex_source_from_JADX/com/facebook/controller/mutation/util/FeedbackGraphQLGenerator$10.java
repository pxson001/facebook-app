package com.facebook.controller.mutation.util;

import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateShimMutationFragmentModel;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;
import javax.annotation.Nullable;

/* compiled from: accessibility_caption */
class FeedbackGraphQLGenerator$10 implements FutureCallback<GraphQLResult<CommentCreateShimMutationFragmentModel>> {
    final /* synthetic */ SettableFuture f11704a;
    final /* synthetic */ FeedbackGraphQLGenerator f11705b;

    FeedbackGraphQLGenerator$10(FeedbackGraphQLGenerator feedbackGraphQLGenerator, SettableFuture settableFuture) {
        this.f11705b = feedbackGraphQLGenerator;
        this.f11704a = settableFuture;
    }

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null) {
            FutureDetour.a(this.f11704a, null, 405663335);
            return;
        }
        CommentCreateShimMutationFragmentModel commentCreateShimMutationFragmentModel = (CommentCreateShimMutationFragmentModel) graphQLResult.e;
        if (commentCreateShimMutationFragmentModel == null || commentCreateShimMutationFragmentModel.a() == null) {
            this.f11704a.a(new ServiceException(OperationResult.a(ErrorCode.OTHER, "Null response object or comment")));
            return;
        }
        FutureDetour.a(this.f11704a, commentCreateShimMutationFragmentModel.a(), -1688442536);
    }

    public void onFailure(Throwable th) {
        this.f11704a.a(th);
    }
}
