package com.facebook.widget.listview;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* compiled from: nearbyfriends_self_view */
public class ListViewAdapterWrapper<VH extends ViewHolder> extends BaseAdapter implements FbListAdapter {
    private final AdapterDataObserver f12925a = new C05391(this);
    private final AdapterCompatibleWithListView<VH> f12926b;

    /* compiled from: nearbyfriends_self_view */
    class C05391 extends AdapterDataObserver {
        final /* synthetic */ ListViewAdapterWrapper f13525a;

        C05391(ListViewAdapterWrapper listViewAdapterWrapper) {
            this.f13525a = listViewAdapterWrapper;
        }

        public final void bb_() {
            super.notifyDataSetChanged();
        }

        public final void mo2217a(int i, int i2) {
            super.notifyDataSetChanged();
        }

        public final void mo2210b(int i, int i2) {
            super.notifyDataSetChanged();
        }

        public final void mo2212c(int i, int i2) {
            super.notifyDataSetChanged();
        }

        public final void mo2218a(int i, int i2, int i3) {
            super.notifyDataSetChanged();
        }
    }

    public ListViewAdapterWrapper(AdapterCompatibleWithListView<VH> adapterCompatibleWithListView) {
        this.f12926b = adapterCompatibleWithListView;
        this.f12926b.mo2223a(this.f12925a);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View a = view != null ? view : mo1985a(getItemViewType(i), viewGroup);
        mo1986a(i, getItem(i), a, getItemViewType(i), viewGroup);
        return a;
    }

    public final View mo1985a(int i, ViewGroup viewGroup) {
        ViewHolder a = this.f12926b.mo2222a(viewGroup, i);
        View view = a.f14095a;
        view.setTag(2131558447, a);
        return view;
    }

    public final void mo1986a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        this.f12926b.mo2225a((ViewHolder) view.getTag(2131558447), i);
    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public boolean isEnabled(int i) {
        return true;
    }

    public int getCount() {
        return this.f12926b.aZ_();
    }

    public Object getItem(int i) {
        return this.f12926b.getItem(i);
    }

    public long getItemId(int i) {
        return this.f12926b.H_(i);
    }

    public boolean hasStableIds() {
        return this.f12926b.en_();
    }

    public int getItemViewType(int i) {
        return this.f12926b.getItemViewType(i);
    }

    public int getViewTypeCount() {
        return this.f12926b.iy_();
    }

    public void notifyDataSetChanged() {
        this.f12926b.notifyDataSetChanged();
    }
}
