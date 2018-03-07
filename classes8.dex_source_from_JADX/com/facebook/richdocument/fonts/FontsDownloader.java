package com.facebook.richdocument.fonts;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.ConnectionStatusLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.throttling.TimeWindowThrottlingPolicy;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.cdn.handler.CdnHttpRequestHandler;
import com.facebook.cdn.handlerimpl.CdnHttpRequestHandlerImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.media.fetch.MediaDownloader;
import javax.inject.Inject;

@ContextScoped
/* compiled from: prefetch_show_end */
public class FontsDownloader extends MediaDownloader {
    private static FontsDownloader f5265a;
    private static final Object f5266b = new Object();

    private static FontsDownloader m5201b(InjectorLike injectorLike) {
        return new FontsDownloader((Context) injectorLike.getInstance(Context.class), FbHttpRequestProcessor.a(injectorLike), WebRequestCounters.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), TimeWindowThrottlingPolicy.a(injectorLike), NetworkDataLogUtils.a(injectorLike), (CdnHttpRequestHandler) CdnHttpRequestHandlerImpl.a(injectorLike), ConnectionStatusLogger.a(injectorLike));
    }

    @Inject
    public FontsDownloader(Context context, FbHttpRequestProcessor fbHttpRequestProcessor, WebRequestCounters webRequestCounters, AnalyticsLogger analyticsLogger, TimeWindowThrottlingPolicy timeWindowThrottlingPolicy, NetworkDataLogUtils networkDataLogUtils, CdnHttpRequestHandler cdnHttpRequestHandler, ConnectionStatusLogger connectionStatusLogger) {
        super(context, fbHttpRequestProcessor, "instant_article_fonts", webRequestCounters, analyticsLogger, timeWindowThrottlingPolicy, networkDataLogUtils, cdnHttpRequestHandler, connectionStatusLogger);
    }

    public static FontsDownloader m5200a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FontsDownloader b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5266b) {
                FontsDownloader fontsDownloader;
                if (a2 != null) {
                    fontsDownloader = (FontsDownloader) a2.a(f5266b);
                } else {
                    fontsDownloader = f5265a;
                }
                if (fontsDownloader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5201b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5266b, b3);
                        } else {
                            f5265a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fontsDownloader;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
