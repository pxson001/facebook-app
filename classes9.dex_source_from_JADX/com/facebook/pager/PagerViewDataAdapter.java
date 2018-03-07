package com.facebook.pager;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: ccu_promo_scrolling_position */
public class PagerViewDataAdapter<T> extends PagerDataSetObservable<T> {
    protected ImmutableList<T> f18411b = RegularImmutableList.a;

    public void mo715a(List<T> list) {
        this.f18411b = ImmutableList.copyOf(list);
    }

    public int mo712a() {
        return this.f18411b.size();
    }

    public T mo713a(int i) {
        return this.f18411b.get(i);
    }
}
