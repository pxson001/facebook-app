package com.facebook.orca.threadview;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: messages/compose */
public class RemoveFromContactListHelper {
    private final DefaultBlueServiceOperationFactory f7358a;
    private final ExecutorService f7359b;

    private static RemoveFromContactListHelper m6993b(InjectorLike injectorLike) {
        return new RemoveFromContactListHelper(DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RemoveFromContactListHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService) {
        this.f7358a = defaultBlueServiceOperationFactory;
        this.f7359b = executorService;
    }
}
