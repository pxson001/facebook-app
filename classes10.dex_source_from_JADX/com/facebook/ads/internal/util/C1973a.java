package com.facebook.ads.internal.util;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class C1973a {
    private static SensorManager f14299a = null;
    private static Sensor f14300b = null;
    private static Sensor f14301c = null;
    public static volatile float[] f14302d;
    public static volatile float[] f14303e;
    private static Map<String, Object> f14304f = new ConcurrentHashMap();
    public static String[] f14305g = new String[]{"x", "y", "z"};

    public static Map<String, Object> m14441a() {
        int i;
        Map<String, Object> hashMap = new HashMap();
        hashMap.putAll(f14304f);
        int i2 = 0;
        float[] fArr = f14302d;
        float[] fArr2 = f14303e;
        if (fArr != null) {
            int min = Math.min(f14305g.length, fArr.length);
            for (i = 0; i < min; i++) {
                hashMap.put("accelerometer_" + f14305g[i], Float.valueOf(fArr[i]));
            }
        }
        if (fArr2 != null) {
            i = Math.min(f14305g.length, fArr2.length);
            while (i2 < i) {
                hashMap.put("rotation_" + f14305g[i2], Float.valueOf(fArr2[i2]));
                i2++;
            }
        }
        return hashMap;
    }
}
