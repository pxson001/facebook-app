package com.facebook.richdocument.logging;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentStartupUiTasksCompletedSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.ScrollValueChangedEventSubscriber;
import javax.inject.Inject;

@ContextScoped
/* compiled from: place_pic_url */
public class RichDocumentScrollDepthLogger extends ScrollValueChangedEventSubscriber {
    private static RichDocumentScrollDepthLogger f5554h;
    private static final Object f5555i = new Object();
    private final boolean f5556a;
    public RecyclerView f5557b;
    private RichDocumentInfo f5558c;
    private int f5559d;
    private int f5560e;
    private int f5561f;
    private int f5562g;

    /* compiled from: place_pic_url */
    class StartupTasksCompletedSubscriber extends RichDocumentStartupUiTasksCompletedSubscriber {
        final /* synthetic */ RichDocumentScrollDepthLogger f5553a;

        /* compiled from: place_pic_url */
        class C07131 implements Runnable {
            final /* synthetic */ StartupTasksCompletedSubscriber f5552a;

            C07131(StartupTasksCompletedSubscriber startupTasksCompletedSubscriber) {
                this.f5552a = startupTasksCompletedSubscriber;
            }

            public void run() {
                RichDocumentScrollDepthLogger.m5400d(this.f5552a.f5553a);
            }
        }

        public StartupTasksCompletedSubscriber(RichDocumentScrollDepthLogger richDocumentScrollDepthLogger) {
            this.f5553a = richDocumentScrollDepthLogger;
        }

        public final void m5397b(FbEvent fbEvent) {
            if (this.f5553a.f5557b != null) {
                this.f5553a.f5557b.post(new C07131(this));
            }
        }
    }

    private static RichDocumentScrollDepthLogger m5399b(InjectorLike injectorLike) {
        return new RichDocumentScrollDepthLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), RichDocumentEventBus.m5130a(injectorLike), RichDocumentInfo.m5102a(injectorLike));
    }

    @Inject
    public RichDocumentScrollDepthLogger(AnalyticsLogger analyticsLogger, RichDocumentEventBus richDocumentEventBus, RichDocumentInfo richDocumentInfo) {
        richDocumentEventBus.a(this);
        richDocumentEventBus.a(new StartupTasksCompletedSubscriber(this));
        this.f5556a = analyticsLogger.a("android_native_article_perf", false).a();
        this.f5558c = richDocumentInfo;
    }

    public final void m5402b(FbEvent fbEvent) {
        m5400d(this);
    }

    public static void m5400d(RichDocumentScrollDepthLogger richDocumentScrollDepthLogger) {
        if (richDocumentScrollDepthLogger.f5556a && richDocumentScrollDepthLogger.f5557b != null && (richDocumentScrollDepthLogger.f5557b.getLayoutManager() instanceof LinearLayoutManager)) {
            richDocumentScrollDepthLogger.f5559d = richDocumentScrollDepthLogger.f5558c.f5120h;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) richDocumentScrollDepthLogger.f5557b.getLayoutManager();
            if (linearLayoutManager.n() - 1 >= richDocumentScrollDepthLogger.f5560e - 1) {
                int i = richDocumentScrollDepthLogger.f5560e;
                richDocumentScrollDepthLogger.f5560e = linearLayoutManager.n();
                if (i != richDocumentScrollDepthLogger.f5560e) {
                    richDocumentScrollDepthLogger.f5562g = 0;
                    richDocumentScrollDepthLogger.f5561f = 0;
                }
                if (richDocumentScrollDepthLogger.f5560e < richDocumentScrollDepthLogger.f5559d) {
                    View c = linearLayoutManager.c(richDocumentScrollDepthLogger.f5560e);
                    if (c != null) {
                        richDocumentScrollDepthLogger.f5561f = c.getHeight();
                        int min = Math.min(c.getHeight(), c.getHeight() - (c.getBottom() - richDocumentScrollDepthLogger.f5557b.getHeight()));
                        if (min > richDocumentScrollDepthLogger.f5562g) {
                            richDocumentScrollDepthLogger.f5562g = min;
                        }
                    }
                }
            }
        }
    }

    public static RichDocumentScrollDepthLogger m5398a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentScrollDepthLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5555i) {
                RichDocumentScrollDepthLogger richDocumentScrollDepthLogger;
                if (a2 != null) {
                    richDocumentScrollDepthLogger = (RichDocumentScrollDepthLogger) a2.a(f5555i);
                } else {
                    richDocumentScrollDepthLogger = f5554h;
                }
                if (richDocumentScrollDepthLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5399b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5555i, b3);
                        } else {
                            f5554h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richDocumentScrollDepthLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final float m5401b() {
        if (this.f5559d == 0) {
            return 0.0f;
        }
        if (this.f5560e == 0) {
            return ((1.0f * ((float) this.f5562g)) / ((float) this.f5561f)) / ((float) this.f5559d);
        }
        if (this.f5560e >= this.f5559d) {
            return 1.0f;
        }
        return (((1.0f * ((float) this.f5562g)) / ((float) this.f5561f)) / ((float) this.f5559d)) + ((((float) this.f5560e) * 1.0f) / ((float) this.f5559d));
    }
}
