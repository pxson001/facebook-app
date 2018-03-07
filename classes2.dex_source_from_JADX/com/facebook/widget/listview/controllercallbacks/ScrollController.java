package com.facebook.widget.listview.controllercallbacks;

import android.content.res.Configuration;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ConfigurationChangedCallback;
import com.facebook.controllercallbacks.fragment.StartStopCallbacks;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;

/* compiled from: omnistore_entry */
public class ScrollController<Dispatcher extends ScrollCallback> extends BaseController implements ConfigurationChangedCallback, StartStopCallbacks {
    private OnScrollListener f11210a;
    public ScrollingFragmentViewHolder f11211b;
    public Dispatcher f11212c;

    /* compiled from: omnistore_entry */
    public class C05701 implements OnScrollListener {
        final /* synthetic */ ScrollController f13838a;

        public C05701(ScrollController scrollController) {
            this.f13838a = scrollController;
        }

        public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
            this.f13838a.f11212c.mo1262a(scrollingViewProxy, i);
        }

        public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            this.f13838a.f11212c.mo1263a(scrollingViewProxy, i, i2, i3);
        }
    }

    public final void mo2119e() {
        if (this.f11210a == null) {
            this.f11210a = new C05701(this);
        }
        this.f11211b.mo1997n().mo2369b(this.f11210a);
    }

    public final void mo2120f() {
        this.f11211b.mo1997n().mo2374c(this.f11210a);
    }

    public final void mo1947a(Configuration configuration) {
        ScrollingViewProxy n = this.f11211b.mo1997n();
        if (n != null) {
            n.mo2398m();
        }
    }
}
