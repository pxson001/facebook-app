package com.facebook.composer.controller;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.composer.controller.ComposerSellController.Delegate;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.model.ComposerLocation.ProvidesViewerCoordinates;
import java.util.concurrent.ExecutorService;

/* compiled from: heap_stats */
public class ComposerSellControllerProvider extends AbstractAssistedProvider<ComposerSellController> {
    public final <DataProvider extends ProvidesViewerCoordinates> ComposerSellController<DataProvider> m7739a(Delegate delegate, DataProvider dataProvider, Boolean bool, Boolean bool2, Boolean bool3, long j) {
        return new ComposerSellController(delegate, dataProvider, bool, bool2, bool3, j, (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), GraphQLQueryExecutor.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
