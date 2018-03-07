package com.facebook.groups.docsandfiles.loader;

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

/* compiled from: Unsupported parameter type. */
public class FileMediaDownloader extends MediaDownloader {
    public static FileMediaDownloader m22381b(InjectorLike injectorLike) {
        return new FileMediaDownloader((Context) injectorLike.getInstance(Context.class, ForAppContext.class), FbHttpRequestProcessor.a(injectorLike), WebRequestCounters.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), TimeWindowThrottlingPolicy.a(injectorLike), NetworkDataLogUtils.a(injectorLike), (CdnHttpRequestHandler) CdnHttpRequestHandlerImpl.a(injectorLike), ConnectionStatusLogger.a(injectorLike));
    }

    @Inject
    public FileMediaDownloader(@ForAppContext Context context, FbHttpRequestProcessor fbHttpRequestProcessor, WebRequestCounters webRequestCounters, AnalyticsLogger analyticsLogger, TimeWindowThrottlingPolicy timeWindowThrottlingPolicy, NetworkDataLogUtils networkDataLogUtils, CdnHttpRequestHandler cdnHttpRequestHandler, ConnectionStatusLogger connectionStatusLogger) {
        super(context, fbHttpRequestProcessor, "fileordoc", webRequestCounters, analyticsLogger, timeWindowThrottlingPolicy, networkDataLogUtils, cdnHttpRequestHandler, connectionStatusLogger);
    }
}
