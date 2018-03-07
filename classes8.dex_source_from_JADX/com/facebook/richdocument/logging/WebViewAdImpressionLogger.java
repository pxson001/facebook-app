package com.facebook.richdocument.logging;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: placeTimeZone */
public class WebViewAdImpressionLogger {
    private static WebViewAdImpressionLogger f5577c;
    private static final Object f5578d = new Object();
    public final RichDocumentAnalyticsLogger f5579a;
    public final MonotonicClock f5580b;

    private static WebViewAdImpressionLogger m5414b(InjectorLike injectorLike) {
        return new WebViewAdImpressionLogger(RichDocumentAnalyticsLogger.m5360a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public WebViewAdImpressionLogger(RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, MonotonicClock monotonicClock) {
        this.f5579a = richDocumentAnalyticsLogger;
        this.f5580b = monotonicClock;
    }

    public static WebViewAdImpressionLogger m5413a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WebViewAdImpressionLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5578d) {
                WebViewAdImpressionLogger webViewAdImpressionLogger;
                if (a2 != null) {
                    webViewAdImpressionLogger = (WebViewAdImpressionLogger) a2.a(f5578d);
                } else {
                    webViewAdImpressionLogger = f5577c;
                }
                if (webViewAdImpressionLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5414b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5578d, b3);
                        } else {
                            f5577c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = webViewAdImpressionLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
