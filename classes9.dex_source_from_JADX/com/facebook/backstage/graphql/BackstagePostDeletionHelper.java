package com.facebook.backstage.graphql;

import com.facebook.backstage.consumption.stack.StoryViewAlertDialogHelper.C05441.C05431;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsModels.FBBackstagePostsDeleteMutationFragmentModel;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: required character count cannot be greater than the max password size */
public class BackstagePostDeletionHelper {
    public static final String f5214a = BackstagePostDeletionHelper.class.getSimpleName();
    public final Executor f5215b;
    public final GraphQLQueryExecutor f5216c;
    public final Provider<String> f5217d;

    /* compiled from: required character count cannot be greater than the max password size */
    public class C05581 implements FutureCallback<GraphQLResult<FBBackstagePostsDeleteMutationFragmentModel>> {
        final /* synthetic */ C05431 f5212a;
        final /* synthetic */ BackstagePostDeletionHelper f5213b;

        public C05581(BackstagePostDeletionHelper backstagePostDeletionHelper, C05431 c05431) {
            this.f5213b = backstagePostDeletionHelper;
            this.f5212a = c05431;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            String str = BackstagePostDeletionHelper.f5214a;
            ((FBBackstagePostsDeleteMutationFragmentModel) graphQLResult.e).m5004a().get(0);
            this.f5212a.m4872a(true);
        }

        public void onFailure(Throwable th) {
            this.f5212a.m4872a(false);
            BLog.b(BackstagePostDeletionHelper.f5214a, "Failed to delete an update", th);
        }
    }

    @Inject
    public BackstagePostDeletionHelper(Executor executor, GraphQLQueryExecutor graphQLQueryExecutor, Provider<String> provider) {
        this.f5215b = executor;
        this.f5216c = graphQLQueryExecutor;
        this.f5217d = provider;
    }
}
