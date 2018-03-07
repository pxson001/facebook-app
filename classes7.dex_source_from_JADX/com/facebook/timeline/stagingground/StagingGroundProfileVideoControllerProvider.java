package com.facebook.timeline.stagingground;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.creativeediting.analytics.VideoCreativeEditingLogger;
import com.facebook.video.engine.VideoPlayerManager;
import java.util.concurrent.Executor;

/* compiled from: factory must not be null */
public class StagingGroundProfileVideoControllerProvider extends AbstractAssistedProvider<StagingGroundProfileVideoController> {
    public final StagingGroundProfileVideoController m18750a(StagingGroundAnalyticsLogger stagingGroundAnalyticsLogger) {
        return new StagingGroundProfileVideoController((Context) getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(this), VideoPlayerManager.a(this), VideoCreativeEditingLogger.m19548b(this), stagingGroundAnalyticsLogger, (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
