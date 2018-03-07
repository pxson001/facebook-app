package com.facebook.feed.rows;

import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.view.View;
import android.widget.ListAdapter;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.ConfigurationChangedCallback;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.fragment.NewsFeedFragment;
import com.facebook.feed.fragment.controllercallbacks.NewsFeedAdapterConfiguration;
import com.facebook.feed.fragment.controllercallbacks.NewsFeedAdapterConfiguration.C05151;
import com.facebook.feed.fragment.controllercallbacks.NewsFeedAdapterConfiguration.C05182;
import com.facebook.feed.rows.MultipleRowsScrollHandler.C05141;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.inject.Assisted;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.controllercallbacks.AdapterDataChangedCallback;
import com.facebook.widget.listview.controllercallbacks.ScrollCallback;
import com.facebook.widget.listview.controllercallbacks.ScrollingFragmentViewHolder;
import com.facebook.widget.recyclerview.HasNotifyOnceAdapterObservers;
import com.facebook.widget.recyclerview.NotifyOnceAdapterObserver;
import javax.inject.Inject;

/* compiled from: omnistore_change_record */
public class MultiRowAdapterController<Dispatcher extends AdapterCreatedCallback & AdapterDataChangedCallback> extends BaseController implements ConfigurationChangedCallback, ResumePauseCallbacks, ViewCreatedDestroyedCallbacks, ScrollCallback {
    private final MultipleRowsScrollHandler f11213a;
    private final NewsFeedAdapterConfiguration f11214b;
    public final DataSetObserver f11215c = new C04711(this);
    public final NotifyOnceAdapterObserver f11216d = new C04722(this);
    public ScrollingFragmentViewHolder f11217e;
    private FeedEnvironment f11218f;
    public Dispatcher f11219g;
    private OnScrollListener f11220h;
    public HasMultiRow f11221i;

    /* compiled from: omnistore_change_record */
    class C04711 extends DataSetObserver {
        final /* synthetic */ MultiRowAdapterController f11316a;

        C04711(MultiRowAdapterController multiRowAdapterController) {
            this.f11316a = multiRowAdapterController;
        }

        public void onChanged() {
            ((AdapterDataChangedCallback) this.f11316a.f11219g).mo1951a((BasicAdapter) this.f11316a.f11221i);
        }
    }

    /* compiled from: omnistore_change_record */
    class C04722 implements NotifyOnceAdapterObserver {
        final /* synthetic */ MultiRowAdapterController f11317a;

        C04722(MultiRowAdapterController multiRowAdapterController) {
            this.f11317a = multiRowAdapterController;
        }

        public final void mo2132a() {
            this.f11317a.f11215c.onChanged();
        }
    }

    @Inject
    public MultiRowAdapterController(@Assisted NewsFeedAdapterConfiguration newsFeedAdapterConfiguration, MultipleRowsScrollHandler multipleRowsScrollHandler) {
        this.f11214b = newsFeedAdapterConfiguration;
        this.f11213a = multipleRowsScrollHandler;
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        this.f11220h.mo1262a(scrollingViewProxy, i);
    }

    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        this.f11220h.mo1263a(scrollingViewProxy, i, i2, i3);
    }

    public final void mo1947a(Configuration configuration) {
        if (this.f11221i != null) {
            this.f11221i.mo2508a(configuration);
        }
    }

    public final void mo1886a(View view) {
        this.f11220h = new C05141(this.f11213a);
        NewsFeedAdapterConfiguration newsFeedAdapterConfiguration = this.f11214b;
        NewsFeedFragment newsFeedFragment = (NewsFeedFragment) newsFeedAdapterConfiguration.f11114v.f10429a;
        newsFeedAdapterConfiguration.f11113u = newsFeedAdapterConfiguration.f11104l.m16446a(newsFeedAdapterConfiguration.f11112t, NewsFeedListType.f12255a, new C05151(newsFeedAdapterConfiguration, newsFeedFragment), null, newsFeedAdapterConfiguration.f11108p, HasScrollListenerSupportImpl.m18212a((ScrollingViewProxy) newsFeedAdapterConfiguration.f11105m.f10397b), new C05182(newsFeedAdapterConfiguration, newsFeedFragment));
        this.f11218f = newsFeedAdapterConfiguration.f11113u;
        m16532b();
    }

    public final void kG_() {
        if (this.f11221i != null) {
            this.f11221i.jc_();
            this.f11219g.kF_();
            if (this.f11221i instanceof HasNotifyOnceAdapterObservers) {
                ((HasNotifyOnceAdapterObservers) this.f11221i).mo2641b(this.f11216d);
            } else if (this.f11221i instanceof ListAdapter) {
                ((ListAdapter) this.f11221i).unregisterDataSetObserver(this.f11215c);
            }
            this.f11221i = null;
        }
        this.f11218f = null;
        this.f11220h = null;
    }

    public final void mo1264c() {
        m16532b();
    }

    public final void mo1265d() {
        MultipleRowsScrollHandler multipleRowsScrollHandler = this.f11213a;
        multipleRowsScrollHandler.f11227d.m16544a(multipleRowsScrollHandler.f11228e);
    }

    private void m16532b() {
        if (this.f11221i == null) {
            if (this.f11217e.mo1997n() == null) {
                throw new IllegalStateException("Must have Scrolling View to create an adapter");
            }
            this.f11221i = this.f11214b.m16444a();
            if (this.f11221i instanceof HasNotifyOnceAdapterObservers) {
                ((HasNotifyOnceAdapterObservers) this.f11221i).mo2640a(this.f11216d);
            } else if (this.f11221i instanceof ListAdapter) {
                ((ListAdapter) this.f11221i).registerDataSetObserver(this.f11215c);
            }
            this.f11219g.mo1889a(this.f11221i, this.f11217e.mo1997n(), this.f11218f);
        }
    }
}
