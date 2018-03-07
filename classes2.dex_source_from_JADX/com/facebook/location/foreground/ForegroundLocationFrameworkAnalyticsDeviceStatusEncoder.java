package com.facebook.location.foreground;

import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationStatus;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.wifiscan.WifiScanEligibilityUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: manual_switcher_mode */
public class ForegroundLocationFrameworkAnalyticsDeviceStatusEncoder {
    private static volatile ForegroundLocationFrameworkAnalyticsDeviceStatusEncoder f15211c;
    public final FbLocationStatusUtil f15212a;
    public final WifiScanEligibilityUtil f15213b;

    public static com.facebook.location.foreground.ForegroundLocationFrameworkAnalyticsDeviceStatusEncoder m21740a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15211c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.location.foreground.ForegroundLocationFrameworkAnalyticsDeviceStatusEncoder.class;
        monitor-enter(r1);
        r0 = f15211c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m21741b(r0);	 Catch:{ all -> 0x0035 }
        f15211c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15211c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.location.foreground.ForegroundLocationFrameworkAnalyticsDeviceStatusEncoder.a(com.facebook.inject.InjectorLike):com.facebook.location.foreground.ForegroundLocationFrameworkAnalyticsDeviceStatusEncoder");
    }

    private static ForegroundLocationFrameworkAnalyticsDeviceStatusEncoder m21741b(InjectorLike injectorLike) {
        return new ForegroundLocationFrameworkAnalyticsDeviceStatusEncoder(FbLocationStatusUtil.m8253a(injectorLike), WifiScanEligibilityUtil.m21744a(injectorLike));
    }

    @Inject
    public ForegroundLocationFrameworkAnalyticsDeviceStatusEncoder(FbLocationStatusUtil fbLocationStatusUtil, WifiScanEligibilityUtil wifiScanEligibilityUtil) {
        this.f15212a = fbLocationStatusUtil;
        this.f15213b = wifiScanEligibilityUtil;
    }

    public final JsonNode m21743a() {
        JsonNode c = JsonNodeFactory.f3121a.m5233c();
        String str = "location_status";
        FbLocationStatus b = this.f15212a.m8259b();
        JsonNode c2 = JsonNodeFactory.f3121a.m5233c();
        c2.m5137a("state", b.f15655a.toString());
        String str2 = "available_providers_enabled";
        ImmutableSet immutableSet = b.f15656b;
        ImmutableSet immutableSet2 = b.f15657c;
        JsonNode c3 = JsonNodeFactory.f3121a.m5233c();
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            c3.m5138a((String) it.next(), true);
        }
        it = immutableSet2.iterator();
        while (it.hasNext()) {
            c3.m5138a((String) it.next(), false);
        }
        c2.m5143c(str2, c3);
        c.m5143c(str, c2);
        c.m5143c("wifi_status", m21742c());
        return c;
    }

    private JsonNode m21742c() {
        String str;
        JsonNode c = JsonNodeFactory.f3121a.m5233c();
        c.m5138a("available", this.f15213b.m21750a());
        c.m5138a("has_permission", this.f15213b.m21751c());
        c.m5138a("supports_timestamps", WifiScanEligibilityUtil.m21747b());
        c.m5138a("enabled", this.f15213b.m21752d());
        String str2 = "can_always_scan";
        TriState e = this.f15213b.m21753e();
        if (e == TriState.UNSET) {
            str = "unsupported";
        } else {
            str = Boolean.toString(e.asBoolean());
        }
        c.m5137a(str2, str);
        return c;
    }
}
