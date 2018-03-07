package com.facebook.messaging.sync.push;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbtrace.FbTracer;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.database.threads.DbThreadsPropertyUtil;
import com.facebook.messaging.sync.MessagesSyncOperationContextSupplier;
import com.facebook.messaging.sync.delta.MessagesDeltaHandlerSupplier;
import com.facebook.messaging.sync.delta.MessagesDeltaNoOpSniffer;
import com.facebook.sync.analytics.SyncDebugOverlayController;
import com.facebook.sync.analytics.SyncErrorReporter;
import com.facebook.sync.connection.SyncConnectionStateManager;
import com.facebook.sync.delta.DeltasWithSequenceIdsFactory;
import com.facebook.sync.model.MqttThriftHeaderDeserialization;
import com.facebook.sync.model.ThriftDeserializationUtil;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: preloadMarkup */
public class MessagesSyncPushHandler {
    private static final Class<?> f4644a = MessagesSyncPushHandler.class;
    private static volatile MessagesSyncPushHandler f4645r;
    private final Provider<DbThreadsPropertyUtil> f4646b;
    private final ThriftDeserializationUtil f4647c;
    private final MqttThriftHeaderDeserialization f4648d;
    private final DefaultBlueServiceOperationFactory f4649e;
    private final SyncDebugOverlayController f4650f;
    private final Provider<Boolean> f4651g;
    private final SyncConnectionStateManager f4652h;
    private final SyncErrorReporter f4653i;
    private final MessagesDeltaNoOpSniffer f4654j;
    private final DeltasWithSequenceIdsFactory f4655k;
    private final Provider<MessagesDeltaHandlerSupplier> f4656l;
    private final MessagesBroadcaster f4657m;
    private final Executor f4658n;
    private final FbTracer f4659o;
    private final DbClock f4660p;
    private final MessagesSyncOperationContextSupplier f4661q;

    public static com.facebook.messaging.sync.push.MessagesSyncPushHandler m4214a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4645r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sync.push.MessagesSyncPushHandler.class;
        monitor-enter(r1);
        r0 = f4645r;	 Catch:{ all -> 0x003a }
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
        r0 = m4215b(r0);	 Catch:{ all -> 0x0035 }
        f4645r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4645r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.push.MessagesSyncPushHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.push.MessagesSyncPushHandler");
    }

    private static MessagesSyncPushHandler m4215b(InjectorLike injectorLike) {
        return new MessagesSyncPushHandler(IdBasedProvider.a(injectorLike, 7808), ThriftDeserializationUtil.a(injectorLike), MqttThriftHeaderDeserialization.a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), SyncDebugOverlayController.a(injectorLike), IdBasedProvider.a(injectorLike, 4075), SyncConnectionStateManager.a(injectorLike), SyncErrorReporter.a(injectorLike), MessagesDeltaNoOpSniffer.m3979a(injectorLike), DeltasWithSequenceIdsFactory.a(injectorLike), IdBasedProvider.a(injectorLike, 8499), MessagesBroadcaster.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), FbTracer.a(injectorLike), DbClock.a(injectorLike), MessagesSyncOperationContextSupplier.m3898a(injectorLike));
    }

    @Inject
    public MessagesSyncPushHandler(Provider<DbThreadsPropertyUtil> provider, ThriftDeserializationUtil thriftDeserializationUtil, MqttThriftHeaderDeserialization mqttThriftHeaderDeserialization, BlueServiceOperationFactory blueServiceOperationFactory, SyncDebugOverlayController syncDebugOverlayController, Provider<Boolean> provider2, SyncConnectionStateManager syncConnectionStateManager, SyncErrorReporter syncErrorReporter, MessagesDeltaNoOpSniffer messagesDeltaNoOpSniffer, DeltasWithSequenceIdsFactory deltasWithSequenceIdsFactory, Provider<MessagesDeltaHandlerSupplier> provider3, MessagesBroadcaster messagesBroadcaster, Executor executor, FbTracer fbTracer, DbClock dbClock, SyncOperationContextSupplier syncOperationContextSupplier) {
        this.f4646b = provider;
        this.f4647c = thriftDeserializationUtil;
        this.f4648d = mqttThriftHeaderDeserialization;
        this.f4649e = blueServiceOperationFactory;
        this.f4650f = syncDebugOverlayController;
        this.f4651g = provider2;
        this.f4652h = syncConnectionStateManager;
        this.f4653i = syncErrorReporter;
        this.f4654j = messagesDeltaNoOpSniffer;
        this.f4655k = deltasWithSequenceIdsFactory;
        this.f4656l = provider3;
        this.f4657m = messagesBroadcaster;
        this.f4658n = executor;
        this.f4659o = fbTracer;
        this.f4660p = dbClock;
        this.f4661q = syncOperationContextSupplier;
    }
}
