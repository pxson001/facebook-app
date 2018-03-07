package com.facebook.widget.viewadapterpreallocator;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

/* compiled from: method/mobile.zeroCampaign */
public interface PreallocatingAdapter<VH extends ViewHolder> {
    int aZ_();

    VH a_(ViewGroup viewGroup, int i);

    int mo2655b();

    int getItemViewType(int i);
}
