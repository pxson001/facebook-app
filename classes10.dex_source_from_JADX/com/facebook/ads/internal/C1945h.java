package com.facebook.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.BannerAdapter;
import com.facebook.ads.internal.adapters.C1902f;
import com.facebook.ads.internal.adapters.C1910p;
import com.facebook.ads.internal.adapters.C1919q;
import com.facebook.ads.internal.adapters.InterstitialAdapter;
import com.facebook.ads.internal.dto.C1923a;
import com.facebook.ads.internal.dto.C1926c;
import com.facebook.ads.internal.dto.C1927d;
import com.facebook.ads.internal.dto.C1929e;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.server.C1953a.C1944a;
import com.facebook.ads.internal.server.C1957d;
import com.facebook.ads.internal.util.C1983g;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.HashMap;
import java.util.Map;

public class C1945h implements C1944a {
    private static final String f14217b = C1945h.class.getSimpleName();
    public C1890a f14218a;
    private final Context f14219c;
    public final Handler f14220d;
    public final Runnable f14221e;
    private final Runnable f14222f;
    public volatile boolean f14223g;
    public boolean f14224h;
    public volatile boolean f14225i;
    public AdAdapter f14226j;
    public View f14227k;
    public C1926c f14228l;
    public C1929e f14229m;
    private AdSize f14230n;

    class C19373 implements Runnable {
        final /* synthetic */ C1945h f14204a;

        C19373(C1945h c1945h) {
            this.f14204a = c1945h;
        }

        public void run() {
            try {
                C1945h.m14366e(this.f14204a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void m14362b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Adapter listener must be called on the main thread.");
        }
    }

    public static AdPlacementType m14364c(C1945h c1945h) {
        return c1945h.f14230n == null ? AdPlacementType.NATIVE : c1945h.f14230n == AdSize.INTERSTITIAL ? AdPlacementType.INTERSTITIAL : AdPlacementType.BANNER;
    }

    private synchronized void m14365d() {
        HandlerDetour.a(new Handler(Looper.getMainLooper()), new C19373(this), -49013128);
    }

    public static void m14366e(C1945h c1945h) {
        C1926c c1926c = c1945h.f14228l;
        C1923a c = c1926c.m14335c();
        if (c == null) {
            c1945h.f14218a.m14207a(AdErrorType.NO_FILL.getAdErrorWrapper(""));
            C1945h.m14367f(c1945h);
            return;
        }
        String str = c.f14131b;
        AdAdapter a = C1902f.m14239a(str, c1926c.f14141c.f14143a);
        if (a == null) {
            Log.e(f14217b, "Adapter does not exist: " + str);
            c1945h.m14365d();
        } else if (C1945h.m14364c(c1945h) != a.mo706a()) {
            c1945h.f14218a.m14207a(AdErrorType.INTERNAL_ERROR.getAdErrorWrapper(""));
        } else {
            Map hashMap = new HashMap();
            C1927d c1927d = c1926c.f14141c;
            hashMap.put("data", c.f14132c);
            hashMap.put("definition", c1927d);
            if (c1945h.f14229m == null) {
                c1945h.f14218a.m14207a(AdErrorType.UNKNOWN_ERROR.getAdErrorWrapper("environment is empty"));
            }
            final Runnable c19406;
            switch (a.mo706a()) {
                case INTERSTITIAL:
                    final InterstitialAdapter interstitialAdapter = (InterstitialAdapter) a;
                    c19406 = new Runnable(c1945h) {
                        final /* synthetic */ C1945h f14210b;

                        public void run() {
                            C1945h c1945h = this.f14210b;
                            AdAdapter adAdapter = interstitialAdapter;
                            if (adAdapter != null) {
                                adAdapter.mo708b();
                            }
                            this.f14210b.m14365d();
                        }
                    };
                    HandlerDetour.b(c1945h.f14220d, c19406, 10000, 507086767);
                    interstitialAdapter.mo710a(c1945h.f14219c, new Object(c1945h) {
                        public final /* synthetic */ C1945h f14212b;

                        public final void m14356a(InterstitialAdapter interstitialAdapter) {
                            C1945h c1945h = this.f14212b;
                            C1945h.m14362b();
                            HandlerDetour.a(this.f14212b.f14220d, c19406);
                            this.f14212b.f14226j = interstitialAdapter;
                            this.f14212b.f14218a.m14209c();
                            C1945h.m14367f(this.f14212b);
                        }

                        public final void m14357b(InterstitialAdapter interstitialAdapter) {
                            C1945h c1945h = this.f14212b;
                            C1945h.m14362b();
                            HandlerDetour.a(this.f14212b.f14220d, c19406);
                            c1945h = this.f14212b;
                            if (interstitialAdapter != null) {
                                interstitialAdapter.mo708b();
                            }
                            this.f14212b.m14365d();
                        }
                    }, hashMap);
                    return;
                case BANNER:
                    final BannerAdapter bannerAdapter = (BannerAdapter) a;
                    c19406 = new Runnable(c1945h) {
                        final /* synthetic */ C1945h f14206b;

                        public void run() {
                            C1945h c1945h = this.f14206b;
                            AdAdapter adAdapter = bannerAdapter;
                            if (adAdapter != null) {
                                adAdapter.mo708b();
                            }
                            this.f14206b.m14365d();
                        }
                    };
                    HandlerDetour.b(c1945h.f14220d, c19406, 10000, -1965690668);
                    bannerAdapter.mo707a(c1945h.f14219c, new Object(c1945h) {
                        public final /* synthetic */ C1945h f14208b;

                        public final void m14355b() {
                            C1945h c1945h = this.f14208b;
                            C1945h.m14362b();
                            this.f14208b.f14218a.m14206a();
                        }
                    }, hashMap);
                    return;
                case NATIVE:
                    final C1910p c1910p = (C1910p) a;
                    c19406 = new Runnable(c1945h) {
                        final /* synthetic */ C1945h f14214b;

                        public void run() {
                            C1945h c1945h = this.f14214b;
                            AdAdapter adAdapter = c1910p;
                            if (adAdapter != null) {
                                adAdapter.mo708b();
                            }
                            this.f14214b.m14365d();
                        }
                    };
                    HandlerDetour.b(c1945h.f14220d, c19406, 10000, -1839377317);
                    c1910p.mo712a(c1945h.f14219c, new C1919q(c1945h) {
                        final /* synthetic */ C1945h f14216b;

                        public final void mo735a(C1910p c1910p) {
                            C1945h c1945h = this.f14216b;
                            C1945h.m14362b();
                            HandlerDetour.a(this.f14216b.f14220d, c19406);
                            this.f14216b.f14226j = c1910p;
                            this.f14216b.f14218a.m14209c();
                        }

                        public final void mo736b(C1910p c1910p) {
                            C1945h c1945h = this.f14216b;
                            C1945h.m14362b();
                            HandlerDetour.a(this.f14216b.f14220d, c19406);
                            c1945h = this.f14216b;
                            if (c1910p != null) {
                                c1910p.mo708b();
                            }
                            this.f14216b.m14365d();
                        }
                    }, hashMap);
                    return;
                default:
                    Log.e(f14217b, "attempt unexpected adapter type");
                    return;
            }
        }
    }

    public static void m14367f(C1945h c1945h) {
        if (!c1945h.f14224h && !c1945h.f14223g) {
            switch (C1945h.m14364c(c1945h)) {
                case INTERSTITIAL:
                    if (!C1983g.m14463a(c1945h.f14219c)) {
                        HandlerDetour.b(c1945h.f14220d, c1945h.f14222f, 1000, 76147724);
                        break;
                    }
                    break;
                case BANNER:
                    int i = c1945h.f14228l == null ? 1 : c1945h.f14228l.f14141c.f14144b;
                    if (!(c1945h.f14227k == null || C1983g.m14464a(c1945h.f14219c, c1945h.f14227k, i))) {
                        HandlerDetour.b(c1945h.f14220d, c1945h.f14222f, 1000, 1248735093);
                        return;
                    }
                default:
                    return;
            }
            long b = c1945h.f14228l == null ? 30000 : c1945h.f14228l.f14141c.m14337b();
            if (b > 0) {
                HandlerDetour.b(c1945h.f14220d, c1945h.f14221e, b, -937484641);
                c1945h.f14223g = true;
            }
        }
    }

    public final C1927d m14368a() {
        return this.f14228l == null ? null : this.f14228l.f14141c;
    }

    public final synchronized void mo737a(final C1920b c1920b) {
        HandlerDetour.a(this.f14220d, new Runnable(this) {
            final /* synthetic */ C1945h f14200b;

            public void run() {
                this.f14200b.f14218a.m14207a(c1920b);
                if (!this.f14200b.f14224h && !this.f14200b.f14223g) {
                    switch (c1920b.f14107a.getErrorCode()) {
                        case 1000:
                        case 1002:
                            switch (C1945h.m14364c(this.f14200b)) {
                                case BANNER:
                                    HandlerDetour.b(this.f14200b.f14220d, this.f14200b.f14221e, 30000, 145837992);
                                    this.f14200b.f14223g = true;
                                    return;
                                default:
                                    return;
                            }
                        default:
                            return;
                    }
                }
            }
        }, -1662926809);
    }

    public final synchronized void mo738a(final C1957d c1957d) {
        HandlerDetour.a(this.f14220d, new Runnable(this) {
            final /* synthetic */ C1945h f14202b;

            public void run() {
                C1926c c1926c = c1957d.f14265a;
                if (c1926c == null || c1926c.f14141c == null) {
                    throw new IllegalStateException("invalid placement in response");
                }
                this.f14202b.f14228l = c1926c;
                this.f14202b.m14365d();
            }
        }, 689813411);
    }
}
