package com.facebook.push.fbpushdata;

import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.push.PushProperty;
import com.facebook.push.PushSource;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: hide topic from user failed */
public abstract class BaseFbPushDataHandler implements FbPushDataHandler {
    private static final Class<?> f11266b = BaseFbPushDataHandler.class;
    protected final ReliabilityAnalyticsLogger f11267a;

    public abstract void m13173b(JsonNode jsonNode, PushProperty pushProperty);

    public BaseFbPushDataHandler(ReliabilityAnalyticsLogger reliabilityAnalyticsLogger) {
        this.f11267a = reliabilityAnalyticsLogger;
    }

    public final void mo617a(JsonNode jsonNode, PushProperty pushProperty) {
        PushSource pushSource = pushProperty.f11217a;
        m13173b(jsonNode, pushProperty);
    }

    protected final void m13172a(String str, PushProperty pushProperty) {
        this.f11267a.a(pushProperty.f11217a.toString(), pushProperty.f11218b, str, null, "", "");
    }
}
