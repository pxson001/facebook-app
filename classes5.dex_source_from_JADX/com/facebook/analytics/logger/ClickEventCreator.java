package com.facebook.analytics.logger;

import android.app.Activity;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.analytics.tagging.AnalyticsActivityWithExtraData;
import com.facebook.analytics.tagging.AnalyticsObjectProvider;
import com.facebook.analytics.tagging.AnalyticsObjectProvider$ObjectType;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: timeline_collection */
public class ClickEventCreator {
    public static HoneyClientEvent m2576a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, ?> map) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
        if (str != null) {
            honeyClientEvent.c = str;
        }
        if (str2 != null) {
            honeyClientEvent.d = str2;
        }
        if (str3 != null) {
            honeyClientEvent.e = str3;
        }
        if (map != null) {
            honeyClientEvent.a(map);
        }
        return honeyClientEvent;
    }

    public static HoneyClientEvent m2575a(@Nullable Activity activity, @Nullable String str, @Nullable String str2, @Nullable Map<String, ?> map) {
        String str3;
        Map a;
        if (activity == null || !(activity instanceof AnalyticsActivity)) {
            str3 = null;
        } else {
            str3 = ((AnalyticsActivity) activity).am_();
        }
        if (activity instanceof AnalyticsObjectProvider) {
            if (str == null) {
                AnalyticsObjectProvider$ObjectType a2 = ((AnalyticsObjectProvider) activity).a();
                if (a2 != null) {
                    str = a2.getTypeName();
                }
            }
            if (str2 == null) {
                str2 = ((AnalyticsObjectProvider) activity).d();
            }
        }
        if (activity instanceof AnalyticsActivityWithExtraData) {
            a = m2577a(map, (AnalyticsActivityWithExtraData) activity);
        }
        return m2576a(str3, str, str2, a);
    }

    private static Map<String, ?> m2577a(Map<String, ?> map, AnalyticsActivityWithExtraData analyticsActivityWithExtraData) {
        Map<String, ?> c = analyticsActivityWithExtraData.c();
        if (c == null) {
            return map;
        }
        if (map == null) {
            return c;
        }
        return ImmutableMap.builder().a(map).a(c).b();
    }
}
