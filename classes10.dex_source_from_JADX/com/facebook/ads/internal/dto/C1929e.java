package com.facebook.ads.internal.dto;

import android.content.Context;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.C1921c;
import com.facebook.ads.internal.C1922d;
import com.facebook.ads.internal.C1931e;
import com.facebook.ads.internal.adapters.C1902f;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.C1976c;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class C1929e {
    public String f14154a;
    public AdPlacementType f14155b;
    public C1925b f14156c;
    public Context f14157d;
    public C1931e f14158e;
    public boolean f14159f;
    private C1921c f14160g;
    public int f14161h;
    public AdSize f14162i;

    public C1929e(Context context, String str, AdSize adSize, C1931e c1931e, C1921c c1921c, int i, boolean z) {
        this.f14154a = str;
        this.f14162i = adSize;
        this.f14158e = c1931e;
        this.f14156c = C1925b.m14333a(c1931e);
        this.f14160g = c1921c;
        this.f14161h = i;
        this.f14159f = z;
        this.f14157d = context;
        C1930f.m14342a(context);
        if (this.f14156c == null) {
            this.f14156c = C1925b.UNKNOWN;
        }
        switch (this.f14156c) {
            case INTERSTITIAL:
                this.f14155b = AdPlacementType.INTERSTITIAL;
                return;
            case BANNER:
                this.f14155b = AdPlacementType.BANNER;
                return;
            case NATIVE:
                this.f14155b = AdPlacementType.NATIVE;
                return;
            default:
                this.f14155b = AdPlacementType.UNKNOWN;
                return;
        }
    }

    private static void m14340a(Map<String, String> map, String str, String str2) {
        if (null != null) {
            map.put("LR_" + str, str2);
        } else {
            map.put(str, str2);
        }
    }

    public final Map<String, String> m14341e() {
        Map<String, String> hashMap = new HashMap();
        C1929e.m14340a(hashMap, "PLACEMENT_ID", this.f14154a);
        if (this.f14155b != AdPlacementType.UNKNOWN) {
            C1929e.m14340a(hashMap, "PLACEMENT_TYPE", this.f14155b.toString().toLowerCase());
        }
        Context context = this.f14157d;
        Map hashMap2 = new HashMap();
        hashMap2.put("VIEWABLE", "1");
        hashMap2.put("SCHEMA", "json");
        hashMap2.put("SDK", "android");
        hashMap2.put("SDK_VERSION", "4.7.0");
        hashMap2.put("LOCALE", Locale.getDefault().toString());
        float f = context.getResources().getDisplayMetrics().density;
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        hashMap2.put("DENSITY", String.valueOf(f));
        hashMap2.put("SCREEN_WIDTH", String.valueOf((int) (((float) i) / f)));
        hashMap2.put("SCREEN_HEIGHT", String.valueOf((int) (((float) i2) / f)));
        hashMap2.put("IDFA", C1930f.f14176n);
        hashMap2.put("IDFA_FLAG", C1930f.f14177o ? "0" : "1");
        hashMap2.put("ATTRIBUTION_ID", C1930f.f14175m);
        hashMap2.put("OS", "Android");
        hashMap2.put("OSVERS", C1930f.f14163a);
        hashMap2.put("BUNDLE", C1930f.f14166d);
        hashMap2.put("APPNAME", C1930f.f14167e);
        hashMap2.put("APPVERS", C1930f.f14168f);
        hashMap2.put("APPBUILD", String.valueOf(C1930f.f14169g));
        hashMap2.put("CARRIER", C1930f.f14170h);
        hashMap2.put("MAKE", C1930f.f14164b);
        hashMap2.put("MODEL", C1930f.f14165c);
        hashMap2.put("COPPA", String.valueOf(AdSettings.f13895f));
        hashMap2.put("SDK_CAPABILITY", C1922d.m14330b());
        for (Entry entry : hashMap2.entrySet()) {
            C1929e.m14340a(hashMap, (String) entry.getKey(), (String) entry.getValue());
        }
        if (this.f14162i != null) {
            C1929e.m14340a(hashMap, "WIDTH", String.valueOf(this.f14162i.getWidth()));
            C1929e.m14340a(hashMap, "HEIGHT", String.valueOf(this.f14162i.getHeight()));
        }
        C1929e.m14340a(hashMap, "ADAPTERS", C1902f.m14240a(this.f14155b));
        if (this.f14158e != null) {
            C1929e.m14340a(hashMap, "TEMPLATE_ID", String.valueOf(this.f14158e.m14346a()));
        }
        if (this.f14160g != null) {
            C1929e.m14340a(hashMap, "REQUEST_TYPE", String.valueOf(this.f14160g.m14329a()));
        }
        if (this.f14159f) {
            C1929e.m14340a(hashMap, "TEST_MODE", "1");
        }
        if (this.f14161h != 0) {
            C1929e.m14340a(hashMap, "NUM_ADS_REQUESTED", String.valueOf(this.f14161h));
        }
        C1929e.m14340a(hashMap, "CLIENT_EVENTS", C1976c.m14445a());
        return hashMap;
    }
}
