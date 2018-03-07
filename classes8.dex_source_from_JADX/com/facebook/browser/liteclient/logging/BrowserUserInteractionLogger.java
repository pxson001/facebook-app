package com.facebook.browser.liteclient.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.inject.InjectorLike;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_csc_valid */
public class BrowserUserInteractionLogger {
    private static volatile BrowserUserInteractionLogger f10645d;
    private final AnalyticsLogger f10646a;
    public final FbNetworkManager f10647b;
    public final DeviceConditionHelper f10648c;

    public static com.facebook.browser.liteclient.logging.BrowserUserInteractionLogger m12582a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10645d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.browser.liteclient.logging.BrowserUserInteractionLogger.class;
        monitor-enter(r1);
        r0 = f10645d;	 Catch:{ all -> 0x003a }
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
        r0 = m12583b(r0);	 Catch:{ all -> 0x0035 }
        f10645d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10645d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.browser.liteclient.logging.BrowserUserInteractionLogger.a(com.facebook.inject.InjectorLike):com.facebook.browser.liteclient.logging.BrowserUserInteractionLogger");
    }

    private static BrowserUserInteractionLogger m12583b(InjectorLike injectorLike) {
        return new BrowserUserInteractionLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), DeviceConditionHelper.a(injectorLike));
    }

    @Inject
    public BrowserUserInteractionLogger(AnalyticsLogger analyticsLogger, FbNetworkManager fbNetworkManager, DeviceConditionHelper deviceConditionHelper) {
        this.f10646a = analyticsLogger;
        this.f10647b = fbNetworkManager;
        this.f10648c = deviceConditionHelper;
    }

    public final void m12584a(Map map) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb4a_iab_spin_user_interaction");
        honeyClientEvent.a(map);
        if (!this.f10647b.d()) {
            honeyClientEvent.b("client_network", "offline");
        } else if (this.f10648c.b()) {
            honeyClientEvent.b("client_network", "wifi");
        } else {
            honeyClientEvent.b("client_network", "mobile");
        }
        this.f10646a.a(honeyClientEvent);
    }
}
