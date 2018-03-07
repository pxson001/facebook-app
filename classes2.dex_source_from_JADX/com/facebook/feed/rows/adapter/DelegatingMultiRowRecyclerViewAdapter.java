package com.facebook.feed.rows.adapter;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.widget.recyclerview.NotifyOnceAdapterObserver;

/* compiled from: min_ad_freshness_delta_minutes */
public class DelegatingMultiRowRecyclerViewAdapter extends DelegatingHasMultiRow implements MultiRowRecyclerViewAdapter {
    private final MultiRowRecyclerViewAdapter f13523a;

    public DelegatingMultiRowRecyclerViewAdapter(MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter) {
        super(multiRowRecyclerViewAdapter);
        this.f13523a = multiRowRecyclerViewAdapter;
    }

    public final int iy_() {
        return this.f13523a.iy_();
    }

    public Object getItem(int i) {
        return this.f13523a.getItem(i);
    }

    public ViewHolder mo2222a(ViewGroup viewGroup, int i) {
        return this.f13523a.mo2222a(viewGroup, i);
    }

    public void mo2225a(ViewHolder viewHolder, int i) {
        this.f13523a.mo2225a(viewHolder, i);
    }

    public int getItemViewType(int i) {
        return this.f13523a.getItemViewType(i);
    }

    public final long H_(int i) {
        return this.f13523a.H_(i);
    }

    public final int aZ_() {
        return this.f13523a.aZ_();
    }

    public final boolean en_() {
        return this.f13523a.en_();
    }

    public final void mo2223a(AdapterDataObserver adapterDataObserver) {
        this.f13523a.mo2223a(adapterDataObserver);
    }

    public final void mo2227b(AdapterDataObserver adapterDataObserver) {
        this.f13523a.mo2227b(adapterDataObserver);
    }

    public void notifyDataSetChanged() {
        this.f13523a.notifyDataSetChanged();
    }

    public final void mo2642a(int i, int i2) {
        this.f13523a.mo2642a(i, i2);
    }

    public final void mo2644c(int i, int i2) {
        this.f13523a.mo2644c(i, i2);
    }

    public final void mo2645d(int i, int i2) {
        this.f13523a.mo2645d(i, i2);
    }

    public final void mo2643b(int i, int i2) {
        this.f13523a.mo2643b(i, i2);
    }

    public final void mo2640a(NotifyOnceAdapterObserver notifyOnceAdapterObserver) {
        this.f13523a.mo2640a(notifyOnceAdapterObserver);
    }

    public final void mo2641b(NotifyOnceAdapterObserver notifyOnceAdapterObserver) {
        this.f13523a.mo2641b(notifyOnceAdapterObserver);
    }
}
