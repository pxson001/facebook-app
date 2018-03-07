package com.facebook.timeline.refresher;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.refresher.ProfileRefresherController.ActivityListener;
import java.util.concurrent.Executor;

/* compiled from: unwrapped/ */
public class ProfileRefresherControllerProvider extends AbstractAssistedProvider<ProfileRefresherController> {
    public final ProfileRefresherController m996a(ActivityListener activityListener, ProfileRefresherBinder profileRefresherBinder, ProfileRefresherModel profileRefresherModel, ProfileRefresherView profileRefresherView) {
        return new ProfileRefresherController(activityListener, profileRefresherBinder, profileRefresherModel, profileRefresherView, GraphQLQueryExecutor.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), ProfileRefresherAnalyticsLogger.m947a((InjectorLike) this), ProfileRefresherStepSkipMutationController.m1050b(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
