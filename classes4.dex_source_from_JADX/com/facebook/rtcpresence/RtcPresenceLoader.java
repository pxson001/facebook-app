package com.facebook.rtcpresence;

import android.util.Pair;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.push.mqtt.service.MqttPushServiceClientManager;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import com.facebook.push.mqtt.service.response.MqttResponseManager;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: session_id = ? */
public class RtcPresenceLoader {
    public static final Class<?> f2530a = RtcPresenceLoader.class;
    private static final Map<UserKey, List<RtcPresenceFetcherListener>> f2531b = new HashMap();
    private static final List<Pair<Set<UserKey>, RtcPresenceFetcherListener>> f2532c = new ArrayList();
    public static final Set<UserKey> f2533d = new HashSet();
    private static volatile RtcPresenceLoader f2534n;
    private final ListeningExecutorService f2535e;
    public final AbstractSingleMethodRunner f2536f;
    public final RtcPresenceMethod f2537g;
    private final DefaultAndroidThreadUtil f2538h;
    public final MqttPushServiceClientManagerImpl f2539i;
    private final Provider<Boolean> f2540j;
    public final MqttResponseManager f2541k;
    public final RtcPresenceMqttHelper f2542l;
    public final RtcPresenceDecoder f2543m;

    public static com.facebook.rtcpresence.RtcPresenceLoader m2819a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2534n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtcpresence.RtcPresenceLoader.class;
        monitor-enter(r1);
        r0 = f2534n;	 Catch:{ all -> 0x003a }
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
        r0 = m2823b(r0);	 Catch:{ all -> 0x0035 }
        f2534n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2534n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtcpresence.RtcPresenceLoader.a(com.facebook.inject.InjectorLike):com.facebook.rtcpresence.RtcPresenceLoader");
    }

    private static RtcPresenceLoader m2823b(InjectorLike injectorLike) {
        return new RtcPresenceLoader((ListeningExecutorService) IdleExecutor_DefaultIdleExecutorMethodAutoProvider.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new RtcPresenceMethod(RtcPresenceDecoder.m2830b(injectorLike)), DefaultAndroidThreadUtil.b(injectorLike), MqttPushServiceClientManagerImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4310), MqttResponseManager.a(injectorLike), RtcPresenceMqttHelper.m2834a(injectorLike), RtcPresenceDecoder.m2830b(injectorLike));
    }

    @Inject
    public RtcPresenceLoader(ListeningExecutorService listeningExecutorService, SingleMethodRunner singleMethodRunner, RtcPresenceMethod rtcPresenceMethod, AndroidThreadUtil androidThreadUtil, MqttPushServiceClientManager mqttPushServiceClientManager, Provider<Boolean> provider, MqttResponseManager mqttResponseManager, RtcPresenceMqttHelper rtcPresenceMqttHelper, RtcPresenceDecoder rtcPresenceDecoder) {
        this.f2535e = listeningExecutorService;
        this.f2536f = singleMethodRunner;
        this.f2537g = rtcPresenceMethod;
        this.f2538h = androidThreadUtil;
        this.f2539i = mqttPushServiceClientManager;
        this.f2540j = provider;
        this.f2541k = mqttResponseManager;
        this.f2542l = rtcPresenceMqttHelper;
        this.f2543m = rtcPresenceDecoder;
    }

    public final synchronized void m2826a(UserKey userKey, RtcPresenceFetcherListener rtcPresenceFetcherListener) {
        if (f2531b.containsKey(userKey)) {
            ((List) f2531b.get(userKey)).add(rtcPresenceFetcherListener);
        } else {
            List arrayList = new ArrayList();
            arrayList.add(rtcPresenceFetcherListener);
            f2531b.put(userKey, arrayList);
            if (!f2533d.contains(userKey)) {
                Set hashSet = new HashSet();
                hashSet.add(userKey);
                this.f2538h.a(m2821a(hashSet), new PresenceCallback(this, hashSet));
            }
        }
    }

    public final synchronized void m2827a(ImmutableSet<UserKey> immutableSet, RtcPresenceFetcherListener rtcPresenceFetcherListener) {
        Set hashSet = new HashSet(immutableSet);
        hashSet.removeAll(f2533d);
        f2533d.addAll(hashSet);
        f2532c.add(new Pair(hashSet, rtcPresenceFetcherListener));
        this.f2538h.a(m2821a(hashSet), new PresenceCallback(this, hashSet));
    }

    private ListenableFuture<RtcPresenceResult> m2821a(Set<UserKey> set) {
        Callable 1;
        ImmutableSet copyOf = ImmutableSet.copyOf(set);
        if (((Boolean) this.f2540j.get()).booleanValue()) {
            1 = new 1(this, copyOf);
        } else {
            1 = new 2(this, copyOf);
        }
        return this.f2535e.a(1);
    }

    public static Map<UserKey, List<RtcPresenceFetcherListener>> m2824e(ImmutableSet<UserKey> immutableSet) {
        Map<UserKey, List<RtcPresenceFetcherListener>> hashMap = new HashMap();
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            UserKey userKey = (UserKey) it.next();
            List list = (List) f2531b.get(userKey);
            if (list != null) {
                hashMap.put(userKey, list);
            }
            f2531b.remove(userKey);
        }
        return hashMap;
    }

    public static Set<RtcPresenceFetcherListener> m2825f(ImmutableSet<UserKey> immutableSet) {
        Set<RtcPresenceFetcherListener> hashSet = new HashSet();
        ArrayList arrayList = new ArrayList(f2532c);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) arrayList.get(i);
            if (((Set) pair.first).removeAll(new HashSet(immutableSet))) {
                hashSet.add(pair.second);
                if (((Set) pair.first).isEmpty()) {
                    f2532c.remove(pair);
                }
            }
        }
        return hashSet;
    }
}
