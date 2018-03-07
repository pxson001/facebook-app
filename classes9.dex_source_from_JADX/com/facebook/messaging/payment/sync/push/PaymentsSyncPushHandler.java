package com.facebook.messaging.payment.sync.push;

import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.DbPaymentsPropertyUtil;
import com.facebook.sync.analytics.SyncDebugOverlayController;
import com.facebook.sync.analytics.SyncErrorReporter;
import com.facebook.sync.model.MqttThriftHeaderDeserialization;
import com.facebook.sync.model.ThriftDeserializationUtil;
import com.facebook.sync.service.SyncOperationParamsUtil;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetchEventRemindersMembersParams */
public class PaymentsSyncPushHandler {
    private static final Class<?> f14919a = PaymentsSyncPushHandler.class;
    private static volatile PaymentsSyncPushHandler f14920j;
    private final ThriftDeserializationUtil f14921b;
    private final MqttThriftHeaderDeserialization f14922c;
    private final Provider<Boolean> f14923d;
    private final DefaultBlueServiceOperationFactory f14924e;
    private final SyncDebugOverlayController f14925f;
    private final SyncOperationParamsUtil f14926g;
    private final DbPaymentsPropertyUtil f14927h;
    private final SyncErrorReporter f14928i;

    public static com.facebook.messaging.payment.sync.push.PaymentsSyncPushHandler m15322a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14920j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.sync.push.PaymentsSyncPushHandler.class;
        monitor-enter(r1);
        r0 = f14920j;	 Catch:{ all -> 0x003a }
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
        r0 = m15323b(r0);	 Catch:{ all -> 0x0035 }
        f14920j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14920j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.push.PaymentsSyncPushHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.push.PaymentsSyncPushHandler");
    }

    private static PaymentsSyncPushHandler m15323b(InjectorLike injectorLike) {
        return new PaymentsSyncPushHandler(ThriftDeserializationUtil.a(injectorLike), MqttThriftHeaderDeserialization.a(injectorLike), IdBasedProvider.a(injectorLike, 4184), DefaultBlueServiceOperationFactory.b(injectorLike), SyncDebugOverlayController.a(injectorLike), SyncOperationParamsUtil.a(injectorLike), DbPaymentsPropertyUtil.m13206a(injectorLike), SyncErrorReporter.a(injectorLike));
    }

    @Inject
    public PaymentsSyncPushHandler(ThriftDeserializationUtil thriftDeserializationUtil, MqttThriftHeaderDeserialization mqttThriftHeaderDeserialization, Provider<Boolean> provider, BlueServiceOperationFactory blueServiceOperationFactory, SyncDebugOverlayController syncDebugOverlayController, SyncOperationParamsUtil syncOperationParamsUtil, DbPaymentsPropertyUtil dbPaymentsPropertyUtil, SyncErrorReporter syncErrorReporter) {
        this.f14921b = thriftDeserializationUtil;
        this.f14922c = mqttThriftHeaderDeserialization;
        this.f14923d = provider;
        this.f14924e = blueServiceOperationFactory;
        this.f14925f = syncDebugOverlayController;
        this.f14926g = syncOperationParamsUtil;
        this.f14927h = dbPaymentsPropertyUtil;
        this.f14928i = syncErrorReporter;
    }
}
