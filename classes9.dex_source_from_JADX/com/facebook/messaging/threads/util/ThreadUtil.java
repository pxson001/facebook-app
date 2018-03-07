package com.facebook.messaging.threads.util;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.Session$OpenRequest */
public class ThreadUtil {
    private static final String f17842a = ThreadUtil.class.getSimpleName();
    private final DefaultBlueServiceOperationFactory f17843b;
    private final ExecutorService f17844c;
    private final AbstractFbErrorReporter f17845d;
    private final GatekeeperStoreImpl f17846e;
    private final Provider<String> f17847f;
    private final DefaultThreadKeyFactory f17848g;

    private static ThreadUtil m17844b(InjectorLike injectorLike) {
        return new ThreadUtil(DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), DefaultThreadKeyFactory.b(injectorLike));
    }

    @Inject
    public ThreadUtil(BlueServiceOperationFactory blueServiceOperationFactory, ExecutorService executorService, FbErrorReporter fbErrorReporter, GatekeeperStore gatekeeperStore, Provider<String> provider, ThreadKeyFactory threadKeyFactory) {
        this.f17843b = blueServiceOperationFactory;
        this.f17844c = executorService;
        this.f17845d = fbErrorReporter;
        this.f17846e = gatekeeperStore;
        this.f17847f = provider;
        this.f17848g = threadKeyFactory;
    }
}
