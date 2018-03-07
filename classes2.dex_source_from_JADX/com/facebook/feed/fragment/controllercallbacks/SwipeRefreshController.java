package com.facebook.feed.fragment.controllercallbacks;

import android.view.View;
import com.facebook.accessibility.ViewAccessibilityHelper;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.ControllerCallback;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.feed.data.FeedDataLoadedCallbacks;
import com.facebook.feed.logging.RerankingEventsLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event;
import com.facebook.feed.util.ConnectivityChangedCallback;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ultralight.Inject;
import com.facebook.widget.FbSwipeRefreshLayout;

/* compiled from: privacy_checkup/?source=%s */
public class SwipeRefreshController<Dispatcher extends Callback> extends BaseController implements ViewCreatedDestroyedCallbacks, FeedDataLoadedCallbacks, ConnectivityChangedCallback {
    public static final Class<?> f10149a = SwipeRefreshController.class;
    public final Lazy<ViewAccessibilityHelper> f10150b;
    public final NewsFeedEventLogger f10151c;
    public final RerankingEventsLogger f10152d;
    public FbSwipeRefreshLayout f10153e;
    public Dispatcher f10154f;

    @ControllerCallback
    /* compiled from: privacy_checkup/?source=%s */
    public interface Callback {
        void av();
    }

    /* compiled from: privacy_checkup/?source=%s */
    class OnRefreshListener implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener {
        final /* synthetic */ SwipeRefreshController f12251a;

        public OnRefreshListener(SwipeRefreshController swipeRefreshController) {
            this.f12251a = swipeRefreshController;
        }

        public final void mo2418a() {
            ((ViewAccessibilityHelper) this.f12251a.f10150b.get()).m8779a(this.f12251a.f10153e, this.f12251a.f10153e.getContext().getString(2131233428));
            this.f12251a.f10154f.av();
        }
    }

    public static SwipeRefreshController m15247a(InjectorLike injectorLike) {
        return new SwipeRefreshController(NewsFeedEventLogger.m4405a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 101), RerankingEventsLogger.m15253a(injectorLike));
    }

    @Inject
    public SwipeRefreshController(NewsFeedEventLogger newsFeedEventLogger, Lazy<ViewAccessibilityHelper> lazy, RerankingEventsLogger rerankingEventsLogger) {
        this.f10151c = newsFeedEventLogger;
        this.f10150b = lazy;
        this.f10152d = rerankingEventsLogger;
    }

    public final void mo1900b(boolean z) {
        if (!z) {
            m15248c();
        }
    }

    public final void m15250a(boolean z, boolean z2) {
        if (z && z2) {
            m15248c();
        }
    }

    public final void m15251b() {
        m15248c();
    }

    public final void mo1886a(View view) {
        this.f10153e = (FbSwipeRefreshLayout) view.findViewById(2131562166);
        this.f10153e.f11693e = new OnRefreshListener(this);
    }

    public final void kG_() {
        this.f10152d.m15258c();
        this.f10153e.f11693e = null;
        this.f10153e = null;
    }

    private void m15248c() {
        this.f10152d.m15257b();
        if (this.f10153e != null) {
            this.f10153e.setRefreshing(false);
        } else {
            this.f10151c.m4410a(f10149a.toString(), Event.SWIPE_LAYOUT_NULL);
        }
    }
}
