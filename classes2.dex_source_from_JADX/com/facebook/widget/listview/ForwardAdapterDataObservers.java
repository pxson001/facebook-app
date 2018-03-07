package com.facebook.widget.listview;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import java.util.ArrayList;
import java.util.List;

/* compiled from: min_newsfeed_db_size */
public class ForwardAdapterDataObservers extends AdapterDataObserver {
    private final List<AdapterDataObserver> f13495a = new ArrayList();
    private boolean f13496b;

    public final void bb_() {
        this.f13496b = true;
        for (int i = 0; i < this.f13495a.size(); i++) {
            ((AdapterDataObserver) this.f13495a.get(i)).bb_();
        }
        this.f13496b = false;
    }

    public final void mo2217a(int i, int i2) {
        this.f13496b = true;
        for (int i3 = 0; i3 < this.f13495a.size(); i3++) {
            ((AdapterDataObserver) this.f13495a.get(i3)).mo2217a(i, i2);
        }
        this.f13496b = false;
    }

    public final void mo2210b(int i, int i2) {
        this.f13496b = true;
        for (int i3 = 0; i3 < this.f13495a.size(); i3++) {
            ((AdapterDataObserver) this.f13495a.get(i3)).mo2210b(i, i2);
        }
        this.f13496b = false;
    }

    public final void mo2212c(int i, int i2) {
        this.f13496b = true;
        for (int i3 = 0; i3 < this.f13495a.size(); i3++) {
            ((AdapterDataObserver) this.f13495a.get(i3)).mo2212c(i, i2);
        }
        this.f13496b = false;
    }

    public final void mo2218a(int i, int i2, int i3) {
        this.f13496b = true;
        for (int i4 = 0; i4 < this.f13495a.size(); i4++) {
            ((AdapterDataObserver) this.f13495a.get(i4)).mo2218a(i, i2, 1);
        }
        this.f13496b = false;
    }

    public final void m19854a(AdapterDataObserver adapterDataObserver) {
        if (this.f13496b) {
            throw new IllegalStateException("Can't register observer during notify*()");
        }
        this.f13495a.add(adapterDataObserver);
    }

    public final void m19856b(AdapterDataObserver adapterDataObserver) {
        if (this.f13496b) {
            throw new IllegalStateException("Can't unregister observer during notify*()");
        }
        this.f13495a.remove(adapterDataObserver);
    }
}
