package com.facebook.feed.fragment.controllercallbacks;

import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.feed.ui.NewsFeedRecyclerViewProxy;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.controllercallbacks.ScrollingFragmentViewHolder;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.recyclerview.RecyclerViewProxy;

/* compiled from: param_priority */
public class NewsFeedViewController extends BaseController implements ViewCreatedDestroyedCallbacks, ScrollingFragmentViewHolder {
    @Inject
    public AbstractFbErrorReporter f10396a;
    public NewsFeedRecyclerViewProxy f10397b;
    private View f10398c;

    public static NewsFeedViewController m15488a(InjectorLike injectorLike) {
        NewsFeedViewController newsFeedViewController = new NewsFeedViewController();
        newsFeedViewController.f10396a = FbErrorReporterImpl.m2317a(injectorLike);
        return newsFeedViewController;
    }

    public final void mo1886a(View view) {
        this.f10398c = view;
        this.f10397b = m15489b(view);
    }

    public final void kG_() {
        this.f10397b = null;
        this.f10398c = null;
    }

    public final ScrollingViewProxy mo1997n() {
        return this.f10397b;
    }

    public final NewsFeedRecyclerViewProxy m15491b() {
        return this.f10397b;
    }

    private NewsFeedRecyclerViewProxy m15489b(View view) {
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) ((CustomFrameLayout) view).asViewGroup().findViewById(16908298);
        betterRecyclerView.setItemAnimator(null);
        betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView, this.f10396a));
        RecyclerViewProxy newsFeedRecyclerViewProxy = new NewsFeedRecyclerViewProxy(betterRecyclerView);
        newsFeedRecyclerViewProxy.mo2370b(false);
        newsFeedRecyclerViewProxy.mo2380d(true);
        newsFeedRecyclerViewProxy.f12219c.setOnScrollListenerLogging(655440);
        return newsFeedRecyclerViewProxy;
    }
}
