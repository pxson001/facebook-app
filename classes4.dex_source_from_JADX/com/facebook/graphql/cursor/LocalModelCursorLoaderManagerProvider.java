package com.facebook.graphql.cursor;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManager.LoaderCallbacks;
import com.facebook.inject.AbstractAssistedProvider;
import java.util.concurrent.Executor;

/* compiled from: messenger_wear */
public class LocalModelCursorLoaderManagerProvider extends AbstractAssistedProvider<LocalModelCursorLoaderManager> {
    public final LocalModelCursorLoaderManager m8192a(String str, LoaderCallbacks loaderCallbacks) {
        return new LocalModelCursorLoaderManager(str, loaderCallbacks, (ModelCursorLoaderProvider) getOnDemandAssistedProviderForStaticDi(ModelCursorLoaderProvider.class), DefaultAndroidThreadUtil.b(this), ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider.b(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this));
    }
}
