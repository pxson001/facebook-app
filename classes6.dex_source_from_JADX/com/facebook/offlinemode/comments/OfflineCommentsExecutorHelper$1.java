package com.facebook.offlinemode.comments;

import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateShimMutationFragmentModel;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLComment.Builder;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: theme_color */
public class OfflineCommentsExecutorHelper$1 implements FutureCallback<GraphQLResult<T>> {
    final /* synthetic */ String f3196a;
    final /* synthetic */ OfflineCommentsExecutorHelper f3197b;

    public OfflineCommentsExecutorHelper$1(OfflineCommentsExecutorHelper offlineCommentsExecutorHelper, String str) {
        this.f3197b = offlineCommentsExecutorHelper;
        this.f3196a = str;
    }

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (!this.f3197b.b.isEmpty() && graphQLResult != null && graphQLResult.e != null) {
            CommentCreateShimMutationFragmentModel commentCreateShimMutationFragmentModel = (CommentCreateShimMutationFragmentModel) graphQLResult.e;
            if (commentCreateShimMutationFragmentModel.a() != null) {
                Builder a = Builder.a(commentCreateShimMutationFragmentModel.a());
                a.z = this.f3196a;
                GraphQLComment a2 = a.a();
                for (CanHandleSuccessfulOfflineComment a3 : this.f3197b.b) {
                    a3.mo1344a(a2);
                }
            }
        }
    }

    public void onFailure(Throwable th) {
    }
}
