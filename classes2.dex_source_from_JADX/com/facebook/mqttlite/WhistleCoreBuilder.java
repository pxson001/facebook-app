package com.facebook.mqttlite;

import android.content.Context;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.proxygen.EventBase;
import com.facebook.proxygen.HTTPThread;
import com.facebook.proxygen.MQTTClientFactory;
import com.facebook.proxygen.MQTTClientSettings;
import com.facebook.proxygen.PersistentSSLCacheSettings;
import com.facebook.proxygen.PersistentSSLCacheSettings.Builder;
import com.facebook.rti.common.time.SystemClock;
import com.facebook.rti.mqtt.common.analytics.MqttAnalyticsLogger;
import com.facebook.rti.mqtt.protocol.MqttClientCore;
import com.facebook.rti.mqtt.protocol.MqttClientCoreBuilder;
import com.facebook.rti.mqtt.protocol.MqttParameters;
import com.facebook.soloader.SoLoader;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: force_full_screen_emoji_nux */
public class WhistleCoreBuilder extends MqttClientCoreBuilder {
    private static final String f23469b = WhistleCoreBuilder.class.getSimpleName();
    private static volatile WhistleCoreBuilder f23470l;
    private final Context f23471c;
    private final Provider<TriState> f23472d;
    private final Lazy<ExecutorService> f23473e;
    private final MqttLiteAnalyticsSamplePolicy f23474f;
    private final Provider<Boolean> f23475g;
    private final Provider<Boolean> f23476h;
    private boolean f23477i = false;
    private MQTTClientFactory f23478j;
    private EventBase f23479k;

    public static com.facebook.mqttlite.WhistleCoreBuilder m31779a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23470l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.mqttlite.WhistleCoreBuilder.class;
        monitor-enter(r1);
        r0 = f23470l;	 Catch:{ all -> 0x003a }
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
        r0 = m31781b(r0);	 Catch:{ all -> 0x0035 }
        f23470l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23470l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.mqttlite.WhistleCoreBuilder.a(com.facebook.inject.InjectorLike):com.facebook.mqttlite.WhistleCoreBuilder");
    }

    private static WhistleCoreBuilder m31781b(InjectorLike injectorLike) {
        return new WhistleCoreBuilder((Context) injectorLike.getInstance(Context.class), IdBasedProvider.m1811a(injectorLike, 753), IdBasedLazy.m1808a(injectorLike, 4537), MqttLiteAnalyticsSamplePolicy.m31717a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4284), IdBasedProvider.m1811a(injectorLike, 4293));
    }

    @Inject
    public WhistleCoreBuilder(Context context, Provider<TriState> provider, Lazy<ExecutorService> lazy, MqttLiteAnalyticsSamplePolicy mqttLiteAnalyticsSamplePolicy, Provider<Boolean> provider2, Provider<Boolean> provider3) {
        this.f23471c = context;
        this.f23472d = provider;
        this.f23473e = lazy;
        this.f23474f = mqttLiteAnalyticsSamplePolicy;
        this.f23475g = provider2;
        this.f23476h = provider3;
    }

    protected final MqttClientCore m31785a(MqttParameters mqttParameters, SystemClock systemClock, MqttAnalyticsLogger mqttAnalyticsLogger) {
        String str;
        TriState triState = (TriState) this.f23472d.get();
        if (TriState.YES.equals(triState)) {
            if (!this.f23477i) {
                try {
                    m31784d();
                    this.f23477i = true;
                } catch (Throwable th) {
                    str = "JNI load failed";
                    BLog.a(f23469b, str, th);
                    m31780a(mqttAnalyticsLogger, str, th);
                    this.a = "LF";
                    return null;
                }
            }
            try {
                if (this.f23478j == null) {
                    HTTPThread hTTPThread = new HTTPThread();
                    Thread a = ThreadInitDetour.a(hTTPThread, -285934729);
                    a.setPriority(mqttParameters.p());
                    a.start();
                    hTTPThread.waitForInitialization();
                    this.f23479k = hTTPThread.getEventBase();
                    MQTTClientSettings mQTTClientSettings = new MQTTClientSettings();
                    mQTTClientSettings.setZlibCompression(true).setVerifyCertificates(true).setConnectTimeout(((Boolean) this.f23476h.get()).booleanValue() ? 30000 : mqttParameters.j()).setPingRespTimeout(0);
                    this.f23478j = new MQTTClientFactory(this.f23479k, (Executor) this.f23473e.get(), mQTTClientSettings).setPersistentSSLCacheSettings(m31782b()).setPersistentDNSCacheSettings(m31783c());
                    this.f23478j.init();
                }
                this.a = "W";
                return new WhistleClientCore(mqttParameters.m(), mqttParameters.i(), this.f23478j, systemClock, this.f23474f.m31720a(), mqttAnalyticsLogger, (Executor) this.f23473e.get(), ((Boolean) this.f23475g.get()).booleanValue());
            } catch (Throwable th2) {
                str = "Failed to create whistle factory";
                BLog.a(f23469b, str, th2);
                m31780a(mqttAnalyticsLogger, str, th2);
                this.a = "FC";
                return null;
            }
        }
        if (TriState.NO.equals(triState)) {
            this.a = "D";
        }
        return null;
    }

    private PersistentSSLCacheSettings m31782b() {
        Builder builder = new Builder(new File(this.f23471c.getCacheDir(), "WhistleTls.store").toString());
        builder.cacheCapacity = 10;
        Builder builder2 = builder;
        builder2.syncInterval = 150;
        return builder2.build();
    }

    private PersistentSSLCacheSettings m31783c() {
        Builder builder = new Builder(new File(this.f23471c.getCacheDir(), "WhistleDns.store").toString());
        builder.cacheCapacity = 20;
        Builder builder2 = builder;
        builder2.syncInterval = 150;
        return builder2.build();
    }

    private static void m31784d() {
        SoLoader.a("fb");
        SoLoader.a("liger");
        SoLoader.a("whistle");
    }

    private static void m31780a(MqttAnalyticsLogger mqttAnalyticsLogger, String str, Throwable th) {
        Map hashMap = new HashMap();
        hashMap.put("reason", str);
        hashMap.put("throwable", th.toString());
        mqttAnalyticsLogger.a("whistle_failure", hashMap);
    }
}
