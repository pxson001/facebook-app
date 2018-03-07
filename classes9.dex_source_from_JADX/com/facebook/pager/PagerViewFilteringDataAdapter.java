package com.facebook.pager;

import com.facebook.pager.PagerViewController.C21281;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: ccu_promo_card_position */
public class PagerViewFilteringDataAdapter<T> extends PagerViewDataAdapter<T> {
    private final PagerViewDataAdapter<T> f18412c;
    public final ArrayList<Integer> f18413d = Lists.a();
    private int f18414e = 0;

    PagerViewFilteringDataAdapter(PagerViewDataAdapter<T> pagerViewDataAdapter) {
        this.f18412c = pagerViewDataAdapter;
        m18393c();
    }

    public final void m18399b(int i) {
        m18392b();
        this.f18414e++;
        for (int i2 = 0; i2 < this.f18412c.mo712a() - this.f18414e; i2++) {
            if (((Integer) this.f18413d.get(i2)).intValue() + i2 >= i) {
                this.f18413d.set(i2, Integer.valueOf(((Integer) this.f18413d.get(i2)).intValue() + 1));
            }
        }
    }

    public final void mo715a(List<T> list) {
        this.f18412c.mo715a((List) list);
    }

    public final int mo712a() {
        return this.f18412c.mo712a() - this.f18414e;
    }

    public final T mo713a(int i) {
        m18392b();
        return this.f18412c.mo713a(((Integer) this.f18413d.get(i)).intValue() + i);
    }

    public final void mo714a(C21281 c21281) {
        this.f18412c.mo714a(c21281);
    }

    public final boolean mo716b(C21281 c21281) {
        return this.f18412c.mo716b(c21281);
    }

    private void m18392b() {
        if (this.f18412c.mo712a() > this.f18413d.size()) {
            m18394d(this.f18412c.mo712a());
        }
    }

    private void m18393c() {
        this.f18413d.clear();
        m18394d(this.f18412c.mo712a());
        this.f18414e = 0;
    }

    private void m18394d(int i) {
        int i2 = 0;
        int size = i - this.f18413d.size();
        Integer valueOf = Integer.valueOf(this.f18413d.isEmpty() ? 0 : ((Integer) this.f18413d.get(this.f18413d.size() - 1)).intValue());
        while (i2 < size) {
            this.f18413d.add(valueOf);
            i2++;
        }
    }
}
