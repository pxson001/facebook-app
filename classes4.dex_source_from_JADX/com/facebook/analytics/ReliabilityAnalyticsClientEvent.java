package com.facebook.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: img_width */
public class ReliabilityAnalyticsClientEvent {
    public static HoneyClientEvent m11015a(String str, String str2, @Nullable Map<String, String> map, @Nullable String str3, @Nullable String str4) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str.toLowerCase());
        honeyClientEvent.b("status", str2.toLowerCase());
        if (str3 != null) {
            honeyClientEvent.d = str3;
        }
        if (str4 != null) {
            honeyClientEvent.e = str4;
        }
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                honeyClientEvent.b((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return honeyClientEvent;
    }
}
