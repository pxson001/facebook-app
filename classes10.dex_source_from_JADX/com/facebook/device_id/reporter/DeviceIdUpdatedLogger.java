package com.facebook.device_id.reporter;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.device_id.DeviceIdChangedCallback;
import com.facebook.device_id.DeviceIdChangedCallback.ChangeType;
import com.facebook.device_id.UniqueDeviceId;
import javax.inject.Inject;

/* compiled from: context_menu_click */
public class DeviceIdUpdatedLogger implements DeviceIdChangedCallback {
    private AnalyticsLogger f15892a;
    private Clock f15893b;

    @Inject
    public DeviceIdUpdatedLogger(AnalyticsLogger analyticsLogger, Clock clock) {
        this.f15892a = analyticsLogger;
        this.f15893b = clock;
    }

    public final void m16328a(UniqueDeviceId uniqueDeviceId, UniqueDeviceId uniqueDeviceId2, ChangeType changeType, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("phoneid_update");
        honeyClientEvent.b("old_id", uniqueDeviceId.a).a("old_ts", uniqueDeviceId.b).b("new_id", uniqueDeviceId2.a).a("new_ts", uniqueDeviceId2.b).b("type", changeType.type());
        if (str != null) {
            honeyClientEvent.b("src_pkg", str);
        }
        honeyClientEvent.e = this.f15893b.a();
        this.f15892a.a(honeyClientEvent);
    }
}
