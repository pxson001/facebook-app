package com.facebook.mqttlite.trafficcontrol;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.trafficcontrol.pref.ExperimentsForMessengerTrafficControlPrefModule;
import com.facebook.messaging.trafficcontrol.pref.TrafficControlPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rti.mqtt.protocol.trafficcontrol.TrafficControlParameter;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: force_refresh */
public class MqttTrafficControlParams implements TrafficControlParameter {
    private static volatile MqttTrafficControlParams f23466c;
    private final FbSharedPreferences f23467a;
    private final QeAccessor f23468b;

    public static com.facebook.mqttlite.trafficcontrol.MqttTrafficControlParams m31774a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23466c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.mqttlite.trafficcontrol.MqttTrafficControlParams.class;
        monitor-enter(r1);
        r0 = f23466c;	 Catch:{ all -> 0x003a }
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
        r0 = m31775b(r0);	 Catch:{ all -> 0x0035 }
        f23466c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23466c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.mqttlite.trafficcontrol.MqttTrafficControlParams.a(com.facebook.inject.InjectorLike):com.facebook.mqttlite.trafficcontrol.MqttTrafficControlParams");
    }

    private static MqttTrafficControlParams m31775b(InjectorLike injectorLike) {
        return new MqttTrafficControlParams(FbSharedPreferencesImpl.m1826a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public MqttTrafficControlParams(FbSharedPreferences fbSharedPreferences, QeAccessor qeAccessor) {
        this.f23467a = fbSharedPreferences;
        this.f23468b = qeAccessor;
    }

    public final boolean m31776a() {
        return this.f23467a.mo286a(TrafficControlPrefKeys.f23793b, false);
    }

    public final int m31777b() {
        return this.f23468b.mo573a(Liveness.Live, ExperimentsForMessengerTrafficControlPrefModule.f, 200);
    }

    public final int m31778c() {
        return this.f23468b.mo573a(Liveness.Live, ExperimentsForMessengerTrafficControlPrefModule.g, 500);
    }
}
