package com.facebook.common.hardware;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.android.WifiManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sphericalFullscreenAspectRatio */
public class WifiDiagnosticsSerializer {
    private static volatile WifiDiagnosticsSerializer f2611b;
    public final WifiManager f2612a;

    public static com.facebook.common.hardware.WifiDiagnosticsSerializer m3722a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2611b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.hardware.WifiDiagnosticsSerializer.class;
        monitor-enter(r1);
        r0 = f2611b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3724b(r0);	 Catch:{ all -> 0x0035 }
        f2611b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2611b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.hardware.WifiDiagnosticsSerializer.a(com.facebook.inject.InjectorLike):com.facebook.common.hardware.WifiDiagnosticsSerializer");
    }

    private static WifiDiagnosticsSerializer m3724b(InjectorLike injectorLike) {
        return new WifiDiagnosticsSerializer(WifiManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public WifiDiagnosticsSerializer(WifiManager wifiManager) {
        this.f2612a = wifiManager;
    }

    public final JsonNode m3725a() {
        if (this.f2612a == null) {
            return null;
        }
        ObjectNode objectNode;
        if (this.f2612a == null) {
            objectNode = null;
        } else {
            String str;
            objectNode = new ObjectNode(JsonNodeFactory.a);
            boolean isWifiEnabled = this.f2612a.isWifiEnabled();
            int wifiState = this.f2612a.getWifiState();
            objectNode.a("enabled", isWifiEnabled);
            String str2 = "state";
            switch (wifiState) {
                case 0:
                    str = "disabling";
                    break;
                case 1:
                    str = "disabled";
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str = "enabling";
                    break;
                case 3:
                    str = "enabled";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            objectNode.a(str2, str);
            WifiInfo connectionInfo = this.f2612a.getConnectionInfo();
            ObjectNode objectNode2 = null;
            if (connectionInfo != null) {
                String bssid = connectionInfo.getBSSID();
                if (bssid != null) {
                    objectNode2 = new ObjectNode(JsonNodeFactory.a);
                    objectNode2.a("mac_address", bssid);
                    objectNode2.a("is_hidden_ssid", connectionInfo.getHiddenSSID());
                    objectNode2.a("link_speed_mbps", connectionInfo.getLinkSpeed());
                    objectNode2.a("signal_strength", connectionInfo.getRssi());
                    objectNode2.a("ssid", connectionInfo.getSSID());
                }
            }
            JsonNode jsonNode = objectNode2;
            if (jsonNode != null) {
                objectNode.c("current_connection", jsonNode);
            }
        }
        ObjectNode objectNode3 = objectNode;
        if (objectNode3 == null) {
            return null;
        }
        JsonNode a = m3723a(this.f2612a.getScanResults());
        if (a == null) {
            return objectNode3;
        }
        objectNode3.c("access_points", a);
        return objectNode3;
    }

    private static JsonNode m3723a(List<ScanResult> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (ScanResult scanResult : list) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("mac_address", scanResult.BSSID);
            objectNode.a("ssid", scanResult.SSID);
            objectNode.a("signal_strength", scanResult.level);
            objectNode.a("frequency", scanResult.frequency);
            objectNode.a("capabilities", scanResult.capabilities);
            arrayNode.a(objectNode);
        }
        return arrayNode;
    }
}
