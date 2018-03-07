package com.facebook.commerce.publishing.fragments.adminproduct;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.commerce.publishing.fragments.adminproduct.ProductInitializationLoadable.ResultHandler;
import com.facebook.inject.Assisted;
import com.facebook.pages.common.viewercontextutils.PageViewerContextLifecycleHelper;
import com.facebook.pages.common.viewercontextutils.PageViewerContextLifecycleHelper.PageViewerContextLifecycleCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: customer_name */
public class PageViewerContextLoadable implements ProductInitializationLoadable<ViewerContext> {
    public final PageViewerContextLifecycleHelper f15622a;
    public final String f15623b;
    public final ResultHandler<ViewerContext> f15624c;

    /* compiled from: customer_name */
    class C21781 implements PageViewerContextLifecycleCallback {
        final /* synthetic */ PageViewerContextLoadable f15621a;

        C21781(PageViewerContextLoadable pageViewerContextLoadable) {
            this.f15621a = pageViewerContextLoadable;
        }

        public final void m16100a(@Nullable ViewerContext viewerContext) {
            this.f15621a.f15624c.mo760a(viewerContext);
            this.f15621a.f15622a.b();
        }

        public final void m16099a() {
            String str = "PageViewerContextLoadable failure. pageId: " + this.f15621a.f15623b;
            this.f15621a.f15624c.mo761a(str, new Throwable(str));
            this.f15621a.f15622a.b();
        }
    }

    @Inject
    public PageViewerContextLoadable(PageViewerContextLifecycleHelper pageViewerContextLifecycleHelper, @Assisted String str, @Assisted ResultHandler<ViewerContext> resultHandler) {
        this.f15622a = pageViewerContextLifecycleHelper;
        this.f15623b = str;
        this.f15624c = resultHandler;
    }

    public final void mo762a() {
        this.f15622a.a(false);
        this.f15622a.a(this.f15623b, new C21781(this));
    }
}
