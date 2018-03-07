package com.facebook.events.permalink.pagevc;

import android.content.Context;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.model.Event;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.pages.common.pageviewercontext.ViewerContextWaiter;
import com.facebook.pages.common.viewercontextutils.ViewerContextUtil;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Function;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@ContextScoped
/* compiled from: banner */
public class PageViewerContextForAnEvent {
    private static PageViewerContextForAnEvent f18751e;
    private static final Object f18752f = new Object();
    public final Executor f18753a;
    public final Toaster f18754b;
    public final ViewerContextUtil f18755c;
    public String f18756d;

    private static PageViewerContextForAnEvent m19059b(InjectorLike injectorLike) {
        return new PageViewerContextForAnEvent(ViewerContextUtil.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), Toaster.b(injectorLike));
    }

    @Inject
    public PageViewerContextForAnEvent(ViewerContextUtil viewerContextUtil, Executor executor, Toaster toaster) {
        this.f18755c = viewerContextUtil;
        this.f18753a = executor;
        this.f18754b = toaster;
    }

    public static PageViewerContextForAnEvent m19058a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageViewerContextForAnEvent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18752f) {
                PageViewerContextForAnEvent pageViewerContextForAnEvent;
                if (a2 != null) {
                    pageViewerContextForAnEvent = (PageViewerContextForAnEvent) a2.a(f18752f);
                } else {
                    pageViewerContextForAnEvent = f18751e;
                }
                if (pageViewerContextForAnEvent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19059b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18752f, b3);
                        } else {
                            f18751e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageViewerContextForAnEvent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m19060a(Event event, final Function<ViewerContext, Void> function) {
        Object obj;
        if (event.v == null || 1 == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.f18755c.a(event.v, new ViewerContextWaiter(this) {
                final /* synthetic */ PageViewerContextForAnEvent f18750b;

                public final void m19054a() {
                    this.f18750b.f18754b.a(new ToastBuilder(2131237226));
                }

                public final void m19055a(ViewerContext viewerContext) {
                    function.apply(viewerContext);
                }

                public final void m19057b(ViewerContext viewerContext) {
                    function.apply(viewerContext);
                }

                public final void m19056b() {
                    this.f18750b.f18754b.a(new ToastBuilder(2131230762));
                }
            }, this.f18753a);
        } else {
            function.apply(null);
        }
    }
}
