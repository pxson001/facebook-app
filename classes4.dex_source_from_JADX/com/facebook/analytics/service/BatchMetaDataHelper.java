package com.facebook.analytics.service;

import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.analytics.db.AnalyticsSessionManager;
import com.facebook.analytics.event.HoneyProtocolUtils;
import com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.application.PlatformAppConfig;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Inject;

/* compiled from: temporary_login_nonce */
public class BatchMetaDataHelper {
    private final TelephonyManager f1229a;
    private final PlatformAppConfig f1230b;
    private final UniqueIdForDeviceHolderImpl f1231c;
    private final FbNetworkManager f1232d;
    private final AppVersionInfo f1233e;
    private final AnalyticsLoggingPolicy f1234f;
    private final AnalyticsSessionManager f1235g;
    private final Clock f1236h;

    public static BatchMetaDataHelper m1479b(InjectorLike injectorLike) {
        return new BatchMetaDataHelper(TelephonyManagerMethodAutoProvider.b(injectorLike), (PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike), FbNetworkManager.a(injectorLike), AppVersionInfoMethodAutoProvider.a(injectorLike), AnalyticsLoggingPolicy.a(injectorLike), AnalyticsSessionManager.m1434a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BatchMetaDataHelper(TelephonyManager telephonyManager, PlatformAppConfig platformAppConfig, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl, FbNetworkManager fbNetworkManager, AppVersionInfo appVersionInfo, AnalyticsLoggingPolicy analyticsLoggingPolicy, AnalyticsSessionManager analyticsSessionManager, Clock clock) {
        this.f1229a = telephonyManager;
        this.f1230b = platformAppConfig;
        this.f1231c = uniqueIdForDeviceHolderImpl;
        this.f1232d = fbNetworkManager;
        this.f1233e = appVersionInfo;
        this.f1234f = analyticsLoggingPolicy;
        this.f1235g = analyticsSessionManager;
        this.f1236h = clock;
    }

    public final ObjectNode m1480a(ObjectNode objectNode) {
        String networkOperatorName = this.f1229a.getNetworkOperatorName();
        if (TextUtils.isEmpty(networkOperatorName)) {
            networkOperatorName = "n/a";
        }
        objectNode.a("carrier", networkOperatorName);
        NetworkInfo i = this.f1232d.i();
        objectNode.a("conn", i != null ? i.getTypeName() : "none");
        objectNode.a("sent_time", HoneyProtocolUtils.m1450a(this.f1236h.a()));
        objectNode.a("app_id", this.f1230b.c());
        objectNode.a("device_id", this.f1231c.a());
        objectNode.a("device", Build.MODEL);
        objectNode.a("os_ver", VERSION.RELEASE);
        return objectNode;
    }

    public final ObjectNode m1481a(ObjectNode objectNode, boolean z) {
        objectNode.a("config_checksum", this.f1234f.a());
        objectNode.a("config_version", "v2");
        if (z) {
            objectNode.a("uid", this.f1235g.m1444b());
            objectNode.a("app_ver", this.f1233e.a());
        }
        return objectNode;
    }

    public final void m1482a(ObjectNode objectNode, long j, String str, int i, int i2, String str2, String str3, boolean z) {
        objectNode.a("time", j);
        objectNode.a("app_ver", str);
        objectNode.a("build_num", i);
        objectNode.a("session_id", str2);
        objectNode.a("seq", i2);
        objectNode.a("uid", this.f1235g.m1444b());
        objectNode.a("tier", str3);
        if (!z) {
            m1480a(objectNode);
            m1481a(objectNode, z);
        }
    }
}
