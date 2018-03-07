package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.C1890a;
import com.facebook.ads.internal.C1945h;
import com.facebook.ads.internal.C1945h.C19395;
import com.facebook.ads.internal.action.C1891a;
import com.facebook.ads.internal.action.C1892b;
import com.facebook.ads.internal.dto.C1927d;
import com.facebook.ads.internal.util.C1975b.C1974a;
import com.facebook.ads.internal.util.C1980f;
import com.facebook.ads.internal.util.C1984h;
import com.facebook.ads.internal.view.C1999a;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class C1907i extends BannerAdapter {
    public static final String f14019a = C1907i.class.getSimpleName();
    public C1999a f14020b;
    public C1914m f14021c;
    public C19395 f14022d;
    public Map<String, Object> f14023e;
    private C1911k f14024f;
    public Context f14025g;
    public long f14026h;
    public C1974a f14027i;

    public class C19062 extends C1885c {
        final /* synthetic */ C1907i f14018a;

        public C19062(C1907i c1907i) {
            this.f14018a = c1907i;
        }

        public final void mo701a() {
            if (this.f14018a.f14022d != null) {
                C19395 c19395 = this.f14018a.f14022d;
                C1945h c1945h = c19395.f14208b;
                C1945h.m14362b();
                c19395.f14208b.f14218a.m14208b();
            }
        }
    }

    public final void mo707a(Context context, BannerAdapterListener bannerAdapterListener, Map<String, Object> map) {
        this.f14025g = context;
        this.f14022d = bannerAdapterListener;
        this.f14023e = map;
        C1927d c1927d = (C1927d) map.get("definition");
        this.f14026h = 0;
        this.f14027i = null;
        final C1895a a = C1912l.m14296a((JSONObject) this.f14023e.get("data"));
        if (C1980f.m14454a(this.f14025g, a)) {
            C19395 c19395 = this.f14022d;
            AdError adError = AdError.f13883b;
            C1945h c1945h = c19395.f14208b;
            C1945h.m14362b();
            HandlerDetour.a(c19395.f14208b.f14220d, c19395.f14207a);
            c1945h = c19395.f14208b;
            if (this != null) {
                mo708b();
            }
            c19395.f14208b.m14365d();
            return;
        }
        this.f14020b = new C1999a(this.f14025g, new Object(this) {
            public final /* synthetic */ C1907i f14017b;

            public final void m14243a(String str) {
                if (this.f14017b.f14022d != null) {
                    this.f14017b.f14022d.m14355b();
                }
                C1891a a = C1892b.m14213a(this.f14017b.f14025g, Uri.parse(str));
                if (a != null) {
                    try {
                        this.f14017b.f14027i = a.mo704a();
                        this.f14017b.f14026h = System.currentTimeMillis();
                        a.mo705b();
                    } catch (Throwable e) {
                        Log.e(C1907i.f14019a, "Error executing action", e);
                    }
                }
            }
        }, c1927d.f14144b);
        C1999a c1999a = this.f14020b;
        int i = c1927d.f14148f;
        int i2 = c1927d.f14149g;
        c1999a.f14375b.f13992a = i;
        c1999a.f14375b.f13993b = i2;
        this.f14021c = new C1914m(this.f14025g, this.f14020b, new C19062(this));
        this.f14021c.f14055d = a;
        this.f14020b.loadDataWithBaseURL(C1984h.m14467a(), a.f14042a, "text/html", "utf-8", null);
        if (this.f14022d != null) {
            c19395 = this.f14022d;
            View view = this.f14020b;
            c1945h = c19395.f14208b;
            C1945h.m14362b();
            HandlerDetour.a(c19395.f14208b.f14220d, c19395.f14207a);
            AdAdapter adAdapter = c19395.f14208b.f14226j;
            c19395.f14208b.f14226j = this;
            c19395.f14208b.f14227k = view;
            if (c19395.f14208b.f14225i) {
                C1890a c1890a = c19395.f14208b.f14218a;
                C1945h c1945h2 = c19395.f14208b;
                if (adAdapter != null) {
                    adAdapter.mo708b();
                }
                C1945h.m14367f(c19395.f14208b);
            } else {
                c19395.f14208b.f14218a.m14209c();
            }
        }
    }

    public final void mo708b() {
        if (this.f14020b != null) {
            C1984h.m14471a(this.f14020b);
            this.f14020b.destroy();
            this.f14020b = null;
        }
        if (this.f14024f != null) {
            this.f14024f.mo708b();
            this.f14024f = null;
        }
    }

    public final void mo709c() {
        if (this.f14021c != null) {
            this.f14021c.m14232a();
        } else if (this.f14024f != null) {
            Map hashMap = new HashMap();
            hashMap.put("mil", Boolean.valueOf(false));
            this.f14024f.mo713a(hashMap);
        }
    }
}
