package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SENT_FROM_RECEIPT */
public class AppEventsLoggerUtility {
    private static final Map<GraphAPIActivityType, String> f23962a = new C34351();

    /* compiled from: SENT_FROM_RECEIPT */
    final class C34351 extends HashMap<GraphAPIActivityType, String> {
        C34351() {
            put(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL");
            put(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS");
        }
    }

    /* compiled from: SENT_FROM_RECEIPT */
    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    public static JSONObject m25231a(GraphAPIActivityType graphAPIActivityType, AttributionIdentifiers attributionIdentifiers, String str, boolean z, Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", f23962a.get(graphAPIActivityType));
        Utility.m25343a(jSONObject, attributionIdentifiers, str, z);
        try {
            Utility.m25342a(jSONObject, context);
        } catch (Exception e) {
            Logger.m25276a(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e.toString());
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
