package com.facebook.feed.fragment.controllercallbacks;

import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.OnUserVisibleHintCallback;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.ViewportViewEvents$FeedVisibilityEvent;
import com.facebook.feed.util.event.ViewportViewEvents$FeedVisibilityEventSubscriber;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.ScrollListenerWithThrottlingSupport;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.controllercallbacks.AdapterDataChangedCallback;
import com.facebook.widget.listview.controllercallbacks.ScrollCallback;
import com.facebook.widget.listview.controllercallbacks.ScrollingFragmentViewHolder;
import com.facebook.widget.listview.throttling.ThrottledOnScrollListenerFactory;
import javax.inject.Inject;

/* compiled from: photo_menu/add/?page_id=%s */
public class ViewportMonitorFragmentController<Dispatcher extends ViewportEventListener> extends ViewportViewEvents$FeedVisibilityEventSubscriber implements FragmentCreateDestroyCallbacks, OnUserVisibleHintCallback, ResumePauseCallbacks, AdapterDataChangedCallback, ScrollCallback {
    public final ViewportMonitor f10052a;
    private final FeedEventBus f10053b;
    private final OnScrollListener f10054c;
    public final QeAccessor f10055d;
    public ScrollingFragmentViewHolder f10056e;
    public Dispatcher f10057f;

    /* compiled from: photo_menu/add/?page_id=%s */
    public class C04241 implements ScrollListenerWithThrottlingSupport {
        final /* synthetic */ ViewportMonitorFragmentController f10068a;
        private boolean f10069b = false;
        private boolean f10070c = false;

        public C04241(ViewportMonitorFragmentController viewportMonitorFragmentController) {
            this.f10068a = viewportMonitorFragmentController;
        }

        public final int mo1974a() {
            return this.f10068a.f10055d.mo572a(ExperimentsForNewsFeedAbTestModule.ag, -1);
        }

        public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
            switch (i) {
                case 0:
                    this.f10068a.f10052a.m15154b(this.f10068a.f10056e.mo1997n());
                    this.f10069b = false;
                    return;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    this.f10070c = true;
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    break;
                default:
                    return;
            }
            this.f10069b = true;
        }

        public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            if (!this.f10070c) {
                this.f10068a.f10052a.mo1263a(scrollingViewProxy, i, i2, i3);
            }
            if (this.f10069b && i3 != 0) {
                this.f10068a.f10052a.mo1263a(scrollingViewProxy, i, i2, i3);
            }
        }
    }

    public static ViewportMonitorFragmentController m15131a(InjectorLike injectorLike) {
        return new ViewportMonitorFragmentController(QeInternalImplMethodAutoProvider.m3744a(injectorLike), ThrottledOnScrollListenerFactory.m14478a(injectorLike), FeedEventBus.m4573a(injectorLike), ViewportMonitor.m15145b(injectorLike));
    }

    public final void mo650b(FbEvent fbEvent) {
        m15132b(((ViewportViewEvents$FeedVisibilityEvent) fbEvent).f14049a);
    }

    @Inject
    public ViewportMonitorFragmentController(QeAccessor qeAccessor, ThrottledOnScrollListenerFactory throttledOnScrollListenerFactory, FeedEventBus feedEventBus, ViewportMonitor viewportMonitor) {
        this.f10055d = qeAccessor;
        this.f10053b = feedEventBus;
        this.f10054c = throttledOnScrollListenerFactory.m14481b((OnScrollListener) new C04241(this));
        this.f10052a = viewportMonitor;
    }

    public final void mo1949b() {
        this.f10052a.m15153b(this.f10057f);
    }

    public final void mo1948a(boolean z) {
        m15132b(z);
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        this.f10054c.mo1262a(scrollingViewProxy, i);
    }

    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        this.f10054c.mo1263a(scrollingViewProxy, i, i2, i3);
    }

    public final void mo1264c() {
        this.f10053b.m4568a((FbEventSubscriber) this);
        this.f10052a.m15152a(true, this.f10056e.mo1997n());
    }

    public final void mo1265d() {
        this.f10053b.m4569b((FbEventSubscriber) this);
        if (this.f10055d.mo596a(ExperimentsForNewsFeedAbTestModule.f5124y, false)) {
            this.f10052a.m15152a(false, this.f10056e.mo1997n());
        } else {
            this.f10052a.m15156c(this.f10056e.mo1997n());
        }
    }

    public final void mo1951a(BasicAdapter basicAdapter) {
        if (this.f10056e.mo1997n() != null && this.f10052a != null) {
            this.f10052a.m15148a(this.f10056e.mo1997n());
        }
    }

    private void m15132b(boolean z) {
        ScrollingViewProxy n = this.f10056e.mo1997n();
        if (n != null) {
            if (this.f10055d.mo596a(ExperimentsForNewsFeedAbTestModule.f5124y, false)) {
                this.f10052a.m15152a(z, n);
            } else if (z) {
                this.f10052a.m15148a(n);
            } else {
                this.f10052a.m15156c(n);
            }
        }
    }
}
