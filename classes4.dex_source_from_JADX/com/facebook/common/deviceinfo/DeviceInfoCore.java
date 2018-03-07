package com.facebook.common.deviceinfo;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.device.yearclass.YearClass;
import java.util.HashMap;
import java.util.Map;

/* compiled from: icon_uri */
public class DeviceInfoCore {
    public static Map<String, Object> m11069a(Context context) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("os_type", "Android");
        hashMap.put("os_ver", VERSION.RELEASE);
        hashMap.put("device_type", Build.MODEL);
        hashMap.put("brand", Build.BRAND);
        hashMap.put("manufacturer", Build.MANUFACTURER);
        if (context != null) {
            hashMap.put("year_class", Integer.valueOf(YearClass.a(context)));
        }
        Object obj = "unknown";
        if (context != null) {
            try {
                obj = (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 262144) != 0 ? "sdcard" : "internal_storage";
            } catch (NameNotFoundException e) {
                obj = "unknown";
            }
        }
        hashMap.put("install_location", obj);
        return hashMap;
    }
}
