package com.facebook.widget.listeners;

import android.support.v4.util.SimpleArrayMap;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.annotation.Nullable;

/* compiled from: ever_foregrounded */
public class BetterViewOnScrollListener implements OnScrollListener {
    public final SimpleArrayMap<OnScrollListener, Boolean> f12723a = new SimpleArrayMap();
    @Nullable
    public OnScrollListener f12724b;
    private boolean f12725c = true;

    public static BetterViewOnScrollListener m13537a(InjectorLike injectorLike) {
        return new BetterViewOnScrollListener();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.f12725c) {
            if (this.f12724b != null) {
                this.f12724b.onScrollStateChanged(absListView, i);
            }
            int size = this.f12723a.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((OnScrollListener) this.f12723a.b(i2)).onScrollStateChanged(absListView, i);
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f12725c) {
            TracerDetour.a("BetterViewOnScrollListener.onScroll", 1050069699);
            try {
                if (this.f12724b != null) {
                    this.f12724b.onScroll(absListView, i, i2, i3);
                }
                int size = this.f12723a.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((OnScrollListener) this.f12723a.b(i4)).onScroll(absListView, i, i2, i3);
                }
            } finally {
                TracerDetour.a(1945458128);
            }
        }
    }

    public final void m13539b(OnScrollListener onScrollListener) {
        this.f12723a.put(onScrollListener, Boolean.TRUE);
    }

    public final void m13538a(boolean z) {
        this.f12725c = z;
    }
}
