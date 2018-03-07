package com.facebook.saved.controller;

import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: is_hype_ad_unit */
public class SavedDashboardLoadMoreController implements OnScrollListener {
    public final Set<OnLoadMoreListener> f9019a = Sets.a();
    public LoadingState f9020b;
    public boolean f9021c;

    /* compiled from: is_hype_ad_unit */
    public enum LoadingState {
        REFRESHING,
        LOADING_MORE,
        LOAD_MORE_FAILED,
        NOT_LOADING
    }

    /* compiled from: is_hype_ad_unit */
    public interface OnLoadMoreListener {
        void mo418b();

        void mo419c();

        void mo420e();

        void mo421f();

        void mo422g();
    }

    public static SavedDashboardLoadMoreController m9035a(InjectorLike injectorLike) {
        return new SavedDashboardLoadMoreController();
    }

    @Inject
    public SavedDashboardLoadMoreController() {
        m9040g();
    }

    public final void m9036a(OnLoadMoreListener onLoadMoreListener) {
        this.f9019a.add(onLoadMoreListener);
    }

    public final void m9039d() {
        LoadingState loadingState = this.f9020b;
        this.f9020b = LoadingState.NOT_LOADING;
        if (loadingState == LoadingState.LOADING_MORE) {
            for (OnLoadMoreListener e : this.f9019a) {
                e.mo420e();
            }
        }
    }

    public final void m9040g() {
        this.f9020b = LoadingState.NOT_LOADING;
        this.f9021c = false;
        for (OnLoadMoreListener g : this.f9019a) {
            g.mo422g();
        }
    }

    public final void m9038a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        if (this.f9020b == LoadingState.NOT_LOADING && this.f9021c && i3 - (i + i2) <= 3) {
            for (OnLoadMoreListener b : this.f9019a) {
                b.mo418b();
            }
        }
    }

    public final void m9037a(ScrollingViewProxy scrollingViewProxy, int i) {
    }
}
