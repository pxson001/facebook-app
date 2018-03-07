package com.facebook.backstage.graphql;

import android.support.annotation.Nullable;
import com.facebook.backstage.graphql.FBBackstageMutationFragmentsModels.FBBackstageClearBadgeMutationModel;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.common.JewelCounters;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: res_size */
public class BackstageBadgeCountGraphQLHelper {
    public static final String f5202a = BackstageBadgeCountGraphQLHelper.class.getSimpleName();
    public final GraphQLQueryExecutor f5203b;
    public final Executor f5204c;
    public final JewelCounters f5205d;
    public final Provider<String> f5206e;

    /* compiled from: res_size */
    public class C05562 implements FutureCallback<GraphQLResult<FBBackstageClearBadgeMutationModel>> {
        final /* synthetic */ BackstageBadgeCountGraphQLHelper f5201a;

        public C05562(BackstageBadgeCountGraphQLHelper backstageBadgeCountGraphQLHelper) {
            this.f5201a = backstageBadgeCountGraphQLHelper;
        }

        public void onSuccess(@Nullable Object obj) {
            BLog.b(BackstageBadgeCountGraphQLHelper.f5202a, "Cleared badges.");
        }

        public void onFailure(Throwable th) {
            BLog.b(BackstageBadgeCountGraphQLHelper.f5202a, "Failed to clear badges.", th);
        }
    }

    public static BackstageBadgeCountGraphQLHelper m4964b(InjectorLike injectorLike) {
        return new BackstageBadgeCountGraphQLHelper((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), JewelCounters.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public BackstageBadgeCountGraphQLHelper(Executor executor, GraphQLQueryExecutor graphQLQueryExecutor, JewelCounters jewelCounters, Provider<String> provider) {
        this.f5204c = executor;
        this.f5203b = graphQLQueryExecutor;
        this.f5205d = jewelCounters;
        this.f5206e = provider;
    }
}
