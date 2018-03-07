package com.facebook.backstage.graphql;

import android.support.annotation.Nullable;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsModels.FBBackstageSeenStateMutationFragmentModel;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: requiredChars */
public class BackstageMarkSeenMutationHelper {
    public static final String f5208a = BackstageMarkSeenMutationHelper.class.getSimpleName();
    public final Executor f5209b;
    public final GraphQLQueryExecutor f5210c;
    public final Provider<String> f5211d;

    /* compiled from: requiredChars */
    public class C05571 implements FutureCallback<GraphQLResult<FBBackstageSeenStateMutationFragmentModel>> {
        final /* synthetic */ BackstageMarkSeenMutationHelper f5207a;

        public void onSuccess(@Nullable Object obj) {
            String str = BackstageMarkSeenMutationHelper.f5208a;
        }

        public C05571(BackstageMarkSeenMutationHelper backstageMarkSeenMutationHelper) {
            this.f5207a = backstageMarkSeenMutationHelper;
        }

        public void onFailure(Throwable th) {
            BLog.b(BackstageMarkSeenMutationHelper.f5208a, "Failed to mark backstage as seen.", th);
        }
    }

    public static BackstageMarkSeenMutationHelper m4965b(InjectorLike injectorLike) {
        return new BackstageMarkSeenMutationHelper((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public BackstageMarkSeenMutationHelper(Executor executor, GraphQLQueryExecutor graphQLQueryExecutor, Provider<String> provider) {
        this.f5209b = executor;
        this.f5210c = graphQLQueryExecutor;
        this.f5211d = provider;
    }
}
