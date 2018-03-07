package com.facebook.resources.impl;

import android.content.Context;
import com.facebook.analytics.ConnectionStatusLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.throttling.TimeWindowThrottlingPolicy;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.cdn.handler.CdnHttpRequestHandler;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.ui.media.fetch.MediaDownloader;

@InjectorModule
/* compiled from: PRIVACY_CHECKUP_AUDIENCE_FRAGMENT_TAG */
public class FbResourcesImplModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static MediaDownloader m12912a(@ForAppContext Context context, FbHttpRequestProcessor fbHttpRequestProcessor, WebRequestCounters webRequestCounters, AnalyticsLogger analyticsLogger, TimeWindowThrottlingPolicy timeWindowThrottlingPolicy, NetworkDataLogUtils networkDataLogUtils, CdnHttpRequestHandler cdnHttpRequestHandler, ConnectionStatusLogger connectionStatusLogger) {
        return new MediaDownloader(context, fbHttpRequestProcessor, "language", webRequestCounters, analyticsLogger, timeWindowThrottlingPolicy, networkDataLogUtils, cdnHttpRequestHandler, connectionStatusLogger);
    }
}
