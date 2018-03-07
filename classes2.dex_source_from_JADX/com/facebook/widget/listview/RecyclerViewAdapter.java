package com.facebook.widget.listview;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.infer.annotation.NoAllocation;
import com.facebook.infer.annotation.PerformanceCritical;

/* compiled from: num_stories_to_return_for_scroll_event */
public interface RecyclerViewAdapter<VH extends ViewHolder> {
    long H_(int i);

    VH mo2222a(ViewGroup viewGroup, int i);

    void mo2642a(int i, int i2);

    void mo2223a(AdapterDataObserver adapterDataObserver);

    @NoAllocation
    @PerformanceCritical
    void mo2225a(VH vh, int i);

    int aZ_();

    void mo2643b(int i, int i2);

    void mo2227b(AdapterDataObserver adapterDataObserver);

    void mo2644c(int i, int i2);

    void mo2645d(int i, int i2);

    boolean en_();

    int getItemViewType(int i);

    void notifyDataSetChanged();
}
