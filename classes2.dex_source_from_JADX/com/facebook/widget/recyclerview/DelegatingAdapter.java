package com.facebook.widget.recyclerview;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import com.facebook.widget.listview.FbListAdapter;
import javax.inject.Inject;

/* compiled from: method/auth.extendSSOAccessToken */
public class DelegatingAdapter extends Adapter<DelegatingViewHolder> implements InjectableComponentWithoutContext, AdapterCompatibleWithListView<DelegatingViewHolder> {
    @Inject
    public DefaultAndroidThreadUtil f13618a;
    @Inject
    public AbstractFbErrorReporter f13619b;
    public final FbListAdapter f13620c;
    public RecyclerView f13621d;
    private boolean f13622e;
    public boolean f13623f;
    private int f13624g;
    private final DataSetObserver f13625h = new C05541(this);
    private final AdapterDataObserver f13626i = new C05552(this);

    /* compiled from: method/auth.extendSSOAccessToken */
    class C05541 extends DataSetObserver {
        final /* synthetic */ DelegatingAdapter f13627a;

        C05541(DelegatingAdapter delegatingAdapter) {
            this.f13627a = delegatingAdapter;
        }

        public void onChanged() {
            if (!this.f13627a.f13623f) {
                this.f13627a.f13623f = true;
                if (!this.f13627a.f13618a.m1659c()) {
                    this.f13627a.f13619b.m2350b(DelegatingAdapter.class.getSimpleName(), "Adapter.notifyDataSetChanged() must be called from the UI thread.");
                }
                LayoutManager layoutManager = this.f13627a.f13621d.getLayoutManager();
                if (layoutManager != null) {
                    layoutManager.mo2309a("Do not call notifyDataSetChanged() while scrolling or in layout.");
                }
                this.f13627a.notifyDataSetChanged();
                this.f13627a.f13623f = false;
            }
        }

        public void onInvalidated() {
            this.f13627a.notifyDataSetChanged();
        }
    }

    /* compiled from: method/auth.extendSSOAccessToken */
    class C05552 extends AdapterDataObserver {
        final /* synthetic */ DelegatingAdapter f13628a;

        C05552(DelegatingAdapter delegatingAdapter) {
            this.f13628a = delegatingAdapter;
        }

        public final void bb_() {
            if (!this.f13628a.f13623f) {
                this.f13628a.f13623f = true;
                this.f13628a.f13620c.notifyDataSetChanged();
                this.f13628a.f13623f = false;
            }
        }

        public final void mo2217a(int i, int i2) {
            bb_();
        }

        public final void mo2210b(int i, int i2) {
            bb_();
        }

        public final void mo2212c(int i, int i2) {
            bb_();
        }

        public final void mo2218a(int i, int i2, int i3) {
            bb_();
        }
    }

    /* compiled from: method/auth.extendSSOAccessToken */
    public class DelegatingViewHolder extends ViewHolder {
        public DelegatingViewHolder(View view) {
            super(view);
        }
    }

    public static void m20033a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        DelegatingAdapter delegatingAdapter = (DelegatingAdapter) obj;
        DefaultAndroidThreadUtil b = DefaultAndroidThreadUtil.m1646b(injectorLike);
        AbstractFbErrorReporter a = FbErrorReporterImpl.m2317a(injectorLike);
        delegatingAdapter.f13618a = b;
        delegatingAdapter.f13619b = a;
    }

    public final void mo2225a(ViewHolder viewHolder, int i) {
        this.f13620c.getView(i, ((DelegatingViewHolder) viewHolder).f14095a, this.f13621d);
    }

    public DelegatingAdapter(FbListAdapter fbListAdapter, RecyclerView recyclerView) {
        Class cls = DelegatingAdapter.class;
        m20033a((Object) this, recyclerView.getContext());
        this.f13620c = fbListAdapter;
        this.f13621d = recyclerView;
        super.mo2223a(this.f13626i);
    }

    public final void mo2223a(AdapterDataObserver adapterDataObserver) {
        this.f13624g++;
        super.mo2223a(adapterDataObserver);
        if (!this.f13622e) {
            this.f13620c.registerDataSetObserver(this.f13625h);
            this.f13622e = true;
        }
    }

    public final void mo2227b(AdapterDataObserver adapterDataObserver) {
        this.f13624g--;
        super.mo2227b(adapterDataObserver);
        if (this.f13622e && this.f13624g == 0) {
            this.f13620c.unregisterDataSetObserver(this.f13625h);
            this.f13622e = false;
        }
    }

    public int getItemViewType(int i) {
        return this.f13620c.getItemViewType(i);
    }

    public final ViewHolder mo2222a(ViewGroup viewGroup, int i) {
        return new DelegatingViewHolder(this.f13620c.mo1985a(i, viewGroup));
    }

    public final int aZ_() {
        return this.f13620c.getCount();
    }

    public int iy_() {
        return this.f13620c.getViewTypeCount();
    }

    public Object getItem(int i) {
        return this.f13620c.getItem(i);
    }
}
