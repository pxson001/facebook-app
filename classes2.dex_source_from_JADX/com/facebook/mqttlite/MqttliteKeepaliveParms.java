package com.facebook.mqttlite;

import com.facebook.inject.InjectorLike;
import com.facebook.mqttlite.keepaliveexperiment.ExperimentsForKeepaliveExperimentModule;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rti.mqtt.keepalive.KeepaliveParms;
import com.facebook.telephony.FbTelephonyManager;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: foreground_last_fetched */
public class MqttliteKeepaliveParms implements KeepaliveParms {
    private static volatile MqttliteKeepaliveParms f23446e;
    private final FbTelephonyManager f23447a;
    private final MqttConnectionConfigManager f23448b;
    public final QeAccessor f23449c;
    private volatile boolean f23450d;

    public static com.facebook.mqttlite.MqttliteKeepaliveParms m31721a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23446e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.mqttlite.MqttliteKeepaliveParms.class;
        monitor-enter(r1);
        r0 = f23446e;	 Catch:{ all -> 0x003a }
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
        r0 = m31722b(r0);	 Catch:{ all -> 0x0035 }
        f23446e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23446e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.mqttlite.MqttliteKeepaliveParms.a(com.facebook.inject.InjectorLike):com.facebook.mqttlite.MqttliteKeepaliveParms");
    }

    private static MqttliteKeepaliveParms m31722b(InjectorLike injectorLike) {
        return new MqttliteKeepaliveParms(FbTelephonyManager.m31732b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), MqttConnectionConfigManager.m31664a(injectorLike));
    }

    @Inject
    public MqttliteKeepaliveParms(FbTelephonyManager fbTelephonyManager, QeAccessor qeAccessor, MqttConnectionConfigManager mqttConnectionConfigManager) {
        this.f23447a = fbTelephonyManager;
        this.f23449c = qeAccessor;
        this.f23448b = mqttConnectionConfigManager;
    }

    public final int m31723a() {
        int a = this.f23449c.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForKeepaliveExperimentModule.f23609e, 0);
        if (a == 0) {
            return 0;
        }
        if (a == 2) {
            Object a2 = this.f23447a.m31741a(0);
            if (a2 != null) {
                a2 = a2.toLowerCase();
            }
            String a3 = this.f23449c.mo585a(Liveness.Cached, ExposureLogging.Off, ExperimentsForKeepaliveExperimentModule.f23607c, "");
            if (a3.isEmpty()) {
                return 0;
            }
            for (String equals : a3.toLowerCase().split(";")) {
                if (equals.equals(a2)) {
                    this.f23449c.mo589a(Liveness.Cached, ExperimentsForKeepaliveExperimentModule.f23609e);
                    return a;
                }
            }
            return 0;
        }
        this.f23449c.mo589a(Liveness.Cached, ExperimentsForKeepaliveExperimentModule.f23609e);
        return a;
    }

    public final int m31725b() {
        return this.f23448b.b().q;
    }

    public final int m31726c() {
        return this.f23449c.mo574a(Liveness.Cached, ExposureLogging.Off, ExperimentsForKeepaliveExperimentModule.f23608d, m31725b());
    }

    public final boolean m31727d() {
        return this.f23450d;
    }

    public final void m31724a(boolean z) {
        this.f23450d = z;
    }

    public final int m31728e() {
        return this.f23449c.mo572a(ExperimentsForKeepaliveExperimentModule.f23610f, this.f23448b.b().p);
    }

    public final boolean m31729f() {
        return this.f23449c.mo596a(ExperimentsForKeepaliveExperimentModule.f23612h, true);
    }
}
