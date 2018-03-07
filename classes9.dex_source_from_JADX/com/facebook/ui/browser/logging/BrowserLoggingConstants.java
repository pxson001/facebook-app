package com.facebook.ui.browser.logging;

import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: tincan_upgrade */
public class BrowserLoggingConstants {
    public static final Map<String, Object> m1629a(String str) {
        if (str == null) {
            return null;
        }
        Map<String, Object> c = Maps.c();
        c.put("dest_module_uri", str);
        return c;
    }
}
