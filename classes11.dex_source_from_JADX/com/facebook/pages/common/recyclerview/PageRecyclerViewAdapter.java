package com.facebook.pages.common.recyclerview;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;

/* compiled from: searchNearbyPlacesAndLayoutsParams */
public class PageRecyclerViewAdapter extends Adapter {
    protected final Context f2242a;
    protected final View f2243b;
    @Nullable
    public Adapter f2244c;
    @Nullable
    protected View f2245d;
    protected final View f2246e;

    /* compiled from: searchNearbyPlacesAndLayoutsParams */
    public class SimpleViewHolder extends ViewHolder {
        public SimpleViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: searchNearbyPlacesAndLayoutsParams */
    public class ViewType {
        @IdRes
        public static final int f2239a = 2131558809;
        @IdRes
        public static final int f2240b = 2131558810;
        @IdRes
        public static final int f2241c = 2131558811;
    }

    public final ViewHolder m3195a(ViewGroup viewGroup, int i) {
        Object obj;
        if (i <= 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return this.f2244c.a(viewGroup, 0 - i);
        }
        if (i == ViewType.f2239a) {
            return new SimpleViewHolder(this.f2243b);
        }
        if (i == ViewType.f2240b) {
            return new SimpleViewHolder(this.f2245d);
        }
        if (i == ViewType.f2241c) {
            return new SimpleViewHolder(this.f2246e);
        }
        throw new IllegalStateException("Cannot create ViewHolder for itemViewType: " + i);
    }

    public PageRecyclerViewAdapter(Context context, View view, Adapter adapter, View view2, View view3) {
        this.f2242a = context;
        this.f2243b = view;
        this.f2244c = adapter;
        this.f2245d = view2;
        this.f2246e = view3;
    }

    private int m3189e(int i) {
        return i - 1;
    }

    private int m3193h() {
        return 1;
    }

    public final int aZ_() {
        return (1 + (this.f2244c != null ? this.f2244c.aZ_() : 0)) + m3192g();
    }

    private int m3190f() {
        return this.f2245d == null ? 0 : 1;
    }

    private int m3192g() {
        return m3190f() + 1;
    }

    public int getItemViewType(int i) {
        if (i < m3193h()) {
            return ViewType.f2239a;
        }
        if (i < m3194i()) {
            return 0 - this.f2244c.getItemViewType(m3189e(i));
        }
        if (i < m3194i() + m3190f()) {
            return ViewType.f2240b;
        }
        return ViewType.f2241c;
    }

    public final void m3196a(ViewHolder viewHolder, int i) {
        if (m3191f(i)) {
            this.f2244c.a(viewHolder, m3189e(i));
            return;
        }
        int itemViewType = getItemViewType(i);
        if (itemViewType != ViewType.f2239a && itemViewType != ViewType.f2240b && itemViewType != ViewType.f2241c) {
            throw new IllegalStateException("Cannot bind ViewHolder for position: " + i);
        }
    }

    private int m3194i() {
        return aZ_() - m3192g();
    }

    private boolean m3191f(int i) {
        return i >= m3193h() && i < m3194i();
    }
}
