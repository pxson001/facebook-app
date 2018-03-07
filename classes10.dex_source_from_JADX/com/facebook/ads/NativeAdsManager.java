package com.facebook.ads;

import android.content.Context;
import com.facebook.ads.NativeAd.MediaCacheFlag;
import com.facebook.ads.internal.C1920b;
import com.facebook.ads.internal.C1921c;
import com.facebook.ads.internal.C1931e;
import com.facebook.ads.internal.C1948i;
import com.facebook.ads.internal.adapters.C1910p;
import com.facebook.ads.internal.util.C1887l;
import com.facebook.ads.internal.util.C1988m;
import com.facebook.neko.util.MainActivityFragment;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class NativeAdsManager {
    public static final C1921c f13964a = C1921c.ADS;
    public final Context f13965b;
    public final String f13966c;
    public final int f13967d;
    public final List<NativeAd> f13968e;
    public int f13969f = -1;
    public MainActivityFragment f13970g;
    public C1948i f13971h;
    public boolean f13972i = false;
    public boolean f13973j = false;

    public NativeAdsManager(Context context, String str, int i) {
        this.f13965b = context;
        this.f13966c = str;
        this.f13967d = Math.max(i, 0);
        this.f13968e = new ArrayList(i);
    }

    public final void m14203a() {
        final EnumSet of = EnumSet.of(MediaCacheFlag.NONE);
        this.f13971h = new C1948i(this.f13965b, this.f13966c, C1931e.NATIVE_UNKNOWN, null, f13964a, this.f13967d, of);
        if (this.f13972i) {
            C1948i c1948i = this.f13971h;
            c1948i.f14240h = false;
            HandlerDetour.a(c1948i.f14241i, c1948i.f14242j);
        }
        this.f13971h.f14243k = new Object(this) {
            final /* synthetic */ NativeAdsManager f13963b;

            public final void m14201a(C1920b c1920b) {
                if (this.f13963b.f13970g != null) {
                    this.f13963b.f13970g.a(c1920b.m14328b());
                }
            }

            public final void m14202a(List<C1910p> list) {
                int i = 0;
                final NativeAd[] nativeAdArr = new NativeAd[list.size()];
                final int[] iArr = new int[]{0};
                while (i < list.size()) {
                    C1910p c1910p = (C1910p) list.get(i);
                    List arrayList = new ArrayList(2);
                    if (of.contains(MediaCacheFlag.ICON) && c1910p.mo720h() != null) {
                        arrayList.add(c1910p.mo720h().f13906a);
                    }
                    if (of.contains(MediaCacheFlag.IMAGE) && c1910p.mo721i() != null) {
                        arrayList.add(c1910p.mo721i().f13906a);
                    }
                    final List<C1910p> list2 = list;
                    C1988m.m14477a(this.f13963b.f13965b, arrayList, new C1887l(this) {
                        final /* synthetic */ C18891 f13961e;

                        public final void mo703a() {
                            nativeAdArr[i] = new NativeAd(this.f13961e.f13963b.f13965b, (C1910p) list2.get(i), null);
                            int[] iArr = iArr;
                            iArr[0] = iArr[0] + 1;
                            if (iArr[0] == list2.size()) {
                                this.f13961e.f13963b.f13973j = true;
                                this.f13961e.f13963b.f13968e.clear();
                                this.f13961e.f13963b.f13969f = 0;
                                for (Object obj : nativeAdArr) {
                                    if (obj != null) {
                                        this.f13961e.f13963b.f13968e.add(obj);
                                    }
                                }
                                if (this.f13961e.f13963b.f13970g != null) {
                                    this.f13961e.f13963b.f13970g.a();
                                }
                            }
                        }
                    });
                    i++;
                }
            }
        };
        this.f13971h.m14373a();
    }

    public final int m14204b() {
        return this.f13968e.size();
    }
}
