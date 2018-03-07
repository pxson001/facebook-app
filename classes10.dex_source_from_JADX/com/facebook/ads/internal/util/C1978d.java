package com.facebook.ads.internal.util;

import com.facebook.ads.internal.dto.C1925b;
import com.facebook.ads.internal.dto.C1929e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class C1978d {
    public static Map<String, Long> f14320a = new ConcurrentHashMap();
    private static Map<String, Long> f14321b = new ConcurrentHashMap();
    public static Map<String, String> f14322c = new ConcurrentHashMap();

    public static void m14447a(long j, C1929e c1929e) {
        f14320a.put(C1978d.m14451d(c1929e), Long.valueOf(j));
    }

    public static void m14448a(String str, C1929e c1929e) {
        f14322c.put(C1978d.m14451d(c1929e), str);
    }

    public static boolean m14449a(C1929e c1929e) {
        String d = C1978d.m14451d(c1929e);
        if (!f14321b.containsKey(d)) {
            return false;
        }
        long longValue = ((Long) f14321b.get(d)).longValue();
        C1925b c1925b = c1929e.f14156c;
        long j = -1000;
        if (!f14320a.containsKey(d)) {
            switch (c1925b) {
                case BANNER:
                    j = 15000;
                    break;
                case INTERSTITIAL:
                case NATIVE:
                    break;
                default:
                    break;
            }
        }
        j = ((Long) f14320a.get(d)).longValue();
        return System.currentTimeMillis() - longValue < j;
    }

    public static void m14450b(C1929e c1929e) {
        f14321b.put(C1978d.m14451d(c1929e), Long.valueOf(System.currentTimeMillis()));
    }

    public static String m14451d(C1929e c1929e) {
        int i = 0;
        String str = "%s:%s:%s:%d:%d:%d";
        Object[] objArr = new Object[6];
        objArr[0] = c1929e.f14154a;
        objArr[1] = c1929e.f14156c;
        objArr[2] = c1929e.f14158e;
        objArr[3] = Integer.valueOf(c1929e.f14162i == null ? 0 : c1929e.f14162i.getHeight());
        if (c1929e.f14162i != null) {
            i = c1929e.f14162i.getWidth();
        }
        objArr[4] = Integer.valueOf(i);
        objArr[5] = Integer.valueOf(c1929e.f14161h);
        return String.format(str, objArr);
    }
}
