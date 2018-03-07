package com.facebook.facecast.plugin;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.facecast.plugin.FacecastViewerFacepileController.ViewersDownloadedListener;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import java.util.concurrent.ExecutorService;

/* compiled from: blockUser */
public class FacecastViewerFacepileControllerProvider extends AbstractAssistedProvider<FacecastViewerFacepileController> {
    public final FacecastViewerFacepileController m22181a(String str, long j, ViewersDownloadedListener viewersDownloadedListener, Context context) {
        return new FacecastViewerFacepileController((Clock) SystemClockMethodAutoProvider.a(this), GraphQLQueryExecutor.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), str, j, viewersDownloadedListener, context);
    }
}
