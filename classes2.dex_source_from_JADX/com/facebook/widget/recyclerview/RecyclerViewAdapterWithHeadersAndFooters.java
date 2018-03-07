package com.facebook.widget.recyclerview;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: num_waiting */
public class RecyclerViewAdapterWithHeadersAndFooters<VH extends ViewHolder> extends Adapter<WrappingViewHolder> implements AdapterCompatibleWithListView<WrappingViewHolder> {
    public final AdapterCompatibleWithListView<VH> f11867a;
    public List<View> f11868b;
    public List<View> f11869c;
    private boolean f11870d;
    private final AdapterDataObserver f11871e = new C05591(this);

    /* compiled from: num_waiting */
    class C05591 extends AdapterDataObserver {
        final /* synthetic */ RecyclerViewAdapterWithHeadersAndFooters f13677a;

        C05591(RecyclerViewAdapterWithHeadersAndFooters recyclerViewAdapterWithHeadersAndFooters) {
            this.f13677a = recyclerViewAdapterWithHeadersAndFooters;
        }

        public final void bb_() {
            this.f13677a.notifyDataSetChanged();
        }

        public final void mo2217a(int i, int i2) {
            this.f13677a.m17217a(this.f13677a.f11868b.size() + i, i2);
        }

        public final void mo2210b(int i, int i2) {
            this.f13677a.m17228c(this.f13677a.f11868b.size() + i, i2);
        }

        public final void mo2212c(int i, int i2) {
            this.f13677a.m17230d(this.f13677a.f11868b.size() + i, i2);
        }

        public final void mo2218a(int i, int i2, int i3) {
            this.f13677a.m17223b(this.f13677a.f11868b.size() + i, i2);
        }
    }

    /* compiled from: num_waiting */
    public class WrappingViewHolder<VH extends ViewHolder> extends ViewHolder {
        public final VH f14093l;

        public WrappingViewHolder(VH vh) {
            super(vh.f14095a);
            this.f14093l = vh;
        }

        public WrappingViewHolder(View view) {
            super(view);
            this.f14093l = null;
        }
    }

    public final void mo2224a(ViewHolder viewHolder) {
        WrappingViewHolder wrappingViewHolder = (WrappingViewHolder) viewHolder;
        if (this.f11867a instanceof Adapter) {
            ((Adapter) this.f11867a).mo2224a(wrappingViewHolder.f14093l);
        }
    }

    public final void mo2225a(ViewHolder viewHolder, int i) {
        WrappingViewHolder wrappingViewHolder = (WrappingViewHolder) viewHolder;
        int size = i - this.f11868b.size();
        if (size >= 0 && size < this.f11867a.aZ_()) {
            this.f11867a.mo2225a(wrappingViewHolder.f14093l, size);
        }
    }

    public final boolean mo2228b(ViewHolder viewHolder) {
        viewHolder = (WrappingViewHolder) viewHolder;
        if (this.f11867a instanceof Adapter) {
            return ((Adapter) this.f11867a).mo2228b(viewHolder.f14093l);
        }
        return super.mo2228b(viewHolder);
    }

    public final void mo2229c(ViewHolder viewHolder) {
        WrappingViewHolder wrappingViewHolder = (WrappingViewHolder) viewHolder;
        if (this.f11867a instanceof Adapter) {
            ((Adapter) this.f11867a).mo2229c(wrappingViewHolder.f14093l);
        }
    }

    public final void mo2230d(ViewHolder viewHolder) {
        WrappingViewHolder wrappingViewHolder = (WrappingViewHolder) viewHolder;
        if (this.f11867a instanceof Adapter) {
            ((Adapter) this.f11867a).mo2230d(wrappingViewHolder.f14093l);
        }
    }

    public RecyclerViewAdapterWithHeadersAndFooters(AdapterCompatibleWithListView<VH> adapterCompatibleWithListView) {
        this.f11867a = adapterCompatibleWithListView;
        this.f11868b = Collections.emptyList();
        this.f11869c = Collections.emptyList();
        m17221a(this.f11867a.en_());
    }

    public final void m17238a(ArrayList<View> arrayList) {
        if (arrayList == null) {
            this.f11868b = Collections.emptyList();
        } else {
            this.f11868b = arrayList;
        }
        notifyDataSetChanged();
    }

    public final void m17240b(ArrayList<View> arrayList) {
        if (arrayList == null) {
            this.f11869c = Collections.emptyList();
        } else {
            this.f11869c = arrayList;
        }
        notifyDataSetChanged();
    }

    public final void mo2223a(AdapterDataObserver adapterDataObserver) {
        super.mo2223a(adapterDataObserver);
        if (!this.f11870d) {
            this.f11867a.mo2223a(this.f11871e);
            this.f11870d = true;
        }
    }

    public final void mo2227b(AdapterDataObserver adapterDataObserver) {
        super.mo2227b(adapterDataObserver);
        if (this.f11870d && !iz_()) {
            this.f11867a.mo2227b(this.f11871e);
            this.f11870d = false;
        }
    }

    public int getItemViewType(int i) {
        int size = this.f11868b.size();
        int aZ_ = this.f11867a.aZ_();
        if (i < size) {
            return m17232f(i);
        }
        size = i - size;
        if (size >= aZ_) {
            return m17233g(i);
        }
        return this.f11867a.getItemViewType(size);
    }

    public final ViewHolder mo2222a(ViewGroup viewGroup, int i) {
        if (i >= 0) {
            return new WrappingViewHolder(this.f11867a.mo2222a(viewGroup, i));
        }
        View view;
        if (i % 2 == 0) {
            view = (View) this.f11869c.get(((-i) / 2) - 1);
        } else {
            view = (View) this.f11868b.get(-((i + 1) / 2));
        }
        return new WrappingViewHolder(view);
    }

    public final int aZ_() {
        return (this.f11868b.size() + this.f11867a.aZ_()) + this.f11869c.size();
    }

    public final int iy_() {
        throw new UnsupportedOperationException("RecyclerView shouldn't be calling this method");
    }

    public Object getItem(int i) {
        int size = this.f11868b.size();
        if (i < size || i >= this.f11867a.aZ_() + size) {
            return null;
        }
        return this.f11867a.getItem(i - size);
    }

    public final long H_(int i) {
        int size = this.f11868b.size();
        int aZ_ = this.f11867a.aZ_();
        if (i < size) {
            return (long) m17232f(i);
        }
        size = i - size;
        if (size >= aZ_) {
            return (long) m17233g(i);
        }
        return this.f11867a.H_(size);
    }

    private static int m17232f(int i) {
        return -1 - (i * 2);
    }

    private int m17233g(int i) {
        return (((i - this.f11867a.aZ_()) - this.f11868b.size()) + 1) * -2;
    }
}
