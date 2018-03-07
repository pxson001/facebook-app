package com.facebook.widget.bottomsheet;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.base.Preconditions;

/* compiled from: deltaBatchSize */
public class SingleItemRecyclerViewAdapter extends Adapter<ViewHolder> {
    private final View f15849a;

    /* compiled from: deltaBatchSize */
    final class SingleItemRecyclerViewHolder extends ViewHolder {
        public SingleItemRecyclerViewHolder(View view) {
            super(view);
        }
    }

    public SingleItemRecyclerViewAdapter(View view) {
        this.f15849a = (View) Preconditions.checkNotNull(view);
    }

    public final ViewHolder m19822a(ViewGroup viewGroup, int i) {
        this.f15849a.setLayoutParams(new LayoutParams(-1, viewGroup.getHeight()));
        return new SingleItemRecyclerViewHolder(this.f15849a);
    }

    public final void m19823a(ViewHolder viewHolder, int i) {
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public final int aZ_() {
        return 1;
    }
}
