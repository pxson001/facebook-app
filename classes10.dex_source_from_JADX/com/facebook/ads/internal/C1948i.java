package com.facebook.ads.internal;

import android.content.Context;
import android.os.Handler;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.NativeAd.MediaCacheFlag;
import com.facebook.ads.NativeAdsManager.C18891;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.C1902f;
import com.facebook.ads.internal.adapters.C1910p;
import com.facebook.ads.internal.adapters.C1919q;
import com.facebook.ads.internal.dto.C1923a;
import com.facebook.ads.internal.dto.C1926c;
import com.facebook.ads.internal.dto.C1929e;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.server.C1953a;
import com.facebook.ads.internal.server.C1953a.C1944a;
import com.facebook.ads.internal.server.C1957d;
import com.facebook.ads.internal.util.C1898t;
import com.facebook.ads.internal.util.C1983g;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C1948i implements C1944a {
    public final Context f14233a;
    private final String f14234b;
    private final C1953a f14235c = new C1953a();
    private final C1931e f14236d;
    private final C1921c f14237e;
    private final AdSize f14238f;
    private final int f14239g;
    public boolean f14240h = true;
    public final Handler f14241i = new Handler();
    public final Runnable f14242j = new C1947b(this);
    public C18891 f14243k;
    public C1926c f14244l;

    final class C1947b extends C1898t<C1948i> {
        public C1947b(C1948i c1948i) {
            super(c1948i);
        }

        public final void run() {
            C1948i c1948i = (C1948i) m14235a();
            if (c1948i != null) {
                if (C1983g.m14463a(c1948i.f14233a)) {
                    c1948i.m14373a();
                } else {
                    HandlerDetour.b(c1948i.f14241i, c1948i.f14242j, 5000, 879689862);
                }
            }
        }
    }

    public C1948i(Context context, String str, C1931e c1931e, AdSize adSize, C1921c c1921c, int i, EnumSet<MediaCacheFlag> enumSet) {
        this.f14233a = context;
        this.f14234b = str;
        this.f14236d = c1931e;
        this.f14238f = adSize;
        this.f14237e = c1921c;
        this.f14239g = i;
    }

    public final void m14373a() {
        this.f14235c.m14388a(this.f14233a, new C1929e(this.f14233a, this.f14234b, this.f14238f, this.f14236d, this.f14237e, this.f14239g, AdSettings.m14170a(this.f14233a)));
    }

    public final void mo737a(C1920b c1920b) {
        if (this.f14240h) {
            HandlerDetour.b(this.f14241i, this.f14242j, 1800000, 423058234);
        }
        if (this.f14243k != null) {
            this.f14243k.m14201a(c1920b);
        }
    }

    public final void mo738a(C1957d c1957d) {
        C1926c c1926c = c1957d.f14265a;
        if (c1926c == null) {
            throw new IllegalStateException("no placement in response");
        }
        if (this.f14240h) {
            long b = c1926c.f14141c.m14337b();
            if (b == 0) {
                b = 1800000;
            }
            HandlerDetour.b(this.f14241i, this.f14242j, b, -788164114);
        }
        this.f14244l = c1926c;
        C1926c c1926c2 = this.f14244l;
        C1923a c = c1926c2.m14335c();
        final List arrayList = new ArrayList(c1926c2.f14139a.size());
        for (C1923a c1923a = c; c1923a != null; c1923a = c1926c2.m14335c()) {
            AdAdapter a = C1902f.m14239a(c1923a.f14131b, AdPlacementType.NATIVE);
            if (a != null && a.mo706a() == AdPlacementType.NATIVE) {
                Map hashMap = new HashMap();
                hashMap.put("data", c1923a.f14132c);
                hashMap.put("definition", c1926c2.f14141c);
                ((C1910p) a).mo712a(this.f14233a, new C1919q(this) {
                    final /* synthetic */ C1948i f14232b;

                    public final void mo735a(C1910p c1910p) {
                        arrayList.add(c1910p);
                    }

                    public final void mo736b(C1910p c1910p) {
                    }
                }, hashMap);
            }
        }
        List list = arrayList;
        if (this.f14243k == null) {
            return;
        }
        if (list.isEmpty()) {
            this.f14243k.m14201a(AdErrorType.NO_FILL.getAdErrorWrapper(""));
        } else {
            this.f14243k.m14202a(list);
        }
    }
}
