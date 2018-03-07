package com.facebook.tigon.httpclientadapter;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.http.common.CachedNetworkInfoCollector;
import com.facebook.http.observer.DownloadBandwidthManager;
import com.facebook.http.observer.FbHttpFlowObserver;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.http.observer.ResponseBandwidthManager;
import com.facebook.http.observer.STATICDI_MULTIBIND_PROVIDER;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.InjectorLike;
import com.facebook.push.connectionstatusbridge.MqttBridgeConnectionStatusProvider;
import com.facebook.push.mqtt.service.MqttBridgeConnectionStatusProviderImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tigon.iface.TigonRequestLayers.LayerInfo;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: notif_update_installed */
public class TigonFlowStateController {
    public static final LayerInfo<FlowObserverRequestInfo> f4932a = new LayerInfo();
    private static final String f4933b = TigonFlowStateController.class.getSimpleName();
    private static volatile TigonFlowStateController f4934n;
    public final Provider<Set<FbHttpFlowObserver>> f4935c;
    private final QeAccessor f4936d;
    public final FbNetworkManager f4937e;
    public final FbDataConnectionManager f4938f;
    public final DownloadBandwidthManager f4939g;
    public final MonotonicClock f4940h;
    private final AbstractFbErrorReporter f4941i;
    public final AnalyticsLogger f4942j;
    public final NetworkInfoCollector f4943k;
    public final MqttBridgeConnectionStatusProvider f4944l;
    public final ResponseBandwidthManager f4945m;

    public static com.facebook.tigon.httpclientadapter.TigonFlowStateController m6232a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4934n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.tigon.httpclientadapter.TigonFlowStateController.class;
        monitor-enter(r1);
        r0 = f4934n;	 Catch:{ all -> 0x003a }
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
        r0 = m6233b(r0);	 Catch:{ all -> 0x0035 }
        f4934n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4934n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tigon.httpclientadapter.TigonFlowStateController.a(com.facebook.inject.InjectorLike):com.facebook.tigon.httpclientadapter.TigonFlowStateController");
    }

    private static TigonFlowStateController m6233b(InjectorLike injectorLike) {
        return new TigonFlowStateController(STATICDI_MULTIBIND_PROVIDER.FbHttpFlowObserver.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), FbDataConnectionManager.a(injectorLike), DownloadBandwidthManager.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (NetworkInfoCollector) CachedNetworkInfoCollector.a(injectorLike), (MqttBridgeConnectionStatusProvider) MqttBridgeConnectionStatusProviderImpl.a(injectorLike));
    }

    @Inject
    public TigonFlowStateController(Provider<Set<FbHttpFlowObserver>> provider, QeAccessor qeAccessor, FbNetworkManager fbNetworkManager, FbDataConnectionManager fbDataConnectionManager, DownloadBandwidthManager downloadBandwidthManager, MonotonicClock monotonicClock, FbErrorReporter fbErrorReporter, AnalyticsLogger analyticsLogger, NetworkInfoCollector networkInfoCollector, MqttBridgeConnectionStatusProvider mqttBridgeConnectionStatusProvider) {
        this.f4935c = provider;
        this.f4936d = qeAccessor;
        this.f4937e = fbNetworkManager;
        this.f4938f = fbDataConnectionManager;
        this.f4939g = downloadBandwidthManager;
        this.f4940h = monotonicClock;
        this.f4941i = fbErrorReporter;
        this.f4942j = analyticsLogger;
        this.f4943k = networkInfoCollector;
        this.f4944l = mqttBridgeConnectionStatusProvider;
        this.f4945m = new ResponseBandwidthManager(downloadBandwidthManager, monotonicClock);
    }

    public final AbstractFbErrorReporter m6234b() {
        return this.f4941i;
    }

    public final int m6235f() {
        return this.f4936d.a(ExperimentsForHttpQeModule.aC, 10000);
    }
}
