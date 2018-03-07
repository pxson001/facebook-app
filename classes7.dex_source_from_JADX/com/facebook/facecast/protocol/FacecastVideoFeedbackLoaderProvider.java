package com.facebook.facecast.protocol;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.facecast.protocol.FacecastVideoFeedbackLoader.VideoFeedbackLoaderListener;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: badgable_profiles */
public class FacecastVideoFeedbackLoaderProvider extends AbstractAssistedProvider<FacecastVideoFeedbackLoader> {
    public final FacecastVideoFeedbackLoader m22315a(String str, VideoFeedbackLoaderListener videoFeedbackLoaderListener) {
        return new FacecastVideoFeedbackLoader((AbstractFbErrorReporter) FbErrorReporterImpl.a(this), GraphQLQueryExecutor.a(this), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), str, videoFeedbackLoaderListener);
    }
}
