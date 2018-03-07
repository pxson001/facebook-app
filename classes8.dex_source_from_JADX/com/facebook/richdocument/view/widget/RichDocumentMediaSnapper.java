package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.richdocument.RichDocumentConstants;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentMediaSnappingEvent;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: offer_view_fbid */
public class RichDocumentMediaSnapper extends OnScrollListener implements InjectableComponentWithContext {
    @Inject
    public Lazy<FbSharedPreferences> f7319a;
    @Inject
    public Lazy<MonotonicClock> f7320b;
    @Inject
    public Lazy<RichDocumentEventBus> f7321c;
    private final RecyclerView f7322d;
    public final float f7323e;
    public final float f7324f;
    public final float f7325g;
    public final float f7326h;
    private final float f7327i;
    private int f7328j = 0;
    public float f7329k;
    private long f7330l;
    private int f7331m;

    public static void m7589a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RichDocumentMediaSnapper richDocumentMediaSnapper = (RichDocumentMediaSnapper) obj;
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 3078);
        Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 601);
        Lazy a = IdBasedLazy.a(fbInjector, 10298);
        richDocumentMediaSnapper.f7319a = b;
        richDocumentMediaSnapper.f7320b = b2;
        richDocumentMediaSnapper.f7321c = a;
    }

    public RichDocumentMediaSnapper(RecyclerView recyclerView) {
        this.f7322d = recyclerView;
        Class cls = RichDocumentMediaSnapper.class;
        m7589a((Object) this, getContext());
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f7323e = m7588a(RichDocumentConstants.f5043g, RichDocumentUIConfig.f6571x);
        this.f7324f = m7588a(RichDocumentConstants.f5044h, RichDocumentUIConfig.f6572y) * f;
        this.f7325g = m7588a(RichDocumentConstants.f5041e, RichDocumentUIConfig.f6573z);
        this.f7326h = f * m7588a(RichDocumentConstants.f5042f, RichDocumentUIConfig.f6530A);
        this.f7327i = m7588a(RichDocumentConstants.f5040d, RichDocumentUIConfig.f6531B);
    }

    private float m7588a(PrefKey prefKey, float f) {
        try {
            f = Float.parseFloat(((FbSharedPreferences) this.f7319a.get()).a(prefKey, Float.toString(f)));
        } catch (NumberFormatException e) {
        }
        return f;
    }

    public Context getContext() {
        return this.f7322d.getContext();
    }

    public final void m7593a(RecyclerView recyclerView, int i) {
        this.f7330l = ((MonotonicClock) this.f7320b.get()).now();
        int i2 = this.f7328j;
        this.f7328j = i;
        if (i2 == 1 && i == 0) {
            m7595a();
        }
    }

    public final void m7594a(RecyclerView recyclerView, int i, int i2) {
        long now = ((MonotonicClock) this.f7320b.get()).now();
        long j = now - this.f7330l;
        this.f7330l = now;
        if (j != 0) {
            this.f7329k = (1000.0f * ((float) i2)) / ((float) j);
            if (this.f7328j == 2) {
                m7595a();
            }
        }
    }

    public final boolean m7595a() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f7322d.getLayoutManager();
        int l = linearLayoutManager.l();
        int v = linearLayoutManager.v() + l;
        Map hashMap = new HashMap();
        while (l <= v) {
            View c = linearLayoutManager.c(l);
            if (m7590a(c)) {
                hashMap.put(Integer.valueOf(l), c);
            }
            l++;
        }
        if (!hashMap.isEmpty()) {
            if (hashMap.containsKey(Integer.valueOf(this.f7331m))) {
                int[] iArr = new int[]{this.f7331m + 1, this.f7331m - 1};
                for (l = 0; l < 2; l++) {
                    int i = iArr[l];
                    if (hashMap.containsKey(Integer.valueOf(i)) && m7591b((View) hashMap.get(Integer.valueOf(i)))) {
                        this.f7331m = i;
                        return true;
                    }
                }
            }
            if (Math.abs(this.f7329k) <= this.f7327i) {
                for (Entry entry : hashMap.entrySet()) {
                    View view = (View) entry.getValue();
                    if (m7592c(view) && m7591b(view)) {
                        this.f7331m = ((Integer) entry.getKey()).intValue();
                        return true;
                    }
                }
            }
        }
        this.f7331m = -1;
        return false;
    }

    private static boolean m7590a(View view) {
        if (view != null && (view instanceof MediaFrame) && ((MediaFrame) view).getTransitionStrategy().mo420d() == MediaTransitionState.f6978b) {
            return true;
        }
        return false;
    }

    private boolean m7591b(View view) {
        if (view == null || !(view instanceof MediaFrame)) {
            return false;
        }
        this.f7322d.c();
        ((RichDocumentEventBus) this.f7321c.get()).a(new RichDocumentMediaSnappingEvent());
        ((MediaFrame) view).mo478a(MediaTransitionState.f6978b);
        return true;
    }

    private boolean m7592c(View view) {
        float abs = Math.abs(this.f7329k);
        if (abs > this.f7325g) {
            abs = this.f7326h;
        } else if (abs < this.f7323e) {
            abs = this.f7324f;
        } else {
            float f = (this.f7326h - this.f7324f) / (this.f7325g - this.f7323e);
            abs = (abs * f) + (this.f7324f - (this.f7323e * f));
        }
        float f2 = abs;
        int measuredHeight = this.f7322d.getMeasuredHeight();
        f2 += ((float) (measuredHeight - view.getHeight())) / 2.0f;
        int top = view.getTop();
        int bottom = view.getBottom();
        if ((top < 0 || ((float) top) > f2 || this.f7329k <= (-this.f7323e)) && (((float) bottom) < ((float) measuredHeight) - f2 || bottom > measuredHeight || this.f7329k >= this.f7323e)) {
            return false;
        }
        return true;
    }
}
