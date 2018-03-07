package com.facebook.feed.environment.impl;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feed.environment.HasScrollListenerSupport.SimpleScrollListener;
import com.facebook.inject.Assisted;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ScrollingViewProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: no activities registered */
public class HasScrollListenerSupportImpl implements HasScrollListenerSupport {
    public static final String f12258a = HasScrollListenerSupportImpl.class.getSimpleName();
    @Deprecated
    public static final Delegate f12259b = new C05161();
    private final Delegate f12260c;
    private final AbstractFbErrorReporter f12261d;
    private List<SimpleScrollListener> f12262e;

    /* compiled from: no activities registered */
    final class C05161 implements Delegate {
        C05161() {
        }

        public final void mo2422a(HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
        }
    }

    /* compiled from: no activities registered */
    public interface Delegate {
        void mo2422a(HasScrollListenerSupportImpl hasScrollListenerSupportImpl);
    }

    /* compiled from: no activities registered */
    final class C05172 implements Delegate {
        final /* synthetic */ WeakReference f12263a;

        C05172(WeakReference weakReference) {
            this.f12263a = weakReference;
        }

        public final void mo2422a(HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
            ScrollingViewProxy scrollingViewProxy = (ScrollingViewProxy) this.f12263a.get();
            if (scrollingViewProxy != null) {
                scrollingViewProxy.mo2369b(new 1(this, hasScrollListenerSupportImpl));
            }
        }
    }

    @Inject
    public HasScrollListenerSupportImpl(@Assisted Delegate delegate, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12261d = abstractFbErrorReporter;
        if (delegate == null) {
            this.f12261d.m2350b(f12258a, "Null delegate not supported. Please use DISABLE_SCROLL_LISTENERS instead for a no-op.");
        }
        this.f12260c = delegate;
    }

    public static Delegate m18212a(ScrollingViewProxy scrollingViewProxy) {
        return new C05172(new WeakReference(scrollingViewProxy));
    }

    public static Delegate m18211a(BetterListView betterListView) {
        return new 3(new WeakReference(betterListView));
    }

    public static LazyListViewDelegate m18213a() {
        return new LazyListViewDelegate();
    }

    public final void mo2420a(SimpleScrollListener simpleScrollListener) {
        if (this.f12260c == f12259b) {
            this.f12261d.m2350b(f12258a, "Trying to add a scroll listener when scroll listeners are disabled. Ensure thatthe environment for the fragment that this PartDefintion is currentlybeing rendered in does not have DISABLE_SCROLL_LISTENERS");
        }
        if (this.f12262e == null) {
            this.f12262e = new ArrayList();
            this.f12260c.mo2422a(this);
        }
        this.f12262e.add(simpleScrollListener);
    }

    public final void mo2421b(SimpleScrollListener simpleScrollListener) {
        this.f12262e.remove(simpleScrollListener);
    }

    public final void m18215b() {
        int size = this.f12262e.size();
        for (int i = 0; i < size; i++) {
            ((SimpleScrollListener) this.f12262e.get(i)).a();
        }
    }
}
