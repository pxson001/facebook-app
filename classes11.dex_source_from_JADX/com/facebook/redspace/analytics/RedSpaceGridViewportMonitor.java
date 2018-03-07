package com.facebook.redspace.analytics;

import android.view.View;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProfilePhotoLoad */
public class RedSpaceGridViewportMonitor implements OnScrollListener {
    private Map<String, Integer> f11760a = new HashMap();
    public final List<RedSpaceGridViewportListener> f11761b = new ArrayList();
    private final int[] f11762c = new int[2];

    public static RedSpaceGridViewportMonitor m12196a(InjectorLike injectorLike) {
        return new RedSpaceGridViewportMonitor();
    }

    public final void m12200a(ScrollingViewProxy scrollingViewProxy, int i) {
    }

    public final void m12201a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        TracerDetour.a("RedSpaceGridViewportMonitor.onScroll", -924758043);
        int i4 = 0;
        while (i4 < i2 && i < i3) {
            try {
                Object g = scrollingViewProxy.g(i);
                if (!(g == null || !(g instanceof RedSpaceFeedProfileFragmentModel) || m12197b(scrollingViewProxy, i))) {
                    RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel = (RedSpaceFeedProfileFragmentModel) g;
                    if (!(redSpaceFeedProfileFragmentModel.m() == null || redSpaceFeedProfileFragmentModel.m().m() == null || redSpaceFeedProfileFragmentModel.m().m().a() == null)) {
                        this.f11760a.put(redSpaceFeedProfileFragmentModel.k(), Integer.valueOf(redSpaceFeedProfileFragmentModel.m().m().a().a()));
                    }
                }
                i++;
                i4++;
            } catch (Throwable th) {
                TracerDetour.a(1849632216);
            }
        }
        TracerDetour.a(-2067001622);
    }

    public final void m12198a() {
        if (!this.f11760a.isEmpty()) {
            Map map = this.f11760a;
            this.f11760a = new HashMap();
            for (RedSpaceGridImpressionListener redSpaceGridImpressionListener : this.f11761b) {
                redSpaceGridImpressionListener.f11755a.a(map);
            }
        }
    }

    public final void m12199a(ScrollingViewProxy scrollingViewProxy) {
        int q = scrollingViewProxy.q();
        m12201a(scrollingViewProxy, q, (scrollingViewProxy.r() - q) + 1, scrollingViewProxy.s());
    }

    private boolean m12197b(ScrollingViewProxy scrollingViewProxy, int i) {
        if (scrollingViewProxy == null) {
            return false;
        }
        View c = scrollingViewProxy.c(i);
        if (c == null) {
            return true;
        }
        c.getLocationOnScreen(this.f11762c);
        int i2 = this.f11762c[1];
        int height = c.getHeight() + this.f11762c[1];
        int i3 = height - i2;
        scrollingViewProxy.a(this.f11762c);
        int e = this.f11762c[1] + scrollingViewProxy.e();
        i3 = (int) (((float) i3) * 0.3f);
        if (height < this.f11762c[1] + i3 || i2 > e - i3) {
            return true;
        }
        return false;
    }
}
