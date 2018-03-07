package com.facebook.resources.impl;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.ConnectionStatusLogger;
import com.facebook.analytics.throttling.TimeWindowThrottlingPolicy;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.cdn.handler.CdnHttpRequestHandler;
import com.facebook.cdn.handlerimpl.CdnHttpRequestHandlerImpl;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ForAppContext;
import com.facebook.ui.media.fetch.MediaDownloader;

/* compiled from: PRIVACY_CHECKUP_APP_STEP_PREVIOUS */
public class MediaDownloaderMethodAutoProvider extends AbstractProvider<MediaDownloader> {
    public Object get() {
        return FbResourcesImplModule.m12912a((Context) getInstance(Context.class, ForAppContext.class), FbHttpRequestProcessor.a(this), WebRequestCounters.a(this), AnalyticsLoggerMethodAutoProvider.a(this), TimeWindowThrottlingPolicy.a(this), NetworkDataLogUtils.a(this), (CdnHttpRequestHandler) CdnHttpRequestHandlerImpl.a(this), ConnectionStatusLogger.a(this));
    }
}
