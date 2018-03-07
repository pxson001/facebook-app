package com.facebook.push.mqtt.external;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.facebook.push.mqtt.ipc.MqttChannelStateInfo;
import com.facebook.push.mqtt.ipc.MqttChannelStateListener;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: foreground_release_notes */
public class ServiceChannelStateListenerManager {
    private static volatile ServiceChannelStateListenerManager f23430c;
    public final Map<IBinder, MqttChannelStateListener> f23431a = new HashMap();
    private final Map<IBinder, DeathRecipient> f23432b = new HashMap();

    public static com.facebook.push.mqtt.external.ServiceChannelStateListenerManager m31701a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f23430c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.push.mqtt.external.ServiceChannelStateListenerManager.class;
        monitor-enter(r1);
        r0 = f23430c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m31702b();	 Catch:{ all -> 0x0034 }
        f23430c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f23430c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.external.ServiceChannelStateListenerManager.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.external.ServiceChannelStateListenerManager");
    }

    private static ServiceChannelStateListenerManager m31702b() {
        return new ServiceChannelStateListenerManager();
    }

    public final synchronized void m31705a(MqttChannelStateListener mqttChannelStateListener) {
        IBinder asBinder = mqttChannelStateListener.asBinder();
        if (!this.f23431a.containsKey(asBinder)) {
            1 1 = new 1(this, asBinder);
            mqttChannelStateListener.asBinder().linkToDeath(1, 0);
            this.f23431a.put(asBinder, mqttChannelStateListener);
            this.f23432b.put(asBinder, 1);
        }
    }

    public final synchronized void m31706b(MqttChannelStateListener mqttChannelStateListener) {
        IBinder asBinder = mqttChannelStateListener.asBinder();
        DeathRecipient deathRecipient = (DeathRecipient) this.f23432b.remove(asBinder);
        this.f23431a.remove(asBinder);
        if (deathRecipient != null) {
            asBinder.unlinkToDeath(deathRecipient, 0);
        }
    }

    public final synchronized void m31704a(MqttChannelStateInfo mqttChannelStateInfo) {
        for (MqttChannelStateListener a : this.f23431a.values()) {
            try {
                a.mo1826a(mqttChannelStateInfo);
            } catch (RemoteException e) {
            }
        }
    }

    public final synchronized void m31703a() {
        for (MqttChannelStateListener a : this.f23431a.values()) {
            try {
                a.mo1825a();
            } catch (RemoteException e) {
            }
        }
    }
}
