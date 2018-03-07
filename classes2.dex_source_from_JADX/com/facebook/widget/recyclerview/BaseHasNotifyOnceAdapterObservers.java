package com.facebook.widget.recyclerview;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.List;

/* compiled from: min_impression_delay_ms */
public class BaseHasNotifyOnceAdapterObservers extends AdapterDataObserver implements HasNotifyOnceAdapterObservers, Runnable {
    private final Handler f13497a = new Handler(Looper.getMainLooper());
    private final List<NotifyOnceAdapterObserver> f13498b = new ArrayList();
    private boolean f13499c;
    private boolean f13500d;
    private boolean f13501e;

    public final void mo2640a(NotifyOnceAdapterObserver notifyOnceAdapterObserver) {
        if (this.f13499c) {
            throw new IllegalStateException("Can't register observer during onChanged()");
        } else if (notifyOnceAdapterObserver != null) {
            this.f13498b.add(notifyOnceAdapterObserver);
        }
    }

    public final void mo2641b(NotifyOnceAdapterObserver notifyOnceAdapterObserver) {
        if (this.f13499c) {
            throw new IllegalStateException("Can't unregister observer during onChanged()");
        } else if (notifyOnceAdapterObserver != null) {
            this.f13498b.remove(notifyOnceAdapterObserver);
        }
    }

    public final void bb_() {
        m19858b();
    }

    public final void mo2217a(int i, int i2) {
        m19858b();
    }

    public final void mo2210b(int i, int i2) {
        m19858b();
    }

    public final void mo2212c(int i, int i2) {
        m19858b();
    }

    public final void mo2218a(int i, int i2, int i3) {
        m19858b();
    }

    public final void jc_() {
        this.f13501e = true;
    }

    public final boolean ba_() {
        return this.f13501e;
    }

    private void m19858b() {
        if (!this.f13500d && !this.f13501e) {
            HandlerDetour.b(this.f13497a, this, -1388442702);
            this.f13500d = true;
        }
    }

    public void run() {
        if (!this.f13501e) {
            this.f13499c = true;
            for (int i = 0; i < this.f13498b.size(); i++) {
                ((NotifyOnceAdapterObserver) this.f13498b.get(i)).mo2132a();
            }
            this.f13499c = false;
            this.f13500d = false;
        }
    }
}
