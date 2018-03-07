package com.facebook.backgroundlocation.reporting;

import com.facebook.backgroundlocation.reporting.BackgroundLocationSnapshot.Coordinates;
import com.fasterxml.jackson.core.JsonGenerator;

/* compiled from: didUpdateSucceed */
public final class BackgroundLocationSnapshot__JsonHelper {
    public static void m15373a(JsonGenerator jsonGenerator, BackgroundLocationSnapshot backgroundLocationSnapshot, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (backgroundLocationSnapshot.f14934a != null) {
            jsonGenerator.a("type", backgroundLocationSnapshot.f14934a);
        }
        if (backgroundLocationSnapshot.f14935b != null) {
            jsonGenerator.a("coordinates");
            Coordinates coordinates = backgroundLocationSnapshot.f14935b;
            if (1 != null) {
                jsonGenerator.f();
            }
            jsonGenerator.a("latitude", coordinates.f14925a);
            jsonGenerator.a("longitude", coordinates.f14926b);
            if (1 != null) {
                jsonGenerator.g();
            }
        }
        if (backgroundLocationSnapshot.f14936c != null) {
            jsonGenerator.a("age_ms", backgroundLocationSnapshot.f14936c.longValue());
        }
        if (backgroundLocationSnapshot.f14937d != null) {
            jsonGenerator.a("accuracy_meters", backgroundLocationSnapshot.f14937d.floatValue());
        }
        if (backgroundLocationSnapshot.f14938e != null) {
            jsonGenerator.a("altitude_meters", backgroundLocationSnapshot.f14938e.doubleValue());
        }
        if (backgroundLocationSnapshot.f14939f != null) {
            jsonGenerator.a("bearing_degrees", backgroundLocationSnapshot.f14939f.floatValue());
        }
        if (backgroundLocationSnapshot.f14940g != null) {
            jsonGenerator.a("speed_meters_per_sec", backgroundLocationSnapshot.f14940g.floatValue());
        }
        if (backgroundLocationSnapshot.f14941h != null) {
            jsonGenerator.a("start_age_ms", backgroundLocationSnapshot.f14941h.longValue());
        }
        if (backgroundLocationSnapshot.f14942i != null) {
            jsonGenerator.a("end_age_ms", backgroundLocationSnapshot.f14942i.longValue());
        }
        if (backgroundLocationSnapshot.f14943j != null) {
            jsonGenerator.a("geofence_radius_meters", backgroundLocationSnapshot.f14943j.intValue());
        }
        if (backgroundLocationSnapshot.f14944k != null) {
            jsonGenerator.a("wifi_info");
            BackgroundLocationSnapshot_WifiInfo__JsonHelper.m15372a(jsonGenerator, backgroundLocationSnapshot.f14944k, true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
