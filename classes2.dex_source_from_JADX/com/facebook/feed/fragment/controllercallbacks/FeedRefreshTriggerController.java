package com.facebook.feed.fragment.controllercallbacks;

import android.view.View;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasRefresh;
import com.facebook.feed.friending.FeedRefreshTrigger;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.ScrollingViewProxy;

/* compiled from: placefeed?placeid=%s&surface=%s&placename=%s */
public class FeedRefreshTriggerController extends BaseController implements ResumePauseCallbacks, ViewCreatedDestroyedCallbacks, AdapterCreatedCallback {
    private final FeedRefreshTrigger<HasRefresh> f9772a;
    private HasRefresh f9773b;

    public static FeedRefreshTriggerController m14788a(InjectorLike injectorLike) {
        return new FeedRefreshTriggerController(FeedRefreshTrigger.m14793a(injectorLike));
    }

    @Inject
    public FeedRefreshTriggerController(FeedRefreshTrigger feedRefreshTrigger) {
        this.f9772a = feedRefreshTrigger;
    }

    public final void mo1264c() {
        this.f9772a.m14797a(this.f9773b);
    }

    public final void mo1265d() {
        this.f9772a.m14798b();
    }

    public final void mo1886a(View view) {
        this.f9772a.m14796a();
    }

    public final void kG_() {
        this.f9772a.m14799c();
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f9773b = (HasRefresh) feedEnvironment;
    }

    public final void kF_() {
        this.f9773b = null;
    }
}
