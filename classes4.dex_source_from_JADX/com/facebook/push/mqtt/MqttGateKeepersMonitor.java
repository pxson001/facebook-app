package com.facebook.push.mqtt;

import com.facebook.common.init.INeedInit;
import com.facebook.gk.GatekeeperStoreConfigMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.listeners.GatekeeperListenersImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperListeners;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreConfig;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.OnGatekeeperChangeListener;
import com.facebook.gk.store.internal.GatekeeperListenersImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: http_failure_status_code */
public class MqttGateKeepersMonitor implements INeedInit {
    public static final String f10589a = MqttGateKeepersMonitor.class.getSimpleName();
    private static final PrefKey f10590b;
    public static final PrefKey f10591c;
    private static final int[] f10592d = new int[]{374};
    private static volatile MqttGateKeepersMonitor f10593k;
    private final GatekeeperStoreImpl f10594e;
    private final GatekeeperListenersImpl f10595f;
    public final GatekeeperStoreConfig f10596g;
    public final FbSharedPreferences f10597h;
    private final Provider<Boolean> f10598i;
    private final OnGatekeeperChangeListener f10599j = new C04831(this);

    /* compiled from: http_failure_status_code */
    class C04831 extends OnGatekeeperChangeListener {
        final /* synthetic */ MqttGateKeepersMonitor f10600a;

        C04831(MqttGateKeepersMonitor mqttGateKeepersMonitor) {
            this.f10600a = mqttGateKeepersMonitor;
        }

        public final void m11129a(GatekeeperStoreImpl gatekeeperStoreImpl, int i) {
            String str = (String) this.f10600a.f10596g.b().get(i);
            String name = gatekeeperStoreImpl.a(i).name();
            String str2 = MqttGateKeepersMonitor.f10589a;
            this.f10600a.f10597h.edit().a((PrefKey) MqttGateKeepersMonitor.f10591c.a(str), name).commit();
        }
    }

    public static com.facebook.push.mqtt.MqttGateKeepersMonitor m11127a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10593k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqtt.MqttGateKeepersMonitor.class;
        monitor-enter(r1);
        r0 = f10593k;	 Catch:{ all -> 0x003a }
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
        r0 = m11128b(r0);	 Catch:{ all -> 0x0035 }
        f10593k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10593k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.MqttGateKeepersMonitor.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.MqttGateKeepersMonitor");
    }

    private static MqttGateKeepersMonitor m11128b(InjectorLike injectorLike) {
        return new MqttGateKeepersMonitor(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GatekeeperListenersImplMethodAutoProvider.a(injectorLike), GatekeeperStoreConfigMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4287));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("mqtt");
        f10590b = prefKey;
        f10591c = (PrefKey) prefKey.a("snapshot_gks");
    }

    @Inject
    public MqttGateKeepersMonitor(GatekeeperStore gatekeeperStore, GatekeeperListeners gatekeeperListeners, GatekeeperStoreConfig gatekeeperStoreConfig, FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider) {
        this.f10594e = gatekeeperStore;
        this.f10595f = gatekeeperListeners;
        this.f10596g = gatekeeperStoreConfig;
        this.f10597h = fbSharedPreferences;
        this.f10598i = provider;
    }

    public void init() {
        if (((Boolean) this.f10598i.get()).booleanValue()) {
            this.f10595f.a(this.f10599j, f10592d);
            Editor edit = this.f10597h.edit();
            for (int i : f10592d) {
                edit.a((PrefKey) f10591c.a((String) this.f10596g.b().get(i)), this.f10594e.a(i).name());
            }
            edit.commit();
        }
    }
}
