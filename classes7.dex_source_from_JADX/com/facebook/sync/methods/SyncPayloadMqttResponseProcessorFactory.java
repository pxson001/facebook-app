package com.facebook.sync.methods;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.push.mqtt.service.ClientSubscriptionManager;
import com.facebook.push.mqtt.service.response.MqttResponseProcessor;
import com.facebook.sync.model.MqttThriftHeaderDeserialization;
import com.facebook.thrift.TException;
import com.google.common.base.Throwables;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: feed_inline_comments */
public class SyncPayloadMqttResponseProcessorFactory {
    private static volatile SyncPayloadMqttResponseProcessorFactory f14526e;
    private final BaseFbBroadcastManager f14527a;
    private final MonotonicClock f14528b;
    private final ClientSubscriptionManager f14529c;
    private final MqttThriftHeaderDeserialization f14530d;

    /* compiled from: feed_inline_comments */
    public interface SyncPayloadCallback<RESPONSE, PAYLOAD> {
        PAYLOAD m18423a(byte[] bArr, int i);

        boolean m18424a(PAYLOAD payload);

        RESPONSE m18425b(PAYLOAD payload);
    }

    /* compiled from: feed_inline_comments */
    class SyncPayloadMqttResponseProcessor<RESPONSE, PAYLOAD> extends MqttResponseProcessor<RESPONSE> {
        final /* synthetic */ SyncPayloadMqttResponseProcessorFactory f14523b;
        @Nullable
        private PAYLOAD f14524c;
        private SyncPayloadCallback<RESPONSE, PAYLOAD> f14525d;

        public SyncPayloadMqttResponseProcessor(SyncPayloadMqttResponseProcessorFactory syncPayloadMqttResponseProcessorFactory, String str, FbBroadcastManager fbBroadcastManager, MonotonicClock monotonicClock, ClientSubscriptionManager clientSubscriptionManager, SyncPayloadCallback<RESPONSE, PAYLOAD> syncPayloadCallback) {
            this.f14523b = syncPayloadMqttResponseProcessorFactory;
            super(str, fbBroadcastManager, monotonicClock, clientSubscriptionManager);
            this.f14525d = syncPayloadCallback;
        }

        protected final void m18426a(String str, byte[] bArr) {
            try {
                this.f14524c = this.f14525d.m18423a(bArr, MqttThriftHeaderDeserialization.m18432a(bArr).f14532b);
            } catch (TException e) {
                Throwables.propagate(e);
            }
        }

        protected final boolean m18427a() {
            return this.f14525d.m18424a(this.f14524c);
        }

        protected final RESPONSE m18428b() {
            return this.f14525d.m18425b(this.f14524c);
        }
    }

    public static com.facebook.sync.methods.SyncPayloadMqttResponseProcessorFactory m18429a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14526e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sync.methods.SyncPayloadMqttResponseProcessorFactory.class;
        monitor-enter(r1);
        r0 = f14526e;	 Catch:{ all -> 0x003a }
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
        r0 = m18430b(r0);	 Catch:{ all -> 0x0035 }
        f14526e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14526e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.methods.SyncPayloadMqttResponseProcessorFactory.a(com.facebook.inject.InjectorLike):com.facebook.sync.methods.SyncPayloadMqttResponseProcessorFactory");
    }

    private static SyncPayloadMqttResponseProcessorFactory m18430b(InjectorLike injectorLike) {
        return new SyncPayloadMqttResponseProcessorFactory((BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), ClientSubscriptionManager.a(injectorLike), MqttThriftHeaderDeserialization.m18434a(injectorLike));
    }

    @Inject
    public SyncPayloadMqttResponseProcessorFactory(BaseFbBroadcastManager baseFbBroadcastManager, MonotonicClock monotonicClock, ClientSubscriptionManager clientSubscriptionManager, MqttThriftHeaderDeserialization mqttThriftHeaderDeserialization) {
        this.f14527a = baseFbBroadcastManager;
        this.f14528b = monotonicClock;
        this.f14529c = clientSubscriptionManager;
        this.f14530d = mqttThriftHeaderDeserialization;
    }

    public final <RESPONSE, PAYLOAD> MqttResponseProcessor<RESPONSE> m18431a(String str, SyncPayloadCallback<RESPONSE, PAYLOAD> syncPayloadCallback) {
        return new SyncPayloadMqttResponseProcessor(this, str, this.f14527a, this.f14528b, this.f14529c, syncPayloadCallback);
    }
}
