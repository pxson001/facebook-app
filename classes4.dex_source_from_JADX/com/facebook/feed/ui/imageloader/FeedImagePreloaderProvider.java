package com.facebook.feed.ui.imageloader;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.feed.collage.PhotoGridProperties;
import com.facebook.feed.photos.FeedImagesCacheStateMapper;
import com.facebook.feed.util.StoryAttachmentUtil;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: watermark_timestamp */
public class FeedImagePreloaderProvider extends AbstractAssistedProvider<FeedImagePreloader> {
    public final FeedImagePreloader m204a(CallerContext callerContext, ImagePreprocessor imagePreprocessor) {
        return new FeedImagePreloader(FeedImageLoader.a(this), PhotoGridProperties.b(this), callerContext, imagePreprocessor, PerfTestConfig.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), FeedImagesCacheStateMapper.a(this), StoryAttachmentUtil.a(this));
    }
}
