package com.facebook.feed.rows.adapter;

import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.debug.dumpsys.DumpsysDumpable;
import com.facebook.feed.rows.adapter.api.HasMarkers.Marker;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.AdaptersCollection;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.FeedUnitAdapter;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.ObservableAdaptersCollection;
import com.facebook.feed.rows.core.RowIdentifier;
import com.facebook.feed.rows.core.ViewBindingsMap;
import com.facebook.feed.rows.core.binding.Binder;
import com.facebook.feed.rows.core.preparer.AdapterPreparer;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.Assisted;
import com.facebook.widget.listview.ForwardAdapterDataObservers;
import com.facebook.widget.recyclerview.BaseHasNotifyOnceAdapterObservers;
import com.facebook.widget.recyclerview.NotifyOnceAdapterObserver;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import com.facebook.widget.viewdiagnostics.ViewDiagnosticsWrapper;
import com.google.common.base.Preconditions;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: min_unshown_stories_in_feed_adapter */
public class BasicMultiRowAdapter extends Adapter<ViewHolder> implements DumpsysDumpable, MultiRowRecyclerViewAdapter {
    private final ListItemRowController f13487a;
    public final AdaptersCollection f13488b;
    public final AdapterPreparer f13489c;
    private final boolean f13490d;
    private final BaseHasNotifyOnceAdapterObservers f13491e;
    private final ForwardAdapterDataObservers f13492f = new ForwardAdapterDataObservers();
    private final AbstractFbErrorReporter f13493g;
    private boolean f13494h;

    /* compiled from: min_unshown_stories_in_feed_adapter */
    class Observer extends AdapterDataObserver {
        final /* synthetic */ BasicMultiRowAdapter f13519a;

        public Observer(BasicMultiRowAdapter basicMultiRowAdapter) {
            this.f13519a = basicMultiRowAdapter;
        }

        public final void bb_() {
            this.f13519a.f13488b.mo2528e();
            this.f13519a.f13489c.mo2533a();
        }
    }

    /* compiled from: min_unshown_stories_in_feed_adapter */
    class AdaptersCollectionObserver extends AdapterDataObserver {
        final /* synthetic */ BasicMultiRowAdapter f13585a;

        public AdaptersCollectionObserver(BasicMultiRowAdapter basicMultiRowAdapter) {
            this.f13585a = basicMultiRowAdapter;
        }

        public final void bb_() {
            BasicMultiRowAdapter.m19834g(this.f13585a);
            this.f13585a.notifyDataSetChanged();
        }

        public final void mo2217a(int i, int i2) {
            BasicMultiRowAdapter.m19834g(this.f13585a);
            this.f13585a.m17217a(i, i2);
        }

        public final void mo2210b(int i, int i2) {
            BasicMultiRowAdapter.m19834g(this.f13585a);
            this.f13585a.m17228c(i, i2);
        }

        public final void mo2212c(int i, int i2) {
            BasicMultiRowAdapter.m19834g(this.f13585a);
            this.f13585a.m17230d(i, i2);
        }

        public final void mo2218a(int i, int i2, int i3) {
            boolean z = true;
            BasicMultiRowAdapter.m19834g(this.f13585a);
            if (i3 != 1) {
                z = false;
            }
            Preconditions.checkArgument(z);
            this.f13585a.m17223b(i, i2);
        }
    }

    /* compiled from: min_unshown_stories_in_feed_adapter */
    class NotifyOnceObserver implements NotifyOnceAdapterObserver {
        final /* synthetic */ BasicMultiRowAdapter f13587a;

        public NotifyOnceObserver(BasicMultiRowAdapter basicMultiRowAdapter) {
            this.f13587a = basicMultiRowAdapter;
        }

        public final void mo2132a() {
            this.f13587a.f13489c.mo2533a();
        }
    }

    @Inject
    public BasicMultiRowAdapter(@Assisted AdaptersCollection adaptersCollection, @Assisted AdapterPreparer adapterPreparer, @Assisted boolean z, AbstractFbErrorReporter abstractFbErrorReporter, ListItemRowController listItemRowController) {
        this.f13493g = abstractFbErrorReporter;
        this.f13490d = z;
        this.f13488b = adaptersCollection;
        this.f13489c = adapterPreparer;
        this.f13487a = listItemRowController;
        this.f13491e = new BaseHasNotifyOnceAdapterObservers();
        mo2223a(this.f13491e);
        super.mo2223a(this.f13492f);
        if (this.f13488b instanceof ObservableAdaptersCollection) {
            ((ObservableAdaptersCollection) this.f13488b).m19880a(new AdaptersCollectionObserver(this));
            mo2640a(new NotifyOnceObserver(this));
            return;
        }
        mo2223a(new Observer(this));
    }

    public final ViewHolder mo2222a(ViewGroup viewGroup, int i) {
        View a = this.f13487a.m16557a(i).mo1995a(viewGroup.getContext());
        if (!this.f13490d) {
            return new MultiRowViewHolder(a);
        }
        View viewDiagnosticsWrapper = new ViewDiagnosticsWrapper(viewGroup.getContext());
        viewDiagnosticsWrapper.addView(a);
        return new MultiRowViewHolder(viewDiagnosticsWrapper);
    }

    public final void mo2225a(ViewHolder viewHolder, int i) {
        View view = viewHolder.f14095a;
        View wrappedView = view instanceof ViewDiagnosticsWrapper ? ((ViewDiagnosticsWrapper) view).getWrappedView() : view;
        BoundedAdapter boundedAdapter = (BoundedAdapter) getItem(i);
        FeedUnitAdapter feedUnitAdapter = boundedAdapter.f13446a;
        int i2 = boundedAdapter.f13447b;
        feedUnitAdapter.m19052e(i2);
        Binder binder = (Binder) feedUnitAdapter.f12965j.get(i2);
        View view2 = binder.f13436a;
        if (view2 != null) {
            feedUnitAdapter.f12961f.m2340a(FeedUnitAdapter.f12956a, "bindNow called on an already bound Binder");
            if ((view2 instanceof RecyclerViewKeepAttached) && feedUnitAdapter.f12967l) {
                MultipleRowsStoriesRecycleCallback.m10041a(view2);
            }
        }
        ViewBindingsMap.m20701a(wrappedView, binder, feedUnitAdapter.f12961f);
        binder.mo2633a(wrappedView);
        Object obj = boundedAdapter.f13446a.f12957b;
        if (obj instanceof FeedUnit) {
            wrappedView.setTag(2131558528, ((FeedUnit) obj).mo2507g());
            if (boundedAdapter.f13447b == 0) {
                wrappedView.setTag(2131558552, "TOP");
            }
        }
    }

    public final int aZ_() {
        m19834g(this);
        return this.f13488b.mo2521b();
    }

    public int getItemViewType(int i) {
        m19834g(this);
        BoundedAdapter boundedAdapter = (BoundedAdapter) getItem(i);
        return this.f13487a.m16559b(boundedAdapter.f13446a.m19047b(boundedAdapter.f13447b));
    }

    public final int iy_() {
        m19834g(this);
        ListItemRowController listItemRowController = this.f13487a;
        if (listItemRowController.f11254f != null) {
            if (!listItemRowController.f11252d.m1659c()) {
                listItemRowController.f11253e.m2350b("BG_ROWTYPE_REGISTRATION", "registerAllViewTypes() called from outside the UI thread");
            }
            for (FeedRowSupportDeclaration a : (Set) listItemRowController.f11254f.get()) {
                a.mo2998a(listItemRowController);
            }
            listItemRowController.f11254f = null;
        }
        return listItemRowController.f11249a.size();
    }

    public Object getItem(int i) {
        m19834g(this);
        return this.f13488b.mo2519a(i);
    }

    public final long H_(int i) {
        m19834g(this);
        return (long) i;
    }

    public final void mo2508a(Configuration configuration) {
        this.f13488b.mo2524c();
        notifyDataSetChanged();
    }

    public final void jc_() {
        this.f13488b.mo2520a();
        this.f13489c.mo2534b();
        this.f13491e.jc_();
        this.f13494h = true;
    }

    public final boolean ba_() {
        return this.f13494h;
    }

    public final int s_(int i) {
        m19834g(this);
        return this.f13488b.mo2522b(i);
    }

    public final int t_(int i) {
        m19834g(this);
        return this.f13488b.mo2523c(i);
    }

    public final int mo2514g(int i) {
        m19834g(this);
        return this.f13488b.mo2525d(i);
    }

    public final int mo2512e() {
        m19834g(this);
        return this.f13488b.mo2529f();
    }

    public final int mo2515h(int i) {
        m19834g(this);
        return ((BoundedAdapter) getItem(i)).f13447b;
    }

    public final int mo2511d(int i) {
        m19834g(this);
        return ((BoundedAdapter) getItem(i)).f13446a.m19044a();
    }

    public final int mo2510c(int i) {
        m19834g(this);
        return this.f13488b.mo2527e(i);
    }

    public final void mo1888a(DumpsysContext dumpsysContext) {
        m19834g(this);
        dumpsysContext.f.a(this.f13488b, dumpsysContext);
    }

    public final RowIdentifier mo2513f() {
        return this.f13488b.mo2526d();
    }

    public final Marker mo2509b(int i) {
        m19834g(this);
        BoundedAdapter boundedAdapter = (BoundedAdapter) getItem(i);
        return new 1(this, boundedAdapter.f13449d, boundedAdapter.f13447b);
    }

    public final void mo2223a(AdapterDataObserver adapterDataObserver) {
        this.f13492f.m19854a(adapterDataObserver);
    }

    public final void mo2227b(AdapterDataObserver adapterDataObserver) {
        this.f13492f.m19856b(adapterDataObserver);
    }

    public final void mo2640a(NotifyOnceAdapterObserver notifyOnceAdapterObserver) {
        this.f13491e.mo2640a(notifyOnceAdapterObserver);
    }

    public final void mo2641b(NotifyOnceAdapterObserver notifyOnceAdapterObserver) {
        this.f13491e.mo2641b(notifyOnceAdapterObserver);
    }

    public static void m19834g(BasicMultiRowAdapter basicMultiRowAdapter) {
        if (basicMultiRowAdapter.f13494h) {
            basicMultiRowAdapter.f13493g.m2340a("BasicMultiRowAdapter", "Adapter is disposed. T11310846");
        }
    }
}
