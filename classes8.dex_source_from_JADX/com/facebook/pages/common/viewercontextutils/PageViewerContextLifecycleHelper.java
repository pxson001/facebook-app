package com.facebook.pages.common.viewercontextutils;

import android.content.Context;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.pages.common.pageviewercontext.ViewerContextWaiter;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@ContextScoped
@NotThreadSafe
/* compiled from: copied_link */
public class PageViewerContextLifecycleHelper {
    private static PageViewerContextLifecycleHelper f16903i;
    private static final Object f16904j = new Object();
    private final DefaultAndroidThreadUtil f16905a;
    private final ViewerContextManager f16906b;
    private final ViewerContextUtil f16907c;
    private final ExecutorService f16908d;
    public final AbstractFbErrorReporter f16909e;
    @Nullable
    public ViewerContext f16910f;
    private boolean f16911g;
    private boolean f16912h;

    /* compiled from: copied_link */
    public interface PageViewerContextLifecycleCallback {
        void m20206a();

        void m20207a(@Nullable ViewerContext viewerContext);
    }

    private static PageViewerContextLifecycleHelper m20210b(InjectorLike injectorLike) {
        return new PageViewerContextLifecycleHelper(DefaultAndroidThreadUtil.b(injectorLike), ViewerContextManagerProvider.b(injectorLike), ViewerContextUtil.m20216b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public static PageViewerContextLifecycleHelper m20208a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageViewerContextLifecycleHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f16904j) {
                PageViewerContextLifecycleHelper pageViewerContextLifecycleHelper;
                if (a2 != null) {
                    pageViewerContextLifecycleHelper = (PageViewerContextLifecycleHelper) a2.a(f16904j);
                } else {
                    pageViewerContextLifecycleHelper = f16903i;
                }
                if (pageViewerContextLifecycleHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20210b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f16904j, b3);
                        } else {
                            f16903i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageViewerContextLifecycleHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageViewerContextLifecycleHelper(DefaultAndroidThreadUtil defaultAndroidThreadUtil, ViewerContextManager viewerContextManager, ViewerContextUtil viewerContextUtil, ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f16905a = defaultAndroidThreadUtil;
        this.f16906b = viewerContextManager;
        this.f16907c = viewerContextUtil;
        this.f16908d = executorService;
        this.f16909e = abstractFbErrorReporter;
    }

    public final void m20211a() {
        m20214a(true);
    }

    public final void m20214a(boolean z) {
        this.f16905a.a();
        this.f16911g = z;
        this.f16912h = true;
    }

    public final void m20215b() {
        this.f16905a.a();
        this.f16911g = false;
        this.f16912h = false;
        this.f16910f = null;
        this.f16906b.a(null);
    }

    public final void m20212a(String str) {
        m20213a(str, null);
    }

    public final void m20213a(String str, @Nullable final PageViewerContextLifecycleCallback pageViewerContextLifecycleCallback) {
        this.f16905a.a();
        Preconditions.checkState(!StringUtil.a(str));
        if (this.f16912h) {
            this.f16907c.m20221a(str, new ViewerContextWaiter(this) {
                final /* synthetic */ PageViewerContextLifecycleHelper f16902b;

                public final void mo1013a(@Nullable ViewerContext viewerContext) {
                    PageViewerContextLifecycleHelper.m20209a(this.f16902b, viewerContext, pageViewerContextLifecycleCallback);
                }

                public final void mo1012a() {
                }

                public final void mo1015b(ViewerContext viewerContext) {
                    PageViewerContextLifecycleHelper.m20209a(this.f16902b, viewerContext, pageViewerContextLifecycleCallback);
                }

                public final void mo1014b() {
                    this.f16902b.f16909e.b(PageViewerContextLifecycleHelper.class.getSimpleName(), "onViewerContextFetchFailed()");
                    if (pageViewerContextLifecycleCallback != null) {
                        pageViewerContextLifecycleCallback.m20206a();
                    }
                }
            }, this.f16908d);
        }
    }

    public static void m20209a(@Nullable PageViewerContextLifecycleHelper pageViewerContextLifecycleHelper, @Nullable ViewerContext viewerContext, PageViewerContextLifecycleCallback pageViewerContextLifecycleCallback) {
        pageViewerContextLifecycleHelper.f16905a.a();
        if (!pageViewerContextLifecycleHelper.f16912h) {
            return;
        }
        if (viewerContext == null || viewerContext.mIsPageContext) {
            if (viewerContext != null && StringUtil.a(viewerContext.mAuthToken)) {
                viewerContext = null;
            }
            pageViewerContextLifecycleHelper.f16910f = viewerContext;
            if (pageViewerContextLifecycleHelper.f16911g) {
                pageViewerContextLifecycleHelper.f16906b.a(viewerContext);
            }
            if (pageViewerContextLifecycleCallback != null) {
                pageViewerContextLifecycleCallback.m20207a(viewerContext);
                return;
            }
            return;
        }
        pageViewerContextLifecycleHelper.f16909e.b(PageViewerContextLifecycleHelper.class.getSimpleName(), "Non-page ViewerContext fetched");
        if (pageViewerContextLifecycleCallback != null) {
            pageViewerContextLifecycleCallback.m20206a();
        }
    }
}
