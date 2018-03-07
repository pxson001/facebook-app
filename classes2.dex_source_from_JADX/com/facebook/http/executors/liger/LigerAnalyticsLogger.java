package com.facebook.http.executors.liger;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.http.observer.NetworkInfo;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.proxygen.AnalyticsLogger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: profile_someone_else */
public class LigerAnalyticsLogger implements AnalyticsLogger {
    private final com.facebook.analytics.logger.AnalyticsLogger f8804a;
    private final FbDataConnectionManager f8805b;
    private final FbNetworkManager f8806c;
    private final NetworkInfoCollector f8807d;
    private Map<String, String> f8808e = new HashMap();

    public LigerAnalyticsLogger(com.facebook.analytics.logger.AnalyticsLogger analyticsLogger, FbDataConnectionManager fbDataConnectionManager, FbNetworkManager fbNetworkManager, NetworkInfoCollector networkInfoCollector) {
        this.f8804a = analyticsLogger;
        this.f8805b = fbDataConnectionManager;
        this.f8806c = fbNetworkManager;
        this.f8807d = networkInfoCollector;
        this.f8808e.put("http_stack", "liger");
    }

    public void reportEvent(Map<String, String> map, String str, String str2) {
        if (map != null && str != null && str2 != null) {
            HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
            honeyClientEvent.f3099c = str2;
            if (!str.equals("http_liger")) {
                String toLowerCase = this.f8806c.m3835k().toLowerCase(Locale.US);
                String l = this.f8806c.m3836l();
                map.put("connection_type", toLowerCase);
                map.put("connection_subtype", toLowerCase + " " + l);
                map.put("connqual", this.f8805b.m3801c().name());
                honeyClientEvent.m5088a(this.f8808e);
                NetworkInfo a = this.f8807d.mo495a();
                if (a != null) {
                    honeyClientEvent.m5088a(a.m27418c());
                }
            }
            honeyClientEvent.m5088a((Map) map);
            this.f8804a.mo526a(honeyClientEvent);
        }
    }
}
