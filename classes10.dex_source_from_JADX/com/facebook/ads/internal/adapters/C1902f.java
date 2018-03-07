package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.server.AdPlacementType;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class C1902f {
    private static final Set<C1904h> f14003a = new HashSet();
    private static final Map<AdPlacementType, String> f14004b = new ConcurrentHashMap();

    static {
        for (C1904h c1904h : C1904h.values()) {
            Class cls;
            switch (c1904h.f14015g) {
                case BANNER:
                    cls = BannerAdapter.class;
                    break;
                case INTERSTITIAL:
                    cls = InterstitialAdapter.class;
                    break;
                case NATIVE:
                    cls = C1910p.class;
                    break;
                default:
                    cls = null;
                    break;
            }
            if (cls != null) {
                Class cls2 = c1904h.f14012d;
                if (cls2 == null) {
                    try {
                        cls2 = Class.forName(c1904h.f14013e);
                    } catch (ClassNotFoundException e) {
                    }
                }
                if (cls2 != null && cls.isAssignableFrom(cls2)) {
                    f14003a.add(c1904h);
                }
            }
        }
    }

    private static AdAdapter m14238a(C1903g c1903g, AdPlacementType adPlacementType) {
        try {
            C1904h b = C1902f.m14241b(c1903g, adPlacementType);
            if (b != null && f14003a.contains(b)) {
                Class cls = b.f14012d;
                if (cls == null) {
                    cls = Class.forName(b.f14013e);
                }
                return (AdAdapter) cls.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AdAdapter m14239a(String str, AdPlacementType adPlacementType) {
        return C1902f.m14238a(C1903g.m14242a(str), adPlacementType);
    }

    public static String m14240a(AdPlacementType adPlacementType) {
        if (f14004b.containsKey(adPlacementType)) {
            return (String) f14004b.get(adPlacementType);
        }
        Set<String> hashSet = new HashSet();
        for (C1904h c1904h : f14003a) {
            if (c1904h.f14015g == adPlacementType) {
                hashSet.add(c1904h.f14014f.toString());
            }
        }
        String str = ",";
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : hashSet) {
            stringBuilder.append(append);
            stringBuilder.append(str);
        }
        str = stringBuilder.length() > 0 ? stringBuilder.substring(0, stringBuilder.length() - 1) : "";
        f14004b.put(adPlacementType, str);
        return str;
    }

    private static C1904h m14241b(C1903g c1903g, AdPlacementType adPlacementType) {
        for (C1904h c1904h : f14003a) {
            if (c1904h.f14014f == c1903g && c1904h.f14015g == adPlacementType) {
                return c1904h;
            }
        }
        return null;
    }
}
