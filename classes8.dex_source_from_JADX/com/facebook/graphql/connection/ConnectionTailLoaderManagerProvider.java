package com.facebook.graphql.connection;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.Callbacks;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.RowIterator;
import com.facebook.graphql.connection.configuration.BatchConfiguration;
import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import java.util.concurrent.Executor;

/* compiled from: windowType */
public class ConnectionTailLoaderManagerProvider extends AbstractAssistedProvider<ConnectionTailLoaderManager> {
    public final ConnectionTailLoaderManager m200a(String str, BatchConfiguration batchConfiguration, Callbacks callbacks, RowIterator rowIterator) {
        return new ConnectionTailLoaderManager(str, batchConfiguration, callbacks, rowIterator, (Clock) SystemClockMethodAutoProvider.a(this), GraphQLQueryExecutor.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (Executor) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(this), GraphCursorDatabase.a(this), DefaultAndroidThreadUtil.b(this), QuickPerformanceLoggerMethodAutoProvider.a(this));
    }
}
