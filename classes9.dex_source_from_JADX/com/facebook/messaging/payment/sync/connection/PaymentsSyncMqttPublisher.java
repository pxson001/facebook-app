package com.facebook.messaging.payment.sync.connection;

import android.content.Context;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.payment.sync.Integer_PaymentsSyncApiVersionMethodAutoProvider;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.messaging.paymentsync.model.thrift.PaymentSyncPayload;
import com.facebook.push.mqtt.service.MqttPushServiceClientManager;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import com.facebook.push.mqtt.service.response.MqttResponse;
import com.facebook.sync.connection.SyncDeviceParamsFactory;
import com.facebook.sync.connection.SyncMqttPublisher;
import com.facebook.sync.connection.SyncMqttPublisher.CreateQueueResult;
import com.facebook.sync.methods.SyncPayloadMqttResponseProcessorFactory;
import com.facebook.sync.methods.SyncPayloadMqttResponseProcessorFactory.SyncPayloadCallback;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.sync.model.ThriftDeserializationUtil;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetchMoreThreads (GQL) */
public class PaymentsSyncMqttPublisher extends SyncMqttPublisher {
    private static volatile PaymentsSyncMqttPublisher f14827d;
    private final SyncPayloadMqttResponseProcessorFactory f14828a;
    private final ThriftDeserializationUtil f14829b;
    private final Integer f14830c;

    /* compiled from: fetchMoreThreads (GQL) */
    class C17161 implements SyncPayloadCallback<CreateQueueResult, PaymentSyncPayload> {
        final /* synthetic */ PaymentsSyncMqttPublisher f14826a;

        C17161(PaymentsSyncMqttPublisher paymentsSyncMqttPublisher) {
            this.f14826a = paymentsSyncMqttPublisher;
        }

        public final boolean m15248a(Object obj) {
            PaymentSyncPayload paymentSyncPayload = (PaymentSyncPayload) obj;
            return (paymentSyncPayload.syncToken == null && paymentSyncPayload.errorCode == null) ? false : true;
        }

        public final Object m15249b(Object obj) {
            PaymentSyncPayload paymentSyncPayload = (PaymentSyncPayload) obj;
            if (paymentSyncPayload.syncToken != null) {
                return CreateQueueResult.a(paymentSyncPayload.syncToken);
            }
            return CreateQueueResult.b(paymentSyncPayload.errorCode);
        }

        public final Object m15247a(byte[] bArr, int i) {
            TProtocol a = ThriftDeserializationUtil.a(bArr, i);
            String str = null;
            a.r();
            String str2 = null;
            Long l = null;
            Long l2 = null;
            Long l3 = null;
            List list = null;
            while (true) {
                TField f = a.f();
                if (f.b != (byte) 0) {
                    switch (f.c) {
                        case (short) 1:
                            if (f.b != (byte) 15) {
                                TProtocolUtil.a(a, f.b);
                                break;
                            }
                            TList h = a.h();
                            list = new ArrayList(Math.max(0, h.b));
                            int i2 = 0;
                            while (true) {
                                if (h.b >= 0) {
                                    if (i2 >= h.b) {
                                        break;
                                    }
                                } else if (!TProtocol.t()) {
                                    break;
                                }
                                list.add(DeltaPaymentWrapper.m16082b(a));
                                i2++;
                            }
                        case (short) 2:
                            if (f.b != (byte) 10) {
                                TProtocolUtil.a(a, f.b);
                                break;
                            }
                            l3 = Long.valueOf(a.n());
                            break;
                        case (short) 3:
                            if (f.b != (byte) 10) {
                                TProtocolUtil.a(a, f.b);
                                break;
                            }
                            l2 = Long.valueOf(a.n());
                            break;
                        case (short) 4:
                            if (f.b != (byte) 10) {
                                TProtocolUtil.a(a, f.b);
                                break;
                            }
                            l = Long.valueOf(a.n());
                            break;
                        case (short) 11:
                            if (f.b != (byte) 11) {
                                TProtocolUtil.a(a, f.b);
                                break;
                            }
                            str2 = a.p();
                            break;
                        case (short) 12:
                            if (f.b != (byte) 11) {
                                TProtocolUtil.a(a, f.b);
                                break;
                            }
                            str = a.p();
                            break;
                        default:
                            TProtocolUtil.a(a, f.b);
                            break;
                    }
                }
                a.e();
                return new PaymentSyncPayload(list, l3, l2, l, str2, str);
            }
        }
    }

    public static com.facebook.messaging.payment.sync.connection.PaymentsSyncMqttPublisher m15250a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14827d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.sync.connection.PaymentsSyncMqttPublisher.class;
        monitor-enter(r1);
        r0 = f14827d;	 Catch:{ all -> 0x003a }
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
        r0 = m15251b(r0);	 Catch:{ all -> 0x0035 }
        f14827d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14827d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.connection.PaymentsSyncMqttPublisher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.connection.PaymentsSyncMqttPublisher");
    }

    private static PaymentsSyncMqttPublisher m15251b(InjectorLike injectorLike) {
        return new PaymentsSyncMqttPublisher((Context) injectorLike.getInstance(Context.class), MqttPushServiceClientManagerImpl.a(injectorLike), SyncDeviceParamsFactory.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), SyncPayloadMqttResponseProcessorFactory.a(injectorLike), ThriftDeserializationUtil.a(injectorLike), Integer_PaymentsSyncApiVersionMethodAutoProvider.m15224b(injectorLike), IdBasedProvider.a(injectorLike, 4345), IdBasedProvider.a(injectorLike, 4347));
    }

    @Inject
    public PaymentsSyncMqttPublisher(Context context, MqttPushServiceClientManager mqttPushServiceClientManager, SyncDeviceParamsFactory syncDeviceParamsFactory, Lazy<FbErrorReporter> lazy, SyncPayloadMqttResponseProcessorFactory syncPayloadMqttResponseProcessorFactory, ThriftDeserializationUtil thriftDeserializationUtil, Integer num, Provider<Boolean> provider, Provider<Boolean> provider2) {
        super(context, mqttPushServiceClientManager, syncDeviceParamsFactory, lazy, provider, provider2);
        this.f14828a = syncPayloadMqttResponseProcessorFactory;
        this.f14829b = thriftDeserializationUtil;
        this.f14830c = num;
    }

    public final IrisQueueTypes m15253a() {
        return IrisQueueTypes.PAYMENTS_QUEUE_TYPE;
    }

    public final int m15254b() {
        return this.f14830c.intValue();
    }

    public final MqttResponse<CreateQueueResult> m15252a(long j, String str) {
        C17161 c17161 = new C17161(this);
        return a(this.f14830c.intValue(), j, this.f14828a.a("/t_ps", c17161), str);
    }
}
