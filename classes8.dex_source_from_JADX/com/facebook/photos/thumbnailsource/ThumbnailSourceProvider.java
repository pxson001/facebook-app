package com.facebook.photos.thumbnailsource;

import com.facebook.bitmaps.ThumbnailMaker;
import com.facebook.common.cpu.ProcessorInfoUtilMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.ui.images.cache.ImageCache;
import java.util.concurrent.ExecutorService;

/* compiled from: selected_friends */
public class ThumbnailSourceProvider extends AbstractAssistedProvider<ThumbnailSource> {
    public final ThumbnailSource m3438a(Integer num, Boolean bool) {
        return new ThumbnailSource(ImageCache.a(this), num, bool, (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(this), (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(this), ThumbnailMaker.b(this), (SequenceLogger) SequenceLoggerImpl.a(this), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this), ThumbnailSourceCacheUtil.m3437a(this), ProcessorInfoUtilMethodAutoProvider.a(this), GatekeeperStoreImplMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
