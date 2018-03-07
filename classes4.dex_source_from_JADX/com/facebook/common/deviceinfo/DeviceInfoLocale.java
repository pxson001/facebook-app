package com.facebook.common.deviceinfo;

import com.facebook.common.locale.Locales;
import java.util.HashMap;
import java.util.Map;

/* compiled from: id/ */
public class DeviceInfoLocale {
    public static Map<String, Object> m11068a(Locales locales) {
        Map<String, Object> hashMap = new HashMap();
        if (locales != null) {
            hashMap.put("device_locale", Locales.e());
            hashMap.put("app_locale", locales.c());
        }
        return hashMap;
    }
}
