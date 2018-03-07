package com.facebook.push.mqtt.service;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.init.INeedInit;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mqttlite.Handler_MqttThreadMethodAutoProvider;
import com.facebook.push.mqtt.IsCombineForegroundAndSubscriptionEnabledProvider;
import com.facebook.push.mqtt.external.MqttThread;
import com.facebook.push.mqtt.persistence.MqttSubscriptionPersistence;
import com.facebook.push.mqtt.service.StickySubscribeTopic.SubscribeWhen;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mqtt_service_state */
public class ClientSubscriptionAutoSubscriber extends AbstractAuthComponent implements INeedInit, MqttClientStateChangeListener {
    private static final Predicate<MqttSubscriptionPersistence> f7462a = new C03572(ImmutableList.copyOf(new MqttSubscriptionPersistence[]{MqttSubscriptionPersistence.DEVICE_USE, MqttSubscriptionPersistence.ALWAYS}));
    private static volatile ClientSubscriptionAutoSubscriber f7463j;
    private final BaseFbBroadcastManager f7464b;
    private final Lazy<ClientSubscriptionManager> f7465c;
    private final Lazy<Set<IProvideSubscribeTopics>> f7466d;
    private final Provider<Boolean> f7467e;
    @MqttThread
    private final Handler f7468f;
    @GuardedBy("this")
    private final Set<SubscribeTopic> f7469g = Sets.a();
    @GuardedBy("this")
    private boolean f7470h;
    @GuardedBy("this")
    private boolean f7471i;

    /* compiled from: mqtt_service_state */
    public final class C03572 implements Predicate<T> {
        final /* synthetic */ ImmutableList f7472a;

        public C03572(ImmutableList immutableList) {
            this.f7472a = immutableList;
        }

        public final boolean apply(Object obj) {
            return this.f7472a.contains((Comparable) obj);
        }
    }

    /* compiled from: mqtt_service_state */
    class C04861 implements ActionReceiver {
        final /* synthetic */ ClientSubscriptionAutoSubscriber f10655a;

        C04861(ClientSubscriptionAutoSubscriber clientSubscriptionAutoSubscriber) {
            this.f10655a = clientSubscriptionAutoSubscriber;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 432171115);
            this.f10655a.m7784i();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1301241883, a);
        }
    }

    /* compiled from: mqtt_service_state */
    public final class C05043 implements Predicate<T> {
        final /* synthetic */ Comparable f10767a;

        public C05043(Comparable comparable) {
            this.f10767a = comparable;
        }

        public final boolean apply(@Nullable Object obj) {
            Comparable comparable = (Comparable) obj;
            Comparable comparable2 = this.f10767a;
            Preconditions.checkNotNull(comparable);
            Preconditions.checkNotNull(comparable2);
            return comparable.compareTo(comparable2) >= 0;
        }
    }

    public static com.facebook.push.mqtt.service.ClientSubscriptionAutoSubscriber m7773a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7463j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqtt.service.ClientSubscriptionAutoSubscriber.class;
        monitor-enter(r1);
        r0 = f7463j;	 Catch:{ all -> 0x003a }
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
        r0 = m7778b(r0);	 Catch:{ all -> 0x0035 }
        f7463j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7463j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.service.ClientSubscriptionAutoSubscriber.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.service.ClientSubscriptionAutoSubscriber");
    }

    private static ClientSubscriptionAutoSubscriber m7778b(InjectorLike injectorLike) {
        return new ClientSubscriptionAutoSubscriber((BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3197), DefaultMqttTopicListProvider.m7794a(injectorLike), IsCombineForegroundAndSubscriptionEnabledProvider.a(injectorLike), Handler_MqttThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ClientSubscriptionAutoSubscriber(FbBroadcastManager fbBroadcastManager, Lazy<ClientSubscriptionManager> lazy, MqttTopicListProvider mqttTopicListProvider, IsCombineForegroundAndSubscriptionEnabledProvider isCombineForegroundAndSubscriptionEnabledProvider, Handler handler) {
        this.f7465c = lazy;
        this.f7464b = fbBroadcastManager;
        this.f7466d = mqttTopicListProvider.f7474a;
        this.f7467e = isCombineForegroundAndSubscriptionEnabledProvider;
        this.f7468f = handler;
    }

    public void init() {
        this.f7464b.a().a("com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE", new C04861(this)).a(this.f7468f).a().b();
    }

    final synchronized void m7784i() {
        m7775a(null);
    }

    private synchronized void m7775a(Boolean bool) {
        Map o = m7780o();
        m7777a(o);
        m7776a(bool, o);
    }

    @GuardedBy("this")
    private void m7777a(Map<SubscribeTopic, MqttSubscriptionPersistence> map) {
        Map a = Maps.a(map, f7462a);
        Builder builder = ImmutableList.builder();
        for (Entry entry : a.entrySet()) {
            builder.c(m7774a((SubscribeTopic) entry.getKey(), (MqttSubscriptionPersistence) entry.getValue()));
        }
        ClientSubscriptionManager clientSubscriptionManager = (ClientSubscriptionManager) this.f7465c.get();
        ListenableFuture a2 = clientSubscriptionManager.a.a(new ClientSubscriptionManager$4(clientSubscriptionManager, ImmutableList.copyOf(builder.b())));
    }

    private static StickySubscribeTopic m7774a(SubscribeTopic subscribeTopic, MqttSubscriptionPersistence mqttSubscriptionPersistence) {
        SubscribeWhen subscribeWhen;
        switch (mqttSubscriptionPersistence) {
            case ALWAYS:
                subscribeWhen = SubscribeWhen.SUBSCRIBE_ALWAYS;
                break;
            case DEVICE_USE:
                subscribeWhen = SubscribeWhen.SUBSCRIBE_ON_DEVICE_USE;
                break;
            default:
                throw new IllegalArgumentException("Unsupported persistence=" + mqttSubscriptionPersistence);
        }
        return new StickySubscribeTopic(subscribeTopic, subscribeWhen, "com.facebook.push.mqtt.category.SAME_APP");
    }

    @GuardedBy("this")
    private void m7776a(Boolean bool, Map<SubscribeTopic, MqttSubscriptionPersistence> map) {
        Collection b = m7779b((Map) map);
        SetView c = Sets.c(b, this.f7469g);
        SetView c2 = Sets.c(this.f7469g, b);
        if (!((Boolean) this.f7467e.get()).booleanValue() || bool == null) {
            ((ClientSubscriptionManager) this.f7465c.get()).a(c, c2);
        } else {
            ((ClientSubscriptionManager) this.f7465c.get()).a(bool.booleanValue(), c, c2);
        }
        this.f7469g.clear();
        this.f7469g.addAll(b);
    }

    private Set<SubscribeTopic> m7779b(Map<SubscribeTopic, MqttSubscriptionPersistence> map) {
        return Maps.a(map, Predicates.and(Predicates.not(f7462a), new C05043(m7781p()))).keySet();
    }

    private ImmutableMap<SubscribeTopic, MqttSubscriptionPersistence> m7780o() {
        HashSet a = Sets.a();
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (IProvideSubscribeTopics iProvideSubscribeTopics : (Set) this.f7466d.get()) {
            ImmutableMap immutableMap = iProvideSubscribeTopics.get();
            Iterator it = immutableMap.keySet().iterator();
            while (it.hasNext()) {
                SubscribeTopic subscribeTopic = (SubscribeTopic) it.next();
                if (a.contains(subscribeTopic.a)) {
                    throw new IllegalStateException("Duplicate topics not allowed at this time: " + subscribeTopic.a);
                }
                a.add(subscribeTopic.a);
                builder.b(subscribeTopic, immutableMap.get(subscribeTopic));
            }
        }
        return builder.b();
    }

    @VisibleForTesting
    private synchronized MqttSubscriptionPersistence m7781p() {
        MqttSubscriptionPersistence mqttSubscriptionPersistence;
        if (this.f7470h) {
            mqttSubscriptionPersistence = MqttSubscriptionPersistence.APP_USE;
        } else if (this.f7471i) {
            mqttSubscriptionPersistence = MqttSubscriptionPersistence.DEVICE_USE;
        } else {
            mqttSubscriptionPersistence = MqttSubscriptionPersistence.ALWAYS;
        }
        return mqttSubscriptionPersistence;
    }

    @Nullable
    final synchronized Set<SubscribeTopic> m7785j() {
        return this.f7469g;
    }

    public final synchronized void mo614k() {
        this.f7471i = true;
        m7784i();
    }

    public final synchronized void mo615l() {
        this.f7470h = true;
        m7775a(Boolean.valueOf(true));
    }

    public final synchronized void mo616m() {
        this.f7470h = false;
        m7775a(Boolean.valueOf(false));
    }

    public final synchronized void mo617n() {
        this.f7471i = false;
        m7784i();
    }

    public final void m7783c() {
        m7784i();
    }

    public final void m7782a(@Nullable AuthenticationResult authenticationResult) {
        m7784i();
    }
}
