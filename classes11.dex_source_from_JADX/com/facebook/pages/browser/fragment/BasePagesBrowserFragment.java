package com.facebook.pages.browser.fragment;

import android.content.Context;
import android.os.Bundle;
import com.facebook.base.fragment.FbFragment;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.browser.analytics.PagesBrowserAnalytics;
import com.facebook.pages.browser.data.fetcher.PagesBrowserDataFetcher;
import com.facebook.pages.browser.util.PagesBrowserLikeHolder;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: story_gallery_survey_ratings_pref_skip */
public class BasePagesBrowserFragment extends FbFragment {
    protected PagesBrowserDataFetcher f1295a;
    protected TasksManager<String> f1296b;
    protected PagesBrowserLikeHolder f1297c;
    protected PagesBrowserAnalytics f1298d;
    private RawLikeHelper f1299e;

    public static void m1943a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BasePagesBrowserFragment) obj).m1942a(PagesBrowserDataFetcher.m1813a(injectorLike), TasksManager.b(injectorLike), PagesBrowserLikeHolder.m1988a(injectorLike), PagesBrowserAnalytics.m1788a(injectorLike), RawLikeHelper.b(injectorLike));
    }

    public void mo27c(Bundle bundle) {
        super.c(bundle);
        Class cls = BasePagesBrowserFragment.class;
        m1943a((Object) this, getContext());
    }

    @Inject
    private void m1942a(PagesBrowserDataFetcher pagesBrowserDataFetcher, TasksManager tasksManager, PagesBrowserLikeHolder pagesBrowserLikeHolder, PagesBrowserAnalytics pagesBrowserAnalytics, RawLikeHelper rawLikeHelper) {
        this.f1295a = pagesBrowserDataFetcher;
        this.f1296b = tasksManager;
        this.f1297c = pagesBrowserLikeHolder;
        this.f1298d = pagesBrowserAnalytics;
        this.f1299e = rawLikeHelper;
    }

    protected final void m1944a(String str, boolean z) {
        if (z) {
            this.f1297c.m1989a(str);
            return;
        }
        PagesBrowserLikeHolder pagesBrowserLikeHolder = this.f1297c;
        if (pagesBrowserLikeHolder.m1990c(str)) {
            pagesBrowserLikeHolder.f1343a.remove(str);
        }
    }

    protected final void m1946b(final String str, final boolean z) {
        this.f1299e.a(str, z, null, "pages_browser", null, "mobile_page_browser", null, false, new MutationCallback<String>(this) {
            final /* synthetic */ BasePagesBrowserFragment f1294c;

            public final /* bridge */ /* synthetic */ void m1938a(Object obj) {
            }

            public final void m1940b(Object obj) {
                String str = (String) obj;
                String str2 = "pages_browser_like_succesful";
                if (!z) {
                    str2 = "pages_browser_unlike_succesful";
                }
                this.f1294c.f1298d.m1791a(str2, Long.parseLong(str));
            }

            public final /* bridge */ /* synthetic */ void m1941c(Object obj) {
            }

            public final void m1939a(Object obj, ServiceException serviceException) {
                String str = "pages_browser_like_failure";
                if (!z) {
                    str = "pages_browser_unlike_failure";
                }
                this.f1294c.f1298d.m1791a(str, Long.parseLong(str));
                this.f1294c.m1944a(str, !z);
                this.f1294c.mo26b();
            }
        });
    }

    protected void mo26b() {
    }
}
