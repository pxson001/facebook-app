package com.facebook.feed.rows.adapter;

import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.feed.rows.adapter.api.HasMarkers.Marker;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.RowIdentifier;
import com.facebook.widget.listview.ListViewAdapterWrapper;

/* compiled from: nectar_module */
public class MultiRowListViewAdapterWrapper extends ListViewAdapterWrapper<ViewHolder> implements MultiRowAdapter {
    private final MultiRowRecyclerViewAdapter f12924a;

    public MultiRowListViewAdapterWrapper(MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter) {
        super(multiRowRecyclerViewAdapter);
        this.f12924a = multiRowRecyclerViewAdapter;
    }

    public final int mo2510c(int i) {
        return this.f12924a.mo2510c(i);
    }

    public final int mo2511d(int i) {
        return this.f12924a.mo2511d(i);
    }

    public final int s_(int i) {
        return this.f12924a.s_(i);
    }

    public final int t_(int i) {
        return this.f12924a.t_(i);
    }

    public final int mo2514g(int i) {
        return this.f12924a.mo2514g(i);
    }

    public final int mo2512e() {
        return this.f12924a.mo2512e();
    }

    public final int mo2515h(int i) {
        return this.f12924a.mo2515h(i);
    }

    public final RowIdentifier mo2513f() {
        return this.f12924a.mo2513f();
    }

    public final void mo2508a(Configuration configuration) {
        this.f12924a.mo2508a(configuration);
    }

    public final void jc_() {
        this.f12924a.jc_();
    }

    public final boolean ba_() {
        return this.f12924a.ba_();
    }

    public final void mo1888a(DumpsysContext dumpsysContext) {
        this.f12924a.mo1888a(dumpsysContext);
    }

    public final Marker mo2509b(int i) {
        return this.f12924a.mo2509b(i);
    }
}
