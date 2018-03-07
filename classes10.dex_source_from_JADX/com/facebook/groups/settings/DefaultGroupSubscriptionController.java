package com.facebook.groups.settings;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.Toaster;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: TIMESTAMP_DIVIDER */
public class DefaultGroupSubscriptionController extends AbstractGroupSubscriptionController {
    public static DefaultGroupSubscriptionController m24424b(InjectorLike injectorLike) {
        return new DefaultGroupSubscriptionController(Toaster.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public DefaultGroupSubscriptionController(Toaster toaster, ExecutorService executorService, String str, GraphQLQueryExecutor graphQLQueryExecutor) {
        super(toaster, executorService, str, graphQLQueryExecutor);
    }
}
