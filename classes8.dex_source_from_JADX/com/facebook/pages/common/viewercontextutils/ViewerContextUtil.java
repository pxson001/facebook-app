package com.facebook.pages.common.viewercontextutils;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContext.ViewerContextBuilder;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import com.facebook.pages.common.pageviewercontext.ViewerContextWaiter;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: coords */
public class ViewerContextUtil {
    public final AdminedPagesRamCache f16921a;
    private final ViewerContextManager f16922b;
    private final ViewerContext f16923c;
    public Lazy<SingleMethodRunner> f16924d;
    public Lazy<PageViewerContextApiMethod> f16925e;
    private Lazy<ExecutorService> f16926f;
    public Lazy<AnalyticsLogger> f16927g;

    public static ViewerContextUtil m20216b(InjectorLike injectorLike) {
        return new ViewerContextUtil(AdminedPagesRamCache.a(injectorLike), ViewerContextManagerProvider.b(injectorLike), ViewerContextMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3834), IdBasedSingletonScopeProvider.b(injectorLike, 2289), IdBasedLazy.a(injectorLike, 9009), IdBasedSingletonScopeProvider.b(injectorLike, 175));
    }

    @Inject
    public ViewerContextUtil(AdminedPagesRamCache adminedPagesRamCache, ViewerContextManager viewerContextManager, ViewerContext viewerContext, Lazy<ExecutorService> lazy, Lazy<SingleMethodRunner> lazy2, Lazy<PageViewerContextApiMethod> lazy3, Lazy<AnalyticsLogger> lazy4) {
        this.f16921a = adminedPagesRamCache;
        this.f16922b = viewerContextManager;
        this.f16923c = viewerContext;
        this.f16926f = lazy;
        this.f16924d = lazy2;
        this.f16925e = lazy3;
        this.f16927g = lazy4;
    }

    public final void m20221a(final String str, final ViewerContextWaiter viewerContextWaiter, Executor executor) {
        ((AnalyticsLogger) this.f16927g.get()).a("viewer_context_util_requested");
        if (this.f16923c != null && this.f16923c.mIsPageContext && this.f16923c.mUserId.equals(str)) {
            viewerContextWaiter.mo1013a(this.f16923c);
            ((AnalyticsLogger) this.f16927g.get()).a("viewer_context_util_available_immediately");
            return;
        }
        Optional b = m20217b(str);
        if (b.isPresent()) {
            viewerContextWaiter.mo1013a(m20219a(str, (String) b.get()));
            ((AnalyticsLogger) this.f16927g.get()).a("viewer_context_util_available_immediately");
            return;
        }
        viewerContextWaiter.mo1012a();
        Futures.a(m20218c(str), new FutureCallback<String>(this) {
            final /* synthetic */ ViewerContextUtil f16915c;

            public void onSuccess(@Nullable Object obj) {
                viewerContextWaiter.mo1015b(this.f16915c.m20219a(str, (String) obj));
                ((AnalyticsLogger) this.f16915c.f16927g.get()).a("viewer_context_util_fetched");
            }

            public void onFailure(Throwable th) {
                viewerContextWaiter.mo1014b();
            }
        }, executor);
    }

    public final ListenableFuture<ViewerContext> m20220a(final String str) {
        ((AnalyticsLogger) this.f16927g.get()).a("viewer_context_util_requested");
        if (this.f16923c != null && this.f16923c.mIsPageContext && this.f16923c.mUserId.equals(str)) {
            ((AnalyticsLogger) this.f16927g.get()).a("viewer_context_util_available_immediately");
            return Futures.a(this.f16923c);
        }
        Optional b = m20217b(str);
        if (!b.isPresent()) {
            return Futures.a(m20218c(str), new Function<String, ViewerContext>(this) {
                final /* synthetic */ ViewerContextUtil f16917b;

                @Nullable
                public Object apply(@Nullable Object obj) {
                    String str = (String) obj;
                    ((AnalyticsLogger) this.f16917b.f16927g.get()).a("viewer_context_util_fetched");
                    return this.f16917b.m20219a(str, str);
                }
            });
        }
        ((AnalyticsLogger) this.f16927g.get()).a("viewer_context_util_available_immediately");
        return Futures.a(m20219a(str, (String) b.get()));
    }

    public final ViewerContext m20219a(String str, String str2) {
        ViewerContext d = this.f16922b.d();
        ViewerContextBuilder newBuilder = ViewerContext.newBuilder();
        newBuilder.d = true;
        newBuilder = newBuilder;
        newBuilder.c = d.mSessionCookiesString;
        newBuilder = newBuilder;
        newBuilder.f = d.mSessionKey;
        newBuilder = newBuilder;
        newBuilder.e = d.mSessionSecret;
        ViewerContextBuilder viewerContextBuilder = newBuilder;
        viewerContextBuilder.a = str;
        viewerContextBuilder = viewerContextBuilder;
        viewerContextBuilder.b = str2;
        return viewerContextBuilder.h();
    }

    private Optional<String> m20217b(String str) {
        AdminedPagesPrefetchNode adminedPagesPrefetchNode = (AdminedPagesPrefetchNode) this.f16921a.b(str);
        if (adminedPagesPrefetchNode == null || !adminedPagesPrefetchNode.f16550b.isPresent()) {
            return Absent.INSTANCE;
        }
        return Optional.of(adminedPagesPrefetchNode.f16550b.get());
    }

    private ListenableFuture<String> m20218c(final String str) {
        final SettableFuture f = SettableFuture.f();
        ExecutorDetour.a((ExecutorService) this.f16926f.get(), new Runnable(this) {
            final /* synthetic */ ViewerContextUtil f16920c;

            public void run() {
                try {
                    PageViewerContextData pageViewerContextData = (PageViewerContextData) ((AbstractSingleMethodRunner) this.f16920c.f16924d.get()).a((ApiMethod) this.f16920c.f16925e.get(), str, CallerContext.a(ViewerContextUtil.class));
                    if (pageViewerContextData == null) {
                        f.a(new UnsupportedOperationException());
                        return;
                    }
                    this.f16920c.f16921a.a(String.valueOf(pageViewerContextData.f16899a), null, null, pageViewerContextData.f16900b, null, Absent.withType());
                    FutureDetour.a(f, pageViewerContextData.f16900b, -1569807892);
                } catch (Throwable e) {
                    f.a(e);
                }
            }
        }, 1204564903);
        return f;
    }
}
