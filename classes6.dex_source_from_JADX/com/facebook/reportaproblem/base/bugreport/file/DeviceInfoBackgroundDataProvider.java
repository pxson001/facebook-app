package com.facebook.reportaproblem.base.bugreport.file;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: set_other_privacy */
public class DeviceInfoBackgroundDataProvider implements BugReportBackgroundDataProvider {
    public final Map<String, String> m7052b() {
        Map<String, String> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("OS_Version", VERSION.RELEASE);
        linkedHashMap.put("Manufacturer", Build.MANUFACTURER);
        linkedHashMap.put("Model", Build.MODEL);
        linkedHashMap.put("Locale", Locale.getDefault().getDisplayName(Locale.US));
        return linkedHashMap;
    }
}
