package com.facebook.messaging.media.upload.udp;

import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.background.MessagesLocalTaskTag;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.lang.annotation.Annotation;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: favorite_contacts */
public class UDPReceivingBackgroundTask extends AbstractBackgroundTask {
    private static volatile UDPReceivingBackgroundTask f12208g;
    public final BlockingByteBufferQueue f12209a;
    public final Clock f12210b;
    private final ListeningExecutorService f12211c;
    public final List<ServerMessageNotificationListener> f12212d = new ArrayList();
    private final Product f12213e;
    public DatagramSocket f12214f;

    public static com.facebook.messaging.media.upload.udp.UDPReceivingBackgroundTask m12873a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12208g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.udp.UDPReceivingBackgroundTask.class;
        monitor-enter(r1);
        r0 = f12208g;	 Catch:{ all -> 0x003a }
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
        r0 = m12874b(r0);	 Catch:{ all -> 0x0035 }
        f12208g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12208g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.udp.UDPReceivingBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.udp.UDPReceivingBackgroundTask");
    }

    private static UDPReceivingBackgroundTask m12874b(InjectorLike injectorLike) {
        return new UDPReceivingBackgroundTask(BlockingByteBufferQueue_UDPIncomingPacketQueueMethodAutoProvider.m12880a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public UDPReceivingBackgroundTask(BlockingByteBufferQueue blockingByteBufferQueue, Clock clock, ListeningExecutorService listeningExecutorService, Product product) {
        super("udp_receiving_task");
        this.f12209a = blockingByteBufferQueue;
        this.f12210b = clock;
        this.f12211c = listeningExecutorService;
        this.f12213e = product;
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(MessagesLocalTaskTag.class);
    }

    public final long mo593f() {
        return -1;
    }

    public final Set<Prerequisite> mo594h() {
        return ImmutableSet.of(Prerequisite.NETWORK_CONNECTIVITY);
    }

    public final boolean mo595i() {
        return this.f12213e == Product.MESSENGER && this.f12214f != null;
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        return this.f12211c.a(new 1(this));
    }
}
