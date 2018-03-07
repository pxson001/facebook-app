package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.facebook.ads.NativeAd.Image;
import com.facebook.ads.NativeAd.Rating;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.action.C1891a;
import com.facebook.ads.internal.action.C1892b;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.util.C1975b.C1974a;
import com.facebook.ads.internal.util.C1979e;
import com.facebook.ads.internal.util.C1980f;
import com.facebook.ads.internal.util.C1983g;
import com.facebook.ads.internal.util.C1991o;
import com.facebook.ads.internal.util.C1994r;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1917n implements C1895a {
    private static final String f14061a = C1917n.class.getSimpleName();
    public final String f14062A;
    private final Image f14063B;
    private final String f14064C;
    public final String f14065D;
    private final C1916a f14066E;
    public final AdExtras f14067F;
    private final NativeAdViewAttributes f14068G;
    public final String f14069H;
    private boolean f14070I;
    private boolean f14071J;
    private boolean f14072K;
    public long f14073L = 0;
    public C1974a f14074M = null;
    private final Uri f14075b;
    private final String f14076c;
    private final String f14077d;
    private final String f14078e;
    private final String f14079f;
    private final String f14080g;
    public final Image f14081h;
    public final Image f14082i;
    private final Rating f14083j;
    private final String f14084k;
    public final String f14085l;
    private final String f14086m;
    private final String f14087n;
    private final C1979e f14088o;
    private final String f14089p;
    private final Collection<String> f14090q;
    private final boolean f14091r;
    public final boolean f14092s;
    public final boolean f14093t;
    private final int f14094u;
    public final int f14095v;
    public final int f14096w;
    public final int f14097x;
    public final String f14098y;
    public final String f14099z;

    class C1916a {
        Map<String, List<String>> f14060a = new HashMap();

        C1916a(JSONArray jSONArray) {
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("type");
                    if (!C1994r.m14486a(optString)) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("urls");
                        if (optJSONArray != null) {
                            List arrayList = new ArrayList(optJSONArray.length());
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                arrayList.add(optJSONArray.optString(i2));
                            }
                            this.f14060a.put(optString, arrayList);
                        }
                    }
                }
            }
        }

        final void m14303a(String str) {
            List<String> list = (List) this.f14060a.get(str);
            if (list != null && !list.isEmpty()) {
                for (String str2 : list) {
                    new C1991o().execute(new String[]{str2});
                }
            }
        }
    }

    private C1917n(Uri uri, String str, String str2, String str3, String str4, String str5, Image image, Image image2, Rating rating, String str6, String str7, String str8, C1979e c1979e, String str9, Collection<String> collection, boolean z, Image image3, String str10, String str11, C1916a c1916a, String str12, boolean z2, boolean z3, int i, int i2, String str13, String str14, String str15, int i3, int i4, AdExtras adExtras, NativeAdViewAttributes nativeAdViewAttributes) {
        this.f14075b = uri;
        this.f14076c = str;
        this.f14077d = str2;
        this.f14078e = str3;
        this.f14079f = str4;
        this.f14080g = str5;
        this.f14081h = image;
        this.f14082i = image2;
        this.f14083j = rating;
        this.f14084k = str6;
        this.f14086m = str7;
        this.f14087n = str8;
        this.f14088o = c1979e;
        this.f14089p = str9;
        this.f14090q = collection;
        this.f14091r = z;
        this.f14092s = z2;
        this.f14093t = z3;
        this.f14063B = image3;
        this.f14064C = str10;
        this.f14065D = str11;
        this.f14066E = c1916a;
        this.f14085l = str12;
        this.f14094u = i;
        this.f14095v = i2;
        this.f14096w = i3;
        this.f14097x = i4;
        this.f14098y = str13;
        this.f14099z = str14;
        this.f14062A = str15;
        this.f14067F = adExtras;
        this.f14068G = nativeAdViewAttributes;
        this.f14069H = UUID.randomUUID().toString();
    }

    public static C1917n m14304a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        NativeAdViewAttributes nativeAdViewAttributes;
        JSONArray jSONArray;
        Uri parse = Uri.parse(jSONObject.optString("fbad_command"));
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("subtitle");
        String optString3 = jSONObject.optString("body");
        String optString4 = jSONObject.optString("call_to_action");
        String optString5 = jSONObject.optString("social_context");
        Image a = Image.m14175a(jSONObject.optJSONObject("icon"));
        Image a2 = Image.m14175a(jSONObject.optJSONObject("image"));
        Rating a3 = Rating.m14177a(jSONObject.optJSONObject("star_rating"));
        String optString6 = jSONObject.optString("impression_report_url");
        String optString7 = jSONObject.optString("native_view_report_url");
        String optString8 = jSONObject.optString("click_report_url");
        AdExtras a4 = new AdExtras().m14347a(jSONObject.optBoolean("is_organic", false));
        String optString9 = jSONObject.optString("used_report_url");
        boolean optBoolean = jSONObject.optBoolean("manual_imp");
        boolean optBoolean2 = jSONObject.optBoolean("enable_view_log");
        boolean optBoolean3 = jSONObject.optBoolean("enable_snapshot_log");
        int optInt = jSONObject.optInt("snapshot_log_delay_second", 4);
        int optInt2 = jSONObject.optInt("snapshot_compress_quality", 0);
        int optInt3 = jSONObject.optInt("viewability_check_initial_delay", 0);
        int optInt4 = jSONObject.optInt("viewability_check_interval", 1000);
        Image image = null;
        JSONObject optJSONObject = jSONObject.optJSONObject("ad_choices_icon");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("native_ui_config");
        if (optJSONObject2 == null) {
            nativeAdViewAttributes = null;
        } else {
            NativeAdViewAttributes nativeAdViewAttributes2 = new NativeAdViewAttributes(optJSONObject2);
        }
        if (optJSONObject != null) {
            image = Image.m14175a(optJSONObject);
        }
        String optString10 = jSONObject.optString("ad_choices_link_url");
        String optString11 = jSONObject.optString("request_id");
        C1979e a5 = C1979e.m14452a(jSONObject.optString("invalidation_behavior"));
        String optString12 = jSONObject.optString("invalidation_report_url");
        try {
            jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        C1917n c1917n = new C1917n(parse, optString, optString2, optString3, optString4, optString5, a, a2, a3, optString6, optString8, optString9, a5, optString12, C1980f.m14453a(jSONArray), optBoolean, image, optString10, optString11, new C1916a(jSONObject.optJSONArray("trackers")), optString7, optBoolean2, optBoolean3, optInt, optInt2, jSONObject.optString("video_url"), jSONObject.optString("video_play_report_url"), jSONObject.optString("video_time_report_url"), optInt3, optInt4, a4, nativeAdViewAttributes);
        return !c1917n.m14310v() ? null : c1917n;
    }

    private static void m14305a(String str, Map<String, String> map, Map<String, Object> map2) {
        if (map2.containsKey(str)) {
            map.put(str, String.valueOf(map2.get(str)));
        }
    }

    private static void m14306a(Map<String, String> map, Map<String, Object> map2) {
        if (map2.containsKey("mil")) {
            boolean booleanValue = ((Boolean) map2.get("mil")).booleanValue();
            map2.remove("mil");
            if (!booleanValue) {
                return;
            }
        }
        map.put("mil", "true");
    }

    private static Map<String, String> m14307b(Map<String, Object> map) {
        Map<String, String> hashMap = new HashMap();
        if (map.containsKey("view")) {
            hashMap.put("view", String.valueOf(map.get("view")));
        }
        if (map.containsKey("snapshot")) {
            hashMap.put("snapshot", String.valueOf(map.get("snapshot")));
        }
        return hashMap;
    }

    private void m14308b(Map<String, String> map, Map<String, Object> map2) {
        C1917n.m14305a("nti", map, map2);
        C1917n.m14305a("nhs", map, map2);
        C1917n.m14305a("nmv", map, map2);
    }

    private void m14309u() {
        if (!this.f14072K) {
            new C1991o().execute(new String[]{this.f14087n});
            this.f14072K = true;
        }
    }

    private boolean m14310v() {
        return (this.f14076c == null || this.f14076c.length() <= 0 || this.f14079f == null || this.f14079f.length() <= 0 || this.f14081h == null || this.f14082i == null) ? false : true;
    }

    public final C1979e mo731a() {
        return this.f14088o;
    }

    public final void m14312a(Context context, Map<String, Object> map) {
        if (!this.f14071J) {
            Map hashMap = new HashMap();
            if (map != null) {
                C1917n.m14306a(hashMap, (Map) map);
                m14308b(hashMap, map);
                hashMap.put("touch", C1983g.m14458a((Map) map));
            }
            new C1991o(hashMap).execute(new String[]{this.f14086m});
            this.f14066E.m14303a("click");
            this.f14071J = true;
            C1983g.m14461a(context, "Click logged");
        }
        C1891a a = C1892b.m14213a(context, this.f14075b);
        if (a != null) {
            try {
                this.f14073L = System.currentTimeMillis();
                this.f14074M = a.mo704a();
                a.mo705b();
            } catch (Throwable e) {
                Log.e(f14061a, "Error executing action", e);
            }
        }
    }

    public final void m14313a(Map<String, Object> map) {
        if (!this.f14070I) {
            final Map hashMap = new HashMap();
            if (map != null) {
                C1917n.m14306a(hashMap, (Map) map);
                m14308b(hashMap, map);
            }
            new C1991o(hashMap).execute(new String[]{this.f14084k});
            if (m14320n() || m14321o()) {
                try {
                    final Map b = C1917n.m14307b(map);
                    HandlerDetour.b(new Handler(), new Runnable(this) {
                        final /* synthetic */ C1917n f14059c;

                        public void run() {
                            new C1991o(hashMap, b).execute(new String[]{this.f14059c.f14085l});
                        }
                    }, (long) (this.f14094u * 1000), 1770315);
                } catch (Exception e) {
                }
            }
            this.f14066E.m14303a("impression");
            this.f14070I = true;
        }
    }

    public final String mo732b() {
        return this.f14089p;
    }

    public final Collection<String> mo733c() {
        return this.f14090q;
    }

    public final String m14316f() {
        m14309u();
        return this.f14076c;
    }

    public final String m14317g() {
        m14309u();
        return this.f14077d;
    }

    public final String m14318h() {
        m14309u();
        return this.f14078e;
    }

    public final String m14319i() {
        m14309u();
        return this.f14080g;
    }

    public final boolean m14320n() {
        return this.f14092s;
    }

    public final boolean m14321o() {
        return this.f14093t;
    }
}
