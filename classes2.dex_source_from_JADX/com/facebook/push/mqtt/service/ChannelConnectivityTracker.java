package com.facebook.push.mqtt.service;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.push.mqtt.external.PushStateBroadcaster;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.facebook.push.mqtt.ipc.MqttChannelStateInfo;
import com.facebook.push.mqtt.ipc.MqttChannelStateInfo.ConnectionState;
import com.facebook.push.mqtt.ipc.MqttChannelStateListener.Stub;
import com.facebook.push.mqtt.service.response.SimpleMqttPushServiceClientFlightRecorderEvent;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: properties */
public class ChannelConnectivityTracker {
    private static volatile ChannelConnectivityTracker f8724j;
    private final MqttChannelStateListenerStub f8725a;
    public final PushStateBroadcaster f8726b;
    public final MqttPushServiceClientFlightRecorder f8727c;
    public final MonotonicClock f8728d;
    @GuardedBy("this")
    private ConnectionState f8729e;
    @GuardedBy("this")
    private long f8730f;
    @GuardedBy("this")
    private long f8731g;
    @GuardedBy("this")
    private long f8732h;
    @GuardedBy("this")
    private boolean f8733i;

    /* compiled from: properties */
    class MqttChannelStateListenerStub extends Stub {
        final /* synthetic */ ChannelConnectivityTracker f8734a;

        public MqttChannelStateListenerStub(ChannelConnectivityTracker channelConnectivityTracker) {
            this.f8734a = channelConnectivityTracker;
        }

        public final void mo1826a(MqttChannelStateInfo mqttChannelStateInfo) {
            long now = this.f8734a.f8728d.now();
            this.f8734a.f8727c.m4455a(new SimpleMqttPushServiceClientFlightRecorderEvent(now, "Received channel state changed: %s", new Object[]{mqttChannelStateInfo.toString()}));
            this.f8734a.m13548a(mqttChannelStateInfo);
        }

        public final void mo1825a() {
            this.f8734a.f8727c.m4455a(new SimpleMqttPushServiceClientFlightRecorderEvent(this.f8734a.f8728d.now(), "Keepalive sent", new Object[0]));
            this.f8734a.f8726b.m9412a(PushStateEvent.KEEPALIVE_SENT);
        }
    }

    public static com.facebook.push.mqtt.service.ChannelConnectivityTracker m13542a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8724j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqtt.service.ChannelConnectivityTracker.class;
        monitor-enter(r1);
        r0 = f8724j;	 Catch:{ all -> 0x003a }
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
        r0 = m13545b(r0);	 Catch:{ all -> 0x0035 }
        f8724j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8724j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.service.ChannelConnectivityTracker.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.service.ChannelConnectivityTracker");
    }

    private static ChannelConnectivityTracker m13545b(InjectorLike injectorLike) {
        return new ChannelConnectivityTracker(PushStateBroadcaster.m9409a(injectorLike), MqttPushServiceClientFlightRecorder.m4462a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public ChannelConnectivityTracker(PushStateBroadcaster pushStateBroadcaster, MqttPushServiceClientFlightRecorder mqttPushServiceClientFlightRecorder, MonotonicClock monotonicClock) {
        synchronized (this) {
            this.f8729e = ConnectionState.DISCONNECTED;
            this.f8731g = -1;
            this.f8732h = -1;
            this.f8733i = false;
        }
        this.f8725a = new MqttChannelStateListenerStub(this);
        this.f8726b = pushStateBroadcaster;
        this.f8727c = mqttPushServiceClientFlightRecorder;
        this.f8728d = monotonicClock;
    }

    final Stub m13547a() {
        return this.f8725a;
    }

    public final synchronized ConnectionState m13549b() {
        return this.f8729e;
    }

    public final synchronized long m13550c() {
        return this.f8731g;
    }

    public final synchronized long m13551d() {
        return this.f8732h;
    }

    public final synchronized boolean m13552e() {
        return this.f8729e == ConnectionState.CONNECTED;
    }

    public final synchronized boolean m13553f() {
        boolean z;
        z = m13552e() || this.f8729e == ConnectionState.CONNECTING;
        return z;
    }

    @VisibleForTesting
    final synchronized void m13548a(MqttChannelStateInfo mqttChannelStateInfo) {
        if (mqttChannelStateInfo.m32033b() >= this.f8730f) {
            this.f8730f = mqttChannelStateInfo.m32033b();
            m13544a(m13543a(mqttChannelStateInfo.m32032a()), mqttChannelStateInfo.m32034c(), mqttChannelStateInfo.m32035d(), mqttChannelStateInfo.m32036e());
        }
    }

    private synchronized void m13544a(ConnectionState connectionState, long j, long j2, boolean z) {
        ConnectionState connectionState2 = this.f8729e;
        this.f8729e = connectionState;
        this.f8731g = j;
        this.f8732h = j2;
        this.f8733i = z;
        if (this.f8729e != connectionState2) {
            m13546h();
        }
    }

    private synchronized void m13546h() {
        PushStateEvent pushStateEvent;
        switch (1.a[this.f8729e.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                pushStateEvent = PushStateEvent.CHANNEL_CONNECTING;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                pushStateEvent = PushStateEvent.CHANNEL_CONNECTED;
                break;
            case 3:
                pushStateEvent = PushStateEvent.CHANNEL_DISCONNECTED;
                if (this.f8733i) {
                    pushStateEvent.setClockSkewDetected(true);
                    break;
                }
                break;
            default:
                throw new IllegalStateException(StringLocaleUtil.m21640a("Received a state I did not expect %s", this.f8729e));
        }
        this.f8726b.m9412a(pushStateEvent);
    }

    public final synchronized void m13554g() {
        m13544a(ConnectionState.DISCONNECTED, this.f8731g, this.f8728d.now(), false);
    }

    private static ConnectionState m13543a(ConnectionState connectionState) {
        switch (1.b[connectionState.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return ConnectionState.CONNECTED;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return ConnectionState.CONNECTING;
            case 3:
                return ConnectionState.DISCONNECTED;
            default:
                throw new IllegalStateException(StringLocaleUtil.m21640a("Received a state I did not expect %s", connectionState));
        }
    }
}
