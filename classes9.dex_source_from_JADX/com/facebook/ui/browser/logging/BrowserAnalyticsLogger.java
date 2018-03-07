package com.facebook.ui.browser.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.logging.RichDocumentSessionTracker;
import com.facebook.ui.browser.event.BrowserEventBus;
import com.facebook.ui.browser.event.BrowserEventSubscriber;
import com.facebook.ui.browser.event.BrowserEvents.OnHandleBackButtonPressEvent;
import com.facebook.ui.browser.event.BrowserEvents.OnHandleBackButtonPressEventSubscriber;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: title_bar_search_button_visible */
public class BrowserAnalyticsLogger {
    private static BrowserAnalyticsLogger f1553f;
    private static final Object f1554g = new Object();
    private AnalyticsLogger f1555a;
    public BrowserEventSubscriber<OnHandleBackButtonPressEvent> f1556b = new C01531(this);
    public final BrowserEventBus f1557c;
    private final RichDocumentSessionTracker f1558d;
    private final Context f1559e;

    /* compiled from: title_bar_search_button_visible */
    public class C01531 extends OnHandleBackButtonPressEventSubscriber {
        final /* synthetic */ BrowserAnalyticsLogger f1552a;

        public C01531(BrowserAnalyticsLogger browserAnalyticsLogger) {
            this.f1552a = browserAnalyticsLogger;
        }

        public final void m1625b(FbEvent fbEvent) {
            this.f1552a.m1628a("back_button_clicked", null);
        }
    }

    private static BrowserAnalyticsLogger m1627b(InjectorLike injectorLike) {
        return new BrowserAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), BrowserEventBus.m1600a(injectorLike), RichDocumentSessionTracker.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public BrowserAnalyticsLogger(AnalyticsLogger analyticsLogger, BrowserEventBus browserEventBus, RichDocumentSessionTracker richDocumentSessionTracker, Context context) {
        this.f1555a = analyticsLogger;
        this.f1557c = browserEventBus;
        this.f1558d = richDocumentSessionTracker;
        this.f1559e = context;
        this.f1557c.a(this.f1556b);
    }

    public final void m1628a(String str, @Nullable Map<String, String> map) {
        HoneyClientEventFast a = this.f1555a.a(str, false);
        if (a.a()) {
            a.a(map);
            if (!StringUtil.c(this.f1558d.a)) {
                a.a("article_chaining_ID", this.f1558d.a);
            }
            a.a("article_depth_level", this.f1558d.c(this.f1559e));
            a.b();
        }
    }

    public static BrowserAnalyticsLogger m1626a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BrowserAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1554g) {
                BrowserAnalyticsLogger browserAnalyticsLogger;
                if (a2 != null) {
                    browserAnalyticsLogger = (BrowserAnalyticsLogger) a2.a(f1554g);
                } else {
                    browserAnalyticsLogger = f1553f;
                }
                if (browserAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1627b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1554g, b3);
                        } else {
                            f1553f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = browserAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
