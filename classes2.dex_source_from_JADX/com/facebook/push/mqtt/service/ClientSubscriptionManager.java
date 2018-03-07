package com.facebook.push.mqtt.service;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.C0259xe99f8445;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.common.executors.SerialListeningExecutorService;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.process.ProcessUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.push.mqtt.IsCombineForegroundAndSubscriptionEnabledProvider;
import com.facebook.push.mqtt.external.PublishedPayloadDescriptor;
import com.facebook.push.mqtt.external.PushStateBroadcaster;
import com.facebook.push.mqtt.ipc.IMqttPushService;
import com.facebook.push.mqtt.ipc.MqttPublishArrivedListener;
import com.facebook.push.mqtt.ipc.MqttPublishArrivedListener.Stub;
import com.facebook.push.mqtt.ipc.StickySubscribeTopic;
import com.facebook.push.mqtt.ipc.StickySubscribeTopic.SubscribeWhen;
import com.facebook.push.mqtt.ipc.SubscribeTopic;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: service_esmobile */
public class ClientSubscriptionManager {
    private static volatile ClientSubscriptionManager f5508o;
    public final DefaultSerialListeningExecutorService f5509a;
    public final PushStateBroadcaster f5510b;
    public final Lazy<ProcessUtil> f5511c;
    private final MqttPublishArrivedListenerStub f5512d = new MqttPublishArrivedListenerStub(this);
    public final TransientSubscriber f5513e = new TransientSubscriber(this.f5512d);
    public final QuietSubscriber f5514f = new QuietSubscriber(this.f5512d);
    private final List<StickySubscribeTopic> f5515g = Lists.m1296a();
    public final MonotonicClock f5516h;
    private final BaseFbBroadcastManager f5517i;
    public final Provider<Boolean> f5518j;
    private boolean f5519k;
    public boolean f5520l;
    public IMqttPushService f5521m;
    public volatile boolean f5522n = false;

    /* compiled from: service_esmobile */
    class MqttPublishArrivedListenerStub extends Stub {
        final /* synthetic */ ClientSubscriptionManager f5530a;

        public MqttPublishArrivedListenerStub(ClientSubscriptionManager clientSubscriptionManager) {
            this.f5530a = clientSubscriptionManager;
        }

        public final void mo1351a(Bundle bundle) {
            PublishedPayloadDescriptor publishedPayloadDescriptor = new PublishedPayloadDescriptor(bundle);
            Integer.valueOf(Binder.getCallingPid());
            publishedPayloadDescriptor.e = this.f5530a.f5516h.now();
            this.f5530a.f5510b.m9411a(publishedPayloadDescriptor, false);
        }

        protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.println(((DefaultProcessUtil) this.f5530a.f5511c.get()).m2389a().b);
        }
    }

    /* compiled from: service_esmobile */
    class TransientSubscriber extends NonStickySubscriber<SubscribeTopic> {
        public TransientSubscriber(MqttPublishArrivedListener mqttPublishArrivedListener) {
            super(mqttPublishArrivedListener);
        }

        protected final void mo1352a(IMqttPushService iMqttPushService, List<SubscribeTopic> list) {
            iMqttPushService.mo3419a(ClientSubscriptionManager.m9397a((Iterable) list), this.f5532b);
        }

        protected final void mo1353b(IMqttPushService iMqttPushService, List<SubscribeTopic> list) {
            List a = Lists.m1296a();
            for (SubscribeTopic subscribeTopic : list) {
                a.add(subscribeTopic.f19455a);
            }
            iMqttPushService.mo3427b(a, this.f5532b);
        }
    }

    /* compiled from: service_esmobile */
    public abstract class NonStickySubscriber<T> {
        private final List<T> f5531a = Lists.m1296a();
        public final MqttPublishArrivedListener f5532b;

        protected abstract void mo1352a(IMqttPushService iMqttPushService, List<T> list);

        protected abstract void mo1353b(IMqttPushService iMqttPushService, List<T> list);

        public NonStickySubscriber(MqttPublishArrivedListener mqttPublishArrivedListener) {
            this.f5532b = mqttPublishArrivedListener;
        }

        public final void m9422a(@Nullable IMqttPushService iMqttPushService, List<T> list, List<T> list2) {
            this.f5531a.addAll(list);
            for (T remove : list2) {
                if (!this.f5531a.remove(remove)) {
                    BLog.a("ClientSubscriptionManager", "Unsubscribed from topic that was not subscribed: '%s'", new Object[]{r0.next()});
                }
            }
            if (iMqttPushService != null) {
                try {
                    getClass().getSimpleName();
                    Iterables.m967c(list);
                    Iterables.m967c(list2);
                    if (!list.isEmpty()) {
                        mo1352a(iMqttPushService, list);
                    }
                    if (!list2.isEmpty()) {
                        mo1353b(iMqttPushService, list2);
                    }
                } catch (RemoteException e) {
                }
            } else if (!list.isEmpty()) {
                getClass().getSimpleName();
                Iterables.m967c(list);
            }
        }

        public final void m9420a(IMqttPushService iMqttPushService) {
            getClass().getSimpleName();
            Iterables.m967c(this.f5531a);
            if (!this.f5531a.isEmpty()) {
                mo1352a(iMqttPushService, this.f5531a);
            }
        }
    }

    /* compiled from: service_esmobile */
    class QuietSubscriber extends NonStickySubscriber<String> {
        protected final void mo1352a(IMqttPushService iMqttPushService, List<String> list) {
            iMqttPushService.mo3430c(list, this.f5532b);
        }

        protected final void mo1353b(IMqttPushService iMqttPushService, List<String> list) {
            iMqttPushService.mo3432d(list, this.f5532b);
        }

        public QuietSubscriber(MqttPublishArrivedListener mqttPublishArrivedListener) {
            super(mqttPublishArrivedListener);
        }
    }

    public static com.facebook.push.mqtt.service.ClientSubscriptionManager m9396a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5508o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqtt.service.ClientSubscriptionManager.class;
        monitor-enter(r1);
        r0 = f5508o;	 Catch:{ all -> 0x003a }
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
        r0 = m9400b(r0);	 Catch:{ all -> 0x0035 }
        f5508o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5508o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.service.ClientSubscriptionManager.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.service.ClientSubscriptionManager");
    }

    private static ClientSubscriptionManager m9400b(InjectorLike injectorLike) {
        return new ClientSubscriptionManager(C0259xe99f8445.m9408b(injectorLike), PushStateBroadcaster.m9409a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 594), IsCombineForegroundAndSubscriptionEnabledProvider.m9413a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike));
    }

    @Inject
    public ClientSubscriptionManager(SerialListeningExecutorService serialListeningExecutorService, PushStateBroadcaster pushStateBroadcaster, MonotonicClock monotonicClock, Lazy<ProcessUtil> lazy, IsCombineForegroundAndSubscriptionEnabledProvider isCombineForegroundAndSubscriptionEnabledProvider, FbBroadcastManager fbBroadcastManager) {
        this.f5509a = serialListeningExecutorService;
        this.f5510b = pushStateBroadcaster;
        this.f5516h = monotonicClock;
        this.f5511c = lazy;
        this.f5518j = isCombineForegroundAndSubscriptionEnabledProvider;
        this.f5517i = fbBroadcastManager;
    }

    public final ListenableFuture<?> m9405a(boolean z, Collection<SubscribeTopic> collection, Collection<SubscribeTopic> collection2) {
        ImmutableList copyOf = ImmutableList.copyOf((Collection) collection);
        ImmutableList copyOf2 = ImmutableList.copyOf((Collection) collection2);
        this.f5522n = z;
        Boolean.valueOf(z);
        m9403c(collection, collection2);
        return this.f5509a.mo269a(new 1(this, copyOf, copyOf2));
    }

    public final ListenableFuture<?> m9404a(Collection<SubscribeTopic> collection, Collection<SubscribeTopic> collection2) {
        final Object copyOf = ImmutableList.copyOf((Collection) collection);
        final Object copyOf2 = ImmutableList.copyOf((Collection) collection2);
        m9403c(copyOf, copyOf2);
        return this.f5509a.mo269a(new Runnable(this) {
            final /* synthetic */ ClientSubscriptionManager f19459c;

            public void run() {
                this.f19459c.f5513e.m9422a(this.f19459c.f5521m, copyOf, copyOf2);
            }
        });
    }

    @Deprecated
    private void m9403c(Collection<SubscribeTopic> collection, Collection<SubscribeTopic> collection2) {
        for (SubscribeTopic subscribeTopic : collection2) {
            String str = subscribeTopic.f19455a;
            if (Objects.equal(str, "/t_p") || Objects.equal(str, "/t_sp")) {
                m9399a(str, "ACTION_CLIENT_PRESENCE_TOPIC_UNSUBSCRIBE");
            }
        }
        for (SubscribeTopic subscribeTopic2 : collection) {
            str = subscribeTopic2.f19455a;
            if (Objects.equal(str, "/t_p") || Objects.equal(str, "/t_sp")) {
                m9399a(str, "ACTION_CLIENT_PRESENCE_TOPIC_SUBSCRIBE");
            }
        }
    }

    public final ListenableFuture<?> m9406b(Collection<String> collection, Collection<String> collection2) {
        return this.f5509a.mo269a(new 3(this, ImmutableList.copyOf((Collection) collection), ImmutableList.copyOf((Collection) collection2)));
    }

    private void m9399a(String str, String str2) {
        Intent intent = new Intent(str2);
        intent.putExtra("DESC_PRESENCE_TOPIC_NAME", str);
        this.f5517i.mo406a(intent);
    }

    public static void m9402b(ClientSubscriptionManager clientSubscriptionManager, List list) {
        if (!clientSubscriptionManager.f5519k || !Objects.equal(clientSubscriptionManager.f5515g, list)) {
            clientSubscriptionManager.f5519k = true;
            clientSubscriptionManager.f5515g.clear();
            clientSubscriptionManager.f5515g.addAll(list);
            clientSubscriptionManager.f5520l = false;
            try {
                m9401b(clientSubscriptionManager);
            } catch (RemoteException e) {
            }
        }
    }

    public static void m9401b(ClientSubscriptionManager clientSubscriptionManager) {
        if (clientSubscriptionManager.f5521m != null && !clientSubscriptionManager.f5520l && clientSubscriptionManager.f5519k) {
            clientSubscriptionManager.f5521m.mo3418a(m9398a(clientSubscriptionManager.f5515g, clientSubscriptionManager.f5512d));
            clientSubscriptionManager.f5520l = true;
        }
    }

    @VisibleForTesting
    private static List<StickySubscribeTopic> m9398a(List<StickySubscribeTopic> list, MqttPublishArrivedListener mqttPublishArrivedListener) {
        List<StickySubscribeTopic> a = Lists.m1296a();
        for (StickySubscribeTopic stickySubscribeTopic : list) {
            a.add(new StickySubscribeTopic(m9395a(stickySubscribeTopic.a), SubscribeWhen.fromOrdinal(stickySubscribeTopic.b.ordinal()), stickySubscribeTopic.c, mqttPublishArrivedListener));
        }
        return a;
    }

    @VisibleForTesting
    static List<SubscribeTopic> m9397a(Iterable<SubscribeTopic> iterable) {
        List<SubscribeTopic> a = Lists.m1296a();
        for (SubscribeTopic a2 : iterable) {
            a.add(m9395a(a2));
        }
        return a;
    }

    public static SubscribeTopic m9395a(SubscribeTopic subscribeTopic) {
        return new SubscribeTopic(subscribeTopic.f19455a, subscribeTopic.f19456b);
    }
}
