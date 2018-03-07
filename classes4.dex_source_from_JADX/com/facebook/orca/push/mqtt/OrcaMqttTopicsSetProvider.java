package com.facebook.orca.push.mqtt;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.push.mqtt.persistence.MqttSubscriptionPersistence;
import com.facebook.push.mqtt.service.IProvideSubscribeTopics;
import com.facebook.push.mqtt.service.MqttDynamicTopic;
import com.facebook.push.mqtt.service.MqttDynamicTopicsSetProvider;
import com.facebook.push.mqtt.service.SubscribeTopic;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: hot */
public class OrcaMqttTopicsSetProvider implements IProvideSubscribeTopics {
    private static volatile OrcaMqttTopicsSetProvider f10741j;
    private final Provider<Boolean> f10742a;
    private final Provider<Boolean> f10743b;
    private final Provider<Boolean> f10744c;
    private final Provider<Boolean> f10745d;
    private final Provider<Boolean> f10746e;
    private final boolean f10747f;
    private final GatekeeperStoreImpl f10748g;
    private final Product f10749h;
    private final MqttDynamicTopicsSetProvider f10750i;

    public static com.facebook.orca.push.mqtt.OrcaMqttTopicsSetProvider m11187a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10741j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.push.mqtt.OrcaMqttTopicsSetProvider.class;
        monitor-enter(r1);
        r0 = f10741j;	 Catch:{ all -> 0x003a }
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
        r0 = m11188b(r0);	 Catch:{ all -> 0x0035 }
        f10741j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10741j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.push.mqtt.OrcaMqttTopicsSetProvider.a(com.facebook.inject.InjectorLike):com.facebook.orca.push.mqtt.OrcaMqttTopicsSetProvider");
    }

    private static OrcaMqttTopicsSetProvider m11188b(InjectorLike injectorLike) {
        return new OrcaMqttTopicsSetProvider(IdBasedProvider.a(injectorLike, 4069), IdBasedProvider.a(injectorLike, 4269), IdBasedProvider.a(injectorLike, 4267), IdBasedProvider.a(injectorLike, 4272), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), MqttDynamicTopicsSetProvider.m7796a(injectorLike), IdBasedProvider.a(injectorLike, 4288));
    }

    @Inject
    OrcaMqttTopicsSetProvider(Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Boolean bool, GatekeeperStore gatekeeperStore, Product product, MqttDynamicTopicsSetProvider mqttDynamicTopicsSetProvider, Provider<Boolean> provider5) {
        this.f10742a = provider;
        this.f10743b = provider2;
        this.f10744c = provider3;
        this.f10745d = provider4;
        this.f10749h = product;
        this.f10747f = bool.booleanValue();
        this.f10748g = gatekeeperStore;
        this.f10750i = mqttDynamicTopicsSetProvider;
        this.f10746e = provider5;
    }

    public ImmutableMap<SubscribeTopic, MqttSubscriptionPersistence> get() {
        Map hashMap = new HashMap();
        if (!((Boolean) this.f10744c.get()).booleanValue()) {
            if (((Boolean) this.f10743b.get()).booleanValue()) {
                hashMap.put(new SubscribeTopic("/t_sp", 0), MqttSubscriptionPersistence.APP_USE);
            } else {
                hashMap.put(new SubscribeTopic("/t_p", 0), MqttSubscriptionPersistence.APP_USE);
            }
        }
        if (!this.f10748g.a(165, false)) {
            String str = ((Boolean) this.f10746e.get()).booleanValue() ? "/t_inbox" : "/inbox";
            if (((Boolean) this.f10742a.get()).booleanValue() && !this.f10747f) {
                hashMap.put(new SubscribeTopic(str, 0), MqttSubscriptionPersistence.DEVICE_USE);
            } else if (this.f10749h == Product.MESSENGER) {
                hashMap.put(new SubscribeTopic(str, 0), MqttSubscriptionPersistence.APP_USE);
            }
        }
        hashMap.put(new SubscribeTopic(((Boolean) this.f10745d.get()).booleanValue() ? "/t_push" : "/push_notification", 0), MqttSubscriptionPersistence.ALWAYS);
        hashMap.put(new SubscribeTopic("/pp", 0), MqttSubscriptionPersistence.ALWAYS);
        Iterator it = ImmutableSet.copyOf(this.f10750i.f7477a).iterator();
        while (it.hasNext()) {
            MqttDynamicTopic mqttDynamicTopic = (MqttDynamicTopic) it.next();
            if (mqttDynamicTopic.c) {
                hashMap.put(mqttDynamicTopic.a, mqttDynamicTopic.b);
            }
        }
        return ImmutableMap.copyOf(hashMap);
    }
}
