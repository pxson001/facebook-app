package com.facebook.backgroundlocation.reporting;

import com.facebook.backgroundlocation.reporting.BackgroundLocationSnapshot.ConnectedWifi;
import com.facebook.backgroundlocation.reporting.BackgroundLocationSnapshot.WifiInfo;
import com.facebook.backgroundlocation.reporting.BackgroundLocationSnapshot.WifiScanResult;
import com.fasterxml.jackson.core.JsonGenerator;

/* compiled from: diode */
public final class BackgroundLocationSnapshot_WifiInfo__JsonHelper {
    public static void m15372a(JsonGenerator jsonGenerator, WifiInfo wifiInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("scan_results");
        if (wifiInfo.f14927a != null) {
            jsonGenerator.d();
            for (WifiScanResult wifiScanResult : wifiInfo.f14927a) {
                if (wifiScanResult != null) {
                    if (1 != null) {
                        jsonGenerator.f();
                    }
                    if (wifiScanResult.f14929a != null) {
                        jsonGenerator.a("age_ms", wifiScanResult.f14929a.longValue());
                    }
                    if (wifiScanResult.f14930b != null) {
                        jsonGenerator.a("hardware_address", wifiScanResult.f14930b);
                    }
                    if (wifiScanResult.f14931c != null) {
                        jsonGenerator.a("rssi_dbm", wifiScanResult.f14931c.intValue());
                    }
                    if (wifiScanResult.f14932d != null) {
                        jsonGenerator.a("network_name", wifiScanResult.f14932d);
                    }
                    if (wifiScanResult.f14933e != null) {
                        jsonGenerator.a("frequency_mhz", wifiScanResult.f14933e.intValue());
                    }
                    if (1 != null) {
                        jsonGenerator.g();
                    }
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (wifiInfo.f14928b != null) {
            jsonGenerator.a("connected");
            ConnectedWifi connectedWifi = wifiInfo.f14928b;
            if (1 != null) {
                jsonGenerator.f();
            }
            if (connectedWifi.f14921a != null) {
                jsonGenerator.a("hardware_address", connectedWifi.f14921a);
            }
            if (connectedWifi.f14922b != null) {
                jsonGenerator.a("rssi_dbm", connectedWifi.f14922b.intValue());
            }
            if (connectedWifi.f14923c != null) {
                jsonGenerator.a("network_name", connectedWifi.f14923c);
            }
            if (connectedWifi.f14924d != null) {
                jsonGenerator.a("frequency_mhz", connectedWifi.f14924d.intValue());
            }
            if (1 != null) {
                jsonGenerator.g();
            }
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
