package com.facebook.fbreact.analytics;

import com.facebook.analytics2.logger.Analytics2Logger;
import com.facebook.analytics2.logger.EventBuilder;
import com.facebook.analytics2.logger.EventLogType;
import com.facebook.catalyst.modules.analytics.AnalyticsDataParser;
import com.facebook.inject.Lazy;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: fail to load edit page data */
public class Fb4aAnalyticsModule extends ReactContextBaseJavaModule {
    private final Lazy<Analytics2Logger> f7250a;

    public Fb4aAnalyticsModule(ReactApplicationContext reactApplicationContext, Lazy<Analytics2Logger> lazy) {
        super(reactApplicationContext);
        this.f7250a = lazy;
    }

    public String getName() {
        return "RKAnalytics";
    }

    @ReactMethod
    public void logCounter(String str, int i) {
    }

    @ReactMethod
    public void logRealtimeEvent(String str, ReadableMap readableMap) {
        EventBuilder a = ((Analytics2Logger) this.f7250a.get()).a(null, str, true, EventLogType.CLIENT_EVENT, true);
        if (a.a()) {
            AnalyticsDataParser.m6878a(a, readableMap);
            a.d();
        }
    }

    @ReactMethod
    public void logEvent(String str, ReadableMap readableMap) {
        EventBuilder a = ((Analytics2Logger) this.f7250a.get()).a(null, str, false, EventLogType.CLIENT_EVENT, false);
        if (a.a()) {
            AnalyticsDataParser.m6878a(a, readableMap);
            a.d();
        }
    }
}
