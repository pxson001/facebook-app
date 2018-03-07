package com.facebook.facecastdisplay;

import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import java.util.concurrent.ExecutorService;

/* compiled from: audio_button_clicks */
public class LiveLikeEventsDownloaderProvider extends AbstractAssistedProvider<LiveLikeEventsDownloader> {
    public final LiveLikeEventsDownloader m22509a(ExecutorService executorService) {
        return new LiveLikeEventsDownloader(executorService, GraphQLQueryExecutor.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), String_ViewerContextUserIdMethodAutoProvider.b(this), (Clock) SystemClockMethodAutoProvider.a(this));
    }
}
