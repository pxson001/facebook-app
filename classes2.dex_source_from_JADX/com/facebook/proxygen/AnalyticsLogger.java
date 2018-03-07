package com.facebook.proxygen;

import java.util.Map;

/* compiled from: update_timeline_app_collection_in_newsfeed */
public interface AnalyticsLogger {
    void reportEvent(Map<String, String> map, String str, String str2);
}
