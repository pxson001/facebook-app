package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.idleexecutor.IdleExecutor_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.controller.connectioncontroller.common.ConnectionCacheRetainingPolicy;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManagerProvider;
import com.facebook.graphql.cursor.ModelCursorLoaderProvider;
import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.google.common.base.Function;
import java.util.concurrent.Executor;

/* compiled from: method/notifications.get */
public class DiskConnectionStoreProvider extends AbstractAssistedProvider<DiskConnectionStore> {
    public final <TEdge> DiskConnectionStore<TEdge> m8074a(String str, ConnectionCacheRetainingPolicy connectionCacheRetainingPolicy, Function<TEdge, String> function, int i) {
        return new DiskConnectionStore(str, connectionCacheRetainingPolicy, function, i, DefaultAndroidThreadUtil.b(this), (Executor) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), IdleExecutor_ForUiThreadMethodAutoProvider.b(this), GraphCursorDatabase.m8126a((InjectorLike) this), (ModelCursorLoaderProvider) getOnDemandAssistedProviderForStaticDi(ModelCursorLoaderProvider.class), (LocalModelCursorLoaderManagerProvider) getOnDemandAssistedProviderForStaticDi(LocalModelCursorLoaderManagerProvider.class), QuickPerformanceLoggerMethodAutoProvider.a(this), (Clock) SystemClockMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
