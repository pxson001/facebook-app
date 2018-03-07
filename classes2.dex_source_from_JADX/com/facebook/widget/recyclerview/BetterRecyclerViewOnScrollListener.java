package com.facebook.widget.recyclerview;

import android.support.v4.util.SimpleArrayMap;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.lib.OncePerFrame;
import javax.inject.Inject;

/* compiled from: number */
public class BetterRecyclerViewOnScrollListener extends OnScrollListener {
    private static final short f11859a = ExperimentsForRecyclerViewModule.f11971a;
    private final SimpleArrayMap<OnScrollListener, Boolean> f11860b = new SimpleArrayMap();
    private final QeAccessor f11861c;
    private Boolean f11862d = null;
    public OnScrollListener f11863e;
    private final OncePerFrame f11864f = new OncePerFrame();

    public static BetterRecyclerViewOnScrollListener m17207b(InjectorLike injectorLike) {
        return new BetterRecyclerViewOnScrollListener(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public BetterRecyclerViewOnScrollListener(QeAccessor qeAccessor) {
        this.f11861c = qeAccessor;
    }

    public final void mo2219a(RecyclerView recyclerView, int i) {
        if (this.f11863e != null) {
            this.f11863e.mo2219a(recyclerView, i);
        }
        int size = this.f11860b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((OnScrollListener) this.f11860b.b(i2)).mo2219a(recyclerView, i);
        }
    }

    public static BetterRecyclerViewOnScrollListener m17205a(InjectorLike injectorLike) {
        return m17207b(injectorLike);
    }

    public final void mo2220a(RecyclerView recyclerView, int i, int i2) {
        if (i != 0 || i2 != 0 || recyclerView.getScrollState() == 0) {
            if (!m17206a() || !this.f11864f.m17667a()) {
                TracerDetour.a("BetterRecyclerViewOnScrollListener.onScrolled", -659118772);
                try {
                    if (this.f11863e != null) {
                        this.f11863e.mo2220a(recyclerView, i, i2);
                    }
                    int size = this.f11860b.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((OnScrollListener) this.f11860b.b(i3)).mo2220a(recyclerView, i, i2);
                    }
                } finally {
                    TracerDetour.a(-335396210);
                }
            }
        }
    }

    private boolean m17206a() {
        if (this.f11862d == null) {
            this.f11862d = Boolean.valueOf(this.f11861c.mo596a(f11859a, false));
        }
        return this.f11862d.booleanValue();
    }

    public final void m17208a(OnScrollListener onScrollListener) {
        this.f11863e = onScrollListener;
    }

    public final void m17211b(OnScrollListener onScrollListener) {
        this.f11860b.put(onScrollListener, Boolean.TRUE);
    }

    public final void m17212c(OnScrollListener onScrollListener) {
        this.f11860b.remove(onScrollListener);
    }
}
