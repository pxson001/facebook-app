package com.facebook.messaging.sync.connection;

import android.content.Context;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.graphql.threads.ThreadQueries;
import com.facebook.messaging.notificationpolicy.NotificationPolicyEngine;
import com.facebook.messaging.photos.size.MediaSizeUtil;
import com.facebook.messaging.sync.model.thrift.SyncPayload;
import com.facebook.push.mqtt.service.MqttPushServiceClientManager;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import com.facebook.sync.connection.SyncDeviceParamsFactory;
import com.facebook.sync.connection.SyncMqttPublisher;
import com.facebook.sync.connection.SyncMqttPublisher.CreateQueueResult;
import com.facebook.sync.methods.SyncPayloadMqttResponseProcessorFactory;
import com.facebook.sync.methods.SyncPayloadMqttResponseProcessorFactory.SyncPayloadCallback;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.sync.model.ThriftDeserializationUtil;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: promo_text */
public class MessagesSyncMqttPublisher extends SyncMqttPublisher {
    private static final Class<?> f4318a = MessagesSyncMqttPublisher.class;
    private static volatile MessagesSyncMqttPublisher f4319i;
    private final ThriftDeserializationUtil f4320b;
    public final SyncPayloadMqttResponseProcessorFactory f4321c;
    public final MediaSizeUtil f4322d;
    public final Provider<Integer> f4323e;
    public final Provider<Boolean> f4324f;
    private final Provider<NotificationPolicyEngine> f4325g;
    private boolean f4326h = false;

    /* compiled from: promo_text */
    public class C06491 implements SyncPayloadCallback<CreateQueueResult, SyncPayload> {
        final /* synthetic */ MessagesSyncMqttPublisher f4317a;

        public C06491(MessagesSyncMqttPublisher messagesSyncMqttPublisher) {
            this.f4317a = messagesSyncMqttPublisher;
        }

        public final boolean m3921a(Object obj) {
            SyncPayload syncPayload = (SyncPayload) obj;
            return (syncPayload.syncToken == null && syncPayload.errorCode == null) ? false : true;
        }

        public final Object m3922b(Object obj) {
            SyncPayload syncPayload = (SyncPayload) obj;
            if (syncPayload.syncToken != null) {
                return CreateQueueResult.a(syncPayload.syncToken);
            }
            return CreateQueueResult.b(syncPayload.errorCode);
        }

        public final Object m3920a(byte[] bArr, int i) {
            return SyncPayload.b(ThriftDeserializationUtil.a(bArr, i));
        }
    }

    public static com.facebook.messaging.sync.connection.MessagesSyncMqttPublisher m3923a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4319i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sync.connection.MessagesSyncMqttPublisher.class;
        monitor-enter(r1);
        r0 = f4319i;	 Catch:{ all -> 0x003a }
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
        r0 = m3924b(r0);	 Catch:{ all -> 0x0035 }
        f4319i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4319i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.connection.MessagesSyncMqttPublisher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.connection.MessagesSyncMqttPublisher");
    }

    private static MessagesSyncMqttPublisher m3924b(InjectorLike injectorLike) {
        return new MessagesSyncMqttPublisher((Context) injectorLike.getInstance(Context.class), MqttPushServiceClientManagerImpl.a(injectorLike), SyncDeviceParamsFactory.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedProvider.a(injectorLike, 4212), ThriftDeserializationUtil.a(injectorLike), SyncPayloadMqttResponseProcessorFactory.a(injectorLike), MediaSizeUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4419), IdBasedProvider.a(injectorLike, 4345), IdBasedProvider.a(injectorLike, 4347), IdBasedProvider.a(injectorLike, 8005));
    }

    @Inject
    public MessagesSyncMqttPublisher(Context context, MqttPushServiceClientManager mqttPushServiceClientManager, SyncDeviceParamsFactory syncDeviceParamsFactory, Lazy<FbErrorReporter> lazy, Provider<Boolean> provider, ThriftDeserializationUtil thriftDeserializationUtil, SyncPayloadMqttResponseProcessorFactory syncPayloadMqttResponseProcessorFactory, MediaSizeUtil mediaSizeUtil, Provider<Integer> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<NotificationPolicyEngine> provider5) {
        super(context, mqttPushServiceClientManager, syncDeviceParamsFactory, lazy, provider3, provider4);
        this.f4320b = thriftDeserializationUtil;
        this.f4321c = syncPayloadMqttResponseProcessorFactory;
        this.f4322d = mediaSizeUtil;
        this.f4323e = provider2;
        this.f4324f = provider;
        this.f4325g = provider5;
    }

    public final IrisQueueTypes m3926a() {
        return IrisQueueTypes.MESSAGES_QUEUE_TYPE;
    }

    public final int m3928b() {
        return ((Integer) this.f4323e.get()).intValue();
    }

    protected final void m3931d() {
        this.f4326h = false;
    }

    protected final void m3927a(ObjectNode objectNode) {
    }

    protected final void m3929b(ObjectNode objectNode) {
        m3925d(objectNode);
    }

    protected final void m3930c(ObjectNode objectNode) {
        if (!this.f4326h) {
            m3925d(objectNode);
        }
    }

    protected final void m3932f() {
        this.f4326h = true;
    }

    private void m3925d(ObjectNode objectNode) {
        ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
        objectNode2.a("buzz_on_deltas_enabled", Boolean.valueOf(((NotificationPolicyEngine) this.f4325g.get()).m3316a()).toString());
        if (((Boolean) this.f4324f.get()).booleanValue()) {
            ObjectNode objectNode3 = new ObjectNode(JsonNodeFactory.a);
            objectNode3.a("xma_query_id", ThreadQueries.h().d);
            ObjectNode objectNode4 = new ObjectNode(JsonNodeFactory.a);
            ObjectNode objectNode5 = new ObjectNode(JsonNodeFactory.a);
            objectNode5.a("xma_id", "<ID>");
            objectNode5.a("small_preview_size", this.f4322d.k());
            objectNode5.a("large_preview_size", this.f4322d.i());
            objectNode4.c(ThreadQueries.h().d, objectNode5);
            objectNode2.c("graphql_query_hashes", objectNode3);
            objectNode2.c("graphql_query_params", objectNode4);
        }
        objectNode.c("queue_params", objectNode2);
    }
}
