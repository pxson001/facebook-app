package com.facebook.ui.images.fetch;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.ConnectionStatusLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.throttling.TimeWindowThrottlingPolicy;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.cdn.handler.CdnHttpRequestHandler;
import com.facebook.cdn.handlerimpl.CdnHttpRequestHandlerImpl;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.fetch.MediaDownloader;
import javax.inject.Inject;

/* compiled from: recent_video_searches_network */
public class ImageMediaDownloader extends MediaDownloader {
    public static ImageMediaDownloader m3965b(InjectorLike injectorLike) {
        return new ImageMediaDownloader((Context) injectorLike.getInstance(Context.class, ForAppContext.class), FbHttpRequestProcessor.a(injectorLike), WebRequestCounters.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), TimeWindowThrottlingPolicy.a(injectorLike), NetworkDataLogUtils.a(injectorLike), (CdnHttpRequestHandler) CdnHttpRequestHandlerImpl.a(injectorLike), ConnectionStatusLogger.a(injectorLike));
    }

    @Inject
    public ImageMediaDownloader(@ForAppContext Context context, FbHttpRequestProcessor fbHttpRequestProcessor, WebRequestCounters webRequestCounters, AnalyticsLogger analyticsLogger, TimeWindowThrottlingPolicy timeWindowThrottlingPolicy, NetworkDataLogUtils networkDataLogUtils, CdnHttpRequestHandler cdnHttpRequestHandler, ConnectionStatusLogger connectionStatusLogger) {
        super(context, fbHttpRequestProcessor, "image", webRequestCounters, analyticsLogger, timeWindowThrottlingPolicy, networkDataLogUtils, cdnHttpRequestHandler, connectionStatusLogger);
    }
}
