package com.facebook.feed.rows.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.common.idleexecutor.IdleExecutor_ForUiThreadMethodAutoProvider;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.inject.Assisted;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.recyclerview.NotifyOnceAdapterObserver;
import com.facebook.widget.viewadapterpreallocator.PreallocatingAdapter;
import com.facebook.widget.viewadapterpreallocator.ViewAdapterPreallocator;
import com.facebook.widget.viewadapterpreallocator.ViewAdapterPreallocatorProvider;
import javax.inject.Inject;

/* compiled from: method/mobile.zeroGetOptinContent */
public class PreallocatingMultiRowAdapter extends DelegatingMultiRowRecyclerViewAdapter implements PreallocatingAdapter<ViewHolder> {
    public final ViewAdapterPreallocator<ViewHolder> f13588a;
    private int f13589b;

    /* compiled from: method/mobile.zeroGetOptinContent */
    class C05521 implements NotifyOnceAdapterObserver {
        final /* synthetic */ PreallocatingMultiRowAdapter f13602a;

        C05521(PreallocatingMultiRowAdapter preallocatingMultiRowAdapter) {
            this.f13602a = preallocatingMultiRowAdapter;
        }

        public final void mo2132a() {
            this.f13602a.f13588a.m19991a();
        }
    }

    @Inject
    public PreallocatingMultiRowAdapter(@Assisted MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter, @Assisted ScrollingViewProxy scrollingViewProxy, ViewAdapterPreallocatorProvider viewAdapterPreallocatorProvider) {
        super(multiRowRecyclerViewAdapter);
        this.f13588a = new ViewAdapterPreallocator(this, scrollingViewProxy.mo2363b(), Integer.valueOf(15), IdleExecutor_ForUiThreadMethodAutoProvider.m10033b(viewAdapterPreallocatorProvider));
        mo2640a(new C05521(this));
    }

    public final void jc_() {
        this.f13588a.m19996d();
        super.jc_();
    }

    public final ViewHolder mo2222a(ViewGroup viewGroup, int i) {
        return this.f13588a.m19990a(i);
    }

    public final void mo2225a(ViewHolder viewHolder, int i) {
        this.f13589b = i;
        super.mo2225a(viewHolder, i);
    }

    public final ViewHolder a_(ViewGroup viewGroup, int i) {
        return super.mo2222a(viewGroup, i);
    }

    public final int mo2655b() {
        return this.f13589b;
    }
}
